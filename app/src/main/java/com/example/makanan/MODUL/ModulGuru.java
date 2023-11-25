package com.example.makanan.MODUL;

public class ModulGuru {
    String nip,nama_guru,status;

    public ModulGuru(String nip, String nama_guru, String status) {
        this.nip = nip;
        this.nama_guru = nama_guru;
        this.status = status;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNama_guru() {
        return nama_guru;
    }

    public void setNama_guru(String nama_guru) {
        this.nama_guru = nama_guru;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
