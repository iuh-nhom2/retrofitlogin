package com.example.gmt_006.vshnn.Model;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Userlogin {
    @SerializedName("status")
    private Integer status;
    @SerializedName("msg")
    private String msg;
    @SerializedName("token")
    private String token;
    @SerializedName("role")
    private String role;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    public static Userlogin getUserlogin(JSONObject obj){
        return new Gson().fromJson(obj.toString(),Userlogin.class);

    }
    public static ArrayList<Userlogin> getinforUserLogin(JSONArray array) throws JSONException {
        ArrayList<Userlogin> ret = new ArrayList<>();
        for(int i=0;i< array.length();i++){
            ret.add(getUserlogin(array.getJSONObject(i)));
        }

        return  ret;

    }
}
