/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameapp;

import java.awt.*;
import javax.swing.*;

public class din {

    Image din = new ImageIcon("asset/1b.png").getImage();
    Image carrot1 = new ImageIcon("asset/crop/carrot1.png").getImage();
    Image carrot2 = new ImageIcon("asset/crop/carrot2.png").getImage();
    Image carrot3 = new ImageIcon("asset/crop/carrot3.png").getImage();
    Image kalum1 = new ImageIcon("asset/crop/karlum1.png").getImage();
    Image kalum2 = new ImageIcon("asset/crop/karlum2.png").getImage();
    Image kalum3 = new ImageIcon("asset/crop/karlum3.png").getImage();
    Image melon1 = new ImageIcon("asset/crop/melon1.png").getImage();
    Image melon2 = new ImageIcon("asset/crop/melon2.png").getImage();
    Image melon3 = new ImageIcon("asset/crop/melon3.png").getImage();
    Image staw1 = new ImageIcon("asset/crop/staw1.png").getImage();
    Image staw2 = new ImageIcon("asset/crop/staw2.png").getImage();
    Image staw3 = new ImageIcon("asset/crop/staw3.png").getImage();
    Image beet1 = new ImageIcon("asset/crop/beet1.png").getImage();
    Image beet2 = new ImageIcon("asset/crop/beet2.png").getImage();
    Image beet3 = new ImageIcon("asset/crop/beet3.png").getImage();
    Image sweet1 = new ImageIcon("asset/crop/sweet1.png").getImage();
    Image sweet2 = new ImageIcon("asset/crop/sweet2.png").getImage();
    Image sweet3 = new ImageIcon("asset/crop/sweet3.png").getImage();
    Image radish1 = new ImageIcon("asset/crop/radish1.png").getImage();
    Image radish2 = new ImageIcon("asset/crop/radish2.png").getImage();
    Image radish3 = new ImageIcon("asset/crop/radish3.png").getImage();
    Image cran1 = new ImageIcon("asset/crop/cran1.png").getImage();
    Image cran2 = new ImageIcon("asset/crop/cran2.png").getImage();
    Image cran3 = new ImageIcon("asset/crop/cran3.png").getImage();
    Image gar1 = new ImageIcon("asset/crop/garlic1.png").getImage();
    Image gar2 = new ImageIcon("asset/crop/garlic2.png").getImage();
    Image gar3 = new ImageIcon("asset/crop/garlic3.png").getImage();
    Image potato1 = new ImageIcon("asset/crop/potato1.png").getImage();
    Image potato2 = new ImageIcon("asset/crop/potato2.png").getImage();
    Image potato3 = new ImageIcon("asset/crop/potato3.png").getImage();
    Image current;
    int[] dx = new int[99999], dy = new int[99999], vetstage = new int[100000], countday = new int[10000], chanid = new int[10000], money = new int[100000], water = new int[100000], stage = new int[100000];
    int remove = 99999, count, money1;

    boolean removecheck = false, watercheck = false;

    public Image getimage(int index, int[] vet, int i) {
        chanid = vet;  
        if (chanid[i] == 0) {
            current = din;
        }
        if (chanid[i] == 1 && vetstage[i] == 1) {
            current = carrot1;

        }
        if (chanid[i] == 1 && vetstage[i] == 2) {
            current = carrot2;

        }
        if (chanid[i] == 1 && vetstage[i] == 3) {
            current = carrot3;

            stage[i] = 3;

        }
        if (chanid[i] == 1 && vetstage[i] > 3) {
            current = carrot3;

            stage[i] = 3;

        }
        if (chanid[i] == 2 && vetstage[i] == 1) {
            current = kalum1;

        }
        if (chanid[i] == 2 && vetstage[i] == 2) {
            current = kalum2;

        }
        if (chanid[i] == 2 && vetstage[i] == 3) {
            current = kalum3;

            stage[i] = 3;

        }
        if (chanid[i] == 2 && vetstage[i] > 3) {
            current = kalum3;

            stage[i] = 3;

        }
        if (chanid[i] == 3 && (vetstage[i] == 1 || vetstage[i] == 2)) {
            current = melon1;

        }
        if (chanid[i] == 3 && (vetstage[i] == 3 || vetstage[i] == 4)) {
            current = melon2;

        }
        if (chanid[i] == 3 && vetstage[i] == 5) {
            current = melon3;

            stage[i] = 3;

        }
        if (chanid[i] == 3 && vetstage[i] > 5) {
            current = melon3;

            stage[i] = 3;

        }
        if (chanid[i] == 4 && (vetstage[i] == 1)) {
            current = staw1;

        }
        if (chanid[i] == 4 && (vetstage[i] == 3 || vetstage[i] == 4 || vetstage[i] == 2)) {
            current = staw2;

        }
        if (chanid[i] == 4 && vetstage[i] == 5) {
            current = staw3;

            stage[i] = 3;

        }
        if (chanid[i] == 4 && vetstage[i] > 5) {
            current = staw3;

            stage[i] = 3;

        }
        if (chanid[i] == 5 && vetstage[i] == 1) {
            current = beet1;

        }
        if (chanid[i] == 5 && vetstage[i] == 2) {
            current = beet2;

        }
        if (chanid[i] == 5 && vetstage[i] >= 3) {
            current = beet3;

            stage[i] = 3;

        }
        if (chanid[i] == 6 && (vetstage[i] == 1 || vetstage[i] == 2)) {
            current = sweet1;

        }
        if (chanid[i] == 6 && (vetstage[i] == 3 || vetstage[i] == 4 || vetstage[i] == 5)) {
            current = sweet2;
            money[index] = 3;
        }
        if (chanid[i] == 6 && vetstage[i] >= 6) {
            current = sweet3;

            stage[i] = 3;

        }
        if (chanid[i] == 7 && vetstage[i] == 1) {
            current = radish1;

        }
        if (chanid[i] == 7 && vetstage[i] == 2) {
            current = radish2;

        }
        if (chanid[i] == 7 && vetstage[i] >= 3) {
            current = radish3;

            stage[i] = 3;

        }
        if (chanid[i] == 8 && (vetstage[i] == 1 || vetstage[i] == 2)) {
            current = cran1;

        }
        if (chanid[i] == 8 && (vetstage[i] == 3 || vetstage[i] == 4)) {
            current = cran2;

        }
        if (chanid[i] == 8 && vetstage[i] >= 5) {
            current = cran3;

            stage[i] = 3;

        }
        if (chanid[i] == 9 && (vetstage[i] == 1 || vetstage[i] == 2)) {
            current = gar1;

        }
        if (chanid[i] == 9 && (vetstage[i] == 3 || vetstage[i] == 4)) {
            current = gar2;

        }
        if (chanid[i] == 9 && vetstage[i] >= 5) {
            current = gar3;

            stage[i] = 3;

        }
        if (chanid[i] == 10 && vetstage[i] == 1) {
            current = potato1;

        }
        if (chanid[i] == 10 && (vetstage[i] == 2 || vetstage[i] == 3)) {
            current = potato2;

        }
        if (chanid[i] == 10 && vetstage[i] >= 4) {
            current = potato3;

            stage[i] = 3;

        }
        return current;
    }

