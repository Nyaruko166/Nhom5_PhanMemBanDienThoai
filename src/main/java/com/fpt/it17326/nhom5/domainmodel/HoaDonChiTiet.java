package com.fpt.it17326.nhom5.domainmodel;

import java.io.Serializable;
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
@Table(name = "HoaDonChiTiet")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HoaDonChiTiet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "IdHD", referencedColumnName = "Id")
    private HoaDon hoaDon;

    @ManyToOne
    @JoinColumn(name = "IdSP", referencedColumnName = "Id")
    private SanPham sanPham;

    @Column(name = "TenSP")
    private String TenSP;

    @Column(name = "SoLuong")
    private int soLuong;

    @Column(name = "DonGia")
    private Float donGia;

    @Column(name = "CreatedAt")
    private Date createdAt;

    @Column(name = "Deleted")
    private boolean deleted;

    @Column(name = "UpdatedAt")
    private Date updatedAt;

}
