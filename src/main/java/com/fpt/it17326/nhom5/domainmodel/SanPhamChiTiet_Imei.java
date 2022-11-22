package com.fpt.it17326.nhom5.domainmodel;

import javax.persistence.Entity;
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
@Table (name = "SanPhamChiTiet_Imei")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SanPhamChiTiet_Imei {
    private String maSanPhamChiTiet;
}
