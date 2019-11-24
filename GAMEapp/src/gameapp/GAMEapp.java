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
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioInputStream;

import java.awt.image.BufferedImage;
import javax.sound.sampled.Clip;

public class GAMEapp extends JPanel implements KeyListener {

    private int px = 524, py = 500, width = 24, height = 24;
    private double speedx = 0, speedy = 0;
    private int mapwidth = 800, mapheight = 800, selectinmenu = -10;
    private int camX;
    private BufferedImage buffer;
    private int camY, select = 70, select1 = 1;
    private double zoom = 3.0;
    int maxspeed = 5, vet, chadis = 0;
    int speed = 1, sleep = 0;
    int[] dx, dy, carrot = new int[9999];
    int indexdin = 1, indexdins = 0;
    int acceleration = 1;
    boolean havedin = false;
    int daycount = 1;
    din Din = new din();
    chanidvet cha = new chanidvet();
    Image sleepimage = new ImageIcon("asset/sleep.png").getImage();
    Image currentImage = new ImageIcon("asset/char1.png").getImage();
    Image point = new ImageIcon("asset/pointer.png").getImage();
    Image rain = new ImageIcon("asset/rain.gif").getImage();
    Image mainmenu = new ImageIcon("asset/menu-bg.png").getImage();
    Image selectmenu = new ImageIcon("asset/border-texrt.png").getImage();
    Image start = new ImageIcon("asset/st.png").getImage();
    Image quit = new ImageIcon("asset/Qu.png").getImage();

    Image end = new ImageIcon("asset/end.png").getImage();
    Image over = new ImageIcon("asset/over.png").getImage();
    boolean gamestart = false;
    Playsound pl = new Playsound();
    int checksameposition;
    boolean checksameposition1 = false, sleepcheck;

    private BufferedImage[] walkingLeft = {Sprite.getSprite(0, 1), Sprite.getSprite(2, 1)};
    private BufferedImage[] walkingRight = {Sprite.getSprite(0, 2), Sprite.getSprite(2, 2)};
    private BufferedImage[] walkingUp = {Sprite.getSprite(0, 3), Sprite.getSprite(2, 3)};
    private BufferedImage[] walkingDown = {Sprite.getSprite(0, 0), Sprite.getSprite(2, 0)};
    private BufferedImage[] standing = {Sprite.getSprite(1, 0)};
    private BufferedImage[] standingl = {Sprite.getSprite(1, 1)};
    private BufferedImage[] standingr = {Sprite.getSprite(1, 2)};
    private BufferedImage[] standingu = {Sprite.getSprite(1, 3)};

// These are animation states
    private Animation walkLeft = new Animation(walkingLeft, 20);
    private Animation walkRight = new Animation(walkingRight, 20);
    private Animation walkDown = new Animation(walkingDown, 20);
    private Animation walkUp = new Animation(walkingUp, 20);
    private Animation standing1 = new Animation(standing, 20);
    private Animation standing2 = new Animation(standingl, 20);
    private Animation standing3 = new Animation(standingr, 20);
    private Animation standing4 = new Animation(standingu, 20);

// This is the actual animation
    private Animation animation = standing1;

    JFrame jr;
    JPanel p1, p2;
    JButton b1, b2;

