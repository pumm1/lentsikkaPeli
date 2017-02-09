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
     * @param ax
     * @param yy
     * @param w
     * @param h
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
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @return
     */
    public int getY() {
        return y;
    }

    /**
     *
     * @return
     */
    public int getLeveys() {
        return leveys;
    }

    /**
     *
     * @return
     */
    public int getKorkeus() {
        return korkeus;
    }

    ////kahden palasen osumisen logiikka////
    /**
     *
     * @param i
     * @return
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
     * @param i
     */
    public void liikuX(int i) {
        x += i;
    }

    /**
     *
     * @param j
     */
    public void liikuY(int j) {
        y += j;
    }

    //////palan piirtäminen///////
    //alustavasti hyödynnetään Javan Graphics-oliota pelin testaamiseen
    //pyritään käyttämään lopussa .png-kuvia
    //pala koostuu neliöstä, jonka vasen ylänurkka koordinaateissa (x,y) ja koko leveys*korkeus (voidaan tarvittaessa muuttaa)
    /**
     *
     * @param g
     */
    public void piirra(Graphics g) {
        g.fillRect(x, y, leveys, korkeus);

    }

}
