import java.awt.*;
import java.util.Arrays;

public class Rectangle extends Shape {


    public Rectangle() {
    }


    public Rectangle(Color color, double[] positions) {
        super(color, positions);
    }


    @Override
    public String toString() {
        return "Rectangle{" +
                ", positions=" + Arrays.toString(positions) +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public void paint(Graphics g, float check) {
        if (check <= 0.5)
            g.fillRect((int) positions[0], (int) positions[1], (int) (Math.random() * 300), (int) (Math.random() * 100));
        else
            g.drawRect((int) positions[0], (int) positions[1], (int) (Math.random() * 300), (int) (Math.random() * 100));
        g.setColor(color);
    }
}
