/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sakureme.logiikka;

import java.util.ArrayList;
import java.util.List;

/**
 * Pelaaja-luokka, tässä luodaan (kuten nimikin kertoo) hahmo, jolla pelataan.
 */
public class Pelaaja extends Hahmo {

    //konstruktori saa parametreina palat, jotka muodostavat lentokoneen
    public Pelaaja(List<Pala> i) {
        super(i);
    }

    //ei mahdollisteta sitä, että pelaaja huijaa pysymällä palikoiden ulottumattomissa!
    public boolean peliAlueenSisalla() {
        if (this.getPalat().get(0).getY() < -10) {
            
            return false;
        } else if (this.getPalat().get(0).getY() > 420) {
            System.out.println("död");
            return false;
        }
        return true;
    }

}
