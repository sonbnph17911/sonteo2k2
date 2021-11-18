/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import HELPER.JdbcHelper;
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
public class HoaDonDAO implements HairSalonDAO<HoaDon, String>{
    
    private ArrayList<HoaDon> selectBySQL(String sql , Object...args){
        ArrayList<HoaDon> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {                
                HoaDon model = new HoaDon();
                model.setMaHoaDon(rs.getString("mahoadon"));
                model.setNgayLapHoaDon(rs.getDate("ngaybatdau"));
                model.setNgayThanhToan(rs.getDate("ngayketthuc"));
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
    public void insert(HoaDon model) {
        
    }

    @Override
    public void update(HoaDon model) {
        
    }

    @Override
    public void delete(String id) {
        
    }

    @Override
    public HoaDon selectByID(String id) {
        return null ;
    }

    @Override
    public ArrayList<HoaDon> selectAll() {
        return null ;
    }
    
    
}
