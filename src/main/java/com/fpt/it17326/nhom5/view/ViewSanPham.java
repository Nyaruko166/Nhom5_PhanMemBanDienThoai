/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.fpt.it17326.nhom5.view;

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
import com.fpt.it17326.nhom5.repository.ImeiDaBanRepository;
import com.fpt.it17326.nhom5.repository.KhuyenMaiRepository;
import com.fpt.it17326.nhom5.repository.SanPhamGiamGiaRepository;
import com.fpt.it17326.nhom5.repository.SanPhamRepository;
import com.fpt.it17326.nhom5.response.HoaDonResponse;
import com.fpt.it17326.nhom5.response.ImeiResponse;
import com.fpt.it17326.nhom5.response.KhuyenMaiResponse;
import com.fpt.it17326.nhom5.response.ThongkeResponse;
import com.fpt.it17326.nhom5.service.HoaDonChiTietService;
import com.fpt.it17326.nhom5.service.HoaDonService;
import com.fpt.it17326.nhom5.service.ImeiService;
import com.fpt.it17326.nhom5.service.KhuyenMaiService;
import com.fpt.it17326.nhom5.service.MauSacService;
import com.fpt.it17326.nhom5.service.impl.HoaDonChiTietServiceImpl;
import com.fpt.it17326.nhom5.service.impl.HoaDonServiceImpl;
import com.fpt.it17326.nhom5.service.impl.ImeiServiceImpl;
import com.fpt.it17326.nhom5.service.impl.KhuyenMaiServiceImpl;
import com.fpt.it17326.nhom5.service.impl.MauSacServiceImpl;
import com.fpt.it17326.nhom5.util.KhuyenMaThread;
import org.springframework.scheduling.annotation.EnableAsync;

import static com.fpt.it17326.nhom5.util.Util.getNameFileFromPath;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDateTime;

//  ---------------------Thang
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import javax.swing.JOptionPane;
import javax.swing.table.JTableHeader;
import com.fpt.it17326.nhom5.util.Util;

/**
 *
 * @author PHAM DAC THANG
 */
@EnableAsync
public class ViewSanPham extends javax.swing.JFrame {

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
    //private SanPhamService sanPhamService;
    private MauSacService mauSacService;
    private ImeiService imeiService;
    private String urlAnh;
    private String urlUploadAnh;

    private List<Chip> listChip;
    private List<Pin> listPin;
    private List<Ram> listRam;
    private List<Rom> listRom;
    private List<HangDienThoai> listHangDT;
    //private List<SanPhamResponse> listSanPham;
    private List<SanPham> listSp;
    private List<MauSac> listMauSac;
    private List<Imei> imeis;
    private List<ImeiResponse> listImei;
    private List<SanPham> listSanPhamDeleted;
    // chi
    private DefaultTableModel dtmSP = new DefaultTableModel();
    private DefaultTableModel dtmGH = new DefaultTableModel();
    private DefaultTableModel dtmHD = new DefaultTableModel();
    private DefaultTableModel dtmHDTreo = new DefaultTableModel();
    private List<SanPhamResponse> listSanPham = new ArrayList<>();
    private List<SanPhamResponse> listGioHang = new ArrayList<>();
    private List<HoaDonResponse> listHoaDon = new ArrayList<>();
    private List<String> listHoaDonTreo = new ArrayList<>();
    private SanPhamService sanPhamService = new SanPhamServiceImpl();
    private HoaDonService hoaDonService = new HoaDonServiceImpl();

    Color bgColo = new Color(0, 0, 102);

    //------Thang
    DefaultTableModel defaultTable;
    HoaDonChiTietService HoaDonChiTietService = new HoaDonChiTietServiceImpl();
    HoaDonService HoaDonService = new HoaDonServiceImpl();

    private List<ThongkeResponse> listThongke = new ArrayList<>();

    /**
     * Creates new form BanHang
     */
    public ViewSanPham() {
        initComponents();
        showDataKM6();
        SanPhamRepository giaRepository = new SanPhamRepository();
        SanPham sanPham = giaRepository.getOneMa(4);
        sanPham.setTenSP("NOKIA");
        sanPhamService.update(sanPham);
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
        dtmHoaDon = (DefaultTableModel) tblHoaDon.getModel();
        dtmHDSP = (DefaultTableModel) tblSP.getModel();
        dtmHDImei = (DefaultTableModel) tblImei.getModel();
        listImei = new ArrayList<>();
        initService();
        tblSanPhamBanHang.setModel(dtmSP);
        String[] hearder = {"Tên SP", "Hãng", "Chip", "Ram", "Rom", "Pin", "Màu sắc", "Số lượng", "Mô Tả", "Đơn giá"};
        dtmSP.setColumnIdentifiers(hearder);
        listSanPham = sanPhamService.getAll();
        showData(listSanPham);
        tblGioHang.setModel(dtmGH);
        dtmGH.setColumnIdentifiers(hearder);
        txtTienThua.setEditable(false);
        txtTongTienHang.setEditable(false);
        txtTienKHTra.setEditable(false);
        dtmHoaDon = (DefaultTableModel) tblHoaDon.getModel();
        designTableSanPham();

        loadProductForm();
        Util.createFolderImageUpload();

        //-------Thang
        loadbangthongke();
        loadbangthongkeimei();
        //--BanHangKM
        for (KhuyenMaiResponse list : lists2) {
            cbx_KhuyenMai.addItem(list.getMaKM());
        }
    }
//Khai Start///////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void showDataKM(List<KhuyenMaiResponse> lst) {
        dfm2.setRowCount(0);
        for (KhuyenMaiResponse khuyenMaiResponse : lst) {
            dfm2.addRow(khuyenMaiResponse.toDataRow());
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
            dfm.addRow(khuyenMaiResponse.toDataRow());
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

        KhuyenMaiResponse khuyenMaiResponse = khuyenMaiService.getOne((int) dfm.getValueAt(index, 0));
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
        cbbDSImei.removeAllItems();
        for (ImeiResponse item : listImei) {
            cbbDSImei.addItem(item.getImei());
        }
    }

