package com.fpt.it17326.nhom5.service.impl;

import com.fpt.it17326.nhom5.domainmodel.KhachHang;
import com.fpt.it17326.nhom5.repository.KhachHangRepository;
import com.fpt.it17326.nhom5.response.KhachHangResponse;
import com.fpt.it17326.nhom5.service.KhachHangService;
import java.util.ArrayList;
import java.util.List;

/**
 * AowVN_Nyaruko
 *
 */
public class KhachHangServiceImpl implements KhachHangService {

    private KhachHangRepository KhachHangRepository = new KhachHangRepository();

    @Override
    public List<KhachHang> getAll1() {
        return KhachHangRepository.getAll();
    }
    
    @Override
    public List<KhachHangResponse> getAll() {
        List<KhachHangResponse> lst = new ArrayList<>();
        List<KhachHang> lstKH = KhachHangRepository.getAll();
        for (KhachHang x : lstKH) {
            KhachHangResponse kh = new KhachHangResponse(x);
            lst.add(kh);
        }
        return lst;
    }

    @Override
    public KhachHang getOne(String MaKH) {
        return KhachHangRepository.getOne(MaKH);
    }

    @Override
    public String add(KhachHang kh) {
        if (KhachHangRepository.add(kh)) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(KhachHang kh) {
        if (KhachHangRepository.update(kh)) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }
    }

    @Override
    public String delete(KhachHang kh) {
        if (KhachHangRepository.delete(kh)) {
            return "Xoá thành công";
        } else {
            return "Xoá thất bại";
        }
    }

}
