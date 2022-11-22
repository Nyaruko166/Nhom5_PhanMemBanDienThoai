package com.fpt.it17326.nhom5.repository;

import com.fpt.it17326.nhom5.config.HibernateConfig;
import com.fpt.it17326.nhom5.domainmodel.HoaDon;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 * AowVN_Nyaruko
 *
 */
public class HoaDonRepository {

    private Session session = HibernateConfig.getFACTORY().openSession();
    private String fromTable = "FROM HoaDon";

    public List<HoaDon> getAll() {
        Query query = session.createQuery(fromTable);
        return query.getResultList();
    }

    public HoaDon getOne(String MaHoaDon) {
        String sql = fromTable + " WHERE MaHoaDon =: MaHoaDon";
        Query query = session.createQuery(sql);
        query.setParameter("MaHoaDon", MaHoaDon);
        return (HoaDon) query.getSingleResult();
    }

    public Boolean add(HoaDon hd) {
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(hd);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean update(HoaDon hd) {
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(hd);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean delete(HoaDon hd) {
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            hd.setDeleted(true);
            session.update(hd);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
