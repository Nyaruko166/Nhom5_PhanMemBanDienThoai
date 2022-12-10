/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.it17326.nhom5.viewmodel;

/**
 *
 * @author youngboizseetinh
 */
public class xuathoadon {
    public  String mahd,hoten,sdt,diachi,ngaythanhtoan,tensp,thongtinsp;
            public int solg;
        public double dongia;
          public  double thanhtien;

    public xuathoadon() {
    }

    public xuathoadon(String mahd, String hoten, String sdt, String diachi, String ngaythanhtoan, String tensp, String thongtinsp, int solg, double dongia, double thanhtien) {
        this.mahd = mahd;
        this.hoten = hoten;
        this.sdt = sdt;
        this.diachi = diachi;
        this.ngaythanhtoan = ngaythanhtoan;
        this.tensp = tensp;
        this.thongtinsp = thongtinsp;
        this.solg = solg;
        this.dongia = dongia;
        this.thanhtien = thanhtien;
    }

    public String getMahd() {
        return mahd;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getNgaythanhtoan() {
        return ngaythanhtoan;
    }

    public void setNgaythanhtoan(String ngaythanhtoan) {
        this.ngaythanhtoan = ngaythanhtoan;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getThongtinsp() {
        return thongtinsp;
    }

    public void setThongtinsp(String thongtinsp) {
        this.thongtinsp = thongtinsp;
    }

    public int getSolg() {
        return solg;
    }

    public void setSolg(int solg) {
        this.solg = solg;
    }

    public double getDongia() {
        return dongia;
    }

    public void setDongia(double dongia) {
        this.dongia = dongia;
    }

    public double getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(double thanhtien) {
        this.thanhtien = thanhtien;
    }

    @Override
    public String toString() {
        return "xuathoadon{" + "mahd=" + mahd + ", hoten=" + hoten + ", sdt=" + sdt + ", diachi=" + diachi + ", ngaythanhtoan=" + ngaythanhtoan + ", tensp=" + tensp + ", thongtinsp=" + thongtinsp + ", solg=" + solg + ", dongia=" + dongia + ", thanhtien=" + thanhtien + '}';
    }
}
