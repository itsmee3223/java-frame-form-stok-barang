/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tugasakhir.ControlInterface;

import com.tugasakhir.Model.Kategori;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author tamva
 */
public interface InterfaceKategori {
    Kategori simpan(Kategori o) throws SQLException;
    void ubah(Kategori o) throws SQLException;
    void hapus(String id) throws SQLException;
    List<Kategori> tampil() throws SQLException;
}
