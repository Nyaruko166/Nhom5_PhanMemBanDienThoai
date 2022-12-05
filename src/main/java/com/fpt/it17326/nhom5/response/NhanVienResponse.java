/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.it17326.nhom5.response;

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
    private boolean GioiTinh;
    private String TenCV;
    private String Email;
    private String QueQuan;
    private String NgaySinh;
    private String TaiKhoan;
    private String MatKhau;
    private Date CreatedAt;
    private boolean Deleted;
    private Date UpdatedAt;
    

    public NhanVienResponse() {
    }

    public NhanVienResponse(NhanVien tk) {
        this.MaNhanVien=tk.getMaNhanVien();
        this.HoTen=tk.getHoTen();
        this.GioiTinh = tk.isGioiTinh();
        this.TenCV=tk.getTenCV();
        this.Email=tk.getEmail();
        this.QueQuan = tk.getQueQuan();
        this.NgaySinh = tk.getNgaySinh();
        this.TaiKhoan=tk.getTaiKhoan();
        this.MatKhau=tk.getMatKhau();
        this.CreatedAt=tk.getCreatedAt();
        this.Deleted=tk.isDeleted();
        this.UpdatedAt=tk.getUpdatedAt();
       
    }
//  public Object[] toRowData(){
//      return new Object[]{MaTaiKhoan,HoTen,TenCV,Email,TaiKhoan,MatKhau,CreatedAt,Deleted};
//  }
   public Object[] toDataRow() {
        String trangThai = "Hoạt động";
        if (Deleted==true) {
            trangThai = "Đã ngừng hoạt động";
        }
        return new Object[]{MaNhanVien,HoTen,GioiTinh,TenCV,Email,QueQuan,NgaySinh,TaiKhoan,MatKhau,trangThai};
    }


       
}
