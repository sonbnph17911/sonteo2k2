/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import HELPER.JdbcHelper;
import MODEL.ChiTietHoaDon;
import MODEL.HoaDon;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DuongNVPH
 */
public class ChiTietHoaDonDAO implements HairSalonDAO<ChiTietHoaDon, Integer>{
    
    private ArrayList<ChiTietHoaDon> selectBySQL(String sql , Object...args){
        ArrayList<ChiTietHoaDon> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {                
                ChiTietHoaDon model = new ChiTietHoaDon();
                model.setMaChiTietHoaDon(rs.getInt("machitiethoadon"));
                model.setGiamGia(rs.getFloat("giamgia"));
                model.setThanhTien(rs.getFloat("thanhtien"));
                model.setMaHoaDon(rs.getString("mahoadon"));
                model.setMaSanPham(rs.getString("masanpham"));
                model.setMaDichVu(rs.getString("madichvu"));
                list.add(model);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            e.printStackTrace();
     
        }
        return list ;
    }

    @Override
    public void insert(ChiTietHoaDon model) {
        
    }

    @Override
    public void update(ChiTietHoaDon model) {
        
    }

    @Override
    public void delete(Integer id) {
        
    }

    @Override
    public ChiTietHoaDon selectByID(Integer id) {
        return null ;
    }

    @Override
    public ArrayList<ChiTietHoaDon> selectAll() {
        return null ;
    }

    
}
