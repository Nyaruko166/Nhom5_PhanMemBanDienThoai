package com.fpt.it17326.nhom5.service;

import com.fpt.it17326.nhom5.domainmodel.MauSac;
import com.fpt.it17326.nhom5.response.MauSacResponse;
import java.util.List;

/**
 * AowVN_Nyaruko
 *
 */
public interface MauSacService {

    List<MauSacResponse> getAll();

    List<MauSac> getAllMauSac();
    
    List<MauSac> getDeletedMauSac();
    
    MauSacResponse getOne(String MaMauSac);
    
    String add(MauSac ms);

    String update(MauSac ms);

    String delete(MauSac ms);
}
