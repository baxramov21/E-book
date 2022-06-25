package com.template;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends FragmentActivity {

    private Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        animation =  AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom);
        ImageView imageView = findViewById(R.id.image_logo);
        imageView.startAnimation(animation);
        int milliSecs = 1500;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(MainActivity.this,ContentActivity.class));
            }
        },milliSecs);
    }
}