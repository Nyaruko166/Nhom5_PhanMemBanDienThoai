/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fpt.it17326.nhom5.service;

import com.fpt.it17326.nhom5.domainmodel.ImeiDaBan;
import com.fpt.it17326.nhom5.response.ImeiDaBanResponse;
import java.util.List;

/**
 *
 * @author youngboizseetinh
 */
public interface ImeiDaBanService {
    
    List<ImeiDaBanResponse> getAll();
    
    List<ImeiDaBan> getAll1();
    
    ImeiDaBanResponse getOne(String MaImei);

    String add(ImeiDaBan imeiDaBan);

    String update(ImeiDaBan imeiDaBan);

    String delete(ImeiDaBan imeiDaBan);
}
