/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.it17326.nhom5.service.impl;

import com.fpt.it17326.nhom5.domainmodel.SanPham;
import com.fpt.it17326.nhom5.repository.SanPhamRepository;
import com.fpt.it17326.nhom5.response.SanPhamResponse;
import com.fpt.it17326.nhom5.service.SanPhamService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author youngboizseetinh
 */
public class SanPhamServiceImpl implements SanPhamService {
    
    private SanPhamRepository sanPhamRepository = new SanPhamRepository();
    
    @Override
    public List<SanPhamResponse> getAll() {
        List<SanPham> listSP = sanPhamRepository.getAll();
        List<SanPhamResponse> lst = new ArrayList<>();
        for (SanPham x : listSP) {
            SanPhamResponse sp = new SanPhamResponse(x);
            lst.add(sp);
        }
        return lst;
    }
    
    @Override
    public SanPhamResponse getOne(String MaSP) {
        return new SanPhamResponse(sanPhamRepository.getOne(MaSP));
    }
    
    @Override
    public String add(SanPham sp) {
        if (sanPhamRepository.add(sp)) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }
    
    @Override
    public String update(SanPham sp) {
        if (sanPhamRepository.update(sp)) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }
    }
    
    @Override
    public String delete(SanPham sp) {
        if (sanPhamRepository.delete(sp)) {
            return "Xoá thành công";
        } else {
            return "Xoá thất bại";
        }
    }
    
    @Override
    public String updateSL(SanPham sp, int sl) {
        
        if (sanPhamRepository.updateSL(sp, sl)) {
            return "Thêm sản phẩm thành công";
        } else {
            return "Thêm sản phẩm thất bại";
        }
        
    }
}
