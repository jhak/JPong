/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.game;

import com.app.game.components.Paddle;
import java.util.Random;

/**
 *class handing ultra-basic AI paddle movements
 *@author Jere
 */
public class AI {
    private Paddle p;
    private Game game;
    private Random random = new Random();
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
     * makes basic AI move based on ball velocity & makes random mistakes by not moving accordingly
     */
    public void movePaddle(){
        if(this.game.getGameBall().getyVelo() > 0){
            if(this.game.getGameBall().getY() > p.getY()+85)
                if(random.nextInt(10) > 1) 
                    this.p.setPos(p.getX(), p.getY() + 15);
        } else {
            if(this.game.getGameBall().getY() < p.getY())
                if(random.nextInt(10) > 1)
                    this.p.setPos(p.getX(), p.getY() - 15);
        }
    }
    
}