    public void loadImageToLabel(String path, boolean hasRoot) {
        BufferedImage img = null;
        String userDirectory = new File("").getAbsolutePath() + Util.SLASH +"pictures";

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
        cbbDSImei.removeAllItems();
        for (Imei imei : imeis) {
            listImei.add(new ImeiResponse(imei));
            cbbDSImei.addItem(imei.getImei());
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
                sp.getMauSac(),
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
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String convert = null;
        List<HoaDonResponse> lsthd = hoaDonService.getAll();
        dtmHoaDon.setRowCount(0);
        for (HoaDonResponse x : lsthd) {
            String StrTT = "Chưa thanh toán";
            if (x.isTrangThai()) {
                StrTT = "Đã thanh toán";

            }
            convert = format.format(x.getCreatedAt());
            dtmHoaDon.addRow(new Object[]{x.getMaHD(), x.getMaNV(), x.getTenKH(), x.getSdt(), StrTT, String.format("%,.0f", x.getTongTien()) + " VND", convert});

        }
    }

    private void sortHD() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
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
                String convert = format.format(x.getCreatedAt());
                dtmHoaDon.addRow(new Object[]{x.getMaHD(), x.getMaNV(), x.getTenKH(), x.getSdt(), StrTT, String.format("%,.0f", x.getTongTien()) + " VND", convert});
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
        ImeiDaBanRepository imeiDaBanRepository = new ImeiDaBanRepository();
        int index = tblSP.getSelectedRow();
        String TenSP = tblSP.getValueAt(index, 0).toString();
        List<ImeiDaBan> lstImei = imeiDaBanRepository.getAll();
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
//======================================================================================
//@QuanPM_PH27325 END

    //--------------Thang
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

            }
        } else {
            System.err.println("list.size=  " + listThongke.size());
        }

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

            }
        } else {
            System.err.println("list.size=  " + listThongke.size());
        }

        loadbangthongkeimei();

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

            }
        } else {
            System.err.println("list.size=  " + listThongke.size());
        }

        loadbangthongkeimei();

    }

    public void loadbangthongkeimei() {

        defaultTable = (DefaultTableModel) tbbangthongkeimai.getModel();
        listThongke = HoaDonChiTietService.getAllimeidaban();

        defaultTable.setRowCount(0);
        if (listThongke.size() > 0) {
            for (int i = 0; i < listThongke.size(); i = i + 1) {

                defaultTable.addRow(new Object[]{i + 1,
                    listThongke.get(i).getMaHD(),
                    listThongke.get(i).getMaImei(),
                    listThongke.get(i).getImei(),
                    listThongke.get(i).chuyenngaymua()
                });

            }

        } else {
            System.err.println("list.size=  " + listThongke.size());
        }

    }

    public void timkiemthongke() {
        defaultTable = (DefaultTableModel) tbbangthongke.getModel();
        listThongke = HoaDonChiTietService.getAll1();

        //---------------------------------------------------------------
        int th = 0;
        int solg = 0;
        double tong = 0;
        for (HoaDonResponse hd : HoaDonService.getAll1()) {
            if (hd.getMaHD().equals(tftimkiemthongke.getText())) {
                th = th + 1;

            }
        }
        if (th == 1) {
            tftieudetongdonhang.setText("HÓA ĐƠN: " + tftimkiemthongke.getText());
            tfchitietdonhang.setText("HÓA ĐƠN: " + tftimkiemthongke.getText());
            tftieudetongdoanhthu.setText("  HÓA ĐƠN: " + tftimkiemthongke.getText());
            tftongdonhang.setText("1");
            tfdonthanhcong.setText(" " + 1);
            tfdondahuy.setText("0");

            for (ThongkeResponse t : listThongke) {
                if (t.getMaHD().equals(tftimkiemthongke.getText())) {
                    solg = solg + t.getSoLuong();
                    tong = tong + t.thanhtien();
                }
            }
            String doanhthu = String.format("%,.2f", tong) + " VND";
            tfdoanhthu.setText(doanhthu);
            tfsoluongsanphambanthongke.setText("" + solg);

        } else {
            tftongdonhang.setText("0");
            tfdonthanhcong.setText(" " + 0);
            tfdondahuy.setText(" 0");
            tfsoluongsanphambanthongke.setText("0");
            tfdoanhthu.setText("0");
            tftieudetongdonhang.setText("TỔNG ĐƠN HÀNG");
            tfchitietdonhang.setText("CHI TIẾT ĐƠN HÀNG");
            tftieudetongdoanhthu.setText("TỔNG DOANH THU");
        }

        //----------------------------------------------------------------------
        defaultTable.setRowCount(0);

        if (listThongke.size() > 0) {
            int io = 0;
            for (int i = 0; i < listThongke.size(); i = i + 1) {
                if (listThongke.get(i).getMaHD().equalsIgnoreCase(tftimkiemthongke.getText())) {
                    double a = (double) (listThongke.get(i).getDonGia() * 1);
                    defaultTable.addRow(new Object[]{io + 1, listThongke.get(i).getMaSP(),
                        listThongke.get(i).getMaHD(),
                        listThongke.get(i).getTenSP(),
                        listThongke.get(i).getSoLuong(),
                        String.format("%,.2f", listThongke.get(i).getDonGia()) + " VND",
                        String.format("%,.2f", listThongke.get(i).thanhtien()) + " VND",
                        listThongke.get(i).chuyenngaymua()
                    });

                }

            }
        } else {
            System.err.println("list.size=  " + listThongke.size());
        }

//
        timkiemimei();  //

    }

    public void timkiemimei() {

        defaultTable = (DefaultTableModel) tbbangthongkeimai.getModel();
        listThongke = HoaDonChiTietService.getAllimeidaban();
        defaultTable.setRowCount(0);
        if (listThongke.size() > 0) {
            int ok = 0;
            for (int i = 0; i < listThongke.size(); i = i + 1) {

                if (listThongke.get(i).getMaHD().equalsIgnoreCase(tftimkiemthongke.getText())) {
                    defaultTable.addRow(new Object[]{ok + 1, // check sau
                        listThongke.get(i).getMaHD(),
                        listThongke.get(i).getMaImei(),
                        listThongke.get(i).getImei(),
                        listThongke.get(i).chuyenngaymua()
                    });
                }
            }

        } else {
            System.err.println("list.size=  " + listThongke.size());
        }
    }

    public int sosanhngaybtvskt() throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        Date date1 = sdf.parse(tfngaybatdauthongke.getText());

        Date date2 = sdf.parse(tfketthucngaythongke.getText());

        int a = date1.compareTo(date2);
        // bằng   date1=date2 thi 0
        //  date1 có trước date2 thì -1
        // còn lại 1

        return a;

    }
    int kt = 0;

    public boolean checktimkiemtheokhoangtime() throws ParseException {
        if (tfngaybatdauthongke.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Ngày bắt đầu không để trống");
            return false;
        } else {
            if (tfketthucngaythongke.getText().isBlank()) {
                JOptionPane.showMessageDialog(this, "Ngày kết thúc không để trống");
                return false;
            } else {
                if (checknhapngaybatdauthongke()) {
                    if (checknhapngayketthucthongke()) {
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
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
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

    public void loadbangthongtheotimkiemkhoangtime0() throws ParseException {
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

        if (listThongke.size() > 0) {
            for (int i = 0; i < listThongke.size(); i = i + 1) {
                if (sosanhngaytrongkhoang0(listThongke.get(i).chuyenngaymua())) {

                    solg = listThongke.get(i).getSoLuong() + solg;
                    tong = listThongke.get(i).thanhtien() + tong;
                    double a = (double) (listThongke.get(i).getDonGia() * 1);
                    defaultTable.addRow(new Object[]{i + 1, listThongke.get(i).getMaSP(),
                        listThongke.get(i).getMaHD(),
                        listThongke.get(i).getTenSP(),
                        listThongke.get(i).getSoLuong(),
                        String.format("%,.2f", listThongke.get(i).getDonGia()) + " VND",
                        String.format("%,.2f", listThongke.get(i).thanhtien()) + " VND",
                        listThongke.get(i).chuyenngaymua()
                    });
                }
            }
        } else {
            System.err.println("list.size=  " + listThongke.size());
        }

        int tc = 0;

        for (HoaDonResponse hd : HoaDonService.getAll1()) {
            if (sosanhngaytrongkhoang0(chuyenngaymuatk(hd.getCreatedAt())) && hd.isTrangThai()) {
                tc = tc + 1;
            }
        }
        tftongdonhang.setText("" + tc);
        tfdonthanhcong.setText(" " + String.valueOf(tc));
        tfdondahuy.setText(" 0");

        String doanhthu = String.format("%,.2f", tong) + " VND";
        tfdoanhthu.setText(doanhthu);
        tfsoluongsanphambanthongke.setText("" + solg);

        //
        defaultTable = (DefaultTableModel) tbbangthongkeimai.getModel();
        listThongke = HoaDonChiTietService.getAllimeidaban();
        defaultTable.setRowCount(0);
        int ic = 0;
        if (listThongke.size() > 0) {
            for (int i = 0; i < listThongke.size(); i = i + 1) {
                if (sosanhngaytrongkhoang0(listThongke.get(i).chuyenngaymua())) {
                    defaultTable.addRow(new Object[]{ic + 1,
                        listThongke.get(i).getMaHD(),
                        listThongke.get(i).getMaImei(),
                        listThongke.get(i).getImei(),
                        listThongke.get(i).chuyenngaymua()
                    });

                }
            }
        } else {
            System.err.println("list.size=  " + listThongke.size());
        }

    }

    public void loadbangthongtheotimkiemkhoangtime1() throws ParseException {
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

        if (listThongke.size() > 0) {
            for (int i = 0; i < listThongke.size(); i = i + 1) {
                if (sosanhngaytrongkhoang1(listThongke.get(i).chuyenngaymua())) {

                    solg = listThongke.get(i).getSoLuong() + solg;
                    tong = listThongke.get(i).thanhtien() + tong;

                    double a = (double) (listThongke.get(i).getDonGia() * 1);
                    defaultTable.addRow(new Object[]{i + 1, listThongke.get(i).getMaSP(),
                        listThongke.get(i).getMaHD(),
                        listThongke.get(i).getTenSP(),
                        listThongke.get(i).getSoLuong(),
                        String.format("%,.2f", listThongke.get(i).getDonGia()) + " VND",
                        String.format("%,.2f", listThongke.get(i).thanhtien()) + " VND",
                        listThongke.get(i).chuyenngaymua()
                    });
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

        String doanhthu = String.format("%,.2f", tong) + " VND";
        tfdoanhthu.setText(doanhthu);
        tfsoluongsanphambanthongke.setText("" + solg);

        defaultTable = (DefaultTableModel) tbbangthongkeimai.getModel();
        listThongke = HoaDonChiTietService.getAllimeidaban();
        defaultTable.setRowCount(0);
        int ic = 0;
        if (listThongke.size() > 0) {
            for (int i = 0; i < listThongke.size(); i = i + 1) {
                if (sosanhngaytrongkhoang1(listThongke.get(i).chuyenngaymua())) {
                    defaultTable.addRow(new Object[]{ic + 1,
                        listThongke.get(i).getMaHD(),
                        listThongke.get(i).getMaImei(),
                        listThongke.get(i).getImei(),
                        listThongke.get(i).chuyenngaymua()
                    });

                }
            }
        } else {
            System.err.println("list.size=  " + listThongke.size());
        }

    }

    public boolean sosanhngaytrongkhoang1(String ec) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        Date date1 = sdf.parse(tfngaybatdauthongke.getText());

        Date date2 = sdf.parse(tfketthucngaythongke.getText());
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

        Date date1 = sdf.parse(tfngaybatdauthongke.getText());

        Date date2 = sdf.parse(tfketthucngaythongke.getText());
        Date date3 = sdf.parse(ec);

        int a = date1.compareTo(date2);
        // bằng   date1=date2 thi 0
        //  date1 có trước date2 thì -1
        // date1 có sau date2 thì 1
        if (date3.compareTo(date1) == 0 || date3.compareTo(date2) == 0) {
            return true;
        } else {
            return false;
        }

    }

    public boolean checknhapngaybatdauthongke() {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        df.setLenient(false);
        String ntn = "[0-9-]{0,20}";

        try {
            Date ngay = df.parse(tfngaybatdauthongke.getText());
            if (tfngaybatdauthongke.getText().matches(ntn) == true) {
                // TFNGAYSINH.setBackground(Color.WHITE);
                // kt5=0;
                return true;
            } else {
                JOptionPane.showMessageDialog(this, "Ngày bắt đầu không ghi chữ ");
                return false;
                //  TFNGAYSINH.setBackground(Color.YELLOW);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, " Ngày bắt đầu không đúng định dạng (dd-MM-yyyy)");
            //TFNGAYSINH.setBackground(Color.YELLOW);
            //  kt5=1;
            return false;
        }
    }

    public boolean checknhapngayketthucthongke() {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        df.setLenient(false);
        String ntn = "[0-9-]{0,20}";

        try {
            Date ngay = df.parse(tfketthucngaythongke.getText());
            if (tfketthucngaythongke.getText().matches(ntn) == true) {
                // TFNGAYSINH.setBackground(Color.WHITE);
                // kt5=0;
                return true;
            } else {
                JOptionPane.showMessageDialog(this, "Ngày kết thúc không ghi chữ ");
                return false;
                //  TFNGAYSINH.setBackground(Color.YELLOW);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, " Ngày kết thúc không đúng định dạng ngáyinh(dd-MM-yyyy)");
            //TFNGAYSINH.setBackground(Color.YELLOW);
            //  kt5=1;
            return false;
        }
    }

    public void guibaocao() {

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
        final String username = "thangpdph28478@fpt.edu.vn";//  email gui
        final String password = "t3ku8v2k";      //mat khau email gui
        final String toEmail = "phamdacthang1@gmail.com";     // email nhân
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
            msg.setFrom(new InternetAddress("thangpdph28478@fpt.edu.vn"));  // email gui
            msg.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(toEmail, false));
            msg.setSubject("THONG BAO DOANH THU: NHOM 5 BAN DIEN THOAI  [ " + tfngaybatdauthongke.getText() + " DEN " + tfketthucngaythongke.getText() + " ]");

            String baocao = "TONG DOANH THU " + "[ " + tfngaybatdauthongke.getText() + " DEN " + tfketthucngaythongke.getText() + " ]" + "\n"
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
            JOptionPane.showMessageDialog(this, "LỖI GỬI THÔNG BÁO ");
            System.out.println("LỖI :    " + e);
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
        pn_Tong = new javax.swing.JPanel();
        pn_Menu = new javax.swing.JPanel();
        pl_anh = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
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
        pn_ThongKe = new javax.swing.JPanel();
        lblThongKe = new javax.swing.JLabel();
        pn_Thoat = new javax.swing.JPanel();
        lblThoat = new javax.swing.JLabel();
        lb_Tendetai = new javax.swing.JLabel();
        pl_FullChucNang = new javax.swing.JPanel();
        pl_home = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
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
        jPanel13 = new javax.swing.JPanel();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        btnLast1 = new javax.swing.JButton();
        btnNext2 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        lblAnhSanPham = new javax.swing.JLabel();
        btnDesignAnh = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtDonGia = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        btnDesignImei = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        txaMoTa = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        btnThemSanPham = new javax.swing.JButton();
        btnSuaSanPham = new javax.swing.JButton();
        btnXoaSanPham = new javax.swing.JButton();
        btnXoaFormSanPham = new javax.swing.JButton();
        cbbDSImei = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        txtTenSanPham = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jTextField8 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jScrollPane18 = new javax.swing.JScrollPane();
        tblSanPhamLuuTru = new javax.swing.JTable();
        jButton14 = new javax.swing.JButton();
        pl_banhang = new javax.swing.JPanel();
        rdoChoThanhToan = new javax.swing.JRadioButton();
        rdoDaHuy = new javax.swing.JRadioButton();
        lblAnh = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnHD1 = new javax.swing.JButton();
        btnHD2 = new javax.swing.JButton();
        pl_banhang1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblGioHang = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTongTienHang = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtTienKHTra = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtTienKhachDua = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtTienThua = new javax.swing.JTextField();
        txtTenKh = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        cbx_KhuyenMai = new javax.swing.JComboBox<>();
        jbl_KM = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        btnTaoHoaDon = new javax.swing.JButton();
        btnHuyHoaDon = new javax.swing.JButton();
        btnThanhToan = new javax.swing.JButton();
        lblAnh1 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtTim = new javax.swing.JTextField();
        btnTim = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSanPhamBanHang = new javax.swing.JTable();
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
        txtTimKiem = new javax.swing.JTextField();
        pLoc = new javax.swing.JPanel();
        jdateFrom = new com.toedter.calendar.JDateChooser();
        jdateTo = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        btnExcel = new javax.swing.JButton();
        pl_khuyenmai = new javax.swing.JPanel();
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
        dtc_TuNgay = new com.toedter.calendar.JDateChooser();
        dtc_DenNgay = new com.toedter.calendar.JDateChooser();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jScrollPane21 = new javax.swing.JScrollPane();
        tbl_KhuyenMaiNgungHoatDong = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_KhuyenMai = new javax.swing.JTable();
        jPanel46 = new javax.swing.JPanel();
        bt_addKM = new javax.swing.JButton();
        bt_suaKM = new javax.swing.JButton();
        bt_xoaKM = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        pl_nhanvien = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        jButton47 = new javax.swing.JButton();
        jButton48 = new javax.swing.JButton();
        jButton49 = new javax.swing.JButton();
        jPanel31 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jTextField30 = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jTextField31 = new javax.swing.JTextField();
        jTextField34 = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jTextField35 = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jTextField36 = new javax.swing.JTextField();
        jTextField37 = new javax.swing.JTextField();
        jTextField38 = new javax.swing.JTextField();
        jTextField39 = new javax.swing.JTextField();
        jComboBox10 = new javax.swing.JComboBox<>();
        jComboBox11 = new javax.swing.JComboBox<>();
        jPanel32 = new javax.swing.JPanel();
        jScrollPane16 = new javax.swing.JScrollPane();
        jTable15 = new javax.swing.JTable();
        jTextField29 = new javax.swing.JTextField();
        jButton44 = new javax.swing.JButton();
        jButton45 = new javax.swing.JButton();
        jButton46 = new javax.swing.JButton();
        jPanel33 = new javax.swing.JPanel();
        pl_doimatkhau = new javax.swing.JPanel();
        jPanel34 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        jTextField32 = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        jTextField33 = new javax.swing.JTextField();
        jTextField40 = new javax.swing.JTextField();
        jButton12 = new javax.swing.JButton();
        jLabel52 = new javax.swing.JLabel();
        jTextField41 = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        jTextField43 = new javax.swing.JTextField();
        jButton50 = new javax.swing.JButton();
        jPanel40 = new javax.swing.JPanel();
        pl_thongke = new javax.swing.JPanel();
        jPanel35 = new javax.swing.JPanel();
        jPanel36 = new javax.swing.JPanel();
        tftieudetongdonhang = new javax.swing.JLabel();
        tftongdonhang = new javax.swing.JLabel();
        tfdonthanhcong = new javax.swing.JLabel();
        tfdondahuy = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jPanel42 = new javax.swing.JPanel();
        jPanel43 = new javax.swing.JPanel();
        tfchitietdonhang = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        tfsoluongsanphambanthongke = new javax.swing.JLabel();
        jPanel41 = new javax.swing.JPanel();
        tftieudetongdoanhthu = new javax.swing.JLabel();
        tfdoanhthu = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        tfngaybatdauthongke = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        tfketthucngaythongke = new javax.swing.JTextField();
        jButton53 = new javax.swing.JButton();
        jButton54 = new javax.swing.JButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel39 = new javax.swing.JPanel();
        jScrollPane17 = new javax.swing.JScrollPane();
        tbbangthongke = new javax.swing.JTable();
        jButton13 = new javax.swing.JButton();
        tftimkiemthongke = new javax.swing.JTextField();
        jButton51 = new javax.swing.JButton();
        jButton52 = new javax.swing.JButton();
        jPanel25 = new javax.swing.JPanel();
        jPanel44 = new javax.swing.JPanel();
        jScrollPane20 = new javax.swing.JScrollPane();
        tbbangthongkeimai = new javax.swing.JTable();
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

        javax.swing.GroupLayout pl_anhLayout = new javax.swing.GroupLayout(pl_anh);
        pl_anh.setLayout(pl_anhLayout);
        pl_anhLayout.setHorizontalGroup(
            pl_anhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pl_anhLayout.setVerticalGroup(
            pl_anhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 144, Short.MAX_VALUE)
        );

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Họ và tên");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Mã");

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
// lblHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fpt/it17326/nhom5/images/home.png"))); // NOI18N
        lblHome.setText("HOME");
        lblHome.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout pn_HomeLayout = new javax.swing.GroupLayout(pn_Home);
        pn_Home.setLayout(pn_HomeLayout);
        pn_HomeLayout.setHorizontalGroup(
            pn_HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_HomeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHome, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
// lblSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fpt/it17326/nhom5/images/smartphone.png"))); // NOI18N
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
// lblBanHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fpt/it17326/nhom5/images/shopping-cart.png"))); // NOI18N
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
// lblHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fpt/it17326/nhom5/images/invoice.png"))); // NOI18N
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
// lblKhuyenMai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fpt/it17326/nhom5/images/discount.png"))); // NOI18N
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
// lblNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fpt/it17326/nhom5/images/staff.png"))); // NOI18N
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
// lblThongTinCaNhan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fpt/it17326/nhom5/images/user.png"))); // NOI18N
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
// lblThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fpt/it17326/nhom5/images/trend.png"))); // NOI18N
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

        lblThoat.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblThoat.setForeground(new java.awt.Color(255, 255, 255));
// lblThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fpt/it17326/nhom5/images/exit.png"))); // NOI18N
        lblThoat.setText("THOÁT");

        javax.swing.GroupLayout pn_ThoatLayout = new javax.swing.GroupLayout(pn_Thoat);
        pn_Thoat.setLayout(pn_ThoatLayout);
        pn_ThoatLayout.setHorizontalGroup(
            pn_ThoatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_ThoatLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pn_ThoatLayout.setVerticalGroup(
            pn_ThoatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_ThoatLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblThoat)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pn_MenuLayout = new javax.swing.GroupLayout(pn_Menu);
        pn_Menu.setLayout(pn_MenuLayout);
        pn_MenuLayout.setHorizontalGroup(
            pn_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_MenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pl_anh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pn_MenuLayout.createSequentialGroup()
                        .addGroup(pn_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(pn_Thoat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pn_ThongKe, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pn_Home, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pn_SanPham, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pn_BanHang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pn_HoaDon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pn_KhuyenMai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pn_NhanVien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pn_ThongTinCaNhan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pn_MenuLayout.setVerticalGroup(
            pn_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_MenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pl_anh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
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
                .addComponent(pn_ThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pn_Thoat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lb_Tendetai.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        lb_Tendetai.setForeground(new java.awt.Color(255, 255, 255));
        lb_Tendetai.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_Tendetai.setText("NHÓM 5 : Quản lý bán điện thoại");

        pl_FullChucNang.setBackground(new java.awt.Color(255, 255, 102));
        pl_FullChucNang.setVerifyInputWhenFocusTarget(false);
        pl_FullChucNang.setLayout(new java.awt.CardLayout());

        pl_home.setBackground(new java.awt.Color(255, 255, 255));
        pl_home.setRequestFocusEnabled(false);
        pl_home.add(jLabel57);

        pl_FullChucNang.add(pl_home, "home");

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
// btnSearchSanPham.setIcon(new javax.swing.ImageIcon("D:\\Study\\FALL_2022\\PRO1041_DuAn1\\OnTap\\CodeTung\\Nhom5_QuanLyDienThoai\\images\\search.png")); // NOI18N
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
// btnDesignChip.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fpt/it17326/nhom5/images/edit.png"))); // NOI18N
        btnDesignChip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesignChipActionPerformed(evt);
            }
        });

        btnDesignMauSac.setBackground(new java.awt.Color(0, 0, 102));
// btnDesignMauSac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fpt/it17326/nhom5/images/edit.png"))); // NOI18N
        btnDesignMauSac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesignMauSacActionPerformed(evt);
            }
        });

        btnDesignRam.setBackground(new java.awt.Color(0, 0, 102));
// btnDesignRam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fpt/it17326/nhom5/images/edit.png"))); // NOI18N
        btnDesignRam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesignRamActionPerformed(evt);
            }
        });

        btnDesignPin.setBackground(new java.awt.Color(0, 0, 102));
// btnDesignPin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fpt/it17326/nhom5/images/edit.png"))); // NOI18N
        btnDesignPin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesignPinActionPerformed(evt);
            }
        });

        btnDesignRom.setBackground(new java.awt.Color(0, 0, 102));
// btnDesignRom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fpt/it17326/nhom5/images/edit.png"))); // NOI18N
        btnDesignRom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesignRomActionPerformed(evt);
            }
        });

        btnDesignHang.setBackground(new java.awt.Color(0, 0, 102));
// btnDesignHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fpt/it17326/nhom5/images/edit.png"))); // NOI18N
        btnDesignHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesignHangActionPerformed(evt);
            }
        });

        btnNext.setBackground(new java.awt.Color(0, 0, 102));
// btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fpt/it17326/nhom5/images/next.png"))); // NOI18N
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnLast.setBackground(new java.awt.Color(0, 0, 102));
// btnLast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fpt/it17326/nhom5/images/last.png"))); // NOI18N
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        btnLast1.setBackground(new java.awt.Color(0, 0, 102));
// btnLast1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fpt/it17326/nhom5/images/first.png"))); // NOI18N
        btnLast1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLast1ActionPerformed(evt);
            }
        });

        btnNext2.setBackground(new java.awt.Color(0, 0, 102));
// btnNext2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fpt/it17326/nhom5/images/previus.png"))); // NOI18N
        btnNext2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNext2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnLast1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(113, 113, 113)
                .addComponent(btnNext2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111)
                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNext2)
                    .addComponent(btnLast1)
                    .addComponent(btnNext)
                    .addComponent(btnLast))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                                .addComponent(btnDesignMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1))
                            .addComponent(btnDesignRom, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(7, 7, 7)
                        .addComponent(cbbHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDesignHang)))
                .addGap(40, 40, 40)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bảng Sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 102))); // NOI18N

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder("Ảnh"));

        lblAnhSanPham.setPreferredSize(new java.awt.Dimension(43, 16));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblAnhSanPham, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblAnhSanPham, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
        );

        btnDesignAnh.setBackground(new java.awt.Color(0, 0, 102));
