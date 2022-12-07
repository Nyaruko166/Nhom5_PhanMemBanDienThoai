/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.it17326.nhom5.service.impl;

import com.fpt.it17326.nhom5.domainmodel.HangDienThoai;
import com.fpt.it17326.nhom5.domainmodel.HoaDonChiTiet;
import com.fpt.it17326.nhom5.domainmodel.ImeiDaBan;
import com.fpt.it17326.nhom5.domainmodel.SanPham;
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
public class HoaDonChiTietServiceImpl implements HoaDonChiTietService {

    private HoaDonChiTietRepositiry hdctRepository = new HoaDonChiTietRepositiry();

    @Override
    public List<HoaDonChiTiet> getAll() {
        return hdctRepository.getAll();
    }

    @Override
    public HoaDonChiTiet getOne(String Id) {
        return hdctRepository.getOne(Id);
    }

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
    
         public List<ThongkeResponse> getAllsp() {
           List<ThongkeResponse> lst = new ArrayList<>();
        List<SanPham> lstHDT = hdctRepository.getAllsp();

        for (SanPham x : lstHDT) {
         
                  ThongkeResponse hdct = new ThongkeResponse(x);
            lst.add(hdct);
            
          
        }
        return lst;
          
          }
         
          
    public List<ThongkeResponse> getAl2(){
    return hdctRepository.getAl2();
    }
    
    

      public List<ThongkeResponse> getAl4(String a, String b) {


        List<ThongkeResponse> lstHD =hdctRepository.getAl4(a,b);
               List<ThongkeResponse> v = new ArrayList<>();
          for (int i=0;i<lstHD.size();i++) {
              int kt=0;
     int   vt=0;
              if (v.size()==0) {
                  
                      v.add(lstHD.get(i));
              }else{
              
               for (int j=0;j<v.size();j++) {
                  if (lstHD.get(i).getMaSP().equals(v.get(j).getMaSP())) {
                     
                    
                 
                        kt=1;
                        vt=j;
                  
              }
            }
            
              
                  if (kt==1) {
                        v.get(vt).setTongsoLuong(lstHD.get(i).getTongsoLuong()+v.get(vt).getTongsoLuong());
                  } else {
                         v.add(lstHD.get(i));
                      
                  }
                  }
   
              
              
          }
          
        return v;
      }
    //thang
      
      
       public  float getAll3(String b) {
          float t=0;
           for ( ThongkeResponse c :  hdctRepository.getAll3(b)) {
               t=t     +c.getTongdoangthu();
           }
           
           
           return t;
           }
    //thang
    public static void main(String[] args) {
        new HoaDonChiTietServiceImpl().getAll1().forEach(s -> System.out.println(s.toString()));
    }
}
