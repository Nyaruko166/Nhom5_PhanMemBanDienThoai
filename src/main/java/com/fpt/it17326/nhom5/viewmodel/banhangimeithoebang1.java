/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.it17326.nhom5.viewmodel;

/**
 *
 * @author PHAM DAC THANG
 */
public class banhangimeithoebang1 {
    private int id;
    private String maimei,imei;
private  int idhdct;
    public banhangimeithoebang1() {
    }

    public banhangimeithoebang1(int id, String maimei, String imei, int idhdct) {
        this.id = id;
        this.maimei = maimei;
        this.imei = imei;
        this.idhdct = idhdct;
    }

    public int getIdhdct() {
        return idhdct;
    }

    public void setIdhdct(int idhdct) {
        this.idhdct = idhdct;
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
