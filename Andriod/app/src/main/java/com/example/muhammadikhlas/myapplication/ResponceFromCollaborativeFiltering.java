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
    String   urlString="http://192.168.212.2:8081/api/v1/";
    String temp, response = "";
    String mname;





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
            //object = (JSONObject) new JSONTokener(response).nextValue();


        } catch (Exception e) {
            Log.d("Exception",""+e.toString());
        }


        return response;
    }


    @Override
    protected void onPostExecute(String x) {

ar=new ArrayList<String>();
        //
//
       // Log.d("ResponceofCol",x.toString());
        try {
            JSONArray array =new JSONArray(x);


            for(int i=0;i<array.length();i++){

                ar.add(array.getString(i));

            }



        } catch (JSONException e) {
            e.printStackTrace();
        }

        Intent ais=new Intent(context,ResponceFromColaborativeActivity.class);
        ais.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        ais.putExtra("Name",mname);

        ais.putExtra("LIST",(Serializable)ar);

//     ais.putExtra("LIST",(Serializable)movie);
//
        context.startActivity(ais);
//
//
//
//
//
//
//
//
//
        //



        //   context.startActivity(new Intent(context, ListOfMoviesByWebMatrixActivity.class));


        //  i.putExtra("Name",""+txt1.getText().toString());

    }






}









