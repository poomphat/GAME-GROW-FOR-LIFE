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
    Image current;
    int[] dx = new int[9999], dy = new int[9999], ddx = new int[10000], ddy = new int[10000],vetstage = new int[10000],countday = new int[10000];
    int remove,count;

    public Image getimage(int[] vet,int i) {
        if(vet[i] == 0){
            current = din;
        }
        if(vet[i] == 1 && vetstage[i] == 1){
            current = carrot1;
        }
        if(vet[i] == 1 && vetstage[i] == 2){
            current = carrot2;
        }
        if(vet[i] == 1 && vetstage[i] == 3){
            current = carrot3;
        }
        return current;
    }
    public void grow(){
         for (int j = 0; vetstage.length-1 > j; j++) {
             vetstage[j] += 1;
         }
    }
    public void countday(int d){
        count += 1;
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
    public void setvet(int vet) {
        this.vetstage[vet] = 1;
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
