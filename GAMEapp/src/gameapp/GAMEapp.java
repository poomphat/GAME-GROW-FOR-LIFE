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

public class GAMEapp extends JPanel implements KeyListener {

    private int px = 800, py = 800, width = 24, height = 24;
    private double speedx = 0, speedy = 0;
    private int mapwidth = 800, mapheight = 800;
    private int camX;
    private int camY, select = 70;
    private double zoom = 3.0;
    int maxspeed = 5, vet, chadis = 0;
    int speed = 1, sleep = 0;
    int[] dx, dy, carrot = new int[9999];
    int indexdin = 0, indexdins = 0;
    int acceleration = 1;
    boolean havedin = false;
    int daycount = 1;
    din Din = new din();
    chanidvet cha = new chanidvet();
    Image sleepimage = new ImageIcon("asset/sleep.png").getImage();
    Image currentImage = new ImageIcon("asset/char1.png").getImage();
    Image point = new ImageIcon("asset/pointer.png").getImage();
    Image imgup = new ImageIcon("asset/up.png").getImage();
    Image imgdown = new ImageIcon("asset/char1.png").getImage();
    Image imgleft = new ImageIcon("asset/left.png").getImage();
    Image imgright = new ImageIcon("asset/right.png").getImage();

    public GAMEapp() {
    }

    public Graphics renderFrame(Graphics g) {

        return g;

    }

