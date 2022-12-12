package com.fpt.it17326.nhom5.util;

import com.fpt.it17326.nhom5.domainmodel.*;
import com.fpt.it17326.nhom5.service.*;
import com.fpt.it17326.nhom5.service.impl.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import net.bytebuddy.jar.asm.Handle;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.xssf.usermodel.XSSFDataValidationHelper;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import lombok.Builder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

@Getter
@Setter
public class ExcelProductHelper {
    private Workbook workbook;
    private Sheet sheet;
    private List<HangDienThoai> brands;
    private List<Chip> chips;
    private List<Ram> rams;
    private List<Rom> roms;
    private List<Pin> pins;
    private List<MauSac> colors;

    private HangDienThoaiService brandService;
    private ChipService chipService;
    private RamService ramService;
    private RomService romService;
    private PinService pinService;
    private MauSacService colorService;
    private SanPhamService productService;
    private ImeiService imeiService;

    public ExcelProductHelper() {
        initService();
        initData();
    }

    public boolean importExcel() {
        HashMap<Integer, List<String>> data = new HashMap<>();
        JFileChooser fileChooser = new JFileChooser();
        FileFilter filter = new FileNameExtensionFilter("Excel file", "xls", "xlsx");
        fileChooser.setFileFilter(filter);
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            // ArrayList<String> data =
            // readExcel(fileChooser.getSelectedFile().getAbsolutePath());
            boolean status = readExcel(fileChooser.getSelectedFile().getAbsolutePath());
            return status;
        }
        return false;
    }

    private boolean readExcel(String fileLocation) {
        ArrayList<String> data = new ArrayList<>();
        ArrayList<SanPham> products = new ArrayList<>();
        try {
            FileInputStream file = new FileInputStream(new File(fileLocation));
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);
            for (int i = 0; i <= sheet.getLastRowNum(); i++) {
                if (i == 0) {
                    continue;
                }
                String name = checkStringNull(readValueCell(sheet, i, 0));
                Integer idBrand = getIdFromTextSelect(readValueCell(sheet, i, 1));
                Integer idChip = getIdFromTextSelect(readValueCell(sheet, i, 2));
                Integer idRam = getIdFromTextSelect(readValueCell(sheet, i, 3));
                Integer idRom = getIdFromTextSelect(readValueCell(sheet, i, 4));
                Integer idPin = getIdFromTextSelect(readValueCell(sheet, i, 5));
                Integer idColor = getIdFromTextSelect(readValueCell(sheet, i, 6));
                String imeiStr = readValueCell(sheet, i, 7);
                String description = readValueCell(sheet, i, 8);
                float unitPrice = getUnitPrice(readValueCell(sheet, i, 9));
                String image = readValueCell(sheet, i, 10);
                if (name == null || idBrand == null
                        || idChip == null || idRam == null || idRom == null || idPin == null || idColor == null
                        || imeiStr == null
                        || description == null || unitPrice == -1 || image == null) {
                    continue;
                }
                File f = new File(image);
                String imgName = Util.getNameFileFromPath(f.getName(), true) + String.valueOf(new Date().getTime())
                        + "." + Util.getNameFileFromPath(f.getName(), false);
                SanPham sp = SanPham.builder()
                        .tenSP(name)
                        .hangdt(getBrandInList(idBrand.intValue()))
                        .chip(getChipInList(idChip.intValue()))
                        .ram(getRamInList(idRam.intValue()))
                        .rom(getRomInList(idRom.intValue()))
                        .pin(getPinInList(idPin.intValue()))
                        .mauSac(getColorInList(idColor.intValue()))
                        .moTa(description)
                        .donGia(unitPrice)
                        .urlAnh(imgName)
                        .maSP(Util.randomString())
                        .soLuong(1)
                        .createdAt(Util.getCurrentDate())
                        .build();
                String result = productService.add(sp);
                if (result.contains("thành công")) {
                    SanPham last = productService.getSPLast();
                    Imei imei = Imei.builder()
                            .maImel(Util.randomString())
                            .imei(imeiStr)
                            .sanPham(last)
                            .trangThai(false)
                            .createdAt(Util.getCurrentDate())
                            .build();
                    imeiService.add(imei);
                    Util.uploadImage(image, imgName);
                }
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    private HangDienThoai getBrandInList(int id) {
        int index = IntStream.range(0, brands.size())
                .filter(i -> brands.get(i).getId() == id)
                .findFirst().orElse(-1);
        if (index != -1) {
            return brands.get(index);
        }
        return null;
    }

    private Chip getChipInList(int id) {
        int index = IntStream.range(0, chips.size())
                .filter(i -> chips.get(i).getId() == id)
                .findFirst().orElse(-1);
        if (index != -1) {
            return chips.get(index);
        }
        return null;
    }

    private Ram getRamInList(int id) {
        int index = IntStream.range(0, rams.size())
                .filter(i -> rams.get(i).getId() == id)
                .findFirst().orElse(-1);
        if (index != -1) {
            return rams.get(index);
        }
        return null;
    }

    private Rom getRomInList(int id) {
        int index = IntStream.range(0, roms.size())
                .filter(i -> roms.get(i).getId() == id)
                .findFirst().orElse(-1);
        if (index != -1) {
            return roms.get(index);
        }
        return null;
    }

    private Pin getPinInList(int id) {
        int index = IntStream.range(0, pins.size())
                .filter(i -> pins.get(i).getId() == id)
                .findFirst().orElse(-1);
        if (index != -1) {
            return pins.get(index);
        }
        return null;
    }

    private MauSac getColorInList(int id) {
        int index = IntStream.range(0, colors.size())
                .filter(i -> colors.get(i).getId() == id)
                .findFirst().orElse(-1);
        if (index != -1) {
            return colors.get(index);
        }
        return null;
    }

    private String checkStringNull(String text) {
        if (text != null) {
            if (text.trim().equals("")) {
                return null;
            }
        }
        return text;
    }

    private float getUnitPrice(String text) {
        if (text != null) {
            try {
                float unitPrice = Float.parseFloat(text);
                return unitPrice;
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
        return -1;
    }

    private Integer getIdFromTextSelect(String text) {
        Pattern pattern = Pattern.compile("<<\\d+>>");
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            text = text.replaceAll("^.*<<(\\d+)>>", "$1");
            Integer id = -1;
            try {
                id = Integer.parseInt(text);
                return id;
            } catch (NumberFormatException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
        return null;
    }

    private String readValueCell(Sheet sheet, int row, int column) {
        Cell cell = sheet.getRow(row).getCell(column);
        if (cell == null)
            return "";
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf(new Double(cell.getNumericCellValue()).longValue());
            default:
                break;
        }
        return "";
    }

    private void initService() {
        brandService = new HangDienThoaiServiceImpl();
        chipService = new ChipServiceImpl();
        ramService = new RamServiceImpl();
        romService = new RomServiceImpl();
        pinService = new PinServiceImpl();
        colorService = new MauSacServiceImpl();
        productService = new SanPhamServiceImpl();
        imeiService = new ImeiServiceImpl();
    }

    private void initData() {
        brands = brandService.getAllHangDT();
        chips = chipService.getAllChip();
        rams = ramService.getAllRam();
        roms = romService.getAllRom();
        pins = pinService.getAllPin();
        colors = colorService.getAllMauSac();
    }

    public String createTemplate() {
        // create template workbook
        initTemplate();
        // create header
        createHeader();
        // create cell
        fillData();
        // save
        String path = saveTemplate();
        return path;

    }

    private void setConstrain(String[] data, int row, int col) {
        DataValidation dataValidation = null;
        DataValidationConstraint constraint = null;
        DataValidationHelper validationHelper = null;
        validationHelper = new XSSFDataValidationHelper((XSSFSheet) sheet);
        CellRangeAddressList addressList = new CellRangeAddressList(row, row, col, col);
        constraint = validationHelper.createExplicitListConstraint(data);
        dataValidation = validationHelper.createValidation(constraint, addressList);
        dataValidation.setSuppressDropDownArrow(true);
        sheet.addValidationData(dataValidation);
    }

    private void initTemplate() {
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("Project");
        sheet.setColumnWidth(0, 6000);
        sheet.setColumnWidth(1, 4000);
        sheet.setColumnWidth(2, 4000);
        sheet.setColumnWidth(3, 4000);
        sheet.setColumnWidth(4, 4000);
        sheet.setColumnWidth(5, 4000);
        sheet.setColumnWidth(6, 4000);
        sheet.setColumnWidth(7, 4000);
        sheet.setColumnWidth(8, 4000);
        sheet.setColumnWidth(9, 5000);
        sheet.setColumnWidth(9, 6000);
    }

    private void setCellValue(Row row, int colNumber, String content, CellStyle style) {
        Cell cell = row.createCell(colNumber);
        cell.setCellValue(content);
        if (style != null) {
            cell.setCellStyle(style);
        }
    }

    private void createHeader() {
        Row header = sheet.createRow(0);
        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        XSSFFont font = ((XSSFWorkbook) workbook).createFont();
        font.setFontName("Arial");
        font.setFontHeightInPoints((short) 16);
        font.setBold(true);
        headerStyle.setFont(font);

        setCellValue(header, 0, "Tên sản phẩm", headerStyle);
        setCellValue(header, 1, "Hãng", headerStyle);
        setCellValue(header, 2, "Chip", headerStyle);
        setCellValue(header, 3, "Ram", headerStyle);
        setCellValue(header, 4, "Rom", headerStyle);
        setCellValue(header, 5, "Pin", headerStyle);
        setCellValue(header, 6, "Màu sắc", headerStyle);
        setCellValue(header, 7, "Imei", headerStyle);
        setCellValue(header, 8, "Mô tả", headerStyle);
        setCellValue(header, 9, "Đơn giá", headerStyle);
        setCellValue(header, 10, "Ảnh sản phẩm", headerStyle);
    }

    private void fillData() {
        CellStyle style = workbook.createCellStyle();
        style.setWrapText(true);
        for (int i = 1; i <= 101; i++) {
            addBrandCombo(i);
            addChipCombo(i);
            addRamCombo(i);
            addRomCombo(i);
            addPinCombo(i);
            addColorCombo(i);
        }
    }

    private void addBrandCombo(int row) {
        String[] data = new String[brands.size()];
        for (int i = 0; i < brands.size(); i++) {
            HangDienThoai item = brands.get(i);
            data[i] = item.getTenHang() + " <<" + item.getId() + ">>";
        }
        setConstrain(data, row, 1);
    }

    private void addChipCombo(int row) {
        String[] data = new String[chips.size()];
        for (int i = 0; i < chips.size(); i++) {
            Chip item = chips.get(i);
            data[i] = item.getTenChip() + " <<" + item.getId() + ">>";
        }
        setConstrain(data, row, 2);
    }

    private void addRamCombo(int row) {
        String[] data = new String[rams.size()];
        for (int i = 0; i < rams.size(); i++) {
            Ram item = rams.get(i);
            data[i] = item.getDungLuong() + " <<" + item.getId() + ">>";
        }
        setConstrain(data, row, 3);
    }

    private void addRomCombo(int row) {
        String[] data = new String[roms.size()];
        for (int i = 0; i < roms.size(); i++) {
            Rom item = roms.get(i);
            data[i] = item.getTenRom() + " <<" + item.getId() + ">>";
        }
        setConstrain(data, row, 4);
    }

    private void addPinCombo(int row) {
        String[] data = new String[pins.size()];
        for (int i = 0; i < pins.size(); i++) {
            Pin item = pins.get(i);
            data[i] = item.getTenPin() + " <<" + item.getId() + ">>";
        }
        setConstrain(data, row, 5);
    }

    private void addColorCombo(int row) {
        String[] data = new String[colors.size()];
        for (int i = 0; i < colors.size(); i++) {
            MauSac item = colors.get(i);
            data[i] = item.getTenMauSac() + " <<" + item.getId() + ">>";
        }
        setConstrain(data, row, 6);
    }

    private String saveTemplate() {
        JFileChooser fileChooser = new JFileChooser();
        String fileDictName = "template.xlsx";
        fileChooser.setDialogTitle("Specify a file to save");
        FileFilter filter = new FileNameExtensionFilter("Template File", ".xlsx");
        fileChooser.setAcceptAllFileFilterUsed(false); // to show or not all other files
        fileChooser.addChoosableFileFilter(filter);
        fileChooser.setSelectedFile(new File(fileDictName)); // when you want to show the name of file into the chooser
        fileChooser.setVisible(true);
        int userSelection = fileChooser.showSaveDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            String path = fileToSave.getAbsolutePath();
            if (!path.endsWith(".xlsx") && !path.endsWith(".xls")) {
                path += ".xlsx";
            }
            FileOutputStream outputStream = null;
            try {
                outputStream = new FileOutputStream(path);
                workbook.write(outputStream);
                workbook.close();
                return path;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
