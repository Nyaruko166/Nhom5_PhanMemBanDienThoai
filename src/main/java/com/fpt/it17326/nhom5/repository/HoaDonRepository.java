package com.fpt.it17326.nhom5.repository;

import com.fpt.it17326.nhom5.config.HibernateConfig;
import com.fpt.it17326.nhom5.domainmodel.HoaDon;
import com.fpt.it17326.nhom5.domainmodel.KhuyenMai;
import com.fpt.it17326.nhom5.domainmodel.NhanVien;
import com.fpt.it17326.nhom5.domainmodel.TrangThaiHoaDon;
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
    public static List<HoaDon> getAll1() {
        Session session = HibernateConfig.getFACTORY().openSession();
        Query query = session.createQuery("From HoaDon");
        return query.getResultList();
    }
    public static void main(String[] args) {
        List<HoaDon> hoaDon = getAll1();
        for (HoaDon x : hoaDon) {
            System.out.println(x);
        }
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
            String sql = "from KhuyenMai where id = 7";
            Query que = session.createQuery(sql);
            KhuyenMai km = (KhuyenMai)que.getSingleResult();
            
            String sql1 = "from NhanVien where id = 1";
            Query que1 = session.createQuery(sql1);
            NhanVien nv = (NhanVien)que1.getSingleResult();
            
            
            String sql2 = "from TrangThaiHoaDon where id = 1";
            Query que2 = session.createQuery(sql2);
            TrangThaiHoaDon tt = (TrangThaiHoaDon)que2.getSingleResult();
            hd.setNhanVien(nv);
            hd.setTrangThaiHoaDon(tt);
            hd.setKhuyenMai(km);
            session.save(hd);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
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
