package com.fpt.it17326.nhom5.repository;

import com.fpt.it17326.nhom5.config.HibernateConfig;
import com.fpt.it17326.nhom5.domainmodel.ImeiDaBan;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 * AowVN_Nyaruko
 *
 */
public class ImeiDaBanRepository {

    private Session session = HibernateConfig.getFACTORY().openSession();
    private String fromTable = "FROM ImeiDaBan";

    public List<ImeiDaBan> getAll() {
        Query query = session.createQuery(fromTable);
        return query.getResultList();
    }

    
//    public static void main(String[] args) {
//        ImeiDaBanRepository imeiDaBanRepository = new ImeiDaBanRepository();
//        List<ImeiDaBan> lst = imeiDaBanRepository.getAll();
//        for (ImeiDaBan imeiDaBan : lst) {
//            System.out.println(imeiDaBan.toString());
//        }
//    }
}