// btnDesignAnh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fpt/it17326/nhom5/images/edit.png"))); // NOI18N
        btnDesignAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesignAnhActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 102));
        jLabel11.setText("Tên Sản Phẩm");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 102));
        jLabel12.setText("Đơn giá");

        txtDonGia.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtDonGia.setForeground(new java.awt.Color(0, 0, 102));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 102));
        jLabel13.setText("DS imei");

        btnDesignImei.setBackground(new java.awt.Color(0, 0, 102));
// btnDesignImei.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fpt/it17326/nhom5/images/edit.png"))); // NOI18N
        btnDesignImei.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesignImeiActionPerformed(evt);
            }
        });

        txaMoTa.setColumns(20);
        txaMoTa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txaMoTa.setForeground(new java.awt.Color(0, 0, 102));
        txaMoTa.setRows(5);
        jScrollPane5.setViewportView(txaMoTa);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 102));
        jLabel14.setText("Mô Tả :");

        btnThemSanPham.setBackground(new java.awt.Color(0, 0, 102));
        btnThemSanPham.setForeground(new java.awt.Color(0, 0, 102));
// btnThemSanPham.setIcon(new javax.swing.ImageIcon("D:\\Study\\FALL_2022\\PRO1041_DuAn1\\OnTap\\CodeTung\\Nhom5_QuanLyDienThoai\\images\\add.png")); // NOI18N
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
// btnSuaSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fpt/it17326/nhom5/images/update.png"))); // NOI18N
        btnSuaSanPham.setEnabled(false);
        btnSuaSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaSanPhamActionPerformed(evt);
            }
        });

        btnXoaSanPham.setBackground(new java.awt.Color(0, 0, 102));
// btnXoaSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fpt/it17326/nhom5/images/delete.png"))); // NOI18N
        btnXoaSanPham.setEnabled(false);
        btnXoaSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaSanPhamActionPerformed(evt);
            }
        });

        btnXoaFormSanPham.setBackground(new java.awt.Color(0, 0, 102));
// btnXoaFormSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fpt/it17326/nhom5/images/reset.png"))); // NOI18N
        btnXoaFormSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaFormSanPhamActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 102));
        jLabel16.setText("Số lượng");

        txtSoLuong.setEditable(false);
        txtSoLuong.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtSoLuong.setForeground(new java.awt.Color(0, 0, 102));

        txtTenSanPham.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtTenSanPham.setForeground(new java.awt.Color(0, 0, 102));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(btnThemSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSuaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                                .addComponent(btnXoaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnXoaFormSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane5)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(20, 20, 20))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)))
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtDonGia, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbbDSImei, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtTenSanPham)
                                    .addComponent(txtSoLuong))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDesignImei, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDesignAnh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(83, 83, 83))))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDesignAnh)
                .addGap(47, 47, 47)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDesignImei)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbbDSImei, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13)))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSuaSanPham)
                    .addComponent(btnXoaSanPham)
                    .addComponent(btnXoaFormSanPham)
                    .addComponent(btnThemSanPham))
                .addContainerGap())
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
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 22, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("Sản Phẩm", jPanel7);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setAutoscrolls(true);

        jTextField8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField8.setForeground(new java.awt.Color(0, 0, 102));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 102));
        jLabel20.setText("Tìm Kiếm");

        jButton8.setBackground(new java.awt.Color(0, 0, 102));
// jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fpt/it17326/nhom5/images/search.png"))); // NOI18N

        tblSanPhamLuuTru.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblSanPhamLuuTru.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên SP", "Đơn giá", "Mô tả", "Màu Sắc", "Hãng", "Chip", "Ram", "Rom", "Pin", "Số Lượng", "Ngày Xóa"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
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
        }

        jButton14.setBackground(new java.awt.Color(0, 0, 102));
// jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fpt/it17326/nhom5/images/restore.png"))); // NOI18N

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
                                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                        .addComponent(jButton14))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField8))
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
                .addGap(0, 1938, Short.MAX_VALUE))
        );
        pl_sanphamLayout.setVerticalGroup(
            pl_sanphamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pl_FullChucNang.add(pl_sanpham, "sanpham");

        pl_banhang.setBackground(new java.awt.Color(255, 255, 255));

        rdoChoThanhToan.setBackground(new java.awt.Color(255, 255, 255));
        rdoChoThanhToan.setText("Chờ thanh toán");

        rdoDaHuy.setBackground(new java.awt.Color(255, 255, 255));
        rdoDaHuy.setText("Đã hủy");

        lblAnh.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblAnh.setMaximumSize(new java.awt.Dimension(460, 621));
        lblAnh.setMinimumSize(new java.awt.Dimension(460, 621));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnHD1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHD2, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnHD1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnHD2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pl_banhang1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Đơn Hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 102))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(0, 0, 102));

        tblGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ẢNH", "MÃ SẢN PHẨM", "TÊN SẢN PHẨM", "SỐ LƯỢNG", "ĐƠN GIÁ", "THÀNH TIỀN", "Imei"
            }
        ));
        tblGioHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGioHangMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblGioHang);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "BÁN HÀNG", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 102))); // NOI18N
        jPanel4.setForeground(new java.awt.Color(0, 0, 102));

        jLabel4.setText("Tên khách hàng :");

        jLabel5.setText("Tổng tiền hàng:");

        jLabel6.setText("Khuyến mãi :");

        jLabel7.setText("Tiền khách phải trả :");

        txtTienKHTra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTienKHTraActionPerformed(evt);
            }
        });

        jLabel8.setText("Tiền thừa");

        txtTienKhachDua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTienKhachDuaActionPerformed(evt);
            }
        });
        txtTienKhachDua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTienKhachDuaKeyPressed(evt);
            }
        });

        jLabel9.setText("Tiền khách đưa:");

        txtTienThua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTienThuaActionPerformed(evt);
            }
        });
        txtTienThua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTienThuaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTienThuaKeyTyped(evt);
            }
        });

        txtTenKh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenKhActionPerformed(evt);
            }
        });

        jLabel56.setText("Mã HĐ:");

        cbx_KhuyenMai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã khuyến mại" }));
        cbx_KhuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_KhuyenMaiActionPerformed(evt);
            }
        });

        jbl_KM.setText(" ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTienThua)
                            .addComponent(txtTienKhachDua)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTienKHTra))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(236, 236, 236)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtTenKh, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtTongTienHang, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                                .addComponent(txtMaHD))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(cbx_KhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                                .addComponent(jbl_KM, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel1))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenKh, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTongTienHang, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbx_KhuyenMai)
                            .addComponent(jbl_KM, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel56)
                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTienKHTra, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "QR", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 102))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CHỨC NĂNG", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 102))); // NOI18N

        btnTaoHoaDon.setBackground(new java.awt.Color(0, 0, 102));
        btnTaoHoaDon.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnTaoHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        btnTaoHoaDon.setText("Tạo Hóa đơn");
        btnTaoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHoaDonActionPerformed(evt);
            }
        });

        btnHuyHoaDon.setBackground(new java.awt.Color(0, 0, 102));
        btnHuyHoaDon.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnHuyHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        btnHuyHoaDon.setText("Hủy hóa đơn");
        btnHuyHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyHoaDonActionPerformed(evt);
            }
        });

        btnThanhToan.setBackground(new java.awt.Color(0, 0, 102));
        btnThanhToan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnThanhToan.setForeground(new java.awt.Color(255, 255, 255));
        btnThanhToan.setText("Thanh Toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuyHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHuyHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        lblAnh1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblAnh1.setMaximumSize(new java.awt.Dimension(460, 621));
        lblAnh1.setMinimumSize(new java.awt.Dimension(460, 621));

        jLabel29.setText("MHD1");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                        .addGap(22, 22, 22))))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(510, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sản Phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 102))); // NOI18N
        jPanel3.setForeground(new java.awt.Color(0, 0, 102));

        btnTim.setBackground(new java.awt.Color(0, 0, 102));
        btnTim.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnTim.setForeground(new java.awt.Color(255, 255, 255));
        btnTim.setText("Tìm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        tblSanPhamBanHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblSanPhamBanHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamBanHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSanPhamBanHang);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnTim)
                .addGap(17, 17, 17))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTim))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pl_banhang1Layout = new javax.swing.GroupLayout(pl_banhang1);
        pl_banhang1.setLayout(pl_banhang1Layout);
        pl_banhang1Layout.setHorizontalGroup(
            pl_banhang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pl_banhang1Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(pl_banhang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pl_banhang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pl_banhang1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pl_banhang1Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)))
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1644, 1644, 1644)
                .addComponent(lblAnh1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(203, Short.MAX_VALUE))
        );
        pl_banhang1Layout.setVerticalGroup(
            pl_banhang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pl_banhang1Layout.createSequentialGroup()
                .addGroup(pl_banhang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pl_banhang1Layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(lblAnh1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(228, 228, 228))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pl_banhang1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pl_banhang1Layout.createSequentialGroup()
                .addGroup(pl_banhang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pl_banhang1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pl_banhang1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pl_banhangLayout = new javax.swing.GroupLayout(pl_banhang);
        pl_banhang.setLayout(pl_banhangLayout);
        pl_banhangLayout.setHorizontalGroup(
            pl_banhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pl_banhangLayout.createSequentialGroup()
                .addGap(2139, 2139, 2139)
                .addComponent(rdoChoThanhToan)
                .addGap(5, 5, 5)
                .addComponent(rdoDaHuy)
                .addGap(5, 5, 5)
                .addComponent(lblAnh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pl_banhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pl_banhangLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pl_banhang1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        pl_banhangLayout.setVerticalGroup(
            pl_banhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pl_banhangLayout.createSequentialGroup()
                .addGroup(pl_banhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pl_banhangLayout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(rdoChoThanhToan))
                    .addGroup(pl_banhangLayout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(rdoDaHuy))
                    .addGroup(pl_banhangLayout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(lblAnh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pl_banhangLayout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(405, 405, 405))
            .addGroup(pl_banhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pl_banhangLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pl_banhang1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pl_FullChucNang.add(pl_banhang, "card4");

        pl_hoadon.setBackground(new java.awt.Color(255, 255, 255));
        pl_hoadon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        pHoaDon.setBackground(new java.awt.Color(255, 255, 255));
        pHoaDon.setBorder(javax.swing.BorderFactory.createTitledBorder("Hoá Đơn"));

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã HD", "Mã NV", "Tên KH", "SDT", "Trạng Thái", "Tổng Tiền", "Ngày Tạo"
            }
        ));
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane13.setViewportView(tblHoaDon);
        if (tblHoaDon.getColumnModel().getColumnCount() > 0) {
            tblHoaDon.getColumnModel().getColumn(0).setPreferredWidth(30);
            tblHoaDon.getColumnModel().getColumn(1).setPreferredWidth(30);
            tblHoaDon.getColumnModel().getColumn(2).setPreferredWidth(100);
        }

        javax.swing.GroupLayout pHoaDonLayout = new javax.swing.GroupLayout(pHoaDon);
        pHoaDon.setLayout(pHoaDonLayout);
        pHoaDonLayout.setHorizontalGroup(
            pHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pHoaDonLayout.createSequentialGroup()
                .addComponent(jScrollPane13)
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

        tblSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên SP", "Đơn Giá", "Số Lượng", "Thành Tiền"
            }
        ));
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
                .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
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

        tblImei.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IMEI"
            }
        ));
        jScrollPane19.setViewportView(tblImei);

        javax.swing.GroupLayout pImeiLayout = new javax.swing.GroupLayout(pImei);
        pImei.setLayout(pImeiLayout);
        pImeiLayout.setHorizontalGroup(
            pImeiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pImeiLayout.createSequentialGroup()
                .addComponent(jScrollPane19, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                .addContainerGap())
        );
        pImeiLayout.setVerticalGroup(
            pImeiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pImeiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane19, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel58.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel58.setText("Tìm Kiếm");

        pLoc.setBackground(new java.awt.Color(255, 255, 255));
        pLoc.setBorder(javax.swing.BorderFactory.createTitledBorder("Lọc theo ngày tạo"));

        jdateFrom.setDateFormatString("yyyy-MM-dd");

        jdateTo.setDateFormatString("yyyy-MM-dd");

        jButton1.setText("Lọc");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel27.setText("Từ:");

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
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

        btnExcel.setText("Excel");

        javax.swing.GroupLayout pl_hoadonLayout = new javax.swing.GroupLayout(pl_hoadon);
        pl_hoadon.setLayout(pl_hoadonLayout);
        pl_hoadonLayout.setHorizontalGroup(
            pl_hoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pl_hoadonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pl_hoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pl_hoadonLayout.createSequentialGroup()
                        .addComponent(pSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(pImei, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pl_hoadonLayout.createSequentialGroup()
                        .addGroup(pl_hoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel58)
                            .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1071, Short.MAX_VALUE)
                        .addComponent(pLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(153, 153, 153)
                        .addComponent(btnExcel)
                        .addGap(94, 94, 94)))
                .addContainerGap(991, Short.MAX_VALUE))
        );
        pl_hoadonLayout.setVerticalGroup(
            pl_hoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pl_hoadonLayout.createSequentialGroup()
                .addGroup(pl_hoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pl_hoadonLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pl_hoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pl_hoadonLayout.createSequentialGroup()
                                .addComponent(jLabel58)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(pLoc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pl_hoadonLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(btnExcel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pl_hoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pImei, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pl_FullChucNang.add(pl_hoadon, "hoadon");

        pl_khuyenmai.setBackground(new java.awt.Color(255, 255, 255));
        pl_khuyenmai.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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
        jScrollPane22.setViewportView(tbl_SanPhamGiamGia);

        jPanel45.setBackground(new java.awt.Color(255, 255, 255));

        jLabel61.setText("Tên chương trình ");

        txt_TenKM.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        jLabel62.setText("Mã giảm giá");

        txt_MaGiamGia.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        jLabel63.setText("Từ ngày");

        jLabel64.setText("Đến ngày");

        jLabel65.setText("Mức giảm (%)");

        txt_MucGiam.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel45Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel45Layout.createSequentialGroup()
                        .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(65, 65, 65)
                        .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_MucGiam)
                            .addComponent(dtc_TuNgay, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                            .addComponent(dtc_DenNgay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel45Layout.createSequentialGroup()
                        .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel61))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_TenKM)
                            .addComponent(txt_MaGiamGia))))
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
                    .addComponent(jLabel63)
                    .addComponent(dtc_TuNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel64)
                    .addComponent(dtc_DenNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_MucGiam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel65))
                .addContainerGap(80, Short.MAX_VALUE))
        );

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
        tbl_KhuyenMaiNgungHoatDong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_KhuyenMaiNgungHoatDongMouseClicked(evt);
            }
        });
        jScrollPane21.setViewportView(tbl_KhuyenMaiNgungHoatDong);

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

        jTabbedPane3.addTab("Đã ngưng hoạt động", jScrollPane2);

        jPanel46.setBackground(new java.awt.Color(255, 255, 255));

        bt_addKM.setText("Thêm");
        bt_addKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_addKMActionPerformed(evt);
            }
        });

        bt_suaKM.setText("Sửa");
        bt_suaKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_suaKMActionPerformed(evt);
            }
        });

        bt_xoaKM.setText("Xóa");
        bt_xoaKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_xoaKMActionPerformed(evt);
            }
        });

        jButton2.setText("Khôi phục");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_xoaKM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_suaKM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_addKM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(bt_addKM, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bt_suaKM, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bt_xoaKM, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(93, Short.MAX_VALUE))
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
                        .addComponent(jPanel46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pl_khuyenmai5Layout.createSequentialGroup()
                        .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(801, 801, 801)
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

        javax.swing.GroupLayout pl_khuyenmaiLayout = new javax.swing.GroupLayout(pl_khuyenmai);
        pl_khuyenmai.setLayout(pl_khuyenmaiLayout);
        pl_khuyenmaiLayout.setHorizontalGroup(
            pl_khuyenmaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pl_khuyenmaiLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(pl_khuyenmai5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(384, 384, 384))
        );
        pl_khuyenmaiLayout.setVerticalGroup(
            pl_khuyenmaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pl_khuyenmaiLayout.createSequentialGroup()
                .addComponent(pl_khuyenmai5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pl_FullChucNang.add(pl_khuyenmai, "khuyenmai");

        pl_nhanvien.setBackground(new java.awt.Color(255, 255, 255));
        pl_nhanvien.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel30.setBackground(new java.awt.Color(255, 255, 255));
        jPanel30.setBorder(javax.swing.BorderFactory.createTitledBorder("CHỨC NĂNG"));

        jButton47.setText("THÊM");

        jButton48.setText("SỬA");

        jButton49.setText("XÓA");

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton48, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton49, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
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

        jLabel47.setText("LƯƠNG");

        jLabel48.setText("TÀI KHOẢN");

        jLabel49.setText("MẬT KHẨU");

        jComboBox10.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox11.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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
                        .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField31, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox10, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox11, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField34, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(122, 122, 122)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField39, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField38, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField37, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField36, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField35, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45)
                    .addComponent(jTextField35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(jTextField31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel46)
                    .addComponent(jTextField36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(jLabel47)
                    .addComponent(jTextField37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(jLabel48)
                    .addComponent(jTextField38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(jTextField34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel49)
                    .addComponent(jTextField39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel32.setBackground(new java.awt.Color(255, 255, 255));
        jPanel32.setBorder(javax.swing.BorderFactory.createTitledBorder("BẢNG NHÂN VIÊN"));

        jTable15.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "Mã NV", "TÊN NHÂN VIÊN", "GIỚI TÍNH", "CHỨC VỤ", "EMAIL", "QUÊ", "NGÀY SINH", "LƯƠNG", "TÀI KHOẢN", "MẬT KHẨU"
            }
        ));
        jScrollPane16.setViewportView(jTable15);

        jButton44.setText("TÌM");

        jButton45.setText("DANH SÁCH NHÂN VIÊN NGHĨ LÀM");

        jButton46.setText("HOẠT ĐỘNG LẠI");

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane16)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jButton45, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jButton46)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton44, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton44)
                    .addComponent(jButton45)
                    .addComponent(jButton46))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
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
            .addGroup(pl_nhanvienLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pl_nhanvienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pl_nhanvienLayout.createSequentialGroup()
                        .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 2184, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pl_nhanvienLayout.setVerticalGroup(
            pl_nhanvienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pl_nhanvienLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pl_nhanvienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(34, 34, 34)
                .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))
        );

        pl_FullChucNang.add(pl_nhanvien, "nhanvien");

        pl_doimatkhau.setBackground(new java.awt.Color(255, 255, 255));
        pl_doimatkhau.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel34.setBackground(new java.awt.Color(255, 255, 255));
        jPanel34.setBorder(javax.swing.BorderFactory.createTitledBorder("ĐỔI MẬT KHẨU"));

        jLabel50.setText("TÀI KHOẢN CŨ");

        jLabel51.setText("MẬT KHẨU CŨ");

        jButton12.setText("GỬI MÃ");

        jLabel52.setText("MẬT KHẨU MỚI");

        jLabel53.setText("NHẬP LẠI");

        jButton50.setText("ĐỔI MẬT KHẨU");

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel34Layout.createSequentialGroup()
                        .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel34Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton12))
                            .addGroup(jPanel34Layout.createSequentialGroup()
                                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel50, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField32, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField33, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(120, 120, 120))
                    .addGroup(jPanel34Layout.createSequentialGroup()
                        .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel34Layout.createSequentialGroup()
                                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField41, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField43, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jTextField40, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(jButton50, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel50))
                .addGap(18, 18, 18)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel51))
                .addGap(27, 27, 27)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton12))
                .addGap(25, 25, 25)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(jTextField41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addComponent(jButton50, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(106, Short.MAX_VALUE))
        );

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

        javax.swing.GroupLayout pl_doimatkhauLayout = new javax.swing.GroupLayout(pl_doimatkhau);
        pl_doimatkhau.setLayout(pl_doimatkhauLayout);
        pl_doimatkhauLayout.setHorizontalGroup(
            pl_doimatkhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pl_doimatkhauLayout.createSequentialGroup()
                .addGap(235, 235, 235)
                .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pl_doimatkhauLayout.createSequentialGroup()
                .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pl_doimatkhauLayout.setVerticalGroup(
            pl_doimatkhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pl_doimatkhauLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87))
        );

        pl_FullChucNang.add(pl_doimatkhau, "khachhang");

        pl_thongke.setBackground(new java.awt.Color(255, 255, 255));
        pl_thongke.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel35.setBackground(new java.awt.Color(255, 255, 255));
        jPanel35.setBorder(javax.swing.BorderFactory.createTitledBorder("THỐNG KÊ TỔNG"));

        jPanel36.setBackground(new java.awt.Color(0, 255, 204));
        jPanel36.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tftieudetongdonhang.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        tftieudetongdonhang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tftieudetongdonhang.setText("TỔNG ĐƠN HÀNG");

        tftongdonhang.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        tftongdonhang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tftongdonhang.setText("0");

        tfdonthanhcong.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        tfdonthanhcong.setText("0");

        tfdondahuy.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        tfdondahuy.setText("0");

        jLabel59.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel59.setText("THÀNH CÔNG :");

        jLabel60.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel60.setText("ĐÃ HỦY            :");

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tftieudetongdonhang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tftongdonhang, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel59, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel60, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfdondahuy, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfdonthanhcong, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addComponent(tftieudetongdonhang, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(tftongdonhang, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel59, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfdonthanhcong, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfdondahuy, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(jLabel60, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        jPanel43.setBackground(new java.awt.Color(255, 255, 51));
        jPanel43.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tfchitietdonhang.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        tfchitietdonhang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tfchitietdonhang.setText("CHI TIẾT ĐƠN HÀNG");

        jLabel55.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel55.setText("Số lượng sản phẩm  đã bán:");

        tfsoluongsanphambanthongke.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        tfsoluongsanphambanthongke.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tfsoluongsanphambanthongke.setText("0");

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tfchitietdonhang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addComponent(jLabel55, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfsoluongsanphambanthongke, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addComponent(tfchitietdonhang, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tfsoluongsanphambanthongke, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel41.setBackground(new java.awt.Color(255, 102, 102));
        jPanel41.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tftieudetongdoanhthu.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        tftieudetongdoanhthu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tftieudetongdoanhthu.setText("DOANH THU");

        tfdoanhthu.setFont(new java.awt.Font("Segoe UI", 1, 21)); // NOI18N
        tfdoanhthu.setText("0");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel25.setText("Tổng doanh thu :");

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tftieudetongdoanhthu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfdoanhthu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addComponent(tftieudetongdoanhthu, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addGap(29, 29, 29)
                .addComponent(tfdoanhthu, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        jLabel26.setText("Từ ngày(dd-mm-yyyy)");

        jLabel54.setText("Đến ngày(dd-mm-yyyy)");

        jButton53.setText("LỌC");
        jButton53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton53ActionPerformed(evt);
            }
        });

        jButton54.setText("GỬI BÁO CÁO");
        jButton54.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton54ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel42, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfngaybatdauthongke, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel54)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfketthucngaythongke, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton53, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton54, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfngaybatdauthongke, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfketthucngaythongke, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton53)
                    .addComponent(jButton54))
                .addContainerGap())
        );

        jPanel39.setBackground(new java.awt.Color(255, 255, 255));
        jPanel39.setBorder(javax.swing.BorderFactory.createTitledBorder("BẢNG THỐNG KÊ"));

        tbbangthongke.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã sản phẩm", "Mã hóa đơn", "Tên sản phẩm", "Số lượng", "Giá bán", "Thành tiền", "Ngày bán"
            }
        ));
        jScrollPane17.setViewportView(tbbangthongke);

        jButton13.setText("Tim theo Mã Hóa Đơn");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton51.setText("TĂNG DẦN");
        jButton51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton51ActionPerformed(evt);
            }
        });

        jButton52.setText("GIẢM DẦN");
        jButton52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton52ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel39Layout.createSequentialGroup()
                        .addComponent(jButton51)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton52)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tftimkiemthongke, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton13)
                        .addGap(98, 98, 98))
                    .addGroup(jPanel39Layout.createSequentialGroup()
                        .addComponent(jScrollPane17)
                        .addContainerGap())))
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel39Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton13)
                    .addComponent(tftimkiemthongke, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton51)
                    .addComponent(jButton52))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Thống kê sản phẩm", jPanel39);

        jPanel44.setBackground(new java.awt.Color(255, 255, 255));
        jPanel44.setBorder(javax.swing.BorderFactory.createTitledBorder("BẢNG THỐNG KÊ IMEI"));

        tbbangthongkeimai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã hóa đơn", "Mã imei", "Imei", "Ngày Bán"
            }
        ));
        jScrollPane20.setViewportView(tbbangthongkeimai);

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane20, javax.swing.GroupLayout.DEFAULT_SIZE, 1011, Short.MAX_VALUE)
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 42, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel44, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Thống kê imei", jPanel25);

        javax.swing.GroupLayout pl_thongkeLayout = new javax.swing.GroupLayout(pl_thongke);
        pl_thongke.setLayout(pl_thongkeLayout);
        pl_thongkeLayout.setHorizontalGroup(
            pl_thongkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pl_thongkeLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(pl_thongkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane2))
                .addContainerGap(2138, Short.MAX_VALUE))
        );
        pl_thongkeLayout.setVerticalGroup(
            pl_thongkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pl_thongkeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pl_FullChucNang.add(pl_thongke, "thongke");

        lblTenChucNang.setBackground(new java.awt.Color(0, 0, 102));
        lblTenChucNang.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        lblTenChucNang.setForeground(new java.awt.Color(255, 255, 255));
        lblTenChucNang.setText("HOME");

        javax.swing.GroupLayout pn_TongLayout = new javax.swing.GroupLayout(pn_Tong);
        pn_Tong.setLayout(pn_TongLayout);
        pn_TongLayout.setHorizontalGroup(
            pn_TongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_TongLayout.createSequentialGroup()
                .addComponent(pn_Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_TongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_TongLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(lblTenChucNang, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lb_Tendetai, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pn_TongLayout.createSequentialGroup()
                        .addComponent(pl_FullChucNang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
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
                .addComponent(pn_Tong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
        lblTenChucNang.setText("HOME");
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
        // TODO add your handling code here:
        pl_FullChucNang.removeAll();
        pl_FullChucNang.add(pl_nhanvien);
        pl_FullChucNang.repaint();
        pl_FullChucNang.revalidate();
        lblTenChucNang.setText("NHÂN VIÊN");
    }//GEN-LAST:event_pn_NhanVienMouseClicked

    private void pn_ThongTinCaNhanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_ThongTinCaNhanMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_pn_ThongTinCaNhanMouseClicked

    private void pn_ThongKeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_ThongKeMouseClicked
        // TODO add your handling code here:
        pl_FullChucNang.removeAll();
        pl_FullChucNang.add(pl_thongke);
        pl_FullChucNang.repaint();
        pl_FullChucNang.revalidate();
        lblTenChucNang.setText("THỐNG KÊ");
    }//GEN-LAST:event_pn_ThongKeMouseClicked

    private void pn_ThoatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_ThoatMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_pn_ThoatMouseClicked

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

    private void pn_ThoatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_ThoatMouseEntered
        // TODO add your handling code here:
        pn_Thoat.setBackground(Color.red);
    }//GEN-LAST:event_pn_ThoatMouseEntered

    private void pn_ThoatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn_ThoatMouseExited
        // TODO add your handling code here:
        pn_Thoat.setBackground(new Color(0, 0, 102));
    }//GEN-LAST:event_pn_ThoatMouseExited

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
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
            for (SanPham item : listSp) {
                listSanPham.add(new SanPhamResponse(item));
            }
            loadProductTable();
        }
    }//GEN-LAST:event_btnSearchSanPhamActionPerformed

    private void btnLast1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLast1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLast1ActionPerformed

    private void btnNext2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNext2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNext2ActionPerformed

    private void tblSanPham2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPham2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tblSanPham2MouseEntered

    private void jButton53ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton53ActionPerformed
        try {

            if (checktimkiemtheokhoangtime()) {
                if (kt == 0) {
                    loadbangthongtheotimkiemkhoangtime0();
                } else {
                    loadbangthongtheotimkiemkhoangtime1();

                }

            }

        } catch (ParseException ex) {
            Logger.getLogger(ViewSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton53ActionPerformed

    private void jButton54ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton54ActionPerformed

        guibaocao();

        //
    }//GEN-LAST:event_jButton54ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        if (tftimkiemthongke.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Hãy Nhập MÃ HÓA ĐƠN");
        } else {

            timkiemthongke();
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton51ActionPerformed
        loadbangthongketangdantheothanhtien();
    }//GEN-LAST:event_jButton51ActionPerformed

    private void jButton52ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton52ActionPerformed
        loadbangthongkegiamdantheothanhtien();
    }//GEN-LAST:event_jButton52ActionPerformed

    private void tblGioHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGioHangMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblGioHangMouseClicked

    private void txtTienKHTraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTienKHTraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTienKHTraActionPerformed

    private void txtTienKhachDuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTienKhachDuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTienKhachDuaActionPerformed

    private void txtTienKhachDuaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienKhachDuaKeyPressed
        // TODO add your handling code here:
        String tienDua = txtTienKhachDua.getText();
        String tienTra = txtTienKHTra.getText();
        double tienThua = Double.valueOf(tienDua) - Double.valueOf(tienTra);
        DecimalFormat decimal = new DecimalFormat("#.#");
        txtTienThua.setText(String.valueOf(decimal.format(tienThua)));
    }//GEN-LAST:event_txtTienKhachDuaKeyPressed

    private void txtTienThuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTienThuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTienThuaActionPerformed

    private void txtTienThuaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienThuaKeyReleased
        // TODO add your handling code here:
        //        String tienDua = txtTienKhachDua.getText();
        //        String tienTra = txtTienKHTra.getText();
        //        double tienThua = Double.valueOf(tienDua) - Double.valueOf(tienTra);
        //        DecimalFormat decimal = new DecimalFormat("#.#");
        //        txtTienThua.setText(String.valueOf(decimal.format(tienThua)));
    }//GEN-LAST:event_txtTienThuaKeyReleased

    private void txtTienThuaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienThuaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTienThuaKeyTyped

    private void txtTenKhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenKhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenKhActionPerformed

    private void btnTaoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHoaDonActionPerformed
        // TODO add your handling code here:
        String maHD = "MHD" + (tblGioHang.getRowCount() + 1);
        String maTT = "MATT002";
        String maNV = "1";
        LocalDateTime dateTime = LocalDateTime.now();
        //        TrangThaiHoaDon tt = new TrangThaiHoaDon(maTT);
        //        HoaDon hd = new HoaDon(maHD, tt);
        //        JOptionPane.showMessageDialog(this, hoaDonService.add(hd));
        listHoaDon = hoaDonService.getAll();
        txtMaHD.setText(maHD);
        float tong = 0;
        int i = tblGioHang.getSelectedRow();
        float sluong = listGioHang.get(i).getSoLuong();
        float donGia = listGioHang.get(i).getDonGia();
        tong += sluong * donGia;
        DecimalFormat decimal = new DecimalFormat("#.#");
        NumberFormat nf = NumberFormat.getInstance();
        txtTongTienHang.setText(String.valueOf(decimal.format(tong)));
        txtTienKHTra.setText(String.valueOf(decimal.format(tong)));
        jLabel10.setText(maHD);
        listHoaDonTreo.add(maHD);
        showData(listSanPham);
    }//GEN-LAST:event_btnTaoHoaDonActionPerformed

    private void btnHuyHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyHoaDonActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_btnHuyHoaDonActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        // TODO add your handling code here:
        String maHD = txtMaHD.getText();
        String ten = txtTenKh.getText();
        String maTT = "MATT001";
        String maNV = "1";
        LocalDateTime dateTime = LocalDateTime.now();
        NhanVien nv = new NhanVien(maNV);
        DecimalFormat decimal = new DecimalFormat("#.#");
        Float tong = Float.valueOf(txtTongTienHang.getText());
        HoaDon hd = new HoaDon(maHD, ten, nv, tong);
        JOptionPane.showMessageDialog(this, hoaDonService.update(hd));
        listHoaDon = hoaDonService.getAll();
        showData(listSanPham);
        clear();
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        // TODO add your handling code here:
        String tim = txtTim.getText();
        List<SanPhamResponse> listTim = new ArrayList<>();
        for (SanPhamResponse sanPhamResponse : listSanPham) {
            if (sanPhamResponse.getTenSP().equalsIgnoreCase(tim)) {
                listTim.add(sanPhamResponse);
            }

        }
        showData(listTim);
    }//GEN-LAST:event_btnTimActionPerformed

    private void tblSanPhamBanHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamBanHangMouseClicked
        // TODO add your handling code here:
        //int index = tblSanPham.getSelectedRow();
        int index = tblSanPhamBanHang.rowAtPoint(evt.getPoint());
        SanPhamResponse sp = listSanPham.get(index);
        int id = sp.getId();
        String sl = JOptionPane.showInputDialog("Nhập số lượng");
        int slTon = sp.getSoLuong() - Integer.valueOf(sl);
        sp.setSoLuong(slTon);
        SanPhamResponse sp1 = new SanPhamResponse();
        sp1.setId(sp.getId());
        sp1.setDonGia(sp.getDonGia());
        sp1.setTenSP(sp.getTenSP());
        sp1.setSoLuong(Integer.valueOf(sl));
        sp1.setMaAnh(sp.getMaAnh());
        sp1.setMaSP(sp.getMaSP());
        sp1.setTenChip(sp.getTenChip());
        sp1.setTenHang(sp.getTenHang());
        sp1.setTenRom(sp.getTenRom());
        sp1.setTenPin(sp.getTenPin());
        sp1.setTenMauSac(sp.getTenMauSac());
        sp1.setMoTa(sp.getMoTa());
        sp1.setDungLuong(sp.getDungLuong());
        listGioHang.add(sp1);
        dtmSP.setRowCount(0);

        showData(listSanPham);
        showDataGH(listGioHang);
        //DialogImeiBanHang dialogImeiBanHang = new DialogImeiBanHang(this, rootPaneCheckingEnabled);
        //dialogImeiBanHang.show();
    }//GEN-LAST:event_tblSanPhamBanHangMouseClicked

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
            System.out.println(khuyenMai.toString());
            khuyenMai.setId((int) dfm.getValueAt(index, 0));
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

        // TODO add your handling code here:
    }//GEN-LAST:event_bt_xoaKMActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int row = tbl_KhuyenMai.getSelectedRow();
        KhuyenMaiRepository khuyenMaiRepository = new KhuyenMaiRepository();
        KhuyenMai khuyenMai = khuyenMaiRepository.getOne((int) dfm2.getValueAt(row, 0));
        khuyenMai.setDeleted(Boolean.FALSE);
        khuyenMaiRepository.update(khuyenMai);
        dfm2.removeRow(row);
        lists = khuyenMaiService.getAllTrue();
        lists2 = khuyenMaiService.getAllFalse();
        showDataKM(lists);
        showDataKM2(lists2);
        showDataKM3(listSanPham);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cbx_KhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_KhuyenMaiActionPerformed
        SanPhamGiamGiaRepository phamRepository = new SanPhamGiamGiaRepository();
        KhuyenMaiRepository khuyenMaiRepository = new KhuyenMaiRepository();
        KhuyenMai khuyenMai = khuyenMaiRepository.getOne(cbx_KhuyenMai.getSelectedItem().toString());
        showData2(listSanPham, cbx_KhuyenMai.getSelectedItem().toString());        // TODO add your handling code here:
    }//GEN-LAST:event_cbx_KhuyenMaiActionPerformed

    private void tblSanPhamLuuTruMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamLuuTruMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblSanPhamLuuTruMouseClicked
