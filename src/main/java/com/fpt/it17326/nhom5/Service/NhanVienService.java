/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fpt.it17326.nhom5.Service;

import com.fpt.it17326.nhom5.Response.NhanVienResponse;
import com.fpt.it17326.nhom5.domainmodel.NhanVien;
import java.util.List;

/**
 *
 * @author Tu
 */
public interface NhanVienService {
    List<NhanVien> getAll();
    List<NhanVien> getListTaiKhoan();
    String add(NhanVien tk);
    String update(NhanVien tk);
    NhanVien getOne(String Email);
     
//    String DangNhap(NhanVien tk);
//    String update(NhanVien tk, String id);
//    String delete(NhanVien tk);
}
