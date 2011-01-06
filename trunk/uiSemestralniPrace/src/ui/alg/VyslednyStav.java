/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.alg;

import java.util.List;

/**
 *
 * @author notebook
 */
public class VyslednyStav<V> {

    private List<V> posloupnostKroku;
    private int pocetKrokuCelkem;

    public VyslednyStav(List<V> posloupnostKroku, int pocetKrokuCelkem) {
        this.posloupnostKroku = posloupnostKroku;
        this.pocetKrokuCelkem = pocetKrokuCelkem;
    }   

    public V getKonecnyStav() {
        return posloupnostKroku.get(0);
    }

    public List<V> getPosloupnostKroku() {
        return posloupnostKroku;
    }

    public void setPosloupnostKroku(List<V> posloupnost) {
        this.posloupnostKroku = posloupnost;
    }

    public void setPocetKrokuCelkem(int pocet) {
        this.pocetKrokuCelkem = pocet;
    }

    public int getPocetKrokuCelkem() {
        return this.pocetKrokuCelkem;
    }

    public int getPocetKroku() {
        return posloupnostKroku.size() - 1;
    }
}
