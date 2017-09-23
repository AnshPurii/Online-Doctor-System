package com.aakash.ods;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Rohit on 19/09/2017.
 */

public class DoctorPatientLogin extends AppCompatActivity {
    public Button doctor,patient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctorpatientlogin);
        init();
        init1();
    }

    public void init() {
         doctor=(Button)findViewById(R.id.doctorbtn);
        doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DoctorPatientLogin.this, ODS1.class);
                startActivity(intent);
            }
        });


    }


    public void init1() {
        patient=(Button)findViewById(R.id.patientbtn);
        patient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DoctorPatientLogin.this,ODS1.class);
                startActivity(intent);

            }
        });


    }



}
