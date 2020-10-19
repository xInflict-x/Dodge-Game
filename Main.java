import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();

        window.setSize(1017, 1040);
        window.setVisible(true);

        Rectangle button = new Rectangle(window, 0, 0, 100, 50, Color.DARK_GRAY);
        Circle food1 = new Circle(window, getRandom(), getRandom(), 50, 50, Color.BLACK);
        Circle food2 = new Circle(window, getRandom(), getRandom(), 50, 50, Color.BLACK);
        Circle food3 = new Circle(window, getRandom(), getRandom(), 50, 50, Color.BLACK);
        Circle food4 = new Circle(window, getRandom(), getRandom(), 50, 50, Color.BLACK);
        Circle food5 = new Circle(window, getRandom(), getRandom(), 50, 50, Color.BLACK);
        Circle food6 = new Circle(window, getRandom(), getRandom(), 50, 50, Color.BLACK);
        Circle food7 = new Circle(window, getRandom(), getRandom(), 50, 50, Color.BLACK);
        Circle food8 = new Circle(window, getRandom(), getRandom(), 50, 50, Color.BLACK);
        Circle food9 = new Circle(window, getRandom(), getRandom(), 50, 50, Color.BLACK);
        Circle food10 = new Circle(window, getRandom(), getRandom(), 50, 50, Color.BLACK);
        Circle food11 = new Circle(window, getRandom(), getRandom(), 50, 50, Color.BLACK);
        Circle food12 = new Circle(window, getRandom(), getRandom(), 50, 50, Color.BLACK);
        Circle food13 = new Circle(window, getRandom(), getRandom(), 50, 50, Color.BLACK);
        Circle food14 = new Circle(window, getRandom(), getRandom(), 50, 50, Color.BLACK);
        Circle food15 = new Circle(window, getRandom(), getRandom(), 50, 50, Color.BLACK);
        Circle food16 = new Circle(window, getRandom(), getRandom(), 50, 50, Color.BLACK);
        Circle food17 = new Circle(window, getRandom(), getRandom(), 50, 50, Color.BLACK);
        Circle food18 = new Circle(window, getRandom(), getRandom(), 50, 50, Color.BLACK);
        Circle food19 = new Circle(window, getRandom(), getRandom(), 50, 50, Color.BLACK);
        Circle food20 = new Circle(window, getRandom(), getRandom(), 50, 50, Color.BLACK);
        Circle food21 = new Circle(window, getRandom(), getRandom(), 50, 50, Color.BLACK);
        Circle player = new Circle(window, 500, getRandom(), 50, 50, Color.GREEN);

        Circle foodArray[] = {food1, food2, food3, food4, food5, food6, food7, food8, food9, food10, food11, food12, food13, food14, food15, food16, food17, food18, food19, food20, food21};

        int difficulty = 100;
        boolean run = true;

        window.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();

                if (x <= 110 && y <= 80) {
                    System.exit(0);
                }

                System.out.println(x);
                System.out.println(y);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        window.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                char ch = e.getKeyChar();
                if (ch == 'w' && player.getY() != 0) {
                    player.setY(player.getY() - 50);
                }

                if (ch == 's' && player.getY() != 950) {
                    player.setY(player.getY() + 50);
                }
                player.repaint();
            }
        });

        Thread moveBarrier = new Thread(() -> {
            while (run) {
                for (Circle circle : foodArray) {
                    circle.setX(circle.getX() - 50);
                    circle.repaint();
                }
                try {
                    Thread.sleep(difficulty);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread checkCollision = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (run) {
                for (Circle circle : foodArray) {
                    if (circle.getX() == player.getX() && circle.getY() == player.getY()) {
                        player.setColor(Color.RED);
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        player.setColor(Color.GREEN);
                    }
                    circle.repaint();
                    player.repaint();
                }
                try {
                    Thread.sleep(difficulty);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread respawnEnemies = new Thread(() -> {
            while (run) {
                for (Circle circle : foodArray) {
                    if (circle.getX() <= 0 && circle.getX() <= 0) {
                        circle.setX(900);
                        circle.setY(getRandom());
                    }
                    circle.repaint();
                }
                try {
                    Thread.sleep(difficulty);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        moveBarrier.start();
        respawnEnemies.start();
        checkCollision.start();
    }

    public static int getRandom() {
        int x;
        do {
            x = (int) Math.round(Math.random() * 950);
        } while (x % 50 != 0 && x >= 0 && x <= 1000);
        return x;
    }

}
