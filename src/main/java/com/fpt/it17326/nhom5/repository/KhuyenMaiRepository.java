/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.it17326.nhom5.repository;

import com.fpt.it17326.nhom5.config.HibernateConfig;
import com.fpt.it17326.nhom5.domainmodel.KhuyenMai;
import com.fpt.it17326.nhom5.response.KhuyenMaiResponse;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author youngboizseetinh
 */
public class KhuyenMaiRepository {

    private Session session = HibernateConfig.getFACTORY().openSession();

    private String fromTable = "FROM KhuyenMai";

    public List<KhuyenMai> getAll() {
        Query query = session.createQuery(fromTable);
        return query.getResultList();
    }

    public List<KhuyenMai> getAllTrue() {
        Query query = session.createQuery(fromTable + " where Deleted = 'true'");
        return query.getResultList();
    }

    public List<KhuyenMai> getAllFalse() {
        Query query = session.createQuery(fromTable + " where Deleted = 'false'");
        return query.getResultList();
    }

    public KhuyenMai getOne(int id) {
        String sql = fromTable + " WHERE id=:id";
        Query query = session.createQuery(sql);
        query.setParameter("id", id);
        return (KhuyenMai) query.getSingleResult();
    }

    public Boolean add(KhuyenMai km) {
        Transaction transaction = null;
        int affectedRows = 0;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            String hql = "UPDATE [dbo].[KhuyenMai]\n"
                    + "   SET [MaKM] =:Ma\n"
                    + "      ,[TenKM] =:TenKM\n"
                    + "      ,[SoTienGiam] =:SoTienGiam\n"
                    + "      ,[NgayBatDau] =:NgayBatDau\n"
                    + "      ,[NgayKetThuc] =:NgayKetThuc\n"
                    + "      ,[UpdatedAt] =:Upda\n"
                    + " WHERE id=:id";
            Query query = session.createQuery(hql);
            query.setParameter("id", km.getId());
            query.setParameter("TenKM", km.getTenKM());
            query.setParameter("SoTienGiam", km.getSoTienGiam());
            query.setParameter("NgayBatDau", km.getNgayBatDau());
            query.setParameter("NgayKetThuc", km.getNgayKetThuc());
            query.setParameter("Upda", km.getUpdatedAt());
            affectedRows = query.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return affectedRows > 0;
    }

    public Boolean update(KhuyenMai km) {
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(km);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean delete(int id) {
        Transaction transaction = null;
        int affectedRows = 0;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            String hql = "update KhuyenMai set Deleted = 'false' where id =:id";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            affectedRows = query.executeUpdate();
        } catch (Exception e) {
        }
        return affectedRows > 0;
    }
}
