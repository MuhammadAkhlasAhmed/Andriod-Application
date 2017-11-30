package com.example.muhammadikhlas.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class IkhlasServiceWali extends Activity {
public TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ikhlas_service_wali);
       txt=(TextView)findViewById(R.id.mytext);

        String value=getIntent().getExtras().getString("Moviename");
        txt.setText(""+value);

    }
}
