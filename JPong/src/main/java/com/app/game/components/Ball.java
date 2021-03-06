/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.game.components;

import java.awt.Graphics;
import java.util.Random;

/**
 * Class containing all essentials for the gameball.
 * @author Jere
 */
public class Ball extends GameObject{
    
    private float xVelo;
    private float yVelo;
    
    
    public Ball(double x, double y){
      super(x,y);
      this.xVelo = 5 + new Random().nextInt(5);
      this.yVelo = 5 + new Random().nextInt(5);
      if(new Random().nextInt(2) == 1){
          xVelo *=-1;
      }
      if(new Random().nextInt(2) == 1){
          yVelo *=-1;
      }
    }

    @Override
    public void Paint(Graphics g) {
        g.fillOval((int)this.getX(), (int)this.getY(), 5, 5);
    }
    /**
     * Moves the ball and increases velocity
     */
    public void move(){
        this.setPos(this.getX() + this.xVelo, this.getY() + this.yVelo);
        this.xVelo *=1.008;
        this.yVelo *=1.008;
        if(Math.abs(xVelo) > 15){
            if(xVelo < 0) {
                xVelo = -15;
            } else {
                xVelo = 15;
            }
        }
        if(Math.abs(yVelo) > 15){
            if(yVelo < 0) {
                yVelo = -15;
            } else {
                yVelo = 15;
            }
        }
        
    }
    /**
     * handles X collision
     */
    public void handleCollisionX() {
        this.xVelo *= -1;
    }
    /**
     * 
     * @return current x velocity
     */
    public float getxVelo() {
        return xVelo;
    }
    /**
     * sets x Velocity
     * @param xVelo wanted x velocity
     */
    public void setxVelo(float xVelo) {
        this.xVelo = xVelo;
    }
    /**
     * 
     * @return current y velocity
     */
    public float getyVelo() {
        return yVelo;
    }
    /**
     * Sets y velocity 
     * @param yVelo wanted y velocity
     */
    public void setyVelo(float yVelo) {
        this.yVelo = yVelo;
    }
    /**
     * handles Y collision
     */
    public void handleCollisionY() {
        this.yVelo *= -1;
    }
    
    
   
   
    
}
