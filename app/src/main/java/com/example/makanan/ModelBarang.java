package com.example.makanan;

public class ModelBarang {
    String kode;
    String nama_barang;
    String satuan;
    String harga;
    String kota;
    String predikat;

    public ModelBarang(String kode, String nama_barang, String satuan, String harga, String kota, String predikat) {
        this.kode = kode;
        this.nama_barang = nama_barang;
        this.satuan = satuan;
        this.harga = harga;
        this.kota = kota;
        this.predikat = predikat;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public String getPredikat() {
        return predikat;
    }

    public void setPredikat(String predikat) {
        this.predikat = predikat;
    }
}
