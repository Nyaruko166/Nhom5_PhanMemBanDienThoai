package com.fpt.it17326.nhom5.domainmodel;

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
    @Column (name = "MaSP")
    private String maSP;

    @Column (name = "TenSP")
    private String tenSP;

    @Column (name = "DonGia")
    private Float donGia;

    @ManyToOne
    @JoinColumn (name = "MaBH", referencedColumnName = "MaBH")
    private BaoHanh maBH;

    @Column (name = "MoTa")
    private String moTa;

    @ManyToOne
    @JoinColumn (name = "MaAnh", referencedColumnName = "MaAnh")
    private Anh maAnh;

    @ManyToOne
    @JoinColumn (name = "MaLoaiSP", referencedColumnName = "MaLoaiSP")
    private LoaiSP maLoaiSP;

    @ManyToOne
    @JoinColumn (name = "MaMauSac", referencedColumnName = "MaMauSac")
    private MauSac maMauSac;

    @ManyToOne
    @JoinColumn (name = "MaHang", referencedColumnName = "MaHang")
    private HangDienThoai maHang;

    @ManyToOne
    @JoinColumn (name = "MaChip", referencedColumnName = "MaChip")
    private Chip maChip;

    @ManyToOne
    @JoinColumn (name = "MaRam", referencedColumnName = "MaRam")
    private Ram maRam;

    @ManyToOne
    @JoinColumn (name = "MaRom", referencedColumnName = "MaRom")
    private Rom maRom;

    @ManyToOne
    @JoinColumn (name = "MaPin", referencedColumnName = "MaPin")
    private Pin maPin;

    @Column (name = "CreatedAt")
    private String createdAt;

    @Column (name = "Deleted")
    private Boolean deleted;

    @Column (name = "UpdatedAt")
    private String updatedAt;

}
