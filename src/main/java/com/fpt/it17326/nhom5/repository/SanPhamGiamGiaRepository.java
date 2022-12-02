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

    private String fromTable = "FROM SanPhamGiamGia";

    public List<SanPhamGiamGia> getAll() {
        Query query = session.createQuery(fromTable);
        return query.getResultList();
    }

    public SanPhamGiamGia getOne(String MaImei) {
        String sql = fromTable + " WHERE MaImei =: MaImei1";
        Query query = session.createQuery(sql);
        query.setParameter("MaImei1", MaImei);
        return (SanPhamGiamGia) query.getSingleResult();
    }

    public Boolean add(SanPhamGiamGia sanPhamGiamGia) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(sanPhamGiamGia);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean update(SanPhamGiamGia sanPhamGiamGia) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(sanPhamGiamGia);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean delete(SanPhamGiamGia sanPhamGiamGia) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.update(sanPhamGiamGia);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
