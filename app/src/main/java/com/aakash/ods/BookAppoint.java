package com.aakash.ods;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class BookAppoint extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bookappoint);
        //setSupportActionBar(toolbar);

    }
    public void app(View view)
    {
        Bundle b = getIntent().getExtras();

        Button fab = (Button) findViewById(R.id.btnAppoint);
        String time = fab.getText().toString();
        final HelperClass hc = new HelperClass(this);
        hc.execute(LoginRequest.name,b.getString("doc"),time);
        final Context context = this;
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(hc.flag)
                {
                    Toast.makeText(BookAppoint.this,"Appointment booked",Toast.LENGTH_SHORT).show();
                }
                if(hc.flag1)
                {
                    Toast.makeText(BookAppoint.this,"error",Toast.LENGTH_SHORT).show();
                }
            }
        }, 2000);
    }

    public void app1(View view)
    {
        Bundle b = getIntent().getExtras();

        Button fab1 = (Button) findViewById(R.id.btnAppoint1);
        String time = fab1.getText().toString();
        final HelperClass hc = new HelperClass(this);
        hc.execute(LoginRequest.name,b.getString("doc"),time);
        final Context context = this;
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(hc.flag)
                {
                    Toast.makeText(BookAppoint.this,"Appointment booked",Toast.LENGTH_SHORT).show();
                }
                if(hc.flag1)
                {
                    Toast.makeText(BookAppoint.this,"error",Toast.LENGTH_SHORT).show();
                }
            }
        }, 2000);
    }
}

