package com.example.makanan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class baca_sqlite extends AppCompatActivity {
    TextView ipk,totsks,jmlmatkul;
    Button btnmasuk;
    RecyclerView recyclerView_barang;
    ArrayList<ModelBarang> barangArrayList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baca_sqlite);
        databasehelper db= new databasehelper(this);
        btnmasuk=findViewById(R.id.tombolmasuk);
        recyclerView_barang=findViewById(R.id.recyclerviewbrg);

        Cursor cursor = db.baca_data();

        cursor.moveToFirst();
        while (cursor.moveToNext()){
            barangArrayList.add(new ModelBarang(cursor.getString(0),
                                                cursor.getString(1),
                                                cursor.getString(2),
                                                cursor.getString(3),
                                                cursor.getString(4),
                                                cursor.getString(5)));
        }
        AdapterBarang adapterBarang=new AdapterBarang(this, barangArrayList);
        recyclerView_barang.setAdapter(adapterBarang);
        recyclerView_barang.setLayoutManager(new LinearLayoutManager(this));

    ipk=findViewById(R.id.ipk);
    totsks=findViewById(R.id.totsks);
    jmlmatkul=findViewById(R.id.jmlmatkul);




        btnmasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(baca_sqlite.this, Entry_data_barang.class);
                startActivity(intent);
            }
        });
    }
}