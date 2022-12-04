package com.fpt.it17326.nhom5.repository;

import com.fpt.it17326.nhom5.config.HibernateConfig;
import com.fpt.it17326.nhom5.domainmodel.HoaDon;
import com.fpt.it17326.nhom5.domainmodel.KhachHang;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 * AowVN_Nyaruko
 *
 */
public class KhachHangRepository {

    private Session session = HibernateConfig.getFACTORY().openSession();
    private String fromTable = "FROM KhachHang";

    public List<KhachHang> getAll() {
        Query query = session.createQuery(fromTable);
        return query.getResultList();
    }

    public KhachHang getOne(String MaKH) {
        String sql = fromTable + " WHERE MaKH =: MaKH";
        Query query = session.createQuery(sql);
        query.setParameter("MaKH", MaKH);
        return (KhachHang) query.getSingleResult();
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
