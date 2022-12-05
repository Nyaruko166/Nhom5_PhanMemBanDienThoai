package com.fpt.it17326.nhom5.service.impl;

import com.fpt.it17326.nhom5.domainmodel.Anh;
import com.fpt.it17326.nhom5.repository.AnhRepository;
import com.fpt.it17326.nhom5.response.AnhResponse;
import com.fpt.it17326.nhom5.service.AnhService;
import java.util.ArrayList;
import java.util.List;

/**
 * AowVN_Nyaruko
 *
 */
public class AnhServiceImpl implements AnhService {

    private AnhRepository AnhRepository = new AnhRepository();

    @Override
    public List<AnhResponse> getAll() {
        List<Anh> lstAnh = AnhRepository.getAll();
        List<AnhResponse> lst = new ArrayList<>();
        for (Anh x : lstAnh) {
            AnhResponse anh = new AnhResponse(x);
            lst.add(anh);
        }
        return lst;
    }

    @Override
    public String add(Anh anh) {
        if (AnhRepository.add(anh)) {
            return "Add thành công";
        } else {
            return "Add thất bại";
        }
    }

    @Override
    public String update(Anh anh) {
        if (AnhRepository.update(anh)) {
            return "Update thành công";
        } else {
            return "Update thất bại";
        }
    }

    @Override
    public String delete(Anh anh) {
        if (AnhRepository.delete(anh)) {
            return "Delete thành công";
        } else {
            return "Delete thất bại";
        }
    }

    @Override
    public AnhResponse getOne(String MaAnh) {
        AnhResponse anh = new AnhResponse(AnhRepository.getOne(MaAnh));
        return anh;
    }

    @Override
    public List<Anh> getAllAnh() {
        return AnhRepository.getAll();
    }

    @Override
    public List<Anh> getDeletedAnh() {
        return AnhRepository.getAllDeleted();
    }
}
