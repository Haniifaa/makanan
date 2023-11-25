package com.example.makanan.CLASS;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.makanan.MODUL.ModelFirebasePegawai;
import com.example.makanan.MODUL.ModelPegawai;
import com.example.makanan.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class UpdatePegawai extends AppCompatActivity {
    EditText enip, enama, egaji;
    Button tombolupdate;
    DatabaseReference dbr;
    ModelPegawai modelPegawai;
    //ArrayList<ModelFirebasePegawai> firebasePegawaiArrayList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_pegawai);

        enip=findViewById(R.id.xnip);
        enama=findViewById(R.id.xnama);
        egaji=findViewById(R.id.xgaji);
        dbr= FirebaseDatabase.getInstance().getReference();
        modelPegawai=new ModelPegawai();
        Bundle bundle=getIntent().getExtras();


        enip.setText(bundle.getString("nipe"));
        enama.setText(bundle.getString("namane"));
        egaji.setText(bundle.getString("gajine"));
        tombolupdate=findViewById(R.id.btnupdate);

        tombolupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                modelPegawai.setNip(enip.getText().toString());
                modelPegawai.setNama_peg(enama.getText().toString());
                modelPegawai.setGaji(egaji.getText().toString());

                String kunci=(bundle.getString("kuncine"));
                dbr.child("Pegawai")
                        .child(kunci)
                        .setValue(modelPegawai)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(UpdatePegawai.this, "Update Sukses!",Toast.LENGTH_LONG).show();
                            }
                        });
            }
        });




        //



    }
}