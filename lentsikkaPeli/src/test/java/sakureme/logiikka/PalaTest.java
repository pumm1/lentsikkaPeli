package sakureme.logiikka;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sakureme.logiikka.Pala;

/*
Pala-luokan testit
 */
public class PalaTest {

    Pala pala1;
    Pala pala2;

    @Before
    public void setUp() {
        pala1 = new Pala(10, 20, 20, 30);
        pala2 = new Pala(30, 30, 30, 30);
    }

    //testi1
    @Test
    public void konstruktoriToimiiOikein() {
        int x1 = pala1.getX();
        int y1 = pala1.getY();
        assertEquals(10, x1);
        assertEquals(20, y1);

        int x2 = pala2.getX();
        int y2 = pala2.getY();
        assertEquals(30, x2);
        assertEquals(30, y2);

        int w1 = pala1.getLeveys();
        int h1 = pala1.getKorkeus();

        assertEquals(20, w1);
        assertEquals(30, h1);

        int w2 = pala2.getLeveys();
        int h2 = pala2.getKorkeus();

        assertEquals(30, w2);
        assertEquals(30, h2);
    }

    //testi2
    @Test
    public void palatTunnistavatOsumanKeskella() {
        boolean osuma;

        pala1.liikuX(5);
        pala1.liikuY(10);
        osuma = pala1.osuuko(pala2);
        assertEquals(true, osuma);
    }

    //testi3
    @Test
    public void palatTunnistavatOsumanVasen() {
        boolean osuma = pala1.osuuko(pala2);        //x-suunnassa pala1 pala2:n vasemmalla reunalla
        assertEquals(true, osuma);

        pala1.liikuX(-1);                   //x-suunnassa siirretään pala1 irti pala2:sta
        osuma = pala1.osuuko(pala2);
        assertEquals(false, osuma);

    }

    //testi4
    @Test
    public void palatTunnistavatOsumanOikea() {
        boolean osuma;

        pala1.liikuX(50);               //siirretään x-suunnassa pala1 pala2:n oikealle reunalle
        osuma = pala1.osuuko(pala2);
        assertEquals(true, osuma);      //osuu vielä reunalla

        pala1.liikuX(1);                    //siirretään reunan yli
        osuma = pala1.osuuko(pala2);
        assertEquals(false, osuma);
    }

    //testi5
    @Test
    public void palatTunnistavatOsumanAlhaalla() {
        pala2.liikuY(20);   //siirretään pala2 y-suunnassa pala1:n alareunaan kiinni
        boolean osuma = pala1.osuuko(pala2);
        assertEquals(true, osuma);

        pala2.liikuY(1);        //siirretään pala2 y-suunnassa reunasta irti
        osuma = pala1.osuuko(pala2);
        assertEquals(false, osuma);     //nyt ei osukaan enää

    }

    //testi6
    @Test
    public void palatTunnistavatOsumanYlhaalla() {
        boolean osuma;

        pala2.liikuY(-40);     //siirretään pala2 y-suunnassa pala1:n yläreunaan
        osuma = pala1.osuuko(pala2);
        assertEquals(true, osuma);      //osuu vielä

        pala2.liikuY(-1);       //siiretään reunasta irti
        osuma = pala1.osuuko(pala2);
        assertEquals(false, osuma);     //eipäs osukaan enää!
    }

    //testi7
    @Test
    public void liikkuminenToimiiX() {
        int x1;
        int x2;

        pala1.liikuX(15);
        x1 = pala1.getX();
        assertEquals(25, x1);
        
        pala1.liikuX(-20);
        x1 = pala1.getX();
        assertEquals(5, x1);
        
        pala2.liikuX(-20);
        x2 = pala2.getX();
        assertEquals(10, x2);
        
        pala2.liikuX(52);
        x2 = pala2.getX();
        assertEquals(62, x2);
    }
    
    //testi8
    @Test
    public void liikkuminenToimiiY(){
        int y1;
        int y2;
        
        pala1.liikuY(10);
        y1 = pala1.getY();
        assertEquals(30, y1);
        
        pala1.liikuY(-8);
        y1 = pala1.getY();
        assertEquals(22, y1);
        
        pala2.liikuY(-19);
        y2 = pala2.getY();
        assertEquals(11, y2);
    }

}
