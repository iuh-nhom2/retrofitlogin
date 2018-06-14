package com.example.gmt_006.resultretrofit.Presenter;

import android.support.annotation.MainThread;

import com.example.gmt_006.resultretrofit.Activity.MainActivity;
import com.example.gmt_006.resultretrofit.ServerRequest.RequestClientIML;
import com.example.gmt_006.resultretrofit.model.userlogin;
import com.example.gmt_006.resultretrofit.viewrequest.onPostLogin;

import java.util.ArrayList;

public class presenterLogin {
    private MainActivity mActivity;
    private RequestClientIML clientIML;
    private ArrayList<userlogin> arrayListul;

    public presenterLogin(MainActivity mainActivity) {
        arrayListul = new ArrayList<>();
        clientIML = RequestClientIML.getInstance(mainActivity);
        mActivity = mainActivity;

    }
    public void getforlogin(String user, String password){
        clientIML.postloginAPI(user,password);
    }
}
