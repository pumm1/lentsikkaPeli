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
        int x = rand.nextInt(300) + 200;
        int y;
        Puu puu1 = new Puu(400, 250, 100, 350);   //olevinaan puu/tolppa
        Puu puu2 = new Puu(750, 200, 100, 350);
        Puu puu3 = new Puu(1100, 230, 100, 350);
        puu1.lataaKuva();
        puu2.lataaKuva();
        puu3.lataaKuva();
        
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
        hahmot.add(pelaaja);
        hahmot.add(puu3);

        kayttis.lisaaHahmot(hahmot);
        kayttis.setPelattavaHahmo(pelaaja);
    }

    public void aloita() {
        SwingUtilities.invokeLater(kayttis);
    }

}
