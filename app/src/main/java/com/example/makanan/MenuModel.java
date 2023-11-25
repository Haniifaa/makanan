package com.example.makanan;

public class MenuModel {
    String namamenu;
    String hargamenu;
    String satuanmenu;
    int gambarmenu;

    public MenuModel(String namamenu, String hargamenu, String satuanmenu, int gambarmenu) {
        this.namamenu = namamenu;
        this.hargamenu = hargamenu;
        this.satuanmenu = satuanmenu;
        this.gambarmenu = gambarmenu;
    }

    public String getNamamenu() {
        return namamenu;
    }

    public void setNamamenu(String namamenu) {
        this.namamenu = namamenu;
    }

    public String getHargamenu() {
        return hargamenu;
    }

    public void setHargamenu(String hargamenu) {
        this.hargamenu = hargamenu;
    }

    public String getSatuanmenu() {
        return satuanmenu;
    }

    public void setSatuanmenu(String satuanmenu) {
        this.satuanmenu = satuanmenu;
    }

    public int getGambarmenu() {
        return gambarmenu;
    }

    public void setGambarmenu(int gambarmenu) {
        this.gambarmenu = gambarmenu;
    }
}
