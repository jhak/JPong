/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.game;

import com.app.game.components.Paddle;

/**
 *class handing ultra-basic AI paddle movements
 *@author Jere
 */
public class AI {
    private Paddle p;
    private Game game;
    /**
     * 
     * @param game current game
     * @param paddle paddle for AI to move
     */
    public AI(Game game, Paddle paddle){
        this.p = paddle;
        this.game = game;
    }
    /**
     * makes basic AI move based on ball velocity
     */
    public void movePaddle(){
        if(this.game.getGameBall().getyVelo() > 0){
            this.p.setPos(p.getX(), p.getY() + 15);
        } else {
            this.p.setPos(p.getX(), p.getY() - 15);
        }
    }
    
}