    public static void main(String[] args) {
        GAMEapp p = new GAMEapp();
        JFrame fr = new JFrame("Stradew 69");
        fr.setSize(1600, 900);
        fr.setResizable(false);
        fr.add(p);
        fr.addKeyListener(p);
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        Graphics2D g1 = (Graphics2D) g;
        super.paintComponent(g);
        Color customColor = new Color(29,29,29);
        renderFrame(g);
        g2D.setColor(customColor);
        g.setColor(customColor);
        g.fillRect(0, 0, 9999, 9999);
        g1.setColor(Color.orange);
        Font myFont = new Font("Courier New", 1, 10);
        Image img1 = new ImageIcon("asset/Holetown.png").getImage();
        camX = (int) (mapwidth / 2) - (px);
        camY = (int) (mapheight / 2) - (py);
        
        g.setFont(myFont);
        g2D.scale(zoom, zoom);
        g.translate(camX - 140, camY - 230);
        g.drawImage(img1, 0, 0, null);

        if (havedin) {
            for (int i = 0; indexdin > i; i++) {
                g2D.drawImage(Din.getimage(carrot, i), Din.getX(i), Din.getY(i), 16, 16, null);
            }
            indexdins += 1;
        }
        g1.fillRect(this.px + 205, this.py - 165, 60, 25);
        g1.setColor(customColor);
        g.drawImage(point, this.px - (this.px % 16) + 16, (int) this.py - (this.py % 16) + 16, 16, 16, null);
        g2D.drawImage(sleepimage, 33 * 16, 30 * 16, 16, 16, null);
        g.drawRect(this.px + 205, this.py - 165, 60, 25);
        g1.setColor(Color.orange);
        g1.fillRect(this.px - 230, this.py - 165, 60, 25);
        g1.setColor(customColor);
        g.drawRect(this.px - 230, this.py - 165, 60, 25);
        g.drawRect(this.px - 70, this.py + 80, 160, 16);

        g.drawImage(cha.getimage(1), this.px - 70, this.py + 80, 16, 16, null);
        g.drawImage(cha.getimage(2), this.px - 54, this.py + 80, 16, 16, null);
        g.drawImage(cha.getimage(3), this.px - 38, this.py + 80, 16, 16, null);
        g.drawImage(cha.getimage(4), this.px - 22, this.py + 80, 16, 16, null);
        g.drawImage(cha.getimage(5), this.px - 6, this.py + 80, 16, 16, null);
        g.drawImage(cha.getimage(6), this.px + 10, this.py + 80, 16, 16, null);
        g.drawImage(cha.getimage(7), this.px + 26, this.py + 80, 16, 16, null);
        g.drawImage(cha.getimage(8), this.px + 42, this.py + 80, 16, 16, null);
        g.drawImage(cha.getimage(9), this.px + 58, this.py + 80, 16, 16, null);
        g.drawImage(cha.getimage(10), this.px + 74, this.py + 80, 16, 16, null);

        g1.setColor(Color.orange);
        g.drawRect(this.px - select, this.py + 80, 16, 16);
        g1.setColor(customColor);
        g.drawImage(currentImage, this.px, this.py, width, height, null);
        g.drawString("Day " + daycount, this.px + 220, this.py - 150);
        g.drawString("Money " + Din.getmoney(indexdin), this.px - 220, this.py - 150);
        g.drawString(cha.getchaniddis(chadis), this.px - 5, this.py + 110);

        if (sleep == 1) {
            g.fillRect(0, 0, 9999, 9999);
            Din.grow();
            sleep = 0;
            try {
                TimeUnit.SECONDS.sleep(1);

            } catch (InterruptedException ex) {
                Logger.getLogger(GAMEapp.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (((px >= 512) && (px <= 528)) && ((py >= 448) && (py <= 484))) {
            g1.setColor(Color.orange);
            g1.fillRect(this.px + -20, this.py - 160, 75, 15);
            g1.setColor(customColor);
            g.drawRect(this.px + -20, this.py - 160, 75, 15);
            g.drawString("SLEEP HERE", this.px - 13, this.py - 150);
        }
        update();
    }

    public void keyTyped(KeyEvent ke) {
    }

    public void keyPressed(KeyEvent ke) {
        int key = ke.getKeyCode();
        if (key == KeyEvent.VK_A) {
            if (((px >= 512) && (px <= 528)) && ((py >= 448) && (py <= 484))) {
                daycount += 1;
                sleep = 1;

                try {
                    TimeUnit.SECONDS.sleep(1);

                } catch (InterruptedException ex) {
                    Logger.getLogger(GAMEapp.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if (key == KeyEvent.VK_S) {
            Din.setpositiondinX(indexdin, (int) this.px - (this.px % 16) + 16);
            Din.setpositiondinY(indexdin, (int) this.py - (this.py % 16) + 16);
            Din.setvet(indexdin);
            havedin = true;
            if (chadis == 0) {
                carrot[indexdin] = 1;
            }
            if (chadis == 1) {
                carrot[indexdin] = 2;
            }
            if (chadis == 2) {
                carrot[indexdin] = 3;
            }
            if (chadis == 3) {
                carrot[indexdin] = 4;
            }
            if (chadis == 4) {
                carrot[indexdin] = 5;
            }
            if (chadis == 5) {
                carrot[indexdin] = 6;
            }
            if (chadis == 6) {
                carrot[indexdin] = 7;
            }
            if (chadis == 7) {
                carrot[indexdin] = 8;
            }
            if (chadis == 8) {
                carrot[indexdin] = 9;
            }
            if (chadis == 9) {
                carrot[indexdin] = 10;
            }

            indexdin += 1;
        }
        if (key == KeyEvent.VK_Z) {
            chadis++;
            if (chadis == 10) {
                chadis = 0;
            }

            if (select <= -74) {
                select = 70;
            } else {
                select -= 16;
            }
        }
        if (key == KeyEvent.VK_X) {
            Din.removedin((int) this.px - (this.px % 16) + 16, (int) this.py - (this.py % 16) + 16);
            havedin = true;
        }
        if (key == KeyEvent.VK_LEFT) {
            speedx = -4;
            if (px <= 432) {
                speedx = 0;
                px += 5;
            } else if (py <= 464) {
                speedy = 0;
                py += 5;
            } else if (py >= 1184) {
                speedy = 0;
                py -= 5;
            } else {
                setspeedx(-4);
            }
            currentImage = imgleft;
            repaint();
        } else if (key == KeyEvent.VK_RIGHT) {
            speedx = 4;
            if (px >= 1168) {
                speedx = 0;
                px -= 5;
            } else if (py <= 464) {
                speedy = 0;
                py += 5;
            } else if (py >= 1184) {
                speedy = 0;
                py -= 5;
            } else {
                setspeedx(4);
            }
            currentImage = imgright;
            repaint();
        } else if (key == KeyEvent.VK_UP) {
            speedy = -4;
            if (py <= 464) {
                speedy = 0;
                py += 5;
            } else if (px <= 432) {
                speedx = 0;
                px += 5;
            } else if (px >= 1168) {
                speedx = 0;
                px -= 5;
            } else {
                setspeedy(-4);
            }
            currentImage = imgup;
            repaint();
        } else if (key == KeyEvent.VK_DOWN) {
            speedy = 4;
            if (py >= 1184) {
                speedy = 0;
                py -= 5;
            } else if (px <= 432) {
                speedx = 0;
                px += 5;
            } else if (px >= 1168) {
                speedx = 0;
                px -= 5;
            } else {
                setspeedy(4);
            }
            currentImage = imgdown;
            repaint();
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
            setspeedx(0);
        }
        if (key == KeyEvent.VK_RIGHT) {
            setspeedx(0);
        }
        if (key == KeyEvent.VK_UP) {
            setspeedy(0);
        }
        if (key == KeyEvent.VK_DOWN) {
            setspeedy(0);
        }
        repaint();
    }

    public void setspeedx(double speedx) {
        this.speedx = speedx;
    }

    public void setspeedy(double speedy) {
        this.speedy = speedy;
    }

}
