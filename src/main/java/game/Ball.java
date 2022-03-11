package game;

import java.awt.*;
import java.util.Random;
public class Ball {

    public double x, y;
    private static final int WIDTH = 3;
    private static final int HEIGHT = 3;
    private double dx,dy;
    public double speed =1.7;
    public Ball(int x, int y) {
        this.x = x;
        this.y = y;
        int random = new Random().nextInt(90);
        this.dx = Math.cos(Math.toRadians(random));
        this.dy = Math.sin(Math.toRadians(random));
    }

    public void tick() {
        if(x + (dx*speed) + WIDTH >= GameFrame.WIDTH){
            dx *= -1;
        }else if(x + (dx*speed) <= 0){
            dx *= -1;
        }
        if(y >= GameFrame.HEIGHT){


        }else if (y <= 0){



        }
        Rectangle r = new Rectangle((int)(x+(dx*speed)), (int)(y+(dy*speed)), WIDTH, HEIGHT);
        Rectangle rPlayer = new Rectangle(GameFrame.player.x, GameFrame.player.y, GameFrame.player.WIDTH, GameFrame.player.HEIGHT);
        Rectangle rEnemy = new Rectangle((int) GameFrame.enemy.x, (int) GameFrame.enemy.y, GameFrame.enemy.WIDTH, GameFrame.enemy.HEIGHT);
        if(r.intersects(rPlayer)){
            dy *= -1;
        }
        if(r.intersects(rEnemy)){
            dy *= -1;
        }
        x+=dx * speed;
        y+=dy * speed;
    }

    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect((int)x, (int)y, WIDTH, HEIGHT);
    }
}
