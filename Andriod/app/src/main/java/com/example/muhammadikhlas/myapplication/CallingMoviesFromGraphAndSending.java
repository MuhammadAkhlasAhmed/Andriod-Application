package com.example.muhammadikhlas.myapplication;

import com.facebook.AccessToken;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Muhammad IKHLAS on 10/1/2017.
 */
public class CallingMoviesFromGraphAndSending extends AsyncTask<Void, Void, Void> {

    public FirebaseDatabase db;
    public int a;
    public JSONArray data;
    private DatabaseReference mDatabase;
    public ArrayList<String> as = new ArrayList<String>();

    @Override
    protected Void doInBackground(Void... voids) {
        GraphRequest request = GraphRequest.newGraphPathRequest(
                AccessToken.getCurrentAccessToken(),
                "/me/video.watches",
                new GraphRequest.Callback() {
                    @Override
                    public void onCompleted(GraphResponse response) {
                        if (response != null) {
                            try {
                                String in = response.getRawResponse();
                                //Log.d("MoviesResponce", in);
                                int i = 0;
                                Pattern p = Pattern.compile("video.movie");
                                Matcher m = p.matcher(in);
                                while (m.find()) {
                                    i++;
                                }
                                JSONObject jobj = new JSONObject(response.getRawResponse());
                                data = jobj.getJSONArray("data");
                                JSONObject jboj1 = new JSONObject();
                                for (int k = 0; k < i - 1; k++) {
                                    String moviename = (String) data.getJSONObject(k).getJSONObject("data").getJSONObject("movie").get("title");
                                    //Log.d("Json", "" + moviename);
                                    as.add(k, moviename); //ading to my list so then we send it to FIREBASE AT LAST
                                }
                                mDatabase = FirebaseDatabase.getInstance().getReference();
                                DatabaseReference mRef = mDatabase.getRef();
                                mRef.push().setValue(as);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        } else {
                            //Log.d("Hello", "ERROR");

                        }
                    }

                });
        Bundle parameters = new Bundle();
        parameters.putString("limit", "20");
        request.setParameters(parameters);
        request.executeAsync();
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }
}
