/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.it17326.nhom5.repository;

import com.fpt.it17326.nhom5.config.HibernateConfig;
import com.fpt.it17326.nhom5.domainmodel.SanPhamGiamGia;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author youngboizseetinh
 */
public class SanPhamGiamGiaRepository {

   private Session session = HibernateConfig.getFACTORY().openSession();

    private String fromTable = " FROM SanPhamGiamGia";

    public List<SanPhamGiamGia> getAll() {
        javax.persistence.Query query = session.createQuery(fromTable, SanPhamGiamGia.class);
        return query.getResultList();
    }
     public List<SanPhamGiamGia> getAllSP(int idKM) {
        String sql = fromTable + " WHERE idKM = "+ idKM;
        javax.persistence.Query query = session.createQuery(sql);
        return  query.getResultList();
    }
     


    public SanPhamGiamGia getOne(String MaAnh) {
        String sql = fromTable + " WHERE MaAnh =: MaAnh1";
        javax.persistence.Query query = session.createQuery(sql);
        query.setParameter("MaAnh1", MaAnh);
        return (SanPhamGiamGia) query.getSingleResult();
    }

    public Boolean add(SanPhamGiamGia anh) {
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(anh);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean update(SanPhamGiamGia anh) {
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(anh);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean delete(SanPhamGiamGia anh) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(anh);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
}
