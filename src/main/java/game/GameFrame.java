package game;

import game.enemy.Enemy;
import game.player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class GameFrame extends Canvas implements Runnable, KeyListener {

    public static  int WIDTH = 240;
    public static  int HEIGHT = 160;
    private static  int SCALE = 3;
    private BufferedImage layer = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    private Player player;
    private Enemy enemy;
    private Ball ball;
    public GameFrame() {
    this.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        this.addKeyListener(this);
        player = new Player( 100 , HEIGHT -10);
        enemy = new Enemy( 100,  0);
        ball = new Ball(100 , HEIGHT / 2 -1);
        JFrame frame = new JFrame("Pong");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(this);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setBackground(Color.BLACK);
        new Thread(this).start();
    }
    public void tick() {
        player.tick();
        enemy.tick();
        ball.tick();
    }
    public void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null) {
            this.createBufferStrategy(3);
            return;
        }
            Graphics g = layer.getGraphics();
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, WIDTH, HEIGHT);
            player.render(g);
            enemy.render(g);
            ball.render(g);
            g = bs.getDrawGraphics();
            g.drawImage(layer,0, 0, WIDTH * SCALE, HEIGHT * SCALE, null);

            bs.show();

    }

    @Override
    public void run() {
        while(true){
            tick();
            render();
            try {
                Thread.sleep(1000/60);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            player.right = true;

        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            player.left = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            player.left = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            player.right = false;
        }
    }
}
