/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sakureme.kuuntelija;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import javax.swing.Timer;
import sakureme.logiikka.Hahmo;
import sakureme.logiikka.Pelaaja;

/**
 * Kuuntelija, saadaan pelattaville hahmoille inputtia
 */
public class Kuuntelija implements KeyListener {

    private Component component;
    private Pelaaja pelaaja;
    private Timer timer;
    private List<Hahmo> hahmot;

    public Kuuntelija(Pelaaja i, Component c, Timer t, List<Hahmo> h) {
        pelaaja = i;
        component = c;
        timer = t;
        hahmot = h;
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            pelaaja.hyppaa();
        } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!timer.isRunning()) {
                timer.start();
                for (Hahmo i : hahmot) {
                    if (i.getClass() != pelaaja.getClass()) {
                        i.siirraUuteenPaikkaan();
                    } else {
                        pelaaja.palautaEloon();
                        int y = i.getPalat().get(0).getY();
                        if (y < 100) {
                            i.liikuY(250);
                        } else if (y > 350) {
                            i.liikuY(-250);
                        }
                    }
                }
            }
        }

        component.repaint();
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

}
