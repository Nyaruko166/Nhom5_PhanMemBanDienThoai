package com.fpt.it17326.nhom5.config;

import com.fpt.it17326.nhom5.domainmodel.TaiKhoan;
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
        properties.put(Environment.USER, "sa");
        properties.put(Environment.PASS, "minhtu1804");
        properties.put(Environment.SHOW_SQL, "true");

        conf.setProperties(properties);
        //Add @Entity
        //conf.addAnnotatedClass(*);
        conf.addAnnotatedClass(TaiKhoan.class);
        

        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties()).build();
        FACTORY = conf.buildSessionFactory(registry);

    }

    public static SessionFactory getFACTORY() {
        return FACTORY;
    }

    public static void main(String[] args) {
        getFACTORY();
    }
}
