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
}
