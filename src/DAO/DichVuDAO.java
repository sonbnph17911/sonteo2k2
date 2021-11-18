/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import HELPER.JdbcHelper;
import MODEL.DichVu;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DuongNVPH
 */
public class DichVuDAO implements HairSalonDAO<DichVu, String>{
    
    private ArrayList<DichVu> selectBySQL(String sql , Object...args){
        ArrayList<DichVu> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {                
                DichVu model = new DichVu();
                model.setMaDichVu(rs.getString("madichvu"));
                model.setTenDichVu(rs.getString("tendichvu"));
                model.setGiaTien(rs.getFloat("giatien"));
                list.add(model);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            e.printStackTrace();
     
        }
        return list ;
    }
    
    
    @Override
    public void insert(DichVu model) {
        
    }

    @Override
    public void update(DichVu model) {
        
    }

    @Override
    public void delete(String id) {
        
    }

    @Override
    public DichVu selectByID(String id) {
           return null ;
    }

    @Override
    public ArrayList<DichVu> selectAll() {
        return null ;
    }
    
}
