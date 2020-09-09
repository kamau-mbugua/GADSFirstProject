package com.example.gadsproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);



        Thread timer = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(2000);



                    Intent Intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(Intent);

                    finish();

                    super.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };
        timer.start();
    }
}
