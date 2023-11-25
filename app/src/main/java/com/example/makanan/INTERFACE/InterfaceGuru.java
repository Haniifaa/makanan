package com.example.makanan.INTERFACE;

import com.example.makanan.MODUL.ModulGuru;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface InterfaceGuru {
    @GET("guru/")
    Call<List<ModulGuru>> tampilkanGuru();
    @POST("guru/")
    Call<ModulGuru> simpanGuru(@Field("nip") String nip,
                               @Field("nama_guru") String nama_guru,
                               @Field("status") String status);

}
