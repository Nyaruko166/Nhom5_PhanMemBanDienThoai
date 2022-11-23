/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fpt.it17326.nhom5.service;

import com.fpt.it17326.nhom5.domainmodel.Imei;
import com.fpt.it17326.nhom5.response.ImeiResponse;
import java.util.List;

/**
 *
 * @author youngboizseetinh
 */
public interface ImeiService {

    List<ImeiResponse> getAll();

    ImeiResponse getOne(String MaImei);

    String add(Imei imei);

    String update(Imei imei);

    String delete(Imei imei);
}
