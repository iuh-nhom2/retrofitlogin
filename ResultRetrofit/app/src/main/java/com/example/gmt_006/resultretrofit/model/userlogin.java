package com.example.gmt_006.resultretrofit.model;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class userlogin {
    @SerializedName("status")
    private Integer status;
    @SerializedName("msg")
    private String msg;
    @SerializedName("token")
    private String token;
    @SerializedName("role")
    private Integer role;

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

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
    public static userlogin getuserlogin(JSONObject obj){
        return new Gson().fromJson(obj.toString(),userlogin.class);
    }
    public static ArrayList<userlogin> getforlogin(JSONArray array) throws JSONException {
        ArrayList<userlogin> ret = new ArrayList<>();
        for (int i=0;i<array.length();i++){
            ret.add(getuserlogin(array.getJSONObject(i)));
        }
        return ret;
    }

}
