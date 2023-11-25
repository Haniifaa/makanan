package com.example.makanan.ADAPTOR;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.makanan.CLASS.MainFirebasePegawai;
import com.example.makanan.CLASS.UpdatePegawai;
import com.example.makanan.MODUL.ModelFirebasePegawai;
import com.example.makanan.R;
import com.example.makanan.UpdateBarang;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class AdapterFirebasePegawai extends RecyclerView.Adapter<AdapterFirebasePegawai.myviewholder> {
    Activity activity;
    ArrayList<ModelFirebasePegawai> firebasePegawaiArrayList;
    DatabaseReference dbr;

    public AdapterFirebasePegawai(Activity activity, ArrayList<ModelFirebasePegawai> firebasePegawaiArrayList) {
        this.activity = activity;
        this.firebasePegawaiArrayList = firebasePegawaiArrayList;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(activity);
        View view=inflater.inflate(R.layout.format_firebase_pegawai,parent, false);

        return new AdapterFirebasePegawai.myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.cnip.setText(firebasePegawaiArrayList.get(position).getNip());
        holder.cnama.setText(firebasePegawaiArrayList.get(position).getNama_peg());
        holder.cgaji.setText(firebasePegawaiArrayList.get(position).getGaji());
        holder.card01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(view.getContext(), UpdatePegawai.class);
                intent.putExtra("kuncine",firebasePegawaiArrayList.get(holder.getAdapterPosition()).getKey());
                intent.putExtra("nipe",firebasePegawaiArrayList.get(holder.getAdapterPosition()).getNip());
                intent.putExtra("namane",firebasePegawaiArrayList.get(holder.getAdapterPosition()).getNama_peg());
                intent.putExtra("gajine",firebasePegawaiArrayList.get(holder.getAdapterPosition()).getGaji());
                view.getContext().startActivity(intent);
                return;
            }
        });
        holder.deletepegawai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(activity);
                //Toast.makeText(activity, "Cari Error"+firebasePegawaiArrayList.g, Toast.LENGTH_SHORT).show();
                builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dbr= FirebaseDatabase.getInstance().getReference();
                        dbr.child("Pegawai").child(firebasePegawaiArrayList.get(position).getKey()).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(activity, "Hapus Berhasil", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(activity,MainFirebasePegawai.class);
                                activity.startActivity(intent);
                            }
                        });

                    }
                }).setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                }).setMessage("Apakah Data ini akan dihapus?"+firebasePegawaiArrayList.get(position).getNama_peg());
                builder.show();
            }

        });
    }

    @Override
    public int getItemCount() {
        return firebasePegawaiArrayList.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder {
        TextView cnip,cnama,cgaji;
        ImageView deletepegawai;
        CardView card01;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            cnip=itemView.findViewById(R.id.nippegawai);
            cnama=itemView.findViewById(R.id.namapegawai);
            cgaji=itemView.findViewById(R.id.gajipegawai);
            deletepegawai=itemView.findViewById(R.id.hapuspegawai);
            card01=itemView.findViewById(R.id.cardview_pegawai);
        }
    }
}
