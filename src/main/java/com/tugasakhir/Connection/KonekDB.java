/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tugasakhir.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author tamva
 */
public class KonekDB {
    private static Connection con;
    public static Connection sambung() throws SQLException{
        try {
            if(con == null){
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                con = (Connection) DriverManager.getConnection("jdbc:mysql:" + "//localhost:3306/ta_stokBarang","root","");
            }
        }  catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Koneksi Gagal");
        }
        return con;
    }
}
