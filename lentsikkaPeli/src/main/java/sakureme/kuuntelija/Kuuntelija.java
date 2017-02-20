/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sakureme.kuuntelija;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import sakureme.logiikka.Hahmo;
import sakureme.logiikka.Pelaaja;

/**
 * Kuuntelija, saadaan pelattaville hahmoille inputtia
 */
public class Kuuntelija implements KeyListener {

    private Component component;
    private Hahmo hahmo;

    public Kuuntelija(Pelaaja i, Component c) {
        hahmo = i;
        component = c;
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            hahmo.hyppaa();
        }

        component.repaint();
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

}
