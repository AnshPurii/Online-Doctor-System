package com.aakash.ods;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

//import com.aakash.ods.DB.SignupInformation;

public class ODS3 extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ods3);
        final EditText etname=(EditText) findViewById(R.id.name1);
        final EditText etpassword=(EditText) findViewById(R.id.password1);
        final EditText etemail=(EditText) findViewById(R.id.email1);
        final EditText etphone=(EditText) findViewById(R.id.phone);

        final Button btn=(Button) findViewById(R.id.signup);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 String name=etname.getText().toString();
                 String password=etpassword.getText().toString();
                 String email=etemail.getText().toString();
                 String number=etphone.getText().toString();

                if(name.isEmpty() || password.isEmpty() || email.isEmpty() || number.isEmpty()){
                    AlertDialog.Builder builder=new AlertDialog.Builder(ODS3.this);
                    builder.setMessage("Register Failed")
                            .setNegativeButton("Retry",null)
                            .create()
                            .show();
                    etname.setText("");
                    etemail.setText("");
                    etpassword.setText("");
                    etphone.setText("");
                }
                else {
                    Response.Listener<String> responseListener = new Response.Listener<String>() {

                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonResponce = new JSONObject(response);
                                boolean success = jsonResponce.getBoolean("success");
                                if (success) {
                                    Toast.makeText(ODS3.this, "SignUp Successfully", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(ODS3.this, ODS1.class);
                                    ODS3.this.startActivity(intent);
                                } else {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(ODS3.this);
                                    builder.setMessage("Register Failed")
                                            .setNegativeButton("Retry", null)
                                            .create()
                                            .show();
                                    etname.setText("");
                                    etemail.setText("");
                                    etpassword.setText("");
                                    etphone.setText("");
                                }


                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    };
                    RegisterRequest registerRequest = new RegisterRequest(name, email, number, password, responseListener);
                    RequestQueue queue = Volley.newRequestQueue(ODS3.this);
                    queue.add(registerRequest);

                }
            }
        });


    }
}