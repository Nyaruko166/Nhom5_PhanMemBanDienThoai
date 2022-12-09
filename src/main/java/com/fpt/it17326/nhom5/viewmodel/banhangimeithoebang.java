/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.it17326.nhom5.viewmodel;

/**
 *
 * @author PHAM DAC THANG
 */
public class banhangimeithoebang {
    private int id;
    private String maimei,imei;

    public banhangimeithoebang() {
    }

    public banhangimeithoebang(int id, String maimei, String imei) {
        this.id = id;
        this.maimei = maimei;
        this.imei = imei;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaimei() {
        return maimei;
    }

    public void setMaimei(String maimei) {
        this.maimei = maimei;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    @Override
    public String toString() {
        return "banhangimei{" + "id=" + id + ", maimei=" + maimei + ", imei=" + imei + '}';
    }

    
    
}
