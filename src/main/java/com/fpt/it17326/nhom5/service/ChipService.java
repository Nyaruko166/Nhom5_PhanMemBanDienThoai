/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fpt.it17326.nhom5.service;

import com.fpt.it17326.nhom5.domainmodel.Chip;
import com.fpt.it17326.nhom5.response.ChipResponse;
import java.util.List;

/**
 *
 * @author youngboizseetinh
 */
public interface ChipService {
    
    List<ChipResponse> getAll();

    ChipResponse getOne(String MaChip);
            
    String add(Chip chip);

    String update(Chip chip);

    String delete(Chip chip);
}