/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlyphonghoc2.Teacher;

/**
 *
 * @author Admin
 */
import Admin.GiaoVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import quanlyphonghoc2.ConnectionFactory;
import quanlyphonghoc2.*;

public class UserDAO {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    int st;

    public boolean performLopHocAction(String action, LopHoc lopHoc, String username) {
        boolean success = false;
        String logMessage = "";

        try {
            con = ConnectionFactory.getConnection();

            String query = "";
            switch (action) {
                case "insert":
                    query = "INSERT INTO `lophoc` (`MaLop`, `TenLop`, `NienKhoa`, `Siso`) VALUES (?, ?, ?, ?)";
                    logMessage = "Đã thêm lớp mới";
                    break;
                case "update":
                    query = "UPDATE `lophoc` SET `TenLop` = ?, `NienKhoa` = ?, `Siso` = ? WHERE `MaLop` = ?";
                    logMessage = "Đã sửa lớp " + lopHoc.getTenLop();
                    break;
                case "delete":
                    query = "DELETE FROM `lophoc` WHERE `MaLop` = ?";
                    logMessage = "Đã xóa lớp " + lopHoc.getMaLop();
                    break;
                default:
                    return false;
            }

            ps = con.prepareStatement(query);
            if (!action.equals("delete")) {
                ps.setString(1, lopHoc.getMaLop());
                ps.setString(2, lopHoc.getTenLop());
                ps.setString(3, lopHoc.getNienKhoa());
                ps.setInt(4, lopHoc.getSiso());
            } else {
                ps.setString(1, lopHoc.getMaLop());
            }

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                success = true;
                logAction(username, logMessage);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
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

        return success;
    }

    public List<LopHoc> selectAllLopHoc() {
        List<LopHoc> lopHocList = new ArrayList<>();

        try {
            con = ConnectionFactory.getConnection();

            String selectQuery = "SELECT * FROM `lophoc`";
            ps = con.prepareStatement(selectQuery);
            rs = ps.executeQuery();

            while (rs.next()) {
                String maLop = rs.getString("MaLop");
                String tenLop = rs.getString("TenLop");
                String nienKhoa = rs.getString("NienKhoa");
                int siso = rs.getInt("Siso");

                LopHoc lopHoc = new LopHoc(maLop, tenLop, siso, nienKhoa);
                lopHocList.add(lopHoc);
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

        return lopHocList;
    }

    public int DangKyTH(LichThucHanh lichThucHanh, String username) {
        int result = -1; // Default value for unsuccessful operation

        try {
            con = ConnectionFactory.getConnection();

            // Check for duplicate entry
            String checkDuplicateQuery = "SELECT * FROM `lichthuchanh` WHERE `MaPh` = ? AND `Ngay` = ? AND `Thoigian` = ?";
            ps = con.prepareStatement(checkDuplicateQuery);
            ps.setString(1, lichThucHanh.getMaPh());
            ps.setDate(2, new java.sql.Date(lichThucHanh.getNgay().getTime())); // Assuming Ngay is a java.util.Date
            ps.setString(3, lichThucHanh.getThoiGian());

            ResultSet duplicateResultSet = ps.executeQuery();
            if (duplicateResultSet.next()) {
                // Duplicate entry found
                result = -1;
            } else {
                // Insert the new entry
                String insertQuery = "INSERT INTO `lichthuchanh` (`MaPh`, `Ngay`, `Thoigian`, `MaLop`) VALUES (?, ?, ?, ?)";
                ps = con.prepareStatement(insertQuery);
                ps.setString(1, lichThucHanh.getMaPh());
                ps.setDate(2, new java.sql.Date(lichThucHanh.getNgay().getTime())); // Assuming Ngay is a java.util.Date
                ps.setString(3, lichThucHanh.getThoiGian());
                ps.setString(4, lichThucHanh.getMaLop());

                int rowsInserted = ps.executeUpdate();
                if (rowsInserted > 0) {
                    logAction(username, "Đã đăng ký phòng thực hành");
                    result = 1; // Successful insert
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
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

        return result;
    }

    public List<LichThucHanh> selectAllLichTH() {
        List<LichThucHanh> lichThucHanhList = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            String selectQuery = "SELECT * FROM lichthuchanh";
            ps = con.prepareStatement(selectQuery);
            rs = ps.executeQuery();

            while (rs.next()) {
                String maPh = rs.getString("MaPh");
                String thoiGian = rs.getString("ThoiGian");
                String maLop = rs.getString("MaLop");
                Date ngay = rs.getDate("Ngay");

                LichThucHanh lichThucHanh = new LichThucHanh(maPh, thoiGian, maLop, ngay);
                lichThucHanhList.add(lichThucHanh);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources (Connection, PreparedStatement, ResultSet)
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
        return lichThucHanhList;
    }

    public String[] getMaPhList() {
        ArrayList<String> maPhList = new ArrayList<>();

        try {
            con = ConnectionFactory.getConnection();

            String selectQuery = "SELECT `MaPh` FROM `phonghoc`";
            ps = con.prepareStatement(selectQuery);
            rs = ps.executeQuery();

            while (rs.next()) {
                maPhList.add(rs.getString("MaPh"));
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

        return maPhList.toArray(new String[0]);
    }

    public String[] getMaLopList() {
        ArrayList<String> maLopList = new ArrayList<>();

        try {
            con = ConnectionFactory.getConnection();
            String query = "SELECT `MaLop` FROM `lophoc`";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                maLopList.add(rs.getString("MaLop"));
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
        return maLopList.toArray(new String[0]);
    }

    public boolean modifyHocSinh(String action, HocSinh hocSinh, String maUser) {
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

            ps = con.prepareCall(procedure);
            ps.setString(1, hocSinh.getMaHS());
            ps.setString(2, hocSinh.getTenHS());
            ps.setString(3, hocSinh.getMaUS());
            ps.setString(4, hocSinh.getMaLop());
            ps.setDate(5, new java.sql.Date(hocSinh.getNgaySinh().getTime()));
            ps.setString(6, maUser);

            success = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }

        return success;
    }

    private void logAction(String maUser, String noidung) {
        try {
            con = ConnectionFactory.getConnection();
            String insertLogQuery = "INSERT INTO `log` (`MaUser`, `Noidung`, `ThoiGian`) VALUES (?, ?, NOW())";
            ps = con.prepareStatement(insertLogQuery);
            ps.setString(1, maUser);
            ps.setString(2, noidung);
            ps.executeUpdate();
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
    }

    public String[] selectMaHSFromHocSinh() {
        List<String> maHSList = new ArrayList<>();
        try {
            Connection con = ConnectionFactory.getConnection();
            String selectQuery = "SELECT MaHS FROM hocsinh";
            PreparedStatement ps = con.prepareStatement(selectQuery);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String MaHS = rs.getString("MaHS");
                maHSList.add(MaHS);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources (Connection, PreparedStatement, ResultSet)
        }
        return maHSList.toArray(new String[0]);
    }

    public String[] getMaUserByLoaiTK() {
        List<String> maUserList = new ArrayList<>();

        try {
            Connection con = ConnectionFactory.getConnection();

            String selectQuery = "SELECT MaUser FROM taikhoan WHERE LoaiTK = 'hs'";
            PreparedStatement ps = con.prepareStatement(selectQuery);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String maUser = rs.getString("MaUser");
                maUserList.add(maUser);
            }

            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return maUserList.toArray(new String[0]);
    }

    // Method to retrieve MaLop
    public String[] getMaLop() {
        List<String> maLopList = new ArrayList<>();

        try {
            Connection con = ConnectionFactory.getConnection();

            String selectQuery = "SELECT MaLop FROM lophoc";
            PreparedStatement ps = con.prepareStatement(selectQuery);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String maLop = rs.getString("MaLop");
                maLopList.add(maLop);
            }

            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return maLopList.toArray(new String[0]);
    }

    public GiaoVien getGiaoVienByMaUser(String maUser) {
        GiaoVien giaoVien = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = ConnectionFactory.getConnection();
            String query = "SELECT * FROM giaovien WHERE MaUser = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, maUser);
            rs = ps.executeQuery();

            if (rs.next()) {
                String MaGV = rs.getString("MaGV");
                String TenGV = rs.getString("TenGV");
                Date NgaySinh = rs.getDate("NgaySinh");
                String DiaChi = rs.getString("DiaChi");
                String SDT = rs.getString("SDT");
                int SoNamCongTac = rs.getInt("SoNamCongTac");

                giaoVien = new GiaoVien(MaGV, TenGV, DiaChi, SDT, SoNamCongTac, maUser, NgaySinh);
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
        return giaoVien;
    }

}
