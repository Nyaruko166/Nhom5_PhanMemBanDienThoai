package com.fpt.it17326.nhom5.response;

import com.fpt.it17326.nhom5.domainmodel.HoaDon;
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
public class HoaDonResponse {

    private String maHD;
    private String maNV;
    private String tenKH;
    private String sdt;
    private boolean trangThai;
    private Float tongTien;
    private Date createdAt;
    private boolean deleted;
    private Date updatedAt;

    public HoaDonResponse() {
    }

    public HoaDonResponse(HoaDon hd) {
        this.maHD = hd.getMaHD();
        this.maNV = hd.getNhanVien().getMaNhanVien();
        this.tenKH = hd.getTenKH();
        this.sdt = hd.getSdt();
        this.trangThai = hd.isTrangThai();
        this.tongTien = hd.getTongTien();
        this.createdAt = hd.getCreatedAt();
        this.deleted = hd.isDeleted();
        this.updatedAt = hd.getUpdatedAt();
    }

//    public HoaDonResponse(String maTT) {
//        this.maTT = maTT;
//    }
//    public HoaDonResponse(String maHD, String maTT, String maNV) {
//        this.maHD = maHD;
//        this.maTT = maTT;
//        this.maNV = maNV;
//    }
}
