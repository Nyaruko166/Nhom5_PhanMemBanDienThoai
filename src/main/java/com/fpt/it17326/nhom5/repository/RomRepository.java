/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.it17326.nhom5.repository;

import com.fpt.it17326.nhom5.config.HibernateConfig;
import com.fpt.it17326.nhom5.domainmodel.Rom;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author youngboizseetinh
 */
public class RomRepository {
    
    private Session session = HibernateConfig.getFACTORY().openSession();

    private String fromTable = "FROM Rom";

    public List<Rom> getAll() {
        Query query = session.createQuery(fromTable);
        return query.getResultList();
    }

    public Rom getOne(String MaRom) {
        String sql = fromTable + " WHERE MaRom =: MaRom1";

        Query query = session.createQuery(sql);
        query.setParameter("MaRom1", MaRom);
        return (Rom) query.getSingleResult();
    }

    public Boolean add(Rom rom) {
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(rom);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean update(Rom rom) {
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(rom);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean delete(Rom rom) {
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            rom.setDeleted(true);
            session.update(rom);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
