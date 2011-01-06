package ui.alg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author notebook
 */
public class Algortimus {

    private Comparator<Stav> c;
    private Stav pocatecni;
    private Stav koncovy;
    private ArrayList<Stav> otevreneStavy;
    private ArrayList<Stav> uzavreneStavy;

    public Algortimus() {
        otevreneStavy = new ArrayList<Stav>();
        uzavreneStavy = new ArrayList<Stav>();
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
    }

    public Algortimus(Stav pocatecni, Stav koncovy) {
        this();
        this.pocatecni = pocatecni;
        this.koncovy = koncovy;
        otevreneStavy.add(pocatecni);
    }

    public VyslednyStav<Stav> spust() {
        Stav aktualniStav = null;
        List<Stav> expandovaneStavy = new ArrayList<Stav>();
        Stav porovnavanyExpStav = null;
        int pocetUzavrenychStavu = 0;

        while (!otevreneStavy.isEmpty() && pocetUzavrenychStavu < 10000) {
            Collections.sort(otevreneStavy, c);
            aktualniStav = otevreneStavy.remove(0);
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
                uzavreneStavy.add(aktualniStav);
                pocetUzavrenychStavu++;
                expandovaneStavy = aktualniStav.getNasledujiStavy();
                for (int i = 0; i < expandovaneStavy.size(); i++) {
                    porovnavanyExpStav = expandovaneStavy.get(i);
                    if (!porovnejSClose(porovnavanyExpStav) && !porovnejSOpen(porovnavanyExpStav)) {
                        otevreneStavy.add(porovnavanyExpStav);
                    }
                }
            }

        }
        return null;
    }

    private boolean porovnejSClose(Stav porovnavanyExpStav) {
        Stav porovnavanyUzavrenyStav;
        for (int j = 0; j < uzavreneStavy.size(); j++) {
            porovnavanyUzavrenyStav = uzavreneStavy.get(j);
            if (porovnavanyExpStav.porovnejStavy(porovnavanyUzavrenyStav) == 0) {
                return true;
            }
        }
        return false;
    }

    private boolean porovnejSOpen(Stav porovnavanyExpStav) {
        Stav porovnavanyUzavrenyStav;
        for (int j = 0; j < otevreneStavy.size(); j++) {
            porovnavanyUzavrenyStav = otevreneStavy.get(j);
            if (porovnavanyExpStav.porovnejStavy(porovnavanyUzavrenyStav) == 0) {
                return true;
            }
        }
        return false;
    }
}
