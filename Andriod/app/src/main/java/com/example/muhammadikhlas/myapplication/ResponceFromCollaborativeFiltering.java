package com.example.muhammadikhlas.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

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

/**
 * Created by Muhammad IKHLAS on 1/14/2018.
 */

public class ResponceFromCollaborativeFiltering extends AsyncTask<String,Void,String> {

    List<String> ar;
    Context context;
    public ResponceFromCollaborativeFiltering(Context context) {
        this.context = context.getApplicationContext();
    }


    HttpURLConnection urlConnection = null;
    URL url = null;
    JSONObject object = null;
    InputStream inStream = null;
    String   urlString="http://10.0.2.2:8081/api/v1/";
    String temp, response = "";
    String mname;
    ArrayList<String> Linkss;
    ArrayList<String> Movies;
    String Count;




    @Override
    protected String doInBackground(String... strings) {



        try {
            Log.d("Starting fetching","Nihal wali service");
            String x=strings[0].toString();
            mname=x;
            url = new URL((urlString.toString()+x).replace(" ","%20"));
            Log.d("chking",url.toString());
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            inStream = urlConnection.getInputStream();
            BufferedReader bReader = new BufferedReader(new InputStreamReader(inStream));

            while ((temp = bReader.readLine()) != null) {
                response += temp;
            }



        } catch (Exception e) {
            Log.d("Exception",""+e.toString());
        }


        return response;
    }


    @Override
    protected void onPostExecute(String x) {

        Log.d("FINAL RES",x);

ar=new ArrayList<String>();



        try {

            JSONObject jsonObj = new JSONObject(x);
            JSONArray CollaborativeList = jsonObj.getJSONArray("listOfMovies");
            JSONArray Links = jsonObj.getJSONArray("onlineAndDownloadLinks");
            String X=jsonObj.getString("firebaseMovieCount");

            Linkss=new ArrayList<String>();
            Movies=new ArrayList<String>();


        for(int i=0;i<Links.length();i++){

            Linkss.add(Links.getString(i).toString());

        }

            for(int i=0;i<CollaborativeList.length();i++){

                Movies.add(CollaborativeList.getString(i).toString());

            }


            Count=X;




        } catch (JSONException e) {
            e.printStackTrace();
        }





        Intent ais=new Intent(context,ResponceFromColaborativeActivity.class);
        ais.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        ais.putExtra("Name",mname);
        ais.putExtra("Movies",(Serializable)Movies);
        ais.putExtra("Links",(Serializable)Linkss);
        ais.putExtra("Count",Count);




        context.startActivity(ais);





    }






}









