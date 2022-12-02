/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.it17326.nhom5.service.impl;

import com.fpt.it17326.nhom5.domainmodel.KhuyenMai;
import com.fpt.it17326.nhom5.repository.KhuyenMaiRepository;
import com.fpt.it17326.nhom5.response.KhuyenMaiResponse;
import com.fpt.it17326.nhom5.service.KhuyenMaiService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author youngboizseetinh
 */
public class KhuyenMaiServiceImpl  implements KhuyenMaiService{

    KhuyenMaiRepository khuyenMaiRepository = new KhuyenMaiRepository();
    
    @Override
    public List<KhuyenMaiResponse> getAll() {
        List<KhuyenMai> listKM = khuyenMaiRepository.getAll();
        List<KhuyenMaiResponse> lst = new ArrayList<>();

        for (KhuyenMai x : listKM) {
            KhuyenMaiResponse km = new KhuyenMaiResponse(x);
            lst.add(km);
        }

        return lst;
    }

    @Override
    public KhuyenMaiResponse getOne(String MaKM) {
        KhuyenMaiResponse lsp = new KhuyenMaiResponse(khuyenMaiRepository.getOne(MaKM));
        return lsp;
    }

    @Override
    public String add(KhuyenMai km) {
        if (khuyenMaiRepository.add(km)) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(KhuyenMai km) {
        if (khuyenMaiRepository.update(km)) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }
    }

    @Override
    public String delete(KhuyenMai km) {
        if (khuyenMaiRepository.delete(km)) {
            return "Xóa thành công";
        } else {
            return "Xóa thất bại";
        }
    }
    
}