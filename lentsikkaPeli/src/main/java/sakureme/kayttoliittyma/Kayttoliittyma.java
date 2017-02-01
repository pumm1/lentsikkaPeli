package sakureme.kayttoliittyma;


import java.awt.Dimension;
import java.awt.Container;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import sakureme.logiikka.Hahmo;

/*
Käyttöliittymän toteutus
 */
public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private Piirtoalusta alusta;
    private int leveys;
    private int korkeus;
    private List<Hahmo> hahmot;
    public Kayttoliittyma(int w, int h) {
        leveys = w;
        korkeus = h;
    }
    
    public Kayttoliittyma(){
        leveys = 640;
        korkeus = 480;
    }
    
    public void lisaaHahmot(List<Hahmo> i){
        hahmot = i;
    }

    private void luoKomponentit(Container c) {
        alusta = new Piirtoalusta(hahmot);
        c.add(alusta);
    }

    @Override
    public void run() {
        frame = new JFrame("LentsikkaPeli");
        frame.setPreferredSize(new Dimension(leveys, korkeus));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());
        frame.setVisible(true);
    }

}
