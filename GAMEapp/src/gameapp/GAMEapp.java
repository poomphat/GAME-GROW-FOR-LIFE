/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameapp;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author poomphatwawongmoon
 */
public class GAMEapp extends JPanel implements KeyListener {

    public int px = 0, py = 0, width = 16, height = 16, speedx=0, speedy=0;
    public int mapwidth = 800, mapheight = 800;
    public int camX;
    public int camY;
    private double zoom = 2.0;
    private int movespeed = 2;
    int maxspeed = 5;
    int speed = 1;
    int acceleration = 1;
    boolean movesUp;

    public static void main(String[] args) {
        GAMEapp p = new GAMEapp();
        JFrame fr = new JFrame();
        fr.setSize(1200, 700);
        fr.add(p);
        fr.addKeyListener(p);
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(Color.BLACK);
        g.fillRect(0, 0, 9999, 9999);
        Image img = new ImageIcon("asset/up.png").getImage();
        Image img1 = new ImageIcon("asset/map.png").getImage();
        camX = (int) (mapwidth / 2) - (px);
        camY = (int) (mapheight / 2) - (py);
        g2D.scale(zoom, zoom);
        g.translate(camX - 100, camY - 200);
        g.drawImage(img1, -100, -200, null);
        g.drawImage(img, this.px, this.py, width, height, null);
        update();
    }

    public void keyTyped(KeyEvent ke) {
    }

    public void keyPressed(KeyEvent ke) {
        int key = ke.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            speedx = -4;
        }
        if (key == KeyEvent.VK_RIGHT) {
            speedx = 4;
        }
        if (key == KeyEvent.VK_UP) {
            speedy = -4;
        }
        if (key == KeyEvent.VK_DOWN) {
            speedy = 4;
        }
        repaint();

    }

    public void update() {

        px += speedx;
        py += speedy;

    }

    public void keyReleased(KeyEvent ke) {
        int key = ke.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            speedx = 0;
        }
        if (key == KeyEvent.VK_RIGHT) {
            speedx = 0;
        }
        if (key == KeyEvent.VK_UP) {
            speedy = 0;
        }
        if (key == KeyEvent.VK_DOWN) {
            speedy = 0;
        }
        repaint();
    }

}
