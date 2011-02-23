package ui.alg;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author notebook
 */

public class Algortimus implements Runnable{

    private Comparator<Stav> c;
    private Stav pocatecni;
    
    private Stav koncovy;
    private PriorityQueue<Stav> otevreneStavy;
    private PriorityQueue<Stav> uzavreneStavy;
//    private ArrayList<Stav> otevreneStavy;
//    private ArrayList<Stav> uzavreneStavy;
    private VyslednyStav<Stav> koncovyStav;
    
    int pocetUzavrenychStavu = 0;
    int pocetOtevrenychStavu = 0;
    int pocetCheckPointu = 0;
    boolean zastav;
    boolean debug;

    private Stav aktualniStav = null;
    
    public Algortimus() {
//        otevreneStavy = new ArrayList<Stav>();
//        uzavreneStavy = new ArrayList<Stav>();        
        zastav = false;
        debug = false;
        c = new Comparator<Stav>() {

            public int compare(Stav o1, Stav o2) {
                if (o1.getOhodnoceni(koncovy) < o2.getOhodnoceni(koncovy)) {
                    return -1;
                } else if (o1.getOhodnoceni(koncovy) == o2.getOhodnoceni(koncovy)) {
                    return 0;
                } else {
                    return 1;
                }
            }
        };
        otevreneStavy = new PriorityQueue<Stav>(500, c);
        uzavreneStavy = new PriorityQueue<Stav>(1000, c);
    }

    public Algortimus(Stav pocatecni, Stav koncovy) {
        this();
        this.pocatecni = pocatecni;
        this.koncovy = koncovy;
        otevreneStavy.add(pocatecni);
    }

    public VyslednyStav<Stav> spust() {
        
        List<Stav> expandovaneStavy = new ArrayList<Stav>();
        Stav porovnavanyExpStav = null;
        
        while (!otevreneStavy.isEmpty()) {
            while (zastav) {
                if(debug){
                    debug = false;
                    break;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Algortimus.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
//            Collections.sort(otevreneStavy, c);
            aktualniStav = otevreneStavy.remove();
            if (aktualniStav.porovnejStavy(koncovy) == 0) {
                List<Stav> kroky = new ArrayList<Stav>();
                Stav aktualni = aktualniStav;
                kroky.add(aktualni);
                while (aktualni.getParent() != null) {

                    aktualni = aktualni.getParent();
                    kroky.add(aktualni);
                }
                return new VyslednyStav<Stav>(kroky, pocetUzavrenychStavu);
            } else {
                if(aktualniStav.isCheckPoint()){
                    pocetCheckPointu++;
                    otevreneStavy.removeAll(otevreneStavy);
                }
                uzavreneStavy.add(aktualniStav);
                pocetUzavrenychStavu++;
                expandovaneStavy = aktualniStav.getNasledujiStavy();
                for (int i = 0; i < expandovaneStavy.size(); i++) {
                    porovnavanyExpStav = expandovaneStavy.get(i);
                    if(!uzavreneStavy.contains(porovnavanyExpStav) && !otevreneStavy.contains(porovnavanyExpStav)){
                    //if(!porovnejSClose(porovnavanyExpStav) && !porovnejSOpen(porovnavanyExpStav)){
                        otevreneStavy.add(porovnavanyExpStav);
                        pocetOtevrenychStavu++;
                    }
                }
            }

        }
        return null;
    }

    private boolean porovnejSClose(Stav porovnavanyExpStav) {
        Iterator<Stav> iterator = uzavreneStavy.iterator();
        while (iterator.hasNext()) {
            Stav stav = iterator.next();
            if(stav.porovnejStavy(porovnavanyExpStav) == 0){
                return true;
            }
        }
        return false;
    }

    private boolean porovnejSOpen(Stav porovnavanyExpStav) {
        Iterator<Stav> iterator = otevreneStavy.iterator();
        while (iterator.hasNext()) {
            Stav stav = iterator.next();
            if(stav.porovnejStavy(porovnavanyExpStav) == 0){
                return true;
            }
        }
        return false;
    }

    public void run() {
        koncovyStav = spust();
    }
    
    public int getPocetCheckPointu(){
        return pocetCheckPointu;
    }
    
    public int getPocetOtevrenych(){
        return pocetOtevrenychStavu;
    }
    
    public int getPocetUzavrenych(){
        return pocetUzavrenychStavu;
    }
    
    public Stav getAktualniStav(){
        return aktualniStav;
    }
    
    public synchronized  void zastav(boolean zastav){
        this.zastav = zastav;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
        this.zastav = true;
    }


    
}