/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fpt.it17326.nhom5.service;

import com.fpt.it17326.nhom5.domainmodel.KhuyenMai;
import com.fpt.it17326.nhom5.response.KhuyenMaiResponse;
import java.util.List;

/**
 *
 * @author youngboizseetinh
 */
public interface KhuyenMaiService {

    List<KhuyenMai> getAll();

    List<KhuyenMaiResponse> getAllTrue();

    List<KhuyenMaiResponse> getAllFalse();

    KhuyenMaiResponse getOne(int MaKM);

    String add(KhuyenMai km);

    String update(KhuyenMai km);

    String delete(int km);
}
