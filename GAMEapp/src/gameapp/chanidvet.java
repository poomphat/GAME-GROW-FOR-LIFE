/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameapp;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Administrator
 */
public class chanidvet {

    private String[] chaniddisplay = new String[]{"Carrot", "Cabbage", "Melon", "Strawberry", "Beetroot", "Potato", "Rasish", "Cranberry", "Garlic", "Potato"};
    Image carrot = new ImageIcon("asset/crop/carrot.png").getImage();
    Image kalum = new ImageIcon("asset/crop/karlum.png").getImage();
    Image melon = new ImageIcon("asset/crop/melon.png").getImage();
    Image staw = new ImageIcon("asset/crop/staw.png").getImage();
    Image beet = new ImageIcon("asset/crop/beet.png").getImage();
    Image sweet = new ImageIcon("asset/crop/sweet.png").getImage();
    Image radish = new ImageIcon("asset/crop/radish.png").getImage();
    Image cranberry = new ImageIcon("asset/crop/cran.png").getImage();
    Image garlic = new ImageIcon("asset/crop/garlic.png").getImage();
    Image potato = new ImageIcon("asset/crop/potato.png").getImage();
    Image current;

    public String getchaniddis(int i) {
        return chaniddisplay[i];
    }

    public Image getimage(int i) {
        if (i == 1) {
            current = carrot;
        }
        if (i == 2) {
            current = kalum;
        }
        if (i == 3) {
            current = melon;
        }
        if (i == 4) {
            current = staw;
        }
        if (i == 5) {
            current = beet;
        }
        if (i == 6) {
            current = sweet;
        }
        if (i == 7) {
            current = radish;
        }
        if (i == 8) {
            current = cranberry;
        }
        if (i == 9) {
            current = garlic;
        }
        if (i == 10) {
            current = potato;
        }

        return current;
    }
}
