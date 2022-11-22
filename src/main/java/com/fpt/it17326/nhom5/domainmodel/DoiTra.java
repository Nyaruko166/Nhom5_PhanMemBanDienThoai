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
import lombok.Setter;
import lombok.ToString;

/**
 * AowVN_Nyaruko
 **/

@Entity
@Table (name = "DoiTra")
@Getter
@Setter
@AllArgsConstructor
@ToString

public class DoiTra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaDoiTra")
    private String MaMaDoiTra;
    
    @Column(name="MaHD")
    private String MaHD;
    
    @Column(name="LyDoDoiTra")
    private String LyDoDoiTra;
    
    @Column (name="HanDoiTra")
    private String HanDoiTra;
    
    @Column (name="TrangThai")
    private boolean TrangThai;
    
    @Column (name="CreatedAt")
    private Date CreatedAt;
    
    @Column (name="Deleted")
    private boolean Deleted;
    
    @Column (name="UpdatedAt")
    private Date UpdaDateAt;
}
