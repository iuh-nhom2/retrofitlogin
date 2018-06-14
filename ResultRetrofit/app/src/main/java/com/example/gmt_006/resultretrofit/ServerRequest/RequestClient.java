package com.example.gmt_006.resultretrofit.ServerRequest;

import com.example.gmt_006.resultretrofit.APIUtils.AppConstant;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.GET;

public interface RequestClient {

    @GET(AppConstant.ServerUrl+AppConstant.postLogin)
    Call<ResponseBody> postlogin(@Field("email") String email,
                                 @Field("password") String password);
}
