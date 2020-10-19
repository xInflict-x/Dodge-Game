import javax.swing.*;
import java.awt.*;

public class Arc extends Shape {

    private int startAngle;
    private int arcAngle;

    public Arc(JFrame window, int x, int y, int width, int height, int startAngle, int arcAngle, Color color) {
        this.setX(x);
        this.setY(y);

        this.setWidth(width);
        this.setHeight(height);

        this.setStartAngle(startAngle);
        this.setArcAngle(arcAngle);

        this.setColor(color);
        this.setVisible(true);

        addToWindow(window);
    }

    public int getStartAngle() {
        return this.startAngle;
    }

    public void setStartAngle(int startAngle) {
        this.startAngle = startAngle;
    }

    public int getArcAngle() {
        return this.arcAngle;
    }

    public void setArcAngle(int arcAngle) {
        this.arcAngle = arcAngle;
    }

    @Override
    public void paintComponent(Graphics g) {
        if (getVisible()) {
            super.paintComponent(g);
            g.setColor(this.getColor());
            this.setBounds(this.getX(), this.getY(), this.getWidth(), this.getHeight());
            g.fillArc(0, 0, this.getWidth(), this.getHeight(), this.getStartAngle(), this.getArcAngle());
        }
    }

}