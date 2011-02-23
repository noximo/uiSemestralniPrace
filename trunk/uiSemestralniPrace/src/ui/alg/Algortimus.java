package ui.alg;

import java.text.SimpleDateFormat;
import ui.alg.udalosti.VypocetHotovEvent;
import ui.alg.udalosti.VypocetHotovEventListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import ui.alg.udalosti.CheckpointEventListener;
import ui.alg.udalosti.CheckpointEvent;

/**
 *
 * @author notebook
 */
public class Algortimus implements Runnable {

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
    boolean suspend = false;
    protected javax.swing.event.EventListenerList vypocetHotovListenerList =
            new javax.swing.event.EventListenerList();
    protected javax.swing.event.EventListenerList checkPointListenerList =
            new javax.swing.event.EventListenerList();
    private Stav aktualniStav = null;

    public Algortimus() {
//        otevreneStavy = new ArrayList<Stav>();
//        uzavreneStavy = new ArrayList<Stav>();        
        zastav = true;
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

    private void cekej() {
        while (this.zastav && !debug) {
//                if(debug){
//                    debug = false;
//                }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Algortimus.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        debug = false;
    }

    public void spust() {

        List<Stav> expandovaneStavy = new ArrayList<Stav>();
        Stav porovnavanyExpStav = null;

        while (!otevreneStavy.isEmpty()) {
            if(suspend){
                break;
            }
            cekej();
            aktualniStav = otevreneStavy.remove();
            if (aktualniStav.porovnejStavy(koncovy) == 0) {
                List<Stav> kroky = new ArrayList<Stav>();
                Stav aktualni = aktualniStav;
                kroky.add(aktualni);
                while (aktualni.getParent() != null) {

                    aktualni = aktualni.getParent();
                    kroky.add(0, aktualni);
                }
                koncovyStav = new VyslednyStav<Stav>(kroky, pocetUzavrenychStavu);
                fireVypocetDokoncen(new VypocetHotovEvent(this, koncovyStav));
                break;
            } else {
                if (aktualniStav.isCheckPoint()) {
                    pocetCheckPointu++;
                    otevreneStavy.removeAll(otevreneStavy);
                    fireCheckPoint(new CheckpointEvent(this, dejCas(), pocetCheckPointu));
                }
                uzavreneStavy.add(aktualniStav);
                pocetUzavrenychStavu++;
                expandovaneStavy = aktualniStav.getNasledujiStavy();
                for (int i = 0; i < expandovaneStavy.size(); i++) {
                    porovnavanyExpStav = expandovaneStavy.get(i);
                    if (!uzavreneStavy.contains(porovnavanyExpStav) && !otevreneStavy.contains(porovnavanyExpStav)) {
                        //if(!porovnejSClose(porovnavanyExpStav) && !porovnejSOpen(porovnavanyExpStav)){
                        otevreneStavy.add(porovnavanyExpStav);
                        pocetOtevrenychStavu++;
                    }
                }
            }

        }
    }

    private Date dejCas(){
        Calendar cal = Calendar.getInstance();
        return cal.getTime();

    }

    private boolean porovnejSClose(Stav porovnavanyExpStav) {
        Iterator<Stav> iterator = uzavreneStavy.iterator();
        while (iterator.hasNext()) {
            Stav stav = iterator.next();
            if (stav.porovnejStavy(porovnavanyExpStav) == 0) {
                return true;
            }
        }
        return false;
    }

    private boolean porovnejSOpen(Stav porovnavanyExpStav) {
        Iterator<Stav> iterator = otevreneStavy.iterator();
        while (iterator.hasNext()) {
            Stav stav = iterator.next();
            if (stav.porovnejStavy(porovnavanyExpStav) == 0) {
                return true;
            }
        }
        return false;
    }

    public void run() {
        spust();
    }

    public int getPocetCheckPointu() {
        return pocetCheckPointu;
    }

    public int getPocetOtevrenych() {
        return pocetOtevrenychStavu;
    }

    public int getPocetUzavrenych() {
        return pocetUzavrenychStavu;
    }

    public Stav getAktualniStav() {
        return aktualniStav;
    }

    public void zastav(boolean zastav) {
        this.zastav = zastav;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
        this.zastav = true;
    }

    public VyslednyStav<Stav> getKoncovyStav() {
        return koncovyStav;
    }

    public void setSuspend(boolean suspend) {
        this.suspend = suspend;
    }

    public void addVypocetHotovListener(VypocetHotovEventListener listener) {
        vypocetHotovListenerList.add(VypocetHotovEventListener.class, listener);
    }

    public void removeVypocetHotovListener(VypocetHotovEventListener listener) {
        vypocetHotovListenerList.remove(VypocetHotovEventListener.class, listener);
    }

    private void fireVypocetDokoncen(VypocetHotovEvent evt) {
        Object[] listeners = vypocetHotovListenerList.getListenerList();
        // Each listener occupies two elements - the first is the listener class
        // and the second is the listener instance
        for (int i=0; i<listeners.length; i+=2) {
            if (listeners[i]==VypocetHotovEventListener.class) {
                ((VypocetHotovEventListener)listeners[i+1]).VypocetHotovEventOccurred(evt);
            }
        }
    }

      public void addCheckPointListener(CheckpointEventListener listener) {
        vypocetHotovListenerList.add(CheckpointEventListener.class, listener);
    }

    public void removeCheckPointListener(CheckpointEventListener listener) {
        vypocetHotovListenerList.remove(CheckpointEventListener.class, listener);
    }

      private void fireCheckPoint(CheckpointEvent evt) {
        Object[] listeners = vypocetHotovListenerList.getListenerList();
        // Each listener occupies two elements - the first is the listener class
        // and the second is the listener instance
        for (int i=0; i<listeners.length; i+=2) {
            if (listeners[i]==CheckpointEventListener.class) {
                ((CheckpointEventListener)listeners[i+1]).CheckpointEventOccurred(evt);
            }
        }
    }


}
