/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ui.alg.udalosti;

import java.util.EventListener;

/**
 *
 * @author notebook
 */
public interface CheckpointEventListener extends EventListener {
    public void CheckpointEventOccurred(CheckpointEvent evt);
}
