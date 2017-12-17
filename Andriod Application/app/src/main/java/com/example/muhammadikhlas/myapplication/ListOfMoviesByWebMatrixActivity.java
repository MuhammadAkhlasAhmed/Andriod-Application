package com.example.muhammadikhlas.myapplication;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.net.URL;

public class ListOfMoviesByWebMatrixActivity extends Activity {

    String responseText;
    StringBuffer response;
    URL url;
    Activity activity;
    private ProgressDialog progressDialog;
    ListView listView;
    StringBuffer responce;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listofmoviesbywebmatrixactivity);
        activity = this;
String name[]=new String[]{"Ikhlas","Ahmed","Nihal","Ahsan"};
        ArrayAdapter<String> adpt=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,
                name);


        listView = (ListView) findViewById(android.R.id.list);
                //Call WebService
listView.setAdapter(adpt);



        String path = "http://192.168.0.106:8080/api/v1/imdb/Inception";

        URL url;
        String Responcetext;




















    }











}
