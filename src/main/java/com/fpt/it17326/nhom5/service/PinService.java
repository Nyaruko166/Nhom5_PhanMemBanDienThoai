/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fpt.it17326.nhom5.service;

import com.fpt.it17326.nhom5.domainmodel.Pin;
import com.fpt.it17326.nhom5.response.PinResponse;
import java.util.List;

/**
 *
 * @author youngboizseetinh
 */
public interface PinService {

    List<PinResponse> getAll();

    PinResponse getOne(String MaPin);

    String add(Pin pin);

    String update(Pin pin);

    String delete(Pin pin);
}
