/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.game.components;

/**
 *
 * @author Jere
 */
public class Ball extends GameObject{
    private double x;
    private double y;
    
    public Ball(double x, double y){
        this.x = x;
        this.y = y;
    }
    
    public void setPos(double x, double y){
        this.x = x;
        this.y = y;
    }
    
}
