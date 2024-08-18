package quanlyphonghoc2.Teacher;

import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import quanlyphonghoc2.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PracticeFrame extends javax.swing.JFrame {

    private String Mauser;
    private ThemeStrategy darkThemeStrategy = new DarkThemeStrategy();
    private ThemeStrategy lightThemeStrategy = new LightThemeStrategy();

    public PracticeFrame(String mauser) {
        this.Mauser = mauser;
        setTitle("Practice Management");
        table = new JTable(new DefaultTableModel(new Object[]{"MaPh", "ThoiGian", "MaLop", "Ngay"}, 0));
        initComponents();

        UserDAO userDAO = new UserDAO();
        maPhComboBox.setModel(new DefaultComboBoxModel<>(userDAO.getMaPhList()));
        maLopComboBox.setModel(new DefaultComboBoxModel<>(userDAO.getMaLopList()));
        group1.add(Darkbtn);
        group1.add(Lightbtn);
        populateTable();
        setVisible(true);
    }

    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        UserDAO userDAO = new UserDAO();
        List<LichThucHanh> list = userDAO.selectAllLichTH();

        for (LichThucHanh lich : list) {
            model.addRow(new Object[]{lich.getMaPh(), lich.getThoiGian(), lich.getMaLop(), lich.getNgay()});
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

        jDatePickerUtil1 = new org.jdatepicker.util.JDatePickerUtil();
        group1 = new javax.swing.ButtonGroup();
        maPhLabel = new javax.swing.JLabel();
        thoiGianLabel = new javax.swing.JLabel();
        maLopLabel = new javax.swing.JLabel();
        ngayLabel = new javax.swing.JLabel();
        maPhComboBox = new javax.swing.JComboBox<>();
        thoiGianComboBox = new javax.swing.JComboBox<>();
        maLopComboBox = new javax.swing.JComboBox<>();
        addButton = new javax.swing.JButton();
        ngayChooser = new com.toedter.calendar.JDateChooser();
        scrollPane = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        teacherMenu1 = new quanlyphonghoc2.Teacher.TeacherMenu();
        Darkbtn = new javax.swing.JRadioButton();
        Lightbtn = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        maPhLabel.setText("Mã Phòng Học");

        thoiGianLabel.setText("Thời Gian");

        maLopLabel.setText("Mã Lớp");

        ngayLabel.setText("Ngày");
        ngayLabel.setToolTipText("");

        maPhComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        thoiGianComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tiet 1-3", "Tiet 4-6 ", "Tiet 7-9", "Tiet 10-12" }));

        maLopComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        addButton.setText("Đăng ký lịch");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
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
        scrollPane.setViewportView(table);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Quản lý thực hành");

        Darkbtn.setText("Dark Theme");
        Darkbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DarkbtnActionPerformed(evt);
            }
        });

        Lightbtn.setText("Light Theme");
        Lightbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LightbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(teacherMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Lightbtn)
                            .addComponent(Darkbtn))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(thoiGianLabel)
                                    .addComponent(maPhLabel)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(ngayLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(maLopLabel)))
                                .addGap(44, 44, 44)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(ngayChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(maLopComboBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(thoiGianComboBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(maPhComboBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(scrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(145, 145, 145)
                            .addComponent(jLabel1))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1)
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(maPhComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(maPhLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(thoiGianLabel)
                            .addComponent(thoiGianComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(maLopLabel)
                            .addComponent(maLopComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ngayLabel)
                            .addComponent(ngayChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(addButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(teacherMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Darkbtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Lightbtn)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        maPhLabel.getAccessibleContext().setAccessibleName("maPhLabel");
        thoiGianLabel.getAccessibleContext().setAccessibleName("thoiGianLabel");
        thoiGianLabel.getAccessibleContext().setAccessibleDescription("");
        maLopLabel.getAccessibleContext().setAccessibleName("maLopLabel");
        ngayLabel.getAccessibleContext().setAccessibleName("ngayLabel");
        maPhComboBox.getAccessibleContext().setAccessibleName("maPhComboBox");
        addButton.getAccessibleContext().setAccessibleName("addButton");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        String maPh = (String) maPhComboBox.getSelectedItem();
        String thoiGian = (String) thoiGianComboBox.getSelectedItem();
        String maLop = (String) maLopComboBox.getSelectedItem();
        Date ngay = new Date(ngayChooser.getDate().getTime()); // Replace this with your Date input logic

        // Create a new LichThucHanh instance
        LichThucHanh lichThucHanh = new LichThucHanh(maPh, thoiGian, maLop, ngay);

        // Insert the LichThucHanh instance using UserDAO
        UserDAO userDAO = new UserDAO();
        int success = userDAO.DangKyTH(lichThucHanh, Mauser);

        if (success == 1) {
            JOptionPane.showMessageDialog(null, "Added successfully");
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.addRow(new Object[]{maPh, thoiGian, maLop, ngay});
        } else {
            JOptionPane.showMessageDialog(null, "An error occurred");
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void DarkbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DarkbtnActionPerformed
        changeTheme();
    }//GEN-LAST:event_DarkbtnActionPerformed

    private void LightbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LightbtnActionPerformed
        changeTheme();
    }//GEN-LAST:event_LightbtnActionPerformed

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
            java.util.logging.Logger.getLogger(PracticeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PracticeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PracticeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PracticeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PracticeFrame("test").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Darkbtn;
    private javax.swing.JRadioButton Lightbtn;
    private javax.swing.JButton addButton;
    private javax.swing.ButtonGroup group1;
    private org.jdatepicker.util.JDatePickerUtil jDatePickerUtil1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox<String> maLopComboBox;
    private javax.swing.JLabel maLopLabel;
    private javax.swing.JComboBox<String> maPhComboBox;
    private javax.swing.JLabel maPhLabel;
    private com.toedter.calendar.JDateChooser ngayChooser;
    private javax.swing.JLabel ngayLabel;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable table;
    private quanlyphonghoc2.Teacher.TeacherMenu teacherMenu1;
    private javax.swing.JComboBox<String> thoiGianComboBox;
    private javax.swing.JLabel thoiGianLabel;
    // End of variables declaration//GEN-END:variables
}
