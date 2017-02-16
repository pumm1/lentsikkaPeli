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

    /**
     * Ohjelman käynnistys täältä
     */
    public static void main(String[] args) {

        Peli peli = new Peli();
        peli.alustaHahmot();
        peli.aloita();
    }

}
