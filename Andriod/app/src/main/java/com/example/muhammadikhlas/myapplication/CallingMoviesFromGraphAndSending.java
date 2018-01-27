package com.example.muhammadikhlas.myapplication;

/**
 * Created by Muhammad IKHLAS on 10/1/2017.
 */

import com.facebook.AccessToken;

import com.facebook.FacebookSdk;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.HttpMethod;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CallingMoviesFromGraphAndSending extends AsyncTask<Void,Void,Void> {

FirebaseDatabase db;
    int a;
    JSONArray data;
    private DatabaseReference mDatabase;


    ArrayList<String> as=new ArrayList<String>();
    @Override
    protected Void doInBackground(Void... voids) {


        GraphRequest request = GraphRequest.newGraphPathRequest(
                AccessToken.getCurrentAccessToken(),
                "/me/video.watches",
        new GraphRequest.Callback() {
                    @Override
                    public void onCompleted(GraphResponse response) {
                        if(response!=null){

                           try {


                               String in = response.getRawResponse();
                               Log.d("MoviesResponce",in);
                               int i = 0;
                               Pattern p = Pattern.compile("video.movie");
                               Matcher m = p.matcher( in );
                               while (m.find()) {
                                   i++;
                               }
Log.d("total movie",""+i);

                                JSONObject jobj = new JSONObject(response.getRawResponse());
                               data=jobj.getJSONArray("data");
                               JSONObject jboj1=new JSONObject();

                              for(int k=0;k<i-1;k++) {
                                  String moviename=(String)data.getJSONObject(k).getJSONObject("data").getJSONObject("movie").get("title");
                                  Log.d("Json", "" +moviename);
                                as.add(k,moviename); //ading to my list so then we send it to FIREBASE AT LAST

                              }
Log.d("checking list",""+as.get(0));

                               mDatabase = FirebaseDatabase.getInstance().getReference();
                               DatabaseReference mRef = mDatabase.getRef();

                               mRef.push().setValue(as);
Log.d("Nahi Jarae","xx");











  //      for(int k=0;k<data.length();k++)

    //    {

//            Log.d("Values",""+data.getJSONObject(k).getJSONObject("data").getJSONObject("movie").get("title"));


                                                                }
//                                }

                            catch (JSONException e) {
                                e.printStackTrace();
                            }


/*
                            for(int k=0;k<=a;k++){
                                try {

                            as.add(k,data.getJSONObject(k).getJSONObject("data").getJSONObject("movie").get("title"));
                                        }}

                                catch (JSONException e) {
                                    e.printStackTrace();}
*/

                            }








                        else
                        {
                            Log.d("Hello","ERROR");

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


        Log.d("ONPOST","Yes its working Ikhlas oMG.");
    }
}
