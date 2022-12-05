package com.fpt.it17326.nhom5.domainmodel;

import java.math.BigDecimal;
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
 **/
@Entity
@Table(name="NhanVien")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;
    
    @Column(name="MaNhanVien")
    private String MaNhanVien;
    
    @Column(name ="HoTen")
    private String HoTen;
    
    @Column(name ="GioiTinh")
    private Boolean GioiTinh;
    
    
    @Column(name ="TenCV")
    private String TenCV;
    
    @Column(name ="Email")
    private String Email;
    
    @Column(name ="QueQuan")
    private String QueQuan;
    
    @Column(name ="NgaySinh")
    private Date NgaySinh;
    
   
    
    @Column(name ="TaiKhoan")
    private String TaiKhoan;
    
    @Column(name ="MatKhau")
    private String MatKhau;
    
    @Column(name ="CreatedAt")
    private Date CreatedAt;
    
    @Column(name ="Deleted")
    private Boolean Deleted;
    
    @Column(name ="UpdatedAt")
    private Date UpdatedAt;

    public NhanVien(String HoTen, String TenCV, String Email, String TaiKhoan, String MatKhau, Date CreatedAt, Boolean Deleted) {
        this.HoTen = HoTen;
        this.TenCV = TenCV;
        this.Email = Email;
        this.TaiKhoan = TaiKhoan;
        this.MatKhau = MatKhau;
        this.CreatedAt = CreatedAt;
        this.Deleted = Deleted;
<<<<<<< HEAD
=======
    }

    public NhanVien( String MatKhau) {
        
        this.MatKhau = MatKhau;
>>>>>>> 5c568a85d6b46ebce7b9b9028cff26230569c535
    }
            
    public NhanVien( String MaNhanVien) {
        
        this.MaNhanVien = MaNhanVien;
    }

    
    
}
