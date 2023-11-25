package com.example.makanan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;

public class detail_menu_makanan extends AppCompatActivity {
    TextView namamenu, hrgmenu, satmenu, totmenu;
    ImageView gambarnya;
    EditText jmlpesan;

    int gambare;
    String xnama="namamenu";
    String tnama;
    String xharga="hargamenu";
    String tharga;
    String xsatuan="satuanmenu";
    String tsatuan;
    String xtotal="totalmenu";
    String ttotal;
    private Array bundle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_menu_makanan);

        gambarnya=findViewById(R.id.foto_menu);

        Bundle bundle=getIntent().getExtras();

        gambare=bundle.getInt(String.valueOf("gambare"));
        gambarnya.setImageResource(gambare);

        namamenu=findViewById(R.id.nm_menu);
        tnama=bundle.getString(xnama);
        namamenu.setText(tnama);

        hrgmenu=findViewById(R.id.harga_menu);
        tharga=bundle.getString(xharga);
        hrgmenu.setText(tharga);

        satmenu=findViewById(R.id.sat_menu);
        tsatuan=bundle.getString(xsatuan);
        satmenu.setText(tsatuan);

        totmenu=findViewById(R.id.total_pesan);
        ttotal=bundle.getString(xtotal);
        totmenu.setText(ttotal);

        jmlpesan=findViewById(R.id.jml_pesan);
        jmlpesan.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void afterTextChanged(Editable editable) {
                totmenu=findViewById(R.id.total_pesan);
                int total,jml=0,harga=0;
                if(!jmlpesan.getText().toString().isEmpty()){
                    jml= Integer.parseInt(jmlpesan.getText().toString());
                    harga=Integer.parseInt(hrgmenu.getText().toString());
                }

                total=(int)(jml*harga);
                totmenu.setText(Integer.toString(total));
            }
        });

    }
}