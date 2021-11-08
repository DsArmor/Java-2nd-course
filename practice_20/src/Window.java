import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    private Shape[] shapes;

    public Window() {
        super("MyDraw");
        createShapes();
        JFrame.setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setSize(1920,1080);
        setVisible(true);
    }

    private void createShapes() {
        shapes = new Shape[20];
        for (int i = 0; i < 20; i++) {
            if (Math.random() <= 0.5) {
                double[] pos= new double[]{Math.random() * 1400, Math.random() * 1080};
                shapes[i] = new Rectangle(new Color((float) Math.random(), (float) Math.random(), (float) Math.random()), pos);
            } else {
                double[] pos = new double[]{Math.random() * 1400, Math.random() * 1080};
                shapes[i] = new Circle(new Color((float) Math.random(), (float) Math.random(), (float) Math.random()), pos);
            }
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        for (int i = 0; i < shapes.length; i++) {
            shapes[i].paint(g, (float) Math.random());
        }
    }

    public static void main(String[] args) {
        new Window();
    }

}