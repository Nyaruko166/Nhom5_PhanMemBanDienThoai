/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.it17326.nhom5.response;

import com.fpt.it17326.nhom5.domainmodel.HoaDonChiTiet;
import com.fpt.it17326.nhom5.domainmodel.ImeiDaBan;
import com.fpt.it17326.nhom5.domainmodel.SanPham;
import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author PHAM DAC THANG
 */

@ToString
public class ThongkeResponse {
     private int id;

 
    private String MaHD;

   
    
    private String MaSP;

  
    private String TenSP;

   
    private int soLuong;

    private int solgton;

 
    
    
    private Float donGia;

 private boolean trangthai;
    private  Date createdAt;

   
    private boolean deleted;


    private Date updatedAt;
    private String MaImei;
    private String imei;
  private long tongsoLuong;
//
  private float tongdoangthu;

    public ThongkeResponse(float tongdoangthu) {
        this.tongdoangthu = tongdoangthu;
    }
  
    public ThongkeResponse(String MaSP, String TenSP, long tongsoLuong, boolean trangthai) {
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.tongsoLuong=tongsoLuong;
        this.trangthai = trangthai;
    }

  

      public ThongkeResponse(SanPham sp) {
      
        this.MaSP = sp.getMaSP();
        this.TenSP = sp.getTenSP();
     
        this.solgton = sp.getSoLuong();
        this.donGia = sp.getDonGia();
        }

    public ThongkeResponse(HoaDonChiTiet hdct) {
            this.id = hdct.getId();
        this.MaHD = hdct.getHoaDon().getMaHD();
        this.MaSP = hdct.getSp().getMaSP();
        this.TenSP = hdct.getTenSP();
        this.soLuong = hdct.getSoLuong();
        this.donGia = hdct.getDonGia();
        this.trangthai=hdct.getHoaDon().isTrangThai();
        this.createdAt = hdct.getHoaDon().getCreatedAt();
        this.deleted = hdct.isDeleted();
        this.updatedAt = hdct.getUpdatedAt();
    }

    public ThongkeResponse(ImeiDaBan a) {
        this.MaHD = a.getHoaDonChiTiet().getHoaDon().getMaHD();
        this.trangthai=a.getHoaDonChiTiet().getHoaDon().isTrangThai();
        this.createdAt = a.getHoaDonChiTiet().getHoaDon().getCreatedAt();
        this.MaImei = a.getMaImel();
        this.imei = a.getImei();
    }

    public float getTongdoangthu() {
        return tongdoangthu;
    }

    public void setTongdoangthu(long tongdoangthu) {
        this.tongdoangthu = tongdoangthu;
    }

    public long getTongsoLuong() {
        return tongsoLuong;
    }

    public void setTongsoLuong(long tongsoLuong) {
        this.tongsoLuong = tongsoLuong;
    }
    
 public int getSolgton() {
        return solgton;
    }

    public void setSolgton(int solgton) {
        this.solgton = solgton;
    }
    public boolean isTrangthai() {
        return trangthai;
    }

    public void setTrangthai(boolean trangthai) {
        this.trangthai = trangthai;
    }

    public String getMaImei() {
        return MaImei;
    }

    public void setMaImei(String MaImei) {
        this.MaImei = MaImei;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public int getId() {
        return id;
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

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Float getDonGia() {
        return donGia;
    }

    public void setDonGia(Float donGia) {
        this.donGia = donGia;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    
public double thanhtien(){
      
  return  (double) (donGia*soLuong);
  
  
  }

  public String chuyenngaymua() {

        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(createdAt.toString());
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            String ns = format.format(date);
            return ns;
        } catch (Exception e) {
            return "";
        }

    }
}
