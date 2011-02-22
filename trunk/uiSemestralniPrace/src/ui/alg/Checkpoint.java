/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ui.alg;

import java.util.ArrayList;

/**
 *
 * @author Pavel
 */
public class Checkpoint {
    private class CheckpointContainer{
        private int uroven;
        private Hra hraciPlocha;

        public CheckpointContainer(int uroven, Hra hraciPlocha){
            this.uroven = uroven;
            this.hraciPlocha = hraciPlocha;
        }

        /**
         * @return the uroven
         */
        public int getUroven() {
            return uroven;
        }

        /**
         * @param uroven the uroven to set
         */
        public void setUroven(int uroven) {
            this.uroven = uroven;
        }

        /**
         * @return the hraciPlocha
         */
        public Hra getHraciPlocha() {
            return hraciPlocha;
        }

        /**
         * @param hraciPlocha the hraciPlocha to set
         */
        public void setHraciPlocha(Hra hraciPlocha) {
            this.hraciPlocha = hraciPlocha;
        }
    }

    private ArrayList<CheckpointContainer> seznam;

    public Checkpoint(){
        seznam = new ArrayList<CheckpointContainer>();
        seznam.add(vytvorPrvniCheckpoint());
    }
    
    public Hra vratCheckpoint(int uroven){
        for (int i = 0; i < seznam.size(); i++) {
            if(seznam.get(i).getUroven() == uroven) return seznam.get(i).getHraciPlocha();
        }
        return null;
    }

    private CheckpointContainer vytvorPrvniCheckpoint(){
        Hra hra = new Hra();
        ArrayList<Policko> policka = hra.getPolicka();

        policka.get(0).nastavCernou();
        policka.get(1).nastavCernou();
        policka.get(2).nastavZadnou();
        policka.get(3).nastavZadnou();
        policka.get(4).nastavCernou();
        policka.get(5).nastavBilou();
        policka.get(6).nastavBilou();
        policka.get(7).nastavBilou();
        policka.get(8).nastavZadnou();
        policka.get(9).nastavBilou();
        policka.get(10).nastavBilou();
        policka.get(11).nastavBilou();
        policka.get(12).nastavZadnou();
        policka.get(13).nastavCernou();
        policka.get(14).nastavZlatou();
        policka.get(15).nastavCernou();
        policka.get(16).nastavCernou();
        
        return new CheckpointContainer(0, hra);

    }
}
