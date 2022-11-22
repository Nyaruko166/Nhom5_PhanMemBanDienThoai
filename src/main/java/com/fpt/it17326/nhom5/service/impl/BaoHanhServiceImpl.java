/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.it17326.nhom5.service.impl;

import com.fpt.it17326.nhom5.domainmodel.BaoHanh;
import com.fpt.it17326.nhom5.repository.BaoHanhRepository;
import com.fpt.it17326.nhom5.response.BaoHanhResponse;
import com.fpt.it17326.nhom5.service.BaoHanhService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author youngboizseetinh
 */
public class BaoHanhServiceImpl implements BaoHanhService {

    private BaoHanhRepository baoHanhRepository = new BaoHanhRepository();

    @Override
    public List<BaoHanhResponse> getAll() {
        List<BaoHanh> listBaoHanh = baoHanhRepository.getAll();
        List<BaoHanhResponse> lst = new ArrayList<>();
        for (BaoHanh x : listBaoHanh) {
            BaoHanhResponse bh = new BaoHanhResponse(x);
            lst.add(bh);
        }
        return lst;
    }

    @Override
    public BaoHanhResponse getOne(String MaBaoHanh) {
        BaoHanhResponse bh = new BaoHanhResponse(baoHanhRepository.getOne(MaBaoHanh));
        return bh;
    }

    @Override
    public String add(BaoHanh bh) {
        if (baoHanhRepository.add(bh)) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(BaoHanh bh) {
        if (baoHanhRepository.update(bh)) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }
    }

    @Override
    public String delete(BaoHanh bh) {
        if (baoHanhRepository.delete(bh)) {
            return "Xóa thành công";
        } else {
            return "Xóa thất bại";
        }
    }

}
