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
@Table(name="TaiKhoan")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TaiKhoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="MaTaiKhoan")
    private String MaTaiKhoan;
    
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
    
    @Column(name ="Luong")
    private BigDecimal Luong;
    
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

    public TaiKhoan(String HoTen, String TenCV, String Email, String TaiKhoan, String MatKhau, Date CreatedAt, Boolean Deleted) {
        this.HoTen = HoTen;
        this.TenCV = TenCV;
        this.Email = Email;
        this.TaiKhoan = TaiKhoan;
        this.MatKhau = MatKhau;
        this.CreatedAt = CreatedAt;
        this.Deleted = Deleted;
    }

    public TaiKhoan( String MatKhau) {
        
        this.MatKhau = MatKhau;
    }
    
}
