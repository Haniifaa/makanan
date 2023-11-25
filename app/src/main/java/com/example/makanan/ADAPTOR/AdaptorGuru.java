package com.example.makanan.ADAPTOR;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.makanan.MODUL.ModulGuru;
import com.example.makanan.R;

import java.util.ArrayList;

public class AdaptorGuru extends RecyclerView.Adapter<AdaptorGuru.myViewHolder> {

    ArrayList<ModulGuru> guruArrayList;
    public AdaptorGuru(ArrayList<ModulGuru> guruArrayList){
        this.guruArrayList=guruArrayList;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.format_data_guru,parent, false);

        return new AdaptorGuru.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
      holder.cnip.setText(guruArrayList.get(position).getNip());
      holder.cnama.setText(guruArrayList.get(position).getNama_guru());
      holder.cstatus.setText(guruArrayList.get(position).getStatus());
    }

    @Override
    public int getItemCount() {
        return guruArrayList.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView cnip,cnama,cstatus;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            cnip=itemView.findViewById(R.id.nipguru);
            cnama=itemView.findViewById(R.id.namaguru);
            cstatus=itemView.findViewById(R.id.statusguru);
        }
    }
}
