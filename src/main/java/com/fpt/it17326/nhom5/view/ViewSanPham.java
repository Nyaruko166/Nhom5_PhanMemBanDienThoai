/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.fpt.it17326.nhom5.view;

import com.fpt.it17326.nhom5.domainmodel.KhachHang;
import org.springframework.scheduling.annotation.EnableAsync;

import static com.fpt.it17326.nhom5.util.Util.getNameFileFromPath;

import javax.mail.*;

import com.fpt.it17326.nhom5.domainmodel.Chip;
import com.fpt.it17326.nhom5.domainmodel.HangDienThoai;
import com.fpt.it17326.nhom5.domainmodel.SanPham;
import com.fpt.it17326.nhom5.response.SanPhamResponse;
import com.fpt.it17326.nhom5.service.ChipService;
import com.fpt.it17326.nhom5.service.HangDienThoaiService;
import com.fpt.it17326.nhom5.service.PinService;
import com.fpt.it17326.nhom5.service.RamService;
import com.fpt.it17326.nhom5.service.RomService;
import com.fpt.it17326.nhom5.service.SanPhamService;
import com.fpt.it17326.nhom5.service.impl.ChipServiceImpl;
import com.fpt.it17326.nhom5.service.impl.HangDienThoaiServiceImpl;
import com.fpt.it17326.nhom5.service.impl.PinServiceImpl;
import com.fpt.it17326.nhom5.service.impl.RamServiceImpl;
import com.fpt.it17326.nhom5.service.impl.RomServiceImpl;
import com.fpt.it17326.nhom5.service.impl.SanPhamServiceImpl;
import com.fpt.it17326.nhom5.util.Util;
import javax.swing.JFileChooser;

import com.fpt.it17326.nhom5.domainmodel.HoaDon;
import com.fpt.it17326.nhom5.domainmodel.HoaDonChiTiet;
import com.fpt.it17326.nhom5.domainmodel.Imei;
import com.fpt.it17326.nhom5.domainmodel.ImeiDaBan;
import com.fpt.it17326.nhom5.domainmodel.KhuyenMai;
import com.fpt.it17326.nhom5.domainmodel.MauSac;
import com.fpt.it17326.nhom5.domainmodel.NhanVien;
import com.fpt.it17326.nhom5.domainmodel.Pin;
import com.fpt.it17326.nhom5.domainmodel.Ram;
import com.fpt.it17326.nhom5.domainmodel.Rom;
import com.fpt.it17326.nhom5.domainmodel.SanPhamGiamGia;
import com.fpt.it17326.nhom5.repository.KhuyenMaiRepository;
import com.fpt.it17326.nhom5.repository.NhanVienRepository;
import com.fpt.it17326.nhom5.repository.SanPhamGiamGiaRepository;
import com.fpt.it17326.nhom5.repository.SanPhamRepository;
import com.fpt.it17326.nhom5.response.ImeiResponse;
import com.fpt.it17326.nhom5.response.KhachHangResponse;
import com.fpt.it17326.nhom5.response.KhuyenMaiResponse;
import com.fpt.it17326.nhom5.response.NhanVienResponse;
import com.fpt.it17326.nhom5.service.ImeiDaBanService;
import com.fpt.it17326.nhom5.service.ImeiService;
import com.fpt.it17326.nhom5.service.KhachHangService;
import com.fpt.it17326.nhom5.service.KhuyenMaiService;
import com.fpt.it17326.nhom5.service.MauSacService;
import com.fpt.it17326.nhom5.service.NhanVienService;
import com.fpt.it17326.nhom5.service.impl.ImeiDaBanServiceImpl;
import com.fpt.it17326.nhom5.service.impl.ImeiServiceImpl;
import com.fpt.it17326.nhom5.service.impl.KhachHangServiceImpl;
import com.fpt.it17326.nhom5.service.impl.KhuyenMaiServiceImpl;
import com.fpt.it17326.nhom5.service.impl.MauSacServiceImpl;
import com.fpt.it17326.nhom5.service.impl.NhanVienServiceImpl;
import com.fpt.it17326.nhom5.util.KhuyenMaThread;
import java.awt.image.BufferedImage;
import java.awt.Font;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.fpt.it17326.nhom5.response.HoaDonResponse;
import com.fpt.it17326.nhom5.response.ThongkeResponse;
import com.fpt.it17326.nhom5.response.bieudo;
import com.fpt.it17326.nhom5.service.HoaDonChiTietService;
import com.fpt.it17326.nhom5.service.HoaDonService;
import com.fpt.it17326.nhom5.service.impl.HoaDonChiTietServiceImpl;
import com.fpt.it17326.nhom5.service.impl.HoaDonServiceImpl;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import javax.swing.JFrame;
import org.apache.commons.lang3.RandomStringUtils;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

//banhang thang
import com.fpt.it17326.nhom5.repobanhang.banhang_repo;

import com.fpt.it17326.nhom5.viewmodel.hoadonbanhang;
import com.fpt.it17326.nhom5.viewmodel.sanphambanhang;
import com.fpt.it17326.nhom5.viewmodel.xuathoadon;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
//banhang thang
//xuat hoadon
//import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.color.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;
import java.text.SimpleDateFormat;
import java.util.Date;
// xuat hoa don

/**
 *
 * @author PHAM DAC THANG
 */
@EnableAsync
public class ViewSanPham extends javax.swing.JFrame {

    private int page = 0;
    private int totalRow = 0;
    private int totalPage = 0;
    private int itemPerPage = 2;
    private int start = 0;

    private DefaultTableModel dtmKHDeleted;
    private DefaultTableModel dtmLichSu;
    private KhachHangService khachHangService;
    private DefaultTableModel dtmKH;
    DefaultTableModel dfm;
    DefaultTableModel dfm2;
    DefaultTableModel dfm3;
    private KhuyenMaiService khuyenMaiService;
    List<KhuyenMaiResponse> lists;
    List<KhuyenMaiResponse> lists2;
    List<SanPham> sanPham;
    private String MaHoaDon;
    private DefaultTableModel dtmHDImei;
    private DefaultTableModel dtmHoaDon;
    private DefaultTableModel dtmHDSP;
    private ChipService chipService;
    private PinService pinService;
    private RamService ramService;
    private RomService romService;
    private HangDienThoaiService hangDienThoaiService;
    private MauSacService mauSacService;
    private ImeiService imeiService;
    private String urlAnh;
    private String urlUploadAnh;
    private ImeiDaBanService imeiDaBanService;
    private List<Chip> listChip;
    private List<Pin> listPin;
    private List<Ram> listRam;
    private List<Rom> listRom;
    private List<HangDienThoai> listHangDT;
    private List<SanPham> listSp;
    private List<MauSac> listMauSac;
    private List<Imei> imeis;
    private List<ImeiResponse> listImei;
    private List<SanPham> listSanPhamDeleted;
    // chi
    private DefaultTableModel dtmSP = new DefaultTableModel();
    private DefaultTableModel dtmGH = new DefaultTableModel();
    private List<SanPhamResponse> listSanPham = new ArrayList<>();
    private SanPhamService sanPhamService = new SanPhamServiceImpl();
    private HoaDonService hoaDonService = new HoaDonServiceImpl();
    private List<NhanVienResponse> listNhanVien = new ArrayList<>();
    private NhanVienService nhanvienService = new NhanVienServiceImpl();
    private DefaultTableModel dtmNV = new DefaultTableModel();
    private List<NhanVien> listnhanvien = new ArrayList<>();
    private List<NhanVienResponse> listnhanvienfalse;
    List<NhanVienResponse> list1;
    List<NhanVienResponse> list2;
    List<NhanVienResponse> list3;
    DefaultTableModel modelnv1;
    DefaultTableModel modelnv2;
    DefaultTableModel modelnv3;
    Color bgColo = new Color(0, 0, 102);

    //------Thang
    DefaultTableModel defaultTable;
    HoaDonChiTietService HoaDonChiTietService = new HoaDonChiTietServiceImpl();
    HoaDonService HoaDonService = new HoaDonServiceImpl();

    private List<ThongkeResponse> listThongke = new ArrayList<>();
    String ngaybatdau = "a";
    String nayketthuc = "a";
    List<bieudo> b = new ArrayList();
    int kiemtravitribangthongke = 0;
    DefaultTableModel vitribangexcle;
    //thang
    private String dataConstructor;
    NhanVienService dvnv = new NhanVienServiceImpl();
    private String generatedString = RandomStringUtils.randomAlphanumeric(6);
    NhanVienRepository nvr = new NhanVienRepository();

    //BÁN HÀNG THẮNG
    List<hoadonbanhang> listtheloai = new ArrayList<>();
    banhang_repo rp = new banhang_repo();
    double tongtienhangbanhang = 0;
    double tongtienhangsaukhuyenmai = 0;
    String tenkhachhangbanhang = null;
    String manhanviendangnhap = null;

    //BÁN HÀNG THẮNG
    /**
     * Creates new form BanHang
     */
    public ViewSanPham(String dataConstructor) {
        initComponents();
        pnPaging.setVisible(false);
        this.dataConstructor = dataConstructor;
        NhanVien nv = dvnv.getOneByUsername(dataConstructor);
        dtmKHDeleted = (DefaultTableModel) tblThongtinKHDeleted.getModel();
        dtmHoaDon = (DefaultTableModel) tblHoaDon.getModel();
        setuptblHD();
        manhanviendangnhap = nv.getMaNhanVien();   /// THẮNG CHÈN VÀO mới lấy dc mã
        txtHoTen.setText(nv.getHoTen());
        txtMa.setText(nv.getMaNhanVien());
        txtMaNV.setText(nv.getMaNhanVien());
        txtTenNV.setText(nv.getHoTen());
        String gt = "";
        if (nv.isGioiTinh() == true) {
            gt = "Nam";
        } else {
            gt = "Nu";
        }
        txtGioiTinh.setText(gt);
        txtChucVu.setText(nv.getTenCV());
        txtEmailttcn.setText(nv.getEmail());
        txtQueQuanttcn.setText(nv.getQueQuan());
        txtNgaySinhttcn.setText(nv.getNgaySinh() + "");
        dtmLichSu = (DefaultTableModel) tblLichSu.getModel();
        dtmKH = (DefaultTableModel) tblThongtinKH1.getModel();
        khachHangService = new KhachHangServiceImpl();
        showDataKM6();
        imeiDaBanService = new ImeiDaBanServiceImpl();
        SanPhamRepository giaRepository = new SanPhamRepository();
        KhuyenMaThread khuyenMaThread = new KhuyenMaThread();
        khuyenMaThread.start();
        dfm = (DefaultTableModel) tbl_KhuyenMaiNgungHoatDong.getModel();
        dfm2 = (DefaultTableModel) tbl_KhuyenMai.getModel();
        dfm3 = (DefaultTableModel) tbl_SanPhamGiamGia.getModel();
        khuyenMaiService = new KhuyenMaiServiceImpl();
        lists = khuyenMaiService.getAllTrue();
        lists2 = khuyenMaiService.getAllFalse();
        listSanPham = sanPhamService.getAll();
        showDataKM(lists);
        showDataKM2(lists2);
        showDataKM3(listSanPham);

        dtmHDSP = (DefaultTableModel) tblSP.getModel();
        dtmHDImei = (DefaultTableModel) tblImei.getModel();
        listImei = new ArrayList<>();
        initService();
        //Hieu
        selecttablenv();
        cbbchucvu.removeAllItems();
        cbbchucvu.addItem("Quan ly");
        cbbchucvu.addItem("Nhan vien");
        loadtable();
        list1 = nhanvienService.getAllTrue();
        list2 = nhanvienService.getAllFalse();
        list3 = nhanvienService.getAllTrue();
        listNhanVien = nhanvienService.getAll();
        modelnv1 = (DefaultTableModel) tablenv.getModel();
        modelnv2 = (DefaultTableModel) tableluutru.getModel();
        modelnv3 = (DefaultTableModel) tablenv.getModel();
        loadnv1(list1);
        loadnv2(list2);
        loadnv3(list3);
        //Hieu

        String[] hearder = {"Tên SP", "Hãng", "Chip", "Ram", "Rom", "Pin", "Màu sắc", "Số lượng", "Mô Tả", "Đơn giá"};
        dtmSP.setColumnIdentifiers(hearder);
        listSanPham = sanPhamService.getAll();
        showData(listSanPham);
        dtmGH.setColumnIdentifiers(hearder);
        dtmHoaDon = (DefaultTableModel) tblHoaDon.getModel();
        designTableSanPham();
        //-------Thang
        loadbangthongke();
        loadbangsanphamtonthongke();
        loadbangsanphambanchaynhat();
        loadbangbieudo();
        gananhbieudo();
        File file = new File("anhbieudo.png");
        try {
            Image img = ImageIO.read(file);
            lbanhbieudo.setIcon(new ImageIcon(img.getScaledInstance(334, 156, 0)));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        //--BanHangthắng
        loadtablebanhanghoadon();
        loadtablebanhangsanpham();
        cbbanhangkhachhang.setModel(new DefaultComboBoxModel(rp.getkhachhangbanhang().toArray()));
        //--BanHangthắng

    }

    ////banhang  thang
    public boolean xuathoadon(String mhd) {
        String pathUnicode = "font\\unicode.ttf";
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            String date = sdf.format(new Date());
            String path = mhd + "_" + date + ".pdf";
            PdfWriter pdfWriter = new PdfWriter(path);
            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            Document document = new Document(pdfDocument);
            float col = 280f;
            float columWidth[] = {col, col};

            PdfFont font = PdfFontFactory.createFont(pathUnicode, BaseFont.IDENTITY_H);

            Table table = new Table(columWidth);
            table.setBackgroundColor(new DeviceRgb(63, 169, 219)).setFontColor(com.itextpdf.kernel.color.Color.WHITE);
            table.setFont(font);

            table.addCell(new Cell().add("A PHONE BILL").setTextAlignment(TextAlignment.CENTER)
                    .setVerticalAlignment(VerticalAlignment.MIDDLE)
                    .setMarginTop(30f)
                    .setMarginBottom(30f)
                    .setFontSize(30f)
                    .setBorder(Border.NO_BORDER));
            table.addCell(new Cell().add("Mã hóa đơn:" + mhd + "\nA Phone store").setTextAlignment(TextAlignment.RIGHT)
                    .setMarginTop(30f)
                    .setMarginBottom(30f)
                    .setBorder(Border.NO_BORDER)
                    .setMarginRight(10f));

            float colWidth[] = {80, 250, 200, 200};
            Table customerInforTable = new Table(colWidth);
            customerInforTable.setFont(font);
            customerInforTable.addCell(new Cell(0, 4).add("Thông tin khách hàng").setBold().setBorder(Border.NO_BORDER));

            customerInforTable.addCell(new Cell().add("Họ tên:").setBorder(Border.NO_BORDER));
            customerInforTable.addCell(new Cell().add("" + rp.xuathoadobbanhang(mhd).get(0).getHoten()).setBorder(Border.NO_BORDER));
            customerInforTable.addCell(new Cell().add("Số điện thoại:").setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT));
            customerInforTable.addCell(new Cell().add("" + rp.xuathoadobbanhang(mhd).get(0).getSdt()).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT));
            customerInforTable.addCell(new Cell().add("Địa chỉ:").setBorder(Border.NO_BORDER));
            customerInforTable.addCell(new Cell().add("" + rp.xuathoadobbanhang(mhd).get(0).getDiachi()).setBorder(Border.NO_BORDER));
            customerInforTable.addCell(new Cell().add("Ngày thanh toán:").setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT));
            customerInforTable.addCell(new Cell().add("" + rp.xuathoadobbanhang(mhd).get(0).getNgaythanhtoan()).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT));

////////////////////////////////////////////////////////////////
            float itemColWidth[] = {15, 110, 110, 50, 140, 140};
            Table itemTable = new Table(itemColWidth);
            itemTable.setFont(font);
            itemTable.addCell(new Cell().add("STT").setBackgroundColor(new DeviceRgb(63, 169, 219)).setFontColor(com.itextpdf.kernel.color.Color.WHITE));
            itemTable.addCell(new Cell().add("Tên sản phẩm").setBackgroundColor(new DeviceRgb(63, 169, 219)).setFontColor(com.itextpdf.kernel.color.Color.WHITE));
            itemTable.addCell(new Cell().add("Thông tin SP").setBackgroundColor(new DeviceRgb(63, 169, 219)).setFontColor(com.itextpdf.kernel.color.Color.WHITE));
            itemTable.addCell(new Cell().add("Số lượng").setBackgroundColor(new DeviceRgb(63, 169, 219)).setFontColor(com.itextpdf.kernel.color.Color.WHITE));
            itemTable.addCell(new Cell().add("Giá bán").setBackgroundColor(new DeviceRgb(63, 169, 219)).setFontColor(com.itextpdf.kernel.color.Color.WHITE));
            itemTable.addCell(new Cell().add("Thành tiền").setBackgroundColor(new DeviceRgb(63, 169, 219)).setFontColor(com.itextpdf.kernel.color.Color.WHITE));
            int stt = 0;
            double tong = 0;
            if (rp.xuathoadobbanhang(mhd).size() > 0) {
                for (xuathoadon x : rp.xuathoadobbanhang(mhd)) {
                    stt = stt + 1;
                    itemTable.addCell(new Cell().add("" + stt));
                    itemTable.addCell(new Cell().add("" + x.getTensp()));
                    itemTable.addCell(new Cell().add("" + x.getThongtinsp()));
                    itemTable.addCell(new Cell().add("" + x.getSolg()));
                    itemTable.addCell(new Cell().add("" + String.format("%,.2f", x.getDongia()) + " VND"));
                    itemTable.addCell(new Cell().add("" + String.format("%,.2f", x.getThanhtien()) + " VND"));
                    tong = tong + x.getThanhtien();
                }

            } else {
                itemTable.addCell(new Cell().add(""));
                itemTable.addCell(new Cell().add(""));
                itemTable.addCell(new Cell().add(""));
                itemTable.addCell(new Cell().add(""));
                itemTable.addCell(new Cell().add(""));
                itemTable.addCell(new Cell().add(""));
            }

            itemTable.addCell(new Cell().add("").setBackgroundColor(new DeviceRgb(63, 169, 219)).setBorder(Border.NO_BORDER));
            itemTable.addCell(new Cell().add("").setBackgroundColor(new DeviceRgb(63, 169, 219)).setBorder(Border.NO_BORDER));
            itemTable.addCell(new Cell().add("").setBackgroundColor(new DeviceRgb(63, 169, 219)).setBorder(Border.NO_BORDER));
            itemTable.addCell(new Cell().add("").setBackgroundColor(new DeviceRgb(63, 169, 219)).setBorder(Border.NO_BORDER));
            itemTable.addCell(new Cell().add("Tổng tiền").setBackgroundColor(new DeviceRgb(63, 169, 219)).setBorder(Border.NO_BORDER).setFontColor(com.itextpdf.kernel.color.Color.WHITE));
            itemTable.addCell(new Cell().add("" + String.format("%,.2f", tong) + " VND").setBackgroundColor(new DeviceRgb(63, 169, 219)).setBorder(Border.NO_BORDER).setFontColor(com.itextpdf.kernel.color.Color.WHITE));
            String ten = "";
            String phantram = "";
            double phaitra = 0;
            if (rp.xuathoadobbanhang(mhd).size() > 0) {
                if (rp.xuathoadobbanhang(mhd).get(0).getHoten().equals("khách bán lẻ")) {
                    ten = rp.xuathoadobbanhang(mhd).get(0).getHoten();
                    phantram = "0%";
                    phaitra = tong;
                } else {
                    ten = "Thành viên";
                    if (tong < 1000000) {
                        phaitra = tong / 100 * 100;
                        phantram = "0%";
                    } else if (10000000 > tong && tong >= 1000000) {
                        phaitra = tong / 100 * 99;
                        phantram = "1%";
                    } else if (tong < 100000000 && tong >= 10000000) {
                        phaitra = tong / 100 * 95;
                        phantram = "5%";
                    } else if (tong >= 100000000) {
                        phaitra = tong / 100 * 90;
                        phantram = "10%";
                    }
                }
            }

            itemTable.addCell(new Cell().add("").setBackgroundColor(new DeviceRgb(63, 169, 219)).setBorder(Border.NO_BORDER));
            itemTable.addCell(new Cell().add("").setBackgroundColor(new DeviceRgb(63, 169, 219)).setBorder(Border.NO_BORDER));
            itemTable.addCell(new Cell().add("").setBackgroundColor(new DeviceRgb(63, 169, 219)).setBorder(Border.NO_BORDER));
            itemTable.addCell(new Cell().add("").setBackgroundColor(new DeviceRgb(63, 169, 219)).setBorder(Border.NO_BORDER));
            itemTable.addCell(new Cell().add("" + ten).setBackgroundColor(new DeviceRgb(63, 169, 219)).setBorder(Border.NO_BORDER).setFontColor(com.itextpdf.kernel.color.Color.WHITE));
            itemTable.addCell(new Cell().add("Giảm :" + phantram).setBackgroundColor(new DeviceRgb(63, 169, 219)).setBorder(Border.NO_BORDER).setFontColor(com.itextpdf.kernel.color.Color.WHITE));

            itemTable.addCell(new Cell().add("").setBackgroundColor(new DeviceRgb(63, 169, 219)).setBorder(Border.NO_BORDER));
            itemTable.addCell(new Cell().add("").setBackgroundColor(new DeviceRgb(63, 169, 219)).setBorder(Border.NO_BORDER));
            itemTable.addCell(new Cell().add("").setBackgroundColor(new DeviceRgb(63, 169, 219)).setBorder(Border.NO_BORDER));
            itemTable.addCell(new Cell().add("").setBackgroundColor(new DeviceRgb(63, 169, 219)).setBorder(Border.NO_BORDER));
            itemTable.addCell(new Cell().add("Tiền phải trả :").setBackgroundColor(new DeviceRgb(63, 169, 219)).setBorder(Border.NO_BORDER).setFontColor(com.itextpdf.kernel.color.Color.WHITE));
            itemTable.addCell(new Cell().add("" + String.format("%,.2f", phaitra) + " VND").setBackgroundColor(new DeviceRgb(63, 169, 219)).setBorder(Border.NO_BORDER).setFontColor(com.itextpdf.kernel.color.Color.WHITE));

            document.add(table);
            document.add(new Paragraph("\n"));
            document.add(customerInforTable);
            document.add(new Paragraph("\n"));
            document.add(itemTable);
            document.close();
            System.out.println("Export successfully");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public String loadtrangthaibanhanghoadon(int a) {
        if (a == 0) {
            return "Chờ thanh toán";
        } else {
            return "Đã thanh toán";
        }

    }

    public void loadtablebanhanghoadon() {
        DefaultTableModel defaultTable = new DefaultTableModel();

        defaultTable = (DefaultTableModel) tbbanhhoadonbanhang.getModel();
        defaultTable.setRowCount(0);
        if (rp.gethdbanhang().size() < 0) {
            System.out.println(rp.gethdbanhang().size());
        } else {

            int stt = 0;
            for (hoadonbanhang sv : rp.gethdbanhang()) {
                defaultTable.addRow(new Object[]{
                    stt = stt + 1,
                    sv.getMaHD(), sv.getHoTennv(), sv.getHoTenkh(), loadtrangthaibanhanghoadon(sv.getTrangthai())
                });
            }

        }

    }

    public void loadtablebanhangsanpham() {
        DefaultTableModel defaultTable = new DefaultTableModel();
        defaultTable.setRowCount(0);
        defaultTable = (DefaultTableModel) tbbangsanphambanhang.getModel();
        defaultTable.setRowCount(0);
        if (rp.gethdbanhang().size() < 0) {
            System.out.println(rp.getsanphambanhang().size());
        } else {

            int stt = 0;
            for (sanphambanhang sv : rp.getsanphambanhang()) {
                double gia = (double) (sv.getDongia());
                defaultTable.addRow(new Object[]{
                    stt = stt + 1,
                    sv.getMasp(), sv.getTensp() + "," + sv.getPin() + "," + sv.getChip() + "," + sv.getRom() + "," + sv.getHangdienthoai() + "," + sv.getRam(),
                    sv.getSoluong(),
                    String.format("%,.2f", gia) + " VND"

                });
            }

        }

    }

    public void clicksanphamragiohang() {
        DefaultTableModel defaultTable = new DefaultTableModel();

        defaultTable = (DefaultTableModel) tbgiohangbanhang.getModel();
        defaultTable.setRowCount(0);
        if (rp.clhoadonrabanggiohang(tbbanhhoadonbanhang.getValueAt(tbbanhhoadonbanhang.getSelectedRow(), 1).toString()).size() <= 0) {
            System.out.println(rp.getsanphambanhang().size());
            tftongtienhang.setText("0");
            tongtienhangbanhang = 0;
            tfkhuyenmai.setText("0");
            tfphaitra.setText("0");
            tongtienhangsaukhuyenmai = 0;

        } else {

            int stt = 0;
            double tong = 0;
            for (sanphambanhang sv : rp.clhoadonrabanggiohang(tbbanhhoadonbanhang.getValueAt(tbbanhhoadonbanhang.getSelectedRow(), 1).toString())) {
                double gia = (double) (sv.getDongia());
                double sl = (double) (sv.getSoluong());
                tong = gia * sl + tong;

                tftongtienhang.setText(String.format("%,.2f", tong) + " VND");
                defaultTable.addRow(new Object[]{
                    stt = stt + 1,
                    sv.getMasp(), sv.getTensp() + "," + sv.getPin() + "," + sv.getChip() + "," + sv.getRom() + "," + sv.getHangdienthoai() + "," + sv.getRam(),
                    sv.getSoluong(),
                    String.format("%,.2f", gia) + " VND",
                    String.format("%,.2f", gia * sl) + " VND"

                });
            }
            tongtienhangbanhang = tong;
            double phaitra = 0;
            if (tbbanhhoadonbanhang.getValueAt(tbbanhhoadonbanhang.getSelectedRow(), 3).toString().equals("khách bán lẻ")) {
                tfkhuyenmai.setText("0");
                tfphaitra.setText(String.format("%,.2f", tong) + " VND");
                tongtienhangsaukhuyenmai = tong;
            } else {
                if (10000000 > tong && tong >= 1000000) {
                    tfkhuyenmai.setText("1");

                    phaitra = tong / 100 * 99;
                    tongtienhangsaukhuyenmai = phaitra;
                    tfphaitra.setText(String.format("%,.2f", phaitra) + " VND");
                } else if (tong < 100000000 && tong >= 10000000) {
                    tfkhuyenmai.setText("5");

                    phaitra = tong / 100 * 95;
                    tongtienhangsaukhuyenmai = phaitra;
                    tfphaitra.setText(String.format("%,.2f", phaitra) + " VND");
                } else if (tong >= 100000000) {
                    tfkhuyenmai.setText("10");

                    phaitra = tong / 100 * 90;
                    tongtienhangsaukhuyenmai = phaitra;
                    tfphaitra.setText(String.format("%,.2f", phaitra) + " VND");
                }
            }

        }
        //kh
        String mahdc = tbbanhhoadonbanhang.getValueAt(tbbanhhoadonbanhang.getSelectedRow(), 1).toString();
        int vtid = 0;
        for (int i = 0; i < rp.gethdbanhang().size(); i++) {
            if (mahdc.equals(rp.gethdbanhang().get(i).getMaHD())) {
                vtid = i;
            }
        }
        int idkh = rp.gethdbanhang().get(vtid).getIdkh();
        for (int i = 0; i < rp.getkhachhangbanhang().size(); i++) {
            if (rp.getkhachhangbanhang().get(i).getId() == idkh) {
                cbbanhangkhachhang.setSelectedIndex(i);
                tenkhachhangbanhang = rp.getkhachhangbanhang().get(i).getTenkh();
            }
        }
        //phaitra

        //ngay
        if (rp.gethdbanhang().get(vtid).getTrangthai() == 0) {
            tfngaytaovaban.setText(rp.gethdbanhang().get(vtid).getNgaytaovaban());
            lbngaytaovaban.setText("Ngày tạo");
        } else {
            tfngaytaovaban.setText(rp.gethdbanhang().get(vtid).getNgaytaovaban());
            lbngaytaovaban.setText("Ngày thanh toán");
        }

        //km 
    }

    public void clicksanphamragiohang____kethop(int tb) {
        DefaultTableModel defaultTable = new DefaultTableModel();

        defaultTable = (DefaultTableModel) tbgiohangbanhang.getModel();
        defaultTable.setRowCount(0);
        if (rp.clhoadonrabanggiohang(tbbanhhoadonbanhang.getValueAt(tb, 1).toString()).size() <= 0) {
            System.out.println(rp.getsanphambanhang().size());
            tftongtienhang.setText("0");
            tongtienhangbanhang = 0;
            tfkhuyenmai.setText("0");
            tfphaitra.setText("0");
            tongtienhangsaukhuyenmai = 0;

        } else {

            int stt = 0;
            double tong = 0;
            for (sanphambanhang sv : rp.clhoadonrabanggiohang(tbbanhhoadonbanhang.getValueAt(tb, 1).toString())) {
                double gia = (double) (sv.getDongia());
                double sl = (double) (sv.getSoluong());
                tong = gia * sl + tong;

                tftongtienhang.setText(String.format("%,.2f", tong) + " VND");
                defaultTable.addRow(new Object[]{
                    stt = stt + 1,
                    sv.getMasp(), sv.getTensp() + "," + sv.getPin() + "," + sv.getChip() + "," + sv.getRom() + "," + sv.getHangdienthoai() + "," + sv.getRam(),
                    sv.getSoluong(),
                    String.format("%,.2f", gia) + " VND",
                    String.format("%,.2f", gia * sl) + " VND"

                });
            }
            tongtienhangbanhang = tong;
            double phaitra = 0;
            if (tbbanhhoadonbanhang.getValueAt(tb, 3).toString().equals("khách bán lẻ")) {
                tfkhuyenmai.setText("0");
                tfphaitra.setText(String.format("%,.2f", tong) + " VND");
                tongtienhangsaukhuyenmai = tong;
            } else {
                if (10000000 > tong && tong >= 1000000) {
                    tfkhuyenmai.setText("1");

                    phaitra = tong / 100 * 99;
                    tongtienhangsaukhuyenmai = phaitra;
                    tfphaitra.setText(String.format("%,.2f", phaitra) + " VND");
                } else if (tong < 100000000 && tong >= 10000000) {
                    tfkhuyenmai.setText("5");

                    phaitra = tong / 100 * 95;
                    tongtienhangsaukhuyenmai = phaitra;
                    tfphaitra.setText(String.format("%,.2f", phaitra) + " VND");
                } else if (tong >= 100000000) {
                    tfkhuyenmai.setText("10");

                    phaitra = tong / 100 * 90;
                    tongtienhangsaukhuyenmai = phaitra;
                    tfphaitra.setText(String.format("%,.2f", phaitra) + " VND");
                }
            }

        }
        //kh
        String mahdc = tbbanhhoadonbanhang.getValueAt(tb, 1).toString();
        int vtid = 0;
        for (int i = 0; i < rp.gethdbanhang().size(); i++) {
            if (mahdc.equals(rp.gethdbanhang().get(i).getMaHD())) {
                vtid = i;
            }
        }
        int idkh = rp.gethdbanhang().get(vtid).getIdkh();
        for (int i = 0; i < rp.getkhachhangbanhang().size(); i++) {
            if (rp.getkhachhangbanhang().get(i).getId() == idkh) {
                cbbanhangkhachhang.setSelectedIndex(i);
                tenkhachhangbanhang = rp.getkhachhangbanhang().get(i).getTenkh();
            }
        }
        //phaitra

        //ngay
        if (rp.gethdbanhang().get(vtid).getTrangthai() == 0) {
            tfngaytaovaban.setText(rp.gethdbanhang().get(vtid).getNgaytaovaban());
            lbngaytaovaban.setText("Ngày tạo");
        } else {
            tfngaytaovaban.setText(rp.gethdbanhang().get(vtid).getNgaytaovaban());
            lbngaytaovaban.setText("Ngày thanh toán");
        }

        //km 
    }

    public boolean kttiennhap() {
        try {
            if (tftienkhachdua.getText().isBlank()) {
                return false;
            } else {
                if (tftienkhachdua.getText().isEmpty()) {
                    return false;
                } else {
                    float tien = Float.parseFloat(tftienkhachdua.getText());
                    return true;
                }
            }

        } catch (Exception e) {
            return false;
        }
    }

    //banhang thang
//Khai Start///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void showDataKM(List<KhuyenMaiResponse> lst) {
        dfm2.setRowCount(0);
        for (KhuyenMaiResponse khuyenMaiResponse : lst) {
            dfm2.addRow(khuyenMaiResponse.toDataRow1());
        }
        tbl_KhuyenMaiNgungHoatDong.getTableHeader().setFont(new Font("Segoe", Font.BOLD, 12));
        tbl_KhuyenMaiNgungHoatDong.setRowHeight(20);
        tbl_KhuyenMai.getTableHeader().setFont(new Font("Segoe", Font.BOLD, 12));
        tbl_KhuyenMai.setRowHeight(20);
        tbl_SanPhamGiamGia.getTableHeader().setFont(new Font("Segoe", Font.BOLD, 12));
        tbl_SanPhamGiamGia.setRowHeight(20);
    }

    public void showDataKM2(List<KhuyenMaiResponse> lst) {
        dfm.setRowCount(0);
        for (KhuyenMaiResponse khuyenMaiResponse : lst) {
            dfm.addRow(khuyenMaiResponse.toDataRow2());
        }
    }

    private void showDataKM3(List<SanPhamResponse> listSanPham) {
        dfm3.setRowCount(0);
        for (SanPhamResponse sanPhamResponse : listSanPham) {

            dfm3.addRow(sanPhamResponse.toDataRow2());
        }
    }

    private void showDataKM4() {
        SanPhamGiamGiaRepository giaRepository = new SanPhamGiamGiaRepository();
        int index = tbl_KhuyenMai.getSelectedRow();
        List<SanPhamGiamGia> giamTheoSPs = giaRepository.getAllSP((int) dfm2.getValueAt(index, 0));
        for (int i = 0; i < listSanPham.size(); i++) {
            for (SanPhamGiamGia giamTheoSP : giamTheoSPs) {
                if (dfm3.getValueAt(i, 0).equals(giamTheoSP.getSanPham().getTenSP())) {
                    dfm3.setValueAt(true, i, 1);
                }
            }
        }

        KhuyenMaiResponse khuyenMaiResponse = khuyenMaiService.getOne((int) dfm2.getValueAt(index, 0));
        txt_TenKM.setText(khuyenMaiResponse.getTenKM());
        txt_MaGiamGia.setText(khuyenMaiResponse.getMaKM());
        txt_MucGiam.setText(Float.toString(khuyenMaiResponse.getSoTienGiam()));
        dtc_TuNgay.setDate(khuyenMaiResponse.getNgayBatDau());
        dtc_DenNgay.setDate(khuyenMaiResponse.getNgayKetThuc());
    }

    private KhuyenMai getDataKM() {
        KhuyenMai khuyenMai = new KhuyenMai();
        khuyenMai.setMaKM(txt_MaGiamGia.getText());
        khuyenMai.setTenKM(txt_TenKM.getText());
        khuyenMai.setCreatedAt(java.util.Calendar.getInstance().getTime());
        khuyenMai.setUpdatedAt(null);
        khuyenMai.setNgayBatDau(dtc_TuNgay.getDate());

        khuyenMai.setNgayKetThuc(dtc_DenNgay.getDate());
        khuyenMai.setSoTienGiam(Float.parseFloat(txt_MucGiam.getText()));
        if (dtc_DenNgay.getDate().after(java.util.Calendar.getInstance().getTime()) || dtc_DenNgay.getDate().equals(java.util.Calendar.getInstance().getTime())) {
            khuyenMai.setDeleted(false);
        } else if (dtc_DenNgay.getDate().before(java.util.Calendar.getInstance().getTime())) {
            khuyenMai.setDeleted(true);
        }
        khuyenMai.setLoaiGiamGia(Boolean.TRUE);
        khuyenMai.setHinhThucGiamGia(Boolean.TRUE);
        return khuyenMai;
    }

    public void showDataKM5() {
        int index2 = tbl_KhuyenMaiNgungHoatDong.getSelectedRow();
        SanPhamGiamGiaRepository giaRepository = new SanPhamGiamGiaRepository();
        List<SanPhamGiamGia> giamTheoSPss = giaRepository.getAllSP((int) dfm.getValueAt(index2, 0));
        for (int i = 0; i < listSanPham.size(); i++) {
            for (SanPhamGiamGia giamTheoSP : giamTheoSPss) {
                if (dfm3.getValueAt(i, 0).equals(giamTheoSP.getSanPham().getTenSP())) {
                    dfm3.setValueAt(true, i, 1);
                }
            }
        }
        KhuyenMaiResponse khuyenMaiResponse = khuyenMaiService.getOne((int) dfm.getValueAt(index2, 0));
        txt_TenKM.setText(khuyenMaiResponse.getTenKM());
        txt_MaGiamGia.setText(khuyenMaiResponse.getMaKM());
        txt_MucGiam.setText(Float.toString(khuyenMaiResponse.getSoTienGiam()));
        dtc_TuNgay.setDate(khuyenMaiResponse.getNgayBatDau());
        dtc_DenNgay.setDate(khuyenMaiResponse.getNgayKetThuc());
    }

    public void showDataKM6() {
        KhuyenMaiRepository khuyenMaiRepository = new KhuyenMaiRepository();
        List<KhuyenMai> khuyenMais = khuyenMaiRepository.getAll();
        for (KhuyenMai khuyenMai : khuyenMais) {
            if (java.util.Calendar.getInstance().getTime().after(khuyenMai.getNgayKetThuc()) == true) {
                khuyenMai.setDeleted(true);
                khuyenMaiRepository.update(khuyenMai);
            }
        }
    }
