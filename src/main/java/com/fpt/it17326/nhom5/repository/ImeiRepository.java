/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.it17326.nhom5.repository;

import com.fpt.it17326.nhom5.config.HibernateConfig;
import com.fpt.it17326.nhom5.domainmodel.Imei;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author youngboizseetinh
 */
public class ImeiRepository {

    private Session session = HibernateConfig.getFACTORY().openSession();

    private String fromTable = "FROM Imei";

    public List<Imei> getAll() {
        Query query = session.createQuery(fromTable);
        return query.getResultList();
    }

    public Imei getOne(String MaImei) {
        String sql = fromTable + " WHERE MaImei =: MaImei1";
        Query query = session.createQuery(sql);
        query.setParameter("MaImei1", MaImei);
        return (Imei) query.getSingleResult();
    }

    public Boolean add(Imei imei) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(imei);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean update(Imei imei) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(imei);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean delete(Imei imei) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.update(imei);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
