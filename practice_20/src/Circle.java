import java.awt.*;
import java.util.Arrays;

public class Circle extends Shape {

    public Circle(Color color, double[] positions) {
        super(color, positions);
    }

    @Override
    public String toString() {
        return "Circle{" +
                ", positions=" + Arrays.toString(positions) +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public void paint(Graphics g, float check) {
        double radius = Math.random() * 200;
        if (check <= 0.5)
            g.fillOval((int) positions[0], (int) positions[1], (int) radius, (int) radius);
        else
            g.drawOval((int) positions[0], (int) positions[1], (int) radius, (int) radius);
        g.setColor(color);
    }
}
