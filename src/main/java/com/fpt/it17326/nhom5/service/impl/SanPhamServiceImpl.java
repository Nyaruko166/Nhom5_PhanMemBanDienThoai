/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.it17326.nhom5.service.impl;

import com.fpt.it17326.nhom5.domainmodel.SanPham;
import com.fpt.it17326.nhom5.repository.SanPhamRepository;
import com.fpt.it17326.nhom5.response.SanPhamResponse;
import com.fpt.it17326.nhom5.service.SanPhamService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author youngboizseetinh
 */
@Service
public class SanPhamServiceImpl implements SanPhamService {

    private SanPhamRepository sanPhamRepository = new SanPhamRepository();

    @Async
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

//    @Override
//    public SanPhamResponse getOne(String tenSP) {
//        return new SanPhamResponse(sanPhamRepository.getOne(tenSP));
//    }

    @Async
    @Override
    public String add(SanPham sp) {
        if (sanPhamRepository.add(sp)) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Async
    @Override
    public String update(SanPham sp) {
        if (sanPhamRepository.update(sp)) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }
    }

    @Async
    @Override
    public String delete(SanPham sp) {
        if (sanPhamRepository.delete(sp)) {
            return "Xoá thành công";
        } else {
            return "Xoá thất bại";
        }
    }

    @Async
    @Override
    public String updateSL(SanPham sp, int sl) {

        if (sanPhamRepository.updateSL(sp, sl)) {
            return "Thêm sản phẩm thành công";
        } else {
            return "Thêm sản phẩm thất bại";
        }

    }

    @Override
    public List<SanPham> getAllSanPham() {
        return sanPhamRepository.getAll();
    }

    @Override
    public List<SanPham> getDeletedSanPham() {
        return sanPhamRepository.getAllDeleted();
    }

    @Override
    public SanPhamResponse getOne(String tenSP) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public SanPham getSPLast() {
        return sanPhamRepository.getSPLast();
    }

    @Override
    public List<SanPham> searchProduct(String name) {
        return sanPhamRepository.search(name);
    }

    @Async
    @Override
    public String restore(SanPham sp) {
        sp.setDeleted(false);
        // TODO Auto-generated method stub
        if (sanPhamRepository.update(sp)) {
            return "Khôi phục thành công";
        } else {
            return "Khôi phục thất bại";
        }
    }

    @Override
    public List<SanPham> searchDeletedProduct(String name) {
        // TODO Auto-generated method stub
        return sanPhamRepository.searchDeleted(name);
    }

    @Async
    @Override
    public int countRecord() {
        // TODO Auto-generated method stub
        return sanPhamRepository.count();
    }

}
