/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.it17326.nhom5.reponse;

import com.fpt.it17326.nhom5.domainmodel.KhuyenMai;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ngock
 */
@Getter
@Setter
public class KhuyenMaiReponse {
    private int id;
    private String TenKM;
    private Float SoTienGiam;
    private Date NgayBatDau;
    private Date NgayKetThuc;
    private Date CreatedAt;
    private int Deleted;
    private Date UpdatedAt;

    public KhuyenMaiReponse(KhuyenMai khuyenMai) {
        this.id = khuyenMai.getId();
        this.TenKM = khuyenMai.getTenKM();
        this.SoTienGiam = khuyenMai.getSoTienGiam();
        this.NgayBatDau = khuyenMai.getNgayBatDau();
        this.NgayKetThuc = khuyenMai.getNgayKetThuc();
        this.CreatedAt = khuyenMai.getCreatedAt();
        this.Deleted = khuyenMai.getDeleted();
        this.UpdatedAt = khuyenMai.getUpdatedAt();
    }

    public KhuyenMaiReponse() {
    }
    public Object[] toDataRow() {
        return new Object[]{id,TenKM,SoTienGiam,NgayBatDau,NgayKetThuc};
    }
    
}
