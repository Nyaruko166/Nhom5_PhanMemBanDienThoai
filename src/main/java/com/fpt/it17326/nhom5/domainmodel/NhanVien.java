package com.fpt.it17326.nhom5.domainmodel;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "NhanVien")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class NhanVien {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "Id")
    private int id;
    
    @Column (name = "MaNhanVien")
    private String maNhanVien;
    
    @Column (name = "HoTen")
    private String hoTen;
    
    @Column (name = "GioiTinh")
    private boolean gioiTinh;
    
    @Column(name = "TenCV")
    private String tenCV;
    
    @Column(name = "Email")
    private String email;
    
    @Column(name = "QueQuan")
    private String queQuan;
    
    @Column(name = "NgaySinh")
    private String ngaySinh;
    
    @Column(name = "TaiKhoan")
    private String taiKhoan;
    
    @Column(name = "MatKhau")
    private String matKhau;
    
    @Column(name = "CreatedAt")
    private Date createdAt;

    @Column(name = "Deleted")
    private boolean deleted;

    @Column(name = "UpdatedAt")
    private Date updatedAt;
}
