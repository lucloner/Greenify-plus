package com.example.adityakhatri.greenify;

import android.app.ActivityManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.util.List;

public class SelectMode extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
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

    Button SelectMode;

    MyAdapter adp;
    ListView lst;
    int load = 0;
    List<ActivityManager.RunningAppProcessInfo> processes;
    ActivityManager amg;

    SwipeRefreshLayout sr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_mode);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }

        // using Activity service to list all process
        amg = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
// list all running process
        processes = amg.getRunningAppProcesses();


        sr = findViewById(R.id.sr);

        sr.setOnRefreshListener(this);

        lst = findViewById(R.id.lst);
        skill_Load_Process();
        lst.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {


                if (load == 1) {
                    for (ActivityManager.RunningAppProcessInfo info : processes) {
                        if (info.processName.equalsIgnoreCase(
                                ((ActivityManager.RunningAppProcessInfo)parent.getItemAtPosition(position)).processName)) {
                            // kill selected process

                            android.os.Process.killProcess(info.pid);
                            android.os.Process.sendSignal(info.pid, android.os.Process.SIGNAL_KILL);
                            amg.killBackgroundProcesses(info.processName);
                        }
                    }
                    load = 0;
                    // refresh list of process
                    skill_Load_Process();
                }
                skill_Load_Process();
                return true;
            }
        });


    }
    @Override
    public void onRefresh() {

        lst.refreshDrawableState();
        sr.setRefreshing(false);

    }

    private void skill_Load_Process() {

        if (load == 0) {
// using Activity service to list all process
            amg = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
// list all running process
            processes = amg.getRunningAppProcesses();
// display list of process on listview


            adp = new MyAdapter(processes, SelectMode.this);
            lst.setAdapter(adp);
            load = 1;
        }
    }




}
