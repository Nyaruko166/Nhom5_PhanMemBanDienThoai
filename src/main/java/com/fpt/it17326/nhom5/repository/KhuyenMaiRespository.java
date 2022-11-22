/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.it17326.nhom5.repository;

import com.fpt.it17326.nhom5.config.HibernateConfig;
import com.fpt.it17326.nhom5.domainmodel.KhuyenMai;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ngock
 */
public class KhuyenMaiRespository {
    private Session session = HibernateConfig.getFACTORY().openSession();

    private String fromTable = "From KHUYENMAI"; //HQL
    public List<KhuyenMai> getAll() {
        Query query = session.createQuery(fromTable);
        return query.getResultList();
    }
    public KhuyenMai getOne(int id) {
        String sql = fromTable + "Where id=:id";
        Query query = session.createQuery(sql, KhuyenMai.class);
        query.setParameter("id", id);
        return (KhuyenMai) query.getSingleResult();
    }
    
    public Boolean add(KhuyenMai khuyenMai){
         Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(khuyenMai);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    public Boolean update(KhuyenMai khuyenMai, int id) {
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(khuyenMai);
            transaction.commit();
            return true;
        } catch (Exception e) {
        }
        return null;
    }

    public Boolean delete(KhuyenMai khuyenMai) {
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            //            Query query = session.createQuery("update LopHoc set tenLop = :tenLop"
//                    + " where maLop = :maLop");
//            query.setParameter("tenLop", "Lop update123");
//            query.setParameter("maLop", 113);
//            query.executeUpdate();
            session.delete(khuyenMai);
            transaction.commit();
            return true;
        } catch (Exception e) {
        }
        return null;
    }

}
