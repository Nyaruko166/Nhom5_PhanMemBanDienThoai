package com.fpt.it17326.nhom5.response;

import com.fpt.it17326.nhom5.domainmodel.HangDienThoai;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * AowVN_Nyaruko
 *
 */
@Getter
@Setter
public class HangDienThoaiResponse {

    private String maHangDT;
    private String tenHang;
    private Date createdAt;
    private boolean deleted;
    private Date updatedAt;

    public HangDienThoaiResponse() {
    }

    public HangDienThoaiResponse(HangDienThoai hdt) {
        this.maHangDT = hdt.getMaHangDT();
        this.tenHang = hdt.getTenHang();
        this.createdAt = hdt.getCreatedAt();
        this.deleted = hdt.isDeleted();
        this.updatedAt = hdt.getUpdatedAt();
    }

}
