package game.player;

import game.GameFrame;

import java.awt.*;

public class Player {

    private int x,y;
    public boolean right,left;
    private static final int WIDTH = 40;
    private static final int HEIGHT = 10;
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
