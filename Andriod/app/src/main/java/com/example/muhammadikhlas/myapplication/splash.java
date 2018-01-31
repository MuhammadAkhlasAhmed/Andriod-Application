package com.example.muhammadikhlas.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class splash extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getActionBar().hide();

        Thread thread =new Thread(){

            @Override
            public void run(){

                try {
                    sleep(4000);
                    Intent in=new Intent(splash.this,MainActivity.class);
                    startActivity(in);
                    finish();



                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }





        };
        thread.start();

    }
}
