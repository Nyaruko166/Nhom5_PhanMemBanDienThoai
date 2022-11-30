/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
 *
 * @author youngboizseetinh
 */
@Entity
@Table (name = "ImeiDaBan")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ImeiDaBan {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "Id")
    private Long id;
    
    @ManyToOne
    @JoinColumn (name = "IdHoaDonChiTiet", referencedColumnName = "Id")
    private HoaDonChiTiet hoaDonChiTiet;
    
    @Column (name = "MaImei")
    private String maImel;

    @Column (name = "Imei")
    private String imei;

    @Column (name = "TrangThai")
    private boolean trangThai;
    
    @Column (name = "CreatedAt")
    private Date createdAt;

    @Column (name = "Deleted")
    private boolean deleted;

    @Column (name = "UpdatedAt")
    private Date updatedAt;
}
