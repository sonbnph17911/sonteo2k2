/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import HELPER.JdbcHelper;
import MODEL.NhanVien;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DuongNVPH
 */
public class NhanVienDAO implements HairSalonDAO<NhanVien, String>{
    String insert = "insert into nhanvien values(?,?,?,?,?,?,?,?,?)";
    String update ="update nhanvien set manhanvien=?,matkhau=?,vaitro=?,hoten=?,"
            + " ngaysinh=?,ngaynhanviec=?,diachi=?,sodienthoai=?,ghichu=?";
    String delete = "delete from nhanvien where manhanvien=?";
    String select_by_id = "select * from nhanvien where manhanvien=?";
    String select_all = "select * from nhanvien ";
    
    private ArrayList<NhanVien> selectBySQL(String sql , Object...args){
        ArrayList<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {                
                NhanVien model = new NhanVien();
                String maNhanVien = rs.getString("manhanvien");
                String matKhau = rs.getString("matkhau");
                boolean vaiTro = rs.getBoolean("vaitro");
                String hoTen = rs.getString("hoten");
                Date ngaySinh = rs.getDate("ngaysinh");
                Date ngayNhanViec = rs.getDate("ngaynhanviec");
                String diaChi = rs.getString("diachi");
                String soDienThoai = rs.getString("sodienthoai");
                String ghiChu  = rs.getString("ghiChu");
                model.setMaNhanVien(maNhanVien);
                model.setMatKhau(matKhau);
                model.setVaiTro(vaiTro);
                model.setHoTen(hoTen);
                model.setNgaySinh(ngaySinh);
                model.setNgayNhanVien(ngayNhanViec);
                model.setDiaChi(diaChi);
                model.setSoDienThoai(soDienThoai);
                model.setGhiChu(ghiChu);
                list.add(model);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            e.printStackTrace();
     
        }
        return list ;
    }

    @Override
    public void insert(NhanVien model) {
        try {
            JdbcHelper.executeUpdate(insert, model.getMaNhanVien(),model.getMatKhau(),model.isVaiTro(),
                    model.getHoTen(),model.getNgaySinh(),model.getNgayNhanVien(),
                    model.getDiaChi(),model.getSoDienThoai(),model.getGhiChu());
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(NhanVien model) {
        try {
            JdbcHelper.executeUpdate(update,model.getMatKhau(),model.isVaiTro(),
                    model.getHoTen(),model.getNgaySinh(),model.getNgayNhanVien(),
                    model.getDiaChi(),model.getSoDienThoai(),model.getGhiChu(), model.getMaNhanVien());
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String id) {
        try {
            JdbcHelper.executeUpdate(delete, id);
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public NhanVien selectByID(String id) {
        ArrayList<NhanVien> list = new ArrayList<>();
        list = selectBySQL(select_by_id, id);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public ArrayList<NhanVien> selectAll() {
        return  selectBySQL(select_all);
    }
    
}
