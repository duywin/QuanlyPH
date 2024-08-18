/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlyphonghoc2.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import quanlyphonghoc2.*;
import java.util.Date;
import java.util.List;

public class HocSinh implements DataObserver
{
    private String MaHS, TenHS, MaUS, MaLop;
    private Date NgaySinh;

    public HocSinh() {
    }

    public HocSinh(String MaHS) {
        this.MaHS = MaHS;
    }

    public HocSinh(String MaHS, String TenHS, String MaUS, String MaLop, Date NgaySinh) {
        this.MaHS = MaHS;
        this.TenHS = TenHS;
        this.MaUS = MaUS;
        this.MaLop = MaLop;
        this.NgaySinh = NgaySinh;
    }

    public String getMaHS() {
        return MaHS;
    }

    public void setMaHS(String MaHS) {
        this.MaHS = MaHS;
    }

    public String getTenHS() {
        return TenHS;
    }

    public void setTenHS(String TenHS) {
        this.TenHS = TenHS;
    }

    public String getMaUS() {
        return MaUS;
    }

    public void setMaUS(String MaUS) {
        this.MaUS = MaUS;
    }

    public String getMaLop() {
        return MaLop;
    }

    public void setMaLop(String MaLop) {
        this.MaLop = MaLop;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }
    

        @Override
    public boolean update(String action, String maUser ) {
 boolean success = false;

        try {
            Connection con = ConnectionFactory.getConnection();
            String procedure = "";

            switch (action) {
                case "insert":
                    procedure = "{CALL InsertHocSinh(?, ?, ?, ?, ?, ?)}";
                    break;
                case "update":
                    procedure = "{CALL UpdateHocSinh(?, ?, ?, ?, ?)}";
                    break;
                default:
                    // Handle invalid action
                    return false;
            }

            PreparedStatement ps = con.prepareCall(procedure);
            ps.setString(1, this.getMaHS());
            ps.setString(2, this.getTenHS());
            ps.setString(3, this.getMaUS());
            ps.setString(4, this.getMaLop());
            ps.setDate(5, new java.sql.Date(this.getNgaySinh().getTime()));
            ps.setString(6, maUser);

            success = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources if needed
        }
        return success;
    }


    public List<HocSinh> selectAllHS() {
        List<HocSinh> hocSinhList = new ArrayList<>();
        try {
            Connection con = ConnectionFactory.getConnection();
            String selectQuery = "SELECT * FROM hocsinh";
            PreparedStatement ps = con.prepareStatement(selectQuery);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String MaHS = rs.getString("MaHS");
                String TenHS = rs.getString("TenHS");
                String MaUS = rs.getString("MaUS");
                String MaLop = rs.getString("MaLop");
                Date NgaySinh = rs.getDate("NgaySinh");

                HocSinh hocSinh = new HocSinh(MaHS, TenHS, MaUS, MaLop, NgaySinh);
                hocSinhList.add(hocSinh);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources (Connection, PreparedStatement, ResultSet)
        }
        return hocSinhList;
    }
}