//Khai end/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // Tung Start///////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void designTableSanPham() {
        JTableHeader header = tblSanPham2.getTableHeader();
        header.setBackground(bgColo);
        header.setForeground(bgColo);
        header.setFont(new Font("Tahoma", Font.BOLD, 14));
    }

    public void loadProductForm() {
        imeis = new ArrayList<>();
        Util.createFolderImageUpload();
        listSanPhamDeleted = new ArrayList<>();
        listSp = sanPhamService.getAllSanPham();
        listSanPham = sanPhamService.getAll();
        loadProductTable();
        getAllChip();
        getAllRam();
        getAllRom();
        getAllPin();
        getAllHang();
        getAllMauSac();
        listSanPhamDeleted = sanPhamService.getDeletedSanPham();
        getAllSanPhamLuuTru(listSanPhamDeleted);
//        getAllImei();
    }

    public void loadProductTable() {
        DefaultTableModel dtm = (DefaultTableModel) tblSanPham2.getModel();
        dtm.setRowCount(0);
        for (SanPhamResponse sp : listSanPham) {
            Object[] row = sp.toDataRow();
            dtm.addRow(row);
        }
    }

    public boolean checkValidateSanPham() {
        String tenSP = txtTenSanPham.getText();
        String donGiaStr = txtDonGia.getText();
        String soLuong = txtSoLuong.getText();
        String moTa = txaMoTa.getText();
        String chipcbb = cbbChip.getSelectedItem().toString();
        String ramcbb = cbbRam.getSelectedItem().toString();
        String romcbb = cbbRom.getSelectedItem().toString();
        String pincbb = cbbPin.getSelectedItem().toString();
        String hdtcbb = cbbHang.getSelectedItem().toString();
        String mscbb = cbbMauSac.getSelectedItem().toString();
        if (tenSP.trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "Không được để trống tên sản phẩm");
            txtTenSanPham.requestFocus();
            return false;
        }
        if (donGiaStr.trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "Không được để trống đơn giá");
            txtDonGia.requestFocus();
            return false;
        }
        double donGia = 0;
        try {
            donGia = Double.parseDouble(donGiaStr);
            if (donGia <= 0) {
                JOptionPane.showMessageDialog(this, "Đơn giá phải lớn hơn 0");
                txtDonGia.requestFocus();
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Đơn giá phải là số");
            txtDonGia.requestFocus();
            return false;
        }
        if (moTa.trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "Mô tả không được để trống");
            txaMoTa.requestFocus();
            return false;
        }
        
        if (lblAnhSanPham == null) {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn ảnh cho sản phẩm");
            return false;
        }
        return true;
    }

    public void getAllChip() {
        listChip = chipService.getAllChip();
        for (Chip chip : listChip) {
            cbbChip.addItem(chip.getTenChip());
        }
    }

    public void getAllRam() {
        listRam = ramService.getAllRam();
        for (Ram item : listRam) {
            cbbRam.addItem(item.getDungLuong());
        }
    }

    public void getAllRom() {
        listRom = romService.getAllRom();
        for (Rom item : listRom) {
            cbbRom.addItem(item.getTenRom());
        }
    }

    public void getAllPin() {
        listPin = pinService.getAllPin();
        for (Pin item : listPin) {
            cbbPin.addItem(item.getTenPin());
        }
    }

    public void getAllHang() {
        listHangDT = hangDienThoaiService.getAllHangDT();
        for (HangDienThoai item : listHangDT) {
            cbbHang.addItem(item.getTenHang());
        }
    }

    public void getAllMauSac() {
        listMauSac = mauSacService.getAllMauSac();
        for (MauSac item : listMauSac) {
            cbbMauSac.addItem(item.getTenMauSac());
        }
    }

    public void getAllImei(List<ImeiResponse> listImei) {
        //cbbDSImei.removeAllItems();
        DefaultTableModel dtm = (DefaultTableModel) tblDSImei.getModel();
        dtm.setRowCount(0);
        for (ImeiResponse item : listImei) {
            //cbbDSImei.addItem(item.getImei());
            Object[] row = {
                item.getImei(),
            };
            dtm.addRow(row);
        }
    }

    public void loadImageToLabel(String path, boolean hasRoot) {
        BufferedImage img = null;
        String userDirectory = new File("").getAbsolutePath() + Util.SLASH + "pictures";

        try {
            if (hasRoot) {
                img = ImageIO.read(new File(userDirectory + Util.SLASH + path));
            } else {
                img = ImageIO.read(new File(path));
            }

        } catch (IOException e) {
//            e.printStackTrace();
            lblAnhSanPham.setIcon(null);
            return;
        }
        Image dimg = img.getScaledInstance(lblAnhSanPham.getWidth(), lblAnhSanPham.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(dimg);
        lblAnhSanPham.setIcon(icon);
    }

    public void addImei(List<Imei> list, SanPham sp) {
        for (Imei imei : list) {
            imei.setSanPham(sp);
            imei.setCommonData();
            imeiService.add(imei);
        }
    }

    public void getImeiByProduct(int id) {
        imeis = imeiService.getAllImeiBySanPham(id);
        listImei = new ArrayList<>();
        DefaultTableModel dtm = (DefaultTableModel) tblDSImei.getModel();
        dtm.setRowCount(0);
        //cbbDSImei.removeAllItems();
        for (Imei imei : imeis) {
//            listImei.add(new ImeiResponse(imei));
//            cbbDSImei.addItem(imei.getImei());
                Object[] row = {
                    imei.getImei(),
                };
                dtm.addRow(row);
        }

    }

    private void showData(List<SanPhamResponse> listSanPham) {
        dtmSP.setRowCount(0);
        for (SanPhamResponse sanPhamResponse : listSanPham) {
            dtmSP.addRow(sanPhamResponse.toDataRow());
        }
    }

    private void showData2(List<SanPhamResponse> listSanPham, String maKM) {
        dtmSP.setRowCount(0);
        listSanPham = sanPhamService.getAll();
        for (SanPhamResponse sanPhamResponse : listSanPham) {
            dtmSP.addRow(sanPhamResponse.toDataRow3(maKM));
        }
    }

    public void getAllSanPham() {
        listSanPham = sanPhamService.getAll();
        listSp = sanPhamService.getAllSanPham();
    }

    public void loadTableSanPham() {
        getAllSanPham();
        DefaultTableModel dtm = (DefaultTableModel) tblSanPham2.getModel();
        dtm.setRowCount(0);
        for (SanPhamResponse item : listSanPham) {
            Object[] row = {
                //                item.getMaSP(),
                item.getTenSP(),
                item.getTenHang(),
                item.getTenChip(),
                item.getDungLuong(),
                item.getTenRom(),
                item.getTenPin(),
                item.getTenMauSac(),
                item.getSoLuong(),
                item.getMoTa(),
                item.getDonGia(),};
            dtm.addRow(row);
        }
    }

    public class DialogResponse {

        public void getListImeiResponse(List<Imei> _imeis) {
            imeis = _imeis;
            listImei = new ArrayList<>();
            for (Imei imei : _imeis) {
                ImeiResponse i = new ImeiResponse(imei);
                listImei.add(i);
            }
            txtSoLuong.setText(String.valueOf(listImei.size()));
            getAllImei(listImei);
        }

    }

    public void setButtonStatus(boolean isUpdate) {
        if (isUpdate) {
            btnThemSanPham.setEnabled(false);
            btnSuaSanPham.setEnabled(true);
            btnXoaSanPham.setEnabled(true);
        } else {
            btnThemSanPham.setEnabled(true);
            btnSuaSanPham.setEnabled(false);
            btnXoaSanPham.setEnabled(false);
            tblSanPham2.clearSelection();
            getImeiByProduct(-1);
            lblAnhSanPham.setIcon(null);
            urlAnh = null;
            urlUploadAnh = null;

        }

    }

    public SanPham buildRequestProduct() {
        String tenSP = txtTenSanPham.getText();
        String donGia = txtDonGia.getText().replace(",", "").replace("VND", "").trim();
        String soLuong = txtSoLuong.getText();
        String moTa = txaMoTa.getText();
        String chipcbb = cbbChip.getSelectedItem().toString();
        String ramcbb = cbbRam.getSelectedItem().toString();
        String romcbb = cbbRom.getSelectedItem().toString();
        String pincbb = cbbPin.getSelectedItem().toString();
        String hdtcbb = cbbHang.getSelectedItem().toString();
        String mscbb = cbbMauSac.getSelectedItem().toString();

        Ram ram = listRam.get(cbbRam.getSelectedIndex());
        Rom rom = listRom.get(cbbRom.getSelectedIndex());
        MauSac ms = listMauSac.get(cbbMauSac.getSelectedIndex());
        Pin pin = listPin.get(cbbPin.getSelectedIndex());
        HangDienThoai hdt = listHangDT.get(cbbHang.getSelectedIndex());
        Chip chip = listChip.get(cbbChip.getSelectedIndex());

        SanPham sp = new SanPham();
        sp.setTenSP(tenSP);
        sp.setDonGia(Float.parseFloat(donGia));
        sp.setSoLuong(Integer.parseInt(soLuong));
        sp.setMoTa(moTa);
        sp.setRam(ram);
        sp.setRom(rom);
        sp.setChip(chip);
        sp.setHangdt(hdt);
        sp.setPin(pin);
        sp.setMauSac(ms);
        sp.setUrlAnh(urlAnh);
        sp.setCommonData();
        return sp;
    }

    public void getAllSanPhamLuuTru(List<SanPham> listSpDeleted) {
        DefaultTableModel dtm = (DefaultTableModel) tblSanPhamLuuTru.getModel();
        dtm.setRowCount(0);
        for (SanPham sp : listSpDeleted) {
            Object[] row = {
                sp.getTenSP(),
                String.format("%,.0f", sp.getDonGia()) + " VND",
                sp.getMoTa(),
                sp.getUrlAnh(),
                sp.getMauSac().getTenMauSac(),
                sp.getHangdt().getTenHang(),
                sp.getChip().getTenChip(),
                sp.getRam().getDungLuong(),
                sp.getRom().getTenRom(),
                sp.getPin().getTenPin(),
                sp.getSoLuong(),
                Util.getCurrentDate(),};
            dtm.addRow(row);
        }
    }

    public void calculatePagination() {
        totalRow = sanPhamService.countRecord();
        totalPage = (int) (totalRow / itemPerPage) + (totalRow % 2 > 0 ? 1 : 0);
        start = page * itemPerPage;
    }

    // Tung End////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    public void initService() {
        chipService = new ChipServiceImpl();
        pinService = new PinServiceImpl();
        ramService = new RamServiceImpl();
        romService = new RomServiceImpl();
        hangDienThoaiService = new HangDienThoaiServiceImpl();
        sanPhamService = new SanPhamServiceImpl();
        mauSacService = new MauSacServiceImpl();
        imeiService = new ImeiServiceImpl();
    }

