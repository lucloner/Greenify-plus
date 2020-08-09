package com.example.adityakhatri.greenify;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.TrafficStats;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

public class SelectMode_f extends AppCompatActivity {
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

    Button ActPerformance,ActEco,ActCritical,ActCustom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_mode_f);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ActPerformance= (Button) findViewById(R.id.ActPerformance);
        ActEco= (Button) findViewById(R.id.ActEco);
        ActCritical= (Button) findViewById(R.id.ActCritical);
        ActCustom= (Button) findViewById(R.id.ActCustom);


        ActPerformance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast t= Toast.makeText(SelectMode_f.this,"Activated Performance mode",Toast.LENGTH_LONG);
                t.setGravity(Gravity.BOTTOM,0,0);
                t.show();

                Intent i=new Intent(SelectMode_f.this,SelectMode.class);
                startActivity(i);



            }
        });

        ActEco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast t= Toast.makeText(SelectMode_f.this,"Activated Eco mode",Toast.LENGTH_SHORT);
                t.setGravity(Gravity.BOTTOM,0,0);
                t.show();


//
              ActivityManager actvityManager = (ActivityManager)
                        getApplicationContext().getSystemService( getApplicationContext().ACTIVITY_SERVICE );
                List<ActivityManager.RunningAppProcessInfo> procInfos = actvityManager.getRunningAppProcesses();

                for(int pnum = 0; pnum < procInfos.size(); pnum++)
                {
                    if((procInfos.get(pnum)).processName.contains("android")||(procInfos.get(pnum)).processName.contains("system")||(procInfos.get(pnum)).processName.contains("adil"))
                    {
                        Toast.makeText(getApplicationContext(), "system apps", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {

//                        final ActivityManager am = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
//                        am.forceStopPackage(procInfos.get(pnum).processName);

                        actvityManager.killBackgroundProcesses(procInfos.get(pnum).processName);
                        Toast t1= Toast.makeText(getApplicationContext(), "killed "+procInfos.get(pnum).processName, Toast.LENGTH_SHORT);
                        t1.setGravity(Gravity.BOTTOM,5,5);
                        t1.show();

                    }
                }



            }
        });

        ActCritical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast t= Toast.makeText(SelectMode_f.this,"Activated Critical mode",Toast.LENGTH_SHORT);
                t.setGravity(Gravity.BOTTOM,5,5);
                t.show();
                Intent i =new Intent(SelectMode_f.this,RunningApp.class);
                startActivity(i);

            }
        });

        ActCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast t= Toast.makeText(SelectMode_f.this,"Activated Custom mode",Toast.LENGTH_SHORT);
                t.setGravity(Gravity.BOTTOM,0,0);
                t.show();

                Intent i=new Intent(SelectMode_f.this,CustomMode.class);
                startActivity(i);

            }
        });


    }

}
