package quanlyphonghoc2;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import com.toedter.calendar.JDateChooser; // Ensure you have this library included in your project


public class DarkThemeStrategy implements ThemeStrategy {

    @Override
    public void applyTheme(JFrame frame) {
        frame.getContentPane().setBackground(Color.BLACK);

        // Loop through each component and apply theme
        applyThemeRecursive(frame.getContentPane(), Color.WHITE, Color.BLACK, Color.DARK_GRAY);
    }

    private void applyThemeRecursive(Container container, Color foreground, Color background, Color secondary) {
        for (Component c : container.getComponents()) {
            if (c instanceof JLabel || c instanceof JTableHeader) {
                c.setForeground(foreground);
            } else if (c instanceof JButton || c instanceof JTextField || c instanceof JComboBox || c instanceof JDateChooser) {
                c.setForeground(foreground);
                c.setBackground(secondary);
            } else if (c instanceof JTable) {
                JTable table = (JTable) c;
                table.setForeground(foreground);
                table.setBackground(secondary);
                table.getTableHeader().setForeground(foreground);
                table.getTableHeader().setBackground(secondary);
            } else if (c instanceof JScrollPane) {
                applyThemeRecursive((Container) c, foreground, background, secondary);
            }
            // Add more components or specific conditions as necessary
        }
    }
}

