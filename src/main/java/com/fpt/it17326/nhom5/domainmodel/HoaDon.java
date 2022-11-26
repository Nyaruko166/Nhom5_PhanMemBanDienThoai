package com.fpt.it17326.nhom5.domainmodel;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * AowVN_Nyaruko
 *
 */
@Entity
@Table(name = "HoaDon")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HoaDon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

//    @ManyToOne
//    @JoinColumn(name = "IdBH", referencedColumnName = "Id")
//    private BaoHanh baoHanh;

    @Column(name = "MaHD")
    private String maHD;

    @Column(name = "TenKH")
    private String tenKH;

    @Column(name = "SDT")
    private String sdt;

    @ManyToOne
    @JoinColumn(name = "IdTT", referencedColumnName = "Id")
    private TrangThaiHoaDon trangThaiHoaDon;

    @Column(name = "GhiChu")
    private String ghiChu;

    @ManyToOne
    @JoinColumn(name = "IdKM", referencedColumnName = "Id")
    private KhuyenMai khuyenMai;

    @ManyToOne
    @JoinColumn(name = "IdNV", referencedColumnName = "Id")
    private NhanVien nhanVien;

    @Column(name = "TongTien")
    private Float tongTien;

    @Column(name = "CreatedAt")
    private Date createdAt;

    @Column(name = "Deleted")
    private boolean deleted;

    @Column(name = "UpdatedAt")
    private Date updatedAt;

    public HoaDon(String maHD, TrangThaiHoaDon trangThaiHoaDon) {
        this.maHD = maHD;
        this.trangThaiHoaDon = trangThaiHoaDon;
    }

    public HoaDon(String maHD, String tenKH, TrangThaiHoaDon trangThaiHoaDon, NhanVien nhanVien, Float tongTien) {
        this.maHD = maHD;
        this.tenKH = tenKH;
        this.trangThaiHoaDon = trangThaiHoaDon;
        this.nhanVien = nhanVien;
        this.tongTien = tongTien;
    }

    
}
