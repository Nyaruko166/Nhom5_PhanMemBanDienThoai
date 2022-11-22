package com.fpt.it17326.nhom5.repository;

import com.fpt.it17326.nhom5.config.HibernateConfig;
import com.fpt.it17326.nhom5.domainmodel.TrangThaiHoaDon;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 * AowVN_Nyaruko
 *
 */
public class TrangThaiHoaDonRepository {

    private Session session = HibernateConfig.getFACTORY().openSession();
    private String fromTable = "FROM TrangThaiHoaDon";

    public List<TrangThaiHoaDon> getAll() {
        Query query = session.createQuery(fromTable);
        return query.getResultList();
    }

    public TrangThaiHoaDon getOne(String MaTT) {
        String sql = fromTable + " WHERE MaTT =: MaTT";
        Query query = session.createQuery(sql);
        return (TrangThaiHoaDon) query.getSingleResult();
    }

    public Boolean add(TrangThaiHoaDon tthd) {
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(tthd);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean update(TrangThaiHoaDon tthd) {
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(tthd);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean delete(TrangThaiHoaDon tthd) {
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(tthd);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
