package sakureme.logiikka;

import java.awt.Graphics;

/**
 * Tässä luodaan pelin palojen (ja ns. 'hitboxien') logiikka
 */
public class Pala {

    private int x;
    private int y;
    private int leveys;
    private int korkeus;
    private int dy = 0;     //putoamista varten, kaikki palat eivät välttämättä liiku

    /**
     *
     * @param ax palan X-koordinaatti
     * @param yy palan Y-koordinaatti
     * @param w palan leveys
     * @param h palan korkeus
     */
    public Pala(int ax, int yy, int w, int h) {
        x = ax;
        y = yy;
        leveys = w;
        korkeus = h;
    }

    ////////////getterit///////////////
    /**
     *
     * @return palauta palan X-koordinaatti
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @return palauta palan Y-koodrinaattti
     */
    public int getY() {
        return y;
    }

    /**
     *
     * @return palauta palan leveys
     */
    public int getLeveys() {
        return leveys;
    }

    /**
     *
     * @return palauta palan leveys
     */
    public int getKorkeus() {
        return korkeus;
    }

    ////kahden palasen osumisen logiikka////
    /**
     *
     * @param i osuu tähän palaan?
     * @return palauta kysymyksen totuusarvo
     */
    public boolean osuuko(Pala i) {

        if (x + leveys >= i.getX() && x <= i.getX() + i.getLeveys()) {
            if (y + korkeus >= i.getY() && y <= i.getY() + i.getKorkeus()) {
                return true;
            }
        }

        return false;
    }

    /////palan liikukuminen////////////
    /**
     *
     * @param i liikuta palaa X-suunnassa tämän verran
     */
    public void liikuX(int i) {
        x += i;
    }

    /**
     *
     * @param j liikuta palaa Y-suunnassa tämän verran
     */
    public void liikuY(int j) {
        y += j;
    }

    //////palan piirtäminen///////
    //alustavasti hyödynnetään Javan Graphics-oliota pelin testaamiseen
    //pala koostuu neliöstä, jonka vasen ylänurkka koordinaateissa (x,y) ja koko leveys*korkeus (voidaan tarvittaessa muuttaa)
    /**
     *
     * @param g piirrä pala Javan Graphics-oliolla
     */
    public void piirra(Graphics g) {
        g.fillRect(x, y, leveys, korkeus);

    }

}
