package com.fpt.it17326.nhom5.service.impl;

import com.fpt.it17326.nhom5.domainmodel.TrangThaiHoaDon;
import com.fpt.it17326.nhom5.repository.TrangThaiHoaDonRepository;
import com.fpt.it17326.nhom5.response.TrangThaiHoaDonResponse;
import com.fpt.it17326.nhom5.service.TrangThaiHoaDonService;
import java.util.ArrayList;
import java.util.List;

/**
 * AowVN_Nyaruko
 *
 */
public class TrangThaiHoaDonServiceImpl implements TrangThaiHoaDonService {

    private TrangThaiHoaDonRepository repository = new TrangThaiHoaDonRepository();

    @Override
    public List<TrangThaiHoaDonResponse> getAll() {
        List<TrangThaiHoaDonResponse> lst = new ArrayList<>();
        List<TrangThaiHoaDon> lstTTHD = repository.getAll();

        for (TrangThaiHoaDon x : lstTTHD) {
            TrangThaiHoaDonResponse tthd = new TrangThaiHoaDonResponse(x);
            lst.add(tthd);
        }
        return lst;
    }

    @Override
    public TrangThaiHoaDonResponse getOne(String MaTT) {
        return new TrangThaiHoaDonResponse(repository.getOne(MaTT));
    }

    @Override
    public String add(TrangThaiHoaDon tthd) {
        if (repository.add(tthd)) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(TrangThaiHoaDon tthd) {
        if (repository.update(tthd)) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }
    }

    @Override
    public String delete(TrangThaiHoaDon tthd) {
        if (repository.delete(tthd)) {
            return "Xoá thành công";
        } else {
            return "Xoá thất bại";
        }
    }

}
