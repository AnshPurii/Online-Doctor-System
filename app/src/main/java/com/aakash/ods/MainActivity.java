package com.aakash.ods;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
   // EditText UsernameEt, PasswordEt;
    public static int SPLASH_TIME_OUT=3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       new Handler().postDelayed(new Runnable() {
            public void run()
            {
                Intent intent = new Intent(MainActivity.this,DoctorPatientLogin.class);
                startActivity(intent);
                finish();
            }


        },SPLASH_TIME_OUT);

    }

}







