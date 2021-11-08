

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Animation extends JFrame {
    Animation() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(100, 300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Animation();
    }

    @Override
    public void paint(Graphics g) {
        int i = 0;
        while (true) {
            BufferedImage img = null;
            try {
                if (i < 7) {
                    img = ImageIO.read(new File("D:\\third_semestr\\Java\\Git\\Java-2nd-course\\practice_20\\Images\\frame_" + i + ".png"));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            g.drawImage(img, 0, 0, new ImageObserver() {
                @Override
                public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                    return false;
                }
            });
            i++;
            if (i == 6)
                i = 3;
            try {
                TimeUnit.MILLISECONDS.sleep(80);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
