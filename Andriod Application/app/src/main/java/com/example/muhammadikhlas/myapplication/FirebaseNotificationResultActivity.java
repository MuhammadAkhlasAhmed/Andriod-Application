package com.example.muhammadikhlas.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class FirebaseNotificationResultActivity extends Activity {
public TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firebasenotificationresultactivit);
       txt=(TextView)findViewById(R.id.mytext);

        String value=getIntent().getExtras().getString("Moviename");
        txt.setText(""+value);

    }
}
