/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ui.gui.icons;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author notebook
 */
public class IconLoader {
    
    java.net.URL imageURL = IconLoader.class.getResource("images/myImage.gif");

    public static Icon loadOrangeRing(){
        return new ImageIcon(IconLoader.class.getResource("orange.png"));
    }
    
     public static Icon loadBlackRing(){
        return new ImageIcon(IconLoader.class.getResource("black.png"));
    }
     
     public static Icon loadWhiteRing(){
        return new ImageIcon(IconLoader.class.getResource("ring.png"));
    }
    
}
