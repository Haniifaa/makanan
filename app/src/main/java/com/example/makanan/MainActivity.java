package com.example.makanan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<MenuModel> modelArrayList=new ArrayList<>();
    RecyclerView recyclerView_menu;
    int fotoMenu[]={R.drawable.menu1, R.drawable.menu2,
            R.drawable.menu3, R.drawable.menu4,
            R.drawable.menu5, R.drawable.menu6,
            R.drawable.menu7, R.drawable.menu8,
            R.drawable.menu9};

    String nmMenu[]={"Nasi Goreng","Soto Madura","Ayam Goreng",
            "Nasi Kuning","Nasi Rames", "Nasi Gudeg","Soto Kudus","Bubur Ayam","Bakso"};

    String hargaMenu[]={"18000","20000","18000","15000","12000","15000","18000","14000","17500"};

    String satMenu[]={"Piring","Mangkok","Ekor","Pincuk","Piring","Pincuk","Mangkok","Baskom","Mangkok"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView_menu=findViewById(R.id.recyclerviewmenu);
        bacaDataMenu();
        AdapterMenu adapterMenu=new AdapterMenu(modelArrayList,this);
        recyclerView_menu.setAdapter(adapterMenu);
        recyclerView_menu.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }

    private void bacaDataMenu(){
        for(int i=0; i<nmMenu.length;i++)
            modelArrayList.add(new MenuModel(nmMenu[i],hargaMenu[i],satMenu[i],fotoMenu[i]));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_pilihan,menu);

        return super.onCreateOptionsMenu(menu);
    }
}