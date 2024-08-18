/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package quanlyphonghoc2.Teacher;

import java.util.List;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import quanlyphonghoc2.DarkThemeStrategy;
import quanlyphonghoc2.LightThemeStrategy;
import quanlyphonghoc2.ThemeStrategy;

/**
 *
 * @author ACER
 */
public class ClassFrame extends javax.swing.JFrame {

    private ThemeStrategy darkThemeStrategy = new DarkThemeStrategy();
    private ThemeStrategy lightThemeStrategy = new LightThemeStrategy();
    private String username;
    private UserDAO userdao;

    public ClassFrame(String username) {
        userdao = new UserDAO();
        setTitle("Class Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        group1.add(Darkbtn);
        group1.add(Lightbtn);
        loadDataIntoTable();

    }

    public void loadDataIntoTable() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Clear existing rows

        List<LopHoc> lopHocList = userdao.selectAllLopHoc();

        for (LopHoc lopHoc : lopHocList) {
            Object[] rowData = {lopHoc.getMaLop(), lopHoc.getTenLop(), lopHoc.getNienKhoa(), lopHoc.getSiso()};
            model.addRow(rowData);
        }
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        group1 = new javax.swing.ButtonGroup();
        maLopLabel = new javax.swing.JLabel();
        tenLopLabel = new javax.swing.JLabel();
        nienKhoaLabel = new javax.swing.JLabel();
        sisoLabel = new javax.swing.JLabel();
        maLopInput = new javax.swing.JTextField();
        tenLopInput = new javax.swing.JTextField();
        sisoInput = new javax.swing.JTextField();
        nienKhoaComboBox = new javax.swing.JComboBox<>();
        addButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        teacherMenu1 = new quanlyphonghoc2.Teacher.TeacherMenu();
        Darkbtn = new javax.swing.JRadioButton();
        Lightbtn = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        maLopLabel.setText("Mã Lớp");

        tenLopLabel.setText("Tên Lớp");

        nienKhoaLabel.setText("Niên Khóa");

        sisoLabel.setText("Sỉ Số");

        nienKhoaComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2020-2023", "2021-2024", "2022-2025" }));

        addButton.setText("Thêm");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        editButton.setText("Sửa");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Xóa");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

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
        jLabel1.setText("Xếp lớp");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(teacherMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Lightbtn)
                            .addComponent(Darkbtn))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(editButton)
                        .addGap(57, 57, 57)
                        .addComponent(deleteButton)
                        .addGap(58, 58, 58))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(maLopLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(maLopInput, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(nienKhoaLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(addButton)
                                            .addComponent(nienKhoaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(tenLopLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(tenLopInput, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(sisoLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(sisoInput, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(25, 25, 25))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maLopInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tenLopInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(maLopLabel)
                    .addComponent(tenLopLabel))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nienKhoaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sisoInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nienKhoaLabel)
                    .addComponent(sisoLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteButton)
                    .addComponent(editButton)
                    .addComponent(addButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(teacherMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Darkbtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Lightbtn)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        String maLop = maLopInput.getText();
        String tenLop = tenLopInput.getText();
        int siso = Integer.parseInt(sisoInput.getText());
        String nienKhoa = nienKhoaComboBox.getSelectedItem().toString();

        LopHoc lopHoc = new LopHoc(maLop, tenLop, siso, nienKhoa);
        boolean success = userdao.performLopHocAction("insert", lopHoc, username);
        loadDataIntoTable();
    }//GEN-LAST:event_addButtonActionPerformed

    private void DarkbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DarkbtnActionPerformed
        changeTheme();
    }//GEN-LAST:event_DarkbtnActionPerformed

    private void LightbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LightbtnActionPerformed
        changeTheme();
    }//GEN-LAST:event_LightbtnActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        String maLop = maLopInput.getText();
        String tenLop = tenLopInput.getText();
        int siso = Integer.parseInt(sisoInput.getText());
        String nienKhoa = nienKhoaComboBox.getSelectedItem().toString();

        LopHoc lopHoc = new LopHoc(maLop, tenLop, siso, nienKhoa);
        boolean success = userdao.performLopHocAction("update", lopHoc, username);
        loadDataIntoTable();
    }//GEN-LAST:event_editButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        String maLop = maLopInput.getText();
        LopHoc lopHoc = new LopHoc(maLop, null, 0, null);
        boolean success = userdao.performLopHocAction("delete", lopHoc, username); //
        loadDataIntoTable();
    }//GEN-LAST:event_deleteButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ClassFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClassFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClassFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClassFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClassFrame("test").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Darkbtn;
    private javax.swing.JRadioButton Lightbtn;
    private javax.swing.JButton addButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.ButtonGroup group1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField maLopInput;
    private javax.swing.JLabel maLopLabel;
    private javax.swing.JComboBox<String> nienKhoaComboBox;
    private javax.swing.JLabel nienKhoaLabel;
    private javax.swing.JTextField sisoInput;
    private javax.swing.JLabel sisoLabel;
    private javax.swing.JTable table;
    private quanlyphonghoc2.Teacher.TeacherMenu teacherMenu1;
    private javax.swing.JTextField tenLopInput;
    private javax.swing.JLabel tenLopLabel;
    // End of variables declaration//GEN-END:variables
}
