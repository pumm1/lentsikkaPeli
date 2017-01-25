package sakureme.logiikka;

import java.awt.Graphics;
import java.util.*;

public class Hahmo {
    
    /*
    Tässä luodaan pelin hahmojen logiikka
    */

    private List<Pala> palat;   //käytetään paloja hahmon 'hitboxia' varten

    public Hahmo(int x, int y, int w, int h) {  //konstruktori hahmolle, jolle ei anneta listaa paloista
        Pala eka = new Pala(x, y, w, h);
        palat = new ArrayList<>();
        palat.add(eka);

    }
    
    public Hahmo(List<Pala> i){     //konstruktori hahmolle, jolle annetaan heti kaikki palat
        palat = i;
    }
    
    /////getterit////////
    
    public List<Pala> getPalat(){
        return palat;
    }
    
    
  ///palojen lisäys//
    public void lisaaPala(Pala i){      
        palat.add(i);
    }
    
    public void lisaaPaloja(List<Pala> p){
        for (Pala i : p){
            palat.add(i);
        }
    }
    
    ///////hahmon logiikka////////
    
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
    
    //hahmon palojen liikuttelu x-suunnassa
    public void liikuX(int a){
        for (Pala i : palat){
            i.liikuX(a);
        }
    }
    
    //hahmon palojen liikuttelu y-suunnassa
    public void liikuY(int a){
        for(Pala i : palat){
            i.liikuY(a);
        }
    }
    
  
    //piirretään hahmon palat
    //myöhemmässä vaiheessa tämä pyritään korvaamaan hahmon .png-kuvan piirtämisellä
    public void piirraPalat(Graphics g){
        for (Pala i : palat){
            i.piirra(g);
        }
    }

}