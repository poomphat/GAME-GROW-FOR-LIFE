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

import java.io.*;

import sun.audio.*;


public class GAMEapp extends JPanel implements KeyListener {

    private int px = 400, py = 400, width = 24, height = 24, speedx=0, speedy=0;
    private int mapwidth = 800, mapheight = 800;
    private int camX;
    private int camY;
    private double zoom = 2.0;
    int maxspeed = 5;
    int speed = 1;
    int[] dx,dy;
    int indexdin = 0;
    int acceleration = 1;
    boolean havedin=false;
    din Din = new din();
    Image currentImage = new ImageIcon("asset/char1.png").getImage();
    Image point = new ImageIcon("asset/pointer.png").getImage();
    Image imgup = new ImageIcon("asset/up.png").getImage();
    Image imgdown = new ImageIcon("asset/char1.png").getImage();
    Image imgleft = new ImageIcon("asset/left.png").getImage();
    Image imgright = new ImageIcon("asset/right.png").getImage();
    
    public GAMEapp() {
    }
    
    
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
       
        
        Image img1 = new ImageIcon("asset/starmap.png").getImage();
        camX = (int) (mapwidth / 2) - (px);
        camY = (int) (mapheight / 2) - (py);
        
        g2D.scale(zoom, zoom);
        g.translate(camX - 100, camY - 200);
        g.drawImage(img1, 0, 0, null);
        
        if(havedin){
            for(int i = 0; indexdin > i;i++){
            g2D.drawImage(Din.getimage(), Din.getX(i), Din.getY(i), 16, 16, null);
            }
            indexdin += 1;
        }
        g.drawImage(point, this.px-(this.px%16)+16, (int)this.py-(this.py%16)+16,16, 16, null);
        g.drawImage(currentImage, this.px, this.py, width, height, null);
        
        update();
    }


    public void keyTyped(KeyEvent ke) {
    }

    public void keyPressed(KeyEvent ke) {
        int key = ke.getKeyCode();
        if(key == KeyEvent.VK_Z){
            Din.setpositiondinX(indexdin,(int)this.px-(this.px%16)+16);
            Din.setpositiondinY(indexdin,(int)this.py-(this.py%16)+16);
            havedin = true;
        }
         if(key == KeyEvent.VK_X){
            Din.removedin((int)this.px-(this.px%16)+16,(int)this.py-(this.py%16)+16);
            havedin = true;
        }
        if (key == KeyEvent.VK_LEFT) {
            speedx = -4;
            if(px <= 32 ){
                 speedx = 0;
            }else{
                speedx = -4;
            }
            currentImage = imgleft;
            repaint();
        }
        if (key == KeyEvent.VK_RIGHT) {
            speedx = 4;
            if(px >= 752 ){
                 speedx = 0;
            }else{
                speedx = 4;
            }
            currentImage = imgright;
            repaint();
        }
        if (key == KeyEvent.VK_UP) {
            speedy = -4;
            if(py <= 96 ){
                 speedy = 0;
            }else{
               speed = -4;
            }
            currentImage = imgup;
            repaint();
        }
        if (key == KeyEvent.VK_DOWN) {
            speedy = 4;
            if(py >= 744 ){
                 speedy = 0;
            }else{
               speed = 4;
            }
            currentImage = imgdown;
            repaint();
        }
        

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
