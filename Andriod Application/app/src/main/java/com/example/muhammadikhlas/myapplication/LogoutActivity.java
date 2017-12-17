package com.example.muhammadikhlas.myapplication;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.tv.TvInputService;
import android.os.AsyncTask;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import com.facebook.AccessToken;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.IgnoreExtraProperties;

import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

import com.google.firebase.database.ValueEventListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;


public class LogoutActivity extends Activity {

    private TextView btnLogout,textView,txt1;
    public User user;
    private ImageView profileImage;
    Bitmap bitmap;
int a;
    Button btn;





    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);

        user=PrefUtils.getCurrentUser(LogoutActivity.this);
        profileImage= (ImageView) findViewById(R.id.profileImage);
        textView=(TextView)findViewById(R.id.hi);
txt1=(TextView)findViewById(R.id.nama);
btn=(Button)findViewById(R.id.button2);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Hello",Toast.LENGTH_LONG).show();
String[] infos=new String[5];
                infos[0]=txt1.getText().toString();


                Intent listofmovies=new Intent(LogoutActivity.this,ListOfMoviesByWebMatrixActivity.class);
                startActivity(listofmovies);


                //PassingandgettingfromIMDB oop=new PassingandgettingfromIMDB();
                //oop.view(txt1.getText().toString());
//new PassingandgettingfromIMDB(getApplicationContext()).execute(new String[]{txt1.getText().toString()});





         /*
            */}
        });

        // fetching facebook's profile picture
        new AsyncTask<Void,Void,Void>(){
            @Override
            protected Void doInBackground(Void... params) {
                URL imageURL = null;

                try {
                    imageURL = new URL("https://graph.facebook.com/"+user.facebookID+"/picture?type=small&redirect=true&width=100&height=100");


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

                Log.d("Yahan check",""+AccessToken.getCurrentAccessToken().getPermissions());



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
}