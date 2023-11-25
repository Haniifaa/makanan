package com.example.makanan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.makanan.CLASS.EntryDataGuru;
import com.example.makanan.CLASS.EntryDataPegawai;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
    }
    public void tampildata(View view) {
        Intent intent=new Intent(Dashboard.this, baca_sqlite.class);
        startActivity(intent);
    }
    public void entrydata(View view)
    {
        Intent intent=new Intent(Dashboard.this, Entry_data_barang.class);
        startActivity(intent);
    }
    public void cetakdata(View view){
        Intent intent=new Intent(Dashboard.this, baca_sqlite.class);
        startActivity(intent);
    }

}