package com.fpt.it17326.nhom5.service;

import com.fpt.it17326.nhom5.domainmodel.HangDienThoai;
import com.fpt.it17326.nhom5.response.HangDienThoaiResponse;
import java.util.List;

/**
 * AowVN_Nyaruko
 *
 */
public interface HangDienThoaiService {

    List<HangDienThoaiResponse> getAll();

    List<HangDienThoai> getAllHangDT();

    List<HangDienThoai> getDeletedHangDT();

    HangDienThoaiResponse getOne(String MaAnh);

    String add(HangDienThoai hdt);

    String update(HangDienThoai hdt);

    String delete(HangDienThoai hdt);

    String restore(HangDienThoai hdt);

    List<HangDienThoai> searchDeletedHangDT(String name);
}
