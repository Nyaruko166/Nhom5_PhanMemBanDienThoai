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
public class KhuyenMaiServiceImpl implements KhuyenMaiService {

    KhuyenMaiRepository khuyenMaiRepository = new KhuyenMaiRepository();

    @Override
    public List<KhuyenMai> getAll() {
        List<KhuyenMai> listKM = khuyenMaiRepository.getAll();
        return listKM;
    }

    @Override
    public KhuyenMaiResponse getOne(int MaKM) {
        KhuyenMaiResponse lsp = new KhuyenMaiResponse(khuyenMaiRepository.getOne(MaKM));
        return lsp;
    }

    @Override
    public String addTheoHoaDon(KhuyenMai km) {
        if (khuyenMaiRepository.addTheoHoaDon(km)) {
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

    @Override
    public List<KhuyenMaiResponse> getAllTrue() {
        List<KhuyenMai> listKM = khuyenMaiRepository.getAllTrue();
        List<KhuyenMaiResponse> lst = new ArrayList<>();

        for (KhuyenMai x : listKM) {
            KhuyenMaiResponse km = new KhuyenMaiResponse(x);
            lst.add(km);
        }

        return lst;
    }

    @Override
    public List<KhuyenMaiResponse> getAllFalse() {
        List<KhuyenMai> listKM = khuyenMaiRepository.getAllFalse();
        List<KhuyenMaiResponse> lst = new ArrayList<>();

        for (KhuyenMai x : listKM) {
            KhuyenMaiResponse km = new KhuyenMaiResponse(x);
            lst.add(km);
        }

        return lst;
    }

}
