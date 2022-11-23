package com.fpt.it17326.nhom5.response;

import com.fpt.it17326.nhom5.domainmodel.NhanVien;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * AowVN_Nyaruko
 *
 */
@Getter
@Setter
public class NhanVienResponse {

    private String maNhanVien;
    private String hoTen;
    private boolean gioiTinh;
    private String tenCV;
    private String email;
    private String queQuan;
    private String ngaySinh;
    private String luong;
    private String taiKhoan;
    private String matKhau;
    private Date createdAt;
    private boolean deleted;
    private Date updatedAt;

    public NhanVienResponse() {
    }

    public NhanVienResponse(NhanVien nv) {
        this.maNhanVien = nv.getMaNhanVien();
        this.hoTen = nv.getHoTen();
        this.gioiTinh = nv.isGioiTinh();
        this.tenCV = nv.getTenCV();
        this.email = nv.getEmail();
        this.queQuan = nv.getQueQuan();
        this.ngaySinh = nv.getNgaySinh();
        this.luong = nv.getLuong();
        this.taiKhoan = nv.getTaiKhoan();
        this.matKhau = nv.getMatKhau();
        this.createdAt = nv.getCreatedAt();
        this.deleted = nv.isDeleted();
        this.updatedAt = nv.getUpdatedAt();
    }

}
