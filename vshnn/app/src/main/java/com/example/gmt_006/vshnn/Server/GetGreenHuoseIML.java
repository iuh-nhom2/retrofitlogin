package com.example.gmt_006.vshnn.Server;

import android.app.Activity;
import android.util.Log;

import com.example.gmt_006.vshnn.APIUltis.ApiConstant;
import com.example.gmt_006.vshnn.ListenerInterface.GetResultGreenHuose;
import com.example.gmt_006.vshnn.Model.GrenHouse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetGreenHuoseIML {
    private static GetGreenHuoseIML instance;
    private Activity mainActivity;
    private Retrofit retrofit;

    public GetGreenHuoseIML(Activity ac) {
        retrofit = new Retrofit.Builder().baseUrl(ApiConstant.ServerURL).build();
        this.mainActivity =ac;
    }

    public static GetGreenHuoseIML getInstance(Activity at){
        if(instance == null){
            instance = new GetGreenHuoseIML(at);
        }
        return instance;
    }
    public void getGreenHuoseProvince (final String ProvinceId, final GetResultGreenHuose callback){
        OkHttpClient.Builder httpclient = new OkHttpClient.Builder();
        httpclient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                Request request = original.newBuilder().header(ApiConstant.Authorization,ApiConstant.Base)
                                    .header(ApiConstant.Authorization2,ApiConstant.ILYRA+LoginClientIML.token)
                                        .method(original.method(),original.body())
                                            .build();


                return chain.proceed(request);
            }
        });
        Retrofit.Builder builder =  new Retrofit.Builder().baseUrl(ApiConstant.ServerURL)
                                        .client(httpclient.build()).addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();
        LoginClient client = retrofit.create(LoginClient.class);
        Call<ResponseBody> ret =client.getGreenHouseProvince(ProvinceId);
        ret.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                try {
                    String s = response.body().string();
                    JSONObject object= new JSONObject(s);
                    String data  = object.getString("msg");
                    int status = Integer.parseInt(object.getString("status"));
                    if(status==200){
                        JSONArray array =  new JSONArray(data);
                        ArrayList<GrenHouse> ret = GrenHouse.getGreenHouseProvince(array);
                        ret.size();
                        callback.getSuccess(ret);

                    }
                    else if(status==400){
                        callback.getFailed("Error");
                    }
                    else{
                        callback.getFailed("Error");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("Error:",t.getMessage());
            }
        });
    }
}
