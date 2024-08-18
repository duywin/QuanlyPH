/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package student;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import quanlyphonghoc2.DarkThemeStrategy;
import quanlyphonghoc2.LightThemeStrategy;
import quanlyphonghoc2.HocSinh;
import quanlyphonghoc2.Teacher.LichThucHanh;
import quanlyphonghoc2.Teacher.UserDAO;
import quanlyphonghoc2.ThemeStrategy;

/**
 *
 * @author ACER
 */
public class ScheduleFrame extends javax.swing.JFrame {

    private String maus, malop;
    private StudentDAO studao;
    private ThemeStrategy darkThemeStrategy = new DarkThemeStrategy();
    private ThemeStrategy lightThemeStrategy = new LightThemeStrategy();
    public ScheduleFrame(String maus) {
        this.maus = maus;
        studao = new StudentDAO();
        quanlyphonghoc2.HocSinh hocsinh = studao.getHocSinhByMaUS(maus);
        malop = hocsinh.getMaLop();
        initComponents();
        group1.add(Darkbtn);
        group1.add(Lightbtn);
        loadDataIntoTableLichThucHanh(malop);
    }

private void loadDataIntoTableLichThucHanh(String maLop) {
    DefaultTableModel model = (DefaultTableModel) table.getModel();
    model.setRowCount(0); // Clear table

    List<LichThucHanh> lichThucHanhList = studao.getLichThucHanhByMaLop(maLop);
    for (LichThucHanh lichThucHanh : lichThucHanhList) {
        Object[] rowData = {lichThucHanh.getMaPh(), lichThucHanh.getThoiGian(), lichThucHanh.getMaLop(), lichThucHanh.getNgay()};
        model.addRow(rowData);
    }
}
    private void changeTheme() {
        if (Darkbtn.isSelected()) {
            darkThemeStrategy.applyTheme(this);
        } else if (Lightbtn.isSelected()) {
            // Apply light theme
            lightThemeStrategy.applyTheme(this);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        group1 = new javax.swing.ButtonGroup();
        titleLabel = new javax.swing.JLabel();
        Lightbtn = new javax.swing.JRadioButton();
        Darkbtn = new javax.swing.JRadioButton();
        studentMenu1 = new student.StudentMenu();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titleLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        titleLabel.setText("Xem Thời Khóa Biểu");

        Lightbtn.setSelected(true);
        Lightbtn.setText("Light Theme");

        Darkbtn.setText("Dark Theme");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Lightbtn)
                            .addComponent(Darkbtn))
                        .addGap(145, 145, 145)
                        .addComponent(titleLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(studentMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(studentMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Darkbtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Lightbtn))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ScheduleFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ScheduleFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ScheduleFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ScheduleFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ScheduleFrame("us2").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Darkbtn;
    private javax.swing.JRadioButton Lightbtn;
    private javax.swing.ButtonGroup group1;
    private javax.swing.JScrollPane jScrollPane2;
    private student.StudentMenu studentMenu1;
    private javax.swing.JTable table;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
