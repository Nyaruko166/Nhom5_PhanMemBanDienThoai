/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.it17326.nhom5.repository;

import com.fpt.it17326.nhom5.config.HibernateConfig;
import com.fpt.it17326.nhom5.domainmodel.Ram;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author youngboizseetinh
 */
public class RamRepository {
    
    private Session session = HibernateConfig.getFACTORY().openSession();

    private String fromTable = "FROM Ram";

    public List<Ram> getAll() {
        String sql = fromTable + " WHERE deleted = 0";
        Query query = session.createQuery(sql);
        return query.getResultList();
    }
    
    public List<Ram> getAllDeleted() {
        String sql = fromTable + " WHERE deleted = 1";
        Query query = session.createQuery(sql);
        return query.getResultList();
    }

    public Ram getOne(String MaRam) {
        String sql = fromTable + " WHERE MaRam =: MaRam1";

        Query query = session.createQuery(sql);
        query.setParameter("MaRam1", MaRam);
        return (Ram) query.getSingleResult();
    }

    public Boolean add(Ram ram) {
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(ram);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean update(Ram ram) {
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(ram);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean delete(Ram ram) {
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            ram.setDeleted(true);
            session.update(ram);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
