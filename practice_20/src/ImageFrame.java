import javax.swing.*;
import java.awt.*;

public class ImageFrame extends JFrame {

    ImageFrame(){
        super("Image");
        JFrame.setDefaultLookAndFeelDecorated(true);
    }
    public void start(String args){
        ImageImplement panel = new ImageImplement(new ImageIcon(args).getImage());
        add(panel);
        setVisible(true);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //D:\System_programs\JDK\bin\java ImageFrame.java для запуска с аргументом ибо ебать нахуй не видит он java
    //D:\System_programs\JDK\bin\java ImageFrame.java D:\third_semestr\Java\Git\Java-2nd-course\practice_20\scale_1200.jfif

    public static void main(String[] args) {
        new ImageFrame().start(args[0]);
    }
}
class ImageImplement extends JPanel{
    private Image img;
    ImageImplement(Image img){
        this.img = img;
        Dimension size = new Dimension(img.getWidth(null),img.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
    }
    public void paintComponent(Graphics g){
        g.drawImage(img,0,0,null);
    }
}
