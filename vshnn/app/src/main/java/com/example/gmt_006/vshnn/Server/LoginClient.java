package com.example.gmt_006.vshnn.Server;

import com.example.gmt_006.vshnn.APIUltis.ApiConstant;
import com.example.gmt_006.vshnn.Model.Userlogin;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface LoginClient {

    @FormUrlEncoded
    @POST(ApiConstant.ServerURL+ApiConstant.getLogin)
    Call<ResponseBody> getuserlogin(@Field("email") String email,
                                       @Field("password")String password);
}
