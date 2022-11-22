package com.fpt.it17326.nhom5.service;

import com.fpt.it17326.nhom5.domainmodel.Anh;
import com.fpt.it17326.nhom5.response.AnhResponse;
import java.util.List;

/**
 * AowVN_Nyaruko
 *
 */
public interface AnhService {

    List<AnhResponse> getAll();

    String add(Anh anh);

    String update(Anh anh);

    String delete(Anh anh);
}
