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
@Table (name = "HangDienThoai")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HangDienThoai {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private String id;

    @Column(name = "MaHangDT")
    private String maHangDT;

    @Column(name = "TenHang")
    private String tenHang;

    @Column(name = "CreatedAt")
    private Date createdAt;

    @Column(name = "Deleted")
    private boolean deleted;

    @Column(name = "UpdatedAt")
    private Date updatedAt;
}

