package com.example.adityakhatri.greenify;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class CreateMacro extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id =item.getItemId();
        switch (id)
        {
            case R.id.ctnus:
                Intent i1=new Intent(this,Contact_us.class);
                startActivity(i1);

                Toast.makeText(this,"contact us",Toast.LENGTH_SHORT).show();
                break;
            case R.id.feedback:
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://greenifyplus.wordpress.com/feedback/"));
                startActivity(browserIntent);
                Toast.makeText(this,"feedback",Toast.LENGTH_SHORT).show();
                break;

        }

        return true;
    }

    Button trig,act;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_macro);

        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }

        trig = findViewById(R.id.trig);
        act = findViewById(R.id.act);

        final FragmentManager FM = getSupportFragmentManager();

        trig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction FT = FM.beginTransaction();
                FT.replace(R.id.frmlyt, new FrmTrigger());
                FT.commit();
            }
        });

        act.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction FT=FM.beginTransaction();
                FT.replace(R.id.frmlyt,new Action());
                FT.commit();

            }
        });

    }
}
