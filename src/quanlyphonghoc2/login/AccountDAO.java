package quanlyphonghoc2.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import quanlyphonghoc2.ConnectionFactory;

public class AccountDAO {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public String checkLogin(String username, String password) {
        String loaiTK = null;

        try {
            con = ConnectionFactory.getConnection();
            String query = "SELECT LoaiTK FROM taikhoan WHERE Username=? AND Password=?";
            ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();

            if (rs.next()) {
                loaiTK = rs.getString("LoaiTK");
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
        return loaiTK;
    }
        public String getmaus(String username, String password) {
        String maus = null;

        try {
            con = ConnectionFactory.getConnection();
            String query = "SELECT MaUser FROM taikhoan WHERE Username=? AND Password=?";
            ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();

            if (rs.next()) {
                maus = rs.getString("MaUser");
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
        return maus;
    }

    public int countTaiKhoan() {
        int count = 0;

        try {
            con = ConnectionFactory.getConnection();
            String query = "SELECT COUNT(*) AS count FROM `taikhoan`";
            ps = con.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                count = resultSet.getInt("count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count;
    }

    public boolean insertTaiKhoan(TaiKhoan taiKhoan) {
        boolean success = false;

        try {
            con = ConnectionFactory.getConnection();

            // Prepare the call to the stored procedure
            String procedureCall = "{CALL CountAndInsertTaiKhoan(?, ?, ?, ?)}";
            ps = con.prepareCall(procedureCall);
            ps.setString(1, taiKhoan.getMaUser());
            ps.setString(2, taiKhoan.getUsername());
            ps.setString(3, taiKhoan.getPassword());
            ps.setString(4, taiKhoan.getLoaiTK());

            // Execute the stored procedure
            ResultSet rs = ps.executeQuery();

            // Check the result
            if (rs.next()) {
                boolean procSuccess = rs.getBoolean("success");
                if (procSuccess) {
                    success = true;
                } else {
                    return false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }
}
