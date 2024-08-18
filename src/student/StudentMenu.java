/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package student;

import quanlyphonghoc2.Teacher.*;
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


public class StudentMenu extends JPanel implements MenuInterface {
    private int selectedIndex = -1;
    private Color selectedColor = new Color(173, 196, 232);
    private Color defaultColor = new Color(240, 240, 240);
    private String username;

    public StudentMenu() {
        setLayout(new GridLayout(0, 1)); 
        setBackground(Color.WHITE);
        initMenu();
    }

    @Override
    public void initMenu() {
        addButton("Trang Chủ", 0);
        addButton("Xem điểm", 1);
        addButton("Xem thời khóa biểu", 2);
        addButton("Đăng xuất",3);
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
                        new MainMenuFrame(username).setVisible(true);
                        break;
                    case 1:
                        new StdScoreFrame(username).setVisible(true);
                        break;
                    case 2:
                        new ScheduleFrame(username).setVisible(true);
                        break;
                    case 3:
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
        JFrame frame = new JFrame("Student Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 400);
        frame.setLocationRelativeTo(null);

        StudentMenu menu = new StudentMenu();
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
