package com.fpt.it17326.nhom5.repository;

import com.fpt.it17326.nhom5.config.HibernateConfig;
import com.fpt.it17326.nhom5.domainmodel.LoaiSP;
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
public class LoaiSPRepository {

    private Session session = HibernateConfig.getFACTORY().openSession();

    private String fromTable = "FROM LoaiSP";

    public List<LoaiSP> getAll() {
        Query query = session.createQuery(fromTable);
        return query.getResultList();
    }

    public LoaiSP getOne(String MaLoaiSP) {
        String sql = fromTable + " WHERE MaLoaiSP =: MaLoaiSP";
        Query query = session.createQuery(sql);
        query.setParameter("MaLoaiSP", MaLoaiSP);
        return (LoaiSP) query.getSingleResult();
    }

    public Boolean add(LoaiSP lsp) {
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(lsp);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean update(LoaiSP lsp) {
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(lsp);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean delete(LoaiSP lsp) {
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            lsp.setDeleted(true);
            session.update(lsp);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

//    public static void main(String[] args) throws ParseException {
//        LoaiSPRepository loaiSPRepository = new LoaiSPRepository();
//        LoaiSP lsp = new LoaiSP();
//        lsp.setId("C04F905E-7DD7-40DE-B829-36F4DD4FB6B9");
//        lsp.setMaLoaiSP("LSP002");
//        lsp.setTenDanhMuc("Máy Tính");
//        lsp.setMota("May Tinh dok");
//        lsp.setDeleted(false);
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        lsp.setCreatedAt(format.parse("2022-11-23"));
//        lsp.setUpdatedAt(format.parse("2022-11-22"));
//
//        loaiSPRepository.update(lsp);
//
//        List<LoaiSP> lst = loaiSPRepository.getAll();
//        for (LoaiSP x : lst) {
//            System.out.println(x.toString());
//        }
//    }
}
