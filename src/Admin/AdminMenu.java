package Admin;

import quanlyphonghoc2.MenuInterface;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import quanlyphonghoc2.login.LoginFrame;

public class AdminMenu extends JPanel implements MenuInterface {

    private String username;
    private int selectedIndex = -1;
    private Color selectedColor = new Color(173, 196, 232);
    private Color defaultColor = new Color(240, 240, 240);

    public AdminMenu() {
        setLayout(new GridLayout(0, 1));
        setBackground(Color.WHITE);
        initMenu();
    }


    @Override
    public void initMenu() {
        addButton("Trang Chủ", 0);
        addButton("Quản lý giáo viên", 1);
        addButton("Quản lý phòng học", 2);
        addButton("Quản lý dụng cụ", 3);
        addButton("Quản lý hóa đơn", 4);
        addButton("Đăng xuất", 5);
    }

    @Override
    public void addButton(String text, int index) {
        JButton button = new JButton(text);
        button.setBackground(defaultColor);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        button.setHorizontalAlignment(SwingConstants.LEFT);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setSelectedIndex(index);
                switch (index) {
                    case 0:
                        new LogFrame(username).setVisible(true);
                        break;
                    case 1:
                        new ManeTechFrame(username).setVisible(true);
                        break;
                    case 2:
                        new ClassroomFrame(username).setVisible(true);
                        break;
                    case 3:
                        new EquipmentFrame(username).setVisible(true);
                        break;
                    case 4:
                        new RecieptFrame(username).setVisible(true);
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

        AdminMenu menu = new AdminMenu();
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
