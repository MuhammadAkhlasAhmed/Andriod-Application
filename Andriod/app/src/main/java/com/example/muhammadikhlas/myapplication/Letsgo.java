package com.example.muhammadikhlas.myapplication;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

public class Letsgo extends Activity {

    public Button btn;
    public EditText edit;
    private ProgressDialog progressDialog;
    private String regex = "^\\w+(\\s\\w+)*$";
    public TakeDataFromServiceAfterPassingMovieName takeDataFromServiceAfterPassingMovieName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letsgo);
        btn=(Button)findViewById(R.id.buttonx);
        edit=(EditText) findViewById(R.id.namax);
        edit.setText("");
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit.setHint("");
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] infos=new String[5];
                infos[0]=edit.getText().toString();
                if(edit.getText().length() == 0 || edit.getText() == null){
                    Toast.makeText(getApplicationContext(), "Please Enter a Movie Name", Toast.LENGTH_SHORT).show();
                } else if((!edit.getText().toString().matches(regex))){
                    Toast.makeText(getApplicationContext(), "Please Enter a Valid Movie Name", Toast.LENGTH_SHORT).show();
                    edit.setText("");
                } else {
                    progressDialog = new ProgressDialog(Letsgo.this);
                    progressDialog.setMessage("Loading, please wait...");
                    progressDialog.show();
                    takeDataFromServiceAfterPassingMovieName = new TakeDataFromServiceAfterPassingMovieName(Letsgo.this);
                    takeDataFromServiceAfterPassingMovieName.execute(infos);
                }
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(progressDialog!=null && progressDialog.isShowing()){
            progressDialog.dismiss();
            edit.setText("");
            edit.setHint("Enter Movie Name");
        }
    }
}