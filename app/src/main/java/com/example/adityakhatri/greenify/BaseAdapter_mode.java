package com.example.adityakhatri.greenify;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by adityakhatri on 07/09/18.
 */

public class BaseAdapter_mode extends BaseAdapter {

    Context c;
    ArrayList<String> ModeLyst;


    public BaseAdapter_mode(Context c, ArrayList<String> ModeLyst)
    {
        this.c=c;
        this.ModeLyst=ModeLyst;

    }


    @Override
    public int getCount() {
        return ModeLyst.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup vg) {
        view = LayoutInflater.from(c).inflate(R.layout.customlist,vg,false);
        TextView tvcustonlyst = view.findViewById(R.id.customlyst);
        tvcustonlyst.setText(ModeLyst.get(i).toString().trim());

        return view;

    }
}
