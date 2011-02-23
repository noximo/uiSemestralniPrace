/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ui.alg.udalosti;

import java.sql.Time;
import java.util.Date;
import java.util.EventObject;

/**
 *
 * @author notebook
 */

public class CheckpointEvent extends EventObject {

    private Date cas;
    private int cislo;

    public CheckpointEvent(Object source, Date cas, int cislo) {
        super(source);
        this.cas = cas;
        this.cislo = cislo;
    }

    public Date getCas() {
        return cas;
    }

    public int getCislo() {
        return cislo;
    }

    
}