/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tugasakhir.ControlInterface;

import com.tugasakhir.Model.Barang;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author tamva
 */
public interface InterfaceBarang {
    Barang simpan(Barang o) throws SQLException;
    void ubah(Barang o) throws SQLException;
    void hapus(String id) throws SQLException;
    List<Barang> tampil() throws SQLException;
}
