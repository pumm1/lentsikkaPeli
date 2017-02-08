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
import sakureme.logiikka.Pala;

/**
Peli-luokalla tehdään Main-luokasta siistimpi, alustamalla tarvittavat oliot täällä käynnistystä varten
 */
public class Peli {

    private Kayttoliittyma kayttis;
    private Random rand = new Random();

    public Peli() {

        kayttis = new Kayttoliittyma();
    }

    //luodaan hahmot ja asetetaan ne paikalleen
    public void alustaHahmot() {
        int x = rand.nextInt(300) + 200;
        int y;
        Pala p1 = new Pala(x, 300, 60, 200);    //olevinaan puu/tolppa
        List<Pala> palat = new ArrayList<>();
        List<Hahmo> hahmot = new ArrayList<>();
        palat.add(p1);

        Hahmo h1 = new Hahmo(palat);
        x = rand.nextInt(500) + 200;
        y = rand.nextInt(250) + 100;
        Pala p2 = new Pala(x, y, 60, 60);

        List<Pala> palat1 = new ArrayList<>();
        palat1.add(p2);

        Hahmo pelaaja = new Hahmo(50, 50, 20, 20);
        pelaaja.lisaaPala(new Pala(50, 70, 100, 20));
        pelaaja.lisaaPala(new Pala(120, 60, 20, 20));
        Hahmo h2 = new Hahmo(palat1);
        x = rand.nextInt(800) + 200;
        Hahmo h3 = new Hahmo(x, 300, 50, 400);
        x = rand.nextInt(700) + 200;
        Hahmo h4 = new Hahmo(x, 100, 100, 60);
        
        pelaaja.setPutoavuus(true);

        hahmot.add(h1);
        hahmot.add(pelaaja);
        hahmot.add(h2);
        hahmot.add(h3);
        hahmot.add(h4);

        kayttis.lisaaHahmot(hahmot);
        kayttis.setPelattavaHahmo(pelaaja);
    }

    public void aloita() {
        SwingUtilities.invokeLater(kayttis);
    }

}
