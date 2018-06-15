package com.example.gmt_006.vshnn.Server;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.example.gmt_006.vshnn.APIUltis.ApiConstant;
import com.example.gmt_006.vshnn.Activity.GreenHouseMainActivity;
import com.example.gmt_006.vshnn.Activity.MainActivity;
import com.example.gmt_006.vshnn.ListenerInterface.OnPostResultLogin;
import com.example.gmt_006.vshnn.Model.Userlogin;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginClientIML {
    private static LoginClientIML instance;
    private LoginClient client;
    private Activity mainActivity;
    private Retrofit retrofit;
    MainActivity main;

    public LoginClientIML(Activity ac) {
        retrofit = new Retrofit.Builder().baseUrl(ApiConstant.ServerURL).build();
        this.mainActivity = ac;
    }

    public static  LoginClientIML getInstance(Activity at){
        if(instance == null){
            instance = new LoginClientIML(at);
        }
        return instance;
    }
    public void getLoginUser(String email, String pass, final OnPostResultLogin callback ){
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                Request request =original.newBuilder()
                                    .header(ApiConstant.Authorization,ApiConstant.Base)
                                    .method(original.method(),original.body())
                                    .build();

                return chain.proceed(request);
            }
        });
        Retrofit.Builder builder = new Retrofit.Builder().baseUrl(ApiConstant.ServerURL)
                                        .client(httpClient.build())
                                            .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();
        LoginClient client = retrofit.create(LoginClient.class);
        Call<ResponseBody> ret = client.getuserlogin(email,pass);
        ret.enqueue(new Callback<ResponseBody>() {


            @Override
            public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                try {
                    String s=response.body().string();
                    JSONObject object=new JSONObject(s);
                    String data=object.getString("msg");


                    int status= Integer.parseInt(object.getString("status"));
                    if(status==200)
                    {
                        String token = object.getString("token");
                        Log.d("Token",token);
                        Log.d("Message:",data);
                        Log.d("Login:","Login succes");
                        Toast.makeText(mainActivity,"Login success",Toast.LENGTH_LONG).show();


//                        JSONArray arr = new JSONArray(data);
//                        ArrayList<Userlogin> ret = Userlogin.getinforUserLogin(arr);
//                        ret.size();
//                        callback.LoginSuccess(ret);
//                        Log.d("Token:",ret.get(0).getToken());
//                        callback.LoginSuccess(ret);

                    }
                    else if(status==400)
                    {
                        callback.LoginFailed("Login Failed");
//                        Toast.makeText(mainActivity,"Login Failed",Toast.LENGTH_LONG).show();

                    }
                    else
                    {
                        callback.LoginFailed("Login Failed");

                    }

                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                    Log.d("Responsebody error:",t.getMessage());
            }
        });

    }


}
