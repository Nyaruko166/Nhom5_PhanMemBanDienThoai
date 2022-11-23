/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.it17326.nhom5.Repository;

import com.fpt.it17326.nhom5.Response.ViewTaiKhoanResponse;
import com.fpt.it17326.nhom5.config.HibernateConfig;
import com.fpt.it17326.nhom5.domainmodel.TaiKhoan;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Tu
 */
public class ViewTaiKhoanRepository {

    private Session session = HibernateConfig.getFACTORY().openSession();
    private String fromTable = "FROM TaiKhoan";

    public List<TaiKhoan> getAll() {
        Query query = session.createQuery(fromTable, TaiKhoan.class);
        List<TaiKhoan> lst = query.getResultList();
        return lst;
    }

    public Boolean add(TaiKhoan tk) {
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

    public Boolean update(TaiKhoan tk) {
        Transaction transaction = null;

        try (
                 Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();

            session.update(tk);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return true;
    }
//    public boolean doiMK(String email,String password){
//        String sql ="From TaiKhoan" +"Where Email=:email";
//        Session session = HibernateConfig.g
//    }

    public Boolean delete(TaiKhoan tk) {
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

//    public static void main(String[] args) {
//        List<TaiKhoan> tk= new ViewTaiKhoanRepository().getAll();
//        for (TaiKhoan viewTaiKhoanResponse : tk) {
//            System.out.println(viewTaiKhoanResponse.toString());
//        }
//        
//    }
//    public static void main(String[] args) {
//        TaiKhoan tk = new TaiKhoan("tu@gmail.com", "tutututu");
//        TaiKhoan  tk1 = new ViewTaiKhoanRepository().update(tk);
//        System.out.println(tk1.toString());
//    }
    public TaiKhoan getOne(String Email) {
        String sql = fromTable + " WHERE Email =: 'Email'";
        Query query = session.createQuery(sql, TaiKhoan.class);
        query.setParameter("'Email'", Email);//lay cai id thu 2 cua cau sql dong28
        return (TaiKhoan) query.getSingleResult();
    }
}
