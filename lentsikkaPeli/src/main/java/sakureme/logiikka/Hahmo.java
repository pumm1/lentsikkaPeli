package sakureme.logiikka;

import java.awt.Graphics;
import java.util.*;

/**
 *
 * @author Sagu
 */
public class Hahmo {

    /**
     * Tässä luodaan pelin hahmojen logiikka
     */
    protected List<Pala> palat;   //käytetään paloja hahmon 'hitboxia' varten
    protected int dy; //putoaminen tai hyppääminen
    protected int dx; //liikkuminen
    protected boolean putoaa;
    private boolean pelattava = false;
    protected Random rand = new Random();

    /**
     *
     * @param x
     * @param y
     * @param w
     * @param h
     */
    public Hahmo(int x, int y, int w, int h) {  //konstruktori hahmolle, jolle ei anneta listaa paloista
        Pala eka = new Pala(x, y, w, h);
        palat = new ArrayList<>();
        palat.add(eka);
        dy = 0;
        putoaa = false;
        dx = -5;
    }

    //konstruktori hahmolle, jolle annetaan heti kaikki palat
    /**
     *
     * @param i
     */
    public Hahmo(List<Pala> i) {
        dx = -5;
        palat = i;
    }

    /////getterit & setterit////////
    /**
     *
     * @param i
     */
    public void setPelattavuus(boolean i) {
        pelattava = i;
    }

    /**
     *
     * @return
     */
    public boolean getPelattavuus() {
        return pelattava;
    }

    /**
     *
     * @return
     */
    public int getDy() {
        return dy;
    }

    /**
     *
     * @return
     */
    public boolean getPutoaa() {
        return putoaa;
    }

    /**
     *
     * @return
     */
    public List<Pala> getPalat() {

        return palat;
    }

    ///palojen lisäys//
    /**
     *
     * @param i
     */
    public void lisaaPala(Pala i) {

        palat.add(i);
    }

    /**
     *
     * @param p
     */
    public void lisaaPaloja(List<Pala> p) {

        for (Pala i : p) {
            palat.add(i);
        }
    }

    ///////hahmon logiikka////////
    //koordinaatisto "väärinpäin", joten hypyssä suunta negatiivinen
    /**
     *
     */
    public void hyppaa() {
        dy = -7;
    }

    /**
     *
     * @param i
     */
    public void setPutoavuus(boolean i) {
        putoaa = i;
        dx = 0;
    }

    /**
     *
     */
    public void putoa() {

        if (putoaa) {   //turhaan toteuttaa ylimääräistä työtä, jos hahmoa ei ole määritelty putoavaksi
            for (Pala i : palat) {
                i.liikuY(dy);
            }
            if (dy < 5) {
                dy++;
            }
        }
    }

    //tarkistetaan, osuuko Hahmo toiseen hahmoon
    /**
     *
     * @param i
     * @return
     */
    public boolean osuu(Hahmo i) {

        List<Pala> kohde = i.getPalat();

        for (Pala a : palat) {
            for (Pala b : kohde) {
                if (a.osuuko(b)) {       //pala a osuu palaan b
                    return true;
                }
            }
        }

        return false;
    }

    //hahmon palojen liikuttelu x-suunnassa
    /**
     *
     * @param a
     */
    public void liikuX(int a) {

        for (Pala i : palat) {
            i.liikuX(a);
        }
    }

    //hahmon palojen liikuttelu y-suunnassa
    /**
     *
     * @param a
     */
    public void liikuY(int a) {

        for (Pala i : palat) {
            i.liikuY(a);
        }
    }

    //yhdistetään putoaminen ja liikkuminen
    /**
     *
     */
    public void liiku() {
        if (putoaa) {
            for (Pala i : palat) {
                i.liikuY(dy);
            }
            if (dy < 5) {
                dy++;
            }
        }
        this.liikuX(dx);
    }

    /**
     * ei tarvitse testata, koska hyödynnetään vain liikuX ja liikuY ja arvotaan
     * uusi paikka tätä mahdollisesti muokataan, koska tämä ei huomioi esteen
     * "tyyppiä" (puu/tolppa, lintu...) käytetään, kun hahmo menee kentän
     * reunojen yli ja se "respwnaa" tulevaisuudessa pyritään tekemään
     * jokaiselle hahmotyypille oma luokka, joka perii Hahmo-luokan
     */
    public void siirraUuteenPaikkaan() {
        dx = rand.nextInt(5) + 4;
        dx = dx * (-1);
        int y = rand.nextInt(100) + 100;
        if (palat.get(0).getY() >= 300) {   //ei siirretä alas, jos menee kentästä ulos
            int kerroin = rand.nextInt(2);  //määrää sen, liikutetaanko hahmoa ylös vai alas
            if (kerroin == 0) {
                y = y * (-1);
            }
        }
        this.liikuY(y);
        int tempX = rand.nextInt(1000) + 800;  //liikutetaan x-suunnassa uudelleen esteeksi
        this.liikuX(tempX);
    }

    //piirretään hahmon palat
    //myöhemmässä vaiheessa tämä pyritään korvaamaan hahmon .png-kuvan piirtämisellä
    /**
     *
     * @param g
     */
    public void piirraPalat(Graphics g) {

        for (Pala i : palat) {
            i.piirra(g);
        }
    }

}
