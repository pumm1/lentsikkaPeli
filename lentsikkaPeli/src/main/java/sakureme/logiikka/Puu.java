/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sakureme.logiikka;

/*
    Tälle luokalle ei tehdä alustavasti testejä, koska on käytännössä Hahmo-luokka
 */
public class Puu extends Hahmo {

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

}
