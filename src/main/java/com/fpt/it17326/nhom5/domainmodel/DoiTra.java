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
@Table(name = "DoiTra")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DoiTra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "MaDoiTra")
    private String maDoiTra;

    @ManyToOne
    @JoinColumn(name = "IdHD", referencedColumnName = "Id")
    private HoaDon hoaDon;

    @Column(name = "LyDoDoiTra")
    private String liDoDoiTra;

    @Column(name = "HanDoiTra")
    private Long hanDoiTra;

    @Column(name = "TrangThai")
    private boolean trangThai;

    @Column(name = "CreatedAt")
    private Date createdAt;

    @Column(name = "Deleted")
    private boolean deleted;

    @Column(name = "UpdatedAt")
    private Date updatedAt;

}
