/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.game.components;

import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author Jere
 */
public abstract class GameObject {
    
    private double x;
    private double y;
    
    public GameObject(double x, double y){
        this.x = x; 
        this.y = y;
    }
    
    public void setPos(double x, double y){
        this.x = x;
        this.y = y;
    }
    
    public double getX(){
        return this.x;
    }
    
    public double getY(){
        return this.y;
    }
    
    public abstract void Paint(Graphics g);
            
}
