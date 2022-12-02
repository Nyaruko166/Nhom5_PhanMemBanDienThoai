package com.fpt.it17326.nhom5.domainmodel;

/**
 * AowVN_Nyaruko
 **/




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "KhuyenMai")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class KhuyenMai {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;
    
    @Column (name = "MaKM")
    private String maKM;
    
    @Column (name = "TenKM")
    private String tenKH;
    
    @Column (name = "SoTienGiam")
    private Float soTienGiam;
    
    @Column (name = "NgayBatDau")
    private String ngayBatDau;
    
    @Column (name = "NgayKetThuc")
    private String ngayKetThuc;
    
    @Column (name = "CreatedAt")
    private String createAt;
    
    @Column (name = "Deleted")
    private boolean deleted;
    
    @Column(name = "UpdatedAt")
    private String updateAt;
    
}
