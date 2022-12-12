/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.it17326.nhom5.repository;

import com.fpt.it17326.nhom5.config.HibernateConfig;
import com.fpt.it17326.nhom5.domainmodel.Rom;
import com.fpt.it17326.nhom5.util.Util;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author youngboizseetinh
 */
public class RomRepository {

    private Session session = HibernateConfig.getFACTORY().openSession();

    private String fromTable = "FROM Rom";

    public List<Rom> getAll() {
        String sql = fromTable + " WHERE deleted = 0 ORDER BY Id DESC";
        Query query = session.createQuery(sql);
        return query.getResultList();
    }

    public List<Rom> getAllDeleted() {
        String sql = fromTable + " WHERE deleted = 1 ORDER BY UpdatedAt DESC";
        Query query = session.createQuery(sql);
        return query.getResultList();
    }

    public Rom getOne(String MaRom) {
        String sql = fromTable + " WHERE MaRom =: MaRom1";

        Query query = session.createQuery(sql);
        query.setParameter("MaRom1", MaRom);
        return (Rom) query.getSingleResult();
    }

    public List<Rom> searchDeleted(String tenRom) {
        tenRom = "%" + tenRom + "%";
        String sql = fromTable + " WHERE TenRom LIKE :TenRom1 and deleted = 1";
        Query query = session.createQuery(sql);
        query.setParameter("TenRom1", tenRom);
        return query.getResultList();
    }

    public Boolean add(Rom rom) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(rom);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean update(Rom rom) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(rom);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean delete(Rom rom) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            rom.setDeleted(true);
            rom.setUpdatedAt(Util.getCurrentDate());
            session.update(rom);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

//        public static void main(String[] args) throws ParseException {
//        RomRepository romRepository = new RomRepository();
//
//        Rom rom = romRepository.getOne("1");
//        System.out.println(rom.toString());
//        
    //Rom rom = new Rom();
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        rom.setTenRom("Hồng");
//        rom.setCreatedAt(format.parse("2022-11-20"));
//        rom.setDeleted(false);
//        rom.setUpdatedAt(format.parse("2022-11-22"));
//        rom.setMaRom("05641DA4-6706-4AA9-B007-875FDF74220B");
//        romRepository.update(rom);
//
//        List<Rom> lstms = romRepository.getAll();
//        for (Rom x : lstms) {
//            System.out.println(x.toString());
//        }
}
