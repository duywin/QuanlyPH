/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student;

/**
 *
 * @author duywo
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import quanlyphonghoc2.*;
import quanlyphonghoc2.Teacher.LichThucHanh;

public class StudentDAO {
    public List<DiemSo> getDiemSoByMaHS(String maHS) {
        List<DiemSo> diemSoList = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = ConnectionFactory.getConnection();
            String query = "SELECT * FROM diemso WHERE MaHS = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, maHS);
            rs = ps.executeQuery();

            while (rs.next()) {
                String maHSResult = rs.getString("MaHS");
                String tenMon = rs.getString("TenMon");
                int diem = rs.getInt("Diem");
                int heSo = rs.getInt("HeSo");
                Date thoiGian = rs.getDate("ThoiGian");

                DiemSo diemSo = new DiemSo(maHSResult, tenMon, diem, heSo, thoiGian);
                diemSoList.add(diemSo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return diemSoList;
    }

    public List<LichThucHanh> getLichThucHanhByMaLop(String maLop) {
        List<LichThucHanh> lichThucHanhList = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = ConnectionFactory.getConnection();
            String query = "SELECT * FROM lichthuchanh WHERE MaLop = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, maLop);
            rs = ps.executeQuery();

            while (rs.next()) {
                String maPh = rs.getString("MaPh");
                String thoiGian = rs.getString("ThoiGian");
                Date ngay = rs.getDate("Ngay");

                LichThucHanh lichThucHanh = new LichThucHanh(maPh, thoiGian, maLop, ngay);
                lichThucHanhList.add(lichThucHanh);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 

        return lichThucHanhList;
    }
    public HocSinh getHocSinhByMaUS(String maus) {
        HocSinh hocSinh = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            con = ConnectionFactory.getConnection();
            String query = "SELECT * FROM hocsinh WHERE MaUS = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, maus);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                String tenHS = rs.getString("TenHS");
                String maHS = rs.getString("MaHS");
                String maLop = rs.getString("MaLop");
                Date ngaySinh = rs.getDate("NgaySinh");
                
                hocSinh = new HocSinh(maHS, tenHS, maus, maLop, ngaySinh);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return hocSinh;
    }
}

