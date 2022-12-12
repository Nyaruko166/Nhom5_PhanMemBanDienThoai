/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fpt.it17326.nhom5.service;

import com.fpt.it17326.nhom5.response.NhanVienResponse;
import com.fpt.it17326.nhom5.domainmodel.NhanVien;
import java.util.List;

/**
 *
 * @author Tu
 */
public interface NhanVienService {

    List<NhanVien> getAll1();

    List<NhanVien> getListTaiKhoan();
//    String add(NhanVien tk);
//    String update(NhanVien tk);

    NhanVien getOne(String Email);

    String DangNhap(NhanVien tk);
//    String update(NhanVien tk, String id);
//    String delete(NhanVien tk);

    List<NhanVienResponse> getAll();
    
    List<NhanVien> getAllNV();

    List<NhanVienResponse> getAllTrue();

    List<NhanVienResponse> getAllFalse();

    NhanVienResponse getOne1(String MaNhanVien);
    
    List<NhanVien> timNV (String MaNhanVien);

    String add(NhanVien nv);

    String update(NhanVien nv);

    String delete(NhanVien nv);
    NhanVien getOneByUsername(String username);
}
