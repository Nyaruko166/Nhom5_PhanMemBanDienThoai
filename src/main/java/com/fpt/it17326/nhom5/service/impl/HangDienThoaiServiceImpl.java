package com.fpt.it17326.nhom5.service.impl;

import com.fpt.it17326.nhom5.domainmodel.HangDienThoai;
import com.fpt.it17326.nhom5.repository.HangDienThoaiRepository;
import com.fpt.it17326.nhom5.response.HangDienThoaiResponse;
import com.fpt.it17326.nhom5.service.HangDienThoaiService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * AowVN_Nyaruko
 *
 */
@Service
public class HangDienThoaiServiceImpl implements HangDienThoaiService {

    private HangDienThoaiRepository hangDienThoaiRepository = new HangDienThoaiRepository();

    @Override
    public List<HangDienThoaiResponse> getAll() {
        List<HangDienThoaiResponse> lst = new ArrayList<>();
        List<HangDienThoai> lstHDT = hangDienThoaiRepository.getAll();

        for (HangDienThoai x : lstHDT) {
            HangDienThoaiResponse hdt = new HangDienThoaiResponse(x);
            lst.add(hdt);
        }
        return lst;
    }

    @Override
    public HangDienThoaiResponse getOne(String MaAnh) {
        return new HangDienThoaiResponse(hangDienThoaiRepository.getOne(MaAnh));
    }

    @Override
    public String add(HangDienThoai hdt) {
        if (hangDienThoaiRepository.add(hdt)) {
            return "Add thành công";
        } else {
            return "Add thất bại";
        }
    }

    @Override
    public String update(HangDienThoai hdt) {
        if (hangDienThoaiRepository.update(hdt)) {
            return "Update thành công";
        } else {
            return "Update thất bại";
        }
    }

    @Override
    public String delete(HangDienThoai hdt) {
        if (hangDienThoaiRepository.delete(hdt)) {
            return "Delete thành công";
        } else {
            return "Delete thất bại";
        }
    }

    @Override
    public List<HangDienThoai> getAllHangDT() {
        return hangDienThoaiRepository.getAll();
    }

    @Override
    public List<HangDienThoai> getDeletedHangDT() {
        return hangDienThoaiRepository.getAllDeleted();
    }

    @Async
    @Override
    public String restore(HangDienThoai hdt) {
        hdt.setDeleted(false);
        if (hangDienThoaiRepository.update(hdt)) {
            return "Khôi phục thành công";
        } else {
            return "Khôi phục thất bại";
        }
    }

    @Override
    public List<HangDienThoai> searchDeletedHangDT(String name) {
        return hangDienThoaiRepository.searchDeleted(name);
    }

}