// đợi

    private void clear() {
        txtTenKh.setText("");
        txtTongTienHang.setText("");
        txtMaHD.setText("");
        txtTienKHTra.setText("");
        txtTienKhachDua.setText("");
        txtTienThua.setText("");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ViewSanPham v = new ViewSanPham();
                v.setLocationRelativeTo(null);
                v.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JButton btnExcel;
    private javax.swing.JButton btnHD1;
    private javax.swing.JButton btnHD2;
    private javax.swing.JButton btnHuyHoaDon;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnLast1;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnNext2;
    private javax.swing.JButton btnSearchSanPham;
    private javax.swing.JButton btnSuaSanPham;
    private javax.swing.JButton btnTaoHoaDon;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThemSanPham;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnXoaFormSanPham;
    private javax.swing.JButton btnXoaSanPham;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbChip;
    private javax.swing.JComboBox<String> cbbDSImei;
    private javax.swing.JComboBox<String> cbbHang;
    private javax.swing.JComboBox<String> cbbMauSac;
    private javax.swing.JComboBox<String> cbbPin;
    private javax.swing.JComboBox<String> cbbRam;
    private javax.swing.JComboBox<String> cbbRom;
    private javax.swing.JComboBox<String> cbx_KhuyenMai;
    private com.toedter.calendar.JDateChooser dtc_DenNgay;
    private com.toedter.calendar.JDateChooser dtc_TuNgay;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton44;
    private javax.swing.JButton jButton45;
    private javax.swing.JButton jButton46;
    private javax.swing.JButton jButton47;
    private javax.swing.JButton jButton48;
    private javax.swing.JButton jButton49;
    private javax.swing.JButton jButton50;
    private javax.swing.JButton jButton51;
    private javax.swing.JButton jButton52;
    private javax.swing.JButton jButton53;
    private javax.swing.JButton jButton54;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox<String> jComboBox10;
    private javax.swing.JComboBox<String> jComboBox11;
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
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
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
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTable jTable15;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField30;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextField32;
    private javax.swing.JTextField jTextField33;
    private javax.swing.JTextField jTextField34;
    private javax.swing.JTextField jTextField35;
    private javax.swing.JTextField jTextField36;
    private javax.swing.JTextField jTextField37;
    private javax.swing.JTextField jTextField38;
    private javax.swing.JTextField jTextField39;
    private javax.swing.JTextField jTextField40;
    private javax.swing.JTextField jTextField41;
    private javax.swing.JTextField jTextField43;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JLabel jbl_KM;
    private com.toedter.calendar.JDateChooser jdateFrom;
    private com.toedter.calendar.JDateChooser jdateTo;
    private javax.swing.JLabel lb_Tendetai;
    private javax.swing.JLabel lblAnh;
    private javax.swing.JLabel lblAnh1;
    private javax.swing.JLabel lblAnhSanPham;
    private javax.swing.JLabel lblBanHang;
    private javax.swing.JLabel lblHoaDon;
    private javax.swing.JLabel lblHome;
    private javax.swing.JLabel lblKhuyenMai;
    private javax.swing.JLabel lblNhanVien;
    private javax.swing.JLabel lblSanPham;
    private javax.swing.JLabel lblTenChucNang;
    private javax.swing.JLabel lblThoat;
    private javax.swing.JLabel lblThongKe;
    private javax.swing.JLabel lblThongTinCaNhan;
    private javax.swing.JPanel pHoaDon;
    private javax.swing.JPanel pImei;
    private javax.swing.JPanel pLoc;
    private javax.swing.JPanel pSanPham;
    private javax.swing.JPanel pl_FullChucNang;
    private javax.swing.JPanel pl_anh;
    private javax.swing.JPanel pl_banhang;
    private javax.swing.JPanel pl_banhang1;
    private javax.swing.JPanel pl_doimatkhau;
    private javax.swing.JPanel pl_hoadon;
    private javax.swing.JPanel pl_home;
    private javax.swing.JPanel pl_khuyenmai;
    private javax.swing.JPanel pl_khuyenmai5;
    private javax.swing.JPanel pl_nhanvien;
    private javax.swing.JPanel pl_sanpham;
    private javax.swing.JPanel pl_thongke;
    private javax.swing.JPanel pn_BanHang;
    private javax.swing.JPanel pn_HoaDon;
    private javax.swing.JPanel pn_Home;
    private javax.swing.JPanel pn_KhuyenMai;
    private javax.swing.JPanel pn_Menu;
    private javax.swing.JPanel pn_NhanVien;
    private javax.swing.JPanel pn_SanPham;
    private javax.swing.JPanel pn_Thoat;
    private javax.swing.JPanel pn_ThongKe;
    private javax.swing.JPanel pn_ThongTinCaNhan;
    private javax.swing.JPanel pn_Tong;
    private javax.swing.JRadioButton rdoChoThanhToan;
    private javax.swing.JRadioButton rdoDaHuy;
    private javax.swing.JTable tbbangthongke;
    private javax.swing.JTable tbbangthongkeimai;
    private javax.swing.JTable tblGioHang;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblImei;
    private javax.swing.JTable tblSP;
    private javax.swing.JTable tblSanPham2;
    private javax.swing.JTable tblSanPhamBanHang;
    private javax.swing.JTable tblSanPhamLuuTru;
    private javax.swing.JTable tbl_KhuyenMai;
    private javax.swing.JTable tbl_KhuyenMaiNgungHoatDong;
    private javax.swing.JTable tbl_SanPhamGiamGia;
    private javax.swing.JLabel tfchitietdonhang;
    private javax.swing.JLabel tfdoanhthu;
    private javax.swing.JLabel tfdondahuy;
    private javax.swing.JLabel tfdonthanhcong;
    private javax.swing.JTextField tfketthucngaythongke;
    private javax.swing.JTextField tfngaybatdauthongke;
    private javax.swing.JLabel tfsoluongsanphambanthongke;
    private javax.swing.JLabel tftieudetongdoanhthu;
    private javax.swing.JLabel tftieudetongdonhang;
    private javax.swing.JTextField tftimkiemthongke;
    private javax.swing.JLabel tftongdonhang;
    private javax.swing.JTextArea txaMoTa;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenKh;
    private javax.swing.JTextField txtTenSanPham;
    private javax.swing.JTextField txtTienKHTra;
    private javax.swing.JTextField txtTienKhachDua;
    private javax.swing.JTextField txtTienThua;
    private javax.swing.JTextField txtTim;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTimKiemSanPham;
    private javax.swing.JTextField txtTongTienHang;
    private javax.swing.JTextField txt_MaGiamGia;
    private javax.swing.JTextField txt_MucGiam;
    private javax.swing.JTextField txt_TenKM;
    // End of variables declaration//GEN-END:variables
}
