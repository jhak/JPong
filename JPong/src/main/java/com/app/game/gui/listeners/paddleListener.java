/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.game.gui.listeners;

import com.app.game.components.Paddle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jere
 */
public class PaddleListener implements KeyListener {

    private Paddle p;
    private boolean player1;
    /**
     * 
     * @param p paddle to be listened
     * @param player1 boolean defining which controls human player uses, true for arrows, false for W and S
     */
    public PaddleListener(Paddle p, boolean player1) {
        this.p = p;
        this.player1 = player1;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (player1) {
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                this.p.setPos(p.getX(), p.getY() - 15);
            }

            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                this.p.setPos(p.getX(), p.getY() + 15);
            }
        } else {

            if (e.getKeyCode() == KeyEvent.VK_W) {
                this.p.setPos(p.getX(), p.getY() - 15);
            }

            if (e.getKeyCode() == KeyEvent.VK_S) {
                this.p.setPos(p.getX(), p.getY() + 15);
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
       
    }

}
