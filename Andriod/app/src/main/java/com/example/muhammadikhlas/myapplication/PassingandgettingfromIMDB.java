package com.example.muhammadikhlas.myapplication;

import com.loopj.android.http.AsyncHttpClient;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by Muhammad IKHLAS on 12/1/2017.
 */



public class PassingandgettingfromIMDB extends AsyncTask<String,Void,String>  {
    HttpURLConnection urlConnection = null;
    URL url = null;
    JSONObject object = null;
    InputStream inStream = null;
    String   urlString="http://192.168.0.112:8080/api/v1/movie/";
    String temp, response = "";






    Context context;
    public PassingandgettingfromIMDB(Context context) {
        this.context = context;
    }



    @Override
    protected String doInBackground(String... strings) {



        try {
            Log.d("Starting fetching","Nihal wali service");
            url = new URL(urlString.toString()+strings[0]);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            inStream = urlConnection.getInputStream();
            BufferedReader bReader = new BufferedReader(new InputStreamReader(inStream));

            while ((temp = bReader.readLine()) != null) {
                response += temp;
            }
            //object = (JSONObject) new JSONTokener(response).nextValue();
            Log.d("Theres",response);

        } catch (Exception e) {
            Log.d("Exception",""+e.toString());
        }







        Log.d("Chal rae","hai");





        return response;
    }


    @Override
    protected void onPostExecute(String result) {
Log.d("Here is",""+result);
     //   context.startActivity(new Intent(context, ListOfMoviesByWebMatrixActivity.class));


      //  i.putExtra("Name",""+txt1.getText().toString());

    }




}

