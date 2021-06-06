package com.example.adityakhatri.greenify;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Selection extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu,menu);
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

    Button SelectMode,SelectMacro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }

        SelectMode = findViewById(R.id.SelectMode);


        SelectMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Selection.this, SelectMode_f.class);
                startActivity(i);

            }
        });

        SelectMacro = findViewById(R.id.SelectMacro);


        SelectMacro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(Selection.this,CreateMacro.class);
                startActivity(i);

            }
        });


    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();

        AlertDialog.Builder adb= new AlertDialog.Builder(Selection.this);
        adb.setMessage("Are you sure you want to quit");
        adb.setTitle("Close");
        adb.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Intent intent = new Intent(Selection.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("Exit me", true);
                startActivity(intent);
                finish();
            }
        });

        adb.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(getApplicationContext(), "hello", Toast.LENGTH_SHORT).show();
            }
        });
        runOnUiThread(adb::show);
    }


}
