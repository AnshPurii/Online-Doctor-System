package com.aakash.ods;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rohit on 17/09/2017.
 */

public class LoginRequest extends StringRequest {

    private static final   String LOGIN_REQUEST_URL="https://rockstarhariom.000webhostapp.com/Login.php";
    private Map<String,String> params;
    public static String name;
    public LoginRequest(String name, String password , Response.Listener<String>listener){
        super(Request.Method.POST,LOGIN_REQUEST_URL,listener,null);
        params=new HashMap<>();
        this.name=name;
        params.put("name",name);
        params.put("password",password);

    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}

