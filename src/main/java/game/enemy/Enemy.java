package game.enemy;

import game.GameFrame;

import java.awt.*;

public class Enemy {
    public double x, y;
    public static final int WIDTH = 40;
    public static final int HEIGHT = 5;

    public Enemy(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void tick() {
        x+= ( GameFrame.ball.x - x) * 0.2;

    }

    public void render(Graphics g) {
        g.setColor(Color.gray);
        g.fillRect((int)x, (int)y, WIDTH, HEIGHT);
    }
}
