package sakureme.kayttoliittyma;

/*
Piirtoalustan toteutus
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

public class Piirtoalusta extends JPanel implements ActionListener {

    private List<Hahmo> hahmot;
    private Timer timer;
    private Random rand = new Random();

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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timer) {
            for (Hahmo i : hahmot) {
                i.putoa();
                if (i.getPelattavuus() == false){
                    i.liikuX(-5);
                    if (i.getPalat().get(0).getX() <= -100){
                        int a = rand.nextInt(1000) + 1000;
                        i.liikuX(a);
                    }
                }
            }
        }
        repaint();
    }
}
