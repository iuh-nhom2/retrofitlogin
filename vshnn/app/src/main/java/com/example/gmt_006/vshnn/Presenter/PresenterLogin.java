package com.example.gmt_006.vshnn.Presenter;

import android.content.Intent;
import android.widget.Toast;

import com.example.gmt_006.vshnn.Activity.GreenHouseMainActivity;
import com.example.gmt_006.vshnn.Activity.MainActivity;
import com.example.gmt_006.vshnn.ListenerInterface.OnPostResultLogin;
import com.example.gmt_006.vshnn.Model.Userlogin;
import com.example.gmt_006.vshnn.Server.LoginClientIML;

import java.util.ArrayList;

public class PresenterLogin {
    private MainActivity mActivity;
    private LoginClientIML client;
    private ArrayList<Userlogin> arrUserLogin;

    ArrayList<Userlogin> arrayList;



    public PresenterLogin(MainActivity mainActivity){
        arrUserLogin = new ArrayList<>();
        client = LoginClientIML.getInstance(mainActivity);
        mActivity = mainActivity;



    }
    public void getLogin(String email, String pass){
        client.getLoginUser(email, pass, new OnPostResultLogin() {
            @Override
            public void LoginSuccess() {
//                Log.d("token:",arrayList.get(0).getToken());
//                setData(arrayList);
//                Log.d("token:",arrayList.get(0).getToken());
//                Toast.makeText(mActivity,"hello",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(mActivity,GreenHouseMainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mActivity.startActivity(intent);

            }

            @Override
            public void LoginFailed(String s) {
                Toast.makeText(mActivity,s,Toast.LENGTH_LONG).show();


            }
        });

    }
    private void setData(ArrayList<Userlogin> arr) {
        arr.clear();
        arr.addAll(arr);


    }
}