    public void grow(int i) {
        for (int j = 0; i - 1 > j; j++) {
            vetstage[j] += 1;
            water[j] -= 1;
            if (water[j] == -2) {
                remove(9900, dx[j], dy[j]);
            }
        }
    }

    public void countday(int d) {
        count += 1;
    }

    public int getX(int i) {
        return dx[i];
    }

    public int getY(int i) {
        return dy[i];
    }

    public void setpositiondin(int index, int posX, int posY) {
        dx[0] = 1;
        dy[0] = 1;
        this.dx[index] = posX;
        this.dy[index] = posY;

    }

    public void setvet(int vet) {
        this.vetstage[vet] = 1;
    }

    public void removedin(int index, int posX, int posY) {
        removecheck = false;
        for (int j = index; j >= 0; j--) {
            if (posX == dx[j] && posY == dy[j]) {
                remove = j;
                removecheck = true;

            }
            if (j == remove) {
                dx[j] = 0;
                dy[j] = 0;
                if (stage[j] == 3) {
                    System.out.println(chanid[j]);
                    if(chanid[j] == 1){
                    money[j] = 10;
                    }
                    else if(chanid[j] == 2){
                    money[j] = 9;
                    }
                    else if(chanid[j] == 3){
                    money[j] = 17;
                    }
                    else if(chanid[j] == 4){
                    money[j] = 20;
                    }
                    else if(chanid[j] == 5){
                    money[j] = 5;
                    }
                    else if(chanid[j] == 6){
                    money[j] = 20;
                    }
                    else if(chanid[j] == 7){
                    money[j] = 5;
                    }
                    else if(chanid[j] == 8){
                    money[j] = 15;
                    }
                    else if(chanid[j] == 9){
                    money[j] = 12;
                    }
                    else if(chanid[j] == 10){
                    money[j] = 13;
                    }
                }
                chanid[j] = 999;
                setmoney(j);
                remove = 99999;
                removecheck = true;
            }

        }

    }

    public void remove(int index, int posX, int posY) {
        removecheck = false;
        for (int j = index; j >= 0; j--) {
            if (posX == dx[j] && posY == dy[j]) {
                remove = j;
                removecheck = true;

            }
            if (j == remove) {
                dx[j] = 0;
                dy[j] = 0;
                chanid[j] = 999;
                remove = 99999;
                removecheck = true;
            }

        }

    }

    public void setmoney(int i) {
        money1 += money[i];
    }

    public int getmoney(int i) {
        return money1;
    }

    public int getarrayx(int i) {
        return dx[i];
    }

    public int getarrayy(int i) {
        return dy[i];
    }

    public int getindexxy() {
        return dx.length;
    }

    public boolean removecheck() {
        return removecheck;
    }

    public void water(int index, int x, int y) {
        watercheck = false;
        for (int j = index; j >= 0; j--) {
            if (x == dx[j] && y == dy[j]) {
                water[j] = 1;
                watercheck = true;
            }
        }

    }

    public boolean getwatercheck() {
        return watercheck;
    }

    public int getwater(int index) {
        return water[index];
    }

    public void setwater(int i) {
        water[i] = 0;
    }

    public void whenrain(int index) {
        for (int j = index; j >= 0; j--) {
            water[j] = 1;
        }
    }
}
