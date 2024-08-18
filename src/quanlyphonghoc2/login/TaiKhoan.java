/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlyphonghoc2.login;

/**
 *
 * @author duywo
 */
public class TaiKhoan {
    private String MaUser, Username, Password, LoaiTK;

    public TaiKhoan() {
    }

    public TaiKhoan(String MaUser, String Username, String Password) {
        this.MaUser = MaUser;
        this.Username = Username;
        this.Password = Password;
    }

    public String getMaUser() {
        return MaUser;
    }

    public void setMaUser(String MaUser) {
        this.MaUser = MaUser;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getLoaiTK() {
        return LoaiTK;
    }

    public void setLoaiTK(String LaoiTK) {
        this.LoaiTK = LaoiTK;
    }
    
}

