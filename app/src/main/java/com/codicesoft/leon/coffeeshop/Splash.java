package com.codicesoft.leon.coffeeshop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Splash extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        int SPLASH_SCREEN_TIME = 500;
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent splashIntent = new Intent(Splash.this, MainActivity.class);
                Splash.this.startActivity(splashIntent);
                Splash.this.finish();
            }
        }, SPLASH_SCREEN_TIME);
    }
}
