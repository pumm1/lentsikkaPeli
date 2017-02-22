/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sakureme.logiikka;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
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
     * @param x puun x-koodrinaatti
     * @param y puun y-koordinaatti
     * @param w puun leveys
     * @param h puun korkeus
     */
    public Puu(int x, int y, int w, int h) {
        super(x, y, w, h);
        this.dx = (rand.nextInt(5) + 3) * (-1);
        ladattu = false;
    }

    /**
     * ladataan puun .png-kuva
     */
    public void lataaKuva() throws IOException {
        //saadaan puun kvua hienosti käyttöön riippumatta siitä, minne kansiot sijoitettu koneella
//        File puuTiedosto = new File("src/main/resources/puu.png");
        InputStream is = getClass().getClassLoader().getResourceAsStream("puu.png");
        BufferedImage im = ImageIO.read(is);
        kuva = kuva = (BufferedImage) im;
        //varmennetaan vielä, että jos jokin menee pieleen, niin käytetään palikkagrafiikkaa
        if (kuva != null) {
            ladattu = true;
        }
    }

    public Image getKuva() {
        return kuva;
    }

    /**
     * siirretään puu uudelle paikalleen, kun se on hävinnyt peliruudulta
     */
    @Override
    public void siirraUuteenPaikkaan() {
        dx = rand.nextInt(8) + 5;
        dx = dx * (-1);
        int y = rand.nextInt(50) + 30;
        if (palat.get(0).getY() >= 280) {   //estetään puun häviäminen ruudulta
            y = y * (-1);
        }
        this.liikuY(y);
        int tempX = rand.nextInt(900) + 1200 + rand.nextInt(400) + rand.nextInt(300);
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
