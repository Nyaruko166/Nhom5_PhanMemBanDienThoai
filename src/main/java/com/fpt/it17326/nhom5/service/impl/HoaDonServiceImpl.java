package com.fpt.it17326.nhom5.service.impl;

import com.fpt.it17326.nhom5.domainmodel.HoaDon;
import com.fpt.it17326.nhom5.repository.HoaDonRepository;
import com.fpt.it17326.nhom5.response.HoaDonResponse;
import com.fpt.it17326.nhom5.service.HoaDonService;
import java.util.ArrayList;
import java.util.List;

/**
 * AowVN_Nyaruko
 *
 */
public class HoaDonServiceImpl implements HoaDonService {

    private HoaDonRepository hoaDonRepository = new HoaDonRepository();

    @Override
    public List<HoaDonResponse> getAll() {
        List<HoaDonResponse> lst = new ArrayList<>();
        List<HoaDon> lstHD = hoaDonRepository.getAll();
    }

    @Override
    public HoaDonResponse getOne(String MaHoaDon) {
    }

    @Override
    public String add(HoaDon hd) {
    }

    @Override
    public String update(HoaDon hd) {
    }

    @Override
    public String delete(HoaDon hd) {
    }

}