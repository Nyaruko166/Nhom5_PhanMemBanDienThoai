/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.it17326.nhom5.response;

import com.fpt.it17326.nhom5.domainmodel.HoaDonChiTiet;
import com.fpt.it17326.nhom5.domainmodel.ImeiDaBan;
import java.util.Date;

/**
 *
 * @author youngboizseetinh
 */
public class ImeiDaBanResponse {

    private int hoaDonChiTiet;
    private String maImei;
    private String imei;
    private boolean trangThai;
    private Date createdAt;
    private boolean deleted;
    private Date updatedAt;

    public ImeiDaBanResponse() {
    }

    public ImeiDaBanResponse(ImeiDaBan imeiDaBan) {
        this.hoaDonChiTiet = imeiDaBan.getHoaDonChiTiet().getId();
        this.maImei = imeiDaBan.getMaImel();
        this.imei = imeiDaBan.getImei();
        this.trangThai = imeiDaBan.isTrangThai();
        this.createdAt = imeiDaBan.getCreatedAt();
        this.deleted = imeiDaBan.isDeleted();
        this.updatedAt = imeiDaBan.getUpdatedAt();
    }
    
    
    
}
