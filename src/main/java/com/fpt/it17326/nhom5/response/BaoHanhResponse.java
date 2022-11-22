/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.it17326.nhom5.response;

import com.fpt.it17326.nhom5.domainmodel.BaoHanh;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author youngboizseetinh
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BaoHanhResponse {

    private String maBaoHanh;
    private String noiDungBaoHanh;
    private Long hanBaoHanh;
    private boolean trangThai;
    private Date createAt;
    private boolean deleted;
    private Date updateAt;

    public BaoHanhResponse(BaoHanh bh) {
        this.maBaoHanh = bh.getMaBaoHanh();
        this.noiDungBaoHanh = bh.getNoiDungBaoHanh();
        this.hanBaoHanh = bh.getHanBaoHanh();
        this.trangThai = bh.isTrangThai();
        this.createAt = bh.getCreatedAt();
        this.deleted = bh.isDeleted();
        this.updateAt = bh.getUpdatedAt();
    }

}
