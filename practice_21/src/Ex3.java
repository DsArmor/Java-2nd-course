

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ex3 extends JFrame {
    JTextArea jta1 = new JTextArea(10, 30);
    JScrollPane jScrollPane = new JScrollPane(jta1);
    Font timesNewRoman = new Font("Times New Roman", Font.PLAIN, 14);
    Font courierNew = new Font("Courier New", Font.PLAIN, 14);
    Font MSSansSerif = new Font("MS Sans Serif", Font.PLAIN, 14);
    JMenu changeFont = new JMenu("Смени шрифт");
    JMenu changeColor = new JMenu("Смени цвет");

    JMenuItem fontTimesNewRoman = new JMenuItem("Times New Roman");
    JMenuItem fontCourierNew = new JMenuItem("Courier New");
    JMenuItem fontMSSansSerif = new JMenuItem("MS Sans Serif");

    JMenuItem colorBlue = new JMenuItem("Синий");
    JMenuItem colorRed = new JMenuItem("Красный");
    JMenuItem colorBlack = new JMenuItem("Черный");

    MenuActionListener menuActionListener = new MenuActionListener();

    JMenuBar jMenuBar = new JMenuBar();

    Ex3() {
        super("Color and Font");
        setLayout(new FlowLayout());
        setSize(500, 500);

        colorBlack.addActionListener(menuActionListener);
        colorBlue.addActionListener(menuActionListener);
        colorRed.addActionListener(menuActionListener);
        fontCourierNew.addActionListener(menuActionListener);
        fontTimesNewRoman.addActionListener(menuActionListener);
        fontMSSansSerif.addActionListener(menuActionListener);

        changeColor.add(colorBlue);
        changeColor.add(colorBlack);
        changeColor.add(colorRed);

        changeFont.add(fontTimesNewRoman);
        changeFont.add(fontMSSansSerif);
        changeFont.add(fontCourierNew);

        jMenuBar.add(changeColor);
        jMenuBar.add(changeFont);

        setJMenuBar(jMenuBar);

        jta1.setText("This field can change color and font");
        add(jScrollPane);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Ex3();
    }

    class MenuActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();
            if (colorBlack.equals(source)) {
                jta1.setForeground(Color.BLACK);
            } else if (colorBlue.equals(source)) {
                jta1.setForeground(Color.BLUE);
            } else if (colorRed.equals(source)) {
                jta1.setForeground(Color.RED);
            } else if (fontCourierNew.equals(source)) {
                jta1.setFont(courierNew);
            } else if (fontMSSansSerif.equals(source)) {
                jta1.setFont(MSSansSerif);
            } else if (fontTimesNewRoman.equals(source)) {
                jta1.setFont(timesNewRoman);
            } else {
                throw new IllegalStateException("Unexpected value: " + e.getSource());
            }
        }
    }

}