//
    private void showDataGH(List<SanPhamResponse> listGioHang) {
        dtmGH.setRowCount(0);
        for (SanPhamResponse sanPhamResponse : listGioHang) {
            dtmGH.addRow(sanPhamResponse.toDataRow());
        }
    }

    //@QuanPM_PH27325 START
    //===============================Code hoá đơn===========================================
    private void setuptblHD() {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        List<HoaDonResponse> lsthd = hoaDonService.getAll();
//        List<HoaDonResponse> lsthd1 = new ArrayList<>();
        dtmHoaDon.setRowCount(0);
        for (HoaDonResponse x : lsthd) {
            String StrTT = "Chưa thanh toán";

            if (x.isDeleted()) {
                StrTT = "Đã huỷ";
            } else if (x.isTrangThai()) {
                StrTT = "Đã thanh toán";
            }
//            if (x.isDeleted()) {
//                StrTT="Đã hủy";
//            } else {
//                  if (x.isTrangThai()) {
//                StrTT = "Đã thanh toán";
//            }else{
//                  StrTT = "Chưa thanh toán";
//                  
//                  }     
//            }
            if (txtMa.getText().equals("MNV001")) {
                dtmHoaDon.addRow(new Object[]{x.getMaHD(), x.getMaNV(), x.getMaKH(), x.getTenKH(), x.getSdt(), StrTT, String.format("%,.0f", x.getTongTien()) + " VND", format.format(x.getCreatedAt())});
            } else if (txtMa.getText().equals(x.getMaNV())) {
                dtmHoaDon.addRow(new Object[]{x.getMaHD(), x.getMaNV(), x.getMaKH(), x.getTenKH(), x.getSdt(), StrTT, String.format("%,.0f", x.getTongTien()) + " VND", format.format(x.getCreatedAt())});
            }
        }
    }

    private void sortDesc() {
        TableRowSorter<TableModel> sort = new TableRowSorter<>(tblHoaDon.getModel());
        tblHoaDon.setRowSorter(sort);
        List<RowSorter.SortKey> ColSortingKeys = new ArrayList<>();
        ColSortingKeys.add(new RowSorter.SortKey(6, SortOrder.DESCENDING));

        sort.setSortKeys(ColSortingKeys);
        sort.sort();
    }

    private void sortAsc() {
        TableRowSorter<TableModel> sort = new TableRowSorter<>(tblHoaDon.getModel());
        tblHoaDon.setRowSorter(sort);
        List<RowSorter.SortKey> ColSortingKeys = new ArrayList<>();
        ColSortingKeys.add(new RowSorter.SortKey(6, SortOrder.ASCENDING));

        sort.setSortKeys(ColSortingKeys);
        sort.sort();
    }

    private void sortHD() {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        List<HoaDonResponse> lstHD = hoaDonService.getAll();
        dtmHoaDon.setRowCount(0);
        Date From = jdateFrom.getDate();
        Date To = jdateTo.getDate();
        for (HoaDonResponse x : lstHD) {
            if (x.getCreatedAt().after(From) && x.getCreatedAt().before(To)) {
//                System.out.println("cac");
                String StrTT = "Chưa thanh toán";
                if (x.isTrangThai()) {
                    StrTT = "Đã thanh toán";
                }
                dtmHoaDon.addRow(new Object[]{x.getMaHD(), x.getMaNV(), x.getMaKH(), x.getTenKH(), x.getSdt(), StrTT, String.format("%,.0f", x.getTongTien()) + " VND", format.format(x.getCreatedAt())});

            }
        }
    }

    private void showhdct() {
        int index = tblHoaDon.getSelectedRow();
        dtmHDImei.setRowCount(0);
        dtmHDSP.setRowCount(0);
        MaHoaDon = tblHoaDon.getValueAt(index, 0).toString();
        HoaDon hd = hoaDonService.getOne(MaHoaDon);
        List<HoaDonChiTiet> lsthdct = HoaDonChiTietService.getAll();
        for (HoaDonChiTiet x : lsthdct) {
            if (x.getHoaDon().getId() == hd.getId()) {
                dtmHDSP.addRow(new Object[]{x.getTenSP(), String.format("%,.0f", x.getDonGia()) + " VND", x.getSoLuong(), String.format("%,.0f", x.getDonGia() * x.getSoLuong()) + " VND"});
            }
        }
    }

    private void showimei() {
        dtmHDImei.setRowCount(0);
        int index = tblSP.getSelectedRow();
        String TenSP = tblSP.getValueAt(index, 0).toString();
        List<ImeiDaBan> lstImei = imeiDaBanService.getAll1();
        HoaDon hd = hoaDonService.getOne(MaHoaDon);
        List<HoaDonChiTiet> lsthdct = HoaDonChiTietService.getAll();
        List<HoaDonChiTiet> lsthd = new ArrayList<>();
        for (HoaDonChiTiet x : lsthdct) {
            if (x.getHoaDon().getId() == hd.getId()) {
                lsthd.add(x);
            }
        }
        for (ImeiDaBan x : lstImei) {
            for (HoaDonChiTiet y : lsthd) {
                if (x.getHoaDonChiTiet().getId() == y.getId()) {
                    if (x.getHoaDonChiTiet().getTenSP().equals(TenSP)) {
                        dtmHDImei.addRow(new Object[]{x.getImei()});
                    }
                }
            }
        }
    }

    private void exportexcel() {
        //Chọn nơi lưu file
        JFileChooser excelFileChooser = new JFileChooser("C:\\Users\\Admin\\Desktop");
        excelFileChooser.setDialogTitle("Save as");
        FileNameExtensionFilter filefilter = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlsm");
        excelFileChooser.setFileFilter(filefilter);
        int check = excelFileChooser.showSaveDialog(null);

        //Check khi ấn nút save
        if (check == JFileChooser.APPROVE_OPTION) {
            FileOutputStream FOS = null;
            BufferedOutputStream BOS = null;
            XSSFWorkbook excelJtableExporter = null;
            try {
                excelJtableExporter = new XSSFWorkbook();
                XSSFSheet excelSheet = excelJtableExporter.createSheet("HoaDon");
                //Lấy số dòng, cột tblHoaDon
                for (int i = 0; i < dtmHoaDon.getRowCount(); i++) {
                    XSSFRow excelRow = excelSheet.createRow(i);
                    for (int j = 0; j < dtmHoaDon.getColumnCount(); j++) {
                        XSSFCell excelCell = excelRow.createCell(j);

                        excelCell.setCellValue(dtmHoaDon.getValueAt(i, j).toString());
                    }
                }

                FOS = new FileOutputStream(excelFileChooser.getSelectedFile() + ".xlsx");
                BOS = new BufferedOutputStream(FOS);
                excelJtableExporter.write(BOS);
                JOptionPane.showMessageDialog(this, "Xuất Thành Công!!!!");
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    if (BOS != null) {
                        BOS.close();
                    }

                    if (FOS != null) {
                        FOS.close();
                    }

                    if (excelJtableExporter != null) {
                        excelJtableExporter.close();
                    }

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

        }
    }

    //KhachHang
    private void setuptblKH() {
        dtmKH.setRowCount(0);
        List<KhachHangResponse> lst = khachHangService.getAll();
        List<HoaDonResponse> lsthd = hoaDonService.getAll();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        String gioitinh = "";
        for (KhachHangResponse x : lst) {
            if (x.isGioiTinh()) {
                gioitinh = "Nam";
            } else {
                gioitinh = "Nữ";
            }
            int i = 0;
            for (HoaDonResponse y : lsthd) {
                if (y.getMaKH().equals(x.getMaKH())) {
                    i++;
                }
            }
            if (!(x.isDeleted())) {
                dtmKH.addRow(new Object[]{x.getMaKH(), x.getHoTen(), x.getSdt(), x.getEmail(), gioitinh, format.format(x.getNgaySinh()), x.getDiaChi(), format.format(x.getCreatedAt()), i});
            } else {
                dtmKHDeleted.addRow(new Object[]{x.getMaKH(), x.getHoTen(), x.getSdt(), x.getEmail(), gioitinh, format.format(x.getNgaySinh()), x.getDiaChi(), format.format(x.getCreatedAt())});
            }
        }
    }

    private KhachHang validateKH() {

        String Ma = txtMaKH1.getText();
        String Ten = txtTenKH1.getText();
        if (Ma.isBlank()) {
            JOptionPane.showMessageDialog(this, "Không bỏ trống các trường.");
            return null;
        }

        if (Ten.isBlank()) {
            JOptionPane.showMessageDialog(this, "Không bỏ trống các trường.");
            return null;
        }

        String sdt = txtSDT2.getText();
        if (sdt.isBlank()) {
            JOptionPane.showMessageDialog(this, "Không bỏ trống các trường.");
            return null;
        }

        boolean GioiTinh = false;
        if (rdonam1.isSelected()) {
            GioiTinh = true;
        }

        String regexPattern = "^[A-Za-z0-9+_.-]+@(.+)$";

        String email = txtEmail1.getText();
        if (email.isBlank()) {
            JOptionPane.showMessageDialog(this, "Không bỏ trống các trường.");
            return null;
        } else if (!(email.matches(regexPattern))) {
            JOptionPane.showMessageDialog(this, "Sai định dạng email.");
            return null;
        }

        Date NgaySinh = jdateNgaySinhKH.getDate();

        String DiaChi = txtDiachi1.getText();
        if (DiaChi.isBlank()) {
            JOptionPane.showMessageDialog(this, "Không bỏ trống các trường.");
            return null;
        }
        KhachHang kh = new KhachHang();
        kh.setMaKH(Ma);
        kh.setHoTen(Ten);
        kh.setSdt(sdt);
        kh.setGioiTinh(GioiTinh);
        kh.setEmail(email);
        kh.setNgaySinh(NgaySinh);
        kh.setDiaChi(DiaChi);
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        try {
            kh.setCreatedAt(f.parse(f.format(date)));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return kh;
    }

    private void detailKH() {
        int index = tblThongtinKH1.getSelectedRow();
        txtMaKH1.setText(dtmKH.getValueAt(index, 0).toString());
        txtTenKH1.setText(dtmKH.getValueAt(index, 1).toString());
        txtSDT2.setText(dtmKH.getValueAt(index, 2).toString());
        txtEmail1.setText(dtmKH.getValueAt(index, 3).toString());
        if (dtmKH.getValueAt(index, 4).toString().equals("Nam")) {
            rdonam1.setSelected(true);
        } else {
            rdoNu1.setSelected(true);
        }
        SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
        try {
            jdateNgaySinhKH.setDate(f.parse(dtmKH.getValueAt(index, 5).toString()));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        txtDiachi1.setText(dtmKH.getValueAt(index, 6).toString());
    }

    private void addKH(KhachHang kh) {
        if (kh != null) {
            String mess = khachHangService.add(kh);
            setuptblKH();
            JOptionPane.showMessageDialog(this, mess);
        }
    }

    private void updateKH(KhachHang kh) {
        if (kh != null) {
            String mess = khachHangService.update(kh);
            JOptionPane.showMessageDialog(this, mess);
        }
    }

    private void deleteKH(KhachHang kh) {
        if (kh != null) {
            String mess = khachHangService.delete(kh);
            JOptionPane.showMessageDialog(this, mess);
        }
    }

    private void clearKH() {
        txtMaKH1.setText("");
        txtTenKH1.setText("");
        txtSDT2.setText("");
        txtEmail1.setText("");
        jdateNgaySinhKH.setDate(null);
        txtDiachi1.setText("");
        rdonam1.setSelected(true);
    }

    private void lichsuKH() {
        dtmLichSu.setRowCount(0);
        List<HoaDon> lsthd = hoaDonService.getAll2();
        SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
        String MaKH = txtLichSu.getText();
        for (HoaDon x : lsthd) {
            if (x.getKhachHang().getMaKH().equals(MaKH)) {
                dtmLichSu.addRow(new Object[]{x.getKhachHang().getMaKH(), x.getKhachHang().getHoTen(), x.getMaHD(), String.format("%,.0f", x.getTongTien()) + " VND", f.format(x.getCreatedAt())});
            }
        }
    }

    private void restoreKH() {
        int index = -1;
        index = tblThongtinKHDeleted.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn KH muốn khôi phục.");
        } else {
            String MaKH = dtmKHDeleted.getValueAt(index, 0).toString();
            KhachHang kh = khachHangService.getOne(MaKH);
            kh.setDeleted(false);
            khachHangService.update(kh);
            JOptionPane.showMessageDialog(this, "Khôi phục thành công");
            setuptblKH();
            dtmKHDeleted.removeRow(index);
        }
    }

    private void findHD() {
        String maHD = txtTimKiemHD.getText();
        int i = tblHoaDon.getRowCount();
        for (int j = 0; j < i; j++) {
            if (maHD.equals(dtmHoaDon.getValueAt(j, 0).toString())) {
                tblHoaDon.setRowSelectionInterval(j, j);
                break;
            }
        }
    }

    private void findKH() {
        String maKH = txtFindKH.getText();
        int i = tblThongtinKH1.getRowCount();
        for (int j = 0; j < i; j++) {
            if (maKH.equals(dtmKH.getValueAt(j, 0).toString())) {
                tblThongtinKH1.setRowSelectionInterval(j, j);
                break;
            }
        }
    }

    private void findDeletedKH() {
        String maKH = txtTimKiemDeleted.getText();
        int i = tblThongtinKHDeleted.getRowCount();
        for (int j = 0; j < i; j++) {
            if (maKH.equals(dtmKHDeleted.getValueAt(j, 0).toString())) {
                tblThongtinKHDeleted.setRowSelectionInterval(j, j);
                break;
            }
        }
    }

    private void f5() {
        dtmHoaDon.setRowCount(0);
        tblHoaDon.setRowSorter(null);
        setuptblHD();
    }
//======================================================================================
//@QuanPM_PH27325 END
//--------------------------------------------------------------------------------------
    //Hieundph27275 start

    public void selecttablenv() {
        listNhanVien = nhanvienService.getAll();
        DefaultTableModel dtmNV = (DefaultTableModel) tablenv.getModel();
        dtmNV.setRowCount(0);
        for (NhanVienResponse nvResponse : listNhanVien) {
            Object[] row = {
                nvResponse.getMaNhanVien(),
                nvResponse.getHoTen(),
                nvResponse.isGioiTinh(),
                nvResponse.getTenCV(),
                nvResponse.getEmail(),
                nvResponse.getQueQuan(),
                nvResponse.getNgaySinh(),
                nvResponse.getTaiKhoan(),
                nvResponse.getMatKhau(),
                nvResponse.getCreatedAt(),
                nvResponse.isDeleted(),
                nvResponse.getUpdatedAt(),};
            dtmNV.addRow(row);
        }
    }

    public void loadtable() {
        listNhanVien = nhanvienService.getAll();
        DefaultTableModel dtmNV = (DefaultTableModel) tablenv.getModel();
        dtmNV.setRowCount(0);
        for (NhanVienResponse x : listNhanVien) {
            Object[] row = {x.getMaNhanVien(), x.getHoTen(), x.isGioiTinh(), x.getTenCV(), x.getEmail(), x.getQueQuan(), x.getNgaySinh(), x.getTaiKhoan(), x.getMatKhau()};
            dtmNV.addRow(row);
        }

    }

    public void loadnv1(List<NhanVienResponse> list1) {
        modelnv1.setRowCount(0);
        for (NhanVienResponse nhanVienResponse : list1) {
            modelnv1.addRow(nhanVienResponse.toDataRow());
        }
    }

    public void loadnv2(List<NhanVienResponse> list2) {
        modelnv2.setRowCount(0);
        for (NhanVienResponse nhanVienResponse : list2) {
            modelnv2.addRow(nhanVienResponse.toDataRow());
        }
    }

    public void loadnv3(List<NhanVienResponse> list3) {
        modelnv3.setRowCount(0);
        for (NhanVienResponse nhanVienResponse : list3) {
            modelnv3.addRow(nhanVienResponse.toDataRow());
        }
    }
    //Hieundph27275-end
//---------------------------------------------------------------------------------------------
    //--------------Thang

    public JFreeChart createChart(List<bieudo> b) {
        JFreeChart barChart = ChartFactory.createBarChart(
                "BIỂU ĐỒ DOANH THU THEO dd-MM-yyyy",
                "dd-MM-yyyy", "Doanh thu(VND)",
                createDataset(b), PlotOrientation.VERTICAL, false, false, false);
        return barChart;
    }

    private CategoryDataset createDataset(List<bieudo> b) {
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (bieudo c : b) {
            String ox = chuyenngaydd_MM_yyyy(c.getOx());
            dataset.addValue(c.getOy(), " ", ox);
        }
        return dataset;
    }

    public void loadbangbieudo() {
        DefaultTableModel tb = new DefaultTableModel();
        tb = (DefaultTableModel) tbbangbieudo.getModel();
        tb.setRowCount(0);
        if (b.size() > 0) {
            int stt = 0;
            for (bieudo b : b) {
                double a = (double) (b.getOy() * 1);
                tb.addRow(new Object[]{
                    stt = stt + 1, chuyenngaydd_MM_yyyy(b.getOx()), String.format("%,.2f", a) + " VND"

                });
            }
        } else {
            System.err.println("taco:-" + b.size());
        }

    }

    public float doanhthu(String a) {
        return HoaDonChiTietService.getAll3(a);

    }

    public void gananhbieudo() {
        File file = new File("anhbieudo.png");
        try {
            Image img = ImageIO.read(file);
            lbanhbieudo.setIcon(new ImageIcon(img.getScaledInstance(328, 142, 0)));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public boolean loadbangthongtheotimkiemkhoangtime1giamdan() throws ParseException {
        defaultTable = (DefaultTableModel) tbbangthongke.getModel();
        listThongke = HoaDonChiTietService.getAll1();

        //---------------------------------------------------------------
        tftieudetongdonhang.setText("TỔNG ĐƠN HÀNG");
        tfchitietdonhang.setText("CHI TIẾT ĐƠN HÀNG");
        tftieudetongdoanhthu.setText("DOANH THU");

        int solg = 0;
        double tong = 0;
        //----------------------------------------------------------------------
        listThongke.sort(
                (o1, o2) -> {
                    return Double.compare(o2.thanhtien(), o1.thanhtien());
                });
        defaultTable.setRowCount(0);
        int stt = 0;
        double tongbang = 0;
        if (listThongke.size() > 0) {
            for (int i = 0; i < listThongke.size(); i = i + 1) {
                if (sosanhngaytrongkhoang1(listThongke.get(i).chuyenngaymua())) {

                    solg = listThongke.get(i).getSoLuong() + solg;
                    tong = listThongke.get(i).thanhtien() + tong;

                    String doanhthu = String.format("%,.2f", tong) + " VND";
                    tfdoanhthu.setText(doanhthu);
                    tfsoluongsanphambanthongke.setText("" + solg);

                    double a = (double) (listThongke.get(i).getDonGia() * 1);
                    defaultTable.addRow(new Object[]{stt = stt + 1, listThongke.get(i).getMaSP(),
                        listThongke.get(i).getMaHD(),
                        listThongke.get(i).getTenSP(),
                        listThongke.get(i).getSoLuong(),
                        String.format("%,.2f", listThongke.get(i).getDonGia()) + " VND",
                        String.format("%,.2f", listThongke.get(i).thanhtien()) + " VND",
                        listThongke.get(i).chuyenngaymua()
                    });
                    tongbang = listThongke.get(i).thanhtien() + tongbang;
                    tftongdoanhthutimkiem.setText(String.format("%,.2f", tongbang) + " VND");
                }
            }
        } else {
            System.err.println("list.size=  " + listThongke.size());
        }

        int tc = 0;

        for (HoaDonResponse hd : HoaDonService.getAll1()) {
            if (sosanhngaytrongkhoang1(chuyenngaymuatk(hd.getCreatedAt())) && hd.isTrangThai()) {
                tc = tc + 1;
            }
        }
        tftongdonhang.setText("" + tc);
        tfdonthanhcong.setText(" " + String.valueOf(tc));
        tfdondahuy.setText(" 0");

////////
//        defaultTable = (DefaultTableModel) tbbangthongkeimai.getModel();
//        listThongke = HoaDonChiTietService.getAllimeidaban();
//        defaultTable.setRowCount(0);
//        int ic = 0;
//        if (listThongke.size() > 0) {
//            for (int i = 0; i < listThongke.size(); i = i + 1) {
//                if (sosanhngaytrongkhoang1(listThongke.get(i).chuyenngaymua())) {
//                    defaultTable.addRow(new Object[]{ic=ic + 1,
//                        listThongke.get(i).getMaHD(),
//                        listThongke.get(i).getMaImei(),
//                        listThongke.get(i).getImei(),
//    
//                    listThongke.get(i).chuyenngaymua()
//                    });
//
//                }
//            }
//        } else {
//            System.err.println("list.size=  " + listThongke.size());
//        }
        return true;
    }

    public boolean loadbangthongtheotimkiemkhoangtime0giamdan() throws ParseException {
        defaultTable = (DefaultTableModel) tbbangthongke.getModel();
        listThongke = HoaDonChiTietService.getAll1();

        //---------------------------------------------------------------
        tftieudetongdonhang.setText("TỔNG ĐƠN HÀNG");
        tfchitietdonhang.setText("CHI TIẾT ĐƠN HÀNG");
        tftieudetongdoanhthu.setText("DOANH THU");

        int solg = 0;
        double tong = 0;
        //----------------------------------------------------------------------
        listThongke.sort(
                (o1, o2) -> {
                    return Double.compare(o2.thanhtien(), o1.thanhtien());
                }
        );
        defaultTable.setRowCount(0);
        int st = 0;
        double tongbang = 0;
        if (listThongke.size() > 0) {
            for (int i = 0; i < listThongke.size(); i = i + 1) {
                if (sosanhngaytrongkhoang0(listThongke.get(i).chuyenngaymua())) {

                    solg = listThongke.get(i).getSoLuong() + solg;
                    tong = listThongke.get(i).thanhtien() + tong;
                    tfdondahuy.setText(" 0");
                    String doanhthu = String.format("%,.2f", tong) + " VND";
                    tfdoanhthu.setText(doanhthu);
                    tfsoluongsanphambanthongke.setText("" + solg);
                    double a = (double) (listThongke.get(i).getDonGia() * 1);
                    defaultTable.addRow(new Object[]{st = st + 1, listThongke.get(i).getMaSP(),
                        listThongke.get(i).getMaHD(),
                        listThongke.get(i).getTenSP(),
                        listThongke.get(i).getSoLuong(),
                        String.format("%,.2f", listThongke.get(i).getDonGia()) + " VND",
                        String.format("%,.2f", listThongke.get(i).thanhtien()) + " VND",
                        listThongke.get(i).chuyenngaymua()
                    });
                    tongbang = listThongke.get(i).thanhtien() + tongbang;
                    tftongdoanhthutimkiem.setText(String.format("%,.2f", tongbang) + " VND");
                }
            }
        } else {
            System.err.println(" sizz sanpham " + listThongke.size());
        }

        int tc = 0;

        for (HoaDonResponse hd : HoaDonService.getAll1()) {
            if (sosanhngaytrongkhoang0(chuyenngaymuatk(hd.getCreatedAt())) && hd.isTrangThai()) {
                tc = tc + 1;
            }
        }
        tftongdonhang.setText("" + tc);
        tfdonthanhcong.setText(" " + String.valueOf(tc));

        return true;
    }

    public boolean loadbangthongtheotimkiemkhoangtime1tangdan() throws ParseException {
        defaultTable = (DefaultTableModel) tbbangthongke.getModel();
        listThongke = HoaDonChiTietService.getAll1();

        //---------------------------------------------------------------
        tftieudetongdonhang.setText("TỔNG ĐƠN HÀNG");
        tfchitietdonhang.setText("CHI TIẾT ĐƠN HÀNG");
        tftieudetongdoanhthu.setText("DOANH THU");

        int solg = 0;
        double tong = 0;
        //----------------------------------------------------------------------
        listThongke.sort(
                (o1, o2) -> {
                    return Double.compare(o1.thanhtien(), o2.thanhtien());
                });
        defaultTable.setRowCount(0);
        int stt = 0;
        double tongbang = 0;
        if (listThongke.size() > 0) {
            for (int i = 0; i < listThongke.size(); i = i + 1) {
                if (sosanhngaytrongkhoang1(listThongke.get(i).chuyenngaymua())) {

                    solg = listThongke.get(i).getSoLuong() + solg;
                    tong = listThongke.get(i).thanhtien() + tong;

                    String doanhthu = String.format("%,.2f", tong) + " VND";
                    tfdoanhthu.setText(doanhthu);
                    tfsoluongsanphambanthongke.setText("" + solg);

                    double a = (double) (listThongke.get(i).getDonGia() * 1);
                    defaultTable.addRow(new Object[]{stt = stt + 1, listThongke.get(i).getMaSP(),
                        listThongke.get(i).getMaHD(),
                        listThongke.get(i).getTenSP(),
                        listThongke.get(i).getSoLuong(),
                        String.format("%,.2f", listThongke.get(i).getDonGia()) + " VND",
                        String.format("%,.2f", listThongke.get(i).thanhtien()) + " VND",
                        listThongke.get(i).chuyenngaymua()
                    });
                    tongbang = listThongke.get(i).thanhtien() + tongbang;
                    tftongdoanhthutimkiem.setText(String.format("%,.2f", tongbang) + " VND");
                }
            }
        } else {
            System.err.println("list.size=  " + listThongke.size());
        }

        int tc = 0;

        for (HoaDonResponse hd : HoaDonService.getAll1()) {
            if (sosanhngaytrongkhoang1(chuyenngaymuatk(hd.getCreatedAt())) && hd.isTrangThai()) {
                tc = tc + 1;
            }
        }
        tftongdonhang.setText("" + tc);
        tfdonthanhcong.setText(" " + String.valueOf(tc));
        tfdondahuy.setText(" 0");

////////
//        defaultTable = (DefaultTableModel) tbbangthongkeimai.getModel();
//        listThongke = HoaDonChiTietService.getAllimeidaban();
//        defaultTable.setRowCount(0);
//        int ic = 0;
//        if (listThongke.size() > 0) {
//            for (int i = 0; i < listThongke.size(); i = i + 1) {
//                if (sosanhngaytrongkhoang1(listThongke.get(i).chuyenngaymua())) {
//                    defaultTable.addRow(new Object[]{ic=ic + 1,
//                        listThongke.get(i).getMaHD(),
//                        listThongke.get(i).getMaImei(),
//                        listThongke.get(i).getImei(),
//    
//                    listThongke.get(i).chuyenngaymua()
//                    });
//
//                }
//            }
//        } else {
//            System.err.println("list.size=  " + listThongke.size());
//        }
        return true;
    }

    public boolean loadbangthongtheotimkiemkhoangtime0tangdan() throws ParseException {
        defaultTable = (DefaultTableModel) tbbangthongke.getModel();
        listThongke = HoaDonChiTietService.getAll1();

        //---------------------------------------------------------------
        tftieudetongdonhang.setText("TỔNG ĐƠN HÀNG");
        tfchitietdonhang.setText("CHI TIẾT ĐƠN HÀNG");
        tftieudetongdoanhthu.setText("DOANH THU");

        int solg = 0;
        double tong = 0;
        //----------------------------------------------------------------------
        listThongke.sort(
                (o1, o2) -> {
                    return Double.compare(o1.thanhtien(), o2.thanhtien());
                }
        );
        defaultTable.setRowCount(0);
        int st = 0;
        double tongbang = 0;
        if (listThongke.size() > 0) {
            for (int i = 0; i < listThongke.size(); i = i + 1) {
                if (sosanhngaytrongkhoang0(listThongke.get(i).chuyenngaymua())) {

                    solg = listThongke.get(i).getSoLuong() + solg;
                    tong = listThongke.get(i).thanhtien() + tong;
                    tfdondahuy.setText(" 0");
                    String doanhthu = String.format("%,.2f", tong) + " VND";
                    tfdoanhthu.setText(doanhthu);
                    tfsoluongsanphambanthongke.setText("" + solg);
                    double a = (double) (listThongke.get(i).getDonGia() * 1);
                    defaultTable.addRow(new Object[]{st = st + 1, listThongke.get(i).getMaSP(),
                        listThongke.get(i).getMaHD(),
                        listThongke.get(i).getTenSP(),
                        listThongke.get(i).getSoLuong(),
                        String.format("%,.2f", listThongke.get(i).getDonGia()) + " VND",
                        String.format("%,.2f", listThongke.get(i).thanhtien()) + " VND",
                        listThongke.get(i).chuyenngaymua()
                    });
                    tongbang = listThongke.get(i).thanhtien() + tongbang;
                    tftongdoanhthutimkiem.setText(String.format("%,.2f", tongbang) + " VND");
                }
            }
        } else {
            System.err.println(" sizz sanpham " + listThongke.size());
        }

        int tc = 0;

        for (HoaDonResponse hd : HoaDonService.getAll1()) {
            if (sosanhngaytrongkhoang0(chuyenngaymuatk(hd.getCreatedAt())) && hd.isTrangThai()) {
                tc = tc + 1;
            }
        }
        tftongdonhang.setText("" + tc);
        tfdonthanhcong.setText(" " + String.valueOf(tc));

        return true;
    }

    public void locsanphambanchaytheokhoangtimegiamdan() {

        defaultTable = (DefaultTableModel) tbbangsanphambanchaynhat.getModel();
        listThongke = HoaDonChiTietService.getAl4(chuyenngayY_M_D(ngaybatdau), chuyenngayY_M_D(nayketthuc));
        listThongke.sort(
                (o1, o2) -> {
                    return Double.compare(o2.getTongsoLuong(), o1.getTongsoLuong());
                }
        );
        defaultTable.setRowCount(0);

        if (listThongke.size() > 0) {
            for (int i = 0; i < listThongke.size(); i = i + 1) {

                defaultTable.addRow(new Object[]{
                    i + 1,
                    listThongke.get(i).getMaSP(),
                    listThongke.get(i).getTenSP(),
                    listThongke.get(i).getTongsoLuong()
                }
                );
            }
        } else {
            System.err.println("list.size=  " + listThongke.size());
        }
    }

    public void locsanphambanchaytheokhoangtimetangdan() {

        defaultTable = (DefaultTableModel) tbbangsanphambanchaynhat.getModel();
        listThongke = HoaDonChiTietService.getAl4(chuyenngayY_M_D(ngaybatdau), chuyenngayY_M_D(nayketthuc));
        listThongke.sort(
                (o1, o2) -> {
                    return Double.compare(o1.getTongsoLuong(), o2.getTongsoLuong());
                }
        );
        defaultTable.setRowCount(0);

        if (listThongke.size() > 0) {
            for (int i = 0; i < listThongke.size(); i = i + 1) {

                defaultTable.addRow(new Object[]{
                    i + 1,
                    listThongke.get(i).getMaSP(),
                    listThongke.get(i).getTenSP(),
                    listThongke.get(i).getTongsoLuong()
                }
                );
            }
        } else {
            System.err.println("list.size=  " + listThongke.size());
        }
    }

    public boolean loadbangthongtheotimkiemkhoangtime1theomasanpham() throws ParseException {
        defaultTable = (DefaultTableModel) tbbangthongke.getModel();
        listThongke = HoaDonChiTietService.getAll1();

        //---------------------------------------------------------------
        tftieudetongdonhang.setText("TỔNG ĐƠN HÀNG");
        tfchitietdonhang.setText("CHI TIẾT ĐƠN HÀNG");
        tftieudetongdoanhthu.setText("DOANH THU");

        int solg = 0;
        double tong = 0;
        //----------------------------------------------------------------------
        defaultTable.setRowCount(0);
        int stt = 0;
        double tongbang = 0;
        if (listThongke.size() > 0) {
            for (int i = 0; i < listThongke.size(); i = i + 1) {
                if (sosanhngaytrongkhoang1(listThongke.get(i).chuyenngaymua()) && listThongke.get(i).getMaSP().equals(tftimkiemthongke.getText())) {

                    solg = listThongke.get(i).getSoLuong() + solg;
                    tong = listThongke.get(i).thanhtien() + tong;

                    String doanhthu = String.format("%,.2f", tong) + " VND";
                    tfdoanhthu.setText(doanhthu);
                    tfsoluongsanphambanthongke.setText("" + solg);

                    double a = (double) (listThongke.get(i).getDonGia() * 1);
                    defaultTable.addRow(new Object[]{stt = stt + 1, listThongke.get(i).getMaSP(),
                        listThongke.get(i).getMaHD(),
                        listThongke.get(i).getTenSP(),
                        listThongke.get(i).getSoLuong(),
                        String.format("%,.2f", listThongke.get(i).getDonGia()) + " VND",
                        String.format("%,.2f", listThongke.get(i).thanhtien()) + " VND",
                        listThongke.get(i).chuyenngaymua()
                    });
                    tongbang = listThongke.get(i).thanhtien() + tongbang;
                    tftongdoanhthutimkiem.setText(String.format("%,.2f", tongbang) + " VND");
                }
            }
        } else {
            System.err.println("list.size=  " + listThongke.size());
        }

        int tc = 0;

        for (HoaDonResponse hd : HoaDonService.getAll1()) {
            if (sosanhngaytrongkhoang1(chuyenngaymuatk(hd.getCreatedAt())) && hd.isTrangThai()) {
                tc = tc + 1;
            }
        }
        tftongdonhang.setText("" + tc);
        tfdonthanhcong.setText(" " + String.valueOf(tc));
        tfdondahuy.setText(" 0");

////////
//        defaultTable = (DefaultTableModel) tbbangthongkeimai.getModel();
//        listThongke = HoaDonChiTietService.getAllimeidaban();
//        defaultTable.setRowCount(0);
//        int ic = 0;
//        if (listThongke.size() > 0) {
//            for (int i = 0; i < listThongke.size(); i = i + 1) {
//                if (sosanhngaytrongkhoang1(listThongke.get(i).chuyenngaymua())) {
//                    defaultTable.addRow(new Object[]{ic=ic + 1,
//                        listThongke.get(i).getMaHD(),
//                        listThongke.get(i).getMaImei(),
//                        listThongke.get(i).getImei(),
//    
//                    listThongke.get(i).chuyenngaymua()
//                    });
//
//                }
//            }
//        } else {
//            System.err.println("list.size=  " + listThongke.size());
//        }
        return true;
    }

    public boolean loadbangthongtheotimkiemkhoangtime0theomasanpham() throws ParseException {
        defaultTable = (DefaultTableModel) tbbangthongke.getModel();
        listThongke = HoaDonChiTietService.getAll1();

        //---------------------------------------------------------------
        tftieudetongdonhang.setText("TỔNG ĐƠN HÀNG");
        tfchitietdonhang.setText("CHI TIẾT ĐƠN HÀNG");
        tftieudetongdoanhthu.setText("DOANH THU");

        int solg = 0;
        double tong = 0;
        //----------------------------------------------------------------------
        defaultTable.setRowCount(0);
        int st = 0;
        double tongbang = 0;
        if (listThongke.size() > 0) {
            for (int i = 0; i < listThongke.size(); i = i + 1) {
                if (sosanhngaytrongkhoang0(listThongke.get(i).chuyenngaymua()) && listThongke.get(i).getMaSP().equals(tftimkiemthongke.getText())) {

                    solg = listThongke.get(i).getSoLuong() + solg;
                    tong = listThongke.get(i).thanhtien() + tong;
                    tfdondahuy.setText(" 0");
                    String doanhthu = String.format("%,.2f", tong) + " VND";
                    tfdoanhthu.setText(doanhthu);
                    tfsoluongsanphambanthongke.setText("" + solg);
                    double a = (double) (listThongke.get(i).getDonGia() * 1);
                    defaultTable.addRow(new Object[]{st = st + 1, listThongke.get(i).getMaSP(),
                        listThongke.get(i).getMaHD(),
                        listThongke.get(i).getTenSP(),
                        listThongke.get(i).getSoLuong(),
                        String.format("%,.2f", listThongke.get(i).getDonGia()) + " VND",
                        String.format("%,.2f", listThongke.get(i).thanhtien()) + " VND",
                        listThongke.get(i).chuyenngaymua()
                    });
                    tongbang = listThongke.get(i).thanhtien() + tongbang;
                    tftongdoanhthutimkiem.setText(String.format("%,.2f", tongbang) + " VND");
                }
            }
        } else {
            System.err.println(" sizz sanpham " + listThongke.size());
        }

        int tc = 0;

        for (HoaDonResponse hd : HoaDonService.getAll1()) {
            if (sosanhngaytrongkhoang0(chuyenngaymuatk(hd.getCreatedAt())) && hd.isTrangThai()) {
                tc = tc + 1;
            }
        }
        tftongdonhang.setText("" + tc);
        tfdonthanhcong.setText(" " + String.valueOf(tc));

        return true;
    }

    public void loadbangsanphambanchaynhat() {
        defaultTable = (DefaultTableModel) tbbangsanphambanchaynhat.getModel();

        defaultTable.setRowCount(0);

        if (listThongke.size() > 0) {
            for (int i = 0; i < HoaDonChiTietService.getAl2().size(); i = i + 1) {

                defaultTable.addRow(new Object[]{
                    i + 1,
                    HoaDonChiTietService.getAl2().get(i).getMaSP(),
                    HoaDonChiTietService.getAl2().get(i).getTenSP(),
                    HoaDonChiTietService.getAl2().get(i).getTongsoLuong()
                }
                );
            }
        } else {
            System.err.println("list.size=  " + listThongke.size());
        }

    }

    public void loadbangsanphamtonthongkeGIAMDAN() {
        defaultTable = (DefaultTableModel) tbsanphamtonthongke.getModel();
        listThongke = HoaDonChiTietService.getAllsp();
        listThongke.sort(
                (o1, o2) -> {
                    return Double.compare(o2.getDonGia(), o1.getDonGia());
                }
        );
        defaultTable.setRowCount(0);

        if (listThongke.size() > 0) {
            for (int i = 0; i < listThongke.size(); i = i + 1) {

                double a = (double) (listThongke.get(i).getDonGia() * 1);
                defaultTable.addRow(new Object[]{i + 1, listThongke.get(i).getMaSP(),
                    listThongke.get(i).getTenSP(),
                    listThongke.get(i).getSolgton(),
                    String.format("%,.2f", listThongke.get(i).getDonGia()) + " VND",});

            }
        } else {
            System.err.println("list.size=  " + listThongke.size());
        }

    }

    public void loadbangsanphamtonthongkeTANGDAN() {
        defaultTable = (DefaultTableModel) tbsanphamtonthongke.getModel();
        listThongke = HoaDonChiTietService.getAllsp();
        listThongke.sort(
                (o1, o2) -> {
                    return Double.compare(o1.getDonGia(), o2.getDonGia());
                }
        );
        defaultTable.setRowCount(0);

        if (listThongke.size() > 0) {
            for (int i = 0; i < listThongke.size(); i = i + 1) {

                double a = (double) (listThongke.get(i).getDonGia() * 1);
                defaultTable.addRow(new Object[]{i + 1, listThongke.get(i).getMaSP(),
                    listThongke.get(i).getTenSP(),
                    listThongke.get(i).getSolgton(),
                    String.format("%,.2f", listThongke.get(i).getDonGia()) + " VND",});

            }
        } else {
            System.err.println("list.size=  " + listThongke.size());
        }

    }

    public void loadbangsanphamtonthongke() {
        defaultTable = (DefaultTableModel) tbsanphamtonthongke.getModel();
        listThongke = HoaDonChiTietService.getAllsp();

        defaultTable.setRowCount(0);

        if (listThongke.size() > 0) {
            for (int i = 0; i < listThongke.size(); i = i + 1) {

                double a = (double) (listThongke.get(i).getDonGia() * 1);
                defaultTable.addRow(new Object[]{i + 1, listThongke.get(i).getMaSP(),
                    listThongke.get(i).getTenSP(),
                    listThongke.get(i).getSolgton(),
                    String.format("%,.2f", listThongke.get(i).getDonGia()) + " VND",});

            }
        } else {
            System.err.println("list.size=  " + listThongke.size());
        }

    }

    public void loadbangthongke() {
        defaultTable = (DefaultTableModel) tbbangthongke.getModel();
        listThongke = HoaDonChiTietService.getAll1();

        //---------------------------------------------------------------
        tftieudetongdonhang.setText("TỔNG ĐƠN HÀNG");
        tfchitietdonhang.setText("CHI TIẾT ĐƠN HÀNG");
        tftieudetongdoanhthu.setText("DOANH THU");
        //   tftongdonhang.setText(String.valueOf(HoaDonService.getAll1().size()));
        int tc = 0;
        int dh = 0;
        for (HoaDonResponse hd : HoaDonService.getAll1()) {
            if (hd.isTrangThai()) {
                tc = tc + 1;
            }
        }
        tftongdonhang.setText(String.valueOf(tc));
        tfdonthanhcong.setText(" " + String.valueOf(tc));
        tfdondahuy.setText(" 0");
        int solg = 0;
        double tong = 0;
        for (ThongkeResponse t : listThongke) {
            solg = solg + t.getSoLuong();
            tong = tong + t.thanhtien();
        }
        String doanhthu = String.format("%,.2f", tong) + " VND";
        tfdoanhthu.setText(doanhthu);
        tfsoluongsanphambanthongke.setText("" + solg);
        //----------------------------------------------------------------------
        defaultTable.setRowCount(0);
        double tongbang = 0;
        if (listThongke.size() > 0) {
            for (int i = 0; i < listThongke.size(); i = i + 1) {

                double a = (double) (listThongke.get(i).getDonGia() * 1);
                defaultTable.addRow(new Object[]{i + 1, listThongke.get(i).getMaSP(),
                    listThongke.get(i).getMaHD(),
                    listThongke.get(i).getTenSP(),
                    listThongke.get(i).getSoLuong(),
                    String.format("%,.2f", listThongke.get(i).getDonGia()) + " VND",
                    String.format("%,.2f", listThongke.get(i).thanhtien()) + " VND",
                    listThongke.get(i).chuyenngaymua()
                });
                tongbang = listThongke.get(i).thanhtien() + tongbang;
                tftongdoanhthutimkiem.setText(String.format("%,.2f", tongbang) + " VND");
            }
        } else {
            System.err.println("list.size=  " + listThongke.size());
        }

        //----------------------
    }

    public void loadbangthongketangdantheothanhtien() {
        defaultTable = (DefaultTableModel) tbbangthongke.getModel();
        listThongke = HoaDonChiTietService.getAll1();
        //
        //---------------------------------------------------------------
        tftieudetongdonhang.setText("TỔNG ĐƠN HÀNG");
        tfchitietdonhang.setText("CHI TIẾT ĐƠN HÀNG");
        tftieudetongdoanhthu.setText("DOANH THU");
        // tftongdonhang.setText(String.valueOf(HoaDonService.getAll1().size()));
        int tc = 0;
        int dh = 0;
        for (HoaDonResponse hd : HoaDonService.getAll1()) {
            if (hd.isTrangThai()) {
                tc = tc + 1;
            }
        }
        tftongdonhang.setText(String.valueOf(tc));
        tfdonthanhcong.setText("" + String.valueOf(tc));
        tfdondahuy.setText("0");
        int solg = 0;
        double tong = 0;
        for (ThongkeResponse t : listThongke) {
            solg = solg + t.getSoLuong();
            tong = tong + t.thanhtien();
        }
        String doanhthu = String.format("%,.2f", tong) + " VND";
        tfdoanhthu.setText(doanhthu);
        tfsoluongsanphambanthongke.setText("" + solg);
        //----------------------------------------------------------------------
        //
        listThongke.sort(
                (o1, o2) -> {
                    return Double.compare(o1.thanhtien(), o2.thanhtien());
                }
        );
        defaultTable.setRowCount(0);
        double tongbang = 0;
        if (listThongke.size() > 0) {
            for (int i = 0; i < listThongke.size(); i = i + 1) {

                double a = (double) (listThongke.get(i).getDonGia() * 1);
                defaultTable.addRow(new Object[]{i + 1, listThongke.get(i).getMaSP(),
                    listThongke.get(i).getMaHD(),
                    listThongke.get(i).getTenSP(),
                    listThongke.get(i).getSoLuong(),
                    String.format("%,.2f", listThongke.get(i).getDonGia()) + " VND",
                    String.format("%,.2f", listThongke.get(i).thanhtien()) + " VND",
                    listThongke.get(i).chuyenngaymua()
                });
                tongbang = listThongke.get(i).thanhtien() + tongbang;
                tftongdoanhthutimkiem.setText(String.format("%,.2f", tongbang) + " VND");
            }
        } else {
            System.err.println("list.size=  " + listThongke.size());
        }

        //    loadbangthongkeimei();
        defaultTable = (DefaultTableModel) tbbangsanphambanchaynhat.getModel();
        listThongke = HoaDonChiTietService.getAl2();
        listThongke.sort(
                (o1, o2) -> {
                    return Double.compare(o1.getTongsoLuong(), o2.getTongsoLuong());
                }
        );

        defaultTable.setRowCount(0);

        if (listThongke.size() > 0) {
            for (int i = 0; i < listThongke.size(); i = i + 1) {

                defaultTable.addRow(new Object[]{
                    i + 1,
                    listThongke.get(i).getMaSP(),
                    listThongke.get(i).getTenSP(),
                    listThongke.get(i).getTongsoLuong()
                }
                );
            }
        } else {
            System.err.println("list.size=  " + listThongke.size());
        }

    }

    public void loadbangthongkegiamdantheothanhtien() {
        defaultTable = (DefaultTableModel) tbbangthongke.getModel();
        listThongke = HoaDonChiTietService.getAll1();
        //
        //---------------------------------------------------------------
        tftieudetongdonhang.setText("TỔNG ĐƠN HÀNG");
        tfchitietdonhang.setText("CHI TIẾT ĐƠN HÀNG");
        tftieudetongdoanhthu.setText("DOANH THU");
        //     tftongdonhang.setText(String.valueOf(HoaDonService.getAll1().size()));
        int tc = 0;
        int dh = 0;
        for (HoaDonResponse hd : HoaDonService.getAll1()) {
            if (hd.isTrangThai()) {
                tc = tc + 1;
            }
        }
        tftongdonhang.setText(String.valueOf(tc));
        tfdonthanhcong.setText(" " + String.valueOf(tc));
        tfdondahuy.setText("0");
        int solg = 0;
        double tong = 0;
        for (ThongkeResponse t : listThongke) {
            solg = solg + t.getSoLuong();
            tong = tong + t.thanhtien();
        }
        String doanhthu = String.format("%,.2f", tong) + " VND";
        tfdoanhthu.setText(doanhthu);
        tfsoluongsanphambanthongke.setText("" + solg);
        //---------------------------------------------------------------------- 
        //
        listThongke.sort(
                (o1, o2) -> {
                    return Double.compare(o2.thanhtien(), o1.thanhtien());
                }
        );
        defaultTable.setRowCount(0);
        double tongbang = 0;
        if (listThongke.size() > 0) {
            for (int i = 0; i < listThongke.size(); i = i + 1) {

                double a = (double) (listThongke.get(i).getDonGia() * 1);
                defaultTable.addRow(new Object[]{i + 1, listThongke.get(i).getMaSP(),
                    listThongke.get(i).getMaHD(),
                    listThongke.get(i).getTenSP(),
                    listThongke.get(i).getSoLuong(),
                    String.format("%,.2f", listThongke.get(i).getDonGia()) + " VND",
                    String.format("%,.2f", listThongke.get(i).thanhtien()) + " VND",
                    listThongke.get(i).chuyenngaymua()
                });
                tongbang = listThongke.get(i).thanhtien() + tongbang;
                tftongdoanhthutimkiem.setText(String.format("%,.2f", tongbang) + " VND");
            }
        } else {
            System.err.println("list.size=  " + listThongke.size());
        }

        //     loadbangthongkeimei();
        loadbangsanphambanchaynhat();

    }

    public void timkiemthongke1() {
        defaultTable = (DefaultTableModel) tbsanphamtonthongke.getModel();
        listThongke = HoaDonChiTietService.getAllsp();

        //---------------------------------------------------------------
        defaultTable.setRowCount(0);
        int ec = 0;

        if (listThongke.size() > 0) {
            for (int i = 0; i < listThongke.size(); i = i + 1) {
                if (listThongke.get(i).getMaSP().equals(tftimkiemsanphamton.getText())) {
                    double a = (double) (listThongke.get(i).getDonGia() * 1);
                    defaultTable.addRow(new Object[]{ec = ec + 1, listThongke.get(i).getMaSP(),
                        listThongke.get(i).getTenSP(),
                        listThongke.get(i).getSolgton(),
                        String.format("%,.2f", listThongke.get(i).getDonGia()) + " VND",});
                }

            }
        } else {
            System.err.println("list.size=  " + listThongke.size());
        }

//
        //  timkiemimei();
    }

    public void timkiemthongke() {
        defaultTable = (DefaultTableModel) tbbangthongke.getModel();
        listThongke = HoaDonChiTietService.getAll1();

        defaultTable.setRowCount(0);

        if (listThongke.size() > 0) {
            int io = 0;
            double tongbang = 0;
            for (int i = 0; i < listThongke.size(); i = i + 1) {
                if (listThongke.get(i).getMaSP().equalsIgnoreCase(tftimkiemthongke.getText())) {

                    double a = (double) (listThongke.get(i).getDonGia() * 1);
                    defaultTable.addRow(new Object[]{io = io + 1, listThongke.get(i).getMaSP(),
                        listThongke.get(i).getMaHD(),
                        listThongke.get(i).getTenSP(),
                        listThongke.get(i).getSoLuong(),
                        String.format("%,.2f", listThongke.get(i).getDonGia()) + " VND",
                        String.format("%,.2f", listThongke.get(i).thanhtien()) + " VND",
                        listThongke.get(i).chuyenngaymua()
                    });
                    tongbang = listThongke.get(i).thanhtien() + tongbang;
                    tftongdoanhthutimkiem.setText(String.format("%,.2f", tongbang) + " VND");
                }

            }
        } else {
            System.err.println("list.size=  " + listThongke.size());
        }

        ///////////////
        defaultTable = (DefaultTableModel) tbbangsanphambanchaynhat.getModel();

        defaultTable.setRowCount(0);

        if (listThongke.size() > 0) {
            int b2 = 0;
            for (int i = 0; i < HoaDonChiTietService.getAl2().size(); i = i + 1) {

                if (HoaDonChiTietService.getAl2().get(i).getMaSP().equalsIgnoreCase(tftimkiemthongke.getText())) {
                    defaultTable.addRow(new Object[]{
                        b2 = b2 + 1,
                        HoaDonChiTietService.getAl2().get(i).getMaSP(),
                        HoaDonChiTietService.getAl2().get(i).getTenSP(),
                        HoaDonChiTietService.getAl2().get(i).getTongsoLuong()
                    }
                    );
                }
            }
        } else {
            System.err.println("list.size=  " + listThongke.size());
        }

//
        //  timkiemimei();
    }

    public int sosanhngaybtvskt() throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        Date date1 = sdf.parse(chuyen_d_M_y(tfngaybatdauthongke.getDate()));

        Date date2 = sdf.parse(chuyen_d_M_y(tfketthucngaythongke.getDate()));

        int a = date1.compareTo(date2);
        // bằng   date1=date2 thi 0
        //  date1 có trước date2 thì -1
        // còn lại 1

        return a;

    }
    int kt = 0;

    public boolean checktimkiemtheokhoangtime() throws ParseException {
        if (tfngaybatdauthongke.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Ngày bắt đầu không đúng định dạng dd-MM-yyyy");
            return false;
        } else {
            if (tfketthucngaythongke.getDate() == null) {
                JOptionPane.showMessageDialog(this, "Ngày kết thúc kkhông đúng định dạng dd-MM-yyyy");
                return false;
            } else {

                if (sosanhngaybtvskt() == 0) {
                    kt = 0;
                    return true;
                } else {
                    if (sosanhngaybtvskt() == -1) {
                        kt = 1;
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(this, "Ngày kết thúc phải lớn hơn hoặc bằng ngày bắt đàu");
                        return false;
                    }
                }

            }
        }
    }

    public String chuyenngaydd_MM_yyyy(String s) {

        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(s);
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            String ns = format.format(date);
            return ns;
        } catch (Exception e) {
            return "";
        }

    }

    public String chuyenngayY_M_D(String s) {

        try {
            Date date = new SimpleDateFormat("dd-MM-yyyy").parse(s);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String ns = format.format(date);
            return ns;
        } catch (Exception e) {
            return "";
        }

    }

    public String chuyenngaymuatk(Date s) {

        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(s.toString());
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            String ns = format.format(date);
            return ns;
        } catch (Exception e) {
            return "";
        }

    }

    public String chuyen_d_M_y(Date s) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            String formattedDate = format.format(s);
            return formattedDate;
        } catch (Exception e) {
            return "";
        }

    }

    public boolean loadbangthongtheotimkiemkhoangtime0() throws ParseException {
        defaultTable = (DefaultTableModel) tbbangthongke.getModel();
        listThongke = HoaDonChiTietService.getAll1();

        //---------------------------------------------------------------
        tftieudetongdonhang.setText("TỔNG ĐƠN HÀNG");
        tfchitietdonhang.setText("CHI TIẾT ĐƠN HÀNG");
        tftieudetongdoanhthu.setText("DOANH THU");

        int solg = 0;
        double tong = 0;
        //----------------------------------------------------------------------
        defaultTable.setRowCount(0);
        int st = 0;
        double tongbang = 0;
        if (listThongke.size() > 0) {
            for (int i = 0; i < listThongke.size(); i = i + 1) {
                if (sosanhngaytrongkhoang0(listThongke.get(i).chuyenngaymua())) {

                    solg = listThongke.get(i).getSoLuong() + solg;
                    tong = listThongke.get(i).thanhtien() + tong;
                    tongbang = listThongke.get(i).thanhtien() + tongbang;

                    double a = (double) (listThongke.get(i).getDonGia() * 1);
                    defaultTable.addRow(new Object[]{st = st + 1, listThongke.get(i).getMaSP(),
                        listThongke.get(i).getMaHD(),
                        listThongke.get(i).getTenSP(),
                        listThongke.get(i).getSoLuong(),
                        String.format("%,.2f", listThongke.get(i).getDonGia()) + " VND",
                        String.format("%,.2f", listThongke.get(i).thanhtien()) + " VND",
                        listThongke.get(i).chuyenngaymua()
                    });

                }
            }
            tfdondahuy.setText(" 0");
            String doanhthu = String.format("%,.2f", tong) + " VND";
            tfdoanhthu.setText(doanhthu);
            tfsoluongsanphambanthongke.setText("" + solg);
            tftongdoanhthutimkiem.setText(String.format("%,.2f", tongbang) + " VND");
        } else {
            System.err.println(" sizz sanpham " + listThongke.size());
        }

        int tc = 0;

        for (HoaDonResponse hd : HoaDonService.getAll1()) {
            if (sosanhngaytrongkhoang0(chuyenngaymuatk(hd.getCreatedAt())) && hd.isTrangThai()) {
                tc = tc + 1;
            }
        }
        tftongdonhang.setText("" + tc);
        tfdonthanhcong.setText(" " + String.valueOf(tc));

        return true;
    }

    public boolean loadbangthongtheotimkiemkhoangtime1() throws ParseException {
        defaultTable = (DefaultTableModel) tbbangthongke.getModel();
        listThongke = HoaDonChiTietService.getAll1();

        //---------------------------------------------------------------
        tftieudetongdonhang.setText("TỔNG ĐƠN HÀNG");
        tfchitietdonhang.setText("CHI TIẾT ĐƠN HÀNG");
        tftieudetongdoanhthu.setText("DOANH THU");

        int solg = 0;
        double tong = 0;
        //----------------------------------------------------------------------
        defaultTable.setRowCount(0);
        int stt = 0;
        double tongbang = 0;
        if (listThongke.size() > 0) {
            for (int i = 0; i < listThongke.size(); i = i + 1) {
                if (sosanhngaytrongkhoang1(listThongke.get(i).chuyenngaymua())) {

                    solg = listThongke.get(i).getSoLuong() + solg;
                    tong = listThongke.get(i).thanhtien() + tong;
                    tongbang = listThongke.get(i).thanhtien() + tongbang;

                    double a = (double) (listThongke.get(i).getDonGia() * 1);
                    defaultTable.addRow(new Object[]{stt = stt + 1, listThongke.get(i).getMaSP(),
                        listThongke.get(i).getMaHD(),
                        listThongke.get(i).getTenSP(),
                        listThongke.get(i).getSoLuong(),
                        String.format("%,.2f", listThongke.get(i).getDonGia()) + " VND",
                        String.format("%,.2f", listThongke.get(i).thanhtien()) + " VND",
                        listThongke.get(i).chuyenngaymua()
                    });

                }
            }
            String doanhthu = String.format("%,.2f", tong) + " VND";
            tfdoanhthu.setText(doanhthu);
            tfsoluongsanphambanthongke.setText("" + solg);
            tftongdoanhthutimkiem.setText(String.format("%,.2f", tongbang) + " VND");
        } else {
            System.err.println("list.size=  " + listThongke.size());
        }

        int tc = 0;

        for (HoaDonResponse hd : HoaDonService.getAll1()) {
            if (sosanhngaytrongkhoang1(chuyenngaymuatk(hd.getCreatedAt())) && hd.isTrangThai()) {
                tc = tc + 1;
            }
        }
        tftongdonhang.setText("" + tc);
        tfdonthanhcong.setText(" " + String.valueOf(tc));
        tfdondahuy.setText(" 0");

////////
//        defaultTable = (DefaultTableModel) tbbangthongkeimai.getModel();
//        listThongke = HoaDonChiTietService.getAllimeidaban();
//        defaultTable.setRowCount(0);
//        int ic = 0;
//        if (listThongke.size() > 0) {
//            for (int i = 0; i < listThongke.size(); i = i + 1) {
//                if (sosanhngaytrongkhoang1(listThongke.get(i).chuyenngaymua())) {
//                    defaultTable.addRow(new Object[]{ic=ic + 1,
//                        listThongke.get(i).getMaHD(),
//                        listThongke.get(i).getMaImei(),
//                        listThongke.get(i).getImei(),
//    
//                    listThongke.get(i).chuyenngaymua()
//                    });
//
//                }
//            }
//        } else {
//            System.err.println("list.size=  " + listThongke.size());
//        }
        return true;
    }

    public boolean sosanhngaytrongkhoang1(String ec) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        Date date1 = sdf.parse(chuyen_d_M_y(tfngaybatdauthongke.getDate()));

        Date date2 = sdf.parse(chuyen_d_M_y(tfketthucngaythongke.getDate()));
        Date date3 = sdf.parse(ec);

        int a = date1.compareTo(date2);
        // bằng   date1=date2 thi 0
        //  date1 có trước date2 thì -1
        // date1 có sau date2 thì 1
        if (date3.compareTo(date1) == 1 && date3.compareTo(date2) == -1 || date3.compareTo(date1) == 0 || date3.compareTo(date2) == 0) {
            return true;
        } else {
            return false;
        }

    }

    public boolean sosanhngaytrongkhoang0(String ec) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        Date date1 = sdf.parse(chuyen_d_M_y(tfngaybatdauthongke.getDate()));

        Date date2 = sdf.parse(chuyen_d_M_y(tfketthucngaythongke.getDate()));
        Date date3 = sdf.parse(ec);

        int a = date1.compareTo(date2);
        // bằng   date1=date2 thi 0
        //  date1 có trước date2 thì -1
        // date1 có sau date2 thì 1
        if (date3.compareTo(date1) == 0 || date3.compareTo(date2) == 0) {
            System.out.println("kiem tra  date ok");
            return true;
        } else {
            System.out.println("kem tra loi");
            return false;

        }

    }

    public void guibaocao() {
        String i = JOptionPane.showInputDialog(this, "NHẬP EMAIL CỦA SẾP");

        if (i != null && i.length() <= 0) {
            JOptionPane.showMessageDialog(this, "Không để trống eimil sếp ");
        } else {

            if (i == null) {
                JOptionPane.showMessageDialog(this, " Đã dừng gửi");
            } else {

                final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
                // Get a Properties object
                Properties props = System.getProperties();
                props.setProperty("mail.smtp.host", "smtp.gmail.com");
                props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
                props.setProperty("mail.smtp.socketFactory.fallback", "false");
                props.setProperty("mail.smtp.port", "465");
                props.setProperty("mail.smtp.socketFactory.port", "465");
                props.put("mail.smtp.auth", "true");
                props.put("mail.debug", "true");
                props.put("mail.store.protocol", "pop3");
                props.put("mail.transport.protocol", "smtp");
                final String username = "thangpdph28478@fpt.edu.vn";//
                final String password = "t3ku8v2k";
                final String toEmail = i;
                try {
                    Session session = Session.getDefaultInstance(props,
                            new Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(username, password);
                        }
                    });

                    // -- Create a new message --
                    Message msg = new MimeMessage(session);

                    // -- Set the FROM and TO fields --
                    msg.setFrom(new InternetAddress("thangpdph28478@fpt.edu.vn"));
                    msg.setRecipients(Message.RecipientType.TO,
                            InternetAddress.parse(toEmail, false));
                    msg.setSubject("THONG BAO DOANH THU: NHOM 5 BAN DIEN THOAI  [ " + chuyen_d_M_y(tfngaybatdauthongke.getDate()) + " DEN " + chuyen_d_M_y(tfketthucngaythongke.getDate()) + " ]");

                    String baocao = "TONG DOANH THU " + "[ " + chuyen_d_M_y(tfngaybatdauthongke.getDate()) + " DEN " + chuyen_d_M_y(tfketthucngaythongke.getDate()) + " ]" + "\n"
                            + "--------------------------------------------------------------------------\n"
                            + "TONG DON HANG                            : " + tftongdonhang.getText() + "\n"
                            + "THANH CONG                                   :" + tfdonthanhcong.getText() + "\n"
                            + "DA HUY                                              :" + tfdondahuy.getText() + "\n"
                            + "--------------------------------------------------------------------------\n"
                            + "SO LUONG SAN PHAM DA BAN      : " + tfsoluongsanphambanthongke.getText() + "\n"
                            + "--------------------------------------------------------------------------\n"
                            + "TONG DOANH THU                           : " + tfdoanhthu.getText() + "\n";
                    msg.setText(baocao);
                    msg.setSentDate(new Date());
                    int xuat = JOptionPane.showConfirmDialog(this, baocao);

                    if (xuat == 0) {
                        Transport.send(msg);
                        JOptionPane.showMessageDialog(this, "GỬI BÁO CÁO THÀNH CÔNG");
                    } else {
                        JOptionPane.showMessageDialog(this, "ĐÃ DỪNG BÁO CÁO");
                    }

                } catch (MessagingException e) {
                    JOptionPane.showMessageDialog(this, "email không tồn tại ,Gửi báo cáo thất bại");
                    System.out.println("LỖI :    " + e);
                }

            }
        }

    }

    public void locsanphambanchaytheokhoangtime() {

        defaultTable = (DefaultTableModel) tbbangsanphambanchaynhat.getModel();

        defaultTable.setRowCount(0);

        if (HoaDonChiTietService.getAl4(chuyenngayY_M_D(ngaybatdau), chuyenngayY_M_D(nayketthuc)).size() > 0) {
            for (int i = 0; i < HoaDonChiTietService.getAl4(chuyenngayY_M_D(ngaybatdau), chuyenngayY_M_D(nayketthuc)).size(); i = i + 1) {

                defaultTable.addRow(new Object[]{
                    i + 1,
                    HoaDonChiTietService.getAl4(chuyenngayY_M_D(ngaybatdau), chuyenngayY_M_D(nayketthuc)).get(i).getMaSP(),
                    HoaDonChiTietService.getAl4(chuyenngayY_M_D(ngaybatdau), chuyenngayY_M_D(nayketthuc)).get(i).getTenSP(),
                    HoaDonChiTietService.getAl4(chuyenngayY_M_D(ngaybatdau), chuyenngayY_M_D(nayketthuc)).get(i).getTongsoLuong()
                }
                );
            }
        } else {
            System.err.println("list.size=  " + listThongke.size());
        }
    }

    public void locsanphambanchaytheokhoangtimetimkiem() {

        defaultTable = (DefaultTableModel) tbbangsanphambanchaynhat.getModel();

        defaultTable.setRowCount(0);

        if (listThongke.size() > 0) {
            int io = 0;
            for (int i = 0; i < HoaDonChiTietService.getAl4(chuyenngayY_M_D(ngaybatdau), chuyenngayY_M_D(nayketthuc)).size(); i = i + 1) {
                if (HoaDonChiTietService.getAl4(chuyenngayY_M_D(ngaybatdau), chuyenngayY_M_D(nayketthuc)).get(i).getMaSP().equals(tftimkiemthongke.getText())) {
                    defaultTable.addRow(new Object[]{
                        io = io + 1,
                        HoaDonChiTietService.getAl4(chuyenngayY_M_D(ngaybatdau), chuyenngayY_M_D(nayketthuc)).get(i).getMaSP(),
                        HoaDonChiTietService.getAl4(chuyenngayY_M_D(ngaybatdau), chuyenngayY_M_D(nayketthuc)).get(i).getTenSP(),
                        HoaDonChiTietService.getAl4(chuyenngayY_M_D(ngaybatdau), chuyenngayY_M_D(nayketthuc)).get(i).getTongsoLuong()
                    }
                    );
                }

            }
        } else {
            System.err.println("list.size=  " + listThongke.size());
        }
    }

    public void xuatexcelthongke() {

        if (kiemtravitribangthongke == 0) {
            JOptionPane.showMessageDialog(this, "Bạn chưa bôi  đen dữ liệu cần xuất Excel");
        } else {
            if (kiemtravitribangthongke == 1) {
                vitribangexcle = (DefaultTableModel) tbbangthongke.getModel();
                JFileChooser excelFileChooser = new JFileChooser("C:\\Users\\Admin\\Desktop");
                excelFileChooser.setDialogTitle("Save as");
                FileNameExtensionFilter filefilter = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlsm");
                excelFileChooser.setFileFilter(filefilter);
                int check = excelFileChooser.showSaveDialog(null);

                //Check khi ấn nút save
                if (check == JFileChooser.APPROVE_OPTION) {
                    FileOutputStream FOS = null;
                    BufferedOutputStream BOS = null;
                    XSSFWorkbook excelJtableExporter = null;
                    try {
                        excelJtableExporter = new XSSFWorkbook();
//                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd_MM_yyyy HH:mm:ss");
//                LocalDateTime now = LocalDateTime.now();
                        XSSFSheet excelSheet = excelJtableExporter.createSheet("SẢN PHẨM BÁN THEO KHOẢNG THỜI GIAN");
                        //Lấy số dòng, cột tblHoaDon

                        for (int i = tbbangthongke.getSelectedRow(); i < tbbangthongke.getSelectedRow() + tbbangthongke.getSelectedRowCount(); i++) {
                            XSSFRow excelRow = excelSheet.createRow(i);
                            for (int j = 0; j < vitribangexcle.getColumnCount(); j++) {
                                XSSFCell excelCell = excelRow.createCell(j);

                                excelCell.setCellValue(vitribangexcle.getValueAt(i, j).toString());
                            }
                        }

                        FOS = new FileOutputStream(excelFileChooser.getSelectedFile() + ".xlsx");
                        BOS = new BufferedOutputStream(FOS);
                        excelJtableExporter.write(BOS);
                        JOptionPane.showMessageDialog(this, "Xuất Thành Công!!!!");
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    } finally {
                        try {
                            if (BOS != null) {
                                BOS.close();
                            }

                            if (FOS != null) {
                                FOS.close();
                            }

                            if (excelJtableExporter != null) {
                                excelJtableExporter.close();
                            }

                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }

                }
            } else {
                if (kiemtravitribangthongke == 2) {
                    vitribangexcle = (DefaultTableModel) tbbangsanphambanchaynhat.getModel();
                    JFileChooser excelFileChooser = new JFileChooser("C:\\Users\\Admin\\Desktop");
                    excelFileChooser.setDialogTitle("Save as");
                    FileNameExtensionFilter filefilter = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlsm");
                    excelFileChooser.setFileFilter(filefilter);
                    int check = excelFileChooser.showSaveDialog(null);

                    //Check khi ấn nút save
                    if (check == JFileChooser.APPROVE_OPTION) {
                        FileOutputStream FOS = null;
                        BufferedOutputStream BOS = null;
                        XSSFWorkbook excelJtableExporter = null;
                        try {
                            excelJtableExporter = new XSSFWorkbook();
//                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd_MM_yyyy HH:mm:ss");
//                LocalDateTime now = LocalDateTime.now();
                            XSSFSheet excelSheet = excelJtableExporter.createSheet("Sản phẩm bán nhiều nhất trong khoang thời gian");
                            //Lấy số dòng, cột tblHoaDon

                            for (int i = tbbangsanphambanchaynhat.getSelectedRow(); i < tbbangsanphambanchaynhat.getSelectedRow() + tbbangsanphambanchaynhat.getSelectedRowCount(); i++) {
                                XSSFRow excelRow = excelSheet.createRow(i);
                                for (int j = 0; j < vitribangexcle.getColumnCount(); j++) {
                                    XSSFCell excelCell = excelRow.createCell(j);

                                    excelCell.setCellValue(vitribangexcle.getValueAt(i, j).toString());
                                }
                            }

                            FOS = new FileOutputStream(excelFileChooser.getSelectedFile() + ".xlsx");
                            BOS = new BufferedOutputStream(FOS);
                            excelJtableExporter.write(BOS);
                            JOptionPane.showMessageDialog(this, "Xuất Thành Công!!!!");
                        } catch (FileNotFoundException ex) {
                            ex.printStackTrace();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        } finally {
                            try {
                                if (BOS != null) {
                                    BOS.close();
                                }

                                if (FOS != null) {
                                    FOS.close();
                                }

                                if (excelJtableExporter != null) {
                                    excelJtableExporter.close();
                                }

                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                        }

                    }
                } else {

                    if (kiemtravitribangthongke == 3) {
                        vitribangexcle = (DefaultTableModel) tbsanphamtonthongke.getModel();
                        JFileChooser excelFileChooser = new JFileChooser("C:\\Users\\Admin\\Desktop");
                        excelFileChooser.setDialogTitle("Save as");
                        FileNameExtensionFilter filefilter = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlsm");
                        excelFileChooser.setFileFilter(filefilter);
                        int check = excelFileChooser.showSaveDialog(null);

                        //Check khi ấn nút save
                        if (check == JFileChooser.APPROVE_OPTION) {
                            FileOutputStream FOS = null;
                            BufferedOutputStream BOS = null;
                            XSSFWorkbook excelJtableExporter = null;
                            try {
                                excelJtableExporter = new XSSFWorkbook();
//                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd_MM_yyyy HH:mm:ss");
//                LocalDateTime now = LocalDateTime.now();
                                XSSFSheet excelSheet = excelJtableExporter.createSheet("SẢN PHẨM TRONG KHO");
                                //Lấy số dòng, cột tblHoaDon

                                for (int i = tbsanphamtonthongke.getSelectedRow(); i < tbsanphamtonthongke.getSelectedRow() + tbsanphamtonthongke.getSelectedRowCount(); i++) {
                                    XSSFRow excelRow = excelSheet.createRow(i);
                                    for (int j = 0; j < vitribangexcle.getColumnCount(); j++) {
                                        XSSFCell excelCell = excelRow.createCell(j);

                                        excelCell.setCellValue(vitribangexcle.getValueAt(i, j).toString());
                                    }
                                }

                                FOS = new FileOutputStream(excelFileChooser.getSelectedFile() + ".xlsx");
                                BOS = new BufferedOutputStream(FOS);
                                excelJtableExporter.write(BOS);
                                JOptionPane.showMessageDialog(this, "Xuất Thành Công!!!!");
                            } catch (FileNotFoundException ex) {
                                ex.printStackTrace();
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            } finally {
                                try {
                                    if (BOS != null) {
                                        BOS.close();
                                    }

                                    if (FOS != null) {
                                        FOS.close();
                                    }

                                    if (excelJtableExporter != null) {
                                        excelJtableExporter.close();
                                    }

                                } catch (IOException ex) {
                                    ex.printStackTrace();
                                }
                            }

                        }
                    }

                }
            }
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup1banhang = new javax.swing.ButtonGroup();
        buttonGroup2banhang = new javax.swing.ButtonGroup();
        pn_Tong = new javax.swing.JPanel();
        pn_Menu = new javax.swing.JPanel();
        pl_anh = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        lblHoTenHome = new javax.swing.JLabel();
        lblMaHome = new javax.swing.JLabel();
        pn_Home = new javax.swing.JPanel();
        lblHome = new javax.swing.JLabel();
        pn_SanPham = new javax.swing.JPanel();
        lblSanPham = new javax.swing.JLabel();
        pn_BanHang = new javax.swing.JPanel();
        lblBanHang = new javax.swing.JLabel();
        pn_HoaDon = new javax.swing.JPanel();
        lblHoaDon = new javax.swing.JLabel();
        pn_KhuyenMai = new javax.swing.JPanel();
        lblKhuyenMai = new javax.swing.JLabel();
        pn_NhanVien = new javax.swing.JPanel();
        lblNhanVien = new javax.swing.JLabel();
        pn_ThongTinCaNhan = new javax.swing.JPanel();
        lblThongTinCaNhan = new javax.swing.JLabel();
        pn_KhachHang = new javax.swing.JPanel();
        lblThoat = new javax.swing.JLabel();
        pn_Thoat = new javax.swing.JPanel();
        lblThongKe1 = new javax.swing.JLabel();
        pn_ThongKe = new javax.swing.JPanel();
        lblThongKe = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JLabel();
        txtMa = new javax.swing.JLabel();
        lb_Tendetai = new javax.swing.JLabel();
        pl_FullChucNang = new javax.swing.JPanel();
        pl_home = new javax.swing.JPanel();
        jPanel63 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        pl_khachhang = new javax.swing.JPanel();
        jLabel66 = new javax.swing.JLabel();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jPanel19 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblThongtinKH1 = new javax.swing.JTable();
        jPanel24 = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        txtMaKH1 = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        txtTenKH1 = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        rdonam1 = new javax.swing.JRadioButton();
        rdoNu1 = new javax.swing.JRadioButton();
        jLabel67 = new javax.swing.JLabel();
        txtSDT2 = new javax.swing.JTextField();
        jLabel68 = new javax.swing.JLabel();
        txtEmail1 = new javax.swing.JTextField();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        txtDiachi1 = new javax.swing.JTextArea();
        jdateNgaySinhKH = new com.toedter.calendar.JDateChooser();
        txtFindKH = new javax.swing.JTextField();
        btnFind = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jPanel22 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        txtLichSu = new javax.swing.JTextField();
        btnLichSu = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblLichSu = new javax.swing.JTable();
        jPanel54 = new javax.swing.JPanel();
        txtTimKiemDeleted = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        btnTimKiemKHDeleted = new javax.swing.JButton();
        btnRestoreKH = new javax.swing.JButton();
        jScrollPane12 = new javax.swing.JScrollPane();
        tblThongtinKHDeleted = new javax.swing.JTable();
        pl_sanpham = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblSanPham2 = new javax.swing.JTable();
        txtTimKiemSanPham = new javax.swing.JTextField();
        btnSearchSanPham = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        cbbChip = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        cbbRam = new javax.swing.JComboBox<>();
        cbbPin = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        cbbRom = new javax.swing.JComboBox<>();
        cbbHang = new javax.swing.JComboBox<>();
        cbbMauSac = new javax.swing.JComboBox<>();
        btnDesignChip = new javax.swing.JButton();
        btnDesignMauSac = new javax.swing.JButton();
        btnDesignRam = new javax.swing.JButton();
        btnDesignPin = new javax.swing.JButton();
        btnDesignRom = new javax.swing.JButton();
        btnDesignHang = new javax.swing.JButton();
        pnPaging = new javax.swing.JPanel();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        btnPrevius = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        lblAnhSanPham = new javax.swing.JLabel();
        btnDesignAnh = new javax.swing.JButton();
        jPanel20 = new javax.swing.JPanel();
        btnThemSanPham = new javax.swing.JButton();
        btnSuaSanPham = new javax.swing.JButton();
        btnXoaSanPham = new javax.swing.JButton();
        btnXoaFormSanPham = new javax.swing.JButton();
        jPanel21 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txaMoTa = new javax.swing.JTextArea();
        txtSoLuong = new javax.swing.JTextField();
        btnDesignImei = new javax.swing.JButton();
        txtDonGia = new javax.swing.JTextField();
        txtTenSanPham = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        tblDSImei = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        txtTimKiemSanPhamDeleted = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        btnTimKiemSanPhamDeleted = new javax.swing.JButton();
        jScrollPane18 = new javax.swing.JScrollPane();
        tblSanPhamLuuTru = new javax.swing.JTable();
        btnRestoreSanPham = new javax.swing.JButton();
        pl_banhang = new javax.swing.JPanel();
        panelbanhang = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbbanhhoadonbanhang = new javax.swing.JTable();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbgiohangbanhang = new javax.swing.JTable();
        jLabel29 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tbbangsanphambanhang = new javax.swing.JTable();
        jTextField3 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cbbanhangkhachhang = new javax.swing.JComboBox<>();
        jButton6 = new javax.swing.JButton();
        jPanel28 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        tftongtienhang = new javax.swing.JLabel();
        KM = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        tfkhuyenmai = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tfphaitra = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel53 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tftienkhachdua = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tftienthua = new javax.swing.JLabel();
        lbngaytaovaban = new javax.swing.JLabel();
        tfngaytaovaban = new javax.swing.JLabel();
        rdtienmat = new javax.swing.JRadioButton();
        rdchuyenkhoan = new javax.swing.JRadioButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        pl_hoadon = new javax.swing.JPanel();
        pHoaDon = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        pSanPham = new javax.swing.JPanel();
        jScrollPane14 = new javax.swing.JScrollPane();
        tblSP = new javax.swing.JTable();
        pImei = new javax.swing.JPanel();
        jScrollPane19 = new javax.swing.JScrollPane();
        tblImei = new javax.swing.JTable();
        jLabel58 = new javax.swing.JLabel();
        txtTimKiemHD = new javax.swing.JTextField();
        pLoc = new javax.swing.JPanel();
        jdateFrom = new com.toedter.calendar.JDateChooser();
        jdateTo = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        btnFindHD = new javax.swing.JButton();
        btnExportHD = new javax.swing.JButton();
        btnSortAsc = new javax.swing.JButton();
        btnF5 = new javax.swing.JButton();
        btnSortDesc = new javax.swing.JButton();
        pl_khuyenmai = new javax.swing.JPanel();
        pl_khuyenmai1 = new javax.swing.JPanel();
        pl_khuyenmai5 = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane22 = new javax.swing.JScrollPane();
        tbl_SanPhamGiamGia = new javax.swing.JTable();
        jPanel45 = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();
        txt_TenKM = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        txt_MaGiamGia = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        txt_MucGiam = new javax.swing.JTextField();
        dtc_DenNgay = new com.toedter.calendar.JDateChooser();
        dtc_TuNgay = new com.toedter.calendar.JDateChooser();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jScrollPane21 = new javax.swing.JScrollPane();
        tbl_KhuyenMaiNgungHoatDong = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_KhuyenMai = new javax.swing.JTable();
        jPanel46 = new javax.swing.JPanel();
        bt_addKM = new javax.swing.JButton();
        bt_suaKM = new javax.swing.JButton();
        bt_xoaKM = new javax.swing.JButton();
        jcbox_All = new javax.swing.JCheckBox();
        jdateFrom1 = new com.toedter.calendar.JDateChooser();
        pl_thongtincanhan = new javax.swing.JPanel();
        jPanel40 = new javax.swing.JPanel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel17 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JLabel();
        txtTenNV = new javax.swing.JLabel();
        txtGioiTinh = new javax.swing.JLabel();
        txtChucVu = new javax.swing.JLabel();
        txtEmailttcn = new javax.swing.JLabel();
        txtQueQuanttcn = new javax.swing.JLabel();
        txtNgaySinhttcn = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jPanel34 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        txtMatKhauCu = new javax.swing.JTextField();
        jButton12 = new javax.swing.JButton();
        jLabel52 = new javax.swing.JLabel();
        txtMatKhauMoi = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        txtNhapLai = new javax.swing.JTextField();
        jButton50 = new javax.swing.JButton();
        txtMaXN = new javax.swing.JTextField();
        pl_thongke = new javax.swing.JPanel();
        jPanel52 = new javax.swing.JPanel();
        jPanel35 = new javax.swing.JPanel();
        jPanel36 = new javax.swing.JPanel();
        tftieudetongdonhang = new javax.swing.JLabel();
        tftongdonhang = new javax.swing.JLabel();
        tfdonthanhcong = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jPanel42 = new javax.swing.JPanel();
        jPanel57 = new javax.swing.JPanel();
        tfchitietdonhang = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        tfsoluongsanphambanthongke = new javax.swing.JLabel();
        jPanel41 = new javax.swing.JPanel();
        tftieudetongdoanhthu = new javax.swing.JLabel();
        tfdoanhthu = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jPanel58 = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        tfdondahuy = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        jButton54 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel44 = new javax.swing.JPanel();
        jButton53 = new javax.swing.JButton();
        tfketthucngaythongke = new com.toedter.calendar.JDateChooser();
        jLabel54 = new javax.swing.JLabel();
        tfngaybatdauthongke = new com.toedter.calendar.JDateChooser();
        jLabel34 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel39 = new javax.swing.JPanel();
        jButton13 = new javax.swing.JButton();
        tftimkiemthongke = new javax.swing.JTextField();
        jButton47 = new javax.swing.JButton();
        jButton52 = new javax.swing.JButton();
        jPanel43 = new javax.swing.JPanel();
        jScrollPane20 = new javax.swing.JScrollPane();
        tbbangsanphambanchaynhat = new javax.swing.JTable();
        jPanel37 = new javax.swing.JPanel();
        jScrollPane17 = new javax.swing.JScrollPane();
        tbbangthongke = new javax.swing.JTable();
        tftongdoanhthutimkiem = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jPanel59 = new javax.swing.JPanel();
        jButton56 = new javax.swing.JButton();
        jButton57 = new javax.swing.JButton();
        jButton58 = new javax.swing.JButton();
        tftimkiemsanphamton = new javax.swing.JTextField();
        jPanel60 = new javax.swing.JPanel();
        jScrollPane25 = new javax.swing.JScrollPane();
        tbsanphamtonthongke = new javax.swing.JTable();
        jPanel38 = new javax.swing.JPanel();
        jPanel47 = new javax.swing.JPanel();
        jPanel48 = new javax.swing.JPanel();
        jButton59 = new javax.swing.JButton();
        jButton60 = new javax.swing.JButton();
        jButton61 = new javax.swing.JButton();
        jPanel49 = new javax.swing.JPanel();
        jButton55 = new javax.swing.JButton();
        jPanel50 = new javax.swing.JPanel();
        jScrollPane26 = new javax.swing.JScrollPane();
        tbbangbieudo = new javax.swing.JTable();
        jPanel51 = new javax.swing.JPanel();
        tfOX = new com.toedter.calendar.JDateChooser();
        jLabel81 = new javax.swing.JLabel();
        jPanel61 = new javax.swing.JPanel();
        lbanhbieudo = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        pl_nhanvien = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        btnthem = new javax.swing.JButton();
        btnxoa = new javax.swing.JButton();
        btnhoatdonglai = new javax.swing.JButton();
        btnsua = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnexportEXCEL = new javax.swing.JButton();
        jPanel31 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        txtmanv = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        txttennv = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        txtque = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        txttaikhaon = new javax.swing.JTextField();
        txtmatkhau = new javax.swing.JTextField();
        cbbchucvu = new javax.swing.JComboBox<>();
        rdnam = new javax.swing.JRadioButton();
        rdnu = new javax.swing.JRadioButton();
        jcalendarngaysinh = new com.toedter.calendar.JDateChooser();
        jPanel32 = new javax.swing.JPanel();
        jTextField29 = new javax.swing.JTextField();
        jButton44 = new javax.swing.JButton();
        table = new javax.swing.JTabbedPane();
        jScrollPane7 = new javax.swing.JScrollPane();
        tableluutru = new javax.swing.JTable();
        jScrollPane11 = new javax.swing.JScrollPane();
        tablenv = new javax.swing.JTable();
        jPanel33 = new javax.swing.JPanel();
        lblTenChucNang = new javax.swing.JLabel();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pn_Tong.setBackground(new java.awt.Color(0, 0, 102));
        pn_Tong.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pn_Tong.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                pn_TongAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        pn_Menu.setBackground(new java.awt.Color(0, 0, 102));
        pn_Menu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        pl_anh.setBackground(new java.awt.Color(0, 0, 102));

        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logoSmartphone.png"))); // NOI18N

        javax.swing.GroupLayout pl_anhLayout = new javax.swing.GroupLayout(pl_anh);
        pl_anh.setLayout(pl_anhLayout);
        pl_anhLayout.setHorizontalGroup(
            pl_anhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pl_anhLayout.setVerticalGroup(
            pl_anhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
        );

        lblHoTenHome.setForeground(new java.awt.Color(255, 255, 255));
        lblHoTenHome.setText("Họ và tên");

        lblMaHome.setForeground(new java.awt.Color(255, 255, 255));
        lblMaHome.setText("Mã");

        pn_Home.setBackground(new java.awt.Color(0, 0, 102));
        pn_Home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pn_HomeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pn_HomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pn_HomeMouseExited(evt);
            }
        });

        lblHome.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblHome.setForeground(new java.awt.Color(255, 255, 255));
        lblHome.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home.png"))); // NOI18N
        lblHome.setText("TRANG CHỦ");
        lblHome.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout pn_HomeLayout = new javax.swing.GroupLayout(pn_Home);
        pn_Home.setLayout(pn_HomeLayout);
        pn_HomeLayout.setHorizontalGroup(
            pn_HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_HomeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pn_HomeLayout.setVerticalGroup(
            pn_HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_HomeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHome)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pn_SanPham.setBackground(new java.awt.Color(0, 0, 102));
        pn_SanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pn_SanPhamMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pn_SanPhamMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pn_SanPhamMouseExited(evt);
            }
        });

        lblSanPham.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblSanPham.setForeground(new java.awt.Color(255, 255, 255));
        lblSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/smartphone.png"))); // NOI18N
        lblSanPham.setText("SẢN PHẨM");

        javax.swing.GroupLayout pn_SanPhamLayout = new javax.swing.GroupLayout(pn_SanPham);
        pn_SanPham.setLayout(pn_SanPhamLayout);
        pn_SanPhamLayout.setHorizontalGroup(
            pn_SanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_SanPhamLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pn_SanPhamLayout.setVerticalGroup(
            pn_SanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_SanPhamLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblSanPham)
                .addContainerGap())
        );

        pn_BanHang.setBackground(new java.awt.Color(0, 0, 102));
        pn_BanHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pn_BanHangMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pn_BanHangMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pn_BanHangMouseExited(evt);
            }
        });

        lblBanHang.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblBanHang.setForeground(new java.awt.Color(255, 255, 255));
        lblBanHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/shopping-cart.png"))); // NOI18N
        lblBanHang.setText("BÁN HÀNG");

        javax.swing.GroupLayout pn_BanHangLayout = new javax.swing.GroupLayout(pn_BanHang);
        pn_BanHang.setLayout(pn_BanHangLayout);
        pn_BanHangLayout.setHorizontalGroup(
            pn_BanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_BanHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pn_BanHangLayout.setVerticalGroup(
            pn_BanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_BanHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBanHang)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pn_HoaDon.setBackground(new java.awt.Color(0, 0, 102));
        pn_HoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pn_HoaDonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pn_HoaDonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pn_HoaDonMouseExited(evt);
            }
        });

        lblHoaDon.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        lblHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/invoice.png"))); // NOI18N
        lblHoaDon.setText("HÓA ĐƠN");

        javax.swing.GroupLayout pn_HoaDonLayout = new javax.swing.GroupLayout(pn_HoaDon);
        pn_HoaDon.setLayout(pn_HoaDonLayout);
        pn_HoaDonLayout.setHorizontalGroup(
            pn_HoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_HoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pn_HoaDonLayout.setVerticalGroup(
            pn_HoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_HoaDonLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblHoaDon)
                .addContainerGap())
        );

        pn_KhuyenMai.setBackground(new java.awt.Color(0, 0, 102));
        pn_KhuyenMai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pn_KhuyenMaiMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pn_KhuyenMaiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pn_KhuyenMaiMouseExited(evt);
            }
        });

        lblKhuyenMai.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblKhuyenMai.setForeground(new java.awt.Color(255, 255, 255));
        lblKhuyenMai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/discount.png"))); // NOI18N
        lblKhuyenMai.setText("KHUYẾN MÃI");

        javax.swing.GroupLayout pn_KhuyenMaiLayout = new javax.swing.GroupLayout(pn_KhuyenMai);
        pn_KhuyenMai.setLayout(pn_KhuyenMaiLayout);
        pn_KhuyenMaiLayout.setHorizontalGroup(
            pn_KhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_KhuyenMaiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pn_KhuyenMaiLayout.setVerticalGroup(
            pn_KhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_KhuyenMaiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblKhuyenMai)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pn_NhanVien.setBackground(new java.awt.Color(0, 0, 102));
        pn_NhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pn_NhanVienMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pn_NhanVienMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pn_NhanVienMouseExited(evt);
            }
        });

        lblNhanVien.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        lblNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/staff.png"))); // NOI18N
        lblNhanVien.setText("NHÂN VIÊN");

        javax.swing.GroupLayout pn_NhanVienLayout = new javax.swing.GroupLayout(pn_NhanVien);
        pn_NhanVien.setLayout(pn_NhanVienLayout);
        pn_NhanVienLayout.setHorizontalGroup(
            pn_NhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_NhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pn_NhanVienLayout.setVerticalGroup(
            pn_NhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_NhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNhanVien)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pn_ThongTinCaNhan.setBackground(new java.awt.Color(0, 0, 102));
        pn_ThongTinCaNhan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pn_ThongTinCaNhanMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pn_ThongTinCaNhanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pn_ThongTinCaNhanMouseExited(evt);
            }
        });

        lblThongTinCaNhan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblThongTinCaNhan.setForeground(new java.awt.Color(255, 255, 255));
        lblThongTinCaNhan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user.png"))); // NOI18N
        lblThongTinCaNhan.setText("THÔNG TIN CÁ NHÂN");

        javax.swing.GroupLayout pn_ThongTinCaNhanLayout = new javax.swing.GroupLayout(pn_ThongTinCaNhan);
        pn_ThongTinCaNhan.setLayout(pn_ThongTinCaNhanLayout);
        pn_ThongTinCaNhanLayout.setHorizontalGroup(
            pn_ThongTinCaNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_ThongTinCaNhanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblThongTinCaNhan)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pn_ThongTinCaNhanLayout.setVerticalGroup(
            pn_ThongTinCaNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_ThongTinCaNhanLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblThongTinCaNhan)
                .addContainerGap())
        );

        pn_KhachHang.setBackground(new java.awt.Color(0, 0, 102));
        pn_KhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pn_KhachHangMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pn_KhachHangMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pn_KhachHangMouseExited(evt);
            }
        });

        lblThoat.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblThoat.setForeground(new java.awt.Color(255, 255, 255));
        lblThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/customer.png"))); // NOI18N
        lblThoat.setText("KHÁCH HÀNG");

        javax.swing.GroupLayout pn_KhachHangLayout = new javax.swing.GroupLayout(pn_KhachHang);
        pn_KhachHang.setLayout(pn_KhachHangLayout);
        pn_KhachHangLayout.setHorizontalGroup(
            pn_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_KhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pn_KhachHangLayout.setVerticalGroup(
            pn_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_KhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblThoat)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pn_Thoat.setBackground(new java.awt.Color(0, 0, 102));
        pn_Thoat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pn_ThoatMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pn_ThoatMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pn_ThoatMouseExited(evt);
            }
        });

        lblThongKe1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblThongKe1.setForeground(new java.awt.Color(255, 255, 255));
        lblThongKe1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.png"))); // NOI18N
        lblThongKe1.setText("THOÁT");

        javax.swing.GroupLayout pn_ThoatLayout = new javax.swing.GroupLayout(pn_Thoat);
        pn_Thoat.setLayout(pn_ThoatLayout);
        pn_ThoatLayout.setHorizontalGroup(
            pn_ThoatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_ThoatLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblThongKe1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pn_ThoatLayout.setVerticalGroup(
            pn_ThoatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_ThoatLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblThongKe1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pn_ThongKe.setBackground(new java.awt.Color(0, 0, 102));
        pn_ThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pn_ThongKeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pn_ThongKeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pn_ThongKeMouseExited(evt);
            }
        });

        lblThongKe.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblThongKe.setForeground(new java.awt.Color(255, 255, 255));
        lblThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/trend.png"))); // NOI18N
        lblThongKe.setText("THỐNG KÊ");

        javax.swing.GroupLayout pn_ThongKeLayout = new javax.swing.GroupLayout(pn_ThongKe);
        pn_ThongKe.setLayout(pn_ThongKeLayout);
        pn_ThongKeLayout.setHorizontalGroup(
            pn_ThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_ThongKeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pn_ThongKeLayout.setVerticalGroup(
            pn_ThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_ThongKeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblThongKe)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtHoTen.setForeground(new java.awt.Color(255, 255, 255));
        txtHoTen.setText("Họ và tên");

        txtMa.setForeground(new java.awt.Color(255, 255, 255));
        txtMa.setText("Mã nhân vien");

        javax.swing.GroupLayout pn_MenuLayout = new javax.swing.GroupLayout(pn_Menu);
        pn_Menu.setLayout(pn_MenuLayout);
        pn_MenuLayout.setHorizontalGroup(
            pn_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_MenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pl_anh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pn_Thoat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pn_ThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pn_MenuLayout.createSequentialGroup()
                        .addGroup(pn_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pn_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(pn_KhachHang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pn_Home, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pn_SanPham, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pn_BanHang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pn_HoaDon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pn_KhuyenMai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pn_NhanVien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pn_ThongTinCaNhan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(pn_MenuLayout.createSequentialGroup()
                                .addComponent(lblHoTenHome)
                                .addGap(18, 18, 18)
                                .addComponent(txtHoTen))
                            .addGroup(pn_MenuLayout.createSequentialGroup()
                                .addComponent(lblMaHome)
                                .addGap(52, 52, 52)
                                .addComponent(txtMa)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pn_MenuLayout.setVerticalGroup(
            pn_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_MenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pl_anh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHoTenHome)
                    .addComponent(txtHoTen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaHome)
                    .addComponent(txtMa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pn_Home, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pn_SanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pn_BanHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pn_HoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pn_KhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pn_NhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pn_ThongTinCaNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pn_KhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_ThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(pn_Thoat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lb_Tendetai.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        lb_Tendetai.setForeground(new java.awt.Color(255, 255, 255));
        lb_Tendetai.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_Tendetai.setText("NHÓM 5: PHẦN MỀM BÁN ĐIỆN THOẠI");

        pl_FullChucNang.setBackground(new java.awt.Color(255, 255, 102));
        pl_FullChucNang.setVerifyInputWhenFocusTarget(false);
        pl_FullChucNang.setLayout(new java.awt.CardLayout());

        pl_home.setBackground(new java.awt.Color(255, 255, 255));

        jPanel63.setBackground(new java.awt.Color(255, 255, 255));
        jPanel63.setForeground(new java.awt.Color(0, 0, 102));

        jLabel26.setBackground(new java.awt.Color(0, 102, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/welcome.png"))); // NOI18N

        javax.swing.GroupLayout jPanel63Layout = new javax.swing.GroupLayout(jPanel63);
        jPanel63.setLayout(jPanel63Layout);
        jPanel63Layout.setHorizontalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel63Layout.createSequentialGroup()
                .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 1277, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel63Layout.setVerticalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pl_homeLayout = new javax.swing.GroupLayout(pl_home);
        pl_home.setLayout(pl_homeLayout);
        pl_homeLayout.setHorizontalGroup(
            pl_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pl_homeLayout.createSequentialGroup()
                .addComponent(jPanel63, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 24, Short.MAX_VALUE))
        );
        pl_homeLayout.setVerticalGroup(
            pl_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pl_homeLayout.createSequentialGroup()
                .addComponent(jPanel63, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pl_FullChucNang.add(pl_home, "card4");

        pl_khachhang.setBackground(new java.awt.Color(255, 255, 255));
        pl_khachhang.setRequestFocusEnabled(false);

        jTabbedPane5.setForeground(new java.awt.Color(0, 0, 102));
        jTabbedPane5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin khách hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 102))); // NOI18N

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));

        tblThongtinKH1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblThongtinKH1.setForeground(new java.awt.Color(0, 0, 102));
        tblThongtinKH1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã KH", "Tên KH", "SĐT", "Email", "Giới tính", "Ngày sinh", "Địa chỉ", "Ngày tạo", "Số lần mua"
            }
        ));
        tblThongtinKH1.setGridColor(new java.awt.Color(51, 0, 102));
        tblThongtinKH1.setSelectionBackground(new java.awt.Color(255, 0, 51));
        tblThongtinKH1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblThongtinKH1MouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(tblThongtinKH1);
        if (tblThongtinKH1.getColumnModel().getColumnCount() > 0) {
            tblThongtinKH1.getColumnModel().getColumn(8).setHeaderValue("Số lần mua");
        }

        jPanel24.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thiết lập thông tin khách hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 102))); // NOI18N
        jPanel24.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(0, 0, 102));
        jLabel37.setText("Mã khách hàng");

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(0, 0, 102));
        jLabel38.setText("Tên khách hàng");

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(0, 0, 102));
        jLabel39.setText("Giới tính");

        buttonGroup2.add(rdonam1);
        rdonam1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rdonam1.setForeground(new java.awt.Color(0, 0, 102));
        rdonam1.setText("Nam");

        buttonGroup2.add(rdoNu1);
        rdoNu1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rdoNu1.setForeground(new java.awt.Color(0, 0, 102));
        rdoNu1.setText("Nữ");

        jLabel67.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(0, 0, 102));
        jLabel67.setText("SDT");

        jLabel68.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(0, 0, 102));
        jLabel68.setText("Email");

        txtEmail1.setMinimumSize(new java.awt.Dimension(64, 32));

        jLabel69.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(0, 0, 102));
        jLabel69.setText("Ngày sinh");

        jLabel70.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(0, 0, 102));
        jLabel70.setText("Địa chỉ");

        txtDiachi1.setColumns(20);
        txtDiachi1.setRows(5);
        jScrollPane10.setViewportView(txtDiachi1);

        jdateNgaySinhKH.setDateFormatString("dd-MM-yyyy");

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenKH1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaKH1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel69, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel68, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtEmail1, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                            .addComponent(jdateNgaySinhKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(txtSDT2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdonam1)
                        .addGap(53, 53, 53)
                        .addComponent(rdoNu1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addComponent(jLabel70)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEmail1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel37)
                        .addComponent(txtMaKH1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel68)
                        .addComponent(jLabel70)))
                .addGap(18, 18, 18)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel38)
                        .addComponent(jLabel69)
                        .addComponent(txtTenKH1, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                    .addComponent(jdateNgaySinhKH, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel39)
                        .addComponent(rdonam1)
                        .addComponent(rdoNu1))
                    .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSDT2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel67)))
                .addGap(57, 57, 57))
        );

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        btnFind.setBackground(new java.awt.Color(0, 0, 102));
        btnFind.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(0, 0, 102));
        jLabel35.setText("Tìm kiếm");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1068, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 42, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 1068, Short.MAX_VALUE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel35)
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addComponent(txtFindKH, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFindKH, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel27.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức năng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 0, 102))); // NOI18N

        jButton9.setBackground(new java.awt.Color(0, 0, 102));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton9MouseClicked(evt);
            }
        });
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(0, 0, 102));
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/update.png"))); // NOI18N
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setBackground(new java.awt.Color(0, 0, 102));
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton15.setBackground(new java.awt.Color(0, 0, 102));
        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/reset.png"))); // NOI18N
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                    .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(jButton9)
                .addGap(18, 18, 18)
                .addComponent(jButton10)
                .addGap(18, 18, 18)
                .addComponent(jButton11)
                .addGap(18, 18, 18)
                .addComponent(jButton15)
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 200, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Khách hàng", jPanel19);

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(0, 0, 102));
        jLabel36.setText("Tìm kiếm");

        btnLichSu.setBackground(new java.awt.Color(0, 0, 102));
        btnLichSu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        btnLichSu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLichSuActionPerformed(evt);
            }
        });

        tblLichSu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã KH", "Tên KH", "Mã HĐ", "Tổng Tiền", "Ngày Tạo"
            }
        ));
        jScrollPane6.setViewportView(tblLichSu);

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 1314, Short.MAX_VALUE)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel36)
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addComponent(txtLichSu, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnLichSu, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel36)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLichSu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLichSu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(306, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Lịch sử mua hàng", jPanel22);

        txtTimKiemDeleted.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtTimKiemDeleted.setForeground(new java.awt.Color(0, 0, 102));

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(0, 0, 102));
        jLabel50.setText("Tìm Kiếm");

        btnTimKiemKHDeleted.setBackground(new java.awt.Color(0, 0, 102));
        btnTimKiemKHDeleted.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        btnTimKiemKHDeleted.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemKHDeletedActionPerformed(evt);
            }
        });

        btnRestoreKH.setBackground(new java.awt.Color(0, 0, 102));
        btnRestoreKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/restore.png"))); // NOI18N
        btnRestoreKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestoreKHActionPerformed(evt);
            }
        });

        tblThongtinKHDeleted.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblThongtinKHDeleted.setForeground(new java.awt.Color(0, 0, 102));
        tblThongtinKHDeleted.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã KH", "Tên KH", "SĐT", "Email", "Giới tính", "Ngày sinh", "Địa chỉ", "Ngày tạo"
            }
        ));
        tblThongtinKHDeleted.setGridColor(new java.awt.Color(51, 0, 102));
        tblThongtinKHDeleted.setSelectionBackground(new java.awt.Color(255, 0, 51));
        tblThongtinKHDeleted.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblThongtinKHDeletedMouseClicked(evt);
            }
        });
        jScrollPane12.setViewportView(tblThongtinKHDeleted);

        javax.swing.GroupLayout jPanel54Layout = new javax.swing.GroupLayout(jPanel54);
        jPanel54.setLayout(jPanel54Layout);
        jPanel54Layout.setHorizontalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel54Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel54Layout.createSequentialGroup()
                        .addComponent(txtTimKiemDeleted, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnTimKiemKHDeleted, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRestoreKH, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel54Layout.createSequentialGroup()
                        .addComponent(jLabel50)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1232, Short.MAX_VALUE))
                .addGap(82, 82, 82))
        );
        jPanel54Layout.setVerticalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel54Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel50)
                    .addGroup(jPanel54Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTimKiemDeleted)
                            .addComponent(btnTimKiemKHDeleted, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)))
                    .addComponent(btnRestoreKH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(299, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Lưu Trữ", jPanel54);

        javax.swing.GroupLayout pl_khachhangLayout = new javax.swing.GroupLayout(pl_khachhang);
        pl_khachhang.setLayout(pl_khachhangLayout);
        pl_khachhangLayout.setHorizontalGroup(
            pl_khachhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pl_khachhangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 1343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(247, 247, 247)
                .addComponent(jLabel66)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pl_khachhangLayout.setVerticalGroup(
            pl_khachhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pl_khachhangLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(pl_khachhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel66))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pl_FullChucNang.add(pl_khachhang, "home");

        pl_sanpham.setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102)));
        jTabbedPane1.setForeground(new java.awt.Color(0, 0, 102));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sản Phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 102))); // NOI18N

        tblSanPham2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblSanPham2.setForeground(new java.awt.Color(0, 0, 102));
        tblSanPham2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Tên SP", "Hãng", "Chip", "Ram", "Rom", "Pin", "Màu sắc", "Số lượng", "Mô tả", "Đơn giá"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSanPham2.setGridColor(new java.awt.Color(0, 0, 102));
        tblSanPham2.setSelectionBackground(new java.awt.Color(255, 0, 51));
        tblSanPham2.setUpdateSelectionOnSort(false);
        tblSanPham2.setVerifyInputWhenFocusTarget(false);
        tblSanPham2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPham2MouseClicked1(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblSanPham2MouseEntered(evt);
            }
        });
        jScrollPane4.setViewportView(tblSanPham2);
        if (tblSanPham2.getColumnModel().getColumnCount() > 0) {
            tblSanPham2.getColumnModel().getColumn(0).setResizable(false);
            tblSanPham2.getColumnModel().getColumn(1).setResizable(false);
            tblSanPham2.getColumnModel().getColumn(2).setResizable(false);
            tblSanPham2.getColumnModel().getColumn(3).setResizable(false);
            tblSanPham2.getColumnModel().getColumn(4).setResizable(false);
            tblSanPham2.getColumnModel().getColumn(5).setResizable(false);
            tblSanPham2.getColumnModel().getColumn(6).setResizable(false);
            tblSanPham2.getColumnModel().getColumn(7).setResizable(false);
            tblSanPham2.getColumnModel().getColumn(8).setResizable(false);
            tblSanPham2.getColumnModel().getColumn(9).setResizable(false);
        }

        txtTimKiemSanPham.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtTimKiemSanPham.setForeground(new java.awt.Color(0, 0, 102));

        btnSearchSanPham.setBackground(new java.awt.Color(0, 0, 102));
        btnSearchSanPham.setForeground(new java.awt.Color(0, 0, 102));
        btnSearchSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        btnSearchSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchSanPhamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 783, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtTimKiemSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSearchSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTimKiemSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchSanPham))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin Sản Phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 102))); // NOI18N
        jPanel10.setForeground(new java.awt.Color(0, 0, 102));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 102));
        jLabel15.setText("Chip");

        cbbChip.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbbChip.setForeground(new java.awt.Color(0, 0, 102));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 102));
        jLabel17.setText("Ram");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 102));
        jLabel18.setText("Pin");

        cbbRam.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbbRam.setForeground(new java.awt.Color(0, 0, 102));

        cbbPin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbbPin.setForeground(new java.awt.Color(0, 0, 102));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 102));
        jLabel19.setText("Rom");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 102));
        jLabel21.setText("Hãng");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 102));
        jLabel22.setText("Màu Sắc");

        cbbRom.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbbRom.setForeground(new java.awt.Color(0, 0, 102));

        cbbHang.setForeground(new java.awt.Color(0, 0, 102));

        cbbMauSac.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbbMauSac.setForeground(new java.awt.Color(0, 0, 102));

        btnDesignChip.setBackground(new java.awt.Color(0, 0, 102));
        btnDesignChip.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        btnDesignChip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesignChipActionPerformed(evt);
            }
        });

        btnDesignMauSac.setBackground(new java.awt.Color(0, 0, 102));
        btnDesignMauSac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        btnDesignMauSac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesignMauSacActionPerformed(evt);
            }
        });

        btnDesignRam.setBackground(new java.awt.Color(0, 0, 102));
        btnDesignRam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        btnDesignRam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesignRamActionPerformed(evt);
            }
        });

        btnDesignPin.setBackground(new java.awt.Color(0, 0, 102));
        btnDesignPin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        btnDesignPin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesignPinActionPerformed(evt);
            }
        });

        btnDesignRom.setBackground(new java.awt.Color(0, 0, 102));
        btnDesignRom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        btnDesignRom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesignRomActionPerformed(evt);
            }
        });

        btnDesignHang.setBackground(new java.awt.Color(0, 0, 102));
        btnDesignHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        btnDesignHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesignHangActionPerformed(evt);
            }
        });

        pnPaging.setBackground(new java.awt.Color(255, 255, 255));

        btnNext.setBackground(new java.awt.Color(0, 0, 102));
        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/next.png"))); // NOI18N
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnLast.setBackground(new java.awt.Color(0, 0, 102));
        btnLast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/last.png"))); // NOI18N
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        btnFirst.setBackground(new java.awt.Color(0, 0, 102));
        btnFirst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/first.png"))); // NOI18N
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnPrevius.setBackground(new java.awt.Color(0, 0, 102));
        btnPrevius.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/previus.png"))); // NOI18N
        btnPrevius.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnPagingLayout = new javax.swing.GroupLayout(pnPaging);
        pnPaging.setLayout(pnPagingLayout);
        pnPagingLayout.setHorizontalGroup(
            pnPagingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPagingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(113, 113, 113)
                .addComponent(btnPrevius, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103)
                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnPagingLayout.setVerticalGroup(
            pnPagingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPagingLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnPagingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPrevius)
                    .addComponent(btnFirst)
                    .addComponent(btnNext)
                    .addComponent(btnLast))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnPaging, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cbbRom, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDesignRom, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cbbChip, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDesignChip, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbbRam, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDesignRam, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDesignHang, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbHang, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(124, 124, 124)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnDesignMauSac, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                        .addComponent(cbbMauSac, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbbPin, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDesignPin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel17)
                    .addComponent(jLabel15))
                .addGap(5, 5, 5)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbChip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbRam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbPin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDesignPin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDesignRam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDesignChip, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(67, 67, 67)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel22))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbbRom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbbMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDesignMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnDesignRom, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(7, 7, 7)
                        .addComponent(cbbHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDesignHang)))
                .addGap(40, 40, 40)
                .addComponent(pnPaging, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bảng Sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 102))); // NOI18N

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder("Ảnh"));

        lblAnhSanPham.setBackground(new java.awt.Color(255, 255, 255));
        lblAnhSanPham.setPreferredSize(new java.awt.Dimension(43, 16));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblAnhSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(lblAnhSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 5, Short.MAX_VALUE))
        );

        btnDesignAnh.setBackground(new java.awt.Color(0, 0, 102));
        btnDesignAnh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        btnDesignAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesignAnhActionPerformed(evt);
            }
        });

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));

        btnThemSanPham.setBackground(new java.awt.Color(0, 0, 102));
        btnThemSanPham.setForeground(new java.awt.Color(0, 0, 102));
        btnThemSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        btnThemSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemSanPhamMouseClicked(evt);
            }
        });
        btnThemSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSanPhamActionPerformed(evt);
            }
        });

        btnSuaSanPham.setBackground(new java.awt.Color(0, 0, 102));
        btnSuaSanPham.setForeground(new java.awt.Color(0, 0, 102));
        btnSuaSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/update.png"))); // NOI18N
        btnSuaSanPham.setEnabled(false);
        btnSuaSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaSanPhamActionPerformed(evt);
            }
        });

        btnXoaSanPham.setBackground(new java.awt.Color(0, 0, 102));
        btnXoaSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        btnXoaSanPham.setEnabled(false);
        btnXoaSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaSanPhamActionPerformed(evt);
            }
        });

        btnXoaFormSanPham.setBackground(new java.awt.Color(0, 0, 102));
        btnXoaFormSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/reset.png"))); // NOI18N
        btnXoaFormSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaFormSanPhamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThemSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSuaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(btnXoaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnXoaFormSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnXoaFormSanPham)
                    .addComponent(btnXoaSanPham)
                    .addComponent(btnSuaSanPham)
                    .addComponent(btnThemSanPham))
                .addContainerGap())
        );

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));

        txaMoTa.setColumns(20);
        txaMoTa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txaMoTa.setForeground(new java.awt.Color(0, 0, 102));
        txaMoTa.setRows(5);
        jScrollPane5.setViewportView(txaMoTa);

        txtSoLuong.setEditable(false);
        txtSoLuong.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtSoLuong.setForeground(new java.awt.Color(0, 0, 102));

        btnDesignImei.setBackground(new java.awt.Color(0, 0, 102));
        btnDesignImei.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        btnDesignImei.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesignImeiActionPerformed(evt);
            }
        });

        txtDonGia.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtDonGia.setForeground(new java.awt.Color(0, 0, 102));
        txtDonGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDonGiaActionPerformed(evt);
            }
        });

        txtTenSanPham.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtTenSanPham.setForeground(new java.awt.Color(0, 0, 102));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 102));
        jLabel11.setText("Tên Sản Phẩm");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 102));
        jLabel12.setText("Đơn giá");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 102));
        jLabel13.setText("DS imei");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 102));
        jLabel16.setText("Số lượng");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 102));
        jLabel14.setText("Mô Tả :");

        tblDSImei.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblDSImei.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Imei"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSImei.setGridColor(new java.awt.Color(0, 0, 102));
        tblDSImei.setSelectionBackground(new java.awt.Color(255, 0, 51));
        tblDSImei.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSImeiMouseClicked(evt);
            }
        });
        jScrollPane15.setViewportView(tblDSImei);
        if (tblDSImei.getColumnModel().getColumnCount() > 0) {
            tblDSImei.getColumnModel().getColumn(0).setResizable(false);
        }

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(254, 254, 254))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel21Layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDonGia))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel21Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(92, 92, 92))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel21Layout.createSequentialGroup()
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(btnDesignImei, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(btnDesignImei)
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
            .addComponent(jPanel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDesignAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(95, 95, 95))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDesignAnh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Sản Phẩm", jPanel7);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setAutoscrolls(true);

        txtTimKiemSanPhamDeleted.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtTimKiemSanPhamDeleted.setForeground(new java.awt.Color(0, 0, 102));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 102));
        jLabel20.setText("Tìm Kiếm");

        btnTimKiemSanPhamDeleted.setBackground(new java.awt.Color(0, 0, 102));
        btnTimKiemSanPhamDeleted.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        btnTimKiemSanPhamDeleted.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemSanPhamDeletedActionPerformed(evt);
            }
        });

        tblSanPhamLuuTru.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblSanPhamLuuTru.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên SP", "Đơn giá", "Mô tả", "Ảnh", "Màu Sắc", "Hãng", "Chip", "Ram", "Rom", "Pin", "Số Lượng", "Ngày Xóa"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSanPhamLuuTru.setGridColor(new java.awt.Color(0, 0, 102));
        tblSanPhamLuuTru.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamLuuTruMouseClicked(evt);
            }
        });
        jScrollPane18.setViewportView(tblSanPhamLuuTru);
        if (tblSanPhamLuuTru.getColumnModel().getColumnCount() > 0) {
            tblSanPhamLuuTru.getColumnModel().getColumn(0).setResizable(false);
            tblSanPhamLuuTru.getColumnModel().getColumn(1).setResizable(false);
            tblSanPhamLuuTru.getColumnModel().getColumn(2).setResizable(false);
            tblSanPhamLuuTru.getColumnModel().getColumn(3).setResizable(false);
            tblSanPhamLuuTru.getColumnModel().getColumn(4).setResizable(false);
            tblSanPhamLuuTru.getColumnModel().getColumn(5).setResizable(false);
            tblSanPhamLuuTru.getColumnModel().getColumn(6).setResizable(false);
            tblSanPhamLuuTru.getColumnModel().getColumn(7).setResizable(false);
            tblSanPhamLuuTru.getColumnModel().getColumn(8).setResizable(false);
            tblSanPhamLuuTru.getColumnModel().getColumn(9).setResizable(false);
            tblSanPhamLuuTru.getColumnModel().getColumn(10).setResizable(false);
            tblSanPhamLuuTru.getColumnModel().getColumn(11).setResizable(false);
        }

        btnRestoreSanPham.setBackground(new java.awt.Color(0, 0, 102));
        btnRestoreSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/restore.png"))); // NOI18N
        btnRestoreSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestoreSanPhamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane18, javax.swing.GroupLayout.DEFAULT_SIZE, 1220, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(txtTimKiemSanPhamDeleted, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnTimKiemSanPhamDeleted, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRestoreSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRestoreSanPham))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnTimKiemSanPhamDeleted, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTimKiemSanPhamDeleted))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(172, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Lưu Trữ", jPanel8);

        javax.swing.GroupLayout pl_sanphamLayout = new javax.swing.GroupLayout(pl_sanpham);
        pl_sanpham.setLayout(pl_sanphamLayout);
        pl_sanphamLayout.setHorizontalGroup(
            pl_sanphamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pl_sanphamLayout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 62, Short.MAX_VALUE))
        );
        pl_sanphamLayout.setVerticalGroup(
            pl_sanphamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pl_FullChucNang.add(pl_sanpham, "sanpham");

        pl_banhang.setBackground(new java.awt.Color(255, 255, 255));

        panelbanhang.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "HÓA ĐƠN", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        tbbanhhoadonbanhang.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tbbanhhoadonbanhang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "MÃ HÓA ĐƠN", "TÊN NHÂN VIÊN", "TÊN KHÁCH HÀNG", "TRẠNG THÁI"
            }
        ));
        tbbanhhoadonbanhang.setGridColor(new java.awt.Color(0, 0, 102));
        tbbanhhoadonbanhang.setSelectionBackground(new java.awt.Color(255, 0, 51));
        tbbanhhoadonbanhang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbbanhhoadonbanhangMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tbbanhhoadonbanhangMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(tbbanhhoadonbanhang);

        buttonGroup2banhang.add(jRadioButton3);
        jRadioButton3.setText("Tất cả");

        jRadioButton2.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2banhang.add(jRadioButton2);
        jRadioButton2.setText("Chờ thanh toán");

        jRadioButton1.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2banhang.add(jRadioButton1);
        jRadioButton1.setText("Đã thanh toán");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jRadioButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Giỏ Hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        tbgiohangbanhang.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tbgiohangbanhang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "MÃ SẢN PHẨM", "TÊN SẢN PHẨM", "SỐ LƯỢNG", "ĐƠN GIÁ", "THÀNH TIỀN"
            }
        ));
        tbgiohangbanhang.setGridColor(new java.awt.Color(0, 0, 102));
        tbgiohangbanhang.setSelectionBackground(new java.awt.Color(255, 0, 51));
        tbgiohangbanhang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbgiohangbanhangMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbgiohangbanhang);

        jLabel29.setText("Giỏ hàng");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sản Phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        tbbangsanphambanhang.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tbbangsanphambanhang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "MÃ SẢN PHẨM", "TÊN SẢN PHẨM", "SỐ LƯỢNG", "ĐƠN GIÁ"
            }
        ));
        tbbangsanphambanhang.setGridColor(new java.awt.Color(0, 0, 102));
        tbbangsanphambanhang.setSelectionBackground(new java.awt.Color(255, 0, 51));
        tbbangsanphambanhang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbbangsanphambanhangMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tbbangsanphambanhang);

        jButton5.setBackground(new java.awt.Color(0, 0, 102));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "BÁN HÀNG", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder("KHÁCH HÀNG"));

        jLabel4.setText(" khách hàng       :");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        cbbanhangkhachhang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbanhangkhachhang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbanhangkhachhangMouseClicked(evt);
            }
        });
        cbbanhangkhachhang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbanhangkhachhangActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(0, 0, 102));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/customer.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbbanhangkhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbanhangkhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel28.setBackground(new java.awt.Color(255, 255, 255));
        jPanel28.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin đơn hàng"));

        jLabel5.setText("Tổng tiền hàng:");

        tftongtienhang.setText("0.0");

        KM.setBackground(new java.awt.Color(0, 0, 102));
        KM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/option.png"))); // NOI18N
        KM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KMActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("%");

        tfkhuyenmai.setText("0.0");

        jLabel7.setText("Khuyến mãi      :");

        tfphaitra.setText("0.0");

        jLabel8.setText(" Phải trả            :");

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addComponent(tfkhuyenmai, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(KM, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tfphaitra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tftongtienhang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tftongtienhang, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                        .addComponent(KM, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tfkhuyenmai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfphaitra, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel53.setBackground(new java.awt.Color(255, 255, 255));
        jPanel53.setBorder(javax.swing.BorderFactory.createTitledBorder("Hình thức thanh toán"));

        jLabel1.setText("Loại thanh toán   :");

        tftienkhachdua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tftienkhachduaActionPerformed(evt);
            }
        });

        jLabel9.setText("Tiền khách đưa    :");

        jLabel10.setText("Tiền thừa             :");

        tftienthua.setText("0");

        lbngaytaovaban.setText("Ngày thanh toán :");

        tfngaytaovaban.setText("dd-MM-yyyy");

        buttonGroup1banhang.add(rdtienmat);
        rdtienmat.setText("Tiền mặt");
        rdtienmat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdtienmatMouseClicked(evt);
            }
        });
        rdtienmat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdtienmatActionPerformed(evt);
            }
        });

        buttonGroup1banhang.add(rdchuyenkhoan);
        rdchuyenkhoan.setText("chuyển khoản");
        rdchuyenkhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdchuyenkhoanMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel53Layout = new javax.swing.GroupLayout(jPanel53);
        jPanel53.setLayout(jPanel53Layout);
        jPanel53Layout.setHorizontalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel53Layout.createSequentialGroup()
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel53Layout.createSequentialGroup()
                        .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel53Layout.createSequentialGroup()
                                .addComponent(rdtienmat)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rdchuyenkhoan))
                            .addComponent(tftienkhachdua)))
                    .addGroup(jPanel53Layout.createSequentialGroup()
                        .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                            .addComponent(lbngaytaovaban, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tftienthua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfngaytaovaban, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel53Layout.setVerticalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel53Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel53Layout.createSequentialGroup()
                        .addComponent(rdchuyenkhoan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tftienkhachdua, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tftienthua, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel53Layout.createSequentialGroup()
                        .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdtienmat))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfngaytaovaban, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(lbngaytaovaban, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("QR"));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CHỨC NĂNG", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jButton8.setBackground(new java.awt.Color(0, 0, 102));
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        jButton8.setText("Tạo Hóa đơn");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton14.setBackground(new java.awt.Color(0, 0, 102));
        jButton14.setForeground(new java.awt.Color(255, 255, 255));
        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pay.png"))); // NOI18N
        jButton14.setText("Thanh Toán");
        jButton14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton14MouseClicked(evt);
            }
        });
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton16.setBackground(new java.awt.Color(0, 0, 102));
        jButton16.setForeground(new java.awt.Color(255, 255, 255));
        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        jButton16.setText("Hủy hóa đơn");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton16, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton16, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelbanhangLayout = new javax.swing.GroupLayout(panelbanhang);
        panelbanhang.setLayout(panelbanhangLayout);
        panelbanhangLayout.setHorizontalGroup(
            panelbanhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelbanhangLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(panelbanhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelbanhangLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(panelbanhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        panelbanhangLayout.setVerticalGroup(
            panelbanhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelbanhangLayout.createSequentialGroup()
                .addGap(0, 13, Short.MAX_VALUE)
                .addGroup(panelbanhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelbanhangLayout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelbanhangLayout.createSequentialGroup()
                        .addGroup(panelbanhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelbanhangLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(140, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pl_banhangLayout = new javax.swing.GroupLayout(pl_banhang);
        pl_banhang.setLayout(pl_banhangLayout);
        pl_banhangLayout.setHorizontalGroup(
            pl_banhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelbanhang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pl_banhangLayout.setVerticalGroup(
            pl_banhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pl_banhangLayout.createSequentialGroup()
                .addComponent(panelbanhang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pl_FullChucNang.add(pl_banhang, "card4");

        pl_hoadon.setBackground(new java.awt.Color(255, 255, 255));
        pl_hoadon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        pHoaDon.setBackground(new java.awt.Color(255, 255, 255));
        pHoaDon.setBorder(javax.swing.BorderFactory.createTitledBorder("Hoá Đơn"));

        tblHoaDon.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã HD", "Mã NV", "Mã KH", "Tên KH", "SDT", "Trạng Thái", "Tổng Tiền", "Ngày Tạo"
            }
        ));
        tblHoaDon.setGridColor(new java.awt.Color(0, 0, 102));
        tblHoaDon.setSelectionBackground(new java.awt.Color(255, 0, 51));
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane13.setViewportView(tblHoaDon);
        if (tblHoaDon.getColumnModel().getColumnCount() > 0) {
            tblHoaDon.getColumnModel().getColumn(0).setPreferredWidth(30);
            tblHoaDon.getColumnModel().getColumn(1).setPreferredWidth(30);
            tblHoaDon.getColumnModel().getColumn(3).setPreferredWidth(100);
        }

        javax.swing.GroupLayout pHoaDonLayout = new javax.swing.GroupLayout(pHoaDon);
        pHoaDon.setLayout(pHoaDonLayout);
        pHoaDonLayout.setHorizontalGroup(
            pHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pHoaDonLayout.createSequentialGroup()
                .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 1184, Short.MAX_VALUE)
                .addContainerGap())
        );
        pHoaDonLayout.setVerticalGroup(
            pHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                .addContainerGap())
        );

        pSanPham.setBackground(new java.awt.Color(255, 255, 255));
        pSanPham.setBorder(javax.swing.BorderFactory.createTitledBorder("Sản Phẩm"));
        pSanPham.setForeground(new java.awt.Color(0, 0, 102));

        tblSP.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên SP", "Đơn Giá", "Số Lượng", "Thành Tiền"
            }
        ));
        tblSP.setGridColor(new java.awt.Color(0, 0, 102));
        tblSP.setSelectionBackground(new java.awt.Color(255, 0, 51));
        tblSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSPMouseClicked(evt);
            }
        });
        jScrollPane14.setViewportView(tblSP);
        if (tblSP.getColumnModel().getColumnCount() > 0) {
            tblSP.getColumnModel().getColumn(0).setPreferredWidth(100);
        }

        javax.swing.GroupLayout pSanPhamLayout = new javax.swing.GroupLayout(pSanPham);
        pSanPham.setLayout(pSanPhamLayout);
        pSanPhamLayout.setHorizontalGroup(
            pSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pSanPhamLayout.createSequentialGroup()
                .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
                .addContainerGap())
        );
        pSanPhamLayout.setVerticalGroup(
            pSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pSanPhamLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                .addContainerGap())
        );

        pImei.setBackground(new java.awt.Color(255, 255, 255));
        pImei.setBorder(javax.swing.BorderFactory.createTitledBorder("Imei"));
        pImei.setForeground(new java.awt.Color(0, 0, 102));

        tblImei.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblImei.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IMEI"
            }
        ));
        tblImei.setGridColor(new java.awt.Color(0, 0, 102));
        tblImei.setSelectionBackground(new java.awt.Color(255, 0, 51));
        jScrollPane19.setViewportView(tblImei);

        javax.swing.GroupLayout pImeiLayout = new javax.swing.GroupLayout(pImei);
        pImei.setLayout(pImeiLayout);
        pImeiLayout.setHorizontalGroup(
            pImeiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pImeiLayout.createSequentialGroup()
                .addComponent(jScrollPane19, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                .addContainerGap())
        );
        pImeiLayout.setVerticalGroup(
            pImeiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pImeiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane19, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel58.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(0, 0, 102));
        jLabel58.setText("Tìm Kiếm");

        pLoc.setBackground(new java.awt.Color(255, 255, 255));
        pLoc.setBorder(javax.swing.BorderFactory.createTitledBorder("Lọc theo ngày tạo"));

        jdateFrom.setDateFormatString("dd-MM-yyyy");

        jdateTo.setDateFormatString("dd-MM-yyyy");

        jButton1.setBackground(new java.awt.Color(0, 0, 102));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/filterhihi.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 0, 102));
        jLabel27.setText("Từ:");

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 0, 102));
        jLabel28.setText("Đến:");

        javax.swing.GroupLayout pLocLayout = new javax.swing.GroupLayout(pLoc);
        pLoc.setLayout(pLocLayout);
        pLocLayout.setHorizontalGroup(
            pLocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pLocLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jdateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jdateTo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
        pLocLayout.setVerticalGroup(
            pLocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pLocLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pLocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jdateTo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(jdateFrom, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pLocLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pLocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel27)
                            .addComponent(jLabel28))))
                .addContainerGap())
        );

        btnFindHD.setBackground(new java.awt.Color(0, 0, 102));
        btnFindHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        btnFindHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindHDActionPerformed(evt);
            }
        });

        btnExportHD.setBackground(new java.awt.Color(0, 0, 102));
        btnExportHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/excel.png"))); // NOI18N
        btnExportHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportHDActionPerformed(evt);
            }
        });

        btnSortAsc.setBackground(new java.awt.Color(0, 0, 102));
        btnSortAsc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/decreasing.png"))); // NOI18N
        btnSortAsc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSortAscActionPerformed(evt);
            }
        });

        btnF5.setBackground(new java.awt.Color(0, 0, 102));
        btnF5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/F5.png"))); // NOI18N
        btnF5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnF5ActionPerformed(evt);
            }
        });

        btnSortDesc.setBackground(new java.awt.Color(0, 0, 102));
        btnSortDesc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ascendant.png"))); // NOI18N
        btnSortDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSortDescActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pl_hoadonLayout = new javax.swing.GroupLayout(pl_hoadon);
        pl_hoadon.setLayout(pl_hoadonLayout);
        pl_hoadonLayout.setHorizontalGroup(
            pl_hoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pl_hoadonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pl_hoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pl_hoadonLayout.createSequentialGroup()
                        .addGroup(pl_hoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pl_hoadonLayout.createSequentialGroup()
                                .addComponent(pSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(pImei, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(btnSortAsc, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnF5, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSortDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(pHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(105, Short.MAX_VALUE))
                    .addGroup(pl_hoadonLayout.createSequentialGroup()
                        .addGroup(pl_hoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel58)
                            .addGroup(pl_hoadonLayout.createSequentialGroup()
                                .addComponent(txtTimKiemHD, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnFindHD, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                        .addComponent(pLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(btnExportHD, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(142, 142, 142))))
        );
        pl_hoadonLayout.setVerticalGroup(
            pl_hoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pl_hoadonLayout.createSequentialGroup()
                .addGroup(pl_hoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pl_hoadonLayout.createSequentialGroup()
                        .addGroup(pl_hoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pl_hoadonLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel58)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pl_hoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtTimKiemHD, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnFindHD, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pl_hoadonLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(pLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pl_hoadonLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnExportHD, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)))
                .addComponent(pHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pl_hoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pl_hoadonLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(pl_hoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnF5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSortAsc, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSortDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pl_hoadonLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(pl_hoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pImei, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pl_FullChucNang.add(pl_hoadon, "hoadon");

        pl_khuyenmai.setBackground(new java.awt.Color(255, 255, 255));
        pl_khuyenmai.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        pl_khuyenmai1.setBackground(new java.awt.Color(255, 255, 255));
        pl_khuyenmai1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        pl_khuyenmai5.setBackground(new java.awt.Color(255, 255, 255));
        pl_khuyenmai5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel29.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 655, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 747, Short.MAX_VALUE)
        );

        tbl_SanPhamGiamGia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tbl_SanPhamGiamGia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên sản phẩm", "Chọn"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_SanPhamGiamGia.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_SanPhamGiamGia.setSelectionBackground(new java.awt.Color(255, 0, 51));
        jScrollPane22.setViewportView(tbl_SanPhamGiamGia);
        if (tbl_SanPhamGiamGia.getColumnModel().getColumnCount() > 0) {
            tbl_SanPhamGiamGia.getColumnModel().getColumn(1).setMinWidth(60);
            tbl_SanPhamGiamGia.getColumnModel().getColumn(1).setMaxWidth(60);
        }

        jPanel45.setBackground(new java.awt.Color(255, 255, 255));

        jLabel61.setText("Tên chương trình ");

        txt_TenKM.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        jLabel62.setText("Mã giảm giá");

        txt_MaGiamGia.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        jLabel63.setText("Từ ngày");

        jLabel64.setText("Đến ngày");

        jLabel65.setText("Mức giảm (%)");

        txt_MucGiam.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        dtc_DenNgay.setDateFormatString("dd-MM-yyyy");

        dtc_TuNgay.setDateFormatString("dd-MM-yyyy");

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel45Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel45Layout.createSequentialGroup()
                        .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel61))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_TenKM)
                            .addComponent(txt_MaGiamGia)))
                    .addGroup(jPanel45Layout.createSequentialGroup()
                        .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(65, 65, 65)
                        .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_MucGiam)
                            .addComponent(dtc_TuNgay, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                            .addComponent(dtc_DenNgay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(36, 36, 36))
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel61)
                    .addComponent(txt_TenKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel62)
                    .addComponent(txt_MaGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel45Layout.createSequentialGroup()
                        .addComponent(jLabel63)
                        .addGap(24, 24, 24))
                    .addGroup(jPanel45Layout.createSequentialGroup()
                        .addComponent(dtc_TuNgay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel64)
                    .addComponent(dtc_DenNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel65)
                    .addComponent(txt_MucGiam, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );

        jTabbedPane3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane3MouseClicked(evt);
            }
        });

        tbl_KhuyenMaiNgungHoatDong.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tbl_KhuyenMaiNgungHoatDong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Tên khuyến mãi", "Mã khuyến mãi", "Giảm giá ", "Thời gian hoạt động", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_KhuyenMaiNgungHoatDong.setGridColor(new java.awt.Color(0, 0, 102));
        tbl_KhuyenMaiNgungHoatDong.setSelectionBackground(new java.awt.Color(255, 0, 51));
        tbl_KhuyenMaiNgungHoatDong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_KhuyenMaiNgungHoatDongMouseClicked(evt);
            }
        });
        jScrollPane21.setViewportView(tbl_KhuyenMaiNgungHoatDong);
        if (tbl_KhuyenMaiNgungHoatDong.getColumnModel().getColumnCount() > 0) {
            tbl_KhuyenMaiNgungHoatDong.getColumnModel().getColumn(0).setMinWidth(50);
            tbl_KhuyenMaiNgungHoatDong.getColumnModel().getColumn(0).setMaxWidth(50);
            tbl_KhuyenMaiNgungHoatDong.getColumnModel().getColumn(4).setMinWidth(200);
            tbl_KhuyenMaiNgungHoatDong.getColumnModel().getColumn(4).setMaxWidth(200);
        }

        jTabbedPane3.addTab("Tất cả", jScrollPane21);

        tbl_KhuyenMai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Tên khuyến mãi", "Mã khuyến mãi", "Giảm giá ", "Thời gian hoạt động", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_KhuyenMai.setSelectionBackground(new java.awt.Color(204, 204, 204));
        tbl_KhuyenMai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_KhuyenMaiMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_KhuyenMai);
        if (tbl_KhuyenMai.getColumnModel().getColumnCount() > 0) {
            tbl_KhuyenMai.getColumnModel().getColumn(0).setMinWidth(50);
            tbl_KhuyenMai.getColumnModel().getColumn(0).setMaxWidth(50);
            tbl_KhuyenMai.getColumnModel().getColumn(4).setMinWidth(200);
            tbl_KhuyenMai.getColumnModel().getColumn(4).setMaxWidth(200);
        }

        jTabbedPane3.addTab("Đã ngưng hoạt động", jScrollPane2);

        jPanel46.setBackground(new java.awt.Color(255, 255, 255));

        bt_addKM.setBackground(new java.awt.Color(0, 0, 102));
        bt_addKM.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bt_addKM.setForeground(new java.awt.Color(255, 255, 255));
        bt_addKM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        bt_addKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_addKMActionPerformed(evt);
            }
        });

        bt_suaKM.setBackground(new java.awt.Color(0, 0, 102));
        bt_suaKM.setForeground(new java.awt.Color(255, 255, 255));
        bt_suaKM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/update.png"))); // NOI18N
        bt_suaKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_suaKMActionPerformed(evt);
            }
        });

        bt_xoaKM.setBackground(new java.awt.Color(0, 0, 102));
        bt_xoaKM.setForeground(new java.awt.Color(255, 255, 255));
        bt_xoaKM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        bt_xoaKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_xoaKMActionPerformed(evt);
            }
        });

        jcbox_All.setText("Tất cả");
        jcbox_All.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbox_AllItemStateChanged(evt);
            }
        });
        jcbox_All.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbox_AllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel46Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jcbox_All, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel46Layout.createSequentialGroup()
                        .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(bt_xoaKM, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                .addComponent(bt_suaKM, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(bt_addKM, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(bt_addKM, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bt_suaKM, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bt_xoaKM, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                .addComponent(jcbox_All))
        );

        javax.swing.GroupLayout pl_khuyenmai5Layout = new javax.swing.GroupLayout(pl_khuyenmai5);
        pl_khuyenmai5.setLayout(pl_khuyenmai5Layout);
        pl_khuyenmai5Layout.setHorizontalGroup(
            pl_khuyenmai5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pl_khuyenmai5Layout.createSequentialGroup()
                .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(491, 491, 491))
            .addGroup(pl_khuyenmai5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pl_khuyenmai5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pl_khuyenmai5Layout.createSequentialGroup()
                        .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(823, 823, 823)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pl_khuyenmai5Layout.setVerticalGroup(
            pl_khuyenmai5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pl_khuyenmai5Layout.createSequentialGroup()
                .addGroup(pl_khuyenmai5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pl_khuyenmai5Layout.createSequentialGroup()
                        .addGroup(pl_khuyenmai5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pl_khuyenmai5Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pl_khuyenmai5Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jPanel46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(pl_khuyenmai5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pl_khuyenmai5Layout.createSequentialGroup()
                                .addGap(229, 229, 229)
                                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pl_khuyenmai5Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pl_khuyenmai5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );

        jdateFrom1.setDateFormatString("dd-MM-yyyy");

        javax.swing.GroupLayout pl_khuyenmai1Layout = new javax.swing.GroupLayout(pl_khuyenmai1);
        pl_khuyenmai1.setLayout(pl_khuyenmai1Layout);
        pl_khuyenmai1Layout.setHorizontalGroup(
            pl_khuyenmai1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pl_khuyenmai1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(pl_khuyenmai5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(384, 384, 384))
            .addGroup(pl_khuyenmai1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pl_khuyenmai1Layout.createSequentialGroup()
                    .addGap(1522, 1522, 1522)
                    .addComponent(jdateFrom1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1523, Short.MAX_VALUE)))
        );
        pl_khuyenmai1Layout.setVerticalGroup(
            pl_khuyenmai1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pl_khuyenmai1Layout.createSequentialGroup()
                .addComponent(pl_khuyenmai5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pl_khuyenmai1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pl_khuyenmai1Layout.createSequentialGroup()
                    .addGap(692, 692, 692)
                    .addComponent(jdateFrom1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(692, 692, 692)))
        );

        javax.swing.GroupLayout pl_khuyenmaiLayout = new javax.swing.GroupLayout(pl_khuyenmai);
        pl_khuyenmai.setLayout(pl_khuyenmaiLayout);
        pl_khuyenmaiLayout.setHorizontalGroup(
            pl_khuyenmaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2285, Short.MAX_VALUE)
            .addGroup(pl_khuyenmaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pl_khuyenmaiLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pl_khuyenmai1, javax.swing.GroupLayout.PREFERRED_SIZE, 2285, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        pl_khuyenmaiLayout.setVerticalGroup(
            pl_khuyenmaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 717, Short.MAX_VALUE)
            .addGroup(pl_khuyenmaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pl_khuyenmaiLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pl_khuyenmai1, javax.swing.GroupLayout.PREFERRED_SIZE, 717, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pl_FullChucNang.add(pl_khuyenmai, "khuyenmai");

        pl_thongtincanhan.setBackground(new java.awt.Color(255, 255, 255));
        pl_thongtincanhan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pl_thongtincanhan.setForeground(new java.awt.Color(0, 0, 102));

        jPanel40.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1056, Short.MAX_VALUE)
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jTabbedPane4.setForeground(new java.awt.Color(0, 0, 102));
        jTabbedPane4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 0, 102))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 102));
        jLabel2.setText("Mã");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 102));
        jLabel3.setText("Họ Tên");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 0, 102));
        jLabel23.setText("Giới Tính");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 0, 102));
        jLabel24.setText("Chức Vụ");

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 0, 102));
        jLabel30.setText("Email");

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 0, 102));
        jLabel31.setText("Quê Quán");

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 0, 102));
        jLabel32.setText("Ngày Sinh");

        txtMaNV.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtMaNV.setForeground(new java.awt.Color(0, 0, 102));
        txtMaNV.setText("Mã");

        txtTenNV.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtTenNV.setForeground(new java.awt.Color(0, 0, 102));
        txtTenNV.setText("Mã");

        txtGioiTinh.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtGioiTinh.setForeground(new java.awt.Color(0, 0, 102));
        txtGioiTinh.setText("Mã");

        txtChucVu.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtChucVu.setForeground(new java.awt.Color(0, 0, 102));
        txtChucVu.setText("Mã");

        txtEmailttcn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtEmailttcn.setForeground(new java.awt.Color(0, 0, 102));
        txtEmailttcn.setText("Mã");

        txtQueQuanttcn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtQueQuanttcn.setForeground(new java.awt.Color(0, 0, 102));
        txtQueQuanttcn.setText("Mã");

        txtNgaySinhttcn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtNgaySinhttcn.setForeground(new java.awt.Color(0, 0, 102));
        txtNgaySinhttcn.setText("Mã");

        jButton3.setBackground(new java.awt.Color(0, 0, 102));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/log-out.png"))); // NOI18N
        jButton3.setText("ĐĂNG XUẤT");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtQueQuanttcn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtEmailttcn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtChucVu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtGioiTinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtTenNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtNgaySinhttcn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaNV))
                .addGap(18, 18, 18)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTenNV))
                .addGap(18, 18, 18)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txtGioiTinh))
                .addGap(18, 18, 18)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txtChucVu))
                .addGap(18, 18, 18)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(txtEmailttcn))
                .addGap(18, 18, 18)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(txtQueQuanttcn))
                .addGap(18, 18, 18)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(txtNgaySinhttcn))
                .addGap(41, 41, 41)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(173, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane4.addTab("Thông tin cá nhân", jPanel17);

        jPanel34.setBackground(new java.awt.Color(255, 255, 255));
        jPanel34.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Đổi mật khẩu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 0, 102))); // NOI18N

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(0, 0, 102));
        jLabel51.setText("MẬT KHẨU CŨ");

        jButton12.setBackground(new java.awt.Color(0, 0, 102));
        jButton12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setText("GỬI MÃ");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(0, 0, 102));
        jLabel52.setText("MẬT KHẨU MỚI");

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(0, 0, 102));
        jLabel53.setText("NHẬP LẠI");

        jButton50.setBackground(new java.awt.Color(0, 0, 102));
        jButton50.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton50.setForeground(new java.awt.Color(255, 255, 255));
        jButton50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key.png"))); // NOI18N
        jButton50.setText("ĐỔI MẬT KHẨU");
        jButton50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton50ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel34Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel52, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                            .addComponent(jLabel53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMaXN, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                            .addComponent(txtNhapLai)
                            .addComponent(txtMatKhauCu)
                            .addComponent(txtMatKhauMoi)))
                    .addGroup(jPanel34Layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addComponent(jButton50, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel34Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(175, Short.MAX_VALUE))
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(txtMatKhauCu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMatKhauMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel52))
                .addGap(18, 18, 18)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel53)
                    .addComponent(txtNhapLai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(txtMaXN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton12)
                .addGap(18, 18, 18)
                .addComponent(jButton50, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(216, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Đổi mật khẩu", jPanel34);

        javax.swing.GroupLayout pl_thongtincanhanLayout = new javax.swing.GroupLayout(pl_thongtincanhan);
        pl_thongtincanhan.setLayout(pl_thongtincanhanLayout);
        pl_thongtincanhanLayout.setHorizontalGroup(
            pl_thongtincanhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pl_thongtincanhanLayout.createSequentialGroup()
                .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 253, Short.MAX_VALUE))
            .addGroup(pl_thongtincanhanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pl_thongtincanhanLayout.setVerticalGroup(
            pl_thongtincanhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pl_thongtincanhanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane4)
                .addGap(18, 18, 18)
                .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87))
        );

        pl_FullChucNang.add(pl_thongtincanhan, "khachhang");

        pl_thongke.setBackground(new java.awt.Color(255, 255, 255));
        pl_thongke.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel52.setBackground(new java.awt.Color(255, 255, 255));
        jPanel52.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel35.setBackground(new java.awt.Color(255, 255, 255));
        jPanel35.setBorder(javax.swing.BorderFactory.createTitledBorder("THỐNG KÊ TỔNG"));

        jPanel36.setBackground(new java.awt.Color(0, 255, 204));
        jPanel36.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tftieudetongdonhang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tftieudetongdonhang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tftieudetongdonhang.setText("TỔNG ĐƠN HÀNG");

        tftongdonhang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tftongdonhang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tftongdonhang.setText("0");

        tfdonthanhcong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tfdonthanhcong.setText("0");

        jLabel79.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel79.setText("THÀNH CÔNG :");

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(tftongdonhang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tftieudetongdonhang, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfdonthanhcong, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)))
                .addGap(0, 12, Short.MAX_VALUE))
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addComponent(tftieudetongdonhang, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(tftongdonhang, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdonthanhcong, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel42.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel57.setBackground(new java.awt.Color(255, 255, 51));
        jPanel57.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tfchitietdonhang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tfchitietdonhang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tfchitietdonhang.setText("CHI TIẾT ĐƠN HÀNG");

        jLabel55.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel55.setText("Số lượng sản phẩm  đã bán:");

        tfsoluongsanphambanthongke.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tfsoluongsanphambanthongke.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tfsoluongsanphambanthongke.setText("0");

        javax.swing.GroupLayout jPanel57Layout = new javax.swing.GroupLayout(jPanel57);
        jPanel57.setLayout(jPanel57Layout);
        jPanel57Layout.setHorizontalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel57Layout.createSequentialGroup()
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(tfchitietdonhang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel55, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel57Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfsoluongsanphambanthongke, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel57Layout.setVerticalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel57Layout.createSequentialGroup()
                .addComponent(tfchitietdonhang, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tfsoluongsanphambanthongke, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel41.setBackground(new java.awt.Color(255, 102, 102));
        jPanel41.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tftieudetongdoanhthu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tftieudetongdoanhthu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tftieudetongdoanhthu.setText("DOANH THU");

        tfdoanhthu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tfdoanhthu.setText("0");

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel33.setText("Tổng doanh thu :");

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel41Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfdoanhthu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)))
                    .addComponent(tftieudetongdoanhthu, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addComponent(tftieudetongdoanhthu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel33)
                .addGap(18, 18, 18)
                .addComponent(tfdoanhthu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel58.setBackground(new java.awt.Color(204, 204, 204));

        jLabel59.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel59.setText("ĐƠN HÀNG ĐÃ HỦY");

        jLabel60.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel60.setText("ĐÃ HỦY  :");

        tfdondahuy.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tfdondahuy.setText("0");

        javax.swing.GroupLayout jPanel58Layout = new javax.swing.GroupLayout(jPanel58);
        jPanel58.setLayout(jPanel58Layout);
        jPanel58Layout.setHorizontalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel58Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfdondahuy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel59, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                    .addGroup(jPanel58Layout.createSequentialGroup()
                        .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel58Layout.setVerticalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel58Layout.createSequentialGroup()
                .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel60)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tfdondahuy, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel25.setBackground(new java.awt.Color(255, 255, 255));
        jPanel25.setBorder(javax.swing.BorderFactory.createTitledBorder("BÁO CÁO ĐỒ"));

        jButton54.setBackground(new java.awt.Color(0, 0, 102));
        jButton54.setForeground(new java.awt.Color(255, 255, 255));
        jButton54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/thongtincanhan.png"))); // NOI18N
        jButton54.setText("GỬI BÁO CÁO");
        jButton54.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton54ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 0, 102));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/excel.png"))); // NOI18N
        jButton4.setText("Xuất EXCEL");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jButton54, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton54, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel44.setBackground(new java.awt.Color(255, 255, 255));
        jPanel44.setBorder(javax.swing.BorderFactory.createTitledBorder("Thống kê thông tin theo khoảng thời gian"));

        jButton53.setBackground(new java.awt.Color(0, 0, 102));
        jButton53.setForeground(new java.awt.Color(255, 255, 255));
        jButton53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/filterhihi.png"))); // NOI18N
        jButton53.setText("LỌC");
        jButton53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton53ActionPerformed(evt);
            }
        });

        tfketthucngaythongke.setDateFormatString("dd-MM-yyyy");

        jLabel54.setText("Đến ngày(dd-mm-yyyy)");

        tfngaybatdauthongke.setDateFormatString("dd-MM-yyyy");

        jLabel34.setText("Từ ngày(dd-mm-yyyy)");

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel44Layout.createSequentialGroup()
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfngaybatdauthongke, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jLabel54)
                .addGap(18, 18, 18)
                .addComponent(tfketthucngaythongke, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton53, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfngaybatdauthongke, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel54, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfketthucngaythongke, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton53, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel35Layout.createSequentialGroup()
                        .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(159, 159, 159)
                        .addComponent(jPanel58, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel57, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(124, 124, 124)
                        .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel35Layout.createSequentialGroup()
                        .addComponent(jPanel44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel57, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel58, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel39.setBackground(new java.awt.Color(255, 255, 255));

        jButton13.setBackground(new java.awt.Color(0, 0, 102));
        jButton13.setForeground(new java.awt.Color(255, 255, 255));
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton47.setBackground(new java.awt.Color(0, 0, 102));
        jButton47.setForeground(new java.awt.Color(255, 255, 255));
        jButton47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ascendantMini.png"))); // NOI18N
        jButton47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton47ActionPerformed(evt);
            }
        });

        jButton52.setBackground(new java.awt.Color(0, 0, 102));
        jButton52.setForeground(new java.awt.Color(255, 255, 255));
        jButton52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/decreasingMini.png"))); // NOI18N
        jButton52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton52ActionPerformed(evt);
            }
        });

        jPanel43.setBackground(new java.awt.Color(255, 255, 255));
        jPanel43.setBorder(javax.swing.BorderFactory.createTitledBorder("Sản phẩm bán nhiều nhất trong khoang thời gian"));

        tbbangsanphambanchaynhat.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tbbangsanphambanchaynhat.setForeground(new java.awt.Color(51, 0, 204));
        tbbangsanphambanchaynhat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "STT", "Mã sản phẩm", "Tên sản phẩm", "Số lượng bán"
            }
        ));
        tbbangsanphambanchaynhat.setGridColor(new java.awt.Color(0, 0, 102));
        tbbangsanphambanchaynhat.setSelectionBackground(new java.awt.Color(255, 0, 51));
        tbbangsanphambanchaynhat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbbangsanphambanchaynhatMouseClicked(evt);
            }
        });
        jScrollPane20.setViewportView(tbbangsanphambanchaynhat);

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 65, Short.MAX_VALUE))
        );

        jPanel37.setBackground(new java.awt.Color(255, 255, 255));
        jPanel37.setBorder(javax.swing.BorderFactory.createTitledBorder("Sản phẩm đã bán trong thời gian lựa chọn"));

        tbbangthongke.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tbbangthongke.setForeground(new java.awt.Color(51, 0, 204));
        tbbangthongke.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã sản phẩm", "Mã hóa đơn", "Tên sản phẩm", "Số lượng bán", "Giá bán", "Thành tiền", "Ngày bán"
            }
        ));
        tbbangthongke.setGridColor(new java.awt.Color(0, 0, 102));
        tbbangthongke.setSelectionBackground(new java.awt.Color(255, 0, 51));
        tbbangthongke.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbbangthongkeMouseClicked(evt);
            }
        });
        jScrollPane17.setViewportView(tbbangthongke);

        tftongdoanhthutimkiem.setText("0.00 VNĐ");

        jLabel80.setText("Tổng thành tiền :");

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 835, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel37Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tftongdoanhthutimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel37Layout.createSequentialGroup()
                .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel80)
                    .addComponent(tftongdoanhthutimkiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel39Layout.createSequentialGroup()
                        .addComponent(jPanel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel39Layout.createSequentialGroup()
                        .addComponent(jButton47, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton52, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tftimkiemthongke, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)))
                .addContainerGap())
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel39Layout.createSequentialGroup()
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel39Layout.createSequentialGroup()
                        .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tftimkiemthongke, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton13))
                        .addGap(13, 13, 13)
                        .addComponent(jPanel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel39Layout.createSequentialGroup()
                        .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel39Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jButton52, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane2.addTab("SẢN PHẨM ĐÃ BÁN", jPanel39);

        jPanel59.setBackground(new java.awt.Color(255, 255, 255));

        jButton56.setBackground(new java.awt.Color(0, 0, 102));
        jButton56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ascendantMini.png"))); // NOI18N
        jButton56.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton56ActionPerformed(evt);
            }
        });

        jButton57.setBackground(new java.awt.Color(0, 0, 102));
        jButton57.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/decreasingMini.png"))); // NOI18N
        jButton57.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton57ActionPerformed(evt);
            }
        });

        jButton58.setBackground(new java.awt.Color(0, 0, 102));
        jButton58.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        jButton58.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton58ActionPerformed(evt);
            }
        });

        jPanel60.setBackground(new java.awt.Color(255, 255, 255));
        jPanel60.setBorder(javax.swing.BorderFactory.createTitledBorder("Sản phẩm trong kho"));

        tbsanphamtonthongke.setForeground(new java.awt.Color(51, 0, 204));
        tbsanphamtonthongke.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "MÃ SẢN PHẨM", "TÊN SẢN PHẨM", "TỒN KHO", "ĐƠN GIÁ"
            }
        ));
        tbsanphamtonthongke.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbsanphamtonthongkeMouseClicked(evt);
            }
        });
        jScrollPane25.setViewportView(tbsanphamtonthongke);

        javax.swing.GroupLayout jPanel60Layout = new javax.swing.GroupLayout(jPanel60);
        jPanel60.setLayout(jPanel60Layout);
        jPanel60Layout.setHorizontalGroup(
            jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane25, javax.swing.GroupLayout.DEFAULT_SIZE, 1210, Short.MAX_VALUE)
        );
        jPanel60Layout.setVerticalGroup(
            jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel60Layout.createSequentialGroup()
                .addComponent(jScrollPane25, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel59Layout = new javax.swing.GroupLayout(jPanel59);
        jPanel59.setLayout(jPanel59Layout);
        jPanel59Layout.setHorizontalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel59Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel59Layout.createSequentialGroup()
                        .addComponent(jPanel60, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel59Layout.createSequentialGroup()
                        .addComponent(jButton56, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton57, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tftimkiemsanphamton, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton58, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))))
        );
        jPanel59Layout.setVerticalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel59Layout.createSequentialGroup()
                .addGroup(jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(tftimkiemsanphamton, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton58, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jButton56, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton57, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel60, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(41, 41, 41))
        );

        jTabbedPane2.addTab("SẢN PHẨM TỒN", jPanel59);

        jPanel38.setBackground(new java.awt.Color(255, 255, 255));

        jPanel47.setBackground(new java.awt.Color(255, 255, 255));
        jPanel47.setBorder(javax.swing.BorderFactory.createTitledBorder("THÔNG TIN BIỂU ĐỒ"));

        jPanel48.setBackground(new java.awt.Color(255, 255, 255));
        jPanel48.setBorder(javax.swing.BorderFactory.createTitledBorder("CHỨC NĂNG BẢNG"));

        jButton59.setBackground(new java.awt.Color(0, 0, 102));
        jButton59.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton59.setForeground(new java.awt.Color(255, 255, 255));
        jButton59.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        jButton59.setText("THÊM");
        jButton59.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton59ActionPerformed(evt);
            }
        });

        jButton60.setBackground(new java.awt.Color(0, 0, 102));
        jButton60.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton60.setForeground(new java.awt.Color(255, 255, 255));
        jButton60.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/update.png"))); // NOI18N
        jButton60.setText("SỬA");
        jButton60.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton60ActionPerformed(evt);
            }
        });

        jButton61.setBackground(new java.awt.Color(0, 0, 102));
        jButton61.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton61.setForeground(new java.awt.Color(255, 255, 255));
        jButton61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        jButton61.setText("XÓA");
        jButton61.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton61ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel48Layout = new javax.swing.GroupLayout(jPanel48);
        jPanel48.setLayout(jPanel48Layout);
        jPanel48Layout.setHorizontalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton61, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton60, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton59, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel48Layout.setVerticalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton59, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton60, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton61, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel49.setBackground(new java.awt.Color(255, 255, 255));
        jPanel49.setBorder(javax.swing.BorderFactory.createTitledBorder("TẠO BIỂU ĐỒ"));

        jButton55.setBackground(new java.awt.Color(0, 0, 102));
        jButton55.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton55.setForeground(new java.awt.Color(255, 255, 255));
        jButton55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        jButton55.setText("TẠO BIỂU ĐỒ");
        jButton55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton55ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel49Layout = new javax.swing.GroupLayout(jPanel49);
        jPanel49.setLayout(jPanel49Layout);
        jPanel49Layout.setHorizontalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton55, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel49Layout.setVerticalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton55, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel50.setBackground(new java.awt.Color(255, 255, 255));
        jPanel50.setBorder(javax.swing.BorderFactory.createTitledBorder("BẢNG THÔNG TIN BIỂU ĐỒ"));

        tbbangbieudo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tbbangbieudo.setForeground(new java.awt.Color(0, 0, 51));
        tbbangbieudo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "STT", "OX(dd-MM-yyyy)", "OY(Doanh thu)"
            }
        ));
        tbbangbieudo.setGridColor(new java.awt.Color(0, 0, 102));
        tbbangbieudo.setSelectionBackground(new java.awt.Color(255, 0, 51));
        tbbangbieudo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbbangbieudoMouseClicked(evt);
            }
        });
        jScrollPane26.setViewportView(tbbangbieudo);

        javax.swing.GroupLayout jPanel50Layout = new javax.swing.GroupLayout(jPanel50);
        jPanel50.setLayout(jPanel50Layout);
        jPanel50Layout.setHorizontalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane26, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel50Layout.setVerticalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane26, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel51.setBackground(new java.awt.Color(255, 255, 255));
        jPanel51.setBorder(javax.swing.BorderFactory.createTitledBorder("CHỌN NGÀY"));

        tfOX.setDateFormatString("dd-MM-yyyy");

        jLabel81.setText("OX(dd-MM-yyyy)  :");

        javax.swing.GroupLayout jPanel51Layout = new javax.swing.GroupLayout(jPanel51);
        jPanel51.setLayout(jPanel51Layout);
        jPanel51Layout.setHorizontalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel51Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(tfOX, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel51Layout.setVerticalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel81, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tfOX, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel47Layout.createSequentialGroup()
                        .addComponent(jPanel48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel47Layout.createSequentialGroup()
                        .addComponent(jPanel51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel61.setBackground(new java.awt.Color(255, 255, 255));
        jPanel61.setBorder(javax.swing.BorderFactory.createTitledBorder("CHÚ THÍCH"));

        lbanhbieudo.setBackground(new java.awt.Color(204, 255, 204));
        lbanhbieudo.setForeground(new java.awt.Color(204, 255, 204));
        lbanhbieudo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/anhbieudo.png"))); // NOI18N

        jLabel82.setText("CHÚ Ý :");

        jLabel83.setText("+Ảnh biểu đồ sẽ thể hiện như ảnh trên");

        jLabel84.setText("+Trục ox: Thời gian muốn kiểm tra");

        jLabel85.setText("+Trục oy: Doanh thu theo thời gian muốn sét");

        jLabel86.setText("=> Hãy nhập thời gian vào bảng bên");

        javax.swing.GroupLayout jPanel61Layout = new javax.swing.GroupLayout(jPanel61);
        jPanel61.setLayout(jPanel61Layout);
        jPanel61Layout.setHorizontalGroup(
            jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel61Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel83, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel84, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel85, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel61Layout.createSequentialGroup()
                        .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel86, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbanhbieudo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel61Layout.setVerticalGroup(
            jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel61Layout.createSequentialGroup()
                .addComponent(lbanhbieudo, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel82)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel83)
                .addGap(18, 18, 18)
                .addComponent(jLabel84)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel85)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel86)
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel38Layout.createSequentialGroup()
                .addComponent(jPanel61, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jPanel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel47, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel61, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 39, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("BIỂU ĐỒ DOANH THU", jPanel38);

        javax.swing.GroupLayout jPanel52Layout = new javax.swing.GroupLayout(jPanel52);
        jPanel52.setLayout(jPanel52Layout);
        jPanel52Layout.setHorizontalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel52Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane2))
                .addContainerGap())
        );
        jPanel52Layout.setVerticalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel52Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pl_thongkeLayout = new javax.swing.GroupLayout(pl_thongke);
        pl_thongke.setLayout(pl_thongkeLayout);
        pl_thongkeLayout.setHorizontalGroup(
            pl_thongkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pl_thongkeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pl_thongkeLayout.setVerticalGroup(
            pl_thongkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pl_thongkeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pl_FullChucNang.add(pl_thongke, "thongke");

        pl_nhanvien.setBackground(new java.awt.Color(255, 255, 255));
        pl_nhanvien.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel30.setBackground(new java.awt.Color(255, 255, 255));
        jPanel30.setBorder(javax.swing.BorderFactory.createTitledBorder("CHỨC NĂNG"));

        btnthem.setBackground(new java.awt.Color(0, 0, 102));
        btnthem.setForeground(new java.awt.Color(255, 255, 255));
        btnthem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });

        btnxoa.setBackground(new java.awt.Color(0, 0, 102));
        btnxoa.setForeground(new java.awt.Color(255, 255, 255));
        btnxoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        btnxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoaActionPerformed(evt);
            }
        });

        btnhoatdonglai.setBackground(new java.awt.Color(0, 0, 102));
        btnhoatdonglai.setForeground(new java.awt.Color(255, 255, 255));
        btnhoatdonglai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/active.png"))); // NOI18N
        btnhoatdonglai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhoatdonglaiActionPerformed(evt);
            }
        });

        btnsua.setBackground(new java.awt.Color(0, 0, 102));
        btnsua.setForeground(new java.awt.Color(255, 255, 255));
        btnsua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/update.png"))); // NOI18N
        btnsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 0, 102));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/excel.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnexportEXCEL.setText("Export Excel");
        btnexportEXCEL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexportEXCELActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel30Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnexportEXCEL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnthem, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnsua, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnxoa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnhoatdonglai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(btnthem, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnsua)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnxoa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnhoatdonglai)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnexportEXCEL)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel31.setBackground(new java.awt.Color(255, 255, 255));
        jPanel31.setBorder(javax.swing.BorderFactory.createTitledBorder("THÔNG TIN NHÂN VIÊN"));

        jLabel40.setText("MÃ NHÂN VIÊN");

        jLabel41.setText("TÊN NHÂN VIÊN");

        jLabel42.setText("CHỨC VỤ");

        jLabel43.setText("GIỚI TÍNH");

        jLabel44.setText("EMAIL");

        jLabel45.setText("QUÊ");

        jLabel46.setText("NGÀY SINH");

        jLabel48.setText("TÀI KHOẢN");

        jLabel49.setText("MẬT KHẨU");

        cbbchucvu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        buttonGroup1.add(rdnam);
        rdnam.setSelected(true);
        rdnam.setText("Nam");

        buttonGroup1.add(rdnu);
        rdnu.setText("Nữ");

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtmanv, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txttennv, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbbchucvu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rdnam)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rdnu)))
                .addGap(94, 94, 94)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtmatkhau, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                    .addComponent(txttaikhaon, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                    .addComponent(txtque, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                    .addComponent(jcalendarngaysinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(140, Short.MAX_VALUE))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(txtmanv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45)
                    .addComponent(txtque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel41)
                        .addComponent(txttennv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel46))
                    .addComponent(jcalendarngaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(rdnam)
                    .addComponent(rdnu)
                    .addComponent(txttaikhaon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel48))
                .addGap(18, 18, 18)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(cbbchucvu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtmatkhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel49))
                .addGap(18, 18, 18)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jPanel32.setBackground(new java.awt.Color(255, 255, 255));
        jPanel32.setBorder(javax.swing.BorderFactory.createTitledBorder("BẢNG NHÂN VIÊN"));

        jButton44.setBackground(new java.awt.Color(0, 0, 102));
        jButton44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N

        tableluutru.setForeground(new java.awt.Color(0, 0, 102));
        tableluutru.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã NV", "Tên NV", "Giới tính", "Chức vụ", "Email", "Quê quán", "Ngày sinh", "Tài khoản", "Mật Khẩu", "Trạng Thái"
            }
        ));
        tableluutru.setSelectionBackground(new java.awt.Color(255, 0, 51));
        tableluutru.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableluutruMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tableluutru);
        if (tableluutru.getColumnModel().getColumnCount() > 0) {
            tableluutru.getColumnModel().getColumn(0).setMinWidth(150);
            tableluutru.getColumnModel().getColumn(0).setMaxWidth(300);
            tableluutru.getColumnModel().getColumn(2).setMinWidth(150);
            tableluutru.getColumnModel().getColumn(2).setMaxWidth(300);
        }

        table.addTab("Nhân viên", jScrollPane7);

        tablenv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã NV", "Tên NV", "Giới tính", "Chức vụ", "Email", "Quê quán", "Ngày sinh", "Tài khoản", "Mật khẩu", "Trạng Thái"
            }
        ));
        jScrollPane11.setViewportView(tablenv);
        if (tablenv.getColumnModel().getColumnCount() > 0) {
            tablenv.getColumnModel().getColumn(0).setMinWidth(150);
            tablenv.getColumnModel().getColumn(0).setMaxWidth(300);
            tablenv.getColumnModel().getColumn(2).setMinWidth(150);
            tablenv.getColumnModel().getColumn(2).setMaxWidth(300);
        }

        table.addTab("Lưu trữ", jScrollPane11);

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton44, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
            .addComponent(table)
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton44))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(table, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel33.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pl_nhanvienLayout = new javax.swing.GroupLayout(pl_nhanvien);
        pl_nhanvien.setLayout(pl_nhanvienLayout);
        pl_nhanvienLayout.setHorizontalGroup(
            pl_nhanvienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pl_nhanvienLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pl_nhanvienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pl_nhanvienLayout.createSequentialGroup()
                        .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(279, Short.MAX_VALUE))))
        );
        pl_nhanvienLayout.setVerticalGroup(
            pl_nhanvienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pl_nhanvienLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pl_nhanvienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(36, 36, 36)
                .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        pl_FullChucNang.add(pl_nhanvien, "nhanvien");

        lblTenChucNang.setBackground(new java.awt.Color(0, 0, 102));
        lblTenChucNang.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        lblTenChucNang.setForeground(new java.awt.Color(255, 255, 255));
        lblTenChucNang.setText("TRANG CHỦ");

        javax.swing.GroupLayout pn_TongLayout = new javax.swing.GroupLayout(pn_Tong);
        pn_Tong.setLayout(pn_TongLayout);
        pn_TongLayout.setHorizontalGroup(
            pn_TongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_TongLayout.createSequentialGroup()
                .addComponent(pn_Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pn_TongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_TongLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(lblTenChucNang, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lb_Tendetai, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pn_TongLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pl_FullChucNang, javax.swing.GroupLayout.PREFERRED_SIZE, 1313, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 56, Short.MAX_VALUE))
        );
        pn_TongLayout.setVerticalGroup(
            pn_TongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_TongLayout.createSequentialGroup()
                .addGroup(pn_TongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_TongLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pn_TongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_Tendetai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTenChucNang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pl_FullChucNang, javax.swing.GroupLayout.PREFERRED_SIZE, 717, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pn_Menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pn_Tong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1088, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pn_Tong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pn_TongAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_pn_TongAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_pn_TongAncestorAdded


    private void btnDesignAnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesignAnhActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            // user selects a file
            File selectedFile = fileChooser.getSelectedFile();
            loadImageToLabel(selectedFile.getPath(), false);
            String name = getNameFileFromPath(selectedFile.getName(), true) + String.valueOf(new Date().getTime()) + "." + getNameFileFromPath(selectedFile.getName(), false);
            urlAnh = name;
            urlUploadAnh = selectedFile.getPath();
//            Util.uploadImage(selectedFile.getPath(), name);
        }
    }//GEN-LAST:event_btnDesignAnhActionPerformed

    private void btnDesignChipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesignChipActionPerformed
        // TODO add your handling code here:\
        String[] hearder = {"Mã Chip", "Tên Chip"};
        DemoDialog dialog = new DemoDialog(this, rootPaneCheckingEnabled, "Chip", hearder, "Mã Chip", "Tên chip");
//        dialog.show();
    }//GEN-LAST:event_btnDesignChipActionPerformed

    private void btnDesignMauSacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesignMauSacActionPerformed
        // TODO add your handling code here:
        String[] hearder = {"Mã màu sắc", "Tên màu sắc"};
        DemoDialog dialog = new DemoDialog(this, rootPaneCheckingEnabled, "Màu sắc", hearder, "Mã màu sắc", "Tên màu sắc");
    }//GEN-LAST:event_btnDesignMauSacActionPerformed

    private void btnDesignRamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesignRamActionPerformed
        // TODO add your handling code here:
        String[] hearder = {"Mã Ram", "Dung lượng"};
        DemoDialog dialog = new DemoDialog(this, rootPaneCheckingEnabled, "Ram", hearder, "Mã Ram", "Dung lượng");
    }//GEN-LAST:event_btnDesignRamActionPerformed

    private void btnDesignPinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesignPinActionPerformed
        // TODO add your handling code here:
        String[] hearder = {"Mã Pin", "Tên pin"};
        DemoDialog dialog = new DemoDialog(this, rootPaneCheckingEnabled, "Pin", hearder, "Mã Pin", "Tên pin");
    }//GEN-LAST:event_btnDesignPinActionPerformed

    private void btnDesignRomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesignRomActionPerformed
        // TODO add your handling code here:
        String[] hearder = {"Mã Rom", "Dung lượng"};
        DemoDialog dialog = new DemoDialog(this, rootPaneCheckingEnabled, "Rom", hearder, "Mã Rom", "Dung lượng");
    }//GEN-LAST:event_btnDesignRomActionPerformed

    private void btnDesignHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesignHangActionPerformed
        // TODO add your handling code here:
        String[] hearder = {"Mã Hãng", "Tên Hãng"};
        DemoDialog dialog = new DemoDialog(this, rootPaneCheckingEnabled, "Hãng", hearder, "Mã Hãng", "Tên Hãng");
    }//GEN-LAST:event_btnDesignHangActionPerformed


    private void pn_HomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_HomeMouseClicked
        // TODO add your handling code here:
        pl_FullChucNang.removeAll();
        pl_FullChucNang.add(pl_home);
        pl_FullChucNang.repaint();
        pl_FullChucNang.revalidate();
        lblTenChucNang.setText("TRANG CHỦ");
    }//GEN-LAST:event_pn_HomeMouseClicked

    private void pn_SanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_SanPhamMouseClicked
        // TODO add your handling code here:
        pl_FullChucNang.removeAll();
        pl_FullChucNang.add(pl_sanpham);
        pl_FullChucNang.repaint();
        pl_FullChucNang.revalidate();
        lblTenChucNang.setText("SẢN PHẨM");
        loadProductForm();
    }//GEN-LAST:event_pn_SanPhamMouseClicked

    private void pn_BanHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_BanHangMouseClicked
        // TODO add your handling code here:
        pl_FullChucNang.removeAll();
        pl_FullChucNang.add(pl_banhang);
        pl_FullChucNang.repaint();
        pl_FullChucNang.revalidate();
        lblTenChucNang.setText("BÁN HÀNG");
        loadTableSanPham();
    }//GEN-LAST:event_pn_BanHangMouseClicked

    private void pn_HoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_HoaDonMouseClicked
        // TODO add your handling code here:
        pl_FullChucNang.removeAll();
        pl_FullChucNang.add(pl_hoadon);
        pl_FullChucNang.repaint();
        pl_FullChucNang.revalidate();
        lblTenChucNang.setText("HÓA ĐƠN");
        setuptblHD();
    }//GEN-LAST:event_pn_HoaDonMouseClicked

    private void pn_KhuyenMaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_KhuyenMaiMouseClicked
        // TODO add your handling code here:
        pl_FullChucNang.removeAll();
        pl_FullChucNang.add(pl_khuyenmai);
        pl_FullChucNang.repaint();
        pl_FullChucNang.revalidate();
        lblTenChucNang.setText("KHUYẾN MÃI");
    }//GEN-LAST:event_pn_KhuyenMaiMouseClicked

    private void pn_NhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_NhanVienMouseClicked
        NhanVien nv = dvnv.getOneByUsername(dataConstructor);
        if (nv.getTenCV().equals("Quản lý")) {
            pn_NhanVien.setEnabled(true);
            pl_FullChucNang.removeAll();
            pl_FullChucNang.add(pl_nhanvien);
            pl_FullChucNang.repaint();
            pl_FullChucNang.revalidate();
            lblTenChucNang.setText("NHÂN VIÊN");
            //loadtable();
            loadnv1(list1);
            loadnv2(list2);
        } else {
            pn_NhanVien.setEnabled(false);
            JOptionPane.showMessageDialog(this, "Chỉ có quản lý mới được dùng chức năng này");
        }
    }//GEN-LAST:event_pn_NhanVienMouseClicked

    private void pn_ThongTinCaNhanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_ThongTinCaNhanMouseClicked
        // TODO add your handling code here:
        pl_FullChucNang.removeAll();
        pl_FullChucNang.add(pl_thongtincanhan);
        pl_FullChucNang.repaint();
        pl_FullChucNang.revalidate();
        lblTenChucNang.setText("THÔNG TIN CÁ NHÂN");
    }//GEN-LAST:event_pn_ThongTinCaNhanMouseClicked

    private void pn_ThongKeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_ThongKeMouseClicked
        // TODO add your handling code here:
        pl_FullChucNang.removeAll();
        pl_FullChucNang.add(pl_thongke);
        pl_FullChucNang.repaint();
        pl_FullChucNang.revalidate();
        lblTenChucNang.setText("THỐNG KÊ");
    }//GEN-LAST:event_pn_ThongKeMouseClicked

    private void pn_KhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_KhachHangMouseClicked
        // TODO add your handling code here:
        pl_FullChucNang.removeAll();
        pl_FullChucNang.add(pl_khachhang);
        pl_FullChucNang.repaint();
        pl_FullChucNang.revalidate();
        lblTenChucNang.setText("KHÁCH HÀNG");
        setuptblKH();
    }//GEN-LAST:event_pn_KhachHangMouseClicked

    private void pn_HomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_HomeMouseEntered
        // TODO add your handling code here:
        pn_Home.setBackground(Color.red);
        //pn_Home.setBackground(Color.white);
    }//GEN-LAST:event_pn_HomeMouseEntered

    private void pn_HomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_HomeMouseExited
        pn_Home.setBackground(bgColo);
    }//GEN-LAST:event_pn_HomeMouseExited

    private void pn_SanPhamMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_SanPhamMouseEntered
        // TODO add your handling code here:
        pn_SanPham.setBackground(Color.red);
    }//GEN-LAST:event_pn_SanPhamMouseEntered

    private void pn_SanPhamMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_SanPhamMouseExited
        // TODO add your handling code here:
        pn_SanPham.setBackground(new Color(0, 0, 102));
    }//GEN-LAST:event_pn_SanPhamMouseExited

    private void pn_BanHangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_BanHangMouseEntered
        // TODO add your handling code here:
        pn_BanHang.setBackground(Color.red);
    }//GEN-LAST:event_pn_BanHangMouseEntered

    private void pn_BanHangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_BanHangMouseExited
        // TODO add your handling code here:
        pn_BanHang.setBackground(new Color(0, 0, 102));
    }//GEN-LAST:event_pn_BanHangMouseExited

    private void pn_HoaDonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_HoaDonMouseEntered
        // TODO add your handling code here:
        pn_HoaDon.setBackground(Color.red);
    }//GEN-LAST:event_pn_HoaDonMouseEntered

    private void pn_HoaDonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_HoaDonMouseExited
        // TODO add your handling code here:
        pn_HoaDon.setBackground(new Color(0, 0, 102));
    }//GEN-LAST:event_pn_HoaDonMouseExited

    private void pn_KhuyenMaiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_KhuyenMaiMouseEntered
        // TODO add your handling code here:
        pn_KhuyenMai.setBackground(Color.red);
    }//GEN-LAST:event_pn_KhuyenMaiMouseEntered

    private void pn_KhuyenMaiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_KhuyenMaiMouseExited
        // TODO add your handling code here:
        pn_KhuyenMai.setBackground(new Color(0, 0, 102));
    }//GEN-LAST:event_pn_KhuyenMaiMouseExited

    private void pn_NhanVienMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_NhanVienMouseEntered
        // TODO add your handling code here:
        pn_NhanVien.setBackground(Color.red);
    }//GEN-LAST:event_pn_NhanVienMouseEntered

    private void pn_NhanVienMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_NhanVienMouseExited
        // TODO add your handling code here:
        pn_NhanVien.setBackground(new Color(0, 0, 102));
    }//GEN-LAST:event_pn_NhanVienMouseExited

    private void pn_ThongTinCaNhanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_ThongTinCaNhanMouseEntered
        // TODO add your handling code here:
        pn_ThongTinCaNhan.setBackground(Color.red);
    }//GEN-LAST:event_pn_ThongTinCaNhanMouseEntered

    private void pn_ThongTinCaNhanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_ThongTinCaNhanMouseExited
        // TODO add your handling code here:
        pn_ThongTinCaNhan.setBackground(new Color(0, 0, 102));
    }//GEN-LAST:event_pn_ThongTinCaNhanMouseExited

    private void pn_ThongKeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_ThongKeMouseEntered
        // TODO add your handling code here:
        pn_ThongKe.setBackground(Color.red);
    }//GEN-LAST:event_pn_ThongKeMouseEntered

    private void pn_ThongKeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_ThongKeMouseExited
        // TODO add your handling code here:
        pn_ThongKe.setBackground(new Color(0, 0, 102));
    }//GEN-LAST:event_pn_ThongKeMouseExited

    private void pn_KhachHangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_KhachHangMouseEntered
        // TODO add your handling code here:
        pn_KhachHang.setBackground(Color.red);
    }//GEN-LAST:event_pn_KhachHangMouseEntered

    private void pn_KhachHangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_KhachHangMouseExited
        // TODO add your handling code here:
        pn_KhachHang.setBackground(new Color(0, 0, 102));
    }//GEN-LAST:event_pn_KhachHangMouseExited

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        if (page < totalPage) {
            page += 1;
            calculatePagination();
            listSp = sanPhamService.getAllSanPham();
            listSanPham = sanPhamService.getAll();
            loadProductTable();
        }
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLastActionPerformed

    private void tblSanPham2MouseClicked1(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPham2MouseClicked1
        // TODO add your handling code here:
        setButtonStatus(true);
        DefaultTableModel dtm = (DefaultTableModel) tblSanPham2.getModel();
        int row = tblSanPham2.getSelectedRow();
        txtTenSanPham.setText(dtm.getValueAt(row, 0).toString());
        txtSoLuong.setText(dtm.getValueAt(row, 7).toString());
        txaMoTa.setText(dtm.getValueAt(row, 8).toString());
        cbbChip.setSelectedItem(dtm.getValueAt(row, 2));
        cbbRam.setSelectedItem(dtm.getValueAt(row, 3).toString());
        cbbRom.setSelectedItem(dtm.getValueAt(row, 4).toString());
        cbbPin.setSelectedItem(dtm.getValueAt(row, 5).toString());
        cbbHang.setSelectedItem(dtm.getValueAt(row, 1).toString());
        cbbMauSac.setSelectedItem(dtm.getValueAt(row, 6).toString());
        getImeiByProduct(listSp.get(row).getId());
        urlUploadAnh = null;
        urlAnh = listSp.get(row).getUrlAnh();
        loadImageToLabel(listSp.get(row).getUrlAnh(), true);

//        double donGia = Double.parseDouble(dtm.getValueAt(row, 9).toString());
//        DecimalFormat df = new DecimalFormat("#.###");
        // String.format("%,.0f", donGia) + " VND"
        txtDonGia.setText(String.format("%,.0f", listSp.get(row).getDonGia()) + " VND");
    }//GEN-LAST:event_tblSanPham2MouseClicked1

    private void btnThemSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSanPhamActionPerformed
        // TODO add your handling code here:
        if (checkValidateSanPham()) {
            int option = JOptionPane.showConfirmDialog(null, "Xác nhận thêm", "Xóa dữ liệu", JOptionPane.OK_CANCEL_OPTION);
            if (option == 0) {
                SanPham sp = buildRequestProduct();
                sp.setMaSP(Util.randomString());
                String result = sanPhamService.add(sp);
                JOptionPane.showMessageDialog(this, result);
                if (result.contains("thành công")) {
                    SanPham last = sanPhamService.getSPLast();
                    addImei(imeis, last);
                    Util.uploadImage(urlUploadAnh, urlAnh);
                    loadTableSanPham();
                    List<SanPhamResponse> lstSP = sanPhamService.getAll();
                    showData(lstSP);
                }
            }
        }

    }//GEN-LAST:event_btnThemSanPhamActionPerformed

    private void btnSuaSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaSanPhamActionPerformed
        // TODO add your handling code here:
        int option = JOptionPane.showConfirmDialog(null, "Xác nhận sửa", "Xóa dữ liệu", JOptionPane.OK_CANCEL_OPTION);
        if (option == 0) {
            SanPham sp = buildRequestProduct();
            sp.setMaSP(listSp.get(tblSanPham2.getSelectedRow()).getMaSP());
            sp.setId(listSp.get(tblSanPham2.getSelectedRow()).getId());
            String result = sanPhamService.update(sp);
            JOptionPane.showMessageDialog(this, result);
            if (result.contains("thành công")) {
                listSp.set(tblSanPham2.getSelectedRow(), sp);
                listSanPham.set(tblSanPham2.getSelectedRow(), new SanPhamResponse(sp));
                loadProductTable();
                List<Imei> listImeiData = imeiService.getAllImeiBySanPham(sp.getId());
                for (Imei imei : listImeiData) {
                    imeiService.delete(imei);
                }
                addImei(imeis, sp);
            }
        }
    }//GEN-LAST:event_btnSuaSanPhamActionPerformed


    private void btnXoaSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaSanPhamActionPerformed
        // TODO add your handling code here:
        int row = tblSanPham2.getSelectedRow();
