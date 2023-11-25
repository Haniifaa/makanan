package com.example.makanan.CLASS;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.example.makanan.ADAPTOR.AdaptorGuru;
import com.example.makanan.API.KoneksiAPI;
import com.example.makanan.INTERFACE.InterfaceGuru;
import com.example.makanan.MODUL.ModulGuru;
import com.example.makanan.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RestAPIGuru extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<ModulGuru> guruArrayList=new ArrayList<>();
    InterfaceGuru interfaceGuru;
    KoneksiAPI koneksiAPI;
    FloatingActionButton tmblinput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest_apiguru);

        recyclerView=findViewById(R.id.recyclerviewGuru);

        interfaceGuru=KoneksiAPI.Koneksi().create(InterfaceGuru.class);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        tmblinput=findViewById(R.id.tombolinput);
        tmblinput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(view.getContext(),EntryDataGuru.class);
                //startActivity(new Intent(RestAPIGuru.this,EntryDataGuru.class));
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        Call<List<ModulGuru>> gurumuncul=interfaceGuru.tampilkanGuru();
        gurumuncul.enqueue(new Callback<List<ModulGuru>>() {
            @Override
            public void onResponse(Call<List<ModulGuru>> call, Response<List<ModulGuru>> response) {
                ArrayList<ModulGuru> guruArrayList=(ArrayList<ModulGuru>) response.body();
                AdaptorGuru adaptorGuru=new AdaptorGuru(guruArrayList);
                recyclerView.setAdapter(adaptorGuru);
            }

            @Override
            public void onFailure(Call<List<ModulGuru>> call, Throwable t) {
                Toast.makeText(RestAPIGuru.this, "Guru Tidak Mau tampil"+t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        super.onResume();
    }
}