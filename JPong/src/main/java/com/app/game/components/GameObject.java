/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.game.components;

import java.awt.Graphics;
import java.awt.Point;

/**
 * abstract base class for gameObjects
 * @author Jere
 */
public abstract class GameObject {
    
    private double x;
    private double y;
    
    public GameObject(double x, double y){
        this.x = x; 
        this.y = y;
    }
    /**
     * Sets the position of the gameObject
     * @param x wanted x coord
     * @param y wanted y coord
     */
    public void setPos(double x, double y){
        this.x = x;
        this.y = y;
    }
    /**
     * 
     * @return x coordinate of position
     */
    public double getX(){
        return this.x;
    }
    /**
     * 
     * @return y coordinate of position
     */
    public double getY(){
        return this.y;
    }

    public abstract void Paint(Graphics g);
            
}
