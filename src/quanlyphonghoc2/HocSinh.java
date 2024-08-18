/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlyphonghoc2;

import java.util.Date;

/**
 *
 * @author duywo
 */
public class HocSinh {
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
    
}
