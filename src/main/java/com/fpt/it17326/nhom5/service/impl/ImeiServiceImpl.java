/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.it17326.nhom5.service.impl;

import com.fpt.it17326.nhom5.domainmodel.Imei;
import com.fpt.it17326.nhom5.repository.ImeiRepository;
import com.fpt.it17326.nhom5.response.ImeiResponse;
import com.fpt.it17326.nhom5.service.ImeiService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author youngboizseetinh
 */
public class ImeiServiceImpl implements ImeiService{

    ImeiRepository imeiRepository = new ImeiRepository();

    @Override
    public List<ImeiResponse> getAll() {
        List<Imei> listImei = imeiRepository.getAll();
        List<ImeiResponse> lst = new ArrayList<>();

        for (Imei x : listImei) {
            ImeiResponse lsp = new ImeiResponse(x);
            lst.add(lsp);
        }

        return lst;
    }

    @Override
    public ImeiResponse getOne(String MaImei) {
        ImeiResponse lsp = new ImeiResponse(imeiRepository.getOne(MaImei));
        return lsp;
    }

    @Override
    public String add(Imei imei) {
        if (imeiRepository.add(imei)) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(Imei imei) {
        if (imeiRepository.update(imei)) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }
    }

    @Override
    public String delete(Imei imei) {
        if (imeiRepository.delete(imei)) {
            return "Xóa thành công";
        } else {
            return "Xóa thất bại";
        }
    }
}
