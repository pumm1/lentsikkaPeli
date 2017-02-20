/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sakureme.logiikka;

import java.awt.Font;
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

    private List<String> loput; //lista mahdollisista game over-teksteistä
    private Image kuva;
    private boolean ladattu;
    private boolean elossa = true;
    private long alku;
    private long loppu;
    private int aika;
    private int sec; //sekunnit
    private int msec; //millisekunnit
    private String gameOver;

    /**
     * konstruktori saa parametreina palat, jotka muodostavat lentokoneen
     *
     * @param i lista pelaajan paloista
     */
    public Pelaaja(List<Pala> i) {
        super(i);
        ladattu = false;
        alku = System.currentTimeMillis();
        loput = new ArrayList<>();
        String g0 = "Hävisit pelin";
        String g1 = "Nyt tuli noutaja!";
        String g2 = "Niinpä tietysti.";
        String g3 = "GAME OVER";
        String g4 = "Sattuko pahasti?";
        loput.add(g0);
        loput.add(g1);
        loput.add(g2);
        loput.add(g3);
        loput.add(g4);
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

    public boolean getElossa() {
        return elossa;
    }

    public void kuolee() {  // rip :(
        elossa = false;
        loppu = System.currentTimeMillis();
        long temp = loppu - alku;
        aika = (int) temp;
        msec = aika % 1000;
        sec = (aika - msec) / 1000;
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
        if (!elossa) {      //annetaan selkeämpi merkki pelaajalle pelin päättymisestä
            String s = Integer.toString(sec);
            String ms = Integer.toString(msec);
            if (gameOver == null) {
                int i = rand.nextInt(loput.size());
                gameOver = loput.get(i);
            }
            String time = "Aika: " + sec + "," + msec + "s";
            g.setFont(new Font("Arial", Font.PLAIN, 40));
            g.drawString(gameOver, 180, 200);
            g.drawString(time, 180, 250);
        }
    }

}
