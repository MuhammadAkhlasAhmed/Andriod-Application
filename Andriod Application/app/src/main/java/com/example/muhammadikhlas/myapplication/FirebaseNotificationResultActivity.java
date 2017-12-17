package com.example.muhammadikhlas.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FirebaseNotificationResultActivity extends Activity implements View.OnClickListener{
public TextView txt;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firebasenotificationresultactivit);
       txt=(TextView)findViewById(R.id.mytext);

        String value=getIntent().getExtras().getString("Moviename");
        txt.setText(""+value);

b1=(Button)findViewById(R.id.button18);
        b1.setOnClickListener(this);






    }

    @Override
    public void onClick(View view) {
        if(view==b1){
            Intent in=new Intent(FirebaseNotificationResultActivity.this,LogoutActivity.class);
            startActivity(in);

        }

        //if(view==b2){}
    }
}
