/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.it17326.nhom5.Service.Impl;

import com.fpt.it17326.nhom5.Repository.ViewTaiKhoanRepository;
import com.fpt.it17326.nhom5.Response.ViewTaiKhoanResponse;
import com.fpt.it17326.nhom5.Service.ViewTaiKhoanSerVice;
import com.fpt.it17326.nhom5.domainmodel.TaiKhoan;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tu
 */
public class ViewTaiKhoanServiceImpl implements ViewTaiKhoanSerVice {

    ViewTaiKhoanRepository vtkr = new ViewTaiKhoanRepository();

    @Override
    public List<ViewTaiKhoanResponse> getAll() {
       List<ViewTaiKhoanResponse> responses = new ArrayList<>();
        List<TaiKhoan> lists = vtkr.getAll();
        for (TaiKhoan tk : lists) {
            ViewTaiKhoanResponse vpr=new ViewTaiKhoanResponse(tk);
            responses.add(vpr);
        }
        return responses;
    }

    @Override
    public String add(TaiKhoan tk) {
        boolean add = vtkr.add(tk);
        if (add) {
            return "Dang ki thanh cong";
        } else {
            return "Dang ki khong thanh cong";
        }
    }

//    @Override
//    public String update(TaiKhoan tk1, String id) {
//        boolean update = vtkr.update(tk1, id);
//        if (update) {
//            return " thanh cong";
//        } else {
//            return " khong thanh cong";
//        }
//    }
//
//    @Override
//    public String delete(TaiKhoan tk) {
//        boolean delete = vtkr.delete(tk);
//        if (delete) {
//            return " thanh cong";
//        } else {
//            return " khong thanh cong";
//        }
//    }
public static void main(String[] args) {
        List<ViewTaiKhoanResponse> lists = new ViewTaiKhoanServiceImpl().getAll();
        for (ViewTaiKhoanResponse v : lists) {
            System.out.println(v.toString());
        }
    }

//    @Override
//    public Boolean DangNhap(TaiKhoan tk) {
//        if(tk.getTaiKhoan().trim().isEmpty()){
//            return "username khong duoc de trong";
//        }
//    }

    @Override
    public String update(TaiKhoan tk) {
        boolean update = vtkr.update(tk);
        if (update) {
            return "Thanh cong";
            
        }else{
            return "Khong thanh cong";
        }
        }

    @Override
    public List<TaiKhoan> getListTaiKhoan() {
        return vtkr.getAll();
    }

    @Override
    public TaiKhoan getOne(String Email) {
        return vtkr.getOne(Email);
    }

   
}
