package com.fpt.it17326.nhom5.service.impl;

import com.fpt.it17326.nhom5.domainmodel.MauSac;
import com.fpt.it17326.nhom5.repository.MauSacRepository;
import com.fpt.it17326.nhom5.response.MauSacResponse;
import com.fpt.it17326.nhom5.service.MauSacService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * AowVN_Nyaruko
 *
 */
@Service
public class MauSacServiceImpl implements MauSacService {

    private MauSacRepository MauSacRepository = new MauSacRepository();

    @Override
    public List<MauSacResponse> getAll() {
        List<MauSacResponse> lst = new ArrayList<>();
        List<MauSac> lstMS = MauSacRepository.getAll();

        for (MauSac x : lstMS) {
            MauSacResponse ms = new MauSacResponse(x);
            lst.add(ms);
        }
        return lst;
    }

    @Override
    public MauSacResponse getOne(String MaMauSac) {
        MauSacResponse ms = new MauSacResponse(MauSacRepository.getOne(MaMauSac));
        return ms;
    }

    @Override
    public String add(MauSac ms) {
        if (MauSacRepository.add(ms)) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(MauSac ms) {
        if (MauSacRepository.update(ms)) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }
    }

    @Override
    public String delete(MauSac ms) {
        if (MauSacRepository.delete(ms)) {
            return "Xóa thành công";
        } else {
            return "Xóa thất bại";
        }
    }

    @Override
    public List<MauSac> getAllMauSac() {
        return MauSacRepository.getAll();
    }

    @Override
    public List<MauSac> getDeletedMauSac() {
        return MauSacRepository.getAllDeleted();
    }

    @Async
    @Override
    public String restore(MauSac ms) {
        ms.setDeleted(false);
        if (MauSacRepository.update(ms)) {
            return "Khôi phục thành công";
        } else {
            return "Khôi phục thất bại";
        }
    }

    @Override
    public List<MauSac> searchDeletedMauSac(String name) {
        return MauSacRepository.searchDeleted(name);
    }
}
