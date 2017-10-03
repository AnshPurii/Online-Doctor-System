package com.aakash.ods;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ODS2 extends AppCompatActivity {

    int images[] = {R.drawable.cardiology,R.drawable.medicine,R.drawable.neurology,R.drawable.surgery,R.drawable.orthology,R.drawable.gynaecology};
    static String name;
    String names[] = {"CARDIOLOGY","MEDICINE","NEUROLOGIST","SURGERY","ORTHOPEDIC","GYNAECOLOGIST"};
    static String phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ods2a);
       // Bundle b = getIntent().getExtras();
       //  phone = b.getString("phone");
        name = getIntent().getStringExtra("name");

        Toast.makeText(ODS2.this,"Hello, "+name,Toast.LENGTH_SHORT).show();
        ListView listView =(ListView) findViewById(R.id.listView);

        CustomAdapter customAdapter = new CustomAdapter();

        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if(position == 0){
                    Intent myintend = new Intent(view.getContext(),Cardiology.class);
                    startActivityForResult(myintend,0);
                }
                if(position == 1){
                    Intent myintend = new Intent(view.getContext(),Medicine.class);
                    startActivityForResult(myintend,0);
                }
                if(position == 2){
                    Intent myintend = new Intent(view.getContext(),Neurologist.class);
                    startActivityForResult(myintend,0);
                }
                if(position == 3){
                    Intent myintend = new Intent(view.getContext(),Surgery.class);
                    startActivityForResult(myintend,0);
                }
                if(position == 4){
                    Intent myintend = new Intent(view.getContext(),Orthopedic.class);
                    startActivityForResult(myintend,0);
                }
                if(position == 5){
                    Intent myintend = new Intent(view.getContext(),Gynaecologist.class);
                    startActivityForResult(myintend,0);
                }
            }
        });
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
            view = getLayoutInflater().inflate(R.layout.activity_ods2b,null);

            ImageView imageView = (ImageView)view.findViewById(R.id.imageView);

            TextView textView_name = (TextView)view.findViewById(R.id.textView_name);

            imageView.setImageResource(images[i]);
            textView_name.setText(names[i]);

            return view;
        }
    }
}

