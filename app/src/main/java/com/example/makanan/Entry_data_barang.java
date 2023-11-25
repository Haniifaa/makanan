package com.example.makanan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Entry_data_barang extends AppCompatActivity {
    EditText kode_brg, nama_brg, st_brg, hg_brg, kota_brg, predikat;
    Button btnsave, btnview;
    databasehelper db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_data_barang);

        kode_brg=findViewById(R.id.kode);
        nama_brg=findViewById(R.id.nama);
        st_brg=findViewById(R.id.satuan);
        hg_brg=findViewById(R.id.harga);
        kota_brg=findViewById(R.id.kota);
        predikat=findViewById(R.id.predikat);
        btnsave=findViewById(R.id.kirim);
        btnview=findViewById(R.id.batal);
        db=new databasehelper(this);


        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String xkode= kode_brg.getText().toString();
                String xnama=nama_brg.getText().toString();
                String xsatuan=st_brg.getText().toString();
                String xharga=hg_brg.getText().toString();
                String xkota=kota_brg.getText().toString();
                String xpredikat=predikat.getText().toString();
                db.input_data(xkode, xnama, xsatuan, xharga, xkota, xpredikat);
                boolean hasil= db.input_data(xkode, xnama, xsatuan, xharga, xkota, xpredikat);
                if(hasil)
                {
                    Toast.makeText(Entry_data_barang.this, "Data Tersimpan", Toast.LENGTH_SHORT).show();
                }
            }
        });


        hg_brg.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                float na;
                String nh,np;
                if (hg_brg.getText().toString().isEmpty()) {
                    na=0;
                } else {

                }
                na = Float.parseFloat(hg_brg.getText().toString());
                //hg_brg.setText(Float.toString(na));

                if (na >= 85) {
                    nh = "A"; np = "Istimewa";
                } else if (na >= 80) {
                    nh = "AB"; np = "Sangat Baik";
                } else if (na >= 70) {
                    nh = "B"; np = "Baik";
                } else if (na >= 65) {
                    nh = "BC"; np = "Cukup Baik";
                } else if (na >= 60) {
                    nh = "C"; np = "Cukup";
                } else if (na >= 40) {
                    nh = "D"; np = "Kurang";
                } else {
                    nh = "E"; np = "Sangat Kurang";
                }
                kota_brg.setText(nh);
                predikat.setText(np);


            }
        });


    }
}