package com.fpt.it17326.nhom5.response;

import com.fpt.it17326.nhom5.domainmodel.HoaDon;
import java.util.Date;

/**
 * AowVN_Nyaruko
 *
 */
public class HoaDonResponse {

    private String maBaoHanh;
    private String maHD;
    private String tenKH;
    private String sdt;
    private String maTT;
    private String ghiChu;
    private String maKM;
    private String maNV;
    private Float tongTien;
    private Date createdAt;
    private boolean deleted;
    private Date updatedAt;

    public HoaDonResponse() {
    }

    public HoaDonResponse(HoaDon hd) {

        this.maHD = hd.getMaHD();
        this.tenKH = hd.getTenKH();
        this.sdt = hd.getSdt();
        this.maTT = hd.getTrangThaiHoaDon().getMaTT();
        this.ghiChu = hd.getGhiChu();
        this.maKM = hd.getKhuyenMai().getMaKM();
        this.maNV = hd.getNhanVien().getMaNhanVien();
        this.tongTien = hd.getTongTien();
        this.createdAt = hd.getCreatedAt();
        this.deleted = hd.isDeleted();
        this.updatedAt = hd.getUpdatedAt();
    }

    public HoaDonResponse(String maTT) {
        this.maTT = maTT;
    }

    public HoaDonResponse(String maHD, String maTT, String maNV) {
        this.maHD = maHD;
        this.maTT = maTT;
        this.maNV = maNV;
    }
    
    
}
