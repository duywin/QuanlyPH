/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlyphonghoc2.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import quanlyphonghoc2.*;
import java.util.Date;
import java.util.List;
import java.sql.SQLException;

/**
 *
 * @author duywo
 */
public class DiemSo implements DataObserver {

    private String MaHS, TenMon;
    private int Diem, HeSo;
    private Date ThoiGian;

    public DiemSo(String MaHS, String TenMon, int Diem, int HeSo, Date ThoiGian) {
        this.MaHS = MaHS;
        this.TenMon = TenMon;
        this.Diem = Diem;
        this.HeSo = HeSo;
        this.ThoiGian = ThoiGian;
    }

    public DiemSo(String MaHS) {
        this.MaHS = MaHS;
    }

    public DiemSo() {
    }

    public String getMaHS() {
        return MaHS;
    }

    public void setMaHS(String MaHS) {
        this.MaHS = MaHS;
    }

    public String getTenMon() {
        return TenMon;
    }

    public void setTenMon(String TenMon) {
        this.TenMon = TenMon;
    }

    public int getDiem() {
        return Diem;
    }

    public void setDiem(int Diem) {
        this.Diem = Diem;
    }

    public int getHeSo() {
        return HeSo;
    }

    public void setHeSo(int HeSo) {
        this.HeSo = HeSo;
    }

    public Date getThoiGian() {
        return ThoiGian;
    }

    public void setThoiGian(Date ThoiGian) {
        this.ThoiGian = ThoiGian;
    }

    public List<DiemSo> selectAll() {
        List<DiemSo> diemSoList = new ArrayList<>();
        try {
            Connection con = ConnectionFactory.getConnection();
            String selectQuery = "SELECT * FROM DiemSo";
            PreparedStatement ps = con.prepareStatement(selectQuery);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String maHS = rs.getString("MaHS");
                String tenMon = rs.getString("TenMon");
                int diem = rs.getInt("Diem");
                int heSo = rs.getInt("HeSo");
                Date thoiGian = rs.getDate("ThoiGian");

                DiemSo diemSo = new DiemSo(maHS, tenMon, diem, heSo, thoiGian);
                diemSoList.add(diemSo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return diemSoList;
    }

    @Override
    public boolean update(String action, String maUser) {
        boolean success = false;

        try {
            Connection con = ConnectionFactory.getConnection();
            String procedure = "";

            switch (action) {
                case "insert":
                    procedure = "{CALL InsertDiemSo(?, ?, ?, ?, ?, ?)}";
                    break;
                case "update":
                    procedure = "{CALL UpdateDiemSo(?, ?, ?, ?, ?, ?)}";
                    break;
                default:
                    // Handle invalid action
                    return false;
            }

            PreparedStatement ps = con.prepareCall(procedure);
            ps.setString(1, this.getMaHS());
            ps.setString(2, this.getTenMon());
            ps.setInt(3, this.getDiem());
            ps.setInt(4, this.getHeSo());
            ps.setDate(5, new java.sql.Date(this.getThoiGian().getTime()));
            ps.setString(6, maUser);

            success = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources if needed
        }
        return success;
    }

}
