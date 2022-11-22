package com.fpt.it17326.nhom5.repository;

import com.fpt.it17326.nhom5.config.HibernateConfig;
import com.fpt.it17326.nhom5.domainmodel.MauSac;
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
public class MauSacRepository {

    private Session session = HibernateConfig.getFACTORY().openSession();

    private String fromTable = "FROM MauSac";

    public List<MauSac> getAll() {
        Query query = session.createQuery(fromTable);
        return query.getResultList();
    }

    public MauSac getOne(String MaMauSac) {
        String sql = fromTable + " WHERE MaMauSac =: MaMauSac1";

        Query query = session.createQuery(sql);
        query.setParameter("MaMauSac1", MaMauSac);
        return (MauSac) query.getSingleResult();
    }

    public Boolean add(MauSac ms) {
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(ms);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean update(MauSac ms) {
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(ms);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean delete(MauSac ms) {
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            ms.setDeleted(true);
            session.update(ms);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

//    public static void main(String[] args) throws ParseException {
//        MauSacRepository mauSacRepository = new MauSacRepository();
//
//        MauSac ms = mauSacRepository.getOne("C29F2974-37C6-417E-85AE-310182D856C0");
//        System.out.println(ms.toString());
//        MauSac ms = new MauSac();
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        ms.setTenMauSac("Hồng");
//        ms.setCreatedAt(format.parse("2022-11-20"));
//        ms.setDeleted(false);
//        ms.setUpdatedAt(format.parse("2022-11-22"));
//        ms.setMaMauSac("05641DA4-6706-4AA9-B007-875FDF74220B");
//        mauSacRepository.update(ms);
//
//        List<MauSac> lstms = mauSacRepository.getAll();
//        for (MauSac x : lstms) {
//            System.out.println(x.toString());
//        }
//    }
}
