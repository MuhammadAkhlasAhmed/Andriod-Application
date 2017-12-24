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


    String[] member_names= new String[5];
    String[] statues=new String[5];
    String[] contactType=new String[5];
    List<RowItem> rowItems;
    ListView mylistview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listofmoviesbywebmatrixactivity);
        activity = this;
member_names[0]="Hello";
statues[0]="1";
        contactType[0]="111";

        rowItems = new ArrayList<RowItem>();


            RowItem item = new RowItem(member_names[0],statues[0],contactType[0]);
            rowItems.add(item);

        mylistview = (ListView) findViewById(R.id.list);
        mylistview.setBackgroundColor(Color.BLACK);
        CustomAdapter adapter = new CustomAdapter(this, rowItems);
        mylistview.setAdapter(adapter);



















    }











}
