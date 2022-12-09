/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.it17326.nhom5.response;

import com.fpt.it17326.nhom5.domainmodel.KhuyenMai;
import java.text.SimpleDateFormat;
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
        this.loaiGiamGia=km.getDeleted();
        this.ngayKetThuc = km.getNgayKetThuc();
        this.createdAt = km.getCreatedAt();
        this.deleted = km.getDeleted();
        this.updatedAt = km.getUpdatedAt();
    }

    public Object[] toDataRow1() {
        String trangThai = "Đã ngừng hoạt động";
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        String date1 = format.format(ngayBatDau);
        String date2 = format.format(ngayKetThuc);
        return new Object[]{id, tenKM, maKM,String.format("%,.0f", soTienGiam) + " %", date1 + " đến " + date2, trangThai};

    }
    public Object[] toDataRow2() {
        String trangThai = "Hoạt động";
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        String date1 = format.format(ngayBatDau);
        String date2 = format.format(ngayKetThuc);
        return new Object[]{id, tenKM, maKM,String.format("%,.0f", soTienGiam) + " %", date1 + " đến " + date2, trangThai};
    }

}
