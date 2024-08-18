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
public class DiemSo {
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
    
    
}
