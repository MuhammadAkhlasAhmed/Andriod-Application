package com.example.muhammadikhlas.myapplication;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.login.LoginManager;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Muhammad IKHLAS on 12/24/2017.
 */
public class LogoutActivity extends Activity {

    private TextView btnLogout,textView;
    private EditText txt1;
    private ProgressDialog progressDialog;
    public User user;
    private ImageView profileImage;
    Bitmap bitmap;
    int a;
    Button btn;
    private ProgressBar spinner;
    private String regex = "^\\w+(\\s\\w+)*$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);
        user=PrefUtils.getCurrentUser(LogoutActivity.this);
        profileImage= (ImageView) findViewById(R.id.profileImage);
        textView=(TextView)findViewById(R.id.hi);
        txt1=(EditText) findViewById(R.id.nama);
        btn=(Button)findViewById(R.id.button2);
        spinner=(ProgressBar)findViewById(R.id.progressBar2);
        spinner.setVisibility(View.GONE);
        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //spinner.setVisibility(View.GONE);
                txt1.setHint("");
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                progressDialog = new ProgressDialog(LogoutActivity.this);
//                progressDialog.setMessage("Please wait...");
//                progressDialog.show();
//                spinner.setVisibility(View.VISIBLE);
//                String[] infos=new String[5];
//                infos[0]=txt1.getText().toString();
//                new TakeDataFromServiceAfterPassingMovieName(LogoutActivity.this).execute(infos);
                String[] infos=new String[5];
                infos[0]=txt1.getText().toString();
                if(txt1.getText().length() == 0 || txt1.getText() == null){
                    Toast.makeText(getApplicationContext(), "Please Enter a Movie Name", Toast.LENGTH_SHORT).show();
                } else if((!txt1.getText().toString().matches(regex))){
                    Toast.makeText(getApplicationContext(), "Please Enter a Valid Movie Name", Toast.LENGTH_SHORT).show();
                    txt1.setText("");
                } else {
                    progressDialog = new ProgressDialog(LogoutActivity.this);
                    progressDialog.setMessage("Loading, please wait...");
                    progressDialog.show();
                    new TakeDataFromServiceAfterPassingMovieNameForFacebookUser(LogoutActivity.this).execute(infos);
                }
        }
        });

        // fetching facebook's profile picture
        new AsyncTask<Void,Void,Void>(){
            @Override
            protected Void doInBackground(Void... params) {
                URL imageURL = null;
                try {
                    imageURL = new URL("https://graph.facebook.com/"+user.facebookID+"/picture?type=small&redirect=true&width=170&height=170");
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                try {
                    bitmap  = BitmapFactory.decodeStream(imageURL.openConnection().getInputStream());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                profileImage.setImageBitmap(bitmap);
                textView.setText(""+user.name);
               new CallingMoviesFromGraphAndSending().execute();
            }
        }.execute();

        btnLogout = (TextView) findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PrefUtils.clearCurrentUser(LogoutActivity.this);
                // We can logout from facebook by calling following method
                LoginManager.getInstance().logOut();
                Intent i= new Intent(LogoutActivity.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(progressDialog!=null && progressDialog.isShowing()){
            progressDialog.dismiss();
            txt1.setText("");
            txt1.setHint("Enter Movie Name");
        }
    }
}