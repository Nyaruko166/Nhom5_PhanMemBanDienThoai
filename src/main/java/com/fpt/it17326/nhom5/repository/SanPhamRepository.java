/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.it17326.nhom5.repository;

import com.fpt.it17326.nhom5.config.HibernateConfig;
import com.fpt.it17326.nhom5.domainmodel.SanPham;
import java.awt.image.SampleModel;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 *
 * @author youngboizseetinh
 */
public class SanPhamRepository {

    private Session session = HibernateConfig.getFACTORY().openSession();

    private String fromTable = "FROM SanPham";

    public SanPham getOneSP(String MaSanPham) {
        String sql = fromTable + " WHERE TenSP =:TenSP";
        Query query = session.createQuery(sql);
        query.setParameter("TenSP", MaSanPham);
        return (SanPham) query.getSingleResult();
    }

    public SanPham getOneMa(int MaSanPham) {
        String sql = fromTable + " WHERE id =:TenSP";
        Query query = session.createQuery(sql);
        query.setParameter("TenSP", MaSanPham);
        return (SanPham) query.getSingleResult();
    }
    

    @Async
    public List<SanPham> getAll() {
        String sql = fromTable + " WHERE deleted = 0  ORDER BY Id DESC";
        Query query = session.createQuery(sql);
        return query.getResultList();
    }

    @Async
    public List<SanPham> getAllDeleted() {
        String sql = fromTable + " WHERE deleted = 1 ORDER BY Id DESC";
        Query query = session.createQuery(sql);
        return query.getResultList();
    }

    public List<SanPham> search(String tenSP) {
        tenSP = "%" + tenSP + "%";
        String sql = fromTable + " WHERE TenSP LIKE :TenSP1 and deleted = 0";
        Query query = session.createQuery(sql);
        query.setParameter("TenSP1", tenSP);
        return query.getResultList();
    }

    @Async
    public SanPham getSPLast() {
        String sql = fromTable + " ORDER BY Id DESC";
        Query query = session.createQuery(sql);
        query.setMaxResults(1);
        return (SanPham) query.getSingleResult();
    }

    public SanPham getOne(int id) {
        String sql = fromTable + " WHERE Id =: id";

        Query query = session.createQuery(sql);
        query.setParameter("id", id);
        return (SanPham) query.getSingleResult();
    }

    @Async
    public Boolean add(SanPham sp) {
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(sp);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Async
    public Boolean update(SanPham sp) {
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(sp);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Async
    public Boolean delete(SanPham sp) {
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            sp.setDeleted(true);
            session.update(sp);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Async
    public Boolean updateSL(SanPham sp, int sl) {
        boolean update = false;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            Transaction tran = session.beginTransaction();
            try {
                String hql = "UPDATE SanPham SET SoLuong = :sl";
                Query query = session.createQuery(hql);
                query.setParameter("sl", sl);
                int check = query.executeUpdate();
                if (check == 0) {
                    update = false;

                }
                tran.commit();
                update = true;
            } catch (Exception e) {
                e.printStackTrace();
                tran.rollback();
            }
        }
        return update;
    }
}
