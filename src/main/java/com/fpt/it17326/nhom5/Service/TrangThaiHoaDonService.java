package com.fpt.it17326.nhom5.service;

import com.fpt.it17326.nhom5.domainmodel.TrangThaiHoaDon;
import com.fpt.it17326.nhom5.response.TrangThaiHoaDonResponse;
import java.util.List;

/**
 * AowVN_Nyaruko
 *
 */
public interface TrangThaiHoaDonService {

    List<TrangThaiHoaDonResponse> getAll();

    TrangThaiHoaDonResponse getOne(String MaTT);

    String add(TrangThaiHoaDon tthd);

    String update(TrangThaiHoaDon tthd);

    String delete(TrangThaiHoaDon tthd);
}
