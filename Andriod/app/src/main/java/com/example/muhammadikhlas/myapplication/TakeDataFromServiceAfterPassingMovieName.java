package com.example.muhammadikhlas.myapplication;

import com.loopj.android.http.AsyncHttpClient;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by Muhammad IKHLAS on 12/1/2017.
 */



public class TakeDataFromServiceAfterPassingMovieName extends AsyncTask<String,Void,String>  {

    // public AsyncResponse delegate = null;

    List<MoviePojo>  movie=new ArrayList<MoviePojo>();

    HttpURLConnection urlConnection = null;
    URL url = null;
    JSONObject object = null;
    InputStream inStream = null;
    String   urlString="http://192.168.0.105:8080/api/v1/movie/";
    String temp, response = "";



    public TakeDataFromServiceAfterPassingMovieName(){

    }


    Context context;
    public TakeDataFromServiceAfterPassingMovieName(Context context) {
        this.context = context.getApplicationContext();
    }









    @Override
    protected String doInBackground(String... strings) {



        try {
            Log.d("Starting fetching","Nihal wali service");
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
            Log.d("Exception",""+e.toString());
        }


        return response;
    }


    @Override
    protected void onPostExecute(String x) {



        try {
            JSONArray a=new JSONArray(x);

            for(int i=0;i<a.length();i++) {
                JSONObject obj=a.getJSONObject(i);

                MoviePojo movieslist=new MoviePojo(obj.getString("rating"),obj.getString("tagline"),obj.getString("name"));

                movie.add(movieslist);


                Log.d("Size of List ", String.valueOf(movie.size()));

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

