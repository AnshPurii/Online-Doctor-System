package com.aakash.ods;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
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



public class HelperClass extends AsyncTask<String,Void,String>
{

    Context context;

    HelperClass (Context ctx) {
        context = ctx;
        flag=false;
        flag1=false;
    }


    @Override
    protected String doInBackground(String... params) {

        String login_url = "https://rockstarhariom.000webhostapp.com/Appoint.php";

            try {

                String DocID = params[0];
                String PatID = params[1];
                String times = params[2];
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("D_ID","UTF-8")+"="+URLEncoder.encode(DocID,"UTF-8")+"&"
                        +URLEncoder.encode("P_ID","UTF-8")+"="+URLEncoder.encode(PatID,"UTF-8")+"&"
                        +URLEncoder.encode("Time","UTF-8")+"="+URLEncoder.encode(times,"UTF-8");
                /*String post_data = URLEncoder.encode("D_ID","UTF-8")+"="+URLEncoder.encode(DocID,"UTF-8")+"&"
                        +URLEncoder.encode("P_ID","UTF-8")+"="+URLEncoder.encode(PatID,"UTF-8")+"&"
                        +URLEncoder.encode("Time","UTF-8")+"="+URLEncoder.encode(times,"UTF-8");*/
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

    String name1;

    @Override
    protected void onPreExecute() {

    }

boolean flag,flag1;
    @Override
    protected void onPostExecute(String result) {
        if(result.contains("Appointment booked!"))
        {
           flag=true;
        }
        if(result.contains("app error"))
        {
            flag1=true;
        }
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}