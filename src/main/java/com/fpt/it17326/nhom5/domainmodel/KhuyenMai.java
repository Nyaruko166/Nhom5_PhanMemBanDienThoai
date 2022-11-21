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
 *
 * @author ngock
 */
@Entity
@Table(name = "KHUYENMAI")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class KhuyenMai {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "TenKM")
    private String TenKM;

    @Column(name = "SoTienGiam")
    private float SoTienGiam;
    @Column(name = "NgayBatDau")
    private Date NgayBatDau;

    @Column(name = "NgayKetThuc")
    private Date NgayKetThuc;
    @Column(name = "CreatedAt")
    private Date CreatedAt;
    @Column(name = "Deleted")
    private int Deleted;

    @Column(name = "UpdatedAt")
    private Date UpdatedAt;
}