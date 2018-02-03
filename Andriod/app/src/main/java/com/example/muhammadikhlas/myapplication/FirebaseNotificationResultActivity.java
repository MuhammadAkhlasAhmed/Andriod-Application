package com.example.muhammadikhlas.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class FirebaseNotificationResultActivity extends Activity implements View.OnClickListener{
public TextView txt;
    Button b1,btnsubmit;
    RatingBar ratingbar1;
    String value1;
    String value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.firebasenotificationresultactivit);
       txt=(TextView)findViewById(R.id.mytext);
        ratingbar1=(RatingBar)findViewById(R.id.ratingBar);
        value=getIntent().getExtras().getString("Moviename");
        txt.setText(""+value);
b1=(Button)findViewById(R.id.button18);
        b1.setOnClickListener(this);




btnsubmit=(Button)findViewById(R.id.button19);
btnsubmit.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if(view==b1){
            Intent in=new Intent(FirebaseNotificationResultActivity.this,LogoutActivity.class);
            startActivity(in);

        }

        if(view==btnsubmit){

//double x=Double.parseDouble(String.valueOf(ratingbar1.getRating()));
  double x=ratingbar1.getRating();




if(x>3){
    value1="like";

}
else{
    value1="dislike";
}

            String[] infos=new String[5];
            infos[0]=value.toString();
            infos[1]=value1.toString();

            new SendingFeedBackABoutMovies(FirebaseNotificationResultActivity.this).execute(infos);






        }
    }










}
