package game.player;

import game.GameFrame;

import java.awt.*;

public class Player {

    public int x;
    public int y;
    public boolean right,left;
    public static final int WIDTH = 40;
    public static final int HEIGHT = 5;
    public Player(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void tick() {
        if(right) x++;
        if(left) x--;
        Collision();
    }
    private void Collision() {
        if(x+WIDTH>GameFrame.WIDTH) x= GameFrame.WIDTH - WIDTH;
        if(x<0) x=0;

    }
    public void render(Graphics g) {
        g.setColor(Color.gray);
        g.fillRect(x, y, WIDTH, HEIGHT);
    }
}
