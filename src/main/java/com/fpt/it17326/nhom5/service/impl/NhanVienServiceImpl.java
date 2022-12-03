/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.it17326.nhom5.service.impl;

import com.fpt.it17326.nhom5.repository.NhanVienRepository;
import com.fpt.it17326.nhom5.response.NhanVienResponse;
import com.fpt.it17326.nhom5.domainmodel.NhanVien;
import java.util.ArrayList;
import java.util.List;
import com.fpt.it17326.nhom5.service.NhanVienService;

/**
 *
 * @author Tu
 */
public class NhanVienServiceImpl implements NhanVienService {

    NhanVienRepository vtkr = new NhanVienRepository();

    @Override
    public List<NhanVien> getAll() {
//       List<NhanVien> responses = new ArrayList<>();
//        List<NhanVien> lists = vtkr.getAll();
//        for (NhanVien tk : lists) {
//             vpr=new NhanVienResponse(tk);
//            responses.add(vpr);
//        }
//        return responses;
            return vtkr.getAll();
    }

    @Override
    public String add(NhanVien tk) {
        boolean add = vtkr.add(tk);
        if (add) {
            return "Dang ki thanh cong";
        } else {
            return "Dang ki khong thanh cong";
        }
    }

//    @Override
//    public String update(NhanVien tk1, String id) {
//        boolean update = vtkr.update(tk1, id);
//        if (update) {
//            return " thanh cong";
//        } else {
//            return " khong thanh cong";
//        }
//    }
//
//    @Override
//    public String delete(NhanVien tk) {
//        boolean delete = vtkr.delete(tk);
//        if (delete) {
//            return " thanh cong";
//        } else {
//            return " khong thanh cong";
//        }
//    }
public static void main(String[] args) {
//        List<NhanVienResponse> lists = new NhanVienServiceImpl().getAll();
//        for (NhanVienResponse v : lists) {
//            System.out.println(v.toString());
//        }
    }

//    @Override
//    public Boolean DangNhap(NhanVien tk) {
//        if(tk.getTaiKhoan().trim().isEmpty()){
//            return "username khong duoc de trong";
//        }
//    }

    @Override
    public String update(NhanVien tk) {
        boolean update = vtkr.update(tk);
        if (update) {
            return "Thanh cong";
            
        }else{
            return "Khong thanh cong";
        }
        }

    @Override
    public List<NhanVien> getListTaiKhoan() {
        return vtkr.getAll();
    }

    @Override
    public NhanVien getOne(String Email) {
        return vtkr.getOne(Email);
    }

    

   
}
