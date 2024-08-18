/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package quanlyphonghoc2.Teacher;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import quanlyphonghoc2.MenuInterface;
import quanlyphonghoc2.login.LoginFrame;

public class TeacherMenu extends JPanel implements MenuInterface {

    private String username;
    private int selectedIndex = -1;
    private Color selectedColor = new Color(173, 196, 232);
    private Color defaultColor = new Color(240, 240, 240);

    public TeacherMenu() {
        setLayout(new GridLayout(0, 1));
        setBackground(Color.WHITE);
        initMenu();
    }


    @Override
    public void initMenu() {
        addButton("Trang Chủ", 0);
        addButton("Quản lý thực hành", 1);
        addButton("Xếp Lớp", 2);
        addButton("Quản lý học sinh", 3);
        addButton("Nhập điểm học sinh", 4);
        addButton("Đăng xuất", 5);
    }

    @Override
    public void addButton(String text, int index) {
        JButton button = new JButton(text);
        button.setBackground(defaultColor);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Adjust padding as needed
        button.setHorizontalAlignment(SwingConstants.LEFT);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setSelectedIndex(index);
                switch (index) {
                    case 0:
                        new MainFrame(username).setVisible(true);
                        break;
                    case 1:
                        new PracticeFrame(username).setVisible(true);
                        break;
                    case 2:
                        new ClassFrame(username).setVisible(true);
                        break;
                    case 3:
                        new StuManeFrame(username).setVisible(true);
                        break;
                    case 4:
                        new MarkingFrame(username).setVisible(true);
                        break;
                    case 5:
                        new LoginFrame().setVisible(true);
                        break;
                    default:
                        break;
                }
            }
        });

        add(button);
    }

    @Override
    public void setSelectedIndex(int index) {
        // Reset the background of the previously selected button
        if (selectedIndex >= 0 && selectedIndex < getComponentCount()) {
            getComponent(selectedIndex).setBackground(defaultColor);
        }

        // Update the selected index and background
        selectedIndex = index;
        if (selectedIndex >= 0 && selectedIndex < getComponentCount()) {
            getComponent(selectedIndex).setBackground(selectedColor);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Admin Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 400);
        frame.setLocationRelativeTo(null);

        TeacherMenu menu = new TeacherMenu();
        frame.add(menu);

        frame.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
