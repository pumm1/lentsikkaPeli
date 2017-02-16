/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sakureme.logiikka;

/*
Lintu-luokka, uhka ilmassa!
 */
/**
 *
 * @author Sagu
 */
public class Lintu extends Hahmo {

    /**
     *
     * @param x
     * @param y
     * @param w
     * @param h
     */
    public Lintu(int x, int y, int w, int h) {
        super(x, y, w, h);
    }

    @Override
    public void siirraUuteenPaikkaan() {
        dx = rand.nextInt(10) + 6;
        dx = dx * (-1);
        int y = rand.nextInt(10) + 30;
        if (palat.get(0).getY() >= 50) {   //estetään linnun häviäminen ruudulta
            y = y * (-1);
        }
        this.liikuY(y);
        int tempX = rand.nextInt(900) + 1200;
        this.liikuX(tempX);
    }

}
