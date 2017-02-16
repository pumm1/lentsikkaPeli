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

/*
    Tälle luokalle ei tehdä alustavasti testejä, koska on käytännössä Hahmo-luokka
 */
/**
 *
 * @author Sagu
 */
public class Puu extends Hahmo {

    private Image kuva;
    private boolean ladattu;

    /**
     *
     * @param x
     * @param y
     * @param w
     * @param h
     */
    public Puu(int x, int y, int w, int h) {
        super(x, y, w, h);
        this.dx = (rand.nextInt(5) + 3) * (-1);
        ladattu = false;
    }

    /**
     *
     */
    public void lataaKuva() {
        //saadaan puun kvua hienosti käyttöön riippumatta siitä, minne kansiot sijoitettu koneella
        File puuTiedosto = new File("src/puu.png");
        kuva = new ImageIcon(puuTiedosto.getAbsolutePath()).getImage();

        //varmennetaan vielä, että jos jokin menee pieleen, niin käytetään palikkagrafiikkaa
        if (kuva != null) {
            ladattu = true;
        }
    }

    //siirretään puu uudelle paikalleen, kun se on hävinnyt peliruudulta
    @Override
    public void siirraUuteenPaikkaan() {
        dx = rand.nextInt(10) + 5;
        dx = dx * (-1);
        int y = rand.nextInt(50) + 30;
        if (palat.get(0).getY() >= 250) {   //estetään puun häviäminen ruudulta
            y = y * (-1);
        }
        this.liikuY(y);
        int tempX = rand.nextInt(900) + 1200;
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
