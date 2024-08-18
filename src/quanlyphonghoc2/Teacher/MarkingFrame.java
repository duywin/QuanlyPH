/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package quanlyphonghoc2.Teacher;

import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import quanlyphonghoc2.*;

/**
 *
 * @author duywo
 */
public class MarkingFrame extends javax.swing.JFrame {

    private String Mauser;
    private ThemeStrategy darkThemeStrategy = new DarkThemeStrategy();
    private ThemeStrategy lightThemeStrategy = new LightThemeStrategy();
    private UserDAO userdao;
    private DiemSo diemso;

    public MarkingFrame(String mauser) {
        this.Mauser = mauser;
        diemso = new DiemSo();
        userdao = new UserDAO();

        initComponents();
        group1.add(Lightbtn);
        group1.add(Darkbtn);
        mahscombo.setModel(new DefaultComboBoxModel<>(userdao.selectMaHSFromHocSinh()));
        loadDataIntoTable();
    }

    private void changeTheme() {
        if (Darkbtn.isSelected()) {
            // Apply dark theme
            darkThemeStrategy.applyTheme(this);
        } else if (Lightbtn.isSelected()) {
            // Apply light theme
            lightThemeStrategy.applyTheme(this);
        }
    }

private void loadDataIntoTable() {
    DefaultTableModel model = (DefaultTableModel) table.getModel();
    model.setRowCount(0); // Clear table

    // Assuming you have a method to get all DiemSo records similar to 'selectAllHS' but for DiemSo
    List<DiemSo> diemSoList = diemso.selectAll(); // Adjust this call to wherever your selectAll method for DiemSo resides
    for (DiemSo diemSo : diemSoList) {
        Object[] rowData = {
            diemSo.getMaHS(),
            diemSo.getTenMon(),
            diemSo.getDiem(),
            diemSo.getHeSo(),
            diemSo.getThoiGian() // Assuming this returns a displayable String or Date
        };
        model.addRow(rowData);
    }
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        group1 = new javax.swing.ButtonGroup();
        teacherMenu1 = new quanlyphonghoc2.Teacher.TeacherMenu();
        Darkbtn = new javax.swing.JRadioButton();
        Lightbtn = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        Addbtn = new javax.swing.JButton();
        updatebtn = new javax.swing.JButton();
        mahscombo = new javax.swing.JComboBox<>();
        tenmoncombo = new javax.swing.JComboBox<>();
        diemtxt = new javax.swing.JTextField();
        hesocombo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Darkbtn.setText("Dark Theme");
        Darkbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DarkbtnActionPerformed(evt);
            }
        });

        Lightbtn.setSelected(true);
        Lightbtn.setText("Light Theme");
        Lightbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LightbtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Nhập điểm học sinh");

        jLabel2.setText("Hệ số");

        jLabel3.setText("Mã học sinh");

        jLabel4.setText("Tên Môn");

        jLabel5.setText("Điểm");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jScrollPane1.setViewportView(table);

        Addbtn.setText("Thêm");
        Addbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddbtnActionPerformed(evt);
            }
        });

        updatebtn.setText("Sửa");
        updatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebtnActionPerformed(evt);
            }
        });

        mahscombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        tenmoncombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Toán ", "Văn", "Anh", "Sử", "Địa", "GDCD" }));

        hesocombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(teacherMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Lightbtn)
                            .addComponent(Darkbtn))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(mahscombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(diemtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(63, 63, 63)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tenmoncombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(hesocombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Addbtn)
                                .addGap(104, 104, 104)
                                .addComponent(updatebtn)))
                        .addContainerGap(160, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(teacherMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Darkbtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Lightbtn)
                        .addGap(21, 21, 21))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel1)
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(mahscombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tenmoncombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(diemtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hesocombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Addbtn)
                            .addComponent(updatebtn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DarkbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DarkbtnActionPerformed
        changeTheme();
    }//GEN-LAST:event_DarkbtnActionPerformed

    private void LightbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LightbtnActionPerformed
        changeTheme();
    }//GEN-LAST:event_LightbtnActionPerformed

    private void AddbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddbtnActionPerformed
    String maHS = (String) mahscombo.getSelectedItem();
    String tenMon = (String) tenmoncombo.getSelectedItem();
    int diem = Integer.parseInt(diemtxt.getText());
    int heSo = Integer.parseInt((String) hesocombo.getSelectedItem());
    Date thoiGian = new Date(System.currentTimeMillis()); // Current date

    DiemSo diemSo = new DiemSo(maHS, tenMon, diem, heSo, thoiGian);

    // Attempt to update the record
    boolean success = diemSo.update("insert", Mauser);
    loadDataIntoTable();
    }//GEN-LAST:event_AddbtnActionPerformed

    private void updatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebtnActionPerformed
    String maHS = (String) mahscombo.getSelectedItem();
    String tenMon = (String) tenmoncombo.getSelectedItem();
    int diem = Integer.parseInt(diemtxt.getText());
    int heSo = Integer.parseInt((String) hesocombo.getSelectedItem());
    Date thoiGian = new Date(System.currentTimeMillis()); // Current date

    DiemSo diemSo = new DiemSo(maHS, tenMon, diem, heSo, thoiGian);

    // Attempt to update the record
    boolean success = diemSo.update("update", Mauser);
    loadDataIntoTable();
    }//GEN-LAST:event_updatebtnActionPerformed

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
            java.util.logging.Logger.getLogger(MarkingFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MarkingFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MarkingFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MarkingFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MarkingFrame("test").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Addbtn;
    private javax.swing.JRadioButton Darkbtn;
    private javax.swing.JRadioButton Lightbtn;
    private javax.swing.JTextField diemtxt;
    private javax.swing.ButtonGroup group1;
    private javax.swing.JComboBox<String> hesocombo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> mahscombo;
    private javax.swing.JTable table;
    private quanlyphonghoc2.Teacher.TeacherMenu teacherMenu1;
    private javax.swing.JComboBox<String> tenmoncombo;
    private javax.swing.JButton updatebtn;
    // End of variables declaration//GEN-END:variables
}
