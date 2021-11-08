import java.awt.*;

public abstract  class Shape {

    protected double[] positions;
    protected Color color;

    public Shape() {
    }

    public Shape(Color color, double[] positions) {
        this.color = color;
        this.positions = positions;
    }

    public abstract String toString();

    public abstract void paint(Graphics g, float check);
}


