/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.it17326.nhom5.viewmodel;

/**
 *
 * @author PHAM DAC THANG
 */
public class khachhangbanhang1 {
    private int id;
    private String makh,tenkh,sdt;

    public khachhangbanhang1() {
    }

    public khachhangbanhang1(int id, String makh, String tenkh, String sdt) {
        this.id = id;
        this.makh = makh;
        this.tenkh = tenkh;
        this.sdt = sdt;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMakh() {
        return makh;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public String getTenkh() {
        return tenkh;
    }

    public void setTenkh(String tenkh) {
        this.tenkh = tenkh;
    }

    @Override
    public String toString() {
        return  makh + "-" + tenkh ;
    }
    
}
