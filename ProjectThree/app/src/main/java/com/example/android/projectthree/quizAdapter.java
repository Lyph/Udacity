package com.example.android.projectthree;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by lyphc on 7/12/2016.
 */

public class quizAdapter extends BaseAdapter {

    LayoutInflater layoutInflater;
    Context context;
    ArrayList<quizObject> q;
    ViewHolder viewHolder;


    public quizAdapter(ArrayList<quizObject> temp, Context context) {

        this.q = temp;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return this.q.size();
    }

    @Override
    public Object getItem(int position) {
        return this.q.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        convertView = layoutInflater.inflate(R.layout.quizformat, parent, false); //parent is the listview, so the view won't be destroyed when scolling

        viewHolder = new ViewHolder();

        viewHolder.question = (TextView) convertView.findViewById(R.id.question);
        viewHolder.a = (RadioButton) convertView.findViewById(R.id.a);

        viewHolder.a.setOnClickListener(new View.OnClickListener() {
        //Im pretty sure theres a way to clean this up using switches but it currently works and I don't want to upset the coding gods
            @Override
            public void onClick(View v) {

                if (q.get(position).getCorrect().charAt(0) == '1') {q.get(position).point = 1;}//position for a
                else{q.get(position).point = 0;}//this needs to be included because if the right answer is selected then deselected, it won't reset to 0 automatically
                q.get(position).setInput(1,0);
            }
        });
        viewHolder.b = (RadioButton) convertView.findViewById(R.id.b);
        viewHolder.b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (q.get(position).getCorrect().charAt(1) == '1') {q.get(position).point = 1;}//position for b
                else{q.get(position).point = 0;}
                q.get(position).setInput(1,1);
            }
        });
        viewHolder.c = (RadioButton) convertView.findViewById(R.id.c);
        viewHolder.c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (q.get(position).getCorrect().charAt(2) == '1') {q.get(position).point = 1;}//position for c
                else{q.get(position).point = 0;}
                q.get(position).setInput(1,2);
            }
        });
        viewHolder.d = (RadioButton) convertView.findViewById(R.id.d);
        viewHolder.d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (q.get(position).getCorrect().charAt(3) == '1') {
                    q.get(position).point = 1;
                }//position for d
                else {
                    q.get(position).point = 0;
                }
                q.get(position).setInput(1,3);
            }
        });

        viewHolder.question.setText(q.get(position).getQuestion());
        viewHolder.a.setText(q.get(position).getA());
        viewHolder.b.setText(q.get(position).getB());
        viewHolder.c.setText(q.get(position).getC());
        viewHolder.d.setText(q.get(position).getD());

        //reset
     /*   viewHolder.a.setChecked(false);
        viewHolder.b.setChecked(false);
        viewHolder.c.setChecked(false);
        viewHolder.d.setChecked(false);*/

        if (q.get(position).getInput()[0] == 1){viewHolder.a.setChecked(true);}
        if (q.get(position).getInput()[1] == 1){viewHolder.b.setChecked(true);}
        if (q.get(position).getInput()[2] == 1){viewHolder.c.setChecked(true);}
        if (q.get(position).getInput()[3] == 1){viewHolder.d.setChecked(true);}


        convertView.setTag(viewHolder);

        return convertView;
    }

    static class ViewHolder {
        TextView question;
        RadioButton a;
        RadioButton b;
        RadioButton c;
        RadioButton d;
    }
}

