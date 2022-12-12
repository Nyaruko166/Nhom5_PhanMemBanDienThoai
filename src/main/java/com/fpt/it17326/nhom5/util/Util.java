/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.it17326.nhom5.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Date;
import net.bytebuddy.utility.RandomString;

/**
 *
 * @author youngboizseetinh
 */
public class Util {
    public static final String SLASH = "/";

    public static void createFolderImageUpload() {
        File theDir = new File("pictures");
        if (!theDir.exists()) {
            theDir.mkdirs();
        }
    }

    public static String getNameFileFromPath(String fileName, boolean isFile) {
        // "t.u.n.g.jpg"; => ["tung", "jpg"] tung.jpg
        String result = "";
        String [] splitStr = fileName.split("\\.");
        if (isFile) {
            if (splitStr.length  >= 2) {
                for (int i = 0; i < splitStr.length - 1; i++) {
                    result += splitStr[i];
                }
            }
        } else {
            result = splitStr[splitStr.length - 1];
        }
        return result;
    }


    public static void uploadImage(String path, String name) {
        File source = new File(path);
        String userDirectory = new File("").getAbsolutePath();
        File dest = new File("pictures" + SLASH + name);
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

    public static String randomString() {
        String generatedString = RandomString.make(10);
        return generatedString;
    }
}
