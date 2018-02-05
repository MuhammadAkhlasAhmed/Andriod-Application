package com.example.muhammadikhlas.myapplication;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
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


        rowItems = new ArrayList<MoviePojo>();

        Intent i=getIntent();
        rowItems=(List<MoviePojo>) i.getSerializableExtra("LIST");




        mylistview = (ListView) findViewById(R.id.list);

        CustomAdapter adapter = new CustomAdapter(this, rowItems);
        mylistview.setAdapter(adapter);


        mylistview.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {


                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        progressDialog = new ProgressDialog(ListOfMoviesByWebMatrixActivity.this);
                        progressDialog.setMessage("Loading, please wait...");
                        progressDialog.show();
                        MoviePojo cities =(MoviePojo) parent.getItemAtPosition(position);


                        new ResponceFromCollaborativeFiltering(ListOfMoviesByWebMatrixActivity.this).execute(cities.name);


                    }
                }
        );

    }
    @Override
    protected void onPause() {
        super.onPause();
        if(progressDialog!=null && progressDialog.isShowing()){
            progressDialog.dismiss();
        }
    }

}
