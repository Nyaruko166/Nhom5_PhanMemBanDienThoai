package com.fpt.it17326.nhom5.repository;

import com.fpt.it17326.nhom5.config.HibernateConfig;
import com.fpt.it17326.nhom5.domainmodel.NhanVien;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 * AowVN_Nyaruko
 *
 */
public class NhanVienRepository {

    private Session session = HibernateConfig.getFACTORY().openSession();
    private String fromTable = "FROM NhanVien";

    public List<NhanVien> getAll() {
        Query query = session.createQuery(fromTable);
        return query.getResultList();
    }

    public NhanVien getOne(String MaNhanVien) {
        String sql = fromTable + " WHERE MaNhanVien =: MaNhanVien";
        Query query = session.createQuery(sql);
        query.setParameter("MaNhanVien", MaNhanVien);
        return (NhanVien) query.getSingleResult();
    }

    public Boolean add(NhanVien nv) {
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(nv);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean update(NhanVien nv) {
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(nv);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean delete(NhanVien nv) {
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            nv.setDeleted(true);
            session.update(nv);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
