package com.fpt.it17326.nhom5.config;

import com.fpt.it17326.nhom5.domainmodel.Anh;
import com.fpt.it17326.nhom5.domainmodel.HangDienThoai;
import com.fpt.it17326.nhom5.domainmodel.LoaiSP;
import com.fpt.it17326.nhom5.domainmodel.MauSac;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class HibernateConfig {

    private static final SessionFactory FACTORY;

    static {
        Configuration conf = new Configuration();

        Properties properties = new Properties();
        properties.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
        properties.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        properties.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=QUANLYBANDIENTHOAI");
        properties.put(Environment.USER, "nya");
        properties.put(Environment.PASS, "123456");
        properties.put(Environment.SHOW_SQL, "true");

        conf.setProperties(properties);
        //Add @Entity
        //conf.addAnnotatedClass(*);
        //conf.addAnnotatedClass(*.class);
        conf.addAnnotatedClass(Anh.class);
        conf.addAnnotatedClass(MauSac.class);
        conf.addAnnotatedClass(LoaiSP.class);
        conf.addAnnotatedClass(HangDienThoai.class);
        

        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties()).build();
        FACTORY = conf.buildSessionFactory(registry);

    }

    public static SessionFactory getFACTORY() {
        return FACTORY;
    }

//    public static void main(String[] args) {
//        getFACTORY();
//    }
}
