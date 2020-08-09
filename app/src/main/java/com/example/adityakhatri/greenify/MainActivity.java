package com.example.adityakhatri.greenify;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static int a = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        if(a==1) {

            Handler h = new Handler();
            h.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent i = new Intent(MainActivity.this, Intro.class);
                    startActivity(i);
                    a = 2;
                }
            }, 300);

        }
        a=1;

            setContentView(R.layout.activity_main);

            if (getIntent().getBooleanExtra("Exit me", false)) {
                finish();
                return; // add this to prevent from doing unnecessary stuffs
            }

    }


}
