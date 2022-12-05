/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.it17326.nhom5.repository;

import com.fpt.it17326.nhom5.response.NhanVienResponse;
import com.fpt.it17326.nhom5.config.HibernateConfig;
import com.fpt.it17326.nhom5.domainmodel.NhanVien;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Tu
 */
public class NhanVienRepository {

    private Session session = HibernateConfig.getFACTORY().openSession();
    private String fromTable = "FROM NhanVien";

    public List<NhanVien> getAll() {
        Query query = session.createQuery(fromTable, NhanVien.class);
        List<NhanVien> lst = query.getResultList();
        return lst;
    }

    public NhanVien getOne(String MaNhanVien) {
        String sql = fromTable + " WHERE MaNhanVien =: MaNhanVien";
        org.hibernate.query.Query query = session.createQuery(sql);
        query.setParameter("MaNhanVien", MaNhanVien);
        return (NhanVien) query.getSingleResult();
    }

    public Boolean add(NhanVien tk) {
        Transaction transaction = null;
        try (
                 Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(tk);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return true;
    }

    public Boolean update(NhanVien nv) {
        Transaction transaction = null;

        try (
                 Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();

            nv.setUpdatedAt(new Date());
            session.saveOrUpdate(nv);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
//    public boolean doiMK(String email,String password){
//        String sql ="From NhanVien" +"Where Email=:email";
//        Session session = HibernateConfig.g
//    }

    public Boolean delete(NhanVien tk) {
        Transaction transaction = null;
        try (
                 Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(tk);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public Boolean updateMK(NhanVien nv, String matKhau, String email) {
        Transaction transaction = null;
        String sql = fromTable + "Set MatKhau=: 'matkhau' where Email =:'email'";
        org.hibernate.query.Query query = session.createQuery(sql);
        query.setParameter("matkhau", matKhau);
        query.setParameter("email", email);
        try (
                 Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            nv.setUpdatedAt(new Date());
            session.update(nv);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public  void doimk(String email,String matKhau){
        NhanVienRepository repo = new NhanVienRepository();
        List<NhanVien>lst = repo.getAll();
        NhanVien nv = new NhanVien();
        for (NhanVien x : lst) {
            if (email.equals(x.getEmail())) {
                nv = x;
            }
        }
        nv.setMatKhau(matKhau);
        nv.setUpdatedAt(new Date());
        repo.update(nv);
    }
    
    
    
    public static void main(String[] args) {
        
//        Boolean update = new NhanVienRepository().update(nv1);
//        System.out.println(nv1.toString());
         
        List<NhanVien> category = new NhanVienRepository().getAll();
        for (NhanVien category1 : category) {
            System.out.println(category1.toString());
        
    }
       
    }
}
