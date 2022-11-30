/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
 *
 * @author youngboizseetinh
 */
@Entity
@Table (name = "SanPhamGiamGia")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SanPhamGiamGia {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "Id")
    private int id;
    
    @ManyToOne
    @JoinColumn (name = "IdSP", referencedColumnName = "Id")
    private SanPham sanPham;
    
    @ManyToOne
    @JoinColumn (name = "IdKM", referencedColumnName = "Id")
    private KhuyenMai khuyenMai;
    
}
