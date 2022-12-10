/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.it17326.nhom5.repobanhang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PHAM DAC THANG
 */
public class dbcontest {
//     private static String hostName = "DESKTOP-HMT0GAQ\\SQLEXPRESS";

    private static String account = "sa";
    private static String pass = "sa";
    private static String dbName = "QUANLYBANDIENTHOAI";
    private static String connectionSQL = "jdbc:sqlserver://localhost:1433;databaseName=" + dbName;
    private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static Connection cnn;

    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
        }
    }

    // Mo ket noi 
    static Connection openDbConnection() {
        try {
            return DriverManager.getConnection(connectionSQL, account, pass);
        } catch (SQLException ex) {
            Logger.getLogger(dbcontest.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static void main(String[] args) {
        new dbcontest().openDbConnection();
    }
}
