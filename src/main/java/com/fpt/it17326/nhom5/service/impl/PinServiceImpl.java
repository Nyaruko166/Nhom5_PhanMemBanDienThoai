/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.it17326.nhom5.service.impl;

import com.fpt.it17326.nhom5.domainmodel.Pin;
import com.fpt.it17326.nhom5.repository.ChipRepository;
import com.fpt.it17326.nhom5.repository.PinRepository;
import com.fpt.it17326.nhom5.response.PinResponse;
import com.fpt.it17326.nhom5.service.PinService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author youngboizseetinh
 */
public class PinServiceImpl implements PinService {

    private PinRepository pinRepository = new PinRepository();

    @Override
    public List<PinResponse> getAll() {
        List<Pin> listPin = pinRepository.getAll();
        List<PinResponse> lst = new ArrayList<>();
        for (Pin x : listPin) {
            PinResponse pin = new PinResponse(x);
            lst.add(pin);
        }
        return lst;
    }

    @Override
    public PinResponse getOne(String MaPin) {
        PinResponse pin = new PinResponse(pinRepository.getOne(MaPin));
        return pin;
    }

    @Override
    public String add(Pin pin) {
        if (pinRepository.add(pin)) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(Pin pin) {
        if (pinRepository.update(pin)) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }
    }

    @Override
    public String delete(Pin pin) {
        if (pinRepository.delete(pin)) {
            return "Xóa thành công";
        } else {
            return "Xóa thất bại";
        }
    }

    @Override
    public List<Pin> getAllPin() {
        return pinRepository.getAll();
    }

    @Override
    public List<Pin> getDeletedPin() {
        return pinRepository.getAllDeleted();
    }

}
