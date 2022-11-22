/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fpt.it17326.nhom5.service;

import com.fpt.it17326.nhom5.domainmodel.BaoHanh;
import com.fpt.it17326.nhom5.response.BaoHanhResponse;
import java.util.List;

/**
 *
 * @author youngboizseetinh
 */
public interface BaoHanhService {

    List<BaoHanhResponse> getAll();

    BaoHanhResponse getOne(String MaBaoHanh);

    String add(BaoHanh bh);

    String update(BaoHanh bh);

    String delete(BaoHanh bh);
}
