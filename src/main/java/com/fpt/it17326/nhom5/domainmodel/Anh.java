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
@Table (name = "Anh")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Anh {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private String id;
    
    @Column(name = "MaAnh")
    private String maAnh;
    
    @Column(name = "UrlAnh")
    private String urlAnh;
    
    @Column(name = "Cover")
    private boolean cover;
    
    @Column(name = "CreatedAt")
    private Date createdAt;
    
    @Column(name = "Deleted")
    private boolean deleted;
    
    @Column(name = "UpdatedAt")
    private Date updatedAt;
}
