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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.*;

public class GAMEapp extends JPanel implements KeyListener {

    private int px = 524, py = 500, width = 24, height = 24;
    private double speedx = 0, speedy = 0;
    private int mapwidth = 800, mapheight = 800, selectinmenu = -50, selectinmenupause = -20;
    private int camX;
    private BufferedImage buffer;
    private int camY, select = 70, select1 = 1, select2 = 1;
    private double zoom = 3.0;
    int maxspeed = 5, vet, chadis = 0;
    int speed = 1, sleep = 0;
    int[] carrot = new int[9999];
    int indexdin = 1, indexdins = 0;
    int acceleration = 1;
    boolean havedin = false, checkhowto = false, pause;
    int daycount = 1;
    int hos = 0, opa = 0;
    String ses = "Spring";
    String bgs = "asset/bg.wav";
    int s = 1;

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
    Image howto = new ImageIcon("asset/howto.png").getImage();
    Image how = new ImageIcon("asset/how.png").getImage();
    Image end = new ImageIcon("asset/end.png").getImage();
    Image over = new ImageIcon("asset/over.png").getImage();
    Image pause1 = new ImageIcon("asset/pause.png").getImage();
    Image res = new ImageIcon("asset/res.png").getImage();
    Image me = new ImageIcon("asset/me.png").getImage();
    Image esc = new ImageIcon("asset/esc.png").getImage();
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
    private Animation walkLeft = new Animation(walkingLeft, 10);
    private Animation walkRight = new Animation(walkingRight, 10);
    private Animation walkDown = new Animation(walkingDown, 10);
    private Animation walkUp = new Animation(walkingUp, 10);
    private Animation standing1 = new Animation(standing, 10);
    private Animation standing2 = new Animation(standingl, 10);
    private Animation standing3 = new Animation(standingr, 10);
    private Animation standing4 = new Animation(standingu, 10);

