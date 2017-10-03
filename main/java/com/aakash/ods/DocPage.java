package com.aakash.ods;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by ansh on 9/28/2017.
 */

public class DocPage extends AppCompatActivity {
    //**ListView lv;
    List<String> list;
    ArrayAdapter<String> stringArrayAdapter;


    EditText username;
    EditText etpassword;
    Button btnlogin ;
    Button docloginbtn ;
    String dname,pname,time;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //DocPage.this.setContentView(R.layout.activity_doc);
        //setContentView(R.layout.activity_ods1);
        username = (EditText) findViewById(R.id.username);
        etpassword = (EditText) findViewById(R.id.password);
        final Context context = this;
        final String name = username.getText().toString();
        final String password = etpassword.getText().toString();
        
        final Handler handler = new Handler();

        new AsyncTask<String, Void, String>() {

            @Override
            protected String doInBackground(String... params) {

                String login_url = "https://rockstarhariom.000webhostapp.com/DoctorAppointment.php";
                try {
                    URL url = new URL(login_url);
                    HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String post_data = URLEncoder.encode("docID","UTF-8")+"="+URLEncoder.encode(name,"UTF-8")+"&"
                            +URLEncoder.encode("docPwd","UTF-8")+"="+URLEncoder.encode(password,"UTF-8");
                    bufferedWriter.write(post_data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                    String result="";
                    String line;
                    while((line = bufferedReader.readLine())!= null) {
                        result += line;
                    }
                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    return result;
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

            public void onPostExecute(final String result){
                if(result.contains("login successful")) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(context,"Login Successful!",Toast.LENGTH_SHORT).show();
                            setContentView(R.layout.activity_ods1);

                            list = new ArrayList<>();
                            stringArrayAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, list);
                            lv = (ListView) findViewById(R.id.lv);
                            lv.setAdapter(stringArrayAdapter);

                            dname = result.substring(result.indexOf("D_Name"));
                            pname = result.substring(result.indexOf("Time:"));
                            time = result.substring(result.indexOf("P_Name:"));
                            list.add(dname+" "+pname+" "+time);
                            lv.setAdapter(stringArrayAdapter);
                            stringArrayAdapter.notifyDataSetChanged();
                            lv.setAdapter(stringArrayAdapter);
                            stringArrayAdapter.notifyDataSetChanged();

                        }
                    });
                }
                else
                {
                    Toast.makeText(context,"Login failed!",Toast.LENGTH_SHORT).show();
                }
            }
        }.execute();
    }


}

