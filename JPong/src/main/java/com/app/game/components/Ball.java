/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.game.components;

import java.awt.Graphics;
import java.util.Random;

/**
 *
 * @author Jere
 */
public class Ball extends GameObject{
    
    private float xVelo;
    private float yVelo;
    
    
    public Ball(double x, double y){
      super(x,y);
      this.xVelo = 1 + new Random().nextInt(10);
      this.yVelo = 1 + new Random().nextInt(10);
    }

    @Override
    public void Paint(Graphics g) {
        g.fillOval((int)this.getX(), (int)this.getY(), 5, 5);
    }
    
    public void move(){
        this.setPos(this.getX() + this.xVelo, this.getY() + this.yVelo);
        this.xVelo *=1.008;
        this.yVelo *=1.008;
    }
    
    public void handleCollisionX() {
        this.xVelo *= -1;
    }

    public float getxVelo() {
        return xVelo;
    }

    public void setxVelo(float xVelo) {
        this.xVelo = xVelo;
    }

    public float getyVelo() {
        return yVelo;
    }

    public void setyVelo(float yVelo) {
        this.yVelo = yVelo;
    }
    
    public void handleCollisionY() {
        this.yVelo *= -1;
    }
    
    
   
   
    
}
