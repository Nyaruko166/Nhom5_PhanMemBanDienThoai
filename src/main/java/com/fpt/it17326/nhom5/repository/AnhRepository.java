package com.fpt.it17326.nhom5.repository;

import com.fpt.it17326.nhom5.config.HibernateConfig;
import com.fpt.it17326.nhom5.domainmodel.Anh;
import com.fpt.it17326.nhom5.response.AnhResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * AowVN_Nyaruko
 *
 */
public class AnhRepository {

    private Session session = HibernateConfig.getFACTORY().openSession();

    private String fromTable = "FROM Anh";

    public List<Anh> getAll() {
        Query query = session.createQuery(fromTable, Anh.class);
        return query.getResultList();
    }

    public Anh getOne(Integer MaAnh) {
        String sql = fromTable + " WHERE MaAnh =: MaAnh1";
        Query query = session.createQuery(sql);
        query.setParameter("MaAnh1", MaAnh);
        return (Anh) query.getSingleResult();
    }

    public Boolean add(Anh anh) {
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(anh);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean update(Anh anh) {
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(anh);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean delete(Anh anh) {
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            anh.setDeleted(true);
            session.update(anh);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

//    public static void main(String[] args) throws ParseException {
//
//        Anh anh = new AnhRepository().getOne(1);
//        System.out.println(anh.toString());
//        Anh anh = new Anh();
//        anh.setUrlAnh("64981105");
//        anh.setCover(true);
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//
//        anh.setCreatedAt(format.parse("2022-11-21"));
//
//        anh.setDeleted(false);
//
//        anh.setUpdatedAt(format.parse("2022-11-21"));
//
//        anh.setMaAnh("6F1A16BA-FA3E-4383-BCAC-B938CD87A1D9");
//        new AnhRepository().delete(anh);
//
//        List<Anh> lst = new AnhRepository().getAll();
//        for (Anh x : lst) {
//            System.out.println(x.toString());
//        }
//    }
}
