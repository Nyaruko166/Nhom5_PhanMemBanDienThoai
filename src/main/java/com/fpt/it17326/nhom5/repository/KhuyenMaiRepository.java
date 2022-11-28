/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.it17326.nhom5.repository;

import com.fpt.it17326.nhom5.config.HibernateConfig;
import com.fpt.it17326.nhom5.domainmodel.KhuyenMai;
import com.fpt.it17326.nhom5.response.KhuyenMaiResponse;
import java.time.Instant;
import java.util.Date;
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
        Query query = session.createQuery(fromTable + " where Deleted = 'true'");
        return query.getResultList();
    }

    public List<KhuyenMai> getAllFalse() {
        Query query = session.createQuery(fromTable + " where Deleted = 'false'");
        return query.getResultList();
    }

    public KhuyenMai getOne(int id) {
        String sql = fromTable + " WHERE id=:id";
        Query query = session.createQuery(sql);
        query.setParameter("id", id);
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
    public static void main(String[] args) {
        KhuyenMaiRepository khuyenMaiRepository = new KhuyenMaiRepository();
        KhuyenMai khuyenMai = new KhuyenMai(3,"KM00110", "Khuyen mai", true,false,Float.max(100, 10000),Float.max(100, 10000), java.util.Calendar.getInstance().getTime(), java.util.Calendar.getInstance().getTime(), java.util.Calendar.getInstance().getTime(), true, null);
        khuyenMaiRepository.delete(khuyenMai);
    }
}
