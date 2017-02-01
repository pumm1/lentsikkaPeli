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
import sakureme.logiikka.Hahmo;

public class Piirtoalusta extends JPanel implements ActionListener{
    
    private List<Hahmo> hahmot;
    
    public Piirtoalusta(List<Hahmo> a){
        super.setBackground(Color.blue);
        hahmot = a;
        
        
    }
    
    
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        for(Hahmo i : hahmot){
            i.piirraPalat(g);
        }
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
    }
}
