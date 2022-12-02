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
 **/



@Entity
@Table (name = "LoaiSP")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoaiSP {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;
    
    @Column(name = "MaLoaiSP")
    private String maLoaiSP;
    
    @Column(name = "TenDanhMuc")
    private String tenDanhMuc;
    
    @Column(name = "Mota")
    private String moTa;
    
    @Column(name = "CreatedAt")
    private Date createdAt;
    
    @Column(name = "Deleted")
    private boolean deleted;
    
    @Column(name = "UpdatedAt")
    private Date updatedAt;
}
