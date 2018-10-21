package umdslacker.FundFinder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;


public class MainActivity extends AppCompatActivity {
    LoginButton loginButton;

    CallbackManager callbackManager;


    View view;
    public boolean loggedIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        loggedIn = false;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        callbackManager = CallbackManager.Factory.create();
        loginButton =  (LoginButton)findViewById(R.id.login_button);

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
            Toast.makeText(getApplicationContext(),"1",Toast.LENGTH_LONG).show();
                Intent mapIn = new Intent(MainActivity.this,MapsActivity.class);
                startActivity(mapIn);
            }

            @Override
            public void onCancel() {
                Toast.makeText(getApplicationContext(),"2",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onError(FacebookException e) {
                Toast.makeText(getApplicationContext(),"3",Toast.LENGTH_LONG).show();
            }
        });



    }

        protected void viewAct (View view){
            Intent randomIntent = new Intent(this, MapsActivity.class);
            startActivity(randomIntent);
        }
    }

