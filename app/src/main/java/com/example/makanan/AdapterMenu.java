package com.example.makanan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterMenu extends RecyclerView.Adapter<AdapterMenu.myViewHolder> {
    ArrayList<MenuModel> modelArrayList;
    Context context;

    public AdapterMenu(ArrayList<MenuModel> modelArrayList, Context context) {
        this.modelArrayList = modelArrayList;
        this.context = context;
    }

    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.format_menu,parent,false);

        return new AdapterMenu.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.cnamaMenu.setText(modelArrayList.get(position).namamenu);
        holder.chargaMenu.setText(modelArrayList.get(position).hargamenu);
        holder.csatuanMenu.setText(modelArrayList.get(position).satuanmenu);
        holder.gambarMenu.setImageResource(modelArrayList.get(position).gambarmenu);
    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView cnamaMenu, chargaMenu,csatuanMenu;
        ImageView gambarMenu;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            cnamaMenu=itemView.findViewById(R.id.nm_menu);
            chargaMenu=itemView.findViewById(R.id.harga_menu);
            csatuanMenu=itemView.findViewById(R.id.sat_menu);
            gambarMenu=itemView.findViewById(R.id.foto_menu);

        }
    }
}

