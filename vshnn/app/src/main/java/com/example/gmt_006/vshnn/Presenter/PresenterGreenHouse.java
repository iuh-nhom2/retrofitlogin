package com.example.gmt_006.vshnn.Presenter;

import android.widget.Toast;

import com.example.gmt_006.vshnn.Activity.GreenHouseMainActivity;
import com.example.gmt_006.vshnn.Activity.MainActivity;
import com.example.gmt_006.vshnn.Adapter.GrenHouseAdappter;
import com.example.gmt_006.vshnn.ListenerInterface.GetResultGreenHuose;
import com.example.gmt_006.vshnn.Model.GrenHouse;
import com.example.gmt_006.vshnn.Server.GetGreenHuoseIML;
import com.example.gmt_006.vshnn.Server.LoginClientIML;

import java.util.ArrayList;

public class PresenterGreenHouse {
    private GreenHouseMainActivity mainActivity;
    private GetGreenHuoseIML client;
    private ArrayList<GrenHouse> arrGreenHuose;
    private GrenHouseAdappter grenHouseAdappter;

    public PresenterGreenHouse(GreenHouseMainActivity greenHuoseActivity){
        arrGreenHuose=new ArrayList<>();
        client = new GetGreenHuoseIML(greenHuoseActivity);
        mainActivity = greenHuoseActivity;
        grenHouseAdappter= new GrenHouseAdappter(greenHuoseActivity,0,arrGreenHuose);


    }
    public void getListGreenhuose(String proince_id){
        client.getGreenHuoseProvince(proince_id, new GetResultGreenHuose() {
            @Override
            public void getSuccess(ArrayList<GrenHouse> arr) {
                    setData(arr);
            }

            @Override
            public void getFailed(String s) {
                Toast.makeText(mainActivity,s,Toast.LENGTH_LONG).show();
            }
        });
    }
    private void setData(ArrayList<GrenHouse> arrayList){
        arrGreenHuose.clear();
        arrGreenHuose.addAll(arrayList);
        grenHouseAdappter.notifyDataSetChanged();
    }

    public GrenHouseAdappter getGrenHouseAdappter() {
        return grenHouseAdappter;
    }
}
