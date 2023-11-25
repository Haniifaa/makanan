package com.example.makanan.CLASS;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.makanan.MODUL.ModelPegawai;
import com.example.makanan.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EntryDataPegawai extends AppCompatActivity implements View.OnClickListener {
    EditText ednip,ednama,edgaji;
    Button tombolsimpan, tombolview;
    DatabaseReference dbr;
    ModelPegawai modelPegawai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_data_pegawai);

        ednip=findViewById(R.id.nippeg);
        ednama=findViewById(R.id.namapeg);
        edgaji=findViewById(R.id.gajipeg);

        tombolsimpan=findViewById(R.id.btnsave);
        tombolsimpan.setOnClickListener(this);
        tombolview=findViewById(R.id.btnview);
        tombolview.setOnClickListener(this);
        modelPegawai=new ModelPegawai();
        dbr= FirebaseDatabase.getInstance().getReference().child("Pegawai");

    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.btnsave)
        {
            //simpan
            modelPegawai.setNip(ednip.getText().toString());
            modelPegawai.setNama_peg(ednama.getText().toString());
            modelPegawai.setGaji(edgaji.getText().toString());
            dbr.push().setValue(modelPegawai);
            Toast.makeText(this, "Data berhasil masuk ke Firebase", Toast.LENGTH_SHORT).show();
        }
        else
        {
            //startActivity(new Intent(EntryDataPegawai.this,RecyclerViewPeg.class));
        }
    }
}