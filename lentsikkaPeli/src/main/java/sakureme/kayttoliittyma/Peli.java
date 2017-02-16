/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sakureme.kayttoliittyma;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.SwingUtilities;
import sakureme.logiikka.Hahmo;
import sakureme.logiikka.Lintu;
import sakureme.logiikka.Pala;
import sakureme.logiikka.Pelaaja;
import sakureme.logiikka.Puu;

/**
 * Peli-luokalla tehdään Main-luokasta siistimpi, alustamalla tarvittavat oliot
 * täällä käynnistystä varten
 */
public class Peli {

    private Kayttoliittyma kayttis;
    private Random rand = new Random();

    public Peli() {

        kayttis = new Kayttoliittyma();
    }

    //luodaan hahmot ja asetetaan ne paikalleen
    public void alustaHahmot() {
        int x = arvoX();
        int y = arvoPuuY();
        Puu puu1 = new Puu(x, y, 100, 350);
        x = arvoX() + arvoX() + arvoX();
        y = arvoPuuY();
        Puu puu2 = new Puu(x, y, 100, 350);
        x = arvoX() + arvoX();
        y = arvoPuuY();
        Puu puu3 = new Puu(x, y, 100, 350);
        puu1.lataaKuva();
        puu2.lataaKuva();
        puu3.lataaKuva();

        x = arvoX();
        y = arvoLintuY();
        Lintu tirppa = new Lintu(x, y, 60, 60);
        tirppa.lataaKuva();

        x = arvoX() + arvoX();
        y = arvoLintuY();
        Lintu pulu = new Lintu(x, y, 60, 60);
        pulu.lataaKuva();

//        List<Pala> palat = new ArrayList<>();
        List<Hahmo> hahmot = new ArrayList<>();

        x = rand.nextInt(500) + 200;
        y = rand.nextInt(250) + 100;

        //luodaan pelattava hahmo
        List<Pala> hahmoPalat = new ArrayList<>();
        hahmoPalat.add(new Pala(50, 50, 20, 20));
        hahmoPalat.add(new Pala(50, 70, 100, 20));
        hahmoPalat.add(new Pala(120, 60, 20, 20));

        Pelaaja pelaaja = new Pelaaja(hahmoPalat);
        pelaaja.setPutoavuus(true);
        pelaaja.lataaKuva();

        hahmot.add(puu1);
        hahmot.add(puu2);
        hahmot.add(puu3);
        hahmot.add(tirppa);
        hahmot.add(pulu);
        hahmot.add(pelaaja);

        kayttis.lisaaHahmot(hahmot);
        kayttis.setPelattavaHahmo(pelaaja);
    }

    public int arvoX() {
        int x = rand.nextInt(800) + 400;
        return x;
    }

    public int arvoPuuY() {
        int y = rand.nextInt(100) + 250;
        return y;
    }

    public int arvoLintuY() {
        int y = rand.nextInt(100) + 10;
        return y;
    }

    public void aloita() {
        SwingUtilities.invokeLater(kayttis);
    }

}
