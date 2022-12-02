/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.it17326.nhom5.Response;

import com.fpt.it17326.nhom5.domainmodel.NhanVien;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Tu
 */
@ToString
@Getter
@Setter
public class NhanVienResponse {
    private String MaNhanVien;
    private String HoTen;
    private String TenCV;
    private String Email;
    private String TaiKhoan;
    private String MatKhau;
    private Date CreatedAt;
    private Boolean Deleted;
    

    public NhanVienResponse() {
    }

    public NhanVienResponse(NhanVien tk) {
        this.MaNhanVien=tk.getMaNhanVien();
        this.HoTen=tk.getHoTen();
        this.TenCV=tk.getTenCV();
        this.Email=tk.getEmail();
        this.TaiKhoan=tk.getTaiKhoan();
        this.MatKhau=tk.getMatKhau();
        this.CreatedAt=tk.getCreatedAt();
        this.Deleted=tk.getDeleted();
       
    }
//  public Object[] toRowData(){
//      return new Object[]{MaTaiKhoan,HoTen,TenCV,Email,TaiKhoan,MatKhau,CreatedAt,Deleted};
//  }
   
   
    
}
