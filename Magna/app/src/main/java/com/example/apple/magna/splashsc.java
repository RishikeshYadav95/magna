package com.example.apple.magna;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.apple.magna.MainActivity;
import com.example.apple.magna.R;


public class splashsc extends Activity {

    // Splash screen timer
    private static int SPLASH_TIME_OUT = 1500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashsc);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(splashsc.this, signin.class);
                startActivity(i);
                //setContentView(R.layout.signin);

                // close this activity
                finish();
            }
        },SPLASH_TIME_OUT);
    }

}


