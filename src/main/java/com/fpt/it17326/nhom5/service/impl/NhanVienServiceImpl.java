package com.fpt.it17326.nhom5.service.impl;

import com.fpt.it17326.nhom5.domainmodel.NhanVien;
import com.fpt.it17326.nhom5.repository.NhanVienRepository;
import com.fpt.it17326.nhom5.response.NhanVienResponse;
import com.fpt.it17326.nhom5.service.NhanVienService;
import java.util.ArrayList;
import java.util.List;

/**
 * AowVN_Nyaruko
 *
 */
public class NhanVienServiceImpl implements NhanVienService {

    private NhanVienRepository nhanVienRepository = new NhanVienRepository();

    @Override
    public List<NhanVienResponse> getAll() {
        List<NhanVienResponse> lst = new ArrayList<>();
        List<NhanVien> lstNV = nhanVienRepository.getAll();

        for (NhanVien x : lstNV) {
            NhanVienResponse nv = new NhanVienResponse(x);
            lst.add(nv);
        }
        return lst;
    }

    @Override
    public NhanVienResponse getOne(String MaNhanVien) {
        return new NhanVienResponse(nhanVienRepository.getOne(MaNhanVien));
    }

    @Override
    public String add(NhanVien nv) {
        if (nhanVienRepository.add(nv)) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(NhanVien nv) {
        if (nhanVienRepository.update(nv)) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }
    }

    @Override
    public String delete(NhanVien nv) {
        if (nhanVienRepository.delete(nv)) {
            return "Xoá thành công";
        } else {
            return "Xoá thất bại";
        }
    }
}
