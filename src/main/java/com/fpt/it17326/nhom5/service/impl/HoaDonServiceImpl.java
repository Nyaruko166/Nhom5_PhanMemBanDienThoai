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
        for (HoaDon hoaDon : lstHD) {
            HoaDonResponse ms = new HoaDonResponse(hoaDon);
            lst.add(ms);
        }
        return lst;
    }
    
    @Override
    public HoaDon getOne(String MaHoaDon) {
        return hoaDonRepository.getOne(MaHoaDon);
    }
    
    @Override
    public String add(HoaDon hd) {
        
        boolean add = hoaDonRepository.add(hd);
        if(add){
            return "Tạo thành công";
        }else{
            return "Tạo thất bại";
        }
    }
    
    @Override
    public String update(HoaDon hd) {
        boolean update = hoaDonRepository.update(hd);
        if(update){
            return "Sửa thành công";
        }else{
            return "Sửa thất bại";
        }
    }
    
    @Override
    public String delete(HoaDon hd) {
        boolean delete = hoaDonRepository.delete(hd);
        if(delete){
            return "Xóa thành công";
        }else{
            return "Xóa thất bại";
        }
    }
    
}
