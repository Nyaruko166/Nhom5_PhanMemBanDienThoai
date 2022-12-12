/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.it17326.nhom5.repository;

import com.fpt.it17326.nhom5.config.HibernateConfig;
import com.fpt.it17326.nhom5.domainmodel.SanPham;
import com.fpt.it17326.nhom5.util.Util;
import java.awt.image.SampleModel;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Repository;

/**
 *
 * @author youngboizseetinh
 */
@Repository
public class SanPhamRepository {

    private Session session = HibernateConfig.getFACTORY().openSession();

    private String fromTable = "FROM SanPham";

    @Async
    public SanPham getOneSP(String MaSanPham) {
        SanPham sp = null;
        try {
            session = HibernateConfig.getFACTORY().openSession();
            String sql = fromTable + " WHERE TenSP =:TenSP";
            Query query = session.createQuery(sql);
            query.setParameter("TenSP", MaSanPham);
            sp = (SanPham) query.getSingleResult();
        } catch (Exception e) {
        }finally {
            session.close();
        }
        return sp;
    }
    
    public SanPham getById(int id) {
        try {
            session = HibernateConfig.getFACTORY().openSession();
            String sql = fromTable + "  WHERE ID = :id ";
            Query query = session.createQuery(sql);
            query.setParameter("id", id);
            return (SanPham) query.getSingleResult();
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }

    @Async
    public SanPham getOneMa(int id) {
        String sql = fromTable + " WHERE Id =:id";
        Query query = session.createQuery(sql);
        query.setParameter("id", id);
        return (SanPham) query.getSingleResult();
    }


    @Async
    public List<SanPham> getAll() {
        List<SanPham> list = null;
        try {
            session = HibernateConfig.getFACTORY().openSession();
            String sql = fromTable + " WHERE deleted = 0  ORDER BY Id DESC";
            Query query = session.createQuery(sql);
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        
        return list;
    }

    @Async
    public List<SanPham> getAllDeleted() {
        List<SanPham> list = null;
        try {
            session = HibernateConfig.getFACTORY().openSession();
            String sql = fromTable + " WHERE deleted = 1 ORDER BY UpdatedAt DESC";
        Query query = session.createQuery(sql);
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }

    @Async
    public List<SanPham> search(String tenSP) {
        List<SanPham> list = new ArrayList<>();
        try {
            session = HibernateConfig.getFACTORY().openSession();
            tenSP = "%" + tenSP + "%";
            String sql = fromTable + " WHERE TenSP LIKE :TenSP1 and deleted = 0";
            Query query = session.createQuery(sql);
            query.setParameter("TenSP1", tenSP);
            return query.getResultList();
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return list;
    }

    @Async
    public List<SanPham> searchDeleted(String tenSP) {
        List<SanPham> list = new ArrayList<>();
        try {
            session = HibernateConfig.getFACTORY().openSession();
            tenSP = "%" + tenSP + "%";
            String sql = fromTable + " WHERE TenSP LIKE :TenSP1 and deleted = 1";
            Query query = session.createQuery(sql);
            query.setParameter("TenSP1", tenSP);
            list = query.getResultList();
        } catch (Exception e) {
        } finally {
            session.close();
        }
        
        return list;
    }

    public SanPham getSPLast() {
        SanPham p = null;
        try {
            session = HibernateConfig.getFACTORY().openSession();
            String sql = fromTable + " ORDER BY Id DESC";
            Query query = session.createQuery(sql);
            query.setMaxResults(1);
             p =(SanPham) query.getSingleResult();
        } catch (Exception e) {
        } finally {
            session.close();
        }
        
        return p;
    }

    @Async
    public SanPham getOne(int id) {
        SanPham p = null;
        try {
            session = HibernateConfig.getFACTORY().openSession();
            String sql = fromTable + " WHERE Id =: id";

            Query query = session.createQuery(sql);
            query.setParameter("id", id);
            p =  (SanPham) query.getSingleResult();
        } catch (Exception e) {
        } finally {
            session.close();
        }
        
        return p;
        
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
        } finally {
            session.close();
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
        }finally {
            session.close();
        }
        return null;
    }

    @Async
    public Boolean delete(SanPham sp) {
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            sp.setDeleted(true);
            sp.setUpdatedAt(Util.getCurrentDate());
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

    @Async
    public int count() {
        String sql = "Select COUNT(sp.id) from SanPham sp";
        Query countQuery = session.createQuery(sql);
        return Integer.parseInt(countQuery.uniqueResult().toString());
    }

    @Async
    public Boolean deleteById(int id) {
        SanPham sp = getById(id);
        sp.setDeleted(true);
        sp.setUpdatedAt(Util.getCurrentDate());
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.update(sp);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }

    @Async
    public Boolean restoreById(int id) {
        SanPham sp = getById(id);
        sp.setDeleted(false);
        sp.setUpdatedAt(Util.getCurrentDate());
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.update(sp);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }
}
