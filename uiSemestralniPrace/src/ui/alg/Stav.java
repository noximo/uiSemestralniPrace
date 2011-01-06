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

    public abstract List<Stav<V>> getNasledujiStavy();

    public abstract int porovnejStavy(Stav<V> druhy);

    public abstract int getOhodnoceni(Stav<V> konecny);

    public abstract V getValue();

    public abstract void setValue(V value);

    public abstract int getUroven();

    public abstract void setUroven(int uroven);

    public abstract void setParent(Stav<V> parent);

    public abstract Stav<V> getParent();
}
