package com.example.adityakhatri.greenify;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomMode extends AppCompatActivity {
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

    ListView cstmlist;

    Button modeset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_mode);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        cstmlist = (ListView) findViewById(R.id.cstmlist);

        ArrayList<String> ModeLyst =new ArrayList<>();

        ModeLyst.add("Whatsapp");
        ModeLyst.add("Instagram");
        ModeLyst.add("Facebook");
        ModeLyst.add("Twitter");
        ModeLyst.add("Google Chrome");
        ModeLyst.add("Play Store");
        ModeLyst.add("Gmail");
        ModeLyst.add("Whatsapp");
        ModeLyst.add("Instagram");
        ModeLyst.add("Facebook");
        ModeLyst.add("Twitter");
        ModeLyst.add("Google Chrome");
        ModeLyst.add("Play Store");
        ModeLyst.add("Gmail");
        ModeLyst.add("Whatsapp");
        ModeLyst.add("Instagram");
        ModeLyst.add("Facebook");
        ModeLyst.add("Twitter");
        ModeLyst.add("Google Chrome");
        ModeLyst.add("Play Store");
        ModeLyst.add("Gmail");
        ModeLyst.add("Whatsapp");
        ModeLyst.add("Instagram");
        ModeLyst.add("Facebook");
        ModeLyst.add("Twitter");
        ModeLyst.add("Google Chrome");
        ModeLyst.add("Play Store");
        ModeLyst.add("Gmail");


        cstmlist.setAdapter(new BaseAdapter_mode(CustomMode.this,ModeLyst));

        modeset = (Button) findViewById(R.id.modeset);

        modeset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(CustomMode.this,"Mode setted",Toast.LENGTH_SHORT).show();
            }
        });


    }
}
