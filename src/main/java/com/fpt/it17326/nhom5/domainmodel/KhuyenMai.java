package com.fpt.it17326.nhom5.domainmodel;

<<<<<<< HEAD
import java.util.Date;
=======
/**
 * AowVN_Nyaruko
 **/




>>>>>>> 5c568a85d6b46ebce7b9b9028cff26230569c535
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

    @Column(name = "MaKM")
    private String maKM;

    @Column(name = "TenKM")
    private String tenKM;

    @Column(name = "LoaiGiamGia")
    private Boolean loaiGiamGia;

    @Column(name = "HinhThucGiamGia")
    private Boolean hinhThucGiamGia;
    
    @Column(name = "SoTienGiam")
    private Float soTienGiam;
    
    @Column(name = "GiaTriDonHangToiThieu")
    private Float giaTriDonHangToiThieu;
    
    @Column(name = "NgayBatDau")
    private Date ngayBatDau;

    @Column(name = "NgayKetThuc")
    private Date ngayKetThuc;

    @Column(name = "CreatedAt")
    private Date createdAt;

    @Column(name = "Deleted")
    private Boolean deleted;

    @Column(name = "UpdatedAt")
    private Date updatedAt;
    
}
