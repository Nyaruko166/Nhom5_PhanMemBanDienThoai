/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.it17326.nhom5.repository;

import com.fpt.it17326.nhom5.config.HibernateConfig;
import com.fpt.it17326.nhom5.domainmodel.Pin;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author youngboizseetinh
 */
public class PinRepository {
    
    private Session session = HibernateConfig.getFACTORY().openSession();

    private String fromTable = "FROM Pin";

    public List<Pin> getAll() {
        String sql = fromTable + " WHERE deleted = 0 ORDER BY Id DESC";
        Query query = session.createQuery(sql);
        return query.getResultList();
    }
    
    public List<Pin> getAllDeleted() {
        String sql = fromTable + " WHERE deleted = 1 ORDER BY UpdatedAt DESC";
        Query query = session.createQuery(sql);
        return query.getResultList();
    }

    public List<Pin> searchDeleted(String tenPin) {
        tenPin = "%" + tenPin + "%";
        String sql = fromTable + " WHERE TenPin LIKE :TenPin1 and deleted = 1";
        Query query = session.createQuery(sql);
        query.setParameter("TenPin1", tenPin);
        return query.getResultList();
    }
    
    public Pin getOne(String MaPin) {
        String sql = fromTable + " WHERE MaPin =: MaPin1";

        Query query = session.createQuery(sql);
        query.setParameter("MaPin1", MaPin);
        return (Pin) query.getSingleResult();
    }

    public Boolean add(Pin pin) {
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(pin);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean update(Pin pin) {
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(pin);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean delete(Pin pin) {
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            pin.setDeleted(true);
            session.update(pin);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
