package com.example.android.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    long delay= 6000;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //code to make the splash screen full bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.splash_screen);
        //code to remove the action bar from the code
        getSupportActionBar().hide();


        //now will will add some delay in the code for our splash screen

        Timer barLoader= new Timer();
        final TimerTask showSplashScreen = new TimerTask() {
            @Override
            public void run() {
                finish();
                Intent  displayMain= new Intent(MainActivity.this, Login.class);
                        startActivity(displayMain);
            }
        };

        barLoader.schedule(showSplashScreen, delay);
    }
}