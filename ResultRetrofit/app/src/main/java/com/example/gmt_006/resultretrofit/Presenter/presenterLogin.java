package com.example.gmt_006.resultretrofit.Presenter;

import com.example.gmt_006.resultretrofit.Activity.MainActivity;
import com.example.gmt_006.resultretrofit.ServerRequest.RequestClientIML;
import com.example.gmt_006.resultretrofit.model.userlogin;
import com.example.gmt_006.resultretrofit.viewrequest.onPostLogin;

import java.util.ArrayList;

public class presenterLogin {
    private MainActivity mainActivity;
    private RequestClientIML clientIML;
    private ArrayList<userlogin> arrayListul;

    public presenterLogin(MainActivity mainActivity, RequestClientIML clientIML, ArrayList<userlogin> arrayListul) {
        this.mainActivity = mainActivity;
        this.clientIML = clientIML;
        this.arrayListul = arrayListul;
    }
    public void getforlogin(String user, String password){
        clientIML.postloginAPI(user,password);
    }
}
