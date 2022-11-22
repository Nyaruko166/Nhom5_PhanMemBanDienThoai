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

    private String MaAnh;
    private String UrlAnh;
    private boolean Cover;
    private Date CreateAt;
    private boolean Deleted;
    private Date UpdateAt;

    public AnhResponse() {
    }

    public AnhResponse(Anh anh) {
        this.MaAnh = anh.getMaAnh();
        this.UrlAnh = anh.getUrlAnh();
        this.Cover = anh.isCover();
        this.CreateAt = anh.getCreatedAt();
        this.Deleted = isDeleted();
        this.UpdateAt = anh.getUpdatedAt();
    }

}
