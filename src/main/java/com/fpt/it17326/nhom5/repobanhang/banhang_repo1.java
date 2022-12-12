/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.it17326.nhom5.repobanhang;


import com.fpt.it17326.nhom5.viewmodel.QRimei1;

import com.fpt.it17326.nhom5.viewmodel.banhangimeithoebang1;
import com.fpt.it17326.nhom5.viewmodel.hoadonbanhang1;
import com.fpt.it17326.nhom5.viewmodel.khachhangbanhang1;
import com.fpt.it17326.nhom5.viewmodel.sanphambanhang1;
import com.fpt.it17326.nhom5.viewmodel.xuathoadon1;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PHAM DAC THANG
 */
public class banhang_repo1 {
  
  dbcontest1 db;
    ResultSet rs = null;
    Statement st = null;
    PreparedStatement pst = null;
    List<hoadonbanhang1> lishoadon1 = null;
   List<banhangimeithoebang1> listimei = null;
         List<sanphambanhang1> lissanphambanhang = null;
              List<khachhangbanhang1> liskhachhangbanhang = null;
                 List<xuathoadon1> lisxuathoadon = null;
                 List<QRimei1> lisQR = null;
    public banhang_repo1() {
    }

    public banhang_repo1(dbcontest1 db) {
        this.db = db;
    }
    
    
           public List<hoadonbanhang1> gethdbanhang() {
               lishoadon1=new ArrayList<>();
        String select = " select a.mahd,b.hoten,c.hoten,a.TrangThai,a.id,c.id,convert(varchar,a.CreatedAt,105),a.tongtien from hoadon a join  nhanvien b  on a.idnv=b.id\n" +
"join  khachhang c  on a.idkh=c.id   where a.deleted=0";
  
        try {
            st = db.openDbConnection().createStatement();
            rs = st.executeQuery(select);
            while (rs.next()) {
                lishoadon1.add(new hoadonbanhang1(rs.getNString(1),rs.getNString(2),rs.getNString(3) ,rs.getInt(4),rs.getInt(5),
                        rs.getInt(6),rs.getString(7),rs.getDouble(8)
                     ));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(banhang_repo1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lishoadon1;
        
    }
           
  //////////////////////////////////////////////////////
             public List<sanphambanhang1> getsanphambanhang() {
               lissanphambanhang=new ArrayList<>();
        String select = "	 select a.masp,a.tensp,b.TenPin,c.TenChip,d.TenRom,e.TenHang,f.DungLuong,count(g.IdSP),a.dongia,a.id \n" +
"from sanpham a left join pin b on a.idpin=b.id\n" +
"            left join Chip c on a.idchip=c.id\n" +
"				left join Rom d on a.IdRom=d.id\n" +
"				left join HangDienThoai e on a.IdHang=e.id\n" +
"				left join Ram f on a.IdRam=f.id\n" +
"				left join Imei g on a.Id=g.idsp\n" +
"\n" +
"				group by a.masp,a.tensp,b.TenPin,c.TenChip,d.TenRom,e.TenHang,f.DungLuong,a.dongia,a.id,g.TrangThai\n"
                + "              having g.TrangThai=0   ";
  
        try {
            st = db.openDbConnection().createStatement();
            rs = st.executeQuery(select);
            while (rs.next()) {
                lissanphambanhang.add(new sanphambanhang1(
                        
                      rs.getNString(1),
                      rs.getString(2),
                      rs.getString(3) ,
                      rs.getString(4) ,
                      rs.getString(5) ,
                      rs.getString(6) ,
                           rs.getString(7) ,
                      rs.getInt(8),
                                 rs.getFloat(9),
                        rs.getInt(10)
                        
                        )
                        
                        
                )
                       
                     ;
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(banhang_repo1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lissanphambanhang;
        
    }
     //////////////////////////////////////////////////////          
                public List<khachhangbanhang1> getkhachhangbanhang() {
               liskhachhangbanhang=new ArrayList<>();
        String select = " select id,makh,hoten,sdt from khachhang";
  
        try {
            st = db.openDbConnection().createStatement();
            rs = st.executeQuery(select);
            while (rs.next()) {
                     liskhachhangbanhang.add(new khachhangbanhang1(
                        
                      rs.getInt(1),
                      rs.getNString(2),
                      rs.getString(3), 
                     rs.getString(4) 
                        
                        )
                        
                        
                )
                       
                     ;
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(banhang_repo1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return       liskhachhangbanhang;
        
    } 
      //////////////////////////////////////////////////////            
    public   String taohoadonbanhang(String manv,String makh){
            
      try {
            String delete = "declare  @idnv int,@idkh int,@tenkh nvarchar(50),@sdt  VARCHAR(20)\n" +
"set @idnv=(select id from NhanVien where MaNhanVien=?)\n" +
"set @idkh=(select id from KhachHang where MaKH=?)\n" +
"set @tenkh=(select HoTen from KhachHang where MaKH=?)\n" +
"set @sdt=(select sdt from KhachHang where MaKH=?)\n" +
"\n" +
"insert into HoaDon(MaHD,idNV,IdKH,tenkh,sdt,TrangThai,tongtien,CreatedAt,Deleted,UpdatedAt)  \n" +
"values('',@idnv,@idkh,@tenkh,@sdt,0,0, getdate(),0, getdate())\n" +
"declare @vt int\n" +
"set @vt=(select TOP 1 id from HoaDon   order by id  desc)\n" +
"\n" +
"update HoaDon set MaHD='MHD00'+cast(@vt as nvarchar)    where id=@vt" ;
            pst = db.openDbConnection().prepareStatement(delete);
            pst.setString(1, manv);
               pst.setString(2, makh);
                 pst.setString(3, makh);
                   pst.setString(4, makh);
            pst.executeUpdate();
            
            return "Tạo hóa đơn  thanh công";
        } catch (SQLException ex) {
            Logger.getLogger(banhang_repo1.class.getName()).log(Level.SEVERE, null, ex);
            return "Tạo hóa đơn  thất bại";
        }      
    
    }
    
       public  List<banhangimeithoebang1> imeisanphambanhang(String masp){
            listimei=new ArrayList<>();
    String aa = "declare @id int\n" +
"set @id=(select id from SanPham where MaSP='"+masp+"')\n" +
"select id,maimei,imei,idSP from imei where idSP=@id   and TrangThai=0" ;
            try {
            st = db.openDbConnection().createStatement();
            rs = st.executeQuery(aa);
            while (rs.next()) {
                listimei.add(new banhangimeithoebang1(
                
                rs.getInt(1),rs.getNString(2),rs.getString(3),
                          rs.getInt(4)
                
                
                )
                       );
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(banhang_repo1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listimei;
            
      
     
}
       
     
       
           public   boolean themhoadonchitietbanhang(int idhd,int idsp,String tensp,int soluong,float dongia){
            
      try {
            String delete = 

" if exists(select idhd,idsp from HoaDonChiTiet where idhd="+idhd+"   and  idsp= "+idsp+")\n" +
"    BEGIN\n" +
"       \n" +
"	   print 'da co roi'\n" +
"    END\n" +
"	else\n" +
"	BEGIN\n" +
"     insert into HoaDonchitiet(idhd,idsp,tensp,soluong,dongia,CreatedAt,Deleted,UpdatedAt)values(?,?,?,?,?,getdate(),0,getdate())\n" +
"\n" +
"    END" ;
            pst = db.openDbConnection().prepareStatement(delete);
            pst.setInt(1, idhd);
                 pst.setInt(2, idsp);
                    pst.setNString(3, tensp);
                       pst.setInt(4, soluong);
                          pst.setFloat(5, dongia);
            pst.executeUpdate();
            return true;
           
        } catch (SQLException ex) {
            Logger.getLogger(banhang_repo1.class.getName()).log(Level.SEVERE, null, ex);
           return false;
        }      
   
    }
          public   void themimeidaban(String maimei,String imei,int idhd,int idsp){
            
      try {
            String delete = "declare @vt int, @idhd int,@idsp int, @maimei nvarchar(50),@Imei varchar(max)\n" +
"	set @idhd=?\n" +
"	set @idsp=?\n" +
"	set @maimei=?\n" +
"	set @Imei =?\n" +
"set @vt=(select  id from HoaDonchitiet  where IdHD=@idhd  and IdSP=@idsp)\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"\n" +
" if exists(select idhoadonchitiet,Maimei,imei from ImeiDaBan where idhoadonchitiet=@vt and Maimei=@maimei  and  imei=@Imei)\n" +
"    BEGIN\n" +
"       \n" +
"	   print 'da co roi'\n" +
"    END\n" +
"	else\n" +
"	BEGIN\n" +
"    insert into ImeiDaBan(idhoadonchitiet,Maimei,imei,TrangThai,CreatedAt,Deleted,UpdatedAt)  values(@vt,@maimei,@Imei,0, getdate(),0, getdate())\n" +
"	 declare @solg int \n" +
"	set @solg=(select count(idhoadonchitiet) from ImeiDaBan  where IdHoaDonChiTiet =@vt)\n" +
"	 print @solg\n" +
"	update HoaDonChiTiet set SoLuong=@solg  where IdHD=@idhd  and IdSP=@idsp\n" +
                    "		update Imei set TrangThai=1 where MaImei=@maimei\n" +
"    END" ;
            pst = db.openDbConnection().prepareStatement(delete);
            pst.setInt(1, idhd);
              pst.setInt(2, idsp);
            pst.setNString(3, maimei);
                 pst.setString(4, imei);
                   
            pst.executeUpdate();
            
           
        } catch (SQLException ex) {
            Logger.getLogger(banhang_repo1.class.getName()).log(Level.SEVERE, null, ex);
          
        }      
    
    }
          
          
          
          
          
               public List<sanphambanhang1> clhoadonrabanggiohang(String mahd) {
               lissanphambanhang=new ArrayList<>();
        String select = "	select a.masp,a.tensp,b.TenPin,c.TenChip,d.TenRom,e.TenHang,f.DungLuong,count(i.IdHoaDonChiTiet),g.dongia ,g.IdSP,g.id\n" +
" from sanpham a  join pin b on a.idpin=b.id\n" +
"                join Chip c on a.idchip=c.id\n" +
"				 join Rom d on a.IdRom=d.id\n" +
"			       join HangDienThoai e on a.IdHang=e.id\n" +
"				 join Ram f on a.IdRam=f.id\n" +
"					 join HoaDonChiTiet g on   g.idsp=a.id\n" +
"					 join hoadon h on h.id=g.IdHD \n" +
"					 \n" +
"					 	left join ImeiDaBan i on g.Id=i.IdHoaDonChiTiet\n" +
"\n" +
"				group by a.masp,a.tensp,b.TenPin,c.TenChip,d.TenRom,e.TenHang,f.DungLuong,g.dongia ,g.IdSP,h.MaHD,g.id\n" +
"					 \n" +
"					 \n" +
"					 having h.MaHD='"+mahd+"'";
  
        try {
            st = db.openDbConnection().createStatement();
            rs = st.executeQuery(select);
            while (rs.next()) {
                lissanphambanhang.add(new sanphambanhang1(
                        
                      rs.getNString(1),
                      rs.getString(2),
                      rs.getString(3) ,
                      rs.getString(4) ,
                      rs.getString(5) ,
                      rs.getString(6) ,
                           rs.getString(7) ,
                      rs.getInt(8),
                                 rs.getFloat(9),
                        rs.getInt(10),
                          rs.getInt(11)
                        
                        )
                        
                        
                )
                       
                     ;
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(banhang_repo1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lissanphambanhang;
        
    }
               
               
               
               
               
                  public   String Thanhtoanhoadon(String tongtiensaukhuyenmai,String mahd){
            
      try {
            String delete = "					  update HoaDon set Tongtien=? , createdat=getdate()  , trangthai=1 where mahd=?\n" +
"\n" +
"\n" +
"\n" +
"update Imei set TrangThai=1  where MaImei in (select c.MaImei from hoadon a join hoadonchitiet b on a.id=b.IdHD\n" +
"                        join ImeiDaBan c   on b.id=c.IdHoaDonChiTiet  where a.MaHD=?)\n" +
"\n" +
"delete from ImeiDaBan  where Id  in (\n" +
"\n" +
"					select c.id from hoadon a join hoadonchitiet b on a.id=b.IdHD\n" +
"                     join ImeiDaBan c   on b.id=c.IdHoaDonChiTiet  where a.MaHD not in (select mahd from hoadon where mahd=?)  \n" +
"\n" +
"					and c.MaImei in (select c.MaImei from hoadon a join hoadonchitiet b on a.id=b.IdHD\n" +
"                      join ImeiDaBan c   on b.id=c.IdHoaDonChiTiet  where a.MaHD=?)\n" +
"\n" +
"					and a.TrangThai=0)\n" +
"					 delete from HoaDonChiTiet where id   in    (select  a.id from HoaDonChiTiet a left  join ImeiDaBan b on a.id=b.IdHoaDonChiTiet \n" +
"                                  left join  HoaDon c on c.id=a.idHD\n" +
"                      group by a.id,c.Deleted  having count(b.IdHoaDonChiTiet)=0  and c.Deleted=0)" ;
            pst = db.openDbConnection().prepareStatement(delete);
            pst.setObject(1, tongtiensaukhuyenmai);
              pst.setObject(2, mahd);
              pst.setObject(3, mahd);
              pst.setObject(4, mahd);
              pst.setObject(5, mahd);
            pst.executeUpdate();
            
            return "Thanh toán  thanh công";
        } catch (SQLException ex) {
            Logger.getLogger(banhang_repo1.class.getName()).log(Level.SEVERE, null, ex);
            return "Thanh toán thất bại";
        }      
    
    }
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                     public   void capnhatsolgsanpham(String masp){
            
      try {
            String delete = " if exists(select count(b.IdSP) from sanpham a join Imei b on b.IdSP=a.id \n" +
"group by  a.id,a.MaSP   having masp=?)\n" +
"begin\n" +
"update sanpham set SoLuong=(select count(b.IdSP) from sanpham a join Imei b on b.IdSP=a.id \n" +
"group by  a.id,a.MaSP   having masp=?)\n" +
"  where masp=?\n" +
"\n" +
"end\n" +
"else\n" +
"begin\n" +
"update sanpham set SoLuong=0 where masp=?\n" +
"end" ;
            pst = db.openDbConnection().prepareStatement(delete);
            pst.setObject(1, masp);
              pst.setObject(2, masp);
               pst.setObject(3, masp);
                pst.setObject(4, masp);
               

            pst.executeUpdate();
            
  
        } catch (SQLException ex) {
            Logger.getLogger(banhang_repo1.class.getName()).log(Level.SEVERE, null, ex);
          
        }      
    
    }
     
                     
                     
                     
                     
                     
                           
                     public   String huyhoadon(String Mahd){
            
      try {
            String delete = "   update hoadon set deleted=1  where mahd=?\n" +
"  update Imei set TrangThai=0 where  MaImei in ( select c.MaImei from HoaDon a left join HoaDonChiTiet b on a.id=b.IdHD\n" +
"                          left join ImeiDaBan c on c.IdHoaDonChiTiet=b.id)" ;
            pst = db.openDbConnection().prepareStatement(delete);
            pst.setObject(1, Mahd);
          

            pst.executeUpdate();
            
  return "ĐÃ HỦY HÓA ĐƠN THÀNH CÔNG";
        } catch (SQLException ex) {
            Logger.getLogger(banhang_repo1.class.getName()).log(Level.SEVERE, null, ex);
           return "ĐÃ HỦY HÓA ĐƠN THẤT BẠI";
        }      
    
    }
                     
                     
                     
                     
                                          
                     public   String taokhachhangbanle(){
            
      try {
            String delete = "  insert into khachhang(makh,hoten,sdt,email,gioitinh,ngaysinh,diachi,createdat,deleted,updatedat) values\n" +
"   ('',N'khách bán lẻ','00000','khachbanle@gmail.com',1,getdate(),'haiduong',getdate(),0,getdate())\n" +
"   declare @vt int\n" +
"set @vt=(select TOP 1 id from khachhang   order by id  desc)\n" +
"update khachhang set makh='MKH00'+cast(@vt as nvarchar)    where id=@vt" ;
            pst = db.openDbConnection().prepareStatement(delete);
       
          

            pst.executeUpdate();
            
  return "TẠO KHÁCH HÀNG BÁN LẺ THÀNH CÔNG";
        } catch (SQLException ex) {
            Logger.getLogger(banhang_repo1.class.getName()).log(Level.SEVERE, null, ex);
           return "TẠO KHÁCH HÀNG BÁN LẺ THẤT BẠI";
        }      
    
    }
                     
                     
                     
                                          public   String taokhachcothongtin(String ten,String sdt){
            
      try {
            String delete = "   insert into khachhang(makh,hoten,sdt,email,gioitinh,ngaysinh,diachi,createdat,deleted,updatedat) values\n" +
"   ('',?,?,'khachbanle@gmail.com',1,getdate(),'haiduong',getdate(),0,getdate())\n" +
"   declare @vt int\n" +
"set @vt=(select TOP 1 id from khachhang   order by id  desc)\n" +
"update khachhang set makh='MKH00'+cast(@vt as nvarchar)    where id=@vt" ;
            pst = db.openDbConnection().prepareStatement(delete);
       
          
   pst.setObject(1, ten);
      pst.setObject(2, sdt);
            pst.executeUpdate();
            
  return "TẠO KHÁCH HÀNG CÓ THÔNG TIN THÀNH CÔNG";
        } catch (SQLException ex) {
            Logger.getLogger(banhang_repo1.class.getName()).log(Level.SEVERE, null, ex);
           return "TẠO KHÁCH HÀNG CÓ THÔNG TIN THẤT BẠI";
        }      
    
    }
                                          
                                          
                                          
                                          
                                          
                                          
       public  List<banhangimeithoebang1> imeigiohangbanhang(String mahd,String masp){
            listimei=new ArrayList<>();
    String aa = "select id , maimei,imei,idHoaDonChiTiet from ImeiDaBan where IdHoaDonChiTiet in \n" +
"(select id from HoaDonChiTiet where  idhd in (select id from hoadon where MaHD='"+mahd+"')  \n" +
"and \n" +
" idsp in (select id from SanPham where MaSP='"+masp+"')\n" +
")" ;
            try {
            st = db.openDbConnection().createStatement();
            rs = st.executeQuery(aa);
            while (rs.next()) {
                listimei.add(new banhangimeithoebang1(
                
                rs.getInt(1),rs.getNString(2),rs.getString(3),
                         rs.getInt(1)
                
                
                )
                       );
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(banhang_repo1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listimei;
            
      
     
}
       
       
       
       
       
       
          public   String XOAIMEITRONGBANGIMEIDABAN(String idimeeidaban,String maimei){
            
      try {
            String delete = "delete  from ImeiDaBan where id=?\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"       delete from HoaDonChiTiet where id   in    (select  a.id from HoaDonChiTiet a left  join ImeiDaBan b on a.id=b.IdHoaDonChiTiet \n" +
"                                  left join  HoaDon c on c.id=a.idHD\n" +
"                      group by a.id,c.Deleted  having count(b.IdHoaDonChiTiet)=0  and c.Deleted=0)\n"
                    + "	update Imei set TrangThai=0 where MaImei=?" ;
            pst = db.openDbConnection().prepareStatement(delete);
        pst.setObject(1, idimeeidaban);
         pst.setObject(2, maimei);
       
  
   
 

            pst.executeUpdate();
            
  return "XÓA IMEI THÀNH CÔNG";
        } catch (SQLException ex) {
            Logger.getLogger(banhang_repo1.class.getName()).log(Level.SEVERE, null, ex);
           return "XÓA IMEI THẤT BẠI";
        }      
    
    }
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          //////////////////////////////////////////////////////////////////////////
               
                  
                     public   void capnhatsoluonghoadonchitiet(int idhdct){
            
      try {
            String delete = " update HoaDonChiTiet set SoLuong=(\n" +
"select count(b.IdHoaDonChiTiet) from HoaDonChiTiet a left join ImeiDaBan b on b.IdHoaDonChiTiet=a.id \n" +
"group by  a.id  having a.id=?)  where id=?" ;
            pst = db.openDbConnection().prepareStatement(delete);
            pst.setObject(1, idhdct);
              pst.setObject(2, idhdct);
              
               

            pst.executeUpdate();
            
  
        } catch (SQLException ex) {
            Logger.getLogger(banhang_repo1.class.getName()).log(Level.SEVERE, null, ex);
          
        }      
    
    }
     
                    public List<xuathoadon1> xuathoadobbanhang(String mahd) {
               lisxuathoadon=new ArrayList<>();
        String select = "select b.MaHD,a.HoTen,a.SDT,a.DiaChi,convert(varchar,b.CreatedAt,105),d.TenSP,f.TenMauSac+','+g.tenrom+','+h.DungLuong,COUNT(e.IdHoaDonChiTiet),d.DonGia,COUNT(e.IdHoaDonChiTiet)*d.DonGia from\n" +
" hoadon b  left join KhachHang a on a.id=b.IdKH\n" +
"           left  join HoaDonChiTiet c on b.id=c.IdHD\n" +
"		 left 	 join ImeiDaBan e on e.IdHoaDonChiTiet=c.Id\n" +
"		 left 	join SanPham d   on c.IdSP=d.Id\n" +
"		 left 	join  mausac f on f.id=d.idmausac\n" +
"		 left 	join  rom g on g.id=d.IdRom\n" +
"		 left 	join ram h on h.id=d.IdRam\n" +
"GROUP BY  b.MaHD,a.HoTen,a.SDT,a.DiaChi,convert(varchar,b.CreatedAt,105),d.TenSP,d.DonGia,f.TenMauSac,g.tenrom,h.DungLuong\n" +
"having mahd='"+mahd+"'";
  
        try {
            st = db.openDbConnection().createStatement();
            rs = st.executeQuery(select);
            while (rs.next()) {
                lisxuathoadon.add(new xuathoadon1(
                        rs.getNString(1),
                        rs.getString(2),
                        rs.getString(3),
                           rs.getString(4) ,
                           rs.getString(5) ,
                           rs.getString(6) ,
                           rs.getString(7) ,
                        rs.getInt(8),
                         rs.getDouble(9),
                         rs.getDouble(10)
                      
                     ));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(banhang_repo1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lisxuathoadon;
        
    }
                    
                     public   String updatekhachhang(String hoten,String sdt,String id ){
            
      try {
            String delete = "  	  update KhachHang set HoTen=?  ,SDT=?  where id=?" ;
            pst = db.openDbConnection().prepareStatement(delete);
            pst.setObject(1, hoten);
              pst.setObject(2, sdt);
                pst.setObject(3, id);
          

            pst.executeUpdate();
            
  return "UPDATE KHÁCH HÀNG THÀNH CÔNG";
        } catch (SQLException ex) {
            Logger.getLogger(banhang_repo1.class.getName()).log(Level.SEVERE, null, ex);
           return "UPDATE KHÁCH HÀNG THẤT BẠI";
        }      
    
    }
                     
                     
                     
                     
                                  public   String Xoagiohang(String mhd ){
            
      try {
            String delete = "update Imei set TrangThai=0 where MaImei in (						  select c.MaImei from HoaDon a left join HoaDonChiTiet b on a.id=b.IdHD\n" +
"						                          left join ImeiDaBan c on b.Id=c.IdHoaDonChiTiet\n" +
"\n" +
"												  where a.MaHD=?)\n" +
"\n" +
"\n" +
"\n" +
"	delete from ImeiDaBan  where  id in (select c.id from HoaDon a left join HoaDonChiTiet b on a.id=b.IdHD\n" +
"						                          left join ImeiDaBan c on b.Id=c.IdHoaDonChiTiet\n" +
" where a.MaHD=?)\n" +
" delete from HoaDonChiTiet where IdHD in (select id from HoaDon where MaHD=?)" ;
            pst = db.openDbConnection().prepareStatement(delete);
            pst.setObject(1, mhd);
              pst.setObject(2, mhd);
                pst.setObject(3, mhd);
          

            pst.executeUpdate();
            
  return "XÓA GIỎ HÀNG THÀNH CÔNG";
        } catch (SQLException ex) {
            Logger.getLogger(banhang_repo1.class.getName()).log(Level.SEVERE, null, ex);
           return "XÓA GIỎ HÀNG THẤT BẠI";
        }      
    
    }
                                  
                                  
       public List<QRimei1> getQR(String maimei) {
               lisQR=new ArrayList<>();
        String select = " select  a.MaImei,b.MaSP,a.TrangThai,b.id,b.TenSP,b.DonGia,a.Imei from imei a join SanPham b on a.idsp=b.id  where MaImei='"+maimei+"'";
  
        try {
            st = db.openDbConnection().createStatement();
            rs = st.executeQuery(select);
            while (rs.next()) {
                     lisQR.add(new QRimei1(
                        
                      rs.getString(1),
                      rs.getString(2),
                      rs.getInt(3), 
            rs.getInt(4), 
                               rs.getNString(5),
                          rs.getInt(6), 
                               rs.getString(7)
                        )
                        
                        
                )
                       
                     ;
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(banhang_repo1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return       lisQR;
        
    }  
       
       public static void main(String[] args) {
        new banhang_repo1().getQR("MI002").toString();
                
    }
}