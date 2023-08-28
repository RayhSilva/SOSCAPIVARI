package com.example.tcc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class Splash extends AppCompatActivity {

         private final Timer timer = new Timer();
         TimerTask timerTask;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        timerTask =  new TimerTask() {
            @Override
            public void run(){
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        gotoActivityLogin();
                    }
                });



            }




        };
        timer.schedule(timerTask, 2000);

    }

    private void gotoActivityLogin() {
        Intent intent= new Intent(getApplicationContext(), TelaInicial.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    finish();

    }




}