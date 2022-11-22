/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.it17326.nhom5.repository;

import com.fpt.it17326.nhom5.config.HibernateConfig;
import com.fpt.it17326.nhom5.domainmodel.BaoHanh;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author youngboizseetinh
 */
public class BaoHanhRepository {

    private Session session = HibernateConfig.getFACTORY().openSession();

    private String fromTable = "FROM BaoHanh"; //HQL

    public BaoHanh getOne(String MaBaoHanh) {
        String sql = fromTable + "WHERE MaBaoHanh =: MaBaoHanh1";
        Query query = session.createQuery(sql, BaoHanh.class);
        query.setParameter("MaBaoHanh1", MaBaoHanh);
        return (BaoHanh) query.getSingleResult();
    }

    public List<BaoHanh> getAll() {
        Query query = session.createQuery(fromTable);
        return query.getResultList();
    }

    public Boolean add(BaoHanh bh) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(bh);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public Boolean update(BaoHanh bh) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(bh);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public Boolean delete(BaoHanh bh) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(bh);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
}
