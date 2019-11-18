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
    int[] dx = new int[9999], dy = new int[9999], ddx = new int[10000], ddy = new int[10000];
    int remove;

    public Image getimage() {
        return din;
    }

    public int getX(int i) {
        return dx[i];
    }

    public int getY(int i) {
        return dy[i];
    }

    public void setpositiondinX(int index, int posX) {
        this.dx[index] = posX;

    }

    public void setpositiondinY(int index, int posY) {
        this.dy[index] = posY;
    }

    public void removedin(int posX, int posY) {
        for (int j = 0 ,k = 0; dx.length-1 > j; j++) {
            if (posX == dx[j] && posY == dy[j]) {
                remove = j;
            }
            if (j == remove){
                dx[j] = dx[j+1];
                dy[j] = dy[j+1];
            } 
       

            

        }
    }
}