//        if (row == -1) {
//            JOptionPane.showMessageDialog(this, "Chọn 1 dòng trên bảng để xóa");
//            return;
//        }
        int option = JOptionPane.showConfirmDialog(null, "Xác nhận xóa", "Xóa dữ liệu", JOptionPane.OK_CANCEL_OPTION);
        if (option == 0) {
            SanPham sp = buildRequestProduct();
            //sp.setDeleted(true);
            sp.setMaSP(listSp.get(tblSanPham2.getSelectedRow()).getMaSP());
            sp.setId(listSp.get(tblSanPham2.getSelectedRow()).getId());
            String result = sanPhamService.delete(sp);
            JOptionPane.showMessageDialog(this, result);
            if (result.contains("thành công")) {
                listSanPhamDeleted = sanPhamService.getDeletedSanPham();
                getAllSanPhamLuuTru(listSanPhamDeleted);
                listSp = sanPhamService.getAllSanPham();
                listSanPham = sanPhamService.getAll();
                loadProductTable();
            }
        }
        //SanPham sp = new
    }//GEN-LAST:event_btnXoaSanPhamActionPerformed

    private void btnXoaFormSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaFormSanPhamActionPerformed
        // TODO add your handling code here:
        txtTenSanPham.setText("");
        txtDonGia.setText("");
        txtSoLuong.setText("");
        txaMoTa.setText("");
        cbbChip.setSelectedIndex(0);
        cbbRam.setSelectedIndex(0);
        cbbRom.setSelectedIndex(0);
        cbbPin.setSelectedIndex(0);
        cbbHang.setSelectedIndex(0);
        cbbMauSac.setSelectedIndex(0);
        setButtonStatus(false);
    }//GEN-LAST:event_btnXoaFormSanPhamActionPerformed


    private void btnDesignImeiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesignImeiActionPerformed
        // TODO add your handling code here:
        DialogResponse response = new DialogResponse();
        DialogImei dialogImei = new DialogImei(this, rootPaneCheckingEnabled, response, listImei);
    }//GEN-LAST:event_btnDesignImeiActionPerformed

    private void btnSearchSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchSanPhamActionPerformed
        // TODO add your handling code here:
        String search = txtTimKiemSanPham.getText().trim();
        listSanPham = new ArrayList<>();
        if (!search.equals("")) {
            listSp = sanPhamService.searchProduct(search);

        } else {
            listSp = sanPhamService.getAllSanPham();
        }
        for (SanPham item : listSp) {
            listSanPham.add(new SanPhamResponse(item));
        }
        loadProductTable();
    }//GEN-LAST:event_btnSearchSanPhamActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnPreviusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPreviusActionPerformed

    private void tblSanPham2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPham2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tblSanPham2MouseEntered

    private void btnThemSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemSanPhamMouseClicked

    }//GEN-LAST:event_btnThemSanPhamMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        sortHD();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        showhdct();
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void tblSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSPMouseClicked
        showimei();
    }//GEN-LAST:event_tblSPMouseClicked

    private void tblSanPhamLuuTruMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamLuuTruMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblSanPhamLuuTruMouseClicked

    private void btnRestoreSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestoreSanPhamActionPerformed
        // TODO add your handling code here:
        if (tblSanPhamLuuTru.getSelectedRow() >= 0) {
            SanPham sp = listSanPhamDeleted.get(tblSanPhamLuuTru.getSelectedRow());
            String result = sanPhamService.restore(sp);
            JOptionPane.showMessageDialog(this, result);
            if (result.contains("thành công")) {
                listSanPhamDeleted = sanPhamService.getDeletedSanPham();
                getAllSanPhamLuuTru(listSanPhamDeleted);
                listSp = sanPhamService.getAllSanPham();
                listSanPham = sanPhamService.getAll();
                loadProductTable();
            }
        }

    }//GEN-LAST:event_btnRestoreSanPhamActionPerformed

    private void btnTimKiemSanPhamDeletedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemSanPhamDeletedActionPerformed
        // TODO add your handling code here:
        String keySearch = txtTimKiemSanPhamDeleted.getText().trim();
        if (keySearch.isBlank()) {
            listSanPhamDeleted = sanPhamService.getDeletedSanPham();
        } else {
            listSanPhamDeleted = sanPhamService.searchDeletedProduct(keySearch);
        }
        getAllSanPhamLuuTru(listSanPhamDeleted);
    }//GEN-LAST:event_btnTimKiemSanPhamDeletedActionPerformed
    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        if (validateKH() != null) {
            addKH(validateKH());
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void tableluutruMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableluutruMouseClicked
        // TODO add your handling code here:
        int selectrow = tableluutru.getSelectedRow();

        DefaultTableModel dtmNV = (DefaultTableModel) tableluutru.getModel();
        txtmanv.setText(dtmNV.getValueAt(selectrow, 0).toString());
        txttennv.setText(dtmNV.getValueAt(selectrow, 1).toString());
        rdnam.setEnabled(rootPaneCheckingEnabled);
        if (dtmNV.getValueAt(selectrow, 2).toString().equalsIgnoreCase("Nam")) {
            rdnam.setSelected(true);
        } else {
            rdnu.setSelected(true);
        }
        cbbchucvu.setSelectedItem(dtmNV.getValueAt(selectrow, 3).toString());
        txtemail.setText(dtmNV.getValueAt(selectrow, 4).toString());
        txtque.setText(dtmNV.getValueAt(selectrow, 5).toString());
        jcalendarngaysinh.setDate((Date) dtmNV.getValueAt(selectrow, 6));
        txttaikhaon.setText(dtmNV.getValueAt(selectrow, 7).toString());
        txtmatkhau.setText(dtmNV.getValueAt(selectrow, 8).toString());
    }//GEN-LAST:event_tableluutruMouseClicked

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
        // TODO add your handling code here:
        String manv = txtmanv.getText();
        listnhanvien = nhanvienService.getAll1();
        for (NhanVien x : listnhanvien) {
            if (x.getMaNhanVien().equalsIgnoreCase(txtmanv.getText())) {
                JOptionPane.showMessageDialog(this, "Không được trùng mà");
                return;
            }
        }
        String tennv = txttennv.getText();
        Boolean gioitinh = false;
        if (rdnam.isSelected()) {
            gioitinh = false;
        } else {
            gioitinh = true;
        }
        String tencv = cbbchucvu.getSelectedItem().toString();
        String email = txtemail.getText();
        String quequan = txtque.getText();
        Date ngaysinh = jcalendarngaysinh.getDate();
        String taikhoan = txttaikhaon.getText();
        String matkhau = txtmatkhau.getText();

        NhanVien nv2 = new NhanVien();
        nv2.setMaNhanVien(manv);
        nv2.setHoTen(tennv);
        nv2.isGioiTinh();
        nv2.setTenCV(tencv);
        nv2.setEmail(email);
        nv2.setQueQuan(quequan);
        nv2.setNgaySinh(ngaysinh);
        nv2.setTaiKhoan(taikhoan);
        nv2.setMatKhau(matkhau);
        NhanVienRepository nhanvienRepositoryadd = new NhanVienRepository();
        JOptionPane.showMessageDialog(this, nhanvienRepositoryadd.add(nv2));
        list1 = nhanvienService.getAllTrue();
        list2 = nhanvienService.getAllFalse();
        loadnv1(list1);
        loadnv2(list2);
        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
        final String toEmail = txtemail.getText();
        String toTaiKhoan = txttaikhaon.getText();
        String toMatKhau = txtmatkhau.getText();
        // Get a Properties object
        Properties props = System.getProperties();
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.auth", "true");
        props.put("mail.debug", "true");
        props.put("mail.store.protocol", "pop3");
        props.put("mail.transport.protocol", "smtp");
        final String username = "tupmph28142@fpt.edu.vn";// EMAIL CUA MINH
        final String password = "0375236867";// MAT KHAU EMAIL

        try {
            Session session = Session.getDefaultInstance(props,
                    new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

            // -- Create a new message --
            Message msg = new MimeMessage(session);

            // -- Set the FROM and TO fields --
            msg.setFrom(new InternetAddress("tupmph28142@fpt.edu.vn"));// EMAIL CUA MINH
            msg.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(toEmail, false));// toEmail: email muon gui den
            msg.setSubject("Tài khoản và mật khẩu của bạn");// TIEU DE EMAIL
            //msg.setText("Tài khoản: "+ toTaiKhoan);// NOI DUNG EMAIL
            msg.setText("Tai khoan: " + toTaiKhoan + "|" + "Mat khau: " + toMatKhau);

            msg.setSentDate(new Date());
            Transport.send(msg);

        } catch (MessagingException e) {
            System.out.println("Loi gui tin nhan " + e);
        }
        //listNhanVien.add(e);
        //loadtable();
    }//GEN-LAST:event_btnthemActionPerformed

    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed
        // TODO add your handling code here:
        int rowsua = tableluutru.getSelectedRow();
        if (rowsua == -1) {
            JOptionPane.showMessageDialog(this, "Chọn để sửa");
            return;
        }
        NhanVienRepository nhanVienRepository = new NhanVienRepository();
        NhanVien nhanVien = nhanVienRepository.getOne((String) modelnv2.getValueAt(rowsua, 0).toString());

        nhanVien.setMaNhanVien((String) modelnv2.getValueAt(rowsua, 0));
        nhanVien.setHoTen(txttennv.getText());
        nhanVien.isGioiTinh();
        nhanVien.setTenCV((String) cbbchucvu.getSelectedItem());
        nhanVien.setEmail(txtemail.getText());
        nhanVien.setQueQuan(txtque.getText());
        nhanVien.setNgaySinh(jcalendarngaysinh.getDate());
        nhanVien.setTaiKhoan(txttaikhaon.getText());
        nhanVien.setMatKhau(txtmatkhau.getText());

        NhanVienService nhanVienService = new NhanVienServiceImpl();
        nhanVienService.update(nhanVien);
        list1 = nhanVienService.getAllTrue();
        list2 = nhanVienService.getAllFalse();
        //list3 = nhanVienService.getAllTrue();
        loadnv1(list1);
        loadnv2(list2);
        //loadnv3(list3);
        //loadtable();
        JOptionPane.showMessageDialog(this, "Sửa thành công");
    }//GEN-LAST:event_btnsuaActionPerformed

    private void btnxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaActionPerformed
        // TODO add your handling code here:
        int row = tableluutru.getSelectedRow();
