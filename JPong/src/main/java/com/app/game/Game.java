/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.game;

import com.app.game.components.Ball;
import com.app.game.components.Paddle;
import com.app.game.gui.GameFrame;
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
    private GameFrame gameFrame;
    private Thread gameThread;
    private boolean debug = true;

    public Game() {
        this.gameFrame = new GameFrame(this);
        startGame(this.gameFrame.getGamePanel().getSize());
        System.out.println("test");
    }

    //sets up a fresh start for a new game and starts the game
    public void startGame(Dimension d) {
        this.player1Paddle = new Paddle(50, d.height / 2 - 42.5);
        this.player2Paddle = new Paddle(d.getWidth() - 50, d.height / 2 - 42.5);
        this.gameBall = new Ball(d.getWidth() / 2, d.getHeight() / 2);
        this.gameFrame.setPaddleListener();
        runGame();
    }

    public Paddle getPlayer1Paddle() {
        return this.player1Paddle;
    }

    public Paddle getPlayer2Paddle() {
        return this.player2Paddle;
    }

    public Ball getGameBall() {
        return this.gameBall;
    }

    public int getPlayer1Score() {
        return this.player1Score;
    }

    public int getPlayer2Score() {
        return this.player2Score;
    }

    public void tick() {
        getGameBall().move();
        handleCollision();
        this.gameFrame.getGamePanel().repaint();
    }

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

    public void runGame() {
        this.gameThread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    tick();
                    try {
                        Thread.sleep(40);
                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }
                }
            }
        };
        gameThread.start();
    }

}
