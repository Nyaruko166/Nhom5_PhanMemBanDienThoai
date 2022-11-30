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
    private int id;
    
    @Column (name = "MaSP")
    private String maSP;

    @Column (name = "TenSP")
    private String tenSP;

    @Column (name = "DonGia")
    private Float donGia;

    @Column (name = "MoTa")
    private String moTa;

    @ManyToOne
    @JoinColumn (name = "IdAnh", referencedColumnName = "Id")
    private Anh anh;

    @ManyToOne
    @JoinColumn (name = "IdMauSac", referencedColumnName = "Id")
    private MauSac mauSac;

    @ManyToOne
    @JoinColumn (name = "IdHang", referencedColumnName = "Id")
    private HangDienThoai hangdt;

    @ManyToOne
    @JoinColumn (name = "IdChip", referencedColumnName = "Id")
    private Chip chip;

    @ManyToOne
    @JoinColumn (name = "IdRam", referencedColumnName = "Id")
    private Ram ram;

    @ManyToOne
    @JoinColumn (name = "IdRom", referencedColumnName = "Id")
    private Rom rom;

    @ManyToOne
    @JoinColumn (name = "IdPin", referencedColumnName = "Id")
    private Pin pin;

    @Column (name = "SoLuong")
    private int soLuong;    
    
    @Column (name = "CreatedAt")
    private Date createdAt;

    @Column (name = "Deleted")
    private boolean deleted;

    @Column (name = "UpdatedAt")
    private Date updatedAt;

}
