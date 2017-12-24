package com.example.muhammadikhlas.myapplication;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ListOfMoviesByWebMatrixActivity extends Activity {

    String responseText;
    StringBuffer response;
    URL url;
    Activity activity;
    private ProgressDialog progressDialog;
    ListView listView;
    StringBuffer responce;
String name;

    List<MoviePojo>   rowItems ;

    ListView mylistview;
    TakeDataFromServiceAfterPassingMovieName iop=new TakeDataFromServiceAfterPassingMovieName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.listofmoviesbywebmatrixactivity);

        //iop.delegate=this;

        rowItems = new ArrayList<MoviePojo>();

       Intent i=getIntent();
rowItems=(List<MoviePojo>) i.getSerializableExtra("LIST");

Log.d("NAME", String.valueOf(rowItems.size()));


        mylistview = (ListView) findViewById(R.id.list);
     //   mylistview.setBackgroundColor(Color.BLACK);
        CustomAdapter adapter = new CustomAdapter(this, rowItems);
        mylistview.setAdapter(adapter);





    }



}
