package sakureme.logiikka;

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
        hahmo2 = new Hahmo(31, 20, 10, 10);

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
            if (i.getX() == 31 && i.getY() == 20) {
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
                if (c == 1) {
                    oikein = false;
                    break;
                } else {
                    c++;
                    oikein = true;
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

        assertEquals(true, oikein); //hahmo1:n oikeellisuus
    }

    //testi 11
    @Test
    public void hahmonOsumaTunnistetaan() {
        boolean osuma = hahmo2.osuu(hahmo1);
        assertEquals(false, osuma);     //hahmojen ei pitäisi osua aloituspaikoillaan

        hahmo2.liikuX(-1);

        osuma = hahmo2.osuu(hahmo1);
        assertEquals(true, osuma);  //hahmojen pitäisi osua

        hahmo2.liikuY(1);   //irrotetaan y-suunnassa
        osuma = hahmo2.osuu(hahmo1);
        assertEquals(false, osuma);

        hahmo2.liikuX(-9);
        osuma = hahmo2.osuu(hahmo1);    //rajalle, ei osu
        assertEquals(false, osuma);

        hahmo2.liikuX(-1);
        osuma = hahmo2.osuu(hahmo1);
        assertEquals(true, osuma);
    }

    //testi12
    @Test
    public void palanLisaaminenToimii() {
        hahmo1.lisaaPala(new Pala(40, 40, 10, 10));
        int p1 = hahmo1.getPalat().size();
        assertEquals(4, p1); //paloja pitäisi olla 4

        hahmo2.lisaaPala(new Pala(30, 30, 30, 30));
        hahmo2.lisaaPala(new Pala(90, 90, 10, 10));
        int p2 = hahmo2.getPalat().size();
        assertEquals(3, p2);    //paloja pitäisi olla 3
    }

    //testi13
    @Test
    public void palojenLisaaminenToimii() {
        Pala p1 = new Pala(50, 50, 30, 30);
        Pala p2 = new Pala(40, 40, 30, 30);
        Pala p3 = new Pala(90, 90, 10, 10);
        List<Pala> palat = new ArrayList<>();
        palat.add(p1);
        palat.add(p2);
        palat.add(p3);

        hahmo1.lisaaPaloja(palat);
        int p = hahmo1.getPalat().size();
        assertEquals(6, p);     //paloja 3 + 3

        Pala p4 = new Pala(10, 60, 10, 10);
        palat.add(p4);
        hahmo2.lisaaPaloja(palat);
        p = hahmo2.getPalat().size();
        assertEquals(5, p);     //paloja  1 + 4
    }

    //testi14
    @Test
    public void hahmonPutoaminenToimii() {
        boolean putoaa = hahmo2.getPutoaa();
        assertEquals(false, putoaa);        //oletuksena ei putoa

        hahmo2.setPutoavuus(true);
        putoaa = hahmo2.getPutoaa();
        assertEquals(true, putoaa);

        hahmo2.putoa();
        List<Pala> palat = hahmo2.getPalat();

        int x = palat.get(0).getX();
        int y = palat.get(0).getY();

        assertEquals(31, x);        //eka putoaminen ei vielä muuta koordinaatteja alkkuperäiseen, koska dy = 0
        assertEquals(20, y);

        hahmo2.putoa();
        hahmo2.putoa();

        palat = hahmo2.getPalat();
        x = palat.get(0).getX();
        y = palat.get(0).getY();

        assertEquals(31, x);
        assertEquals(23, y);

        hahmo2.putoa();
        hahmo2.putoa();
        hahmo2.putoa();     //dy saavuttaa maksiminsa
        hahmo2.putoa();

        palat = hahmo2.getPalat();

        x = palat.get(0).getX();
        y = palat.get(0).getY();

        assertEquals(31, x);
        assertEquals(40, y);

        hahmo2.setPutoavuus(false);

        hahmo2.putoa();
        x = palat.get(0).getX();
        y = palat.get(0).getY();

        assertEquals(31, x);
        assertEquals(40, y);

    }

    //testi15
    @Test
    public void hahmonHyppaaminenToimii() {
        hahmo2.setPutoavuus(true);
        int dy = hahmo2.getDy();
        assertEquals(0, dy);
        hahmo2.hyppaa();

        dy = hahmo2.getDy();
        assertEquals(-7, dy);
        hahmo2.putoa();
        hahmo2.putoa();
        dy = hahmo2.getDy();
        assertEquals(-5, dy);
        for (int i = 0; i < 20; i++) {
            hahmo2.putoa();
        }
        dy = hahmo2.getDy();

        assertEquals(5, dy);
    }
}
