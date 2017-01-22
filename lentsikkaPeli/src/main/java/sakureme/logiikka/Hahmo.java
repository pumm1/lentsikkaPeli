package sakureme.logiikka;

import java.awt.Graphics;
import java.util.*;

public class Hahmo {
    
    /*
    Tässä luodaan pelin hahmojen logiikka
    */

    private List<Pala> palat;   //käytetään paloja hahmon 'hitboxia' varten

    public Hahmo(List<Pala> i) {
        palat = i;

    }
    
    /////getterit////////
    
    public List<Pala> getPalat(){
        return palat;
    }
    
    ///////hahmon osumisen logiikka////////
    
    //tarkistetaan, osuuko Hahmo toiseen hahmoon
    public boolean osuu(Hahmo i){
        List<Pala> kohde = i.getPalat();
        
        for (Pala a : palat){
            for (Pala b : kohde){
                if (a.osuuko(b)){       //pala a osuu palaan b
                    return true;
                }
            }
        }
        
        return false;
    }
    
  
    //piirretään hahmon palat
    //myöhemmässä vaiheessa tämä pyritään korvaamaan hahmon .png-kuvan piirtämisellä
    public void piirraPalat(Graphics g){
        for (Pala i : palat){
            i.piirra(g);
        }
    }

}
