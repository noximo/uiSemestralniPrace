/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ui.aplikace;

import ui.alg.Hra;
import ui.alg.StavHry;

/**
 *
 * @author notebook
 */
public class UiSemPrace {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Hra hra1 = new Hra();
        hra1.setDefault();
        Hra hra2 = new Hra();
        hra2.setDefault();
        StavHry stavHry1 = new StavHry(hra1, null, 0);
        StavHry stavHry2 = new StavHry(hra2, null, 0);
        stavHry1.porovnejStavy(stavHry2);
    }

}
