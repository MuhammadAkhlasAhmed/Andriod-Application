package com.example.muhammadikhlas.myapplication;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Muhammad IKHLAS on 12/24/2017.
 */
public class ListOfMoviesByWebMatrixActivity extends Activity {

    public String responseText;
    public StringBuffer response;
    public URL url;
    public Activity activity;
    private ProgressDialog progressDialog;
    public ListView listView;
    public StringBuffer responce;
    public String name;
    public List<MoviePojo> rowItems;
    public ListView mylistview;
    TakeDataFromServiceAfterPassingMovieName iop = new TakeDataFromServiceAfterPassingMovieName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listofmoviesbywebmatrixactivity);
        rowItems = new ArrayList<MoviePojo>();
        Intent i = getIntent();
        rowItems = (List<MoviePojo>) i.getSerializableExtra("LIST");
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
                        MoviePojo cities = (MoviePojo) parent.getItemAtPosition(position);
                        new ResponceFromCollaborativeFiltering(ListOfMoviesByWebMatrixActivity.this).execute(cities.name);
                    }
                }
        );
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }
}
