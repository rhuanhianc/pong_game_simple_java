package game.enemy;

import java.awt.*;

public class Enemy {
    public double x, y;
    private static final int WIDTH = 40;
    private static final int HEIGHT = 10;

    public Enemy(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void tick() {

    }

    public void render(Graphics g) {
        g.setColor(Color.gray);
        g.fillRect((int)x, (int)y, WIDTH, HEIGHT);
    }
}
