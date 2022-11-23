/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.it17326.nhom5.response;

import com.fpt.it17326.nhom5.domainmodel.Chip;
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
public class ChipResponse {
    
    private String maChip;
    private String tenChip;
    private Date createAt;
    private boolean deleted;
    private Date updateAt;

    public ChipResponse() {
    }

    public ChipResponse(Chip chip) {
        this.maChip = chip.getMaChip();
        this.tenChip = chip.getTenChip();
        this.createAt = chip.getCreatedAt();
        this.deleted = chip.isDeleted();
        this.updateAt = chip.getUpdatedAt();
    }
    
    
}
