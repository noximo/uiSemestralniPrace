/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ui.gui.komponenty;

import javax.swing.Icon;
import ui.gui.icons.IconLoader;

/**
 *
 * @author Pavel
 */
public class IkonyPolicka {
    private static Icon kulickaZlata = IconLoader.loadOrangeRing();
    private static Icon kulickaCerna = IconLoader.loadBlackRing();
    private static Icon kulickaBila = IconLoader.loadWhiteRing();

    public static Icon getZlataKulicka(){
        return kulickaZlata;
    }

    public static Icon getCernaKulicka(){
        return kulickaCerna;
    }

    public static Icon getBilaKulicka(){
        return kulickaBila;
    }
}
