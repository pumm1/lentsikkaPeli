/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sakureme.logiikka;

import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
public class PilviTest {

    private Pilvi pilvi;

    @Before
    public void setUp() {
        List<Pala> p = new ArrayList<>();
        pilvi = new Pilvi(p, 50, 50);
    }

    //testi24
    @Test
    public void kuvanLatausToimii() throws IOException {
        boolean toimii = false;
        pilvi.lataaKuva();
        Image k = pilvi.getKuva();
        if (k != null) {
            toimii = true;
        }
        assertEquals(true, toimii);
    }

    //testi27
    @Test
    public void liikkuminenToimii() {
        boolean toimii = false;
        int dx = pilvi.dx;
        pilvi.liiku();

        int x = pilvi.getX();
        int y = pilvi.getY();
        if (x == 50 + dx) {
            toimii = true;
        }
        assertEquals(true, toimii);
    }

    //testi28
    @Test
    public void siirtoUuteenPaikkaanToimii() {
        boolean toimii = false;
        int x = pilvi.getX();
        int y = pilvi.getY();

        pilvi.siirraUuteenPaikkaan();
        int tx = pilvi.getX();
        int ty = pilvi.getY();

        if (tx != x) {
            toimii = true;
        }
        assertEquals(true, toimii);

        if (pilvi.dx > -5 && pilvi.dx <= -2) {
            toimii = true;
        } else {
            toimii = false;
        }

        assertEquals(true, toimii);

    }
}
