/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.it17326.nhom5.repository;

import com.fpt.it17326.nhom5.config.HibernateConfig;
import com.fpt.it17326.nhom5.domainmodel.DoiTra;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author youngboizseetinh
 */
public class DoiTraRepository {

    private Session session = HibernateConfig.getFACTORY().openSession();

    private String fromTable = "FROM DoiTra"; //HQL

    public DoiTra getOne(String MaDoiTra) {
        String sql = fromTable + "WHERE DoiTra =: MaDoiTra1";
        Query query = session.createQuery(sql, DoiTra.class);
        query.setParameter("MaDoiTra1", MaDoiTra);
        return (DoiTra) query.getSingleResult();
    }

    public List<DoiTra> getAll() {
        Query query = session.createQuery(fromTable);
        return query.getResultList();
    }

    public Boolean add(DoiTra doiTra) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(doiTra);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public Boolean update(DoiTra doiTra) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(doiTra);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public Boolean delete(DoiTra doiTra) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(doiTra);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
}
