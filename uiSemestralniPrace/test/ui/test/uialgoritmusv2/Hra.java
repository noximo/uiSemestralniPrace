/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.test.uialgoritmusv2;

import ui.alg.Stav;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author notebook
 */
public class Hra implements Stav<Integer[]> {

    private Stav<Integer[]> parent;
    private Integer[] hraciPlocha;
    private int uroven;

    public Hra() {
        hraciPlocha = new Integer[10];
        uroven = 0;
    }

    public Hra(Integer[] hraciPlocha, int uroven, Hra parent) {
        this.hraciPlocha = hraciPlocha;
        this.uroven = uroven;
        this.parent = parent;
    }

    public int porovnejStavy(Stav<Integer[]> druhy) {
        int pocetSpatnych = 0;
        for (int i = 0; i < 10; i++) {
            if (hraciPlocha[i] != druhy.getValue()[i]) {
                pocetSpatnych++;
            }
        }
        return pocetSpatnych;
    }

    public int getOhodnoceni(Stav<Integer[]> konecny) {
        return porovnejStavy(konecny);
    }

    public Integer[] getValue() {
        return hraciPlocha;
    }

    public void setValue(Integer[] value) {
        hraciPlocha = value;
    }

    public int getUroven() {
        return uroven;
    }

    public void setUroven(int uroven) {
        this.uroven = uroven;
    }

    public void setParent(Stav<Integer[]> parent) {
        this.parent = parent;
    }

    public Stav<Integer[]> getParent() {
        return parent;
    }

    public List<Stav<Integer[]>> getNasledujiStavy() {
        List<Stav<Integer[]>> vyslList = new ArrayList<Stav<Integer[]>>();
        int poziceNuly = getPoziceNuly();
        if(isPosunNahoru(poziceNuly)){
            vyslList.add(new Hra(posunNahoru(poziceNuly, vytvorPole()), uroven++, this));
        }
        if(isPosunDolu(poziceNuly)){
            vyslList.add(new Hra(posunDolu(poziceNuly, vytvorPole()), uroven++, this));
        }
        if(isPosunDoleva(poziceNuly)){
            vyslList.add(new Hra(posunDoleva(poziceNuly, vytvorPole()), uroven++, this));
        }
        if(isPosunDoprava(poziceNuly)){
            vyslList.add(new Hra(posunDoprava(poziceNuly, vytvorPole()), uroven++, this));
        }
        return vyslList;
    }

    private Integer[] vytvorPole(){
        Integer[] novaHraciPlocha = new Integer[10];
        System.arraycopy(hraciPlocha, 0, novaHraciPlocha, 0, 10);
        return novaHraciPlocha;
    }

    private int getPoziceNuly() {
        for (int i = 0; i < 10; i++) {
            if (hraciPlocha[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    private Integer[] posunNahoru(int pozice, Integer[] pole) {
        pole[pozice] = pole[pozice - 3];
        pole[pozice - 3] = 0;
        return pole;
    }

    private boolean isPosunNahoru(int pozice){
        return pozice != 0 && pozice != 1 && pozice != 2 && pozice != 9;
    }

    private Integer[] posunDolu(int pozice, Integer[] pole) {
        pole[pozice] = pole[pozice + 3];
        pole[pozice + 3] = 0;
        return pole;
    }

    private boolean isPosunDolu(int pozice){
        return pozice != 6 && pozice != 7 && pozice != 8 && pozice != 9;
    }

    private Integer[] posunDoleva(int pozice, Integer[] pole) {
        pole[pozice] = pole[pozice - 1];
        pole[pozice - 1] = 0;
        return pole;
    }

    private boolean isPosunDoleva(int pozice){
        return pozice != 0 && pozice != 3 && pozice != 6;
    }

    private Integer[] posunDoprava(int pozice, Integer[] pole) {
        pole[pozice] = pole[pozice + 1];
        pole[pozice + 1] = 0;
        return pole;
    }

    private boolean isPosunDoprava(int pozice){
        return pozice != 2 && pozice != 5 && pozice != 9;
    }

    public boolean isCheckPoint() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
