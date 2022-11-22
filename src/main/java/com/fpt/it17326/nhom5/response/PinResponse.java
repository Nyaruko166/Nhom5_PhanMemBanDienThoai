/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.it17326.nhom5.response;

import com.fpt.it17326.nhom5.domainmodel.Pin;
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
public class PinResponse {
    
    private String MaPin;
    private String TenPin;
    private Date CreatedAt;
    private boolean Deleted;
    private Date UpdatedAt;

    public PinResponse() {
    }

    public PinResponse(Pin pin) {
        this.MaPin = pin.getMaPin();
        this.TenPin = pin.getTenPin();
        this.CreatedAt = pin.getCreatedAt();
        this.Deleted = pin.isDeleted();
        this.UpdatedAt = pin.getUpdatedAt();
    }
    
    
}
