/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.it17326.nhom5.response;

import com.fpt.it17326.nhom5.domainmodel.Imei;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author youngboizseetinh
 */
@Getter
@Setter
@ToString
public class ImeiResponse {
    
    private String maImei;
    private String tenImei;
    private Date createdAt;
    private boolean deleted;
    private Date updatedAt;

    public ImeiResponse() {
    }

    public ImeiResponse(Imei imei) {
        this.maImei = imei.getMaImel();
        this.tenImei = imei.getImei();
        this.createdAt = imei.getCreatedAt();
        this.deleted = imei.isDeleted();
        this.updatedAt = imei.getUpdatedAt();
    }
    
    
}
