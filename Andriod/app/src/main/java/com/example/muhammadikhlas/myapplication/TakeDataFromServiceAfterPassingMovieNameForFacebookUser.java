package com.example.muhammadikhlas.myapplication;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static com.facebook.FacebookSdk.getApplicationContext;

/**
 * Created by ahayat on 12-Feb-18.
 */

public class TakeDataFromServiceAfterPassingMovieNameForFacebookUser extends AsyncTask<String,Void,String> {

    // public AsyncResponse delegate = null;
    public List<MoviePojo> movie=new ArrayList<MoviePojo>();
    public HttpURLConnection urlConnection = null;
    public URL url = null;
    public JSONObject object = null;
    public InputStream inStream = null;
    public String   urlString="http://192.168.1.104:8080/api/v1/movie/";
    public String temp, response = "";
    private ProgressDialog progressDialog;

    public TakeDataFromServiceAfterPassingMovieNameForFacebookUser(){

    }

    public Context context;
    public TakeDataFromServiceAfterPassingMovieNameForFacebookUser(Context context) {
        this.context = context.getApplicationContext();
    }

    @Override
    protected String doInBackground(String... strings) {
        try {
            //Log.d("Starting fetching","Nihal wali service");
            url = new URL((urlString.toString()+strings[0]).replace(" ","%20"));
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            inStream = urlConnection.getInputStream();
            BufferedReader bReader = new BufferedReader(new InputStreamReader(inStream));
            while ((temp = bReader.readLine()) != null) {
                response += temp;
            }
            //object = (JSONObject) new JSONTokener(response).nextValue();
        } catch (Exception e) {
            //Log.d("Exception",""+e.toString());
        }
        return response;
    }

    @Override
    protected void onPostExecute(String x) {
        if (x == "") {
            Toast.makeText(getApplicationContext(), "Movie Name Not Found !", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(context,LogoutActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            context.startActivity(intent);
        }
        try {
            JSONArray a=new JSONArray(x);
            for(int i=0;i<a.length();i++) {
                JSONObject obj=a.getJSONObject(i);
                MoviePojo movieslist=new MoviePojo(obj.getString("rating"),obj.getString("tagline"),obj.getString("name"));
                movie.add(movieslist);
                //Log.d("Size of List ", String.valueOf(movie.size()));
            }
            //        delegate.processFinish(movie);
            Intent ais=new Intent(context,ListOfMoviesByWebMatrixActivity.class);
            ais.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            ais.putExtra("LIST",(Serializable)movie);
            context.startActivity(ais);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //   context.startActivity(new Intent(context, ListOfMoviesByWebMatrixActivity.class));
        //  i.putExtra("Name",""+txt1.getText().toString());
    }
}
