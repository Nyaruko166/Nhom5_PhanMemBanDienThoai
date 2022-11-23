package com.fpt.it17326.nhom5.response;

import com.fpt.it17326.nhom5.domainmodel.LoaiSP;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * AowVN_Nyaruko
 *
 */
@Getter
@Setter
public class LoaiSPResponse {

    private String maLoaiSP;
    private String tenDanhMuc;
    private String moTa;
    private Date createdAt;
    private boolean deleted;
    private Date updatedAt;

    public LoaiSPResponse() {
    }

    public LoaiSPResponse(LoaiSP lsp) {
        this.maLoaiSP = lsp.getMaLoaiSP();
        this.tenDanhMuc = lsp.getTenDanhMuc();
        this.moTa = lsp.getMoTa();
        this.createdAt = lsp.getCreatedAt();
        this.deleted = lsp.isDeleted();
        this.updatedAt = lsp.getUpdatedAt();
    }  
}
