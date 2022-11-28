/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.it17326.nhom5.response;

import com.fpt.it17326.nhom5.domainmodel.SanPham;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author youngboizseetinh
 */
@Getter
@Setter
@ToString
public class SanPhamResponse {

    private int id;
    private String maSP;
    private String tenSP;
    private Float donGia;
    private int soLuong;
    private String moTa;
    private String tenAnh;
    private String tenMauSac;
    private String tenHang;
    private String tenChip;
    private String dungLuong;
    private String tenRom;
    private String tenPin;
    private Date CreatedAt;
    private boolean Deleted;
    private Date UpdatedAt;

    public SanPhamResponse() {
    }

    public SanPhamResponse(SanPham sp) {
        this.id = sp.getId();
        this.maSP = sp.getMaSP();
        this.tenSP = sp.getTenSP();
        this.donGia = sp.getDonGia();
        this.soLuong = sp.getSoLuong();
        this.moTa = sp.getMoTa();
        this.tenAnh = sp.getAnh().getMaAnh();
        this.tenMauSac = sp.getMauSac().getTenMauSac();
        this.tenHang = sp.getHangdt().getTenHang();
        this.tenChip = sp.getChip().getTenChip();
        this.dungLuong = sp.getRam().getDungLuong();
        this.tenRom = sp.getRom().getTenRom();
        this.tenPin = sp.getPin().getTenPin();
        this.CreatedAt = sp.getCreatedAt();
        this.Deleted = sp.isDeleted();
        this.UpdatedAt = sp.getUpdatedAt();
    }

    public Object[] toDataRow() {
        return new Object[]{maSP, tenSP, donGia,soLuong, moTa, tenAnh, tenMauSac, tenHang, tenChip, dungLuong, tenRom, tenPin};
    }

}
