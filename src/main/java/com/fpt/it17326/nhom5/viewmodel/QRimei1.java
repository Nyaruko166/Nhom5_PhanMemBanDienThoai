/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.it17326.nhom5.viewmodel;

/**
 *
 * @author PHAM DAC THANG
 */
public class QRimei1 {
   public String maimei,masp;
   public  int trangthaai,idsp;
   public String tensp;
   public  int dongia;
   public  String imei;
    public QRimei1() {
    }

    public QRimei1(String maimei, String masp, int trangthaai, int idsp, String tensp, int dongia, String imei) {
        this.maimei = maimei;
        this.masp = masp;
        this.trangthaai = trangthaai;
        this.idsp = idsp;
        this.tensp = tensp;
        this.dongia = dongia;
        this.imei = imei;
    }

   

    public int getIdsp() {
        return idsp;
    }

    public void setIdsp(int idsp) {
        this.idsp = idsp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public int getDongia() {
        return dongia;
    }

    public void setDongia(int dongia) {
        this.dongia = dongia;
    }

 

    public String getMaimei() {
        return maimei;
    }

    public void setMaimei(String maimei) {
        this.maimei = maimei;
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public int getTrangthaai() {
        return trangthaai;
    }

    public void setTrangthaai(int trangthaai) {
        this.trangthaai = trangthaai;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    

  
  
}
