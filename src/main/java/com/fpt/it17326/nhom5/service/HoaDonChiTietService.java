/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fpt.it17326.nhom5.service;

import com.fpt.it17326.nhom5.response.HangDienThoaiResponse;
import com.fpt.it17326.nhom5.response.HoaDonChiTietResponse;
import com.fpt.it17326.nhom5.response.ThongkeResponse;
import java.util.List;

/**
 *
 * @author PHAM DAC THANG
 */
public interface HoaDonChiTietService {
     public List<ThongkeResponse> getAll1() ;
      public List<ThongkeResponse> getAllimeidaban();
}