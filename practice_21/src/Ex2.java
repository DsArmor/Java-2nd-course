

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Ex2 extends JFrame {

    JButton northLabel = new JButton("North");
    JButton southLabel = new JButton("South");
    JButton westLabel = new JButton("West");
    JButton eastLabel = new JButton("East");
    JButton centerLabel = new JButton("Center");

    Ex2() {
        MouseListener mouseListener = new MouseL();
        setLayout(new BorderLayout());
        setSize(500, 500);
        northLabel.addMouseListener(mouseListener);
        southLabel.addMouseListener(mouseListener);
        centerLabel.addMouseListener(mouseListener);
        eastLabel.addMouseListener(mouseListener);
        westLabel.addMouseListener(mouseListener);
        add(northLabel, BorderLayout.NORTH);
        add(southLabel, BorderLayout.SOUTH);
        add(eastLabel, BorderLayout.EAST);
        add(westLabel, BorderLayout.WEST);
        add(centerLabel, BorderLayout.CENTER);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Ex2();
    }

    class MouseL implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            JButton jButton = (JButton) e.getComponent();
            String place = jButton.getText();
            String navigation = switch (place) {
                case "East" -> "Дахране";
                case "North" -> "Абу-Даби";
                case "South" -> "Абха";
                case "West" -> "Джидда";
                default -> "";
            };
            JOptionPane.showMessageDialog(null, "Welcome to " + navigation, "Welcome to new place", JOptionPane.INFORMATION_MESSAGE);
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }
}
