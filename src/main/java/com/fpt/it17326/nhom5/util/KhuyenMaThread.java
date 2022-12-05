/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.it17326.nhom5.util;

import com.fpt.it17326.nhom5.domainmodel.KhuyenMai;
import com.fpt.it17326.nhom5.repository.KhuyenMaiRepository;
import com.fpt.it17326.nhom5.service.KhuyenMaiService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ngock
 */
public class KhuyenMaThread extends Thread {

    public KhuyenMaThread() {
    }

    @Override
    public void run() {
        KhuyenMaiRepository khuyenMaiRepository = new KhuyenMaiRepository();
        List<KhuyenMai> khuyenMaiRepositorys = khuyenMaiRepository.getAll();
        while (true) {
            for (KhuyenMai khuyenMai : khuyenMaiRepositorys) {
                if (java.util.Calendar.getInstance().getTime().after(khuyenMai.getNgayKetThuc()) == true) {
                    khuyenMai.setDeleted(true);
                    khuyenMaiRepository.update(khuyenMai);
                }
            }
            try {
                sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(KhuyenMaThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}