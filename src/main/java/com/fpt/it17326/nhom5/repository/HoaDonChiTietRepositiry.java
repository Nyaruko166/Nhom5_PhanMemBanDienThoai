/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.it17326.nhom5.repository;

import com.fpt.it17326.nhom5.config.HibernateConfig;
import com.fpt.it17326.nhom5.domainmodel.HoaDonChiTiet;
import com.fpt.it17326.nhom5.domainmodel.ImeiDaBan;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author PHAM DAC THANG
 */
public class HoaDonChiTietRepositiry {
//thang

    private Session session = HibernateConfig.getFACTORY().openSession();

    private String fromTable = "FROM HoaDonChiTiet";
    private String fromTableimeiban = "FROM ImeiDaBan";

    public List<HoaDonChiTiet> getAll1() {
        Query query = session.createQuery(fromTable);
        return query.getResultList();
    }

    public HoaDonChiTiet getOne(String id) {
        String sql = fromTable + " WHERE Id =: Id";
        Query query = session.createQuery(sql);
        query.setParameter("Id", id);
        return (HoaDonChiTiet) query.getSingleResult();
    }
    
    public List<HoaDonChiTiet> getAll() {
        Query query = session.createQuery(fromTable);
        List<HoaDonChiTiet> lst = query.list();
        return lst;
    }

    public List<ImeiDaBan> getAllimaidaban() {
        Query query = session.createQuery(fromTableimeiban);
        List<ImeiDaBan> lst = query.list();
        return lst;
    }

    public static void main(String[] args) {
        new HoaDonChiTietRepositiry().getAll().forEach(s -> System.out.println("ta co---" + s.toString()));
    }
    //thang
}
