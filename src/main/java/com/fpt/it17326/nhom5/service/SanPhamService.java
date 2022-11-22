/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fpt.it17326.nhom5.service;

import com.fpt.it17326.nhom5.domainmodel.SanPham;
import com.fpt.it17326.nhom5.response.SanPhamResponse;
import java.util.List;

/**
 *
 * @author youngboizseetinh
 */
public interface SanPhamService {

    List<SanPhamResponse> getAll();

    SanPhamResponse getOne(String MaSP);

    String add(SanPham sp);

    String update(SanPham sp);

    String delete(SanPham sp);
}
