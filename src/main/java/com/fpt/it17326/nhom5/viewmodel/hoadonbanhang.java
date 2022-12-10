/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.it17326.nhom5.viewmodel;

/**
 *
 * @author PHAM DAC THANG
 */
public class hoadonbanhang {
    private String 	MaHD ;
   private String	
	HoTennv ;
    private String	
	HoTenkh ;
      private int trangthai,id,idkh;
private String ngaytaovaban;
private  double tongtien;
    public hoadonbanhang() {
    }

    public hoadonbanhang(String MaHD, String HoTennv, String HoTenkh, int trangthai, int id, int idkh, String ngaytaovaban, double tongtien) {
        this.MaHD = MaHD;
        this.HoTennv = HoTennv;
        this.HoTenkh = HoTenkh;
        this.trangthai = trangthai;
        this.id = id;
        this.idkh = idkh;
        this.ngaytaovaban = ngaytaovaban;
        this.tongtien = tongtien;
    }

    public double getTongtien() {
        return tongtien;
    }

    public void setTongtien(double tongtien) {
        this.tongtien = tongtien;
    }

    public String getNgaytaovaban() {
        return ngaytaovaban;
    }

    public void setNgaytaovaban(String ngaytaovaban) {
        this.ngaytaovaban = ngaytaovaban;
    }

 

 

    public int getId() {
        return id;
    }

    public int getIdkh() {
        return idkh;
    }

    public void setIdkh(int idkh) {
        this.idkh = idkh;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public String getHoTennv() {
        return HoTennv;
    }

    public void setHoTennv(String HoTennv) {
        this.HoTennv = HoTennv;
    }

    public String getHoTenkh() {
        return HoTenkh;
    }

    public void setHoTenkh(String HoTenkh) {
        this.HoTenkh = HoTenkh;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

    @Override
    public String toString() {
        return "hoadonbanhang{" + "MaHD=" + MaHD + ", HoTennv=" + HoTennv + ", HoTenkh=" + HoTenkh + ", trangthai=" + trangthai + '}';
    }
    
    
}
