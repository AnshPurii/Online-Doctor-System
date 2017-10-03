package com.aakash.ods;

/**
 * Created by Rohit on 21/09/2017.
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;



public class Gynaecologist extends AppCompatActivity {

    String names[] = {"Dr. Aakash Mahajan"};
    String about[] = {"MBBS,MD(MED)"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctor_listview);

        ListView listView = (ListView) findViewById(R.id.listview);

        CustomAdapter customAdapter = new CustomAdapter();

        listView.setAdapter(customAdapter);


    }

    class CustomAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return names.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.medicine_listview, null);
            TextView textView_name = (TextView) view.findViewById(R.id.textView_name);
            TextView textView_about = (TextView) view.findViewById(R.id.textView_about);
            Button but = (Button) view.findViewById(R.id.button);
            textView_name.setText(names[i]);
            textView_about.setText(about[i]);


            return view;
        }
    }

    public void onAppoint(View view)
    {
        Intent intent = new Intent(this,BookAppoint.class);
        Bundle bundle = new Bundle();
        bundle.putString("doc","7898476761");
        //bundle.putString("doc","Dr. Abhay Somani");
        intent.putExtras(bundle);
        startActivity(intent);
    }
}

