/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.game.gui.listeners;

import com.app.game.components.Paddle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Jere
 */
public class paddleListener implements KeyListener {
    
    private Paddle p1;
    private Paddle p2;
    
    public paddleListener(Paddle p1, Paddle p2){
        this.p1 = p1;
        this.p2 = p2;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getID() == KeyEvent.VK_UP){
            this.p1.setPos(p1.getX(), p1.getY()-3);
        }
        if(e.getID() == KeyEvent.VK_DOWN){
            this.p1.setPos(p1.getX(), p1.getY()+3);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
