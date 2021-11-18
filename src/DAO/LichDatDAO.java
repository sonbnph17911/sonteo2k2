/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import HELPER.JdbcHelper;
import MODEL.LichDat;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DuongNVPH
 */
public class LichDatDAO implements HairSalonDAO<LichDat, Integer>{
  
    
    private ArrayList<LichDat> selectBySQL(String sql , Object...args){
        ArrayList<LichDat> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {                
                LichDat model = new LichDat();
                model.setMaLichDat(rs.getInt("malichdat"));
                model.setNgayBatDau(rs.getDate("ngaybatdau"));
                model.setNgayKeyThuc(rs.getDate("ngayketthuc"));
                model.setGhiChu(rs.getString("ghichu"));
                model.setMaKhachHang(rs.getString("makhachhang"));
                model.setMaNhanVien(rs.getString("manhanvien"));
                list.add(model);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            e.printStackTrace();
     
        }
        return list ;
    }

    @Override
    public void insert(LichDat model) {
        
    }

    @Override
    public void update(LichDat model) {
        
    }

    @Override
    public void delete(Integer id) {
        
    }

    @Override
    public LichDat selectByID(Integer id) {
        return null ;
    }

    @Override
    public ArrayList<LichDat> selectAll() {
        return null;
    }
}
