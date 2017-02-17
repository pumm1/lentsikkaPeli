/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sakureme.logiikka;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;

/**
 * Lintu-luokka, uhka ilmassa!
 */
/**
 *
 * @author Sagu
 */
public class Lintu extends Hahmo {

    private Image kuva;
    private boolean ladattu;
    private boolean suunta;

    /**
     *
     * @param x linnun x-koordinaatti
     * @param y linnnu y-koordinaatti
     * @param w linnun leveys
     * @param h linnun korkeus
     */
    public Lintu(int x, int y, int w, int h) {
        super(x, y, w, h);
        int i = rand.nextInt(2);
        if (i == 0) {
            suunta = true;
            dy = rand.nextInt(4);
        } else {
            suunta = false;
            dy = rand.nextInt(4) * (-1);
        }
    }

    public void lataaKuva() {
        File tirppaTiedosto = new File("src/tirppa.png");
        kuva = new ImageIcon(tirppaTiedosto.getAbsolutePath()).getImage();

        if (kuva != null) {
            ladattu = true;
        }
    }

    /**
     * muutetaan liikkuminen niin, että lintu liikkuu ilmassa arvaamattomammin
     */
    @Override
    public void liiku() {

        this.liikuX(dx);
        this.liikuY(dy);
        if (suunta) {
            if (dy >= 5) {
                suunta = false;
            } else {
                dy++;
            }
        } else {
            if (dy <= -5) {
                suunta = true;
            } else {
                dy--;
            }
        }

    }

    @Override
    public void siirraUuteenPaikkaan() {
        dx = rand.nextInt(10) + 6;
        dx = dx * (-1);
        int y = rand.nextInt(40) + 60;
        if (palat.get(0).getY() >= 100) {   //estetään linnun meno liian alas
            y = y * (-1);
        }
        if (y < 0) {
            y = 0 + rand.nextInt(15);
        }
        this.liikuY(y);
        int tempX = rand.nextInt(500) + 1200 + rand.nextInt(400) + rand.nextInt(200);
        this.liikuX(tempX);
    }

    @Override
    public void piirraPalat(Graphics g) {
        if (ladattu) {
            int x = this.getPalat().get(0).getX();
            int y = this.getPalat().get(0).getY();
            g.drawImage(kuva, x, y, null);
        } else {
            for (Pala i : palat) {
                i.piirra(g);
            }
        }
    }

}
