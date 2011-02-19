/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ui.alg;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pavel
 */
public class StavHry implements Stav<Hra> {
    private Stav<Hra> parent;
    private Hra hraciPlocha;
    private int uroven;


    public StavHry(Hra hraciPlocha, Stav<Hra> parent, int uroven){
        this.hraciPlocha = new Hra(hraciPlocha);
        this.parent = parent;
        this.uroven = uroven;
    }

    public List<Stav<Hra>> getNasledujiStavy() {
        //dodelat na overeni ze se nevklada ten samy stav tam
        StavHry novyStavHry;
        Policko policko;
        ArrayList<Policko> sousedniPolicka;
        Policko sousedniPolicko;
        List<Stav<Hra>> listStavu = new ArrayList<Stav<Hra>>();

        int novaUroven;
        Hra novaHraciPlocha;
        Policko zkoumanePolicko;
        Policko zkoumaneSousedniPolicko;
        Policko prazdnePolicko = new Policko();
        prazdnePolicko.nastavZadnou();
        ArrayList<Policko> kopieListu;
        int cisloPoslednihoPolicka;

        //projdu vsechny policka
        for (int j = 0; j < hraciPlocha.getPolicka().size(); j++) {
        //for (Iterator<Policko> it = hraciPlocha.getPolicka().iterator(); it.hasNext();) {
            //policko = it.next();
            policko = hraciPlocha.getPolicka().get(j);

            //najdu neprazdna
            if(policko.getBarva() != -1){

                //vyberu jejich okoli
                sousedniPolicka = hraciPlocha.getSousedniPolicka(policko);
                for (int i = 0; i < sousedniPolicka.size(); i++) {
                    sousedniPolicko = sousedniPolicka.get(i);
                    novyStavHry = null;
                    novaUroven = uroven+1;
                    novaHraciPlocha = hraciPlocha;
                    zkoumanePolicko = policko;
                    zkoumaneSousedniPolicko = sousedniPolicko;

                    //pokud jsou prazdna tak vytvorim novy stav a zjistuji jestli se nemohu posunout jeste dal
                    //zkoumaneSousedniPolicko je na zacatku prazdne
                    while(zkoumaneSousedniPolicko.getBarva() == -1){
                        cisloPoslednihoPolicka = zkoumanePolicko.getCisloPolicka();

                        novyStavHry = new StavHry(novaHraciPlocha, this, novaUroven);
                        novyStavHry.hraciPlocha.prohodHodnotyPolicek(zkoumanePolicko.getCisloPolicka(), zkoumaneSousedniPolicko.getCisloPolicka());
                        novaUroven++;
                        novaHraciPlocha = novyStavHry.hraciPlocha;
                        //je na pozici byvaleho prazdneho nyni jiz plneho
                        zkoumanePolicko = novaHraciPlocha.getPolicka().get(zkoumaneSousedniPolicko.getCisloPolicka()-1);
                        zkoumaneSousedniPolicko = zkoumanePolicko;

                        //odeberu z nej to prazdny abych se pak nevracel zpet
                        kopieListu = novaHraciPlocha.getSousedniPolicka(zkoumanePolicko);
                        for (int k = 0; k < kopieListu.size(); k++) {
                            if(kopieListu.get(k).getCisloPolicka() == cisloPoslednihoPolicka) kopieListu.remove(k);
                            break;
                        }
                        if(kopieListu.contains(prazdnePolicko)){
                            zkoumaneSousedniPolicko = kopieListu.get(kopieListu.indexOf(prazdnePolicko));
                        }
                            
                    }
                    if(novyStavHry != null) listStavu.add(novyStavHry);
                    /*
                     * pokud zkoumaneSousedniPolicko je prazdne
                     * vytvorim novy stav hry prohozenim hodnot zkoumanehoPolicka a zkoumanehoSousednihoPolicka
                     * zkoumanePolicko se stane zkoumaneSousedni
                     * najdu mu sousedni policka prazdna a opakuju cely postup dokud ma zkoumanePolicko souseda prazndeho
                     * + kontrola abych se nevracel
                     * po cyklu pridani poslednihoStavuHry do listu stavu
                     */

                }
            }
        }
        return listStavu;
    }

    public int porovnejStavy(Stav<Hra> druhy) {
        //if(this.equals(druhy)) return 0;
        //if(this.hraciPlocha.equals(druhy.getValue())) return 0;
        //else return 1;
        int navrat = 1;
        if(druhy.getValue().equals(this.hraciPlocha)) navrat = 0;
        else if(this.hraciPlocha.equals(druhy.getValue().rotuj(1))) navrat = 0;
        else if(this.hraciPlocha.equals(druhy.getValue().rotuj(2))) navrat = 0;
        else if(this.hraciPlocha.equals(druhy.getValue().rotuj(3))) navrat = 0;
        return navrat;
    }

    public int getOhodnoceni(Stav<Hra> konecny) {
        int hodnoceni = 0;
        hodnoceni = hodnoceni + 100*uroven;
        for (int i = 0; i < hraciPlocha.getPolicka().size(); i++) {
            if(!konecny.getValue().getPolicka().get(i).equals(hraciPlocha.getPolicka().get(i)))
                hodnoceni++;
        }

        return hodnoceni;
    }

    public Hra getValue() {
        return this.hraciPlocha;
    }

    public void setValue(Hra value) {
        this.hraciPlocha = value;
    }

    public int getUroven() {
        return this.uroven;
    }

    public void setUroven(int uroven) {
        this.uroven = uroven;
    }

    public void setParent(Stav<Hra> parent) {
        this.parent = parent;
    }

    public Stav<Hra> getParent() {
        return this.parent;
    }

    public boolean equals(StavHry stav){
        boolean navrat = false;
        if(stav.hraciPlocha.equals(this.hraciPlocha)) navrat = true;
        else if(this.hraciPlocha.equals(stav.hraciPlocha.rotuj(1))) navrat = true;
        else if(this.hraciPlocha.equals(stav.hraciPlocha.rotuj(2))) navrat = true;
        else if(this.hraciPlocha.equals(stav.hraciPlocha.rotuj(3))) navrat = true;
        return navrat;
    }

}
