package com.example.makanan.CLASS;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.makanan.ADAPTOR.AdapterFirebasePegawai;
import com.example.makanan.MODUL.ModelFirebasePegawai;
import com.example.makanan.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainFirebasePegawai extends AppCompatActivity {
    RecyclerView recyclerView_pegawai;
    DatabaseReference dbr;
    ArrayList<ModelFirebasePegawai> firebasePegawaiArrayList=new ArrayList<>();
    FloatingActionButton tmblinput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_firebase_pegawai);
        recyclerView_pegawai=findViewById(R.id.recyclerview_peg);

        dbr= FirebaseDatabase.getInstance().getReference();
        tampilkan_pegawai();
        recyclerView_pegawai.setLayoutManager(new LinearLayoutManager(this));
        tmblinput=findViewById(R.id.floatinginput);
        tmblinput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(view.getContext(),EntryDataPegawai.class);
                //startActivity(new Intent(RestAPIGuru.this,EntryDataGuru.class));
                view.getContext().startActivity(intent);
            }
        });
    }

    private void tampilkan_pegawai() {
        dbr.child("Pegawai").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                    ModelFirebasePegawai modelFirebasePegawai=dataSnapshot.getValue(ModelFirebasePegawai.class);
                    modelFirebasePegawai.setKey(dataSnapshot.getKey());
                    firebasePegawaiArrayList.add(modelFirebasePegawai);
                }
                AdapterFirebasePegawai afp=new AdapterFirebasePegawai(MainFirebasePegawai.this,firebasePegawaiArrayList);
                recyclerView_pegawai.setAdapter(afp);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}