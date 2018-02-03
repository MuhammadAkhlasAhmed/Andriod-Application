package com.example.muhammadikhlas.myapplication;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class Letsgo extends Activity {

    Button btn;
    EditText edit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letsgo);

        btn=(Button)findViewById(R.id.buttonx);
        edit=(EditText) findViewById(R.id.namax);


        edit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                edit.setText("");
            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                String[] infos=new String[5];
                infos[0]=edit.getText().toString();


                new TakeDataFromServiceAfterPassingMovieName(Letsgo.this).execute(infos);





            }
        });

    }
}
