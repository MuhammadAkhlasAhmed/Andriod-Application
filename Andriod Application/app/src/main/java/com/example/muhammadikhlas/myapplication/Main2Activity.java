package com.example.muhammadikhlas.myapplication;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

import static android.content.ContentValues.TAG;

public class Main2Activity extends Activity {

    String responseText;
    StringBuffer response;
    URL url;
    Activity activity;
    private ProgressDialog progressDialog;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        activity = this;
        Intent a=getIntent();

   String Name=a.getExtras().getString("Name").toString();
        Toast.makeText(this,""+Name,Toast.LENGTH_LONG).show();
        listView = (ListView) findViewById(android.R.id.list);
                //Call WebService
PassingandgettingfromIMDB p=new PassingandgettingfromIMDB();


    }











}
