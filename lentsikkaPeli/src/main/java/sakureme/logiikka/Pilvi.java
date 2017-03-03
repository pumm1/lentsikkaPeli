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
import java.util.List;
import javax.imageio.ImageIO;
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

    /**
     *
     * @param i
     * @param a
     * @param b
     */
    public Pilvi(List<Pala> i, int a, int b) {
        super(i);
        x = a;
        y = b;
        ladattu = false;
    }

    /**
     *
     * @return kuva
     */
    public Image getKuva() {
        return kuva;
    }

    /**
     *
     * @throws IOException
     */
    public void lataaKuva() throws IOException {
        InputStream is = getClass().getClassLoader().getResourceAsStream("pilvi.png");
        BufferedImage im = ImageIO.read(is);
        kuva = kuva = (BufferedImage) im;
        if (kuva != null) {
            ladattu = true;
        }
    }

    @Override
    public void liiku() {
        x += dx;
    }

    /**
     *
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @return y
     */
    public int getY() {
        return y;
    }

    /**
     *
     */
    public void siirraUuteenPaikkaan() {
        dx = rand.nextInt(4) + 3;
        dx = dx * (-1);
        int yy = rand.nextInt(20) + 30;
        if (y >= 100) {   //estetään pilven meno liian alas
            yy = yy * (-1);
        }
        if (yy < 0) {
            yy = 10 + rand.nextInt(15);
        }
        y += yy;
        int tempX = rand.nextInt(400) + 900;
        x += tempX;
    }

    @Override
    public void piirraPalat(Graphics g) {
        if (ladattu) {
            g.drawImage(kuva, x, y, null);
        }
    }

}
