import javax.swing.*;
import java.awt.*;

public class Shape extends JComponent {

    private int x;
    private int y;

    private int width;
    private int height;

    private Color color;
    private boolean visible;

    public void expand(int expandedX, int expandedY) {
        this.width = getWidth() + expandedX;
        this.height = getHeight() + expandedY;
    }

    public void retract(int expandedX, int expandedY) {
        this.width = getWidth() - expandedX;
        this.height = getHeight() - expandedY;
    }

    public void addToWindow(JFrame window) {
        window.add(this);
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean getVisible() {
        return this.visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

}
