/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.it17326.nhom5.response;

import com.fpt.it17326.nhom5.domainmodel.KhuyenMai;
import com.fpt.it17326.nhom5.domainmodel.SanPham;
import com.fpt.it17326.nhom5.domainmodel.SanPhamGiamGia;
import com.fpt.it17326.nhom5.repository.KhuyenMaiRepository;
import com.fpt.it17326.nhom5.repository.SanPhamGiamGiaRepository;
import java.util.Date;
import java.util.List;
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
    private String moTa;
    private String maAnh;
    private String tenMauSac;
    private String tenHang;
    private String tenChip;
    private String dungLuong;
    private String tenRom;
    private String tenPin;
    private int soLuong;
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
        this.moTa = sp.getMoTa();
        this.maAnh = sp.getUrlAnh();
        this.tenMauSac = sp.getMauSac().getTenMauSac();
        this.tenHang = sp.getHangdt().getTenHang();
        this.tenChip = sp.getChip().getTenChip();
        this.dungLuong = sp.getRam().getDungLuong();
        this.tenRom = sp.getRom().getTenRom();
        this.tenPin = sp.getPin().getTenPin();
        this.soLuong = sp.getSoLuong();
        this.CreatedAt = sp.getCreatedAt();
        this.Deleted = sp.isDeleted();
        this.UpdatedAt = sp.getUpdatedAt();
    }

    public Object[] toDataRow() {
        return new Object[]{tenSP, tenHang, tenChip, dungLuong, tenRom, tenPin, tenMauSac, soLuong, moTa, String.format("%,.0f", donGia) + " VND"};
    }
    private Boolean luaChon = false;

    public Object[] toDataRow2() {
        return new Object[]{tenSP, luaChon};
    }

    public Object[] toDataRow3(String maKM) {
        SanPhamGiamGiaRepository phamRepository = new SanPhamGiamGiaRepository();
        KhuyenMaiRepository khuyenMaiRepository = new KhuyenMaiRepository();
        KhuyenMai khuyenMai = khuyenMaiRepository.getOne(maKM);
        SanPhamGiamGia gia = new SanPhamGiamGia();
        List<SanPhamGiamGia> giamGias = phamRepository.getAllSP(khuyenMai.getId());
        for (SanPhamGiamGia giamGia : giamGias) {
            if (giamGia.getSanPham().getTenSP().equals(tenSP)) {
                donGia = donGia-((donGia*khuyenMai.getSoTienGiam())/100);
            }
        }
        return new Object[]{tenSP, tenHang, tenChip, dungLuong, tenRom, tenPin, tenMauSac, soLuong, moTa, String.format("%,.0f", donGia) + " VND"};
    }
}
