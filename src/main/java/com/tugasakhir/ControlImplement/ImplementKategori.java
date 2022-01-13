/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tugasakhir.ControlImplement;

import com.tugasakhir.Connection.KonekDB;
import com.tugasakhir.ControlInterface.InterfaceKategori;
import com.tugasakhir.Model.Kategori;
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
public class ImplementKategori implements InterfaceKategori{

    @Override
    public Kategori simpan(Kategori o) throws SQLException {
        PreparedStatement st = (PreparedStatement) KonekDB.sambung().prepareStatement("INSERT INTO tblKategori VALUES(?,?)");
        st.setString(1, o.getId());
        st.setString(2, o.getNama());
        st.executeUpdate();
        return o;
    }

    @Override
    public void ubah(Kategori o) throws SQLException {
        PreparedStatement st = (PreparedStatement) KonekDB.sambung().prepareStatement("UPDATE tblKategori set namaKategori = ? WHERE idKategori = ?");
        st.setString(1, o.getNama());
        st.setString(2, o.getId());
        st.executeUpdate();
    }

    @Override
    public void hapus(String idKategori) throws SQLException {
        PreparedStatement st = (PreparedStatement) KonekDB.sambung().prepareStatement("DELETE FROM tblKategori WHERE idKategori = ?");
        st.setString(1, idKategori);
        st.executeUpdate();
    }

    @Override
    public List<Kategori> tampil() throws SQLException {
        Statement stm = (Statement) KonekDB.sambung().createStatement();
        ResultSet rst = stm.executeQuery("SELECT * FROM tblKategori");
        List<Kategori> listKategori = new ArrayList<>();
        while(rst.next()){
            Kategori Kategori = new Kategori();
            Kategori.setId(rst.getString("idKategori"));
            Kategori.setNama(rst.getString("namaKategori"));
            listKategori.add(Kategori);
        }
        return listKategori;
        }
    
}
