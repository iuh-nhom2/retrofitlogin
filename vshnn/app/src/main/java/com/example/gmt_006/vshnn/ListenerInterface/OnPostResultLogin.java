package com.example.gmt_006.vshnn.ListenerInterface;

import android.content.Context;

import com.example.gmt_006.vshnn.Model.Userlogin;

import java.util.ArrayList;

public interface OnPostResultLogin {
    void LoginSuccess();
    void LoginFailed(String s);
}
