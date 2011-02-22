/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ui.alg;

/**
 *
 * @author Pavel
 */
public class Policko {
    //-1 nic, 0 zlata, 1 cerna, 2 bila
    private int barva = -1;

    private int cisloPolicka;

    public Policko(Policko policko){
        this.barva = policko.barva;
        this.cisloPolicka = policko.cisloPolicka;
    }

    public Policko(){
        
    }

    /**
     * @return the barva
     */
    public int getBarva() {
        return barva;
    }

    /**
     * @param barva the barva to set
     */
    public void setBarva(int barva) {
        this.barva = barva;
    }

    /**
     * @return the cisloPolicka
     */
    public int getCisloPolicka() {
        return cisloPolicka;
    }

    /**
     * @param cisloPolicka the cisloPolicka to set
     */
    public void setCisloPolicka(int cisloPolicka) {
        this.cisloPolicka = cisloPolicka;
    }

    public void nastavZlatou(){
        this.barva = 0;
    }

    public void nastavCernou(){
        this.barva = 1;
    }

    public void nastavBilou(){
        this.barva = 2;
    }

    public void nastavZadnou(){
        this.barva = -1;
    }
    
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Policko other = (Policko) obj;
        if (this.barva != other.barva) {
            return false;
        }
        return true;
    }

}
