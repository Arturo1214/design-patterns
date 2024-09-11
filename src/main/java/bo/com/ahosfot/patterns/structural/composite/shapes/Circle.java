package bo.com.ahosfot.patterns.structural.composite.shapes;

import java.awt.*;

public class Circle extends BaseShape {
    public int radius;

    public Circle(int x, int y, int radius, Color color) {
        super(x, y, color);
        this.radius = radius;
    }

    @Override
    public int getWidth() {
        return this.radius * 2;
    }

    @Override
    public int getHeight() {
        return this.radius * 2;
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        graphics.drawOval(this.x, this.y, getWidth() - 1, getHeight() - 1);
    }
}
