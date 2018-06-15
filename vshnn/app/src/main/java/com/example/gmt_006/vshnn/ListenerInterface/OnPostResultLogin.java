package com.example.gmt_006.vshnn.ListenerInterface;

import com.example.gmt_006.vshnn.Model.Userlogin;

import java.util.ArrayList;

public interface OnPostResultLogin {
    void LoginSuccess(ArrayList<Userlogin> arrayList);
    void LoginFailed(String s);
}
