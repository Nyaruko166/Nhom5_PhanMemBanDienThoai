package com.fpt.it17326.nhom5.response;

import com.fpt.it17326.nhom5.domainmodel.KhachHang;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * AowVN_Nyaruko
 *
 */
@Getter
@Setter
@ToString
public class KhachHangResponse {

    private String maKH;
    private String hoTen;
    private String sdt;
    private String email;
    private boolean gioiTinh;
    private Date ngaySinh;
    private String diaChi;
    private Date createdAt;
    private boolean deleted;
    private Date updatedAt;

    public KhachHangResponse() {
    }

    public KhachHangResponse(KhachHang kh) {
        this.maKH = kh.getMaKH();
        this.hoTen = kh.getHoTen();
        this.sdt = kh.getSdt();
        this.email = kh.getEmail();
        this.gioiTinh = kh.isGioiTinh();
        this.ngaySinh = kh.getNgaySinh();
        this.diaChi = kh.getDiaChi();
        this.createdAt = kh.getCreatedAt();
        this.deleted = kh.isDeleted();
        this.updatedAt = kh.getUpdatedAt();
    }
    
    
}
