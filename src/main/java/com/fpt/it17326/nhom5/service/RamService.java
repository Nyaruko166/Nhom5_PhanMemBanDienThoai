/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.it17326.nhom5.service;

import com.fpt.it17326.nhom5.domainmodel.Ram;
import com.fpt.it17326.nhom5.response.RamResponse;
import java.util.List;

/**
 *
 * @author youngboizseetinh
 */
public interface RamService {
    
    List<RamResponse> getAll();
    
    List<Ram> getAllRam();
    
    List<Ram> getDeletedRam();

    RamResponse getOne(String MaRam);
            
    String add(Ram ram);

    String update(Ram ram);

    String delete(Ram ram);
    
    String restore(Ram ram);
    
    List<Ram> searchDeletedRam(String name);
}
