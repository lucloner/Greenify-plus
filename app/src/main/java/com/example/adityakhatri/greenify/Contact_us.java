package com.example.adityakhatri.greenify;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class Contact_us extends AppCompatActivity {
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
                Intent i=new Intent(this,Contact_us.class);
                startActivity(i);

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
}
