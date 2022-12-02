/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.it17326.nhom5.service.impl;

import com.fpt.it17326.nhom5.domainmodel.HangDienThoai;
import com.fpt.it17326.nhom5.domainmodel.HoaDonChiTiet;
import com.fpt.it17326.nhom5.domainmodel.ImeiDaBan;
import com.fpt.it17326.nhom5.repository.HangDienThoaiRepository;
import com.fpt.it17326.nhom5.repository.HoaDonChiTietRepositiry;

import com.fpt.it17326.nhom5.response.HangDienThoaiResponse;
import com.fpt.it17326.nhom5.response.HoaDonChiTietResponse;
import com.fpt.it17326.nhom5.response.ThongkeResponse;
import com.fpt.it17326.nhom5.service.HoaDonChiTietService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PHAM DAC THANG
 */
public class HoaDonChiTietServiceImpl implements HoaDonChiTietService{
    
    private HoaDonChiTietRepositiry hdctRepository = new HoaDonChiTietRepositiry();
//thang
    @Override
    public List<ThongkeResponse> getAll1() {
        List<ThongkeResponse> lst = new ArrayList<>();
        List<HoaDonChiTiet> lstHDT = hdctRepository.getAll();

        for (HoaDonChiTiet x : lstHDT) {
            if (x.getHoaDon().isTrangThai()) {
                  ThongkeResponse hdct = new ThongkeResponse(x);
            lst.add(hdct);
            }
          
        }
        return lst;
       
   
    }
     @Override
    public List<ThongkeResponse> getAllimeidaban() {
        List<ThongkeResponse> lst = new ArrayList<>();
        List<ImeiDaBan> lstHDT = hdctRepository.getAllimaidaban();

        for (ImeiDaBan x : lstHDT) {
                  if (x.getHoaDonChiTiet().getHoaDon().isTrangThai()) {
            ThongkeResponse hdct = new ThongkeResponse(x);
            lst.add(hdct);
                  }
        }
        return lst;
       
   
    }
    //thang
     public static void main(String[] args) {
        new HoaDonChiTietServiceImpl().getAll1().forEach(s -> System.out.println(s.toString()));
    }
}
