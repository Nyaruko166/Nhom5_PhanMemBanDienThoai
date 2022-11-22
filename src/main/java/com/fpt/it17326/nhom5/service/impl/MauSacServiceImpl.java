package com.fpt.it17326.nhom5.service.impl;

import com.fpt.it17326.nhom5.domainmodel.MauSac;
import com.fpt.it17326.nhom5.repository.MauSacRepository;
import com.fpt.it17326.nhom5.response.MauSacResponse;
import com.fpt.it17326.nhom5.service.MauSacService;
import java.util.ArrayList;
import java.util.List;

/**
 * AowVN_Nyaruko
 *
 */
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
            return "Add thành công";
        } else {
            return "Add thất bại";
        }
    }

    @Override
    public String update(MauSac ms) {
        if (MauSacRepository.update(ms)) {
            return "Update thành công";
        } else {
            return "Update thất bại";
        }
    }

    @Override
    public String delete(MauSac ms) {
        if (MauSacRepository.delete(ms)) {
            return "Delete thành công";
        } else {
            return "Delete thất bại";
        }
    }
}
