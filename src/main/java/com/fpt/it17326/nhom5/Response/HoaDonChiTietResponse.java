/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.it17326.nhom5.response;

import com.fpt.it17326.nhom5.domainmodel.HoaDon;
import com.fpt.it17326.nhom5.domainmodel.HoaDonChiTiet;
import com.fpt.it17326.nhom5.domainmodel.SanPham;
import java.util.Date;

/**
 *
 * @author youngboizseetinh
 */
public class HoaDonChiTietResponse {
    
    private int hoaDon;
    private int sp;
    private String tenSP;
    private int soLuong;
    private Float donGia;
    private Date CreatedAt;
    private boolean Deleted;
    private Date UpdatedAt;

    public HoaDonChiTietResponse() {
    }

    public HoaDonChiTietResponse(HoaDonChiTiet hdct) {
        this.hoaDon = hdct.getHoaDon().getId();
        this.sp = hdct.getSp().getId();
        this.tenSP = hdct.getTenSP();
        this.soLuong = hdct.getSoLuong();
        this.donGia = hdct.getDonGia();
        this.CreatedAt = hdct.getCreatedAt();
        this.Deleted = hdct.isDeleted();
        this.UpdatedAt = hdct.getUpdatedAt();
    }
    
    
}
