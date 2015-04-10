/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.game.components;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Jere
 */
public class Paddle extends GameObject {
    private Rectangle paddleRect;
    
    public Paddle(double x, double y){
        super(x,y);
        
    }
    
    public Rectangle getPaddleRect(){
        return new Rectangle((int)this.getX(), (int)this.getY(), 10, 85);
    }
    
    @Override
    public void Paint(Graphics g) {
        g.fillRect((int)this.getX(), (int)this.getY(), 10, 85);
    }
    
}
