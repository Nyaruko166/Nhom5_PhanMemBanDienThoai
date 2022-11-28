package com.fpt.it17326.nhom5.domainmodel;

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
 *
 */
@Entity
@Table(name = "ImeiDaBan")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ImeiDaBan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "IdHoaDonChiTiet", referencedColumnName = "Id")
    private HoaDonChiTiet hoaDonChiTiet;

    @Column(name = "MaImei")
    private String maImei;

    @Column(name = "Imei")
    private String imei;

    @Column(name = "CreatedAt")
    private Date createdAt;

    @Column(name = "Deleted")
    private boolean deleted;

    @Column(name = "UpdatedAt")
    private Date updatedAt;

}
