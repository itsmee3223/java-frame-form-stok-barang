/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tugasakhir.ControlImplement;

import com.tugasakhir.Connection.KonekDB;
import com.tugasakhir.ControlInterface.InterfaceBarang;
import com.tugasakhir.Model.Barang;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tamva
 */
public class ImplementBarang implements InterfaceBarang{

    @Override
    public Barang simpan(Barang o) throws SQLException {
        PreparedStatement st = (PreparedStatement) KonekDB.sambung().prepareStatement("INSERT INTO tblbarang VALUES(?,?)");
        st.setString(1, o.getId());
        st.setString(2, o.getNama());
        st.executeUpdate();
        return o;
    }

    @Override
    public void ubah(Barang o) throws SQLException {
        PreparedStatement st = (PreparedStatement) KonekDB.sambung().prepareStatement("UPDATE tblbarang set namaBarang = ? WHERE idBarang = ?");
        st.setString(1, o.getNama());
        st.setString(2, o.getId());
        st.executeUpdate();
    }

    @Override
    public void hapus(String idKategori) throws SQLException {
        PreparedStatement st = (PreparedStatement) KonekDB.sambung().prepareStatement("DELETE FROM tblbarang WHERE idBarang = ?");
        st.setString(1, idKategori);
        st.executeUpdate();
    }

    @Override
    public List<Barang> tampil() throws SQLException {
        Statement stm = (Statement) KonekDB.sambung().createStatement();
        ResultSet rst = stm.executeQuery("SELECT * FROM tblbarang");
        List<Barang> listbarang = new ArrayList<>();
        while(rst.next()){
            Barang barang = new Barang();
            barang.setId(rst.getString("idBarang"));
            barang.setNama(rst.getString("namaBarang"));
            listbarang.add(barang);
        }
        return listbarang;
        }
    
}
