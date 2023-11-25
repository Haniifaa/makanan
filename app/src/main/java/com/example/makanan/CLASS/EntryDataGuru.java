package com.example.makanan.CLASS;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.makanan.R;

public class EntryDataGuru extends AppCompatActivity implements View.OnClickListener {
    EditText ednip,ednama,edstatus;
    Button btnsimpan,btnview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_data_guru);
        ednip=findViewById(R.id.nipguru);
        ednama=findViewById(R.id.namaguru);
        edstatus=findViewById(R.id.statusguru);

        btnsimpan=findViewById(R.id.tombolsave);
        btnview=findViewById(R.id.tombolview);

        btnsimpan.setOnClickListener(this);
        btnview.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.tombolsave)
        {
            //save
        }else
        {
            //view
        }
    }
}