//        if (row == -1) {
//            return;
//        }
        NhanVienRepository nhanVienRepository = new NhanVienRepository();
        NhanVien nhanVien = nhanVienRepository.getOne((String) modelnv2.getValueAt(row, 0).toString());
        nhanVien.setDeleted(Boolean.TRUE);
        nhanVienRepository.update(nhanVien);
        modelnv2.removeRow(row);
        list1 = nhanvienService.getAllTrue();
        list2 = nhanvienService.getAllFalse();
        loadnv1(list1);
        loadnv2(list2);
        //loadtable();
        JOptionPane.showMessageDialog(this, "Xóa thành công");
    }//GEN-LAST:event_btnxoaActionPerformed

    private void btnhoatdonglaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhoatdonglaiActionPerformed
        // TODO add your handling code here:
        int row = tablenv.getSelectedRow();
        if (row == -1) {
            return;
        }
        NhanVienRepository nhanVienRepository = new NhanVienRepository();
        NhanVien nhanVien = nhanVienRepository.getOne((String) modelnv1.getValueAt(row, 0).toString());
        nhanVien.setDeleted(Boolean.FALSE);
        nhanVienRepository.update(nhanVien);
        modelnv1.removeRow(row);
        list1 = nhanvienService.getAllTrue();
        list2 = nhanvienService.getAllFalse();
        loadnv1(list1);
        loadnv2(list2);
        JOptionPane.showMessageDialog(this, "Hoạt động thành công");
        //loadtable();
    }//GEN-LAST:event_btnhoatdonglaiActionPerformed

    private void pn_ThoatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_ThoatMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_pn_ThoatMouseClicked

    private void pn_ThoatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_ThoatMouseEntered
        // TODO add your handling code here:
        pn_Thoat.setBackground(Color.red);
    }//GEN-LAST:event_pn_ThoatMouseEntered

    private void pn_ThoatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_ThoatMouseExited
        // TODO add your handling code here:
        pn_Thoat.setBackground(new Color(0, 0, 102));
    }//GEN-LAST:event_pn_ThoatMouseExited

    private void jButton54ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton54ActionPerformed

        JOptionPane.showMessageDialog(this, "CHÚ Ý : TRƯỚC ĐÓ HÃY NHẬP ĐẦU ĐỦ Ở KHUNG : Thống kê thông tin theo thời gian");
        try {

            if (checktimkiemtheokhoangtime()) {
                if (kt == 0) {
                    if (loadbangthongtheotimkiemkhoangtime0()) {
                        guibaocao();
                    }

                } else {
                    if (loadbangthongtheotimkiemkhoangtime1()) {
                        guibaocao();
                    }

                }

            }

        } catch (ParseException ex) {
            Logger.getLogger(ViewSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }

        //
    }//GEN-LAST:event_jButton54ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        xuatexcelthongke();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton53ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton53ActionPerformed

        try {

            if (checktimkiemtheokhoangtime()) {
                if (kt == 0) {
                    ngaybatdau = chuyen_d_M_y(tfngaybatdauthongke.getDate());
                    nayketthuc = chuyen_d_M_y(tfketthucngaythongke.getDate());
                    loadbangthongtheotimkiemkhoangtime0();
                    locsanphambanchaytheokhoangtime();
                } else {
                    ngaybatdau = chuyen_d_M_y(tfngaybatdauthongke.getDate());
                    nayketthuc = chuyen_d_M_y(tfketthucngaythongke.getDate());
                    loadbangthongtheotimkiemkhoangtime1();
                    locsanphambanchaytheokhoangtime();
                }

            }

        } catch (ParseException ex) {
            Logger.getLogger(ViewSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton53ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        if (tftimkiemthongke.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Hãy Nhập MÃ SẢN PHẨM");
        } else {
            if (ngaybatdau.equals("a") || ngaybatdau.equals("a")) {
                timkiemthongke();
            } else {
                locsanphambanchaytheokhoangtimetimkiem();

                if (kt == 0) {
                    try {
                        loadbangthongtheotimkiemkhoangtime0theomasanpham();
                    } catch (ParseException ex) {
                        Logger.getLogger(ViewSanPham.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    try {
                        loadbangthongtheotimkiemkhoangtime1theomasanpham();
                    } catch (ParseException ex) {
                        Logger.getLogger(ViewSanPham.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }

        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton47ActionPerformed

        if (ngaybatdau.equals("a") || ngaybatdau.equals("a")) {
            loadbangthongketangdantheothanhtien();
        } else {
            locsanphambanchaytheokhoangtimetangdan();
            if (kt == 0) {
                try {
                    loadbangthongtheotimkiemkhoangtime0tangdan();
                } catch (ParseException ex) {
                    Logger.getLogger(ViewSanPham.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    loadbangthongtheotimkiemkhoangtime1tangdan();
                } catch (ParseException ex) {
                    Logger.getLogger(ViewSanPham.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }//GEN-LAST:event_jButton47ActionPerformed

    private void jButton52ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton52ActionPerformed

        if (ngaybatdau.equals("a") || ngaybatdau.equals("a")) {
            loadbangthongkegiamdantheothanhtien();
        } else {
            locsanphambanchaytheokhoangtimegiamdan();

            if (kt == 0) {
                try {
                    loadbangthongtheotimkiemkhoangtime0giamdan();
                } catch (ParseException ex) {
                    Logger.getLogger(ViewSanPham.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {

                try {
                    loadbangthongtheotimkiemkhoangtime1giamdan();
                } catch (ParseException ex) {
                    Logger.getLogger(ViewSanPham.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }//GEN-LAST:event_jButton52ActionPerformed

    private void tbbangsanphambanchaynhatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbbangsanphambanchaynhatMouseClicked
        kiemtravitribangthongke = 2;
    }//GEN-LAST:event_tbbangsanphambanchaynhatMouseClicked

    private void tbbangthongkeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbbangthongkeMouseClicked
        kiemtravitribangthongke = 1;
    }//GEN-LAST:event_tbbangthongkeMouseClicked

    private void jButton56ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton56ActionPerformed
        // TODO add your handling code here:
        loadbangsanphamtonthongkeTANGDAN();
    }//GEN-LAST:event_jButton56ActionPerformed

    private void jButton57ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton57ActionPerformed
        // TODO add your handling code here:
        loadbangsanphamtonthongkeGIAMDAN();
    }//GEN-LAST:event_jButton57ActionPerformed

    private void jButton58ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton58ActionPerformed
        // TODO add your handling code here:
        if (tftimkiemsanphamton.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Hãy Nhập MÃ SẢN PHẨM");
        } else {

            timkiemthongke1();
        }
    }//GEN-LAST:event_jButton58ActionPerformed

    private void tbsanphamtonthongkeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbsanphamtonthongkeMouseClicked
        kiemtravitribangthongke = 3;
    }//GEN-LAST:event_tbsanphamtonthongkeMouseClicked

    private void jButton59ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton59ActionPerformed

        if (tfOX.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Nhập không đúng định dạng dd-MM-yyyy");

        } else {

            b.add(new bieudo(chuyenngayY_M_D(chuyen_d_M_y(tfOX.getDate())), doanhthu(chuyenngayY_M_D(chuyen_d_M_y(tfOX.getDate())))));
            loadbangbieudo();
        }
    }//GEN-LAST:event_jButton59ActionPerformed

    private void jButton60ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton60ActionPerformed

        int vt = tbbangbieudo.getSelectedRow();

        if (vt < 0) {
            JOptionPane.showMessageDialog(this, "bạn chưa chọn đối tượng để cập nhật");

        } else {
            if (tfOX.getDate() == null) {
                JOptionPane.showMessageDialog(this, "Bạn chưa nhập OX(dd-MM-yyyy)  cập nhật");
            } else {

                b.get(vt).setOx(chuyenngayY_M_D(chuyen_d_M_y(tfOX.getDate())));
                b.get(vt).setOy(doanhthu(chuyenngayY_M_D(chuyen_d_M_y(tfOX.getDate()))));
                loadbangbieudo();
            }

        }
    }//GEN-LAST:event_jButton60ActionPerformed

    private void jButton61ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton61ActionPerformed
        int vt = tbbangbieudo.getSelectedRow();   //>=0
        int tong = tbbangbieudo.getSelectedRowCount(); //>0
        System.err.println("" + vt);
        System.out.println("" + tong);
        if (vt >= 0 && tong > 0) {
            for (int i = 0; i < tong; i++) {
                b.remove(vt);
                loadbangbieudo();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn đối tượng để xóa");
        }

        //        System.out.println("bat dau --"+b.get(3).getOx());
        //        b.remove(3);
        //           System.out.println("sau do --"+b.get(3).getOx());
    }//GEN-LAST:event_jButton61ActionPerformed

    private void jButton55ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton55ActionPerformed
        ChartPanel chartPanel = new ChartPanel(createChart(b));
        chartPanel.setPreferredSize(new java.awt.Dimension(10, 10));
        JFrame frame = new JFrame();
        frame.add(chartPanel);
        frame.setTitle("Biểu đồ thống kê doanh thu ");
        frame.setSize(1200, 800);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }//GEN-LAST:event_jButton55ActionPerformed

    private void tbbangbieudoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbbangbieudoMouseClicked
        int vt = tbbangbieudo.getSelectedRow();

        try {
            Date date = new SimpleDateFormat("dd-MM-yyyy").parse(tbbangbieudo.getValueAt(vt, 1).toString());
            tfOX.setDate(date);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_tbbangbieudoMouseClicked

    private void txtDonGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDonGiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDonGiaActionPerformed
    private void tblThongtinKH1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThongtinKH1MouseClicked
        detailKH();
    }//GEN-LAST:event_tblThongtinKH1MouseClicked

    private void jButton9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseClicked
        if (validateKH() != null) {

        }
    }//GEN-LAST:event_jButton9MouseClicked

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        int index = -1;
        index = tblThongtinKH1.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn khách hàng muốn sửa");
        } else {
            String MaKH = dtmKH.getValueAt(index, 0).toString();
            int id = -1;
            List<KhachHang> lst = khachHangService.getAll1();
            for (KhachHang x : lst) {
                if (x.getMaKH().equals(MaKH)) {
                    id = x.getId();
                    break;
                }
            }
            KhachHang kh = validateKH();
            kh.setId(id);
            updateKH(kh);
            SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
            dtmKH.setValueAt(kh.getMaKH(), index, 0);
            dtmKH.setValueAt(kh.getHoTen(), index, 1);
            dtmKH.setValueAt(kh.getSdt(), index, 2);
            dtmKH.setValueAt(kh.getEmail(), index, 3);
            String gt = "";
            if (kh.isGioiTinh()) {
                gt = "Nam";
            } else {
                gt = "Nữ";
            }
            dtmKH.setValueAt(gt, index, 4);
            dtmKH.setValueAt(f.format(kh.getNgaySinh()), index, 5);
            dtmKH.setValueAt(kh.getDiaChi(), index, 6);
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        int index = -1;
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        String gioitinh = "";
        index = tblThongtinKH1.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn khách hàng muốn xoá");
        } else {
            String MaKH = dtmKH.getValueAt(index, 0).toString();
            int id = -1;
            List<KhachHang> lst = khachHangService.getAll1();
            for (KhachHang x : lst) {
                if (x.getMaKH().equals(MaKH)) {
                    id = x.getId();
                    break;
                }
            }
            KhachHang kh = validateKH();
            kh.setId(id);
            deleteKH(kh);
            dtmKH.removeRow(index);
            if (kh.isGioiTinh()) {
                gioitinh = "Nam";
            } else {
                gioitinh = "Nữ";
            }
            dtmKHDeleted.addRow(new Object[]{kh.getMaKH(), kh.getHoTen(), kh.getSdt(), kh.getEmail(), gioitinh, format.format(kh.getNgaySinh()), kh.getDiaChi(), format.format(kh.getCreatedAt())});
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        clearKH();
    }//GEN-LAST:event_jButton15ActionPerformed

    private void btnLichSuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLichSuActionPerformed
        lichsuKH();
    }//GEN-LAST:event_btnLichSuActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        NhanVien nv = dvnv.getOneByUsername(dataConstructor);

        System.out.println(generatedString);

        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
        // Get a Properties object
        Properties props = System.getProperties();
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.auth", "true");
        props.put("mail.debug", "true");
        props.put("mail.store.protocol", "pop3");
        props.put("mail.transport.protocol", "smtp");
        final String username = "tupmph28142@fpt.edu.vn";//
        final String password = "0375236867";
        final String toEmail = nv.getEmail();
        try {
            Session session = Session.getDefaultInstance(props,
                    new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

            // -- Create a new message --
            Message msg = new MimeMessage(session);

            // -- Set the FROM and TO fields --
            msg.setFrom(new InternetAddress("tupmph28142@fpt.edu.vn"));
            msg.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(toEmail, false));
            msg.setSubject("Doi mat khau");
            msg.setText("Ma xac nhan cua ban la: " + generatedString);
            msg.setSentDate(new Date());
            Transport.send(msg);
            JOptionPane.showMessageDialog(this, "Ma xac nhan da duoc gui ve gmail cua ban. Vui long kiem tra gmail!");

        } catch (MessagingException e) {
            System.out.println("Loi gui tin nhan " + e);
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton50ActionPerformed
        NhanVien nv = dvnv.getOneByUsername(dataConstructor);

        if (txtMatKhauCu.getText().trim().length() == 0 || txtMatKhauMoi.getText().trim().length() == 0 || txtNhapLai.getText().trim().length() == 0 || txtMaXN.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "Thông tin không được để trống");
            return;

        }
        if (!nv.getMatKhau().contains(txtMatKhauCu.getText())) {
            JOptionPane.showMessageDialog(this, "Mật khẩu cũ không đúng");
            return;
        } else {
            if (!txtMatKhauMoi.getText().contains(txtNhapLai.getText())) {
                JOptionPane.showMessageDialog(this, "Mật khẩu khôn khớp");
                return;
            } else {
                if (!txtMaXN.getText().contains(generatedString)) {
                    JOptionPane.showMessageDialog(this, "Mã xác nhận không đúng");
                    return;
                } else {
                    nvr.doimk(nv.getEmail(), txtMatKhauMoi.getText());
                    JOptionPane.showMessageDialog(this, "Đổi mật khẩu thành công");
                }
            }
        }

    }//GEN-LAST:event_jButton50ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int conFirm = JOptionPane.showConfirmDialog(null, "Bạn có muốn đăng xuất?");
        if (conFirm == 0) {
            JOptionPane.showMessageDialog(this, "Đăng xuất thành công");
            ViewDangNhap v = new ViewDangNhap();
            v.setLocationRelativeTo(null);
            v.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tblGioHang1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGioHang1MouseClicked


    }//GEN-LAST:event_tblGioHang1MouseClicked

    private void btnXoaSPGioHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaSPGioHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnXoaSPGioHangActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed

    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void tbbanhhoadonbanhangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbbanhhoadonbanhangMouseClicked
        clicksanphamragiohang();
        //kh

    }//GEN-LAST:event_tbbanhhoadonbanhangMouseClicked

    private void tbbanhhoadonbanhangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbbanhhoadonbanhangMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tbbanhhoadonbanhangMouseEntered

    private void tbgiohangbanhangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbgiohangbanhangMouseClicked

        String v = tbgiohangbanhang.getValueAt(tbgiohangbanhang.getSelectedRow(), 1).toString();
        int vtspbanhang = -1;
        for (int i = 0; i < rp.clhoadonrabanggiohang(v).size(); i++) {
            if (v.equals(rp.clhoadonrabanggiohang(v).get(i).getMasp())) {
                vtspbanhang = i;
            }
        }
        int vt = vtspbanhang;
        ///

        int vtsanpham = vt;
        //

        int vthoadon = -1;
        if (tbbanhhoadonbanhang.getSelectedRow() >= 0) {
            for (int i = 0; i < rp.gethdbanhang().size(); i++) {
                if (tbbanhhoadonbanhang.getValueAt(tbbanhhoadonbanhang.getSelectedRow(), 1).toString().equals(rp.gethdbanhang().get(i).getMaHD())) {
                    vthoadon = i;
                }
            }
        }

        int vtbanghoadon = vthoadon;

        String tenbang = "giohang";
        banhangimei m = new banhangimei(this, rootPaneCheckingEnabled, v, vtsanpham, vtbanghoadon, tenbang);
        m.show();
    }//GEN-LAST:event_tbgiohangbanhangMouseClicked

    private void tbbangsanphambanhangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbbangsanphambanhangMouseClicked

        int vtspbanhang = -1;
        for (int i = 0; i < rp.getsanphambanhang().size(); i++) {
            if (tbbangsanphambanhang.getValueAt(tbbangsanphambanhang.getSelectedRow(), 1).toString().equals(rp.getsanphambanhang().get(i).getMasp())) {
                vtspbanhang = i;
            }
        }
        int vt = vtspbanhang;
        ///
        String v = tbbangsanphambanhang.getValueAt(tbbangsanphambanhang.getSelectedRow(), 1).toString();
        int vtsanpham = vt;
        //

        int vthoadon = -1;
        if (tbbanhhoadonbanhang.getSelectedRow() >= 0) {
            for (int i = 0; i < rp.gethdbanhang().size(); i++) {
                if (tbbanhhoadonbanhang.getValueAt(tbbanhhoadonbanhang.getSelectedRow(), 1).toString().equals(rp.gethdbanhang().get(i).getMaHD())) {
                    vthoadon = i;
                }
            }
        }

        int vtbanghoadon = vthoadon;

        String tenbang = "sanpham";
        banhangimei m = new banhangimei(this, rootPaneCheckingEnabled, v, vtsanpham, vtbanghoadon, tenbang);
        m.show();
    }//GEN-LAST:event_tbbangsanphambanhangMouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        cbbanhangkhachhang.setModel(new DefaultComboBoxModel(rp.getkhachhangbanhang().toArray()));
    }//GEN-LAST:event_jLabel4MouseClicked

    private void cbbanhangkhachhangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbanhangkhachhangMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbanhangkhachhangMouseClicked

    private void cbbanhangkhachhangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbanhangkhachhangActionPerformed

    }//GEN-LAST:event_cbbanhangkhachhangActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        bangthongtinkhachhangkhibanhang V = new bangthongtinkhachhangkhibanhang(this, rootPaneCheckingEnabled);
        V.show();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void KMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KMActionPerformed
        bangthongtinkhuyenmaineudangkythanhvien M = new bangthongtinkhuyenmaineudangkythanhvien(this, rootPaneCheckingEnabled);
        M.show();

    }//GEN-LAST:event_KMActionPerformed

    private void tftienkhachduaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tftienkhachduaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tftienkhachduaActionPerformed

    private void rdtienmatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdtienmatMouseClicked
        if (tbbanhhoadonbanhang.getSelectedRow() >= 0) {

            String mahdc = tbbanhhoadonbanhang.getValueAt(tbbanhhoadonbanhang.getSelectedRow(), 1).toString();
            int vtid = 0;
            for (int i = 0; i < rp.gethdbanhang().size(); i++) {
                if (mahdc.equals(rp.gethdbanhang().get(i).getMaHD())) {
                    vtid = i;
                }
            }
            if (rp.gethdbanhang().get(vtid).getTrangthai() == 0) {

                ///////////////////
                tftienkhachdua.setEditable(true);
                tftienkhachdua.setText("");
                ////////////////////////////

                Thread thread = new Thread() {
                    @Override
                    public void run() {
                        while (true) {
                            if (kttiennhap()) {

                                if (tenkhachhangbanhang.equals("khách bán lẻ")) {

                                    float tien = Float.parseFloat(tftienkhachdua.getText());

                                    double tienthua = (double) (tien - tongtienhangbanhang);
                                    tftienthua.setText(String.format("%,.2f", tienthua) + " VND");

                                } else {
                                    float tien = Float.parseFloat(tftienkhachdua.getText());

                                    double tienthua = (double) (tien - tongtienhangsaukhuyenmai);
                                    tftienthua.setText(String.format("%,.2f", tienthua) + " VND");

                                }

                            } else {
                                tftienthua.setText("0");
                            }

                            try {
                                Thread.sleep(1);
                            } catch (Exception ex) {

                            }
                        }
                    }
                };
                thread.start();

                /////////////////
            }

        }
    }//GEN-LAST:event_rdtienmatMouseClicked

    private void rdtienmatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdtienmatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdtienmatActionPerformed

    private void rdchuyenkhoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdchuyenkhoanMouseClicked
        if (tbbanhhoadonbanhang.getSelectedRow() >= 0) {

            String mahdc = tbbanhhoadonbanhang.getValueAt(tbbanhhoadonbanhang.getSelectedRow(), 1).toString();
            int vtid = 0;
            for (int i = 0; i < rp.gethdbanhang().size(); i++) {
                if (mahdc.equals(rp.gethdbanhang().get(i).getMaHD())) {
                    vtid = i;
                }
            }
            if (rp.gethdbanhang().get(vtid).getTrangthai() == 0) {

                tftienkhachdua.setText(tfphaitra.getText());
                tftienthua.setText("0");
                tftienkhachdua.setEditable(false);

                ///////////////////
            }

        }
    }//GEN-LAST:event_rdchuyenkhoanMouseClicked

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        //   System.out.println("tacos---"+cbbanhangkhachhang.getSelectedIndex()+"---"+rp.getkhachhangbanhang().get(cbbanhangkhachhang.getSelectedIndex()).getMakh());
        JOptionPane.showMessageDialog(this, rp.taohoadonbanhang(manhanviendangnhap, rp.getkhachhangbanhang().get(cbbanhangkhachhang.getSelectedIndex()).getMakh()));
        loadtablebanhanghoadon();
        loadtablebanhangsanpham();
        DefaultTableModel defaultTable = new DefaultTableModel();

        defaultTable = (DefaultTableModel) tbgiohangbanhang.getModel();
        defaultTable.setRowCount(0);

    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton14MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton14MouseClicked

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed

        if (tbbanhhoadonbanhang.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn hóa đơn để thanh toán");
        } else {

            clicksanphamragiohang____kethop(tbbanhhoadonbanhang.getSelectedRow());

            int vthd = 0;
            for (int i = 0; i < rp.gethdbanhang().size(); i++) {
                if (tbbanhhoadonbanhang.getValueAt(tbbanhhoadonbanhang.getSelectedRow(), 1).toString().equals(rp.gethdbanhang().get(i).getMaHD())) {
                    vthd = i;
                }
            }
            if (rp.gethdbanhang().get(vthd).getTrangthai() == 1) {
                JOptionPane.showMessageDialog(this, "Hóa đơn mã : " + tbbanhhoadonbanhang.getValueAt(tbbanhhoadonbanhang.getSelectedRow(), 1).toString() + " đã được thanh toán.\n"
                        + "Nên bạn không thể thanh toán tiếp hóa đơn đó....");
            } else {

                if (rdtienmat.isSelected() || rdchuyenkhoan.isSelected()) {

                    if (rdtienmat.isSelected()) {
                        //tien mat
                        if (tftienkhachdua.getText().isBlank() || tftienkhachdua.getText().isEmpty()) {

                            JOptionPane.showMessageDialog(this, "Tiền khách đưa không được để trống");

                        } else {

                            if (kttiennhap()) {

                                float tiendua = Float.parseFloat(tftienkhachdua.getText());

                                if (tiendua > tongtienhangsaukhuyenmai) {
                                    JOptionPane.showMessageDialog(this, "Khách hàng đã dưa thừa tiền\n"
                                            + "Nhân viên hãy trả lại tiền cho khách hàng rồi hãng thanh toán");
                                } else if (tiendua < tongtienhangsaukhuyenmai) {
                                    JOptionPane.showMessageDialog(this, "Khách hàng đã dưa thiếu tiền\n"
                                            + "Không thể thanh toán");
                                } else {

                                    //thanh toán
                                    String tiendakhuyenmai = String.valueOf(tongtienhangsaukhuyenmai);

                                    if (rp.Thanhtoanhoadon(tiendakhuyenmai, tbbanhhoadonbanhang.getValueAt(tbbanhhoadonbanhang.getSelectedRow(), 1).toString()).equals("Thanh toán  thanh công")) {
                                        JOptionPane.showMessageDialog(this, "Thanh toán thành công");
                                        int vitri = JOptionPane.showConfirmDialog(this, "BẠN CÓ MUỐN XUẤT HÓA ĐƠN KHÔNG");
                                        if (vitri == 0) {
                                            if (xuathoadon(tbbanhhoadonbanhang.getValueAt(tbbanhhoadonbanhang.getSelectedRow(), 1).toString())) {
                                                JOptionPane.showMessageDialog(this, "Xuất hóa đơn thành công");
                                            } else {

                                                JOptionPane.showMessageDialog(this, "Xuất hóa đơn thất bại");
                                            }
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(this, "Thanh toán thất bại");
                                    }
                                    tftienkhachdua.setText("");
                                    for (sanphambanhang sp : rp.getsanphambanhang()) {
                                        rp.capnhatsolgsanpham(sp.getMasp());
                                    }
                                    for (sanphambanhang om : rp.clhoadonrabanggiohang(tbbanhhoadonbanhang.getValueAt(tbbanhhoadonbanhang.getSelectedRow(), 1).toString())) {
                                        rp.capnhatsoluonghoadonchitiet(om.getIdhdct());
                                    }

                                    loadtablebanhanghoadon();
                                    loadtablebanhangsanpham();

                                    DefaultTableModel defaultTable = new DefaultTableModel();

                                    defaultTable = (DefaultTableModel) tbgiohangbanhang.getModel();
                                    defaultTable.setRowCount(0);

                                }

                            } else {

                                JOptionPane.showMessageDialog(this, "Tiền khách đưa không hợp lệ\n"
                                        + "(Tiền khách đưa chỉ được ghi số)");

                            }

                        }

                    } else {
                        //chuyen khoan
                        if (tftienkhachdua.getText().isBlank() || tftienkhachdua.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(this, "Bạn hãy chọn lại phương thức thanh toán");

                        } else {

                            //thanh toán
                            String tiendakhuyenmai = String.valueOf(tongtienhangsaukhuyenmai);

                            if (rp.Thanhtoanhoadon(tiendakhuyenmai, tbbanhhoadonbanhang.getValueAt(tbbanhhoadonbanhang.getSelectedRow(), 1).toString()).equals("Thanh toán  thanh công")) {
                                JOptionPane.showMessageDialog(this, "Thanh toán thành công");
                                int vitri = JOptionPane.showConfirmDialog(this, "BẠN CÓ MUỐN XUẤT HÓA ĐƠN KHÔNG");
                                if (vitri == 0) {
                                    if (xuathoadon(tbbanhhoadonbanhang.getValueAt(tbbanhhoadonbanhang.getSelectedRow(), 1).toString())) {
                                        JOptionPane.showMessageDialog(this, "Xuất hóa đơn thành công");
                                    } else {

                                        JOptionPane.showMessageDialog(this, "Xuất hóa đơn thất bại");
                                    }
                                }
                            } else {
                                JOptionPane.showMessageDialog(this, "Thanh toán thất bại");
                            }
                            tftienkhachdua.setText("");
                            for (sanphambanhang sp : rp.getsanphambanhang()) {
                                rp.capnhatsolgsanpham(sp.getMasp());
                            }
                            for (sanphambanhang om : rp.clhoadonrabanggiohang(tbbanhhoadonbanhang.getValueAt(tbbanhhoadonbanhang.getSelectedRow(), 1).toString())) {
                                rp.capnhatsoluonghoadonchitiet(om.getIdhdct());
                            }
                            loadtablebanhanghoadon();
                            loadtablebanhangsanpham();

                            DefaultTableModel defaultTable = new DefaultTableModel();

                            defaultTable = (DefaultTableModel) tbgiohangbanhang.getModel();
                            defaultTable.setRowCount(0);

                        }

                    }

                } else {
                    JOptionPane.showMessageDialog(this, "Bạn chưa chọn phương thức thanh toán");
                }

            }

        }


    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        if (tbbanhhoadonbanhang.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn hóa đơn muốn hủy");
        } else {
            String mahdc = tbbanhhoadonbanhang.getValueAt(tbbanhhoadonbanhang.getSelectedRow(), 1).toString();
            int vtid = 0;
            for (int i = 0; i < rp.gethdbanhang().size(); i++) {
                if (mahdc.equals(rp.gethdbanhang().get(i).getMaHD())) {
                    vtid = i;
                }
            }
            if (rp.gethdbanhang().get(vtid).getTrangthai() == 1) {

                JOptionPane.showMessageDialog(this, "Hóa đơn " + mahdc + " đã được thanh toán .\n"
                        + "Nên không được hủy");

            } else {
                JOptionPane.showMessageDialog(this, rp.huyhoadon(mahdc));

                loadtablebanhanghoadon();
                loadtablebanhangsanpham();

                DefaultTableModel defaultTable = new DefaultTableModel();

                defaultTable = (DefaultTableModel) tbgiohangbanhang.getModel();
                defaultTable.setRowCount(0);

            }

        }

    }//GEN-LAST:event_jButton16ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void tbl_KhuyenMaiNgungHoatDongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_KhuyenMaiNgungHoatDongMouseClicked
        for (int i = 0; i < listSanPham.size(); i++) {
            dfm3.setValueAt(false, i, 1);
        }
        showDataKM5();        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_KhuyenMaiNgungHoatDongMouseClicked

    private void tbl_KhuyenMaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_KhuyenMaiMouseClicked
        for (int i = 0; i < listSanPham.size(); i++) {
            dfm3.setValueAt(false, i, 1);
        }
        showDataKM4();
        bt_addKM.setEnabled(false);
        bt_suaKM.setEnabled(false);
        bt_xoaKM.setEnabled(false);

        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_KhuyenMaiMouseClicked

    private void bt_addKMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_addKMActionPerformed
        KhuyenMai khuyenMai = getDataKM();
        if (khuyenMai.getNgayBatDau().after(khuyenMai.getNgayKetThuc())) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập lại ngày");
            return;
        }

        for (KhuyenMai list : khuyenMaiService.getAll()) {
            if (list.getMaKM().equals(khuyenMai.getMaKM())) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập lại,mã khuyến mãi đã trùng");
                return;
            }
        }
        if (khuyenMai.getNgayKetThuc().before(khuyenMai.getNgayKetThuc()) == true) {
            JOptionPane.showMessageDialog(this, "Vui lòng ngày bắt đầu và ngày kết thúc");
            return;
        }
        SanPhamGiamGiaRepository phamRepository = new SanPhamGiamGiaRepository();
        khuyenMaiService.addTheoHoaDon(khuyenMai);
        SanPhamGiamGia gia = new SanPhamGiamGia();
        gia.setKhuyenMai(khuyenMai);
        for (int i = 0; i < sanPhamService.getAll().size(); i++) {
            SanPhamRepository phamRepository1 = new SanPhamRepository();
            SanPham pham = phamRepository1.getOneSP(dfm3.getValueAt(i, 0).toString());
            if (dfm3.getValueAt(i, 1) == Boolean.TRUE) {
                gia.setSanPham(pham);
                phamRepository.add(gia);
            }
        }
        JOptionPane.showMessageDialog(this, "Thêm khuyến mãi thành công");
        lists = khuyenMaiService.getAllTrue();
        lists2 = khuyenMaiService.getAllFalse();
        showDataKM(lists);
        showDataKM2(lists2);
        showDataKM3(listSanPham);
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_addKMActionPerformed

    private void bt_suaKMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_suaKMActionPerformed
        int index = tbl_KhuyenMaiNgungHoatDong.getSelectedRow();
        KhuyenMaiRepository khuyenMaiRepository = new KhuyenMaiRepository();
        KhuyenMai khuyenMai = khuyenMaiRepository.getOne((int) dfm.getValueAt(index, 0));
        if (index == -1) {
            JOptionPane.showMessageDialog(rootPane, "Bạn chưa chọn hàng cần sửa!");
        } else {
            if (!khuyenMai.getMaKM().equals(txt_MaGiamGia.getText())) {
                JOptionPane.showMessageDialog(this, "Không được sửa mã khuyến mãi");
                return;
            }
            khuyenMai.setId((int) dfm.getValueAt(index, 0));
            khuyenMai.setMaKM(txt_MaGiamGia.getText());
            khuyenMai.setTenKM(txt_TenKM.getText());
            khuyenMai.setCreatedAt(java.util.Calendar.getInstance().getTime());
            khuyenMai.setUpdatedAt(null);
            khuyenMai.setNgayBatDau(dtc_DenNgay.getDate());
            khuyenMai.setNgayKetThuc(dtc_TuNgay.getDate());
            khuyenMai.setSoTienGiam(Float.parseFloat(txt_MucGiam.getText()));
            if (dtc_DenNgay.getDate().after(java.util.Calendar.getInstance().getTime()) || dtc_DenNgay.getDate().equals(java.util.Calendar.getInstance().getTime())) {
                khuyenMai.setDeleted(false);
            } else if (dtc_DenNgay.getDate().before(java.util.Calendar.getInstance().getTime())) {
                khuyenMai.setDeleted(true);
            }
            KhuyenMaiService khuyenMaiService = new KhuyenMaiServiceImpl();
            khuyenMaiService.update(khuyenMai);
            System.out.println(khuyenMai.toString());
            SanPhamGiamGiaRepository phamRepository = new SanPhamGiamGiaRepository();
            SanPhamGiamGia gia = new SanPhamGiamGia();
            gia.setKhuyenMai(khuyenMai);
            List<SanPhamGiamGia> giamGias = phamRepository.getAllSP(khuyenMai.getId());
            for (SanPhamGiamGia giamGia : giamGias) {
                phamRepository.delete(giamGia);
            }
            for (int i = 0; i < sanPhamService.getAll().size(); i++) {
                SanPhamRepository phamRepository1 = new SanPhamRepository();
                SanPham pham = phamRepository1.getOneSP(dfm3.getValueAt(i, 0).toString());
                if (dfm3.getValueAt(i, 1) == Boolean.TRUE) {
                    gia.setSanPham(pham);
                    phamRepository.add(gia);
                }
            }
            lists = khuyenMaiService.getAllTrue();
            lists2 = khuyenMaiService.getAllFalse();
            showDataKM(lists);
            showDataKM2(lists2);
            showDataKM3(listSanPham);
            JOptionPane.showMessageDialog(this, "Sửa thành công!");

        }        // TODO add your handling code here:
    }//GEN-LAST:event_bt_suaKMActionPerformed

    private void bt_xoaKMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_xoaKMActionPerformed
        int row = tbl_KhuyenMaiNgungHoatDong.getSelectedRow();
       
        int conFirm = JOptionPane.showConfirmDialog(null, "Bạn muốn hủy khuyến mãi?");
        if (conFirm == 0) {
             KhuyenMaiRepository khuyenMaiRepository = new KhuyenMaiRepository();
        KhuyenMai khuyenMai = khuyenMaiRepository.getOne((int) dfm.getValueAt(row, 0));
        khuyenMai.setDeleted(Boolean.TRUE);
        khuyenMaiRepository.update(khuyenMai);
        dfm.removeRow(row);
        lists = khuyenMaiService.getAllTrue();
        lists2 = khuyenMaiService.getAllFalse();
        showDataKM(lists);
        showDataKM2(lists2);
        showDataKM3(listSanPham);
        }
        JOptionPane.showMessageDialog(this, "Hủy khuyến mãi thành công");

        // TODO add your handling code here:
    }//GEN-LAST:event_bt_xoaKMActionPerformed

    private void jcbox_AllItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbox_AllItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == 1) {
            for (int i = 0; i < dfm3.getRowCount(); i++) {
                dfm3.setValueAt(true, i, 1);
            }
        } else {
            for (int i = 0; i < dfm3.getRowCount(); i++) {
                dfm3.setValueAt(false, i, 1);
            }
        }
    }//GEN-LAST:event_jcbox_AllItemStateChanged

    private void jcbox_AllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbox_AllActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_jcbox_AllActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        File excelFile;
        FileInputStream excelFIS = null;
        BufferedInputStream excelBIS = null;
        XSSFWorkbook excelJTableImport = null;

        String defaultCurrentDirectoryPath = "E:\\Excel";
        JFileChooser execlFileChooser = new JFileChooser(defaultCurrentDirectoryPath);

        FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlsm");
        execlFileChooser.setFileFilter(fnef);

        execlFileChooser.setDialogTitle("Select Excel File");
        int excelChooser = execlFileChooser.showOpenDialog(null);

        if (excelChooser == JFileChooser.APPROVE_OPTION) {
            try {
                excelFile = execlFileChooser.getSelectedFile();
                excelFIS = new FileInputStream(excelFile);
                excelBIS = new BufferedInputStream(excelFIS);
                excelJTableImport = new XSSFWorkbook(excelBIS);
                XSSFSheet excelSheet = excelJTableImport.getSheetAt(0);

                for (int row = 1; row < excelSheet.getLastRowNum() + 1; row++) {
                    XSSFRow excelRow = excelSheet.getRow(row);

                    XSSFCell MaNV = excelRow.getCell(0);
                    XSSFCell HoTen = excelRow.getCell(1);
                    XSSFCell GioiTinh = excelRow.getCell(2);
                    XSSFCell ChucVu = excelRow.getCell(3);
                    XSSFCell Email = excelRow.getCell(4);
                    XSSFCell QueQuan = excelRow.getCell(5);
                    XSSFCell NgaySinh = excelRow.getCell(6);
                    XSSFCell TaiKhoan = excelRow.getCell(7);
                    XSSFCell MatKhau = excelRow.getCell(8);

                    //JTable excelJL = new JTable;
                    //modelnv2.addRow(new Object[]{excelMaNV, excelHoTen, excelGioiTinh, excelChucVu, excelEmail, excelQueQuan, excelNgaySinh, excelTaiKhoan, excelMatKhau});
                    modelnv2.addRow(new Object[]{MaNV, HoTen, GioiTinh, ChucVu, Email, QueQuan, NgaySinh, TaiKhoan, MatKhau});
                    //modelnv2.addRow(new Object[row]);
                }
                JOptionPane.showMessageDialog(null, "Đã thêm thông tin từ Excel");
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            } finally {

                try {
                    if (excelFIS != null) {
                        excelFIS.close();
                    }
                    if (excelBIS != null) {
                        excelBIS.close();
                    }
                    if (excelJTableImport != null) {
                        excelJTableImport.close();
                    }
                } catch (IOException iOException) {
                    JOptionPane.showMessageDialog(null, iOException.getMessage());
                }
            }
        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnTimKiemKHDeletedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemKHDeletedActionPerformed
        findDeletedKH();
    }//GEN-LAST:event_btnTimKiemKHDeletedActionPerformed

    private void btnRestoreKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestoreKHActionPerformed
        restoreKH();
    }//GEN-LAST:event_btnRestoreKHActionPerformed

    private void tblThongtinKHDeletedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThongtinKHDeletedMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblThongtinKHDeletedMouseClicked

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        findKH();
    }//GEN-LAST:event_btnFindActionPerformed

    private void btnExportHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportHDActionPerformed
        exportexcel();
    }//GEN-LAST:event_btnExportHDActionPerformed

    private void btnSortAscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSortAscActionPerformed
        sortAsc();
    }//GEN-LAST:event_btnSortAscActionPerformed

    private void btnSortDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSortDescActionPerformed
        sortDesc();
    }//GEN-LAST:event_btnSortDescActionPerformed

    private void btnFindHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindHDActionPerformed
        findHD();
    }//GEN-LAST:event_btnFindHDActionPerformed

    private void btnF5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnF5ActionPerformed
        f5();
    }//GEN-LAST:event_btnF5ActionPerformed

    private void tblDSImeiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSImeiMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblDSImeiMouseClicked

    private void btnexportEXCELActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexportEXCELActionPerformed
        // TODO add your handling code here:
         JFileChooser excelFileChooser = new JFileChooser("C:\\Users\\Admin\\Desktop");
        excelFileChooser.setDialogTitle("Save as");
        FileNameExtensionFilter filefilter = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlsm");
        excelFileChooser.setFileFilter(filefilter);
        int check = excelFileChooser.showSaveDialog(null);

        //Check khi ấn nút save
        if (check == JFileChooser.APPROVE_OPTION) {
            FileOutputStream FOS = null;
            BufferedOutputStream BOS = null;
            XSSFWorkbook excelJtableExporter = null;
            try {
                excelJtableExporter = new XSSFWorkbook();
                XSSFSheet excelSheet = excelJtableExporter.createSheet("HoaDon");
                //Lấy số dòng, cột tblHoaDon
                for (int i = 0; i < tableluutru.getRowCount(); i++) {
                    XSSFRow excelRow = excelSheet.createRow(i);
                    for (int j = 0; j < tableluutru.getColumnCount(); j++) {
                        XSSFCell excelCell = excelRow.createCell(j);

                        excelCell.setCellValue(tableluutru.getValueAt(i, j).toString());
                    }
                }

                FOS = new FileOutputStream(excelFileChooser.getSelectedFile() + ".xlsx");
                BOS = new BufferedOutputStream(FOS);
                excelJtableExporter.write(BOS);
                JOptionPane.showMessageDialog(this, "Xuất Thành Công!!!!");
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    if (BOS != null) {
                        BOS.close();
                    }

                    if (FOS != null) {
                        FOS.close();
                    }

                    if (excelJtableExporter != null) {
                        excelJtableExporter.close();
                    }

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

        }
    
    }//GEN-LAST:event_btnexportEXCELActionPerformed

    private void jTabbedPane3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane3MouseClicked
