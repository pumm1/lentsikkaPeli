/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sakureme.kayttoliittyma;

import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingUtilities;
import sakureme.logiikka.Hahmo;
import sakureme.logiikka.Pala;

/*
Peli-luokalla tehdään Main-luokasta siistimpi, alustamalla tarvittavat oliot täällä käynnistystä varten
 */
public class Peli {

    private Kayttoliittyma kayttis;

    public Peli() {

        kayttis = new Kayttoliittyma();
    }

    public void alustaHahmot() {
        Pala p1 = new Pala(500, 250, 60, 200);
        List<Pala> palat = new ArrayList<>();
        List<Hahmo> hahmot = new ArrayList<>();
        palat.add(p1);

        Hahmo h1 = new Hahmo(palat);
        Pala p2 = new Pala(600, 100, 60, 60);
        
        List<Pala> palat1 = new ArrayList<>();
        palat1.add(p2);
        
        Hahmo h2 = new Hahmo(50, 50, 20, 20);
        h2.lisaaPala(new Pala(50, 70, 100, 20));
        h2.lisaaPala(new Pala(120, 60, 20, 20));
        Hahmo h3 = new Hahmo(palat1);
        
        h2.setPutoavuus(true);
        hahmot.add(h1);
        hahmot.add(h2);
        hahmot.add(h3);
        
        kayttis.lisaaHahmot(hahmot);
        kayttis.setPelattavaHahmo(h2);
    }

    public void aloita() {
        SwingUtilities.invokeLater(kayttis);
    }

}
