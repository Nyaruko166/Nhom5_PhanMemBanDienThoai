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
@Table(name = "KhachHang")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class KhachHang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int Id;
    
    @Column(name = "maKH")
    private String maKH;

    @Column(name = "HoTen")
    private String hoTen;
    
    @Column(name = "SDT")
    private String sdt;
    
    @Column(name = "Email")
    private String email;
    
    @Column(name = "GioiTinh")
    private boolean gioiTinh;
    
    @Column(name = "NgaySinh")
    private Date ngaySinh;
    
    @Column(name = "DiaChi")
    private String diaChi;
    
    @Column(name = "HangKH")
    private String hangKH;
    
    @Column(name = "CreatedAt")
    private Date createdAt;

    @Column(name = "Deleted")
    private boolean deleted;

    @Column(name = "UpdatedAt")
    private Date updatedAt;
}