    public GAMEapp() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                gameLoop();
            }
        });
        thread.start();
    }

    public Graphics renderFrame(Graphics g) {
        return g;

    }

    public static void main(String[] args) {
        GAMEapp p = new GAMEapp();
        JFrame fr = new JFrame("FARM IN ABYSS");
        p.playSound();
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
        Color customColor = new Color(29, 29, 29);
        Color rainc = new Color(65, 120, 157, 100);
        Color water = new Color(65, 120, 157, 130);
        renderFrame(g);
        g2D.setColor(customColor);
        g.setColor(customColor);
        g.fillRect(0, 0, 9999, 9999);
        g1.setColor(Color.orange);
        Font myFont = new Font("Courier New", 1, 10);
        camX = (int) (mapwidth / 2) - (px);
        camY = (int) (mapheight / 2) - (py);

        g.setFont(myFont);
        g2D.scale(zoom, zoom);
        g.translate(camX - 140, camY - 230);
        g1.drawImage(mainmenu, this.px - 260, this.py - 175, 535, 300, null);
        g1.drawImage(start, this.px - 40, this.py - 10, 90, 40, null);
        g1.drawImage(quit, this.px - 40, this.py + 50, 90, 40, null);
        g1.drawImage(selectmenu, this.px - 40, this.py + selectinmenu, 90, 40, null);

        if (gamestart == true) {
            Image img1 = new ImageIcon("asset/Holetown.png").getImage();

            g.drawImage(img1, 0, 0, null);

            if (havedin) {
                for (int i = 0; indexdin > i; i++) { 
                    g2D.drawImage(Din.getimage(indexdin, carrot, i), Din.getX(i), Din.getY(i), 16, 16, null);
                    if(Din.getwater(i) == 1){
                        g.setColor(water);
                        g.fillRect(Din.getX(i),Din.getY(i), 16, 16);
                        g.setColor(Color.orange);
                      
                        
                    }
                   
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

            g.drawImage(animation.getSprite(), px, py, 24, 24, null);

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

            g.drawString("Day " + daycount, this.px + 220, this.py - 150);
            g.drawString("Money " + Din.getmoney(indexdin), this.px - 220, this.py - 150);
            g.drawString(cha.getchaniddis(chadis), this.px - 5, this.py + 110);

            if (sleep == 1) {
                g.fillRect(0, 0, 9999, 9999);
                wait(2000);

                Din.grow();
                sleep = 0;

            }
            if (Din.getmoney(indexdin) >= 10000) {
                g1.drawImage(end, this.px - 260, this.py - 175, 535, 300, null);
            }
            if (daycount >= 100) {
                g1.drawImage(over, this.px - 260, this.py - 175, 535, 300, null);
            }

            if (((px >= 512) && (px <= 528)) && ((py >= 448) && (py <= 484))) {
                g1.setColor(Color.orange);
                g1.fillRect(this.px + -20, this.py - 160, 75, 15);
                g1.setColor(customColor);
                g.drawRect(this.px + -20, this.py - 160, 75, 15);
                g.drawString("SLEEP HERE", this.px - 13, this.py - 150);

            }
            if ((daycount % 5) == 0) {
                Din.whenrain(indexdin);
                g1.setColor(rainc);
                g1.fillRect(0, 0, 9999, 9999);
                g1.drawImage(rain, this.px - 260, this.py - 175, 535, 300, null);
                g1.setColor(customColor);

            }
          
        }
    }

    public int getIndexdin() {
        return indexdin;
    }

    public void keyTyped(KeyEvent ke) {
    }

    public void keyPressed(KeyEvent ke) {
        int key = ke.getKeyCode();
        if (key == KeyEvent.VK_D) {
            Din.water(indexdin,(int) this.px - (this.px % 16) + 16,(int) this.py - (this.py % 16) + 16);
        }
        if (key == KeyEvent.VK_ENTER) {
            if (select1 == 1) {
                gamestart = true;
            }
            if (select1 == 2) {
                System.exit(0);
            }
        }
        if (key == KeyEvent.VK_A) {
            if (gamestart) {
                if (((px >= 512) && (px <= 528)) && ((py >= 448) && (py <= 484))) {
                    daycount += 1;
                    sleep = 1;
                    sleepcheck = true;
                }
            }
        }

        if (key == KeyEvent.VK_S) {
            if (gamestart) {
                pl.playSoundDig();
                System.out.println(indexdin);
                Din.setpositiondin(indexdin, (int) this.px - (this.px % 16) + 16, (int) this.py - (this.py % 16) + 16);
                Din.setvet(indexdin);
                havedin = true;
                if (chadis == 0) {
                    carrot[indexdin] = 1;
                } else if (chadis == 1) {
                    carrot[indexdin] = 2;
                } else if (chadis == 2) {
                    carrot[indexdin] = 3;
                } else if (chadis == 3) {
                    carrot[indexdin] = 4;
                } else if (chadis == 4) {
                    carrot[indexdin] = 5;
                } else if (chadis == 5) {
                    carrot[indexdin] = 6;
                } else if (chadis == 6) {
                    carrot[indexdin] = 7;
                } else if (chadis == 7) {
                    carrot[indexdin] = 8;
                } else if (chadis == 8) {
                    carrot[indexdin] = 9;
                } else if (chadis == 9) {
                    carrot[indexdin] = 10;
                }
                for (int l = 0; Din.getindexxy() > l; l++) {
                    if (indexdin != l) {
                        if (this.px - (this.px % 16) + 16 == Din.getarrayx(l) && (int) this.py - (this.py % 16) + 16 == Din.getarrayy(l)) {
                            checksameposition += 1;

                        }
                    }

                }
                if (checksameposition == 0) {
                    checksameposition1 = true;
                }
                if (checksameposition1) {
                    indexdin += 1;
                    checksameposition = 0;
                    checksameposition1 = false;
                }
                checksameposition = 0;
            }
        }
        if (key == KeyEvent.VK_Z) {
            if (gamestart) {
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
        }
        if (key == KeyEvent.VK_X) {
            if (gamestart) {
                Din.removedin(indexdin, (int) this.px - (this.px % 16) + 16, (int) this.py - (this.py % 16) + 16);
                havedin = true;
                if (Din.removecheck()) {
                    pl.playSoundSell();
                }
            }
        }
        if (key == KeyEvent.VK_LEFT) {
            if (gamestart) {
                setspeedx(-1);
            }

        } else if (key == KeyEvent.VK_RIGHT) {
            if (gamestart) {
                setspeedx(1);
            }

        } else if (key == KeyEvent.VK_UP) {
            if (!gamestart) {
                selectinmenu = -10;

                if (select1 == 1) {
                    selectinmenu = 50;
                    select1 = 2;
                } else {
                    select1 = 1;
                }
            }
            setspeedy(-1);

        } else if (key == KeyEvent.VK_DOWN) {
            if (!gamestart) {
                selectinmenu = 50;

                if (select1 == 2) {
                    selectinmenu = -10;
                    select1 = 1;
                } else {
                    select1 = 2;
                }
            }
            setspeedy(1);

        }

    }

    public void update() {

        px += speedx;
        py += speedy;
        animation.update();

    }

    public void keyReleased(KeyEvent ke) {
        int key = ke.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            setspeedx(0);
            animation.stop();
            animation.reset();
            animation = standing2;

        }
        if (key == KeyEvent.VK_RIGHT) {
            setspeedx(0);
            animation.stop();
            animation.reset();
            animation = standing3;

        }
        if (key == KeyEvent.VK_UP) {
            setspeedy(0);
            animation.stop();
            animation.reset();
            animation = standing4;
        }
        if (key == KeyEvent.VK_DOWN) {
            setspeedy(0);
            animation.stop();
            animation.reset();
            animation = standing1;
        }

    }

    public void setspeedx(double speedx) {
        this.speedx = speedx;
    }

    public void setspeedy(double speedy) {
        this.speedy = speedy;
    }

    long targetFPS = 60;
    long currentFPS = targetFPS;
    long currentTPS = targetFPS;
    long FPSticks = 0;
    long TPSticks = 0;
    long oldFPSTime = time();
    long newFPSTime = oldFPSTime;

    public void gameLoop() {

        long previous = time();
        long lag = 0;
        while (true) {
            long current = time();
            long elapsed = current - previous;
            previous = current;
            lag += elapsed;
            while (lag >= 1000 / targetFPS) {
                update();
                lag -= 1000 / targetFPS;
                TPSticks++;
            }
            repaint();
            newFPSTime = time();
            if (newFPSTime > oldFPSTime + 1000) {
                oldFPSTime = newFPSTime;
                currentFPS = FPSticks;
                currentTPS = TPSticks;
                FPSticks = 0;
                TPSticks = 0;
            }
            if (px <= 432) {
                speedx = 0;
                px = 433;
            }
            if (py <= 464) {
                speedy = 0;
                py = 465;
            }
            if (py >= 1184) {
                speedy = 0;
                py = 1183;
            }
            if (px >= 1168) {
                speedx = 0;
                px = 1167;
            }

            if (speedx < 0) {
                animation = walkLeft;
                animation.start();
            } else if (speedx > 0) {
                animation = walkRight;
                animation.start();
            } else if (speedy < 0) {
                animation = walkUp;
                animation.start();
            } else if (speedy > 0) {
                animation = walkDown;
                animation.start();
            }
        }
    }

    public long time() {
        return System.currentTimeMillis();
    }

    public void wait(int n) {
        long t0, t1;
        t0 = System.currentTimeMillis();

        do {
            t1 = System.currentTimeMillis();
        } while ((t1 - t0) < n);
    }

    public void playSound() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("asset/bg.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        } catch (Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }
}
