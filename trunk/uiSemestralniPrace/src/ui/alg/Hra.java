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
public class Hra {
    private ArrayList<Policko> components = new ArrayList<Policko>();

    private Policko policko1;
    private Policko policko2;
    private Policko policko3;
    private Policko policko4;
    private Policko policko5;
    private Policko policko6;
    private Policko policko7;
    private Policko policko8;
    private Policko policko9;
    private Policko policko10;
    private Policko policko11;
    private Policko policko12;
    private Policko policko13;
    private Policko policko14;
    private Policko policko15;
    private Policko policko16;
    private Policko policko17;


    public boolean equals(Hra hra){
        /*for (int i = 0; i < components.size(); i++) {
            if(!components.get(i).equals(hra.components.get(i)))
                return false;
        }
        return true;*/
        if(hra.components.equals(this.components)) return true;
        else return false;
    }

    public Hra() {
        /*components.add(policko1);
        components.add(policko2);
        components.add(policko3);
        components.add(policko4);
        components.add(policko5);
        components.add(policko6);
        components.add(policko7);
        components.add(policko8);
        components.add(policko9);
        components.add(policko10);
        components.add(policko11);
        components.add(policko12);
        components.add(policko13);
        components.add(policko14);
        components.add(policko15);
        components.add(policko16);
        components.add(policko17);*/
        for (int i = 0; i < 17; i++) {
            components.add(new Policko());
        }

        for (int i = 0; i < components.size(); i++) {
            components.get(i).setCisloPolicka(i+1);
        }
    }

    public Hra(Hra hra){
        //this();
        /*policko1 = hra.policko1;
        policko2 = hra.policko2;
        policko3 = hra.policko3;
        policko4 = hra.policko4;
        policko5 = hra.policko5;
        policko6 = hra.policko6;
        policko7 = hra.policko7;
        policko8 = hra.policko8;
        policko9 = hra.policko9;
        policko10 = hra.policko10;
        policko11 = hra.policko11;
        policko12 = hra.policko12;
        policko13 = hra.policko13;
        policko14 = hra.policko14;
        policko15 = hra.policko15;
        policko16 = hra.policko16;
        policko17 = hra.policko17;*/
        for (int i = 0; i < hra.components.size(); i++) {
            components.add(new Policko(hra.components.get(i)));
        }
    }

    public void setDefault(){
        components.get(0).nastavCernou();
        components.get(1).nastavZadnou();
        components.get(2).nastavCernou();
        components.get(3).nastavZadnou();
        components.get(4).nastavCernou();
        components.get(5).nastavBilou();
        components.get(6).nastavBilou();
        components.get(7).nastavBilou();
        components.get(8).nastavZlatou();
        components.get(9).nastavBilou();
        components.get(10).nastavBilou();
        components.get(11).nastavBilou();
        components.get(12).nastavCernou();
        components.get(13).nastavZadnou();
        components.get(14).nastavCernou();
        components.get(15).nastavZadnou();
        components.get(16).nastavCernou();
    }

    public void setFinal(){
        components.get(0).nastavBilou();
        components.get(1).nastavZadnou();
        components.get(2).nastavBilou();
        components.get(3).nastavZadnou();
        components.get(4).nastavBilou();
        components.get(5).nastavCernou();
        components.get(6).nastavCernou();
        components.get(7).nastavCernou();
        components.get(8).nastavZlatou();
        components.get(9).nastavCernou();
        components.get(10).nastavCernou();
        components.get(11).nastavCernou();
        components.get(12).nastavBilou();
        components.get(13).nastavZadnou();
        components.get(14).nastavBilou();
        components.get(15).nastavZadnou();
        components.get(16).nastavBilou();
    }

    public ArrayList<Policko> getPolicka(){
        return this.components;
    }

    public void setPolicko(int cislo, Policko policko){
        components.set(cislo, policko);
    }

    public void prohodHodnotyPolicek(int polickoCislo1, int polickoCislo2){
        int pom = components.get(polickoCislo1 - 1).getBarva();
        components.get(polickoCislo1 - 1).setBarva(components.get(polickoCislo2 - 1).getBarva());
        components.get(polickoCislo2 - 1).setBarva(pom);
    }

    public ArrayList<Policko> getSousedniPolicka(Policko policko){
        ArrayList<Policko> list = new ArrayList<Policko>();
        switch(policko.getCisloPolicka()){

                    /*
         *  1 - 3
            2 - 3
            3 - 1,2,4,5
            4 - 3
            5 - 3,9
            6 - 7
            7 - 6,8
            8 - 7,9
            9 - 5,8,10,13
            10 - 9,11
            11 - 10,12
            12 - 11
            13 - 9,15
            14 - 15
            15 - 13,14,16,17
            16 - 15
            17 - 15
         */


            case 1: list.add(components.get(2)); break;
            case 2: list.add(components.get(2)); break;
            case 3: list.add(components.get(0)); list.add(components.get(1)); list.add(components.get(3)); list.add(components.get(4)); break;
            case 4: list.add(components.get(2)); break;
            case 5: list.add(components.get(2)); list.add(components.get(8)); break;
            case 6: list.add(components.get(6)); break;
            case 7: list.add(components.get(5)); list.add(components.get(7)); break;
            case 8: list.add(components.get(6)); list.add(components.get(8)); break;
            case 9: list.add(components.get(4)); list.add(components.get(7)); list.add(components.get(9)); list.add(components.get(12)); break;
            case 10: list.add(components.get(8)); list.add(components.get(10)); break;
            case 11: list.add(components.get(9)); list.add(components.get(11)); break;
            case 12: list.add(components.get(10)); break;
            case 13: list.add(components.get(8)); list.add(components.get(14)); break;
            case 14: list.add(components.get(14)); break;
            case 15: list.add(components.get(12)); list.add(components.get(13)); list.add(components.get(15)); list.add(components.get(16)); break;
            case 16: list.add(components.get(14)); break;
            case 17: list.add(components.get(14)); break;
        }
        return list;
    }

    public Hra rotuj(int cisloRotace){
        Hra rotovana = new Hra(this);
        switch(cisloRotace){
            case 1:{
                rotovana.prohodHodnotyPolicek(2, 4);
                rotovana.prohodHodnotyPolicek(6, 12);
                rotovana.prohodHodnotyPolicek(7, 11);
                rotovana.prohodHodnotyPolicek(8, 10);
                rotovana.prohodHodnotyPolicek(14, 16);
                break;
            }
            case 2:{
                rotovana.prohodHodnotyPolicek(1, 17);
                rotovana.prohodHodnotyPolicek(3, 15);
                rotovana.prohodHodnotyPolicek(5, 13);
                rotovana.prohodHodnotyPolicek(2, 14);
                rotovana.prohodHodnotyPolicek(4, 16);
                break;
            }
            case 3:{
                rotovana.prohodHodnotyPolicek(1, 17);
                rotovana.prohodHodnotyPolicek(3, 15);
                rotovana.prohodHodnotyPolicek(5, 13);
                rotovana.prohodHodnotyPolicek(6, 12);
                rotovana.prohodHodnotyPolicek(7, 11);
                rotovana.prohodHodnotyPolicek(8, 10);
                rotovana.prohodHodnotyPolicek(2, 16);
                rotovana.prohodHodnotyPolicek(4, 14);
                break;
            }
        }
        return rotovana;
    }
}
