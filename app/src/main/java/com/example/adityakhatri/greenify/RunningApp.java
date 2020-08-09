package com.example.adityakhatri.greenify;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;
import java.util.*;

public class RunningApp extends AppCompatActivity {
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
    Button BtnKill,BtnRefresh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_runningapp);
if(getSupportActionBar() != null) {
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
}

        TextView tv = (TextView) findViewById(R.id.textView1);





        final ActivityManager activityManager = (ActivityManager) this

                .getSystemService(Activity.ACTIVITY_SERVICE);


        List<ActivityManager.RunningAppProcessInfo> procInfos = activityManager

                .getRunningAppProcesses();

        for (int idx = 0; idx < procInfos.size(); idx++) {
            String pname=procInfos.get(idx).processName;
            String [] p1=pname.split("\\.");
            int l=p1.length;


            tv.setText(tv.getText() + "" + (idx + 1) + ". "

                    + p1[l-1].toUpperCase() + "\n");


        }

//        for(RunningAppProcessInfo processInfo: procInfos)
//        {
//            tv.setText(tv.getText()+processInfo.processName+"\n");
//        }

        BtnKill = (Button) findViewById(R.id.BtnKill);
        BtnRefresh= (Button) findViewById(R.id.BtnRefresh);

        BtnKill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ActivityManager actvityManager = (ActivityManager)
                        getApplicationContext().getSystemService( getApplicationContext().ACTIVITY_SERVICE );
//                List<ActivityManager.RunningAppProcessInfo> procInfos = actvityManager.getRunningAppProcesses();
                List<RunningAppProcessInfo> packages;
//                PackageManager pm;
//                pm = getPackageManager();
                //get a list of installed apps.
                packages = activityManager.getRunningAppProcesses();
                //packages = pm.getInstalledApplications(0);

                for(int pnum = 0; pnum < packages.size(); pnum++)
                {
                      if((packages.get(pnum)).processName.contains("android")||(packages.get(pnum)).processName.contains("system"))//||(packages.get(pnum)).processName.contains("adi"))
                    {
//                        String pname=packages.get(pnum).processName;
//                        String [] p1=pname.split("\\.");
//                        int l=p1.length;

//                        Toast.makeText(getApplicationContext(), "system apps\n"+ p1[l-1], Toast.LENGTH_SHORT).show();
                    }
                    else
                        {
                          actvityManager.killBackgroundProcesses(packages.get(pnum).processName);
                            String pname=packages.get(pnum).processName;
                            String [] p1=pname.split("\\.");
                            int l=p1.length;


                            Toast t1 = Toast.makeText(getApplicationContext(), "Processes Killed " + p1[l-1], Toast.LENGTH_SHORT);
                          t1.setGravity(Gravity.BOTTOM, 5, 5);
                          t1.show();
                      }


                }


            }
        });

        BtnRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(0, 0);
                startActivity(getIntent());
                overridePendingTransition(0, 0);
            }
        });



    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        Intent i =new Intent(RunningApp.this,SelectMode_f.class);
        startActivity(i);
    }
}
