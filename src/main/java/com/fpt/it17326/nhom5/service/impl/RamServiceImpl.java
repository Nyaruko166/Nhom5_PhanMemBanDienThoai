/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.it17326.nhom5.service.impl;

import com.fpt.it17326.nhom5.domainmodel.Ram;
import com.fpt.it17326.nhom5.repository.RamRepository;
import com.fpt.it17326.nhom5.response.RamResponse;
import com.fpt.it17326.nhom5.service.RamService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 *
 * @author youngboizseetinh
 */
@Service
public class RamServiceImpl implements RamService {

    private RamRepository ramRepository = new RamRepository();

    @Override
    public List<RamResponse> getAll() {
        List<Ram> listRam = ramRepository.getAll();
        List<RamResponse> lst = new ArrayList<>();
        for (Ram x : listRam) {
            RamResponse ram = new RamResponse(x);
            lst.add(ram);
        }
        return lst;
    }

    @Override
    public RamResponse getOne(String MaRam) {
        RamResponse ram = new RamResponse(ramRepository.getOne(MaRam));
        return ram;
    }

    @Override
    public String add(Ram ram) {
        if (ramRepository.add(ram)) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(Ram ram) {
        if (ramRepository.update(ram)) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }
    }

    @Override
    public String delete(Ram ram) {
        if (ramRepository.delete(ram)) {
            return "Xóa thành công";
        } else {
            return "Xóa thất bại";
        }
    }

    @Override
    public List<Ram> getAllRam() {
        return ramRepository.getAll();
    }

    @Override
    public List<Ram> getDeletedRam() {
        return ramRepository.getAllDeleted();
    }

    @Async
    @Override
    public String restore(Ram ram) {
        ram.setDeleted(false);
        if (ramRepository.update(ram)) {
            return "Khôi phục thành công";
        } else {
            return "Khôi phục thất bại";
        }
    }

    @Override
    public List<Ram> searchDeletedRam(String name) {
        return ramRepository.searchDeleted(name);
    }

}
