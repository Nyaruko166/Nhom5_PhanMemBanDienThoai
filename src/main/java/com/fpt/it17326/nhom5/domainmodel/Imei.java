package com.fpt.it17326.nhom5.domainmodel;

import com.fpt.it17326.nhom5.util.Util;
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
@Table (name = "Imei")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Imei {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "Id")
    private Long id;
    
    @Column (name = "MaImei")
    private String maImel;

    @Column (name = "Imei")
    private String imei;

    @ManyToOne
    @JoinColumn (name = "IdSP", referencedColumnName = "Id")
    private SanPham sanPham;
    
    @Column (name = "TrangThai")
    private boolean trangThai;
    
    @Column (name = "CreatedAt")
    private Date createdAt;

    @Column (name = "Deleted")
    private boolean deleted;

    @Column (name = "UpdatedAt")
    private Date updatedAt;
    
    public void setCommonData() {
        this.deleted = false;
        this.createdAt = Util.getCurrentDate();
        this.maImel = Util.randomString();
    }
}
