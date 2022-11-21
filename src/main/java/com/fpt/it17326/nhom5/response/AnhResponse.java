package com.fpt.it17326.nhom5.response;

import com.fpt.it17326.nhom5.domainmodel.Anh;
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
public class AnhResponse {

    private String maAnh;
    private String urlAnh;
    private boolean cover;
    private Date createAt;
    private boolean deleted;
    private Date UpdateAt;

    public AnhResponse() {
    }

    public AnhResponse(Anh anh) {
        this.maAnh = anh.getMaAnh();
        this.urlAnh = anh.getUrlAnh();
        this.cover = anh.isCover();
        this.createAt = anh.getCreatedAt();
        this.deleted = isDeleted();
        this.UpdateAt = anh.getUpdatedAt();
    }
    
    
}
