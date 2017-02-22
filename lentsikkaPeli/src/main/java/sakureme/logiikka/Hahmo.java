package sakureme.logiikka;

import java.awt.Graphics;
import java.util.*;

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
     * @param x hahmon X-koordinaatti
     * @param y hahmon Y-koordinaatti
     * @param w hahmon leveys
     * @param h hahmon korkeus
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
     * @param i palat, joista hahmo koostuu
     */
    public Hahmo(List<Pala> i) {
        dx = -5;
        palat = i;
    }

    /////getterit & setterit////////
    /**
     *
     * @param i pelattava-muuttujan arvo
     */
    public void setPelattavuus(boolean i) {
        pelattava = i;
    }

    /**
     *
     * @return palautetaan pelattavuuden arvo
     */
    public boolean getPelattavuus() {
        return pelattava;
    }

    /**
     *
     * @return palautetaan muuttuja dy
     */
    public int getDy() {
        return dy;
    }

    /**
     *
     * @return palautetaan muuttuja putoaa
     */
    public boolean getPutoaa() {
        return putoaa;
    }

    /**
     *
     * @return palautetaan hahmon palat
     */
    public List<Pala> getPalat() {
        return palat;
    }

    ///palojen lisäys//
    /**
     *
     * @param i lisätään hahmolle pala
     */
    public void lisaaPala(Pala i) {
        palat.add(i);
    }

    /**
     *
     * @param p lisätään hahmolle lista paloja
     */
    public void lisaaPaloja(List<Pala> p) {
        for (Pala i : p) {
            palat.add(i);
        }
    }

    /**
     * koordinaatisto "väärinpäin", joten hypyssä suunta negatiivinen
     */
    public void hyppaa() {
        dy = -7;
    }

    /**
     *
     * @param i asetetaan putoavuuden arvo
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

    /**
     *
     * @param i osuu this.hahmo?
     * @return totuusarvo kysymykselle
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

    /**
     * hahmon palojen liikuttelu x-suunnassa
     *
     * @param a liikuta paloja X-suunnassa tämän verran
     */
    public void liikuX(int a) {
        for (Pala i : palat) {
            i.liikuX(a);
        }
    }

    /**
     * hahmon palojen liikuttelu y-suunnassa
     *
     * @param a liikuta paloja Y-suunnassa tämän verran
     */
    public void liikuY(int a) {
        for (Pala i : palat) {
            i.liikuY(a);
        }
    }

    /**
     * yhdistetään putoaminen ja liikkuminen
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

    public void siirraUuteenPaikkaan() {
        //tämä korvattu kaikissa muissa
    }

    /**
     * @param g hyödynnetään Javan Graphics-oliota
     */
    public void piirraPalat(Graphics g) {
        //toteutus korvattu muissa
    }
}
