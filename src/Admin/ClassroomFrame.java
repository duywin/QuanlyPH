/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import quanlyphonghoc2.login.LoginFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import quanlyphonghoc2.*;

public class ClassroomFrame extends javax.swing.JFrame {

    private ThemeStrategy darkThemeStrategy = new DarkThemeStrategy();
    private ThemeStrategy lightThemeStrategy = new LightThemeStrategy();
    private String username;
    private AdminDAO adminDAO;

    public ClassroomFrame(String username) {
        this.username = username;
        adminDAO = new AdminDAO();
        table = new JTable(new DefaultTableModel(new Object[]{"MaPh", "TenPh", "Succhua"}, 0));
        initComponents();
        group1.add(DarkBtn);
        group1.add(LightBtn);
        loadDataIntoTable();

    }

    private void loadDataIntoTable() {
        List<PhongHoc> phongHocList = adminDAO.selectAllPhongHoc();
        populateTable(phongHocList);
    }

    private void populateTable(List<PhongHoc> phongHocList) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        for (PhongHoc phongHoc : phongHocList) {
            Object[] row = {phongHoc.getMaPhong(), phongHoc.getTenPhong(), phongHoc.getSucchua()};
            model.addRow(row);
        }
    }

    private void changeTheme() {
        if (DarkBtn.isSelected()) {
            // Apply dark theme
            darkThemeStrategy.applyTheme(this);
        } else if (LightBtn.isSelected()) {
            // Apply light theme
            lightThemeStrategy.applyTheme(this);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        group1 = new javax.swing.ButtonGroup();
        adminMenu1 = new Admin.AdminMenu();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        maphongtext = new javax.swing.JTextField();
        suachuatext = new javax.swing.JTextField();
        tenphong = new javax.swing.JTextField();
        Addbtn = new javax.swing.JButton();
        DeleteBtn = new javax.swing.JButton();
        UpdateBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        DarkBtn = new javax.swing.JRadioButton();
        LightBtn = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Quản lý phòng học");

        jLabel2.setText("Mã phòng học");

        jLabel3.setText("Tên phòng");

        jLabel4.setText("Sức chứa");

        Addbtn.setText("Thêm");
        Addbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddbtnActionPerformed(evt);
            }
        });

        DeleteBtn.setText("Xóa");
        DeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteBtnActionPerformed(evt);
            }
        });

        UpdateBtn.setText("Sửa");
        UpdateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateBtnActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã phòng", "Tên phòng", "Sứa chứa"
            }
        ));
        jScrollPane1.setViewportView(table);

        DarkBtn.setText("Dark Theme");
        DarkBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DarkBtnActionPerformed(evt);
            }
        });

        LightBtn.setSelected(true);
        LightBtn.setText("Light Theme");
        LightBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LightBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(adminMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DarkBtn)
                            .addComponent(LightBtn))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(Addbtn)
                        .addGap(52, 52, 52)
                        .addComponent(DeleteBtn)
                        .addGap(48, 48, 48)
                        .addComponent(UpdateBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(suachuatext, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                            .addComponent(maphongtext)
                            .addComponent(tenphong)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(jLabel1)))
                .addContainerGap(118, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(maphongtext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tenphong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(suachuatext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Addbtn)
                    .addComponent(DeleteBtn)
                    .addComponent(UpdateBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(adminMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DarkBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LightBtn)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LightBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LightBtnActionPerformed
        changeTheme();
    }//GEN-LAST:event_LightBtnActionPerformed

    private void DarkBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DarkBtnActionPerformed
        changeTheme();
    }//GEN-LAST:event_DarkBtnActionPerformed

    private void AddbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddbtnActionPerformed
        PhongHoc phonghoc = new PhongHoc (maphongtext.getText(),tenphong.getText(),
        Integer.parseInt(suachuatext.getText()));
        adminDAO.modifyPhongHoc("insert", phonghoc, username);
        loadDataIntoTable();
    }//GEN-LAST:event_AddbtnActionPerformed

    private void DeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBtnActionPerformed
        PhongHoc phonghoc = new PhongHoc (maphongtext.getText());
        adminDAO.modifyPhongHoc("delete", phonghoc, username);
        loadDataIntoTable();
    }//GEN-LAST:event_DeleteBtnActionPerformed

    private void UpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateBtnActionPerformed
        PhongHoc phonghoc = new PhongHoc (maphongtext.getText(),tenphong.getText(),
        Integer.parseInt(suachuatext.getText()));
        adminDAO.modifyPhongHoc("update", phonghoc, username);
        loadDataIntoTable();
    }//GEN-LAST:event_UpdateBtnActionPerformed

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
            java.util.logging.Logger.getLogger(ClassroomFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClassroomFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClassroomFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClassroomFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClassroomFrame("test").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Addbtn;
    private javax.swing.JRadioButton DarkBtn;
    private javax.swing.JButton DeleteBtn;
    private javax.swing.JRadioButton LightBtn;
    private javax.swing.JButton UpdateBtn;
    private Admin.AdminMenu adminMenu1;
    private javax.swing.ButtonGroup group1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField maphongtext;
    private javax.swing.JTextField suachuatext;
    private javax.swing.JTable table;
    private javax.swing.JTextField tenphong;
    // End of variables declaration//GEN-END:variables
}
