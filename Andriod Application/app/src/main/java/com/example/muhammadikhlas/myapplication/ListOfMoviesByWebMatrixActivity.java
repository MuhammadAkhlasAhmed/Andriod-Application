package com.example.muhammadikhlas.myapplication;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
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


    int[] rating= new int[5];
    String[] moviename=new String[5];
    String[] tagline=new String[5];
    List<MoviePojo> rowItems;
    ListView mylistview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listofmoviesbywebmatrixactivity);
        activity = this;
rating[0]=1;
moviename[0]="Herculas";
        tagline[0]="A big man with meow";

        rowItems = new ArrayList<MoviePojo>();


            MoviePojo item = new MoviePojo(rating[0],tagline[0],moviename[0]);
            rowItems.add(item);

        mylistview = (ListView) findViewById(R.id.list);
        mylistview.setBackgroundColor(Color.BLACK);
        CustomAdapter adapter = new CustomAdapter(this, rowItems);
        mylistview.setAdapter(adapter);



















    }











}
