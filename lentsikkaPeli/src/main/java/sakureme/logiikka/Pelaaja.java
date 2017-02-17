/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sakureme.logiikka;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

/**
 * Pelaaja-luokka, tässä luodaan (kuten nimikin kertoo) hahmo, jolla pelataan.
 */
public class Pelaaja extends Hahmo {

    private Image kuva;
    private boolean ladattu;

    /**
     * konstruktori saa parametreina palat, jotka muodostavat lentokoneen
     *
     * @param i lista pelaajan paloista
     */
    public Pelaaja(List<Pala> i) {
        super(i);
        ladattu = false;
    }

    /**
     * ei mahdollisteta sitä, että pelaaja huijaa pysymällä palikoiden
     * ulottumattomissa!
     *
     * @return
     */
    public boolean peliAlueenSisalla() {
        if (this.getPalat().get(0).getY() < -10) {
            return false;
        } else if (this.getPalat().get(0).getY() > 420) {
            return false;
        }
        return true;
    }

    /**
     * ladataan pelaajan .png-kuva
     */
    public void lataaKuva() {
        //"D:\\Projekstit\\lentsikkaPeli\\lentsikkaPeli\\src\\lentsikka.png" <- talteen varalle
        //seuraavan avulla kaikilla koodin omaavilla pitäisi kuvien näkyä
        File lentsikkaTiedosto = new File("src/lentsikka.png");
//        System.out.println(file.getAbsolutePath());
        kuva = new ImageIcon(lentsikkaTiedosto.getAbsolutePath()).getImage();

        //varmennetaan vielä, että jos jokin menee pieleen, niin käytetään palikkagrafiikkaa
        if (kuva != null) {
            ladattu = true;
        }
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
