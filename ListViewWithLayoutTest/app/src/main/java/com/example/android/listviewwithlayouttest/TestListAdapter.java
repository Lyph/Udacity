package com.example.android.listviewwithlayouttest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import static android.R.layout.simple_list_item_1;

/**
 * Created by lyphc on 7/2/2016.
 */
public class TestListAdapter extends BaseAdapter {

    String[] names;
    Context context;
    LayoutInflater myInflater;

   public TestListAdapter(String[] a, Context b){
        names= a;
       context = b;
       myInflater = (LayoutInflater)b.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }



    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int position) {
        return names[position];
    }

    /*Not important*/
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       if(convertView == null){
           convertView = myInflater.inflate(android.R.layout.activity_main);
           TextView name = (TextView)convertView.findViewById(android.R.id.test);


       }
        return null;
    }
}
