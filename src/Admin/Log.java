/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Admin;


import java.sql.Timestamp;

public class Log {
    private int logID;
    private String maUser;
    private String noidung;
    private Timestamp thoiGian;

    // Constructor
    public Log(int logID, String maUser, String noidung, Timestamp thoiGian) {
        this.logID = logID;
        this.maUser = maUser;
        this.noidung = noidung;
        this.thoiGian = thoiGian;
    }

    // Getters
    public int getLogID() {
        return logID;
    }

    public String getMaUser() {
        return maUser;
    }

    public String getNoidung() {
        return noidung;
    }

    public Timestamp getThoiGian() {
        return thoiGian;
    }
}

