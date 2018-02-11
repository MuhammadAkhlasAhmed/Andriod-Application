package com.example.muhammadikhlas.myapplication;

import com.facebook.FacebookSdk;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.LoggingBehavior;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import android.app.ProgressDialog;
import android.view.View;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import org.json.JSONObject;

/**
 * Created by Muhammad IKHLAS on 12/24/2017.
 */
public class MainActivity extends Activity {

    private CallbackManager callbackManager;
    private LoginButton loginButton;
    private TextView btnLogin;
    private ProgressDialog progressDialog;
    private Button btnLetsgo;
    public User user;
    public LoginResult logre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Movies Recommendation System");
        if(PrefUtils.getCurrentUser(MainActivity.this) != null){
            Intent homeIntent = new Intent(MainActivity.this, LogoutActivity.class);
            startActivity(homeIntent);
            finish();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        FacebookSdk.setIsDebugEnabled(true);
        FacebookSdk.addLoggingBehavior(LoggingBehavior.INCLUDE_ACCESS_TOKENS);
        callbackManager=CallbackManager.Factory.create();
        loginButton= (LoginButton)findViewById(R.id.login_button);
        loginButton.setReadPermissions("public_profile","email","user_friends");
        btnLogin= (TextView) findViewById(R.id.btnLogin);
        btnLetsgo= (Button) findViewById(R.id.button3);
        btnLetsgo.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent letsgo=new Intent(MainActivity.this,Letsgo.class);
            startActivity(letsgo);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setMessage("Loading...");
                progressDialog.show();
                loginButton.performClick();
                loginButton.setPressed(true);
                loginButton.invalidate();
                loginButton.registerCallback(callbackManager, mCallBack);
                loginButton.setPressed(false);
                loginButton.invalidate();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    private FacebookCallback<LoginResult> mCallBack = new FacebookCallback<LoginResult>() {
        @Override
        public void onSuccess(final LoginResult loginResult) {
            progressDialog.dismiss();
            // App code
            GraphRequest request = GraphRequest.newMeRequest(
                    loginResult.getAccessToken(),
                    new GraphRequest.GraphJSONObjectCallback() {
                        @Override
                        public void onCompleted(
                                JSONObject object,
                                GraphResponse response) {
                            try {
                                user = new User();
                                user.facebookID = object.getString("id").toString();
                                user.email = object.getString("email").toString();
                                user.name = object.getString("name").toString();
                                user.gender = object.getString("gender").toString();
                           //     user.accessToken= AccessToken.getCurrentAccessToken();
                             //   Log.d("NACHO",""+user.accessToken);
                                PrefUtils.setCurrentUser(user,MainActivity.this);
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                            Toast.makeText(MainActivity.this,"welcome "+user.name+"\n"+user.facebookID,Toast.LENGTH_LONG).show();
                            Intent intent=new Intent(MainActivity.this,LogoutActivity.class);
                            startActivity(intent);
                            finish();
                        }

                    });
            Bundle parameters = new Bundle();
            parameters.putString("fields", "id,name,email,gender, birthday");
            request.setParameters(parameters);
            request.executeAsync();
        }

        @Override
        public void onCancel() {
            progressDialog.dismiss();
        }

        @Override
        public void onError(FacebookException e) {
            progressDialog.dismiss();
        }
    };
}