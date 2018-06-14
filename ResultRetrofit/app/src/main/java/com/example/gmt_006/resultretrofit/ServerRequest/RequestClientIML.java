package com.example.gmt_006.resultretrofit.ServerRequest;

import android.app.Activity;
import android.util.Log;

import com.example.gmt_006.resultretrofit.APIUtils.AppConstant;
import com.example.gmt_006.resultretrofit.Activity.MainActivity;
import com.example.gmt_006.resultretrofit.model.userlogin;

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

public class RequestClientIML {
    private static RequestClientIML instance;
    private RequestClient client;
    private Activity mainActivity;
    private Retrofit retrofit;

    public RequestClientIML(Activity ac) {
        retrofit = new Retrofit.Builder().baseUrl(AppConstant.ServerUrl).build();
        this.mainActivity =ac;
    }

    public static RequestClientIML getInstance(Activity at){
        if(instance == null){
            instance = new RequestClientIML(at);
        }
        return instance;
    }
    public void postloginAPI(String email, String password){
        OkHttpClient.Builder httpclient= new OkHttpClient.Builder();
        httpclient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                Request request = original.newBuilder()
                                    .header(AppConstant.Authorization,AppConstant.Base)
                                    .method(original.method(),original.body()).build();
                return chain.proceed(request);
            }
        });
        Retrofit.Builder builder = new Retrofit.Builder().baseUrl(AppConstant.ServerUrl).client(httpclient.build())
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();
        RequestClient  client = retrofit.create(RequestClient.class);
        Call<ResponseBody> calllogin =client.postlogin(email,password);
        calllogin.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                try {
                    String s = response.body().string();
                    JSONObject object = new JSONObject();
                    String data = object.getString("msg");
                    int status = Integer.parseInt(object.getString("status"));
                    if(status==200){
                        JSONArray arr= new JSONArray();
                        ArrayList<userlogin> ret = userlogin.getforlogin(arr);
                        ret.size();
                        Log.d("token",ret.get(0).getToken());
                    }else{
                        Log.d("Error","Failed");
                    }
                } catch (IOException e) {
                    e.printStackTrace();

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                    Log.d("Error",t.getMessage());
            }
        });

    }

}
