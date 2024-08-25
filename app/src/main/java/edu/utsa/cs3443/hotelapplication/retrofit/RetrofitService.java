package edu.utsa.cs3443.hotelapplication.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitService {
    public static Retrofit retrofit= null;

    public RetrofitService(){
        initRetrofit();

    }

    public static Retrofit initRetrofit(){


        Gson gson= new GsonBuilder().setLenient().create();

        OkHttpClient client= new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor())
                .build();

        if(retrofit == null){
            retrofit= new Retrofit.Builder()
                    .baseUrl("http://192.168.1.112:8080")
                    .client(client)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
   }

   public static Retrofit getRetrofit(){
       return retrofit;
   }

}
