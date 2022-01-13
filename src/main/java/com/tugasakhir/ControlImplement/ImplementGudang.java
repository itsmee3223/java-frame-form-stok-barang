/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tugasakhir.ControlImplement;

import com.tugasakhir.Connection.KonekDB;
import com.tugasakhir.ControlInterface.InterfaceGudang;
import com.tugasakhir.Model.Barang;
import com.tugasakhir.Model.Gudang;
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
public class ImplementGudang implements InterfaceGudang{

    @Override
    public Gudang simpan(Gudang o) throws SQLException {
        PreparedStatement st = (PreparedStatement) KonekDB.sambung().prepareStatement("INSERT INTO tblGudang VALUES(?,?,?)");
        st.setString(1, o.getIdBarang());
        st.setString(2, o.getIdKategori());
        st.setInt(3, o.getStok());
        st.executeUpdate();
        return o;
    }

    @Override
    public void ubah(Gudang o) throws SQLException {
        PreparedStatement st = (PreparedStatement) KonekDB.sambung().prepareStatement("UPDATE tblGudang set stok = ? WHERE idbarang = ?");
        st.setInt(1, o.getStok());
        st.setString(2, o.getIdBarang());
        st.executeUpdate();
    }

    @Override
    public void hapus(String idbarang) throws SQLException {
        PreparedStatement st = (PreparedStatement) KonekDB.sambung().prepareStatement("DELETE FROM tblGudang WHERE idbarang = ?");
        st.setString(1, idbarang);
        st.executeUpdate();
    }

    @Override
    public List<Gudang> tampil() throws SQLException {
        Statement stm = (Statement) KonekDB.sambung().createStatement();
        ResultSet rst = stm.executeQuery("SELECT * FROM tblgudang\n" +
"INNER JOIN tblbarang\n" +
"ON tblgudang.idbarang = tblbarang.idBarang\n" +
"INNER JOIN tblkategori\n" +
"ON tblkategori.idKategori = tblgudang.idkategori");
        List<Gudang> listGudang = new ArrayList<>();
        while(rst.next()){
            Gudang Gudang = new Gudang();
            Gudang.setIdBarang(rst.getString("idbarang"));
            Gudang.setIdKategori(rst.getString("idkategori"));
            Gudang.setStok(rst.getInt("stok"));
            Gudang.setNamaBarang(rst.getString("namaBarang"));
            Gudang.setNamaKategori(rst.getString("namaKategori"));
            listGudang.add(Gudang);
        }
        return listGudang;
        }

    @Override
    public List<Barang> tampilBarang() throws SQLException {
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
    
    @Override
    public List<Kategori> tampilKategori() throws SQLException {
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
