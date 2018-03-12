package com.example.muhammadikhlas.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * Created by Muhammad IKHLAS on 12/24/2017.
 */
public class FirebaseNotificationResultActivity extends Activity implements View.OnClickListener {

    public TextView txt;
    public Button b1, btnsubmit;
    public RatingBar ratingbar1;
    public String value1;
    public String value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firebasenotificationresultactivit);
        setTitle("Movies Recommendation System");
        txt = (TextView) findViewById(R.id.mytext);
        ratingbar1 = (RatingBar) findViewById(R.id.ratingBar);
        value = getIntent().getExtras().getString("Moviename");
        txt.setText("" + value);
        b1 = (Button) findViewById(R.id.button18);
        b1.setOnClickListener(this);
        btnsubmit = (Button) findViewById(R.id.button19);
        btnsubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == b1) {
            Intent in = new Intent(FirebaseNotificationResultActivity.this, LogoutActivity.class);
            startActivity(in);
        }
        if (view == btnsubmit) {
//double x=Double.parseDouble(String.valueOf(ratingbar1.getRating()));
            double x = ratingbar1.getRating();
            if (x > 3) {
                value1 = "like";
            } else {
                value1 = "dislike";
            }
            String[] infos = new String[5];
            infos[0] = value.toString();
            infos[1] = value1.toString();
            new SendingFeedBackABoutMovies(FirebaseNotificationResultActivity.this).execute(infos);
        }
    }
}
