package com.fpt.it17326.nhom5.config;

import com.fpt.it17326.nhom5.domainmodel.Chip;
import com.fpt.it17326.nhom5.domainmodel.HangDienThoai;
import com.fpt.it17326.nhom5.domainmodel.HoaDon;
import com.fpt.it17326.nhom5.domainmodel.HoaDonChiTiet;
import com.fpt.it17326.nhom5.domainmodel.Imei;
import com.fpt.it17326.nhom5.domainmodel.ImeiDaBan;
import com.fpt.it17326.nhom5.domainmodel.KhachHang;
import com.fpt.it17326.nhom5.domainmodel.KhuyenMai;
import com.fpt.it17326.nhom5.domainmodel.MauSac;
import com.fpt.it17326.nhom5.domainmodel.NhanVien;
import com.fpt.it17326.nhom5.domainmodel.Pin;
import com.fpt.it17326.nhom5.domainmodel.Ram;
import com.fpt.it17326.nhom5.domainmodel.Rom;
import com.fpt.it17326.nhom5.domainmodel.SanPham;
import com.fpt.it17326.nhom5.domainmodel.SanPhamGiamGia;
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
        properties.put(Environment.PASS, "123456");
        properties.put(Environment.SHOW_SQL, "false");
        conf.setProperties(properties);
        //Add @Entity
        //conf.addAnnotatedClass(*);
        //conf.addAnnotatedClass(*.class);
        conf.addAnnotatedClass(MauSac.class);
        conf.addAnnotatedClass(HangDienThoai.class);
        conf.addAnnotatedClass(Chip.class);
        conf.addAnnotatedClass(NhanVien.class);
        conf.addAnnotatedClass(Ram.class);
        conf.addAnnotatedClass(Rom.class);
        conf.addAnnotatedClass(Chip.class);
        conf.addAnnotatedClass(Pin.class);
        conf.addAnnotatedClass(SanPham.class);
        conf.addAnnotatedClass(HoaDon.class);
        conf.addAnnotatedClass(HoaDonChiTiet.class);
        conf.addAnnotatedClass(KhuyenMai.class);
        conf.addAnnotatedClass(ImeiDaBan.class);
        conf.addAnnotatedClass(Imei.class);
        conf.addAnnotatedClass(SanPhamGiamGia.class);
        conf.addAnnotatedClass(KhachHang.class);

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
