/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tugasakhir.ControlInterface;

import com.tugasakhir.Model.Barang;
import com.tugasakhir.Model.Gudang;
import com.tugasakhir.Model.Kategori;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author tamva
 */
public interface InterfaceGudang {
    Gudang simpan(Gudang o) throws SQLException;
    void ubah(Gudang o) throws SQLException;
    void hapus(String id) throws SQLException;
    List<Gudang> tampil() throws SQLException;
    List<Kategori> tampilKategori() throws SQLException;
    List<Barang> tampilBarang() throws SQLException;
}
