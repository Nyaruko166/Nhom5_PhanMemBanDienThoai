/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.it17326.nhom5.response;

import com.fpt.it17326.nhom5.domainmodel.KhuyenMai;
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
public class KhuyenMaiResponse {

    private int id;
    private String maKM;
    private String tenKM;
    private Float soTienGiam;
    private Date ngayBatDau;
    private Date ngayKetThuc;
    private Date createdAt;
    private Boolean deleted;
    private Date updatedAt;
    private Boolean loaiGiamGia;
    private Float giaTriDonHangToiThieu;
    private Boolean hinhThucGiamGia;

    public KhuyenMaiResponse() {
    }

    public KhuyenMaiResponse(KhuyenMai km) {
        this.id = km.getId();
        this.maKM = km.getMaKM();
        this.tenKM = km.getTenKM();
        this.soTienGiam = km.getSoTienGiam();
        this.ngayBatDau = km.getNgayBatDau();
        this.giaTriDonHangToiThieu=km.getGiaTriDonHangToiThieu();
        this.loaiGiamGia=km.getDeleted();
        this.hinhThucGiamGia=km.getHinhThucGiamGia();
        this.ngayKetThuc = km.getNgayKetThuc();
        this.createdAt = km.getCreatedAt();
        this.deleted = km.getDeleted();
        this.updatedAt = km.getUpdatedAt();
    }

    public Object[] toDataRow() {
        String trangThai = "Hoạt động";
        if (deleted==false) {
            trangThai = "Đã ngừng hoạt động";
        }
        String loaiGiamGiaa = "Theo sản phẩm";
        if (loaiGiamGia == true) {
            loaiGiamGiaa="Theo hóa đơn";
        }
        return new Object[]{id,loaiGiamGiaa, tenKM, maKM,soTienGiam, ngayBatDau + " đến " + ngayKetThuc, trangThai};
    }
}
