/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fpt.it17326.nhom5.service;

import com.fpt.it17326.nhom5.domainmodel.Rom;
import com.fpt.it17326.nhom5.response.RomResponse;
import java.util.List;

/**
 *
 * @author youngboizseetinh
 */
public interface RomService {
    
     List<RomResponse> getAll();

    RomResponse getOne(String MaRom);
            
    String add(Rom rom);

    String update(Rom rom);

    String delete(Rom rom);
}
