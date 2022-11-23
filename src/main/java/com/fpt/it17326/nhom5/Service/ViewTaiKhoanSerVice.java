/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fpt.it17326.nhom5.Service;

import com.fpt.it17326.nhom5.Response.ViewTaiKhoanResponse;
import com.fpt.it17326.nhom5.domainmodel.TaiKhoan;
import java.util.List;

/**
 *
 * @author Tu
 */
public interface ViewTaiKhoanSerVice {
    List<ViewTaiKhoanResponse> getAll();
    List<TaiKhoan> getListTaiKhoan();
    String add(TaiKhoan tk);
    String update(TaiKhoan tk);
    TaiKhoan getOne(String Email);
//    String DangNhap(TaiKhoan tk);
//    String update(TaiKhoan tk, String id);
//    String delete(TaiKhoan tk);
}
