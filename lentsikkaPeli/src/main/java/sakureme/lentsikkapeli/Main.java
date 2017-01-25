/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sakureme.lentsikkapeli;

import sakureme.logiikka.Hahmo;
import sakureme.logiikka.Pala;
import java.util.*;

public class Main {

    /*
    Ohjelman käynnistys täältä
     */
    public static void main(String[] args) {
        Pala p1 = new Pala(50, 10, 10, 10);
        Pala p2 = new Pala(20, 10, 10, 10);
        Pala p3 = new Pala(10, 20, 10, 10);
        List<Pala> palat = new ArrayList<>();
        palat.add(p1);
        palat.add(p2);
        palat.add(p3);
        
        Hahmo hahmo1 = new Hahmo(palat);
        Hahmo hahmo2 = new Hahmo(50, 20, 10 ,10);
//        hahmo1.liikuX(50);
        palat = hahmo1.getPalat();
        
        for (Pala i : palat){
            int x = i.getX();
            int y = i.getY();
            System.out.println(x + ", " + y);
        }

    }

}
