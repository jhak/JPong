/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.game;

import com.app.game.components.Ball;
import com.app.game.components.Paddle;
import java.awt.Dimension;

/**
 *
 * @author Jere
 * 
 * Core class that binds the game pieces together
 * 
 */
public class Game {
    
    private Paddle player1Paddle;
    private Paddle player2Paddle;
    private Ball gameBall;
    private int player1Score;
    private int player2Score;
    
    public Game(){
        
    }
    //sets up a fresh start for a new game and starts the game
    public void startGame(Dimension d){
        this.player1Paddle = new Paddle();
        this.player2Paddle = new Paddle();
        this.gameBall = new Ball(d.getWidth()/2,d.getHeight()/2);
    }
    
    public Paddle getPlayer1Paddle(){
        return this.player1Paddle;
    }
    
    public Paddle getPlayer2Paddle(){
        return this.player2Paddle;
    }
    
    public Ball getGameBall(){
        return this.gameBall;
    }
    
    public int getPlayer1Score(){
        return this.player1Score;
    }
    
    public int getPlayer2Score(){
        return this.player2Score;
    }
    
    
}
