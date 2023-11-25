package com.example.makanan;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class databasehelper extends SQLiteOpenHelper {

    public final static String NAMA_DATABASE="STOK_BARANG";
    public final static String NAMA_TABEL="barang";

    public final static String field01="kode";
    public final static String field02="nama_brg";
    public final static String field03="satuan";
    public final static String field04="harga";
    public final static String field05="kota";
    public final static String field06="predikat";


    public databasehelper(Context context) {
        super(context, NAMA_DATABASE,null, 1);
        SQLiteDatabase db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+NAMA_TABEL+"(kode primary key, nama_brg text, satuan text, harga text, kota text, predikat text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+NAMA_TABEL);
        onCreate(db);
    }

    public boolean input_data(String xkode, String xnama, String xsatuan, String xharga, String xkota, String xpredikat) {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(field01, xkode);
        contentValues.put(field02, xnama);
        contentValues.put(field03, xsatuan);
        contentValues.put(field04, xharga);
        contentValues.put(field05, xkota);
        contentValues.put(field06, xpredikat);
        db.insert(NAMA_TABEL, null,contentValues);
        return true;
    }

    public Cursor baca_data() {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cur=db.rawQuery("select * from "+NAMA_TABEL, null);
        return cur;
    }

    public boolean Update_data(String xkode, String xnama, String xsatuan, String xharga, String xkota, String xpredikat) {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(field01, String.valueOf(xkode));
        contentValues.put(field02, String.valueOf(xnama));
        contentValues.put(field03, String.valueOf(xsatuan));
        contentValues.put(field04, String.valueOf(xharga));
        contentValues.put(field05, String.valueOf(xkota));
        contentValues.put(field06, String.valueOf(xpredikat));
        long jadi=db.update(NAMA_TABEL, contentValues, field01+"=?", new String[]{String.valueOf(xkode)});
        if(jadi>0)
        {
            return true;
        }
        else
        {
            return false;
        }

    }

    public boolean hapus_databarang(String xkode) {
        SQLiteDatabase db=this.getWritableDatabase();
        long hasile=db.delete(NAMA_TABEL, "kode=?", new String[]{xkode});
        if(hasile<0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }


}






