/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.it17326.nhom5.viewmodel;

/**
 *
 * @author PHAM DAC THANG
 */
public class sanphambanhang1 {
  private String masp,tensp,pin,chip,rom,hangdienthoai,ram;
  private int soluong;
  private float dongia;
  private int id;
  private int idhdct;

    public sanphambanhang1() {
    }

    public sanphambanhang1(String masp, String tensp, String pin, String chip, String rom, String hangdienthoai, String ram, int soluong, float dongia,int id) {
        this.masp = masp;
        this.tensp = tensp;
        this.pin = pin;
        this.chip = chip;
        this.rom = rom;
        this.hangdienthoai = hangdienthoai;
        this.ram = ram;
        this.soluong = soluong;
        this.dongia = dongia;
        this.id=id;
    }

    public sanphambanhang1(String masp, String tensp, String pin, String chip, String rom, String hangdienthoai, String ram, int soluong, float dongia, int id, int idhdct) {
        this.masp = masp;
        this.tensp = tensp;
        this.pin = pin;
        this.chip = chip;
        this.rom = rom;
        this.hangdienthoai = hangdienthoai;
        this.ram = ram;
        this.soluong = soluong;
        this.dongia = dongia;
        this.id = id;
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

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getChip() {
        return chip;
    }

    public void setChip(String chip) {
        this.chip = chip;
    }

    public String getRom() {
        return rom;
    }

    public void setRom(String rom) {
        this.rom = rom;
    }

    public String getHangdienthoai() {
        return hangdienthoai;
    }

    public void setHangdienthoai(String hangdienthoai) {
        this.hangdienthoai = hangdienthoai;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public float getDongia() {
        return dongia;
    }

    public void setDongia(float dongia) {
        this.dongia = dongia;
    }

    @Override
    public String toString() {
        return "sanphambanhang{" + "masp=" + masp + ", tensp=" + tensp + ", pin=" + pin + ", chip=" + chip + ", rom=" + rom + ", hangdienthoai=" + hangdienthoai + ", ram=" + ram + ", soluong=" + soluong + ", dongia=" + dongia + '}';
    }
 
 
}
