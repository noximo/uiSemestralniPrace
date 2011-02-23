/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ui.alg.udalosti;

import java.util.EventObject;
import ui.alg.VyslednyStav;

/**
 *
 * @author notebook
 */

public class VypocetHotovEvent extends EventObject {

    private VyslednyStav stav;
    
    public VypocetHotovEvent(Object source, VyslednyStav stav) {
        super(source);
        this.stav = stav;
    }

    public VyslednyStav getStav() {
        return stav;
    }
}