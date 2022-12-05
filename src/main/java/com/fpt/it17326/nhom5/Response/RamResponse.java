/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.it17326.nhom5.response;

import com.fpt.it17326.nhom5.domainmodel.Ram;
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
public class RamResponse {
    
    private String maRam;
    private String dungLuong;
    private Date CreatedAt;
    private boolean Deleted;
    private Date UpdatedAt;

    public RamResponse() {
    }

    public RamResponse(Ram ram) {
        this.maRam = ram.getMaRam();
<<<<<<< HEAD:src/main/java/com/fpt/it17326/nhom5/response/RamResponse.java
        this.dungLuong = ram.getDungLuong();
=======
        this.tenRam = ram.getDungLuong();
>>>>>>> 5c568a85d6b46ebce7b9b9028cff26230569c535:src/main/java/com/fpt/it17326/nhom5/Response/RamResponse.java
        this.CreatedAt = ram.getCreatedAt();
        this.Deleted = ram.isDeleted();
        this.UpdatedAt = ram.getUpdatedAt();
    }
    
    
}
