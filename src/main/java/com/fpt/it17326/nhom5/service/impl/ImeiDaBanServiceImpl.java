/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.it17326.nhom5.service.impl;

import com.fpt.it17326.nhom5.domainmodel.ImeiDaBan;
import com.fpt.it17326.nhom5.repository.ImeiDaBanRepository;
import com.fpt.it17326.nhom5.response.ImeiDaBanResponse;
import com.fpt.it17326.nhom5.service.ImeiDaBanService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author youngboizseetinh
 */
public class ImeiDaBanServiceImpl implements ImeiDaBanService {

    ImeiDaBanRepository imeiDaBanRepository = new ImeiDaBanRepository();

    @Override
    public List<ImeiDaBanResponse> getAll() {
        List<ImeiDaBan> listImeiDaBan = imeiDaBanRepository.getAll();
        List<ImeiDaBanResponse> lst = new ArrayList<>();

        for (ImeiDaBan x : listImeiDaBan) {
            ImeiDaBanResponse lsp = new ImeiDaBanResponse(x);
            lst.add(lsp);
        }

        return lst;
    }

    @Override
    public ImeiDaBanResponse getOne(String MaImei) {
        ImeiDaBanResponse lsp = new ImeiDaBanResponse(imeiDaBanRepository.getOne(MaImei));
        return lsp;
    }

    @Override
    public String add(ImeiDaBan imeiDaBan) {
        if (imeiDaBanRepository.add(imeiDaBan)) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(ImeiDaBan imeiDaBan) {
        if (imeiDaBanRepository.update(imeiDaBan)) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }
    }

    @Override
    public String delete(ImeiDaBan imeiDaBan) {
        if (imeiDaBanRepository.delete(imeiDaBan)) {
            return "Xóa thành công";
        } else {
            return "Xóa thất bại";
        }
    }
}
