/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.it17326.nhom5.response;

import com.fpt.it17326.nhom5.domainmodel.TrangThaiHoaDon;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author youngboizseetinh
 */
@Getter
@Setter
public class TrangThaiHoaDonResponse {

    private String maTT;
    private String tinhTrang;

    public TrangThaiHoaDonResponse() {
    }

    public TrangThaiHoaDonResponse(TrangThaiHoaDon tthd) {
        this.maTT = tthd.getMaTT();
        this.tinhTrang = tthd.getTinhTrang();
    }

}
