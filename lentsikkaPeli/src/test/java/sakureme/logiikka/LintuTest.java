/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sakureme.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sagu
 */
public class LintuTest {

    private Lintu lintu;

    @Before
    public void setUp() {
        lintu = new Lintu(50, 50, 50, 50);
    }

    //testi19
    @Test
    public void konstruktoriToimii() {
        int x = lintu.getPalat().get(0).getX();
        int y = lintu.getPalat().get(0).getY();
        boolean toimii = false;

        if (x == 50 && y == 50) {
            toimii = true;
        }
        assertEquals(true, toimii);
    }

    //testi20
    @Test
    public void siirtoUuteenPaikkaanToimii() {
        int y = lintu.getPalat().get(0).getY();
        int temp = y;
        lintu.siirraUuteenPaikkaan();
        boolean toimii = false;
        int x = lintu.getPalat().get(0).getX();
        y = lintu.getPalat().get(0).getY();
        if (x == 50) {
            toimii = false;
        } else if (x >= 900) {
            toimii = true;
        }

        if (y == temp) {
            toimii = false;
        } else {
            toimii = true;
        }

        assertEquals(true, toimii);

    }

    //testi21
    @Test
    public void liikuToimii() {
        boolean suunta = lintu.getSuunta();
        boolean tempSuunta = suunta;
        int dx = lintu.getDx();
        int dy = lintu.getDy();
        int tempDy = dy;
        int x = lintu.getPalat().get(0).getX();
        int y = lintu.getPalat().get(0).getY();
        boolean toimii = false;

        assertEquals(50, x);
        assertEquals(50, y);

        //hankala testata, koska randomisoituja osioita alustuksessa
        lintu.liiku();

        x = lintu.getPalat().get(0).getX();
        y = lintu.getPalat().get(0).getY();

        assertEquals(50 + dx, x);
        assertEquals(50 + dy, y);

        suunta = lintu.getSuunta();
        if (tempSuunta != suunta) {
            dy = lintu.getDy();
            if (dy == tempDy) {
                toimii = true;
            }
        } else {
            dy = lintu.getDy();
            if (dy != tempDy) {
                toimii = true;
            }
        }
        assertEquals(true, toimii);
    }

}
