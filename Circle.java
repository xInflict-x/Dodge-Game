import javax.swing.*;
import java.awt.*;

public class Circle extends Shape {

    public Circle(JFrame window, int x, int y, int width, int height, Color color) {
        this.setX(x);
        this.setY(y);

        this.setWidth(width);
        this.setHeight(height);

        this.setColor(color);
        this.setVisible(true);

        addToWindow(window);
    }

    @Override
    public void paintComponent(Graphics g) {
        if (getVisible()) {
            super.paintComponent(g);
            g.setColor(this.getColor());
            this.setBounds(this.getX(), this.getY(), this.getWidth(), this.getHeight());
            g.fillOval(0, 0, this.getWidth(), this.getHeight());
        }
    }

}