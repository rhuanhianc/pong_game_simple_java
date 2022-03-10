package game;

import java.awt.*;
import java.util.Random;

public class Ball {

    public double x, y;
    private static final int WIDTH = 3;
    private static final int HEIGHT = 3;
    private double dx,dy;
    public double speed =1.1;
    public Ball(int x, int y) {
        this.x = x;
        this.y = y;
        this.dx = new Random().nextGaussian();
        this.dy = new Random().nextGaussian();
    }

    public void tick() {
        x+=dx * speed;
        y+=dy * speed;
    }

    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect((int)x, (int)y, WIDTH, HEIGHT);
    }
}
