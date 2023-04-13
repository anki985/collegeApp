package com.example.grosskart;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.LinearLayout;
import android.widget.TextView;

public class splash_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        //finding IDS
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView textView = findViewById(R.id.gross);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView textView1 = findViewById(R.id.Kart);


        boolean handler = new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(getApplicationContext(), login.class);

                Animation scale = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.scale);
                textView.setAnimation(scale);
                textView1.setAnimation(scale);
                startActivity(i);
            }
        },4000);
    }
}