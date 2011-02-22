package ui.alg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

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
    
    private Stav aktualniStav = null;
    
    public Algortimus() {
//        otevreneStavy = new ArrayList<Stav>();
//        uzavreneStavy = new ArrayList<Stav>();        

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
//                if(aktualniStav.isCheckPoint()){
//                    pocetCheckPointu++;
//                    otevreneStavy.removeAll(otevreneStavy);
//                }
                uzavreneStavy.add(aktualniStav);
                pocetUzavrenychStavu++;
                expandovaneStavy = aktualniStav.getNasledujiStavy();
                for (int i = 0; i < expandovaneStavy.size(); i++) {
                    porovnavanyExpStav = expandovaneStavy.get(i);
                    if(!otevreneStavy.contains(porovnavanyExpStav) && !uzavreneStavy.contains(porovnavanyExpStav)){
                        otevreneStavy.add(porovnavanyExpStav);
                        pocetOtevrenychStavu++;
                    }
                }
            }

        }
        return null;
    }

    private boolean porovnejSClose(Stav porovnavanyExpStav) {
//        Stav porovnavanyUzavrenyStav;
//        for (int j = 0; j < uzavreneStavy.size(); j++) {
//            porovnavanyUzavrenyStav = uzavreneStavy.get(j);
//            if (porovnavanyExpStav.porovnejStavy(porovnavanyUzavrenyStav) == 0) {
//                return true;
//            }
//        }
        return false;
    }

    private boolean porovnejSOpen(Stav porovnavanyExpStav) {
//        Stav porovnavanyUzavrenyStav;
//        for (int j = 0; j < otevreneStavy.size(); j++) {
//            porovnavanyUzavrenyStav = otevreneStavy.get(j);
//            if (porovnavanyExpStav.porovnejStavy(porovnavanyUzavrenyStav) == 0) {
//                return true;
//            }
//        }
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
    
    public synchronized  void zastav() throws InterruptedException{
        Thread.currentThread().wait();
    }
    
    public synchronized  void resume(){
        Thread.currentThread().notify();
    }
}