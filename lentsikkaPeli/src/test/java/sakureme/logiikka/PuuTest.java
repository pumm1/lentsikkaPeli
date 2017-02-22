/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sakureme.logiikka;

import java.awt.Image;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/*
 Hahmo-luokasta muutettu vain uuteenPaikkaanSiirto, jota testataan
 */
public class PuuTest {

    private Puu p1;

    @Before
    public void setUp() {
        p1 = new Puu(400, 250, 70, 350);
    }

    //testi16
    @Test
    public void siirtoUuteenPaikkaanToimii() {
        boolean toimii = false;
        int x = p1.getPalat().get(0).getX();
        int y = p1.getPalat().get(0).getY();
        int temp = y;
        //alkusijoitus oikein
        assertEquals(400, x);
        assertEquals(250, y);

        p1.siirraUuteenPaikkaan();
        x = p1.getPalat().get(0).getX();
        y = p1.getPalat().get(0).getY();

        //tarkistetaan, ettei puu ole enää samalla paikalla kuin aiemmin
        if (x >= 900) {
            if (y != temp) {
                toimii = true;
            }
        }

        if (p1.dx > -13 && p1.dx <= -5) {
            toimii = true;
        } else {
            toimii = false;
        }

        assertEquals(true, toimii);
    }

    //testi26
    @Test
    public void kuvanLatausToimii() throws IOException {
        boolean toimii = false;
        p1.lataaKuva();
        Image k = p1.getKuva();
        if (k != null) {
            toimii = true;
        }
        assertEquals(true, toimii);
    }

}
