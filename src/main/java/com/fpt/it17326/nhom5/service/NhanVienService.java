package com.fpt.it17326.nhom5.service;

import com.fpt.it17326.nhom5.domainmodel.NhanVien;
import com.fpt.it17326.nhom5.response.NhanVienResponse;
import java.util.List;

/**
 * AowVN_Nyaruko
 *
 */
public interface NhanVienService {

    List<NhanVienResponse> getAll();

    NhanVienResponse getOne(String MaNhanVien);

    String add(NhanVien nv);

    String update(NhanVien nv);

    String delete(NhanVien nv);
}
