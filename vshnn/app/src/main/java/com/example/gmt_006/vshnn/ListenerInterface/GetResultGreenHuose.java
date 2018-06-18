package com.example.gmt_006.vshnn.ListenerInterface;

import com.example.gmt_006.vshnn.Model.GrenHouse;

import java.util.ArrayList;

public interface GetResultGreenHuose {
    void getSuccess(ArrayList<GrenHouse> arr);
    void getFailed(String s);
}
