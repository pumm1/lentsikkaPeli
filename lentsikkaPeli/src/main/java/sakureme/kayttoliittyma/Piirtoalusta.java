package sakureme.kayttoliittyma;

/**
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
    private Hahmo hahmo;

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
    
    public void setHahmo(Hahmo i){
        hahmo = i;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timer) {
            for (Hahmo i : hahmot) {
                i.putoa();
                if (i.getPelattavuus() == false){
                    i.liiku();
                    if (i.getPalat().get(0).getX() <= -100){
                        i.siirraUuteenPaikkaan();
                    }
                }
                if(!i.equals(hahmo)){
                    if(hahmo.osuu(i)){
                        timer.stop();
                    }
                }
            }
        }
        repaint();
    }
}
