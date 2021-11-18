/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import HELPER.JdbcHelper;
import MODEL.KhachHang;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DuongNVPH
 */
public class KhachHangDAO implements HairSalonDAO<KhachHang, String>{


    
    private ArrayList<KhachHang> selectBySQL(String sql , Object...args){
        ArrayList<KhachHang> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {                
                KhachHang model = new KhachHang();
                model.setMaKhachHang(rs.getString("makhachhang"));
                model.setHoTen(rs.getString("hoten"));
                model.setSoDienThoai(rs.getString("sodienthoai"));
                model.setEmail(rs.getString("email"));
                model.setGioiTinh(rs.getBoolean("gioitinh"));
                model.setDiaChi(rs.getString("diachi"));
                model.setGhiChu(rs.getString("ghichu"));
                list.add(model);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            e.printStackTrace();
     
        }
        return list ;
    }

    @Override
    public void insert(KhachHang model) {
      
    }

    @Override
    public void update(KhachHang model) {
      
    }

    @Override
    public void delete(String id) {
        
    }

    @Override
    public KhachHang selectByID(String id) {
        return null;
    }

    @Override
    public ArrayList<KhachHang> selectAll() {
        return null ;
    }
    
    
}