    private Clip clip;

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
                if (pause) {
                }
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
        Color night = new Color(22, 0, 46, opa);

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
        g1.drawImage(start, this.px - 40, this.py - 50, 90, 40, null);
        g1.drawImage(howto, this.px - 40, this.py, 90, 40, null);
        g1.drawImage(quit, this.px - 40, this.py + 50, 90, 40, null);
        g1.drawImage(selectmenu, this.px - 40, this.py + selectinmenu, 90, 40, null);
        if (checkhowto) {
            g1.drawImage(how, this.px - 260, this.py - 175, 535, 300, null);
        }
        if (gamestart == true) {
            Image img1 = new ImageIcon("asset/Holetown.png").getImage();
            if (daycount <= 25) {
                img1 = new ImageIcon("asset/Holetown.png").getImage();
                ses = "Spring";
                bgs = "asset/bg.wav";
                if (s == 1) {
                    s++;
                    stopSound();
                    playSound();

                }              
            } else if (daycount <= 50) {
                img1 = new ImageIcon("asset/HoletownSu.png").getImage();
                ses = "Summer";
                bgs = "asset/bgsum.wav";
                if (s == 2) {
                    s++;
                    stopSound();
                    playSound();

                }              
            } else if (daycount <= 75) {
                img1 = new ImageIcon("asset/HoletownFa.png").getImage();
                ses = "Autumn";
                bgs = "asset/bgfall.wav";
                if (s == 3) {
                    s++;
                    stopSound();
                    playSound();
                    
   
                }              
            } else if (daycount <= 100) {
                img1 = new ImageIcon("asset/HoletownWi.png").getImage();
                ses = "Winter";
                bgs = "asset/bgwin.wav";
                if (s == 4) {
                    s++;
                    stopSound();
                    playSound();

                }           
            }
            g.drawImage(img1, 0, 0, null);



            if (havedin) {
                for (int i = 0; indexdin > i; i++) {
                    g2D.drawImage(Din.getimage(indexdin, carrot, i), Din.getX(i), Din.getY(i), 16, 16, null);
                    if (Din.getwater(i) == 1) {
                        g.setColor(water);
                        g.fillRect(Din.getX(i), Din.getY(i), 16, 16);
                        g.setColor(Color.orange);

                    }

                }
                indexdins += 1;
            }

            g1.setColor(customColor);
            g.drawImage(point, this.px - (this.px % 16) + 16, (int) this.py - (this.py % 16) + 16, 16, 16, null);
            g2D.drawImage(sleepimage, 33 * 16, 30 * 16, 16, 16, null);

            g.drawImage(animation.getSprite(), px, py, 24, 24, null);

            String soon = "0";
            if (sec >= 360) {
                soon = "";
            }
            String jood = ":";
            if (sec % 2 == 0) {
                jood = " ";
            }

            g.drawImage(esc, this.px - 260, this.py - 180, 535, 300, null);

            if (!pause) {
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
                g1.fillRect(this.px + 205, this.py - 165, 60, 35);
                g1.fillRect(this.px + 198, this.py + 85, 67, 25);
                g1.fillRect(this.px - 230, this.py - 165, 80, 25);
                g1.setColor(customColor);
                g.drawRect(this.px + 198, this.py + 85, 67, 25);
                g.drawRect(this.px - 230, this.py - 165, 80, 25);
                g.drawRect(this.px - 70, this.py + 80, 160, 16);
                g.drawRect(this.px + 205, this.py - 165, 60, 35);
                g1.setColor(Color.orange);
                g.drawRect(this.px - select, this.py + 80, 16, 16);

                g1.setColor(customColor);

                g.drawString("Day " + daycount, this.px + 215, this.py - 150);
                g.drawString(ses, this.px + 215, this.py - 140);
                g.drawString("Time " + soon + (((sec - (sec % 60)) / 60) + 4) + jood + "00", this.px + 201, this.py + 101);
                g.drawString("Money " + (Din.getmoney(indexdin) + hos), this.px - 220, this.py - 150);
                g.drawString(cha.getchaniddis(chadis), this.px - 5, this.py + 110);
            }
            if (sleep == 1) {
                g.setColor(Color.BLACK);
                g.fillRect(0, 0, 9999, 9999);

            }
            if (((daycount % 3) == 0 && (daycount > 0 && daycount <= 25))||((daycount % 5) == 0 && (daycount > 25 && daycount <= 50))||((daycount % 7) == 0 && (daycount > 50 && daycount <= 75))) {
                Din.whenrain(indexdin);
                g1.setColor(rainc);
                g1.fillRect(0, 0, 9999, 9999);
                g1.drawImage(rain, this.px - 260, this.py - 175, 535, 300, null);
                g1.setColor(customColor);

            }

            if (sec >= 560) {
                opa = 10;
                g.setColor(night);
                g.fillRect(0, 0, 9999, 9999);
                g.setColor(Color.orange);

            }
            if (sec >= 760) {
                opa = 40;
                g.setColor(night);
                g.fillRect(0, 0, 9999, 9999);
                g.setColor(Color.orange);

            }
            if (sec >= 880) {
                opa = 60;
                g.setColor(night);
                g.fillRect(0, 0, 9999, 9999);
                g.setColor(Color.orange);

            }
            if (sec >= 1000) {
                opa = 80;
                g.setColor(night);
                g.fillRect(0, 0, 9999, 9999);
                g.setColor(Color.orange);

            }

            if (Din.getmoney(indexdin) >= 10000) {
                g1.drawImage(end, this.px - 260, this.py - 175, 535, 300, null);
            }
            if (daycount > 100) {
                g1.drawImage(over, this.px - 260, this.py - 175, 535, 300, null);
            }

            if (((px >= 512) && (px <= 528)) && ((py >= 448) && (py <= 484))) {
                g1.setColor(Color.orange);
                g1.fillRect(this.px + -20, this.py - 160, 75, 15);
                g1.setColor(customColor);
                g.drawRect(this.px + -20, this.py - 160, 75, 15);
                g.drawString("SLEEP HERE", this.px - 13, this.py - 150);

            }
            if (pause) {
                g1.drawImage(pause1, this.px - 260, this.py - 175, 535, 300, null);
                g1.drawImage(res, this.px - 40, this.py - 20, 90, 40, null);
                g1.drawImage(me, this.px - 40, this.py + 30, 90, 40, null);
                g1.drawImage(selectmenu, this.px - 40, this.py + selectinmenupause, 90, 40, null);
                g.drawImage(esc, this.px - 260, this.py - 180, 535, 300, null);
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
        if (sleep == 0) {
            if (key == KeyEvent.VK_ESCAPE) {
                if (pause) {
                    pause = false;
                } else {
                    pause = true;
                }
            }

            if (key == KeyEvent.VK_D) {
                Din.water(indexdin, (int) this.px - (this.px % 16) + 16, (int) this.py - (this.py % 16) + 16);
                if (Din.watercheck) {
                    pl.playSoundwater();
                }
            }
            if (key == KeyEvent.VK_ENTER) {
                if (checkhowto) {
                    checkhowto = false;
                } else if (select1 == 1) {
                    gamestart = true;
                    select1 = 1;
                } else if (select1 == 2) {
                    checkhowto = true;
                } else if (select1 == 3) {
                    System.exit(0);
                }
                if (pause) {
                    if (select1 == 1) {
                        gamestart = true;
                    }
                    if (select2 == 1) {
                        pause = false;
                    }
                    if (select2 == 2) {
                        select1 = 1;
                        gamestart = false;
                        pause = false;

                    }
                }
            }
            if (key == KeyEvent.VK_A) {
                if (gamestart && !pause) {
                    if (((px >= 512) && (px <= 528)) && ((py >= 448) && (py <= 484))) {
                        hos = 0;
                        sleep = 1;
                        sleepcheck = true;
                    }
                }
            }

            if (key == KeyEvent.VK_S) {
                if (gamestart && !pause) {
                    if (!(((px >= 512) && (px <= 528)) && ((py >= 448) && (py <= 484)))) {
                        pl.playSoundDig();
                        // System.out.println(indexdin);
                        Din.setpositiondin(indexdin, (int) this.px - (this.px % 16) + 16, (int) this.py - (this.py % 16) + 16);
                        Din.setwater(indexdin);
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
                        for (int l = 0; indexdin + 1 > l; l++) {
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
            }
            if (key == KeyEvent.VK_Z) {
                if (gamestart && !pause) {
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
                if (gamestart && !pause) {
                    Din.removedin(indexdin, (int) this.px - (this.px % 16) + 16, (int) this.py - (this.py % 16) + 16);
                    havedin = true;
                    if (Din.removecheck()) {
                        pl.playSoundSell();
                    }
                }
            }
            if (key == KeyEvent.VK_LEFT) {
                if (gamestart && !pause) {
                    setspeedx(-2);
                }

            } else if (key == KeyEvent.VK_RIGHT) {
                if (gamestart && !pause) {
                    setspeedx(2);
                }

            } else if (key == KeyEvent.VK_UP) {
                if (!gamestart) {
                    selectinmenu = -50;
                    pl.playSoundselect();
                    if (select1 == 1) {
                        selectinmenu = 50;
                        select1 = 3;

                    } else if (select1 == 3) {
                        selectinmenu = 0;
                        select1 = 2;
                    } else {
                        select1 = 1;
                    }
                }
                if (!pause) {
                    setspeedy(-2);
                }
                if (pause) {
                    selectinmenupause = 30;
                    if (select2 == 2) {
                        selectinmenupause = -20;
                        select2 = 1;
                    } else {
                        select2 = 2;
                    }

                }

            } else if (key == KeyEvent.VK_DOWN) {
                if (!gamestart) {
                    selectinmenu = -50;
                    pl.playSoundselect();
                    if (select1 == 1) {
                        selectinmenu = 0;
                        select1 = 2;
                    } else if (select1 == 2) {
                        selectinmenu = 50;
                        select1 = 3;
                    } else {
                        select1 = 1;
                    }
                }
                if (!pause) {
                    setspeedy(2);
                }
                if (pause) {
                    selectinmenupause = -20;
                    if (select2 == 1) {
                        selectinmenupause = 30;
                        select2 = 2;
                    } else {
                        select2 = 1;
                    }

                }

            }

        }
    }

    public void update() {

        px += speedx;
        py += speedy;
        animation.update();
        if (pause) {
            speedx = 0;
            speedy = 0;
            animation.stop();
        }

    }

    public void keyReleased(KeyEvent ke) {
        int key = ke.getKeyCode();
        if (!pause) {
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
    }

    public void setspeedx(double speedx) {
        this.speedx = speedx;
    }

    public void setspeedy(double speedy) {
        this.speedy = speedy;
    }

    long targetFPS = 45;
    long currentFPS = targetFPS;
    long currentTPS = targetFPS;
    long FPSticks = 0;
    long TPSticks = 0;
    long oldFPSTime = time();
    long newFPSTime = oldFPSTime;
    int sec = 0;

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

            if (sleep == 1) {

                try {
                    Thread.sleep(0);
                } catch (InterruptedException ex) {
                    Logger.getLogger(GAMEapp.class.getName()).log(Level.SEVERE, null, ex);
                }
                Din.grow(indexdin + 1);
                daycount += 1;
                pl.playSoundmorning();
                sec = 0;
                sleep = 0;

            }
            if (sec == 1200) {
                sleep = 1;
                opa = 0;
                hos -= 30;
            }

            repaint();
            newFPSTime = time();
            if (newFPSTime > oldFPSTime + 1000) {
                oldFPSTime = newFPSTime;
                currentFPS = FPSticks;
                currentTPS = TPSticks;
                if (gamestart && !pause) {
                    sec++;

                }
              //  System.out.println(sec);
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
    public void stopSound(){
        clip.stop();}

    public void playSound() {

        try {

            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(bgs).getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            FloatControl gainControl
                    = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-10.0f);

            clip.stop();
            clip.start();

        } catch (Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }
}
