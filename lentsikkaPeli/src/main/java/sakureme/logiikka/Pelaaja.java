/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sakureme.logiikka;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

/**
 * Pelaaja-luokka, tässä luodaan (kuten nimikin kertoo) hahmo, jolla pelataan.
 */
public class Pelaaja extends Hahmo {

    private Image kuva;
    private boolean ladattu;

    //konstruktori saa parametreina palat, jotka muodostavat lentokoneen
    public Pelaaja(List<Pala> i) {
        super(i);
        ladattu = false;
    }

    //ei mahdollisteta sitä, että pelaaja huijaa pysymällä palikoiden ulottumattomissa!
    public boolean peliAlueenSisalla() {
        if (this.getPalat().get(0).getY() < -10) {
            return false;
        } else if (this.getPalat().get(0).getY() > 420) {
            return false;
        }
        return true;
    }

    public void lataaKuva() {
        kuva = new ImageIcon("D:\\Projekstit\\lentsikkaPeli\\lentsikkaPeli\\src\\lentsikka.png").getImage();
        ladattu = true;
    }

    @Override
    public void piirraPalat(Graphics g) {
        if (ladattu) {
            int x = this.getPalat().get(0).getX();
            int y = this.getPalat().get(0).getY();
            g.drawImage(kuva, x, y, null);
        } else {
            for (Pala i : palat) {
                i.piirra(g);
            }
        }
    }

}
