package com.fpt.it17326.nhom5.service.impl;

import com.fpt.it17326.nhom5.domainmodel.LoaiSP;
import com.fpt.it17326.nhom5.repository.LoaiSPRepository;
import com.fpt.it17326.nhom5.response.LoaiSPResponse;
import com.fpt.it17326.nhom5.service.LoaiSPService;
import java.util.ArrayList;
import java.util.List;

/**
 * AowVN_Nyaruko
 *
 */
public class LoaiSPServiceImpl implements LoaiSPService {

    LoaiSPRepository loaiSPRepository = new LoaiSPRepository();

    @Override
    public List<LoaiSPResponse> getAll() {
        List<LoaiSP> lstSP = loaiSPRepository.getAll();
        List<LoaiSPResponse> lst = new ArrayList<>();

        for (LoaiSP x : lstSP) {
            LoaiSPResponse lsp = new LoaiSPResponse(x);
            lst.add(lsp);
        }

        return lst;
    }

    @Override
    public LoaiSPResponse getOne(String MaAnh) {
        LoaiSPResponse lsp = new LoaiSPResponse(loaiSPRepository.getOne(MaAnh));
        return lsp;
    }

    @Override
    public String add(LoaiSP lsp) {
        if (loaiSPRepository.add(lsp)) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(LoaiSP lsp) {
        if (loaiSPRepository.update(lsp)) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }
    }

    @Override
    public String delete(LoaiSP lsp) {
        if (loaiSPRepository.delete(lsp)) {
            return "Xóa thành công";
        } else {
            return "Xóa thất bại";
        }
    }
}
