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
public interface Stav<V> {

    List<Stav<V>> getNasledujiStavy();    

    int porovnejStavy(Stav<V> druhy);

    int getOhodnoceni(Stav<V> konecny);

    V getValue();

    void setValue(V value);

    int getUroven();

    void setUroven(int uroven);

    void setParent(Stav<V> parent);

    Stav<V> getParent();

    boolean isCheckPoint();
}
