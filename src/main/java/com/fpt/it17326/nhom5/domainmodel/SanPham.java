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
 **/

@Entity
@Table (name = "SanPham")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SanPham {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "Id")
    private String id;
    
    @Column (name = "MaSP")
    private String maSP;

    @Column (name = "TenSP")
    private String tenSP;

    @Column (name = "DonGia")
    private Float donGia;

    @ManyToOne
    @JoinColumn (name = "IdBH", referencedColumnName = "IdBH")
    private BaoHanh maBH;
    
    @ManyToOne
    @JoinColumn (name = "IdImei", referencedColumnName = "IdImei")
    private Imei imei;

    @Column (name = "MoTa")
    private String moTa;

    @ManyToOne
    @JoinColumn (name = "IdAnh", referencedColumnName = "IdAnh")
    private Anh idAnh;

    @ManyToOne
    @JoinColumn (name = "IdLoaiSP", referencedColumnName = "IdLoaiSP")
    private LoaiSP idLoaiSP;

    @ManyToOne
    @JoinColumn (name = "IdMauSac", referencedColumnName = "IdMauSac")
    private MauSac idMauSac;

    @ManyToOne
    @JoinColumn (name = "IdHang", referencedColumnName = "IdHang")
    private HangDienThoai idHang;

    @ManyToOne
    @JoinColumn (name = "IdChip", referencedColumnName = "IdChip")
    private Chip idChip;

    @ManyToOne
    @JoinColumn (name = "IdRam", referencedColumnName = "IdRam")
    private Ram idRam;

    @ManyToOne
    @JoinColumn (name = "IdRom", referencedColumnName = "IdRom")
    private Rom idRom;

    @ManyToOne
    @JoinColumn (name = "IdPin", referencedColumnName = "IdPin")
    private Pin idPin;

    @Column (name = "CreatedAt")
    private Date createdAt;

    @Column (name = "Deleted")
    private boolean deleted;

    @Column (name = "UpdatedAt")
    private Date updatedAt;

}
