package com.fpt.it17326.nhom5.repository;

import com.fpt.it17326.nhom5.config.HibernateConfig;
import com.fpt.it17326.nhom5.domainmodel.HangDienThoai;
import com.fpt.it17326.nhom5.util.Util;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 * AowVN_Nyaruko
 *
 */
public class HangDienThoaiRepository {

    private Session session = HibernateConfig.getFACTORY().openSession();

    private String fromTable = "FROM HangDienThoai";

    public List<HangDienThoai> getAll() {
        String sql = fromTable + " WHERE deleted = 0 ORDER BY Id DESC";
        Query query = session.createQuery(sql);
        return query.getResultList();
    }
    
    public List<HangDienThoai> getAllDeleted() {
        String sql = fromTable + " WHERE deleted = 1 ORDER BY UpdatedAt DESC";
        Query query = session.createQuery(sql);
        return query.getResultList();
    }

    public HangDienThoai getOne(String MaHangDT) {
        String sql = fromTable + " WHERE MaHangDT =: MaHangDT";
        Query query = session.createQuery(sql);
        query.setParameter("MaHangDT", MaHangDT);
        return (HangDienThoai) query.getSingleResult();
    }

    public List<HangDienThoai> searchDeleted(String tenHang) {
        tenHang = "%" + tenHang + "%";
        String sql = fromTable + " WHERE TenHang LIKE :TenHang1 and deleted = 1";
        Query query = session.createQuery(sql);
        query.setParameter("TenHang1", tenHang);
        return query.getResultList();
    }
    
    public Boolean add(HangDienThoai hdt) {
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(hdt);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean update(HangDienThoai hdt) {
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(hdt);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean delete(HangDienThoai hdt) {
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            hdt.setDeleted(true);
            hdt.setUpdatedAt(Util.getCurrentDate());
            session.update(hdt);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

//    public static void main(String[] args) throws ParseException {
//        HangDienThoai hdt = new HangDienThoai();
//        hdt.setMaHangDT("HDT001");
//        hdt.setTenHang("HTC");
//        hdt.setDeleted(false);
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        hdt.setCreatedAt(format.parse("2022-11-23"));
//        hdt.setUpdatedAt(format.parse("2022-11-22"));
//        
//        new HangDienThoaiRepository().add(hdt);
//        
//        List<HangDienThoai> lst = new HangDienThoaiRepository().getAll();
//        
//        for (HangDienThoai hangDienThoai : lst) {
//            System.out.println(hangDienThoai.toString());
//        }
//    }
}
