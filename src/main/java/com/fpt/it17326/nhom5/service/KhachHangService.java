package com.fpt.it17326.nhom5.service;

import com.fpt.it17326.nhom5.domainmodel.KhachHang;
import com.fpt.it17326.nhom5.response.KhachHangResponse;
import java.util.List;

/**
 * AowVN_Nyaruko
 *
 */
public interface KhachHangService {

    List<KhachHangResponse> getAll();

    KhachHang getOne(String MaKH);

    String add(KhachHang kh);

    String update(KhachHang kh);

    String delete(KhachHang kh);
}