bt_addKM.setEnabled(true);

bt_suaKM.setEnabled(true);

bt_xoaKM.setEnabled(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPane3MouseClicked
    private void txtTongTienHang1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
// đợi

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(ViewSanPham.class
//                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
//
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ViewSanPham.class
//                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
//
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ViewSanPham.class
//                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
//
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ViewSanPham.class
//                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                ViewSanPham v = new ViewSanPham();
//                v.setLocationRelativeTo(null);
//                v.setVisible(true);
//            }
//        });
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewSanPham.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewSanPham.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewSanPham.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewSanPham.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        //java.awt.EventQueue.invokeLater(new Runnable() {
        //@Override
        //public void run() {
        //ViewSanPham v = new ViewSanPham();
        //v.setVisible(true);
        //}
        //});
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton KM;
    private javax.swing.JButton bt_addKM;
    private javax.swing.JButton bt_suaKM;
    private javax.swing.JButton bt_xoaKM;
    private javax.swing.JButton btnDesignAnh;
    private javax.swing.JButton btnDesignChip;
    private javax.swing.JButton btnDesignHang;
    private javax.swing.JButton btnDesignImei;
    private javax.swing.JButton btnDesignMauSac;
    private javax.swing.JButton btnDesignPin;
    private javax.swing.JButton btnDesignRam;
    private javax.swing.JButton btnDesignRom;
    private javax.swing.JButton btnExportHD;
    private javax.swing.JButton btnF5;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnFindHD;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnLichSu;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevius;
    private javax.swing.JButton btnRestoreKH;
    private javax.swing.JButton btnRestoreSanPham;
    private javax.swing.JButton btnSearchSanPham;
    private javax.swing.JButton btnSortAsc;
    private javax.swing.JButton btnSortDesc;
    private javax.swing.JButton btnSuaSanPham;
    private javax.swing.JButton btnThemSanPham;
    private javax.swing.JButton btnTimKiemKHDeleted;
    private javax.swing.JButton btnTimKiemSanPhamDeleted;
    private javax.swing.JButton btnXoaFormSanPham;
    private javax.swing.JButton btnXoaSanPham;
    private javax.swing.JButton btnexportEXCEL;
    private javax.swing.JButton btnhoatdonglai;
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btnthem;
    private javax.swing.JButton btnxoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup1banhang;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup2banhang;
    private javax.swing.JComboBox<String> cbbChip;
    private javax.swing.JComboBox<String> cbbHang;
    private javax.swing.JComboBox<String> cbbMauSac;
    private javax.swing.JComboBox<String> cbbPin;
    private javax.swing.JComboBox<String> cbbRam;
    private javax.swing.JComboBox<String> cbbRom;
    private javax.swing.JComboBox<String> cbbanhangkhachhang;
    private javax.swing.JComboBox<String> cbbchucvu;
    private com.toedter.calendar.JDateChooser dtc_DenNgay;
    private com.toedter.calendar.JDateChooser dtc_TuNgay;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton44;
    private javax.swing.JButton jButton47;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton50;
    private javax.swing.JButton jButton52;
    private javax.swing.JButton jButton53;
    private javax.swing.JButton jButton54;
    private javax.swing.JButton jButton55;
    private javax.swing.JButton jButton56;
    private javax.swing.JButton jButton57;
    private javax.swing.JButton jButton58;
    private javax.swing.JButton jButton59;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton60;
    private javax.swing.JButton jButton61;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel57;
    private javax.swing.JPanel jPanel58;
    private javax.swing.JPanel jPanel59;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel60;
    private javax.swing.JPanel jPanel61;
    private javax.swing.JPanel jPanel63;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane26;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField3;
    private com.toedter.calendar.JDateChooser jcalendarngaysinh;
    private javax.swing.JCheckBox jcbox_All;
    private com.toedter.calendar.JDateChooser jdateFrom;
    private com.toedter.calendar.JDateChooser jdateFrom1;
    private com.toedter.calendar.JDateChooser jdateNgaySinhKH;
    private com.toedter.calendar.JDateChooser jdateTo;
    private javax.swing.JLabel lb_Tendetai;
    private javax.swing.JLabel lbanhbieudo;
    private javax.swing.JLabel lblAnhSanPham;
    private javax.swing.JLabel lblBanHang;
    private javax.swing.JLabel lblHoTenHome;
    private javax.swing.JLabel lblHoaDon;
    private javax.swing.JLabel lblHome;
    private javax.swing.JLabel lblKhuyenMai;
    private javax.swing.JLabel lblMaHome;
    private javax.swing.JLabel lblNhanVien;
    private javax.swing.JLabel lblSanPham;
    private javax.swing.JLabel lblTenChucNang;
    private javax.swing.JLabel lblThoat;
    private javax.swing.JLabel lblThongKe;
    private javax.swing.JLabel lblThongKe1;
    private javax.swing.JLabel lblThongTinCaNhan;
    private javax.swing.JLabel lbngaytaovaban;
    private javax.swing.JPanel pHoaDon;
    private javax.swing.JPanel pImei;
    private javax.swing.JPanel pLoc;
    private javax.swing.JPanel pSanPham;
    private javax.swing.JPanel panelbanhang;
    private javax.swing.JPanel pl_FullChucNang;
    private javax.swing.JPanel pl_anh;
    private javax.swing.JPanel pl_banhang;
    private javax.swing.JPanel pl_hoadon;
    private javax.swing.JPanel pl_home;
    private javax.swing.JPanel pl_khachhang;
    private javax.swing.JPanel pl_khuyenmai;
    private javax.swing.JPanel pl_khuyenmai1;
    private javax.swing.JPanel pl_khuyenmai5;
    private javax.swing.JPanel pl_nhanvien;
    private javax.swing.JPanel pl_sanpham;
    private javax.swing.JPanel pl_thongke;
    private javax.swing.JPanel pl_thongtincanhan;
    private javax.swing.JPanel pnPaging;
    private javax.swing.JPanel pn_BanHang;
    private javax.swing.JPanel pn_HoaDon;
    private javax.swing.JPanel pn_Home;
    private javax.swing.JPanel pn_KhachHang;
    private javax.swing.JPanel pn_KhuyenMai;
    private javax.swing.JPanel pn_Menu;
    private javax.swing.JPanel pn_NhanVien;
    private javax.swing.JPanel pn_SanPham;
    private javax.swing.JPanel pn_Thoat;
    private javax.swing.JPanel pn_ThongKe;
    private javax.swing.JPanel pn_ThongTinCaNhan;
    private javax.swing.JPanel pn_Tong;
    private javax.swing.JRadioButton rdchuyenkhoan;
    private javax.swing.JRadioButton rdnam;
    private javax.swing.JRadioButton rdnu;
    private javax.swing.JRadioButton rdoNu1;
    private javax.swing.JRadioButton rdonam1;
    private javax.swing.JRadioButton rdtienmat;
    private javax.swing.JTabbedPane table;
    private javax.swing.JTable tableluutru;
    private javax.swing.JTable tablenv;
    private javax.swing.JTable tbbangbieudo;
    private javax.swing.JTable tbbangsanphambanchaynhat;
    private javax.swing.JTable tbbangsanphambanhang;
    private javax.swing.JTable tbbangthongke;
    private javax.swing.JTable tbbanhhoadonbanhang;
    private javax.swing.JTable tbgiohangbanhang;
    private javax.swing.JTable tblDSImei;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblImei;
    private javax.swing.JTable tblLichSu;
    private javax.swing.JTable tblSP;
    private javax.swing.JTable tblSanPham2;
    private javax.swing.JTable tblSanPhamLuuTru;
    private javax.swing.JTable tblThongtinKH1;
    private javax.swing.JTable tblThongtinKHDeleted;
    private javax.swing.JTable tbl_KhuyenMai;
    private javax.swing.JTable tbl_KhuyenMaiNgungHoatDong;
    private javax.swing.JTable tbl_SanPhamGiamGia;
    private javax.swing.JTable tbsanphamtonthongke;
    private com.toedter.calendar.JDateChooser tfOX;
    private javax.swing.JLabel tfchitietdonhang;
    private javax.swing.JLabel tfdoanhthu;
    private javax.swing.JLabel tfdondahuy;
    private javax.swing.JLabel tfdonthanhcong;
    private com.toedter.calendar.JDateChooser tfketthucngaythongke;
    private javax.swing.JLabel tfkhuyenmai;
    private com.toedter.calendar.JDateChooser tfngaybatdauthongke;
    private javax.swing.JLabel tfngaytaovaban;
    private javax.swing.JLabel tfphaitra;
    private javax.swing.JLabel tfsoluongsanphambanthongke;
    private javax.swing.JTextField tftienkhachdua;
    private javax.swing.JLabel tftienthua;
    private javax.swing.JLabel tftieudetongdoanhthu;
    private javax.swing.JLabel tftieudetongdonhang;
    private javax.swing.JTextField tftimkiemsanphamton;
    private javax.swing.JTextField tftimkiemthongke;
    private javax.swing.JLabel tftongdoanhthutimkiem;
    private javax.swing.JLabel tftongdonhang;
    private javax.swing.JLabel tftongtienhang;
    private javax.swing.JTextArea txaMoTa;
    private javax.swing.JLabel txtChucVu;
    private javax.swing.JTextArea txtDiachi1;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtEmail1;
    private javax.swing.JLabel txtEmailttcn;
    private javax.swing.JTextField txtFindKH;
    private javax.swing.JLabel txtGioiTinh;
    private javax.swing.JLabel txtHoTen;
    private javax.swing.JTextField txtLichSu;
    private javax.swing.JLabel txtMa;
    private javax.swing.JTextField txtMaKH1;
    private javax.swing.JLabel txtMaNV;
    private javax.swing.JTextField txtMaXN;
    private javax.swing.JTextField txtMatKhauCu;
    private javax.swing.JTextField txtMatKhauMoi;
    private javax.swing.JLabel txtNgaySinhttcn;
    private javax.swing.JTextField txtNhapLai;
    private javax.swing.JLabel txtQueQuanttcn;
    private javax.swing.JTextField txtSDT2;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenKH1;
    private javax.swing.JLabel txtTenNV;
    private javax.swing.JTextField txtTenSanPham;
    private javax.swing.JTextField txtTimKiemDeleted;
    private javax.swing.JTextField txtTimKiemHD;
    private javax.swing.JTextField txtTimKiemSanPham;
    private javax.swing.JTextField txtTimKiemSanPhamDeleted;
    private javax.swing.JTextField txt_MaGiamGia;
    private javax.swing.JTextField txt_MucGiam;
    private javax.swing.JTextField txt_TenKM;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtmanv;
    private javax.swing.JTextField txtmatkhau;
    private javax.swing.JTextField txtque;
    private javax.swing.JTextField txttaikhaon;
    private javax.swing.JTextField txttennv;
    // End of variables declaration//GEN-END:variables
}
