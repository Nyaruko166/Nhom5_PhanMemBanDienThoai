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

    private String MaMauSac;
    private String TenMauSac;
    private Date CreatedAt;
    private boolean Deleted;
    private Date UpdatedAt;

    public MauSacResponse() {
    }

    public MauSacResponse(MauSac ms) {
        this.MaMauSac = ms.getMaMauSac();
        this.TenMauSac = ms.getTenMauSac();
        this.CreatedAt = ms.getCreatedAt();
        this.Deleted = ms.getDeleted();
        this.UpdatedAt = ms.getUpdatedAt();
    }

}
