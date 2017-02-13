/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sakureme.logiikka;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/*
Pelaaja-luokan testit
testataan vain Hahmo-luokalle uusi metodi, jolla tarkistetaan onko pelaaja pelialueella
 */
public class PelaajaTest {

    private Pelaaja p;

    @Before
    public void setUp() {
        List<Pala> palat = new ArrayList<>();
        palat.add(new Pala(50, 50, 20, 20));
        p = new Pelaaja(palat);
    }
    
    
    //testi17
    @Test
    public void tunnistaaPeliAlueenSisalla(){
        boolean sisalla = p.peliAlueenSisalla();
        
        assertEquals(true, sisalla);
        
        //ylös rajalle
        p.liikuY(-60);
        sisalla = p.peliAlueenSisalla();
        assertEquals(true, sisalla);
        
        //rajan yli
        p.liikuY(-1);
        sisalla = p.peliAlueenSisalla();
        assertEquals(false, sisalla);
        
        //alas rajalle
        p.liikuY(61 + 370);
        sisalla = p.peliAlueenSisalla();
        assertEquals(true, sisalla);
        
        //rajan yli
        p.liikuY(1);
        sisalla = p.peliAlueenSisalla();
        assertEquals(false, sisalla);
    }

}
