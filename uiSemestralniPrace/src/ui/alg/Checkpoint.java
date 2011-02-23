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
        seznam.add(vytvorCheckpoint6());
        seznam.add(vytvorCheckpoint20());
        seznam.add(vytvorCheckpoint32());
        seznam.add(vytvorCheckpoint48());
        seznam.add(vytvorCheckpoint58());
        seznam.add(vytvorCheckpoint66());
        seznam.add(vytvorCheckpoint88());
        seznam.add(vytvorCheckpoint100());
        seznam.add(vytvorCheckpoint107());
    }
    
    public Hra vratCheckpoint(int uroven){
        for (int i = 0; i < seznam.size(); i++) {
            if(seznam.get(i).getUroven() == uroven) return seznam.get(i).getHraciPlocha();
        }
        return null;
    }

    private CheckpointContainer vytvorCheckpoint6(){
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
        
        return new CheckpointContainer(6, hra);

    }

    private CheckpointContainer vytvorCheckpoint20(){
        Hra hra = new Hra();
        ArrayList<Policko> policka = hra.getPolicka();

        policka.get(0).nastavCernou();
        policka.get(1).nastavBilou();
        policka.get(2).nastavZadnou();
        policka.get(3).nastavBilou();
        policka.get(4).nastavZadnou();
        policka.get(5).nastavBilou();
        policka.get(6).nastavBilou();
        policka.get(7).nastavZadnou();
        policka.get(8).nastavZadnou();
        policka.get(9).nastavCernou();
        policka.get(10).nastavBilou();
        policka.get(11).nastavBilou();
        policka.get(12).nastavCernou();
        policka.get(13).nastavCernou();
        policka.get(14).nastavZlatou();
        policka.get(15).nastavCernou();
        policka.get(16).nastavCernou();

        return new CheckpointContainer(20, hra);

    }

    private CheckpointContainer vytvorCheckpoint32(){
        Hra hra = new Hra();
        ArrayList<Policko> policka = hra.getPolicka();

        policka.get(0).nastavCernou();
        policka.get(1).nastavBilou();
        policka.get(2).nastavBilou();
        policka.get(3).nastavBilou();
        policka.get(4).nastavBilou();
        policka.get(5).nastavCernou();
        policka.get(6).nastavZadnou();
        policka.get(7).nastavZadnou();
        policka.get(8).nastavZadnou();
        policka.get(9).nastavCernou();
        policka.get(10).nastavBilou();
        policka.get(11).nastavBilou();
        policka.get(12).nastavZadnou();
        policka.get(13).nastavCernou();
        policka.get(14).nastavZlatou();
        policka.get(15).nastavCernou();
        policka.get(16).nastavCernou();

        return new CheckpointContainer(32, hra);

    }

    private CheckpointContainer vytvorCheckpoint48(){
        Hra hra = new Hra();
        ArrayList<Policko> policka = hra.getPolicka();

        policka.get(0).nastavCernou();
        policka.get(1).nastavBilou();
        policka.get(2).nastavZadnou();
        policka.get(3).nastavBilou();
        policka.get(4).nastavZadnou();
        policka.get(5).nastavCernou();
        policka.get(6).nastavCernou();
        policka.get(7).nastavBilou();
        policka.get(8).nastavZadnou();
        policka.get(9).nastavZadnou();
        policka.get(10).nastavBilou();
        policka.get(11).nastavBilou();
        policka.get(12).nastavBilou();
        policka.get(13).nastavCernou();
        policka.get(14).nastavZlatou();
        policka.get(15).nastavCernou();
        policka.get(16).nastavCernou();

        return new CheckpointContainer(48, hra);

    }

    private CheckpointContainer vytvorCheckpoint58(){
        Hra hra = new Hra();
        ArrayList<Policko> policka = hra.getPolicka();

        policka.get(0).nastavBilou();
        policka.get(1).nastavBilou();
        policka.get(2).nastavZlatou();
        policka.get(3).nastavBilou();
        policka.get(4).nastavZadnou();
        policka.get(5).nastavCernou();
        policka.get(6).nastavCernou();
        policka.get(7).nastavBilou();
        policka.get(8).nastavZadnou();
        policka.get(9).nastavCernou();
        policka.get(10).nastavBilou();
        policka.get(11).nastavBilou();
        policka.get(12).nastavZadnou();
        policka.get(13).nastavCernou();
        policka.get(14).nastavZadnou();
        policka.get(15).nastavCernou();
        policka.get(16).nastavCernou();

        return new CheckpointContainer(58, hra);

    }

    private CheckpointContainer vytvorCheckpoint66(){
        Hra hra = new Hra();
        ArrayList<Policko> policka = hra.getPolicka();

        policka.get(0).nastavBilou();
        policka.get(1).nastavBilou();
        policka.get(2).nastavZlatou();
        policka.get(3).nastavBilou();
        policka.get(4).nastavCernou();
        policka.get(5).nastavCernou();
        policka.get(6).nastavCernou();
        policka.get(7).nastavCernou();
        policka.get(8).nastavZadnou();
        policka.get(9).nastavZadnou();
        policka.get(10).nastavBilou();
        policka.get(11).nastavBilou();
        policka.get(12).nastavZadnou();
        policka.get(13).nastavCernou();
        policka.get(14).nastavZadnou();
        policka.get(15).nastavCernou();
        policka.get(16).nastavBilou();

        return new CheckpointContainer(66, hra);

    }

    private CheckpointContainer vytvorCheckpoint88(){
        Hra hra = new Hra();
        ArrayList<Policko> policka = hra.getPolicka();

        policka.get(0).nastavBilou();
        policka.get(1).nastavBilou();
        policka.get(2).nastavZlatou();
        policka.get(3).nastavBilou();
        policka.get(4).nastavBilou();
        policka.get(5).nastavCernou();
        policka.get(6).nastavCernou();
        policka.get(7).nastavZadnou();
        policka.get(8).nastavZadnou();
        policka.get(9).nastavBilou();
        policka.get(10).nastavCernou();
        policka.get(11).nastavCernou();
        policka.get(12).nastavZadnou();
        policka.get(13).nastavCernou();
        policka.get(14).nastavZadnou();
        policka.get(15).nastavCernou();
        policka.get(16).nastavBilou();

        return new CheckpointContainer(88, hra);

    }

    private CheckpointContainer vytvorCheckpoint100(){
        Hra hra = new Hra();
        ArrayList<Policko> policka = hra.getPolicka();

        policka.get(0).nastavBilou();
        policka.get(1).nastavBilou();
        policka.get(2).nastavZlatou();
        policka.get(3).nastavBilou();
        policka.get(4).nastavBilou();
        policka.get(5).nastavCernou();
        policka.get(6).nastavCernou();
        policka.get(7).nastavCernou();
        policka.get(8).nastavZadnou();
        policka.get(9).nastavCernou();
        policka.get(10).nastavCernou();
        policka.get(11).nastavCernou();
        policka.get(12).nastavZadnou();
        policka.get(13).nastavBilou();
        policka.get(14).nastavZadnou();
        policka.get(15).nastavZadnou();
        policka.get(16).nastavBilou();

        return new CheckpointContainer(100, hra);

    }

    private CheckpointContainer vytvorCheckpoint107(){
        Hra hra = new Hra();
        ArrayList<Policko> policka = hra.getPolicka();

        policka.get(0).nastavBilou();
        policka.get(1).nastavBilou();
        policka.get(2).nastavZadnou();
        policka.get(3).nastavBilou();
        policka.get(4).nastavZadnou();
        policka.get(5).nastavCernou();
        policka.get(6).nastavCernou();
        policka.get(7).nastavCernou();
        policka.get(8).nastavZlatou();
        policka.get(9).nastavCernou();
        policka.get(10).nastavCernou();
        policka.get(11).nastavCernou();
        policka.get(12).nastavBilou();
        policka.get(13).nastavZadnou();
        policka.get(14).nastavBilou();
        policka.get(15).nastavZadnou();
        policka.get(16).nastavBilou();

        return new CheckpointContainer(107, hra);

    }

}
