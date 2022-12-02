/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.it17326.nhom5.response;

import com.fpt.it17326.nhom5.domainmodel.Rom;
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
public class RomResponse {
    
    private String maRom;
    private String tenRom;
    private Date CreatedAt;
    private boolean Deleted;
    private Date UpdatedAt;

    public RomResponse() {
    }

    public RomResponse(Rom rom) {
        this.maRom = rom.getMaRom();
        this.tenRom = rom.getTenRom();
        this.CreatedAt = rom.getCreatedAt();
        this.Deleted = rom.isDeleted();
        this.UpdatedAt = rom.getUpdatedAt();
    }
    
    
}
