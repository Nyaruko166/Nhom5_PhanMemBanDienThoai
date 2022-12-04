/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.it17326.nhom5.repository;

import com.fpt.it17326.nhom5.config.HibernateConfig;
import com.fpt.it17326.nhom5.domainmodel.KhuyenMai;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author youngboizseetinh
 */
public class KhuyenMaiRepository {
     private Session session = HibernateConfig.getFACTORY().openSession();

    private String fromTable = "FROM KhuyenMai";

    public List<KhuyenMai> getAll() {
        Query query = session.createQuery(fromTable);
        return query.getResultList();
    }
    public List<KhuyenMai> getAllTrue() {
        Query query = session.createQuery(fromTable + " where Deleted = 'true' order by id desc");
        return query.getResultList();
    }

    public List<KhuyenMai> getAllFalse() {
        Query query = session.createQuery(fromTable + " where Deleted = 'false' order by id desc");
        return query.getResultList();
    }

    public KhuyenMai getOne(int id) {
        String sql = fromTable + " WHERE id=:id";
        Query query = session.createQuery(sql);
        query.setParameter("id", id);
        return (KhuyenMai) query.getSingleResult();
    }
    public KhuyenMai getOne(String maKM) {
        String sql = fromTable + " WHERE maKM=:id";
        Query query = session.createQuery(sql);
        query.setParameter("id", maKM);
        return (KhuyenMai) query.getSingleResult();
    }

    public Boolean addTheoHoaDon(KhuyenMai km) {
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(km);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean update(KhuyenMai km) {
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(km);
            transaction.commit();
            session.save(km);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean delete(KhuyenMai chip) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(chip);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    
}
