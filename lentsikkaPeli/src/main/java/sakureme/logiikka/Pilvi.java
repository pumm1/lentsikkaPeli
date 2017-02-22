/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sakureme.logiikka;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.util.List;
import javax.swing.ImageIcon;

/**
 *
 * @author Sagu
 */
public class Pilvi extends Hahmo {

    private int x;
    private int y;
    private Image kuva;
    private boolean ladattu;

    public Pilvi(List<Pala> i, int a, int b) {
        super(i);
        x = a;
        y = b;
        ladattu = false;
    }

    public void lataaKuva() {
        File pilviTiedosto = new File("src/pilvi.png");
        kuva = new ImageIcon(pilviTiedosto.getAbsolutePath()).getImage();
        if (kuva != null) {
            ladattu = true;
        }
    }

    @Override
    public void liiku() {
        x += dx;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void siirraUuteenPaikkaan() {
        dx = rand.nextInt(3) + 2;
        dx = dx * (-1);
        int yy = rand.nextInt(20) + 30;
        if (y >= 100) {   //estetään pilven meno liian alas
            yy = yy * (-1);
        }
        if (yy < 0) {
            yy = 0 + rand.nextInt(15);
        }
        y += yy;
        int tempX = rand.nextInt(100) + 800;
        x += tempX;
    }

    @Override
    public void piirraPalat(Graphics g) {
        if (ladattu) {
            g.drawImage(kuva, x, y, null);
        }
    }

}
