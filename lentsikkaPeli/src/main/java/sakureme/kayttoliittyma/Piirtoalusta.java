package sakureme.kayttoliittyma;

/**
 * Piirtoalustan toteutus
 */
import java.util.*;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;
import sakureme.logiikka.Hahmo;
import sakureme.logiikka.Pelaaja;

public class Piirtoalusta extends JPanel implements ActionListener {

    private List<Hahmo> hahmot;
    private Timer timer;
    private Random rand = new Random();
    private Pelaaja pelaaja;

    public Piirtoalusta(List<Hahmo> a) {
        super.setBackground(Color.white);
        hahmot = a;
        timer = new Timer(35, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        for (Hahmo i : hahmot) {
            i.piirraPalat(g);
        }

    }

    public void setHahmo(Pelaaja i) {
        pelaaja = i;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == timer) {
            if (!pelaaja.peliAlueenSisalla()) { //hävisit pelin
                pelaaja.kuolee();
                repaint();
                timer.stop();
            }
            for (Hahmo i : hahmot) {
                i.putoa();
                if (i.getPelattavuus() == false) {
                    i.liiku();
                    if (i.getPalat().get(0).getX() <= -300) {
                        i.siirraUuteenPaikkaan();
                    }
                }
                if (!i.equals(pelaaja)) {
                    if (pelaaja.osuu(i)) {  //hävisit pelin
                        pelaaja.kuolee();
                        repaint();
                        timer.stop();
                    }
                }
            }
        }
        repaint();
    }
}
