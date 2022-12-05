package com.fpt.it17326.nhom5.response;

import com.fpt.it17326.nhom5.domainmodel.MauSac;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * AowVN_Nyaruko
 *
 */
@Getter
@Setter
@ToString
public class MauSacResponse {

    private String maMauSac;
    private String tenMauSac;
    private Date createdAt;
    private boolean deleted;
    private Date updatedAt;

    public MauSacResponse() {
    }

    public MauSacResponse(MauSac ms) {
        this.maMauSac = ms.getMaMauSac();
        this.tenMauSac = ms.getTenMauSac();
        this.createdAt = ms.getCreatedAt();
        this.deleted = ms.isDeleted();
        this.updatedAt = ms.getUpdatedAt();
    }

}
