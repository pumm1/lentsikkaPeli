/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sakureme.logiikka.Hahmo;
import sakureme.logiikka.Pala;

/*
Hahmo-luokan testaus
 */
public class HahmoTest {

    Hahmo hahmo1;
    Hahmo hahmo2;

    @Before
    public void setUp() {
        Pala p1 = new Pala(10, 10, 10, 10);     // (10, 10) <--alkup.
        Pala p2 = new Pala(20, 10, 10, 10);
        Pala p3 = new Pala(10, 20, 10, 10);
        List<Pala> palat = new ArrayList<>();
        palat.add(p1);
        palat.add(p2);
        palat.add(p3);

        hahmo1 = new Hahmo(palat);
        hahmo2 = new Hahmo(50, 20, 10, 10);

    }

    //testi9
    @Test
    public void konstruktoriAsettaaPalikatOikein() {
        List<Pala> palat = hahmo1.getPalat();
        boolean oikein = false; //totuusarvo, täyttyykö palojen oikeellisuus
        int a = 0;  //3 apumuuttujaa, joilla varmistetaan, että kaikki 3 palaa testataan
        int b = 0;
        int c = 0;
        for (Pala i : palat) {
            int x = i.getX();
            int y = i.getY();

            if (x == 10 && y == 10) {
                oikein = true;
                if (a == 1) {
                    oikein = false;
                    break;
                } else {
                    a++;
                }
            } else if (x == 20 && y == 10) {
                oikein = true;
                if (b == 1) {
                    oikein = false;
                    break;
                } else {
                    oikein = true;
                    b++;
                }
            } else if (x == 10 && y == 20) {
                oikein = true;
                if (c == 1) {
                    oikein = false;
                    break;
                } else {
                    oikein = true;
                    c++;
                }
            } else {
                oikein = false;
                break;
            }
        }

        if (a == 1 && b == 1 && c == 1) {
            oikein = true;
        } else {
            oikein = false;
        }

        assertEquals(true, oikein); //hahmo1:n palikoiden oikeellisuus

        oikein = false;
        palat = hahmo2.getPalat();
        a = 0;          //varmistetaan, ettei hahmo2 sisällä ylimääräisiä paloja

        for (Pala i : palat) {
            if (i.getX() == 50 && i.getY() == 20) {
                oikein = true;
                if (a == 1) {
                    oikein = false;
                    break;
                } else {
                    a++;
                    oikein = true;
                }
            } else {
                oikein = false;
                break;
            }
        }

        if (a == 1) {
            oikein = true;
        } else {
            oikein = false;
        }

        assertEquals(true, oikein);     //hahmo2:n oikeellisuus

    }

    //testi10
    @Test
    public void hahmonLiikkuminenXToimii() {
        hahmo1.liikuX(10);
        boolean oikein = false;
        int a = 0;      //varmistetaan, että kaikki palat liikkuvat vain kerran
        int b = 0;
        int c = 0;

        List<Pala> palat = hahmo1.getPalat();

        for (Pala i : palat) {
            int x = i.getX();
            int y = i.getY();
            if (x == 20 && y == 10) {
                if (a == 1) {
                    oikein = false;
                    break;
                } else {
                    oikein = true;
                    a++;
                }
            } else if (x == 30 && y == 10) {
                if (b == 1) {
                    oikein = false;
                    break;
                } else {
                    b++;
                    oikein = true;
                }
            } else if (x == 20 && y == 20) {
                if (c == 1){
                    oikein = false;
                    break;
                }else{
                    c++;
                    oikein = true;
                }
            }else{
                oikein = false;
                break;
            }
        }
        
        if (a == 1 && b == 1 && c == 1){
            oikein = true;
        }else{
            oikein = false;
        }

        assertEquals(true, oikein); //hahmo1:n oikeellisuus
    }
}
