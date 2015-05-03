/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.game;

import com.app.game.components.Ball;
import com.app.game.components.Paddle;
import com.app.game.gui.GameFrame;
import java.awt.Color;
import java.awt.Dimension;
import javafx.scene.text.Font;
import javax.swing.JOptionPane;

/**
 *Core class that binds the game pieces together
 *@author Jere
 */
public class Game {

    private Paddle player1Paddle;
    private Paddle player2Paddle;
    private Ball gameBall;
    private int player1Score;
    private int player2Score;
    public GameFrame gameFrame;
    private Thread gameThread;
    private boolean debug = true;
    private Dimension dimension;
    private AI ai;
    private boolean player1Won;
    private boolean player2Won;
    private volatile boolean shouldGameStop = true;

    /**
     * creates a new gameFrame and calls startGame()
     */
    public Game() {
        this.gameFrame = new GameFrame(this);
        startGame(this.gameFrame.getGamePanel().getSize());
    }

    /**
     * Sets up a fresh start for a new game and calls runGame()
     *
     * @param d gamePanel size
     */
    public void startGame(Dimension d) {
        this.dimension = d;
        this.player1Paddle = new Paddle(50, d.height / 2 - 42.5);
        this.player2Paddle = new Paddle(d.getWidth() - 50, d.height / 2 - 42.5);
        this.gameBall = new Ball(d.getWidth() / 2, d.getHeight() / 2);
        this.gameFrame.setPaddleListener();
        this.player1Score = 0;
        this.player2Score = 0;
        this.player1Won = false;
        this.player2Won = false;
        this.ai = new AI(this, player2Paddle);
        this.shouldGameStop = false;
        runGame();
    }

    /**
     * Returns reference to player 1's paddle
     *
     * @return player 1's paddle
     */
    public Paddle getPlayer1Paddle() {
        return this.player1Paddle;
    }

    /**
     * Returns reference to player 2's paddle
     *
     * @return player 2's paddle
     */
    public Paddle getPlayer2Paddle() {
        return this.player2Paddle;
    }

    /**
     * Returns reference to current game ball
     *
     * @return current game ball
     */
    public Ball getGameBall() {
        return this.gameBall;
    }

    /**
     * @return player 1's score
     *
     */
    public int getPlayer1Score() {
        return this.player1Score;
    }

    /**
     * @return player 2's score
     *
     */
    public int getPlayer2Score() {
        return this.player2Score;
    }

    /**
     * tells game thread to stop
     */
    public void stopGame() {
        this.shouldGameStop = true;
    }

    /**
     * tells if game thread should stop ie. is certain boolean true
     * @return boolean telling if the game should stop
     */
    public boolean shouldGameStop() {
        return this.shouldGameStop;
    }

    /**
     * Handles a game tick, calls for gameball move, ai move, checks for a goal
     * and calls for collision handling, calls gamepanel repaint in the end
     * @throws InterruptedException
     */
    public void tick() throws InterruptedException {
        handleCollision();
        getGameBall().move();
        this.ai.movePaddle();
        checkForGoal();
        
        this.gameFrame.getGamePanel().repaint();    
    }
    
    public void displayErrorWarning(){
        JOptionPane.showMessageDialog(this.gameFrame, "Minor error occured during the game loop", "Error", JOptionPane.ERROR_MESSAGE);
    }

 /**
  *checks for goal and increases coal count & sets the gameball to the middle
  *@throws InterruptedException 
  */
    public void checkForGoal() throws InterruptedException {

        if (getGameBall().getX() + getGameBall().getxVelo() < 0) {
            this.gameBall = new Ball(this.dimension.getWidth() / 2, this.dimension.getHeight() / 2);
            this.player2Score++;
        }

        if (getGameBall().getX() + getGameBall().getxVelo() > this.gameFrame.getGamePanel().getWidth()) {
            this.gameBall = new Ball(this.dimension.getWidth() / 2, this.dimension.getHeight() / 2);
            this.player1Score++;
        }
    }

    /**
     * handles collision detection and adjusts ball velocity values accordingly.
     */
    public void handleCollision() {
        if (getPlayer1Paddle().getPaddleRect().contains(getGameBall().getX() + getGameBall().getxVelo(), getGameBall().getY())) {
            getGameBall().handleCollisionX();
        }
        if (getPlayer1Paddle().getPaddleRect().contains(getGameBall().getX(), getGameBall().getY() + getGameBall().getyVelo())) {
            getGameBall().handleCollisionY();
        }

        if (getPlayer2Paddle().getPaddleRect().contains(getGameBall().getX() + getGameBall().getxVelo(), getGameBall().getY())) {
            getGameBall().handleCollisionX();
        }
        if (getPlayer2Paddle().getPaddleRect().contains(getGameBall().getX(), getGameBall().getY() + getGameBall().getyVelo())) {
            getGameBall().handleCollisionY();
        }

        if ((getGameBall().getX() + getGameBall().getxVelo()) >= this.gameFrame.getGamePanel().getWidth() || (getGameBall().getX() + getGameBall().getxVelo()) <= 0) {
            getGameBall().handleCollisionX();
        }

        if ((getGameBall().getY() + getGameBall().getyVelo()) >= this.gameFrame.getGamePanel().getHeight() || (getGameBall().getY() + getGameBall().getyVelo()) <= 0) {
            getGameBall().handleCollisionY();
        }

        if ((getPlayer1Paddle().getY() < 0)) {
            getPlayer1Paddle().setPos(getPlayer1Paddle().getX(), 0);
        } else if ((getPlayer1Paddle().getPaddleRect().getHeight() + getPlayer1Paddle().getY() > this.gameFrame.getGamePanel().getHeight())) {
            getPlayer1Paddle().setPos(getPlayer1Paddle().getX(), this.gameFrame.getGamePanel().getHeight() - getPlayer1Paddle().getPaddleRect().getHeight());
        }

        if ((getPlayer2Paddle().getY() < 0)) {
            getPlayer2Paddle().setPos(getPlayer2Paddle().getX(), 0);
        } else if ((getPlayer2Paddle().getPaddleRect().getHeight() + getPlayer2Paddle().getY() > this.gameFrame.getGamePanel().getHeight())) {
            getPlayer2Paddle().setPos(getPlayer2Paddle().getX(), this.gameFrame.getGamePanel().getHeight() - getPlayer2Paddle().getPaddleRect().getHeight());
        }
    }

    /**
     * creates a new game thread and starts it
     */
    public void runGame() {
        gameThread = new Thread() {
            @Override
            public void run() {             
                while (true) {
                    try {
                        Thread.sleep(30);
                        tick();
                        
                        if (getPlayer1Score() > 9) {
                            player1Won = true;
                            break;
                        } else if (getPlayer2Score() > 9) {
                            player2Won = true;
                            break;
                        }

                    } catch (InterruptedException ie) {
                        displayErrorWarning();
                    }
                    if (shouldGameStop()) {
                        break;
                    }
                }
            }
        };
        gameThread.start();
    }

}
