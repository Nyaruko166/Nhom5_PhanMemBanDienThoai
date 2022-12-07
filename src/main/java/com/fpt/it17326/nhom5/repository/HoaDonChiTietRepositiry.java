/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.it17326.nhom5.repository;

import com.fpt.it17326.nhom5.config.HibernateConfig;
import com.fpt.it17326.nhom5.domainmodel.HoaDonChiTiet;
import com.fpt.it17326.nhom5.domainmodel.ImeiDaBan;
import com.fpt.it17326.nhom5.domainmodel.SanPham;
import com.fpt.it17326.nhom5.response.ThongkeResponse;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author PHAM DAC THANG
 */
public class HoaDonChiTietRepositiry {
//thang

    private Session session = HibernateConfig.getFACTORY().openSession();

   private String fromTable = "FROM HoaDonChiTiet";
   private String fromTableimeiban="FROM ImeiDaBan";
      private String fromTablesp = "FROM SanPham";

    

    public HoaDonChiTiet getOne(String id) {
        String sql = fromTable + " WHERE Id =: Id";
        Query query = session.createQuery(sql);
        query.setParameter("Id", id);
        return (HoaDonChiTiet) query.getSingleResult();
    }
    
    public List<HoaDonChiTiet> getAll() {
        Query query = session.createQuery(fromTable);
        List<HoaDonChiTiet> lst = query.list();
        return lst;
    }

     public List<ThongkeResponse> getAl2() {
        String sql = "SELECT new com.fpt.it17326.nhom5.response.ThongkeResponse"
                + "(c.maSP,c.tenSP,sum(a.soLuong),b.trangThai )"
                + "  FROM HoaDonChiTiet a  join HoaDon b  on a.hoaDon.id=b.id\n" +
"  join SanPham c  on a.sp.id=c.id"
                + "   GROUP BY  c.maSP,c.tenSP,b.trangThai  having  b.trangThai=true  order by sum(a.soLuong) desc";
        

        Query query = session.createQuery(sql);
        List<ThongkeResponse> list = query.list();
        return list;
    }
     
     
       public List<ThongkeResponse> getAl4( String a, String b) {
        String sql = "SELECT new com.fpt.it17326.nhom5.response.ThongkeResponse"
                + "(c.maSP,c.tenSP,sum(a.soLuong),b.trangThai )"
                + "  FROM HoaDonChiTiet a  join HoaDon b  on a.hoaDon.id=b.id\n" +
"  join SanPham c  on a.sp.id=c.id"
                + "   GROUP BY  c.maSP,c.tenSP,b.trangThai,b.createdAt"
                + "  having  b.trangThai=true  and b.createdAt   between  '"+a+"' and '"+b+"'"
                + " order by sum(a.soLuong) desc";
        

        Query query = session.createQuery(sql);
        List<ThongkeResponse> list = query.list();
        return list;
    }
       
   
      public  List<ThongkeResponse> getAll3(String b) {
        String sql = "	SELECT new com.fpt.it17326.nhom5.response.ThongkeResponse"
                + "( a.soLuong*a.donGia)\n" +
"			 from HoaDonChiTiet a  join HoaDon b  on a.hoaDon.id=b.id\n" +
"			\n" +
"			  GROUP BY b.trangThai,b.createdAt,a.soLuong,a.donGia\n" +
"			  having   b.trangThai=true  and b.createdAt   between  '1-1-1' and '"+b+"'";
        Query query = session.createQuery(sql);
        List<ThongkeResponse> list = query.list();
        return list;
    }
     

    public List<SanPham> getAllsp() {
        Query query = session.createQuery(fromTablesp);
        return query.getResultList();
    }
    public List<ImeiDaBan> getAllimaidaban() {
        Query query = session.createQuery(fromTableimeiban);
        List<ImeiDaBan> lst = query.list();
        return lst;
    }
   

    public static void main(String[] args) {
        new HoaDonChiTietRepositiry().getAll().forEach(s -> System.out.println("ta co---" + s.toString()));
    }
    //thang
}
