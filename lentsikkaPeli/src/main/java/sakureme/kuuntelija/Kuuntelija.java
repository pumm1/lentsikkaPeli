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

/*
Kuuntelija, saadaan pelattaville hahmoille inputtia
 */
public class Kuuntelija implements KeyListener {
    
    private Component component;
    private Hahmo hahmo;
    
    public Kuuntelija(Hahmo i, Component c){
        hahmo = i;
        component = c;
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            hahmo.liikuX(-3);
        }else if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            hahmo.liikuX(3);
        }else if (e.getKeyCode() == KeyEvent.VK_UP){
            hahmo.hyppaa();
        }
        
        component.repaint();
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

    
    
    
    
}
