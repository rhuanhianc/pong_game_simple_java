package game;

import javax.swing.*;
import java.awt.*;

public class Frame extends Canvas implements Runnable {

    private static  int WIDTH = 240;
    private static  int HEIGHT = 160;
    private static  int SCALE = 3;

    public Frame() {
    this.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        JFrame frame = new JFrame("Pong");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(this);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void run() {

    }
}
