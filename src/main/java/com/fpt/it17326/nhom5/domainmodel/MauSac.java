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
@Table(name = "MauSac")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MauSac {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private String Id;

    @Column(name = "MaMauSac")
    private String MaMauSac;
    
    @Column(name = "TenMauSac")
    private String TenMauSac;

    @Column(name = "CreatedAt")
    private Date CreatedAt;

    @Column(name = "Deleted")
    private boolean Deleted;

    @Column(name = "UpdatedAt")
    private Date UpdatedAt;
}
