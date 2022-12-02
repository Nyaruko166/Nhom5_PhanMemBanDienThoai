/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fpt.it17326.nhom5.service;

import com.fpt.it17326.nhom5.domainmodel.SanPhamGiamGia;
import com.fpt.it17326.nhom5.response.SanPhamGiamGiaResponse;
import java.util.List;

/**
 *
 * @author youngboizseetinh
 */
public interface SanPhamGiamGiaService {

    List<SanPhamGiamGiaResponse> getAll();

    SanPhamGiamGiaResponse getOne(String MaSP);

    String add(SanPhamGiamGia spGiamGia);

    String update(SanPhamGiamGia spGiamGia);

    String delete(SanPhamGiamGia spGiamGia);
}
