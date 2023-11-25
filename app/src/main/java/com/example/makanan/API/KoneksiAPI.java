package com.example.makanan.API;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class KoneksiAPI {
    public static final String url_base="http://192.168.10.253/~a112113820/";
    public static Retrofit retrofit;

    //static tidak perlu membuat objeknya
    public static Retrofit Koneksi()
    {
        if(retrofit==null)
        {
            retrofit=new Retrofit.Builder()
                    .baseUrl(url_base)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
