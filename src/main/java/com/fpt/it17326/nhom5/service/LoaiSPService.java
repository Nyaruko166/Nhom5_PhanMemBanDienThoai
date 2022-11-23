package com.fpt.it17326.nhom5.service;

import com.fpt.it17326.nhom5.domainmodel.LoaiSP;
import com.fpt.it17326.nhom5.response.LoaiSPResponse;
import java.util.List;

/**
 * AowVN_Nyaruko
 *
 */
public interface LoaiSPService {

    List<LoaiSPResponse> getAll();

    LoaiSPResponse getOne(String MaAnh);

    String add(LoaiSP lsp);

    String update(LoaiSP lsp);

    String delete(LoaiSP lsp);
}
