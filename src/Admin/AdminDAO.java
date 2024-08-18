package Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.Timestamp;
import quanlyphonghoc2.ConnectionFactory;

public class AdminDAO {

    Connection con = null;
    PreparedStatement ps = null;
    int st;
    ResultSet rs = null;

    public boolean modifyPhongHoc(String action, PhongHoc phongHoc, String maUser) {
        boolean success = false;

        try {
            con = ConnectionFactory.getConnection();
            String procedure = "";

            switch (action) {
                case "insert":
                    procedure = "{CALL InsertPhongHoc(?, ?, ?, ?)}";
                    break;
                case "update":
                    procedure = "{CALL UpdatePhongHoc(?, ?, ?, ?)}";
                    break;
                case "delete":
                    procedure = "{CALL DeletePhongHoc(?, ?)}"; // Only MaPh needed for deletion
                    break;
                default:
                    return false;
            }

            ps = con.prepareCall(procedure);

            if (action.equals("delete")) {
                ps.setString(1, phongHoc.getMaPhong());
                ps.setString(2, maUser);// Only MaPh needed for deletion
            } else {
                ps.setString(1, phongHoc.getMaPhong());
                ps.setString(2, phongHoc.getTenPhong());
                ps.setInt(3, phongHoc.getSucchua());
                ps.setString(4, maUser);
            }

            success = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }

    public boolean modifyGiaoVien(String action, GiaoVien giaoVien, String maUser) {
        boolean success = false;

        try {
            con = ConnectionFactory.getConnection();
            String procedure = "";

            switch (action) {
                case "insert":
                    procedure = "{CALL InsertGiaoVien(?, ?, ?, ?, ?, ?, ?, ?)}";
                    break;
                case "update":
                    procedure = "{CALL UpdateGiaoVien(?, ?, ?, ?, ?, ?, ?, ?)}";
                    break;
                case "delete":
                    procedure = "{CALL DeleteGiaoVien(?, ?)}";
                    break;
                default:
                    return false;
            }

            ps = con.prepareCall(procedure);

            if (action.equals("delete")) {
                ps.setString(1, giaoVien.getMaGV());
                ps.setString(2, maUser);
            } else {
                ps.setString(1, giaoVien.getMaGV());
                ps.setString(2, giaoVien.getTenGv());
                ps.setDate(3, new java.sql.Date(giaoVien.getNgaysinh().getTime()));
                ps.setString(4, giaoVien.getDiaChi());
                ps.setString(5, giaoVien.getSDT());
                ps.setInt(6, giaoVien.getSonam());
                ps.setString(7, giaoVien.getMaUser());
                ps.setString(8, maUser);
            }

            success = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return success;
    }

    public boolean modifyDungCu(String action, DungCu dungCu, String maUser) {
        boolean success = false;

        try {
            con = ConnectionFactory.getConnection();
            String procedure = "";

            switch (action) {
                case "insert":
                    procedure = "{CALL InsertDungCu(?, ?, ?, ?, ?)}";
                    break;
                case "update":
                    procedure = "{CALL UpdateDungCu(?, ?, ?, ?, ?)}";
                    break;
                case "delete":
                    procedure = "{CALL DeleteDungCu(?, ?)}";
                    break;
                default:
                    // Handle invalid action
                    return false;
            }

            ps = con.prepareCall(procedure);
            if (action.equals("delete")) {
                ps.setString(1, dungCu.getMaDc());
                ps.setString(2, maUser);
            } else {
                ps.setString(1, dungCu.getMaDc());
                ps.setString(2, dungCu.getTenDc());
                ps.setString(3, dungCu.getMaPh());
                ps.setInt(4, dungCu.getSoluong());
                ps.setString(5, maUser);
            }

            success = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }

    public boolean modifyHoaDon(String action, HoaDon hoaDon, String maUser) {
        boolean success = false;

        try {
            con = ConnectionFactory.getConnection();
            String procedure = "";

            switch (action) {
                case "insert":
                    procedure = "{CALL InsertHoaDon(?, ?, ?, ?, ?, ?)}";
                    break;
                case "update":
                    procedure = "{CALL UpdateHoaDon(?, ?, ?, ?, ?)}";
                    break;
                default:
                    // Handle invalid action
                    return false;
            }

            ps = con.prepareCall(procedure);
            ps.setString(1, hoaDon.getMaHD());

            if (action.equals("insert")) {
                ps.setDate(2, new java.sql.Date(hoaDon.getNgayNhap().getTime()));
                ps.setString(3, hoaDon.getMaDC());
                ps.setInt(4, hoaDon.getSoLuong());
                ps.setInt(5, hoaDon.getThanhTien());
                ps.setString(6, maUser);
            } else if (action.equals("update")) {
                ps.setString(2, hoaDon.getMaDC());
                ps.setInt(3, hoaDon.getSoLuong());
                ps.setInt(4, hoaDon.getThanhTien());
                ps.setString(5, maUser);
            }

            success = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources if needed
        }

        return success;
    }

    public List<PhongHoc> selectAllPhongHoc() {
        List<PhongHoc> phongHocList = new ArrayList<>();

        try {
            con = ConnectionFactory.getConnection();
            String selectQuery = "SELECT * FROM phonghoc";
            ps = con.prepareStatement(selectQuery);
            rs = ps.executeQuery();

            while (rs.next()) {
                String maPhong = rs.getString("MaPh");
                String tenPhong = rs.getString("TenPh");
                int sucChua = rs.getInt("Succhua");

                PhongHoc phongHoc = new PhongHoc(maPhong, tenPhong, sucChua);
                phongHocList.add(phongHoc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources if needed
        }

        return phongHocList;
    }

    public List<GiaoVien> selectAllGiaoVien() {
        List<GiaoVien> giaoVienList = new ArrayList<>();

        try {
            con = ConnectionFactory.getConnection();
            String selectQuery = "SELECT * FROM `giaovien`";
            ps = con.prepareStatement(selectQuery);
            rs = ps.executeQuery();

            while (rs.next()) {
                String maGV = rs.getString("MaGV");
                String tenGV = rs.getString("TenGV");
                Date ngaySinh = rs.getDate("NgaySinh");
                String diaChi = rs.getString("DiaChi");
                String sdt = rs.getString("SDT");
                int soNamCongTac = rs.getInt("SoNamCongTac");
                String maUser = rs.getString("MaUser");

                GiaoVien giaoVien = new GiaoVien(maGV, tenGV, diaChi, sdt, soNamCongTac, maUser, ngaySinh);
                giaoVienList.add(giaoVien);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources if necessary
        }

        return giaoVienList;
    }

    public List<DungCu> selectAllDungCu() {
        List<DungCu> dungCuList = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            String selectQuery = "SELECT * FROM `dungcu`";
            ps = con.prepareStatement(selectQuery);
            rs = ps.executeQuery();

            while (rs.next()) {
                String maDC = rs.getString("MaDC");
                String tenDC = rs.getString("TenDC");
                String maPh = rs.getString("MaPh");
                int soLuong = rs.getInt("SoLuong");

                DungCu dungCu = new DungCu(maDC, tenDC, maPh, soLuong);
                dungCuList.add(dungCu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                // Close resources
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
        return dungCuList;
    }

    public List<HoaDon> selectAllHoaDon() {
        List<HoaDon> hoaDonList = new ArrayList<>();

        try {
            con = ConnectionFactory.getConnection();
            String selectQuery = "SELECT * FROM `hoadon`";
            ps = con.prepareStatement(selectQuery);
            rs = ps.executeQuery();

            while (rs.next()) {
                String MaHD = rs.getString("MaHD");
                Date NgayLap = rs.getDate("NgayLap");
                String MaDC = rs.getString("MaDC");
                int SoLuong = rs.getInt("SoLuong");
                int ThanhTien = rs.getInt("ThanhTien");

                HoaDon hoaDon = new HoaDon(MaHD, MaDC, NgayLap, SoLuong, ThanhTien);
                hoaDonList.add(hoaDon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return hoaDonList;
    }

    public List<Log> selectAllLogs() {
        List<Log> logs = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            String selectQuery = "SELECT * FROM `log`";
            ps = con.prepareStatement(selectQuery);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int logID = rs.getInt("LogID");
                String maUser = rs.getString("MaUser");
                String noidung = rs.getString("Noidung");
                Timestamp thoiGian = rs.getTimestamp("ThoiGian");

                Log log = new Log(logID, maUser, noidung, thoiGian);
                logs.add(log);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return logs;
    }

    public String[] getMaDCList() {
        ArrayList<String> maDCList = new ArrayList<>();

        try {
            con = ConnectionFactory.getConnection();

            String selectQuery = "SELECT `MaDC` FROM `dungcu`";
            ps = con.prepareStatement(selectQuery);
            rs = ps.executeQuery();

            while (rs.next()) {
                maDCList.add(rs.getString("MaDC"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maDCList.toArray(new String[0]);
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

    public String[] selectMaUserFromTaiKhoan() {
        ArrayList<String> maUserList = new ArrayList<String>();

        try {
            con = ConnectionFactory.getConnection();
            String selectQuery = "SELECT MaUser FROM taikhoan";
            ps = con.prepareStatement(selectQuery);
            rs = ps.executeQuery();

            while (rs.next()) {
                String maUser = rs.getString("MaUser");
                maUserList.add(maUser);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources if necessary
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
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return maUserList.toArray(new String[0]);
    }

    public String[] selectAllMaDC() {
        List<String> maDCList = new ArrayList<>();

        try {
            con = ConnectionFactory.getConnection();
            String selectQuery = "SELECT MaDC FROM dungcu";
            ps = con.prepareStatement(selectQuery);
            rs = ps.executeQuery();

            while (rs.next()) {
                String maDC = rs.getString("MaDC");
                maDCList.add(maDC);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String[] maDCArray = new String[maDCList.size()];
        maDCArray = maDCList.toArray(maDCArray);
        return maDCArray;
    }
}
