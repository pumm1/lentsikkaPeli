/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sakureme.lentsikkapeli;

import sakureme.logiikka.Hahmo;
import sakureme.logiikka.Pala;
import java.util.*;
import javax.swing.SwingUtilities;
import sakureme.kayttoliittyma.Kayttoliittyma;
import sakureme.kayttoliittyma.Peli;

public class Main {

    /*
    Ohjelman käynnistys täältä
     */
    public static void main(String[] args) {

        Peli peli = new Peli();
        peli.alustaHahmot();
        peli.aloita();
//        Kayttoliittyma kayttis = new Kayttoliittyma();
//        
//
//        Pala p1 = new Pala(20, 20, 10, 10);
//        Pala p2 = new Pala(20, 30, 10, 10);
//        Pala p3 = new Pala(30, 30, 10, 10);
//        List<Pala> palat = new ArrayList<>();
//        List<Hahmo> hahmot = new ArrayList<>();
//        palat.add(p1);
//        palat.add(p2);
//        palat.add(p3);
//
//        Hahmo h1 = new Hahmo(palat);
//        Hahmo h2 = new Hahmo(60, 60, 10, 10);
//        hahmot.add(h1);
//        hahmot.add(h2);
//        h2.setPutoavuus(true);
//        kayttis.setPelattavaHahmo(h2);
//        kayttis.lisaaHahmot(hahmot);
//        SwingUtilities.invokeLater(kayttis);

    }

}
