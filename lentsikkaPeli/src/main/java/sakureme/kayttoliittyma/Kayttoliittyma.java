package sakureme.kayttoliittyma;

import java.awt.Dimension;
import java.awt.Container;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import sakureme.kuuntelija.Kuuntelija;
import sakureme.logiikka.Hahmo;

/**
Käyttöliittymän toteutus
 */
public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private Piirtoalusta alusta;
    private int leveys;
    private int korkeus;
    private List<Hahmo> hahmot;
    private Hahmo hahmo;

    //kustomoitava koko ikkunalle konstruktorissa
    public Kayttoliittyma(int w, int h, Piirtoalusta a) {
        leveys = w;
        korkeus = h;
        alusta = a;
    }

    public void setPelattavaHahmo(Hahmo i) {
        hahmo = i;
        hahmo.setPelattavuus(true);
    }

    //oletusarvoinen koko ikkunalle konstruktorissa
    public Kayttoliittyma() {
        leveys = 640;
        korkeus = 480;
    }

    public void setAlusta(Piirtoalusta i) {
        alusta = i;
    }

    public void lisaaHahmot(List<Hahmo> i) {
        hahmot = i;
    }
    
    public void lisaaHahmoListaan(Hahmo i){
        hahmot.add(i);
    }

    public JFrame getFrame() {
        return frame;
    }

    private void luoKomponentit(Container c) {
        alusta = new Piirtoalusta(hahmot);
        alusta.setHahmo(hahmo);
        c.add(alusta);

        frame.addKeyListener(new Kuuntelija(hahmo, alusta));
    }

    @Override
    public void run() {
        frame = new JFrame("LentsikkaPeli");
        frame.setPreferredSize(new Dimension(leveys, korkeus));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

}
