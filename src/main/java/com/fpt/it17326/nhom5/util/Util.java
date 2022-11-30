/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.it17326.nhom5.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Date;

/**
 *
 * @author youngboizseetinh
 */
public class Util {

    public static void createFolderImageUpload() {
        File theDir = new File("pictures");
        if (!theDir.exists()) {
            theDir.mkdirs();
        }
    }

    public static void uploadImage(String path) {
        File source = new File(path);
        File dest = new File("pictures\\" + source.getName());
        try {
            Files.copy(source.toPath(), dest.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Date getCurrentDate() {
        Date date = new Date();
        return date;
    }
}
