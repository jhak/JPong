/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.game.gui;

import com.app.game.Game;
import com.app.game.gui.listeners.PaddleListener;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * Main GUI of the game
 * @author Jere
 */
public class GameFrame extends JFrame {

    private GamePanel gamePanel;
    private Game game;
    private JMenuBar menuBar;
    private JMenu options;
    private JMenuItem startGame;
    private JMenuItem stopGame;
    
    /**
     * builds a new gameFrame
     *
     * @param game the game you are using this frame for
     */
    public GameFrame(Game game) {

        this.game = game;
        this.gamePanel = new GamePanel(game, new Dimension(780, 400));
        this.menuBar = new JMenuBar();
        this.options = new JMenu("Options");
        this.startGame = new JMenuItem("Start game");
        this.stopGame = new JMenuItem("Stop game");

        this.options.add(startGame);
        this.options.add(stopGame);
        this.menuBar.add(this.options);
        
        this.startGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getGame().startGame(getGamePanel().getSize());
            }
        });

        stopGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                getGame().stopGame();
            }
        });
        
        setResizable(false);
        setTitle("JPong");
        setSize(new Dimension(900, 900));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        add(menuBar, BorderLayout.NORTH);
        add(gamePanel, BorderLayout.SOUTH);

        pack();
        setVisible(true);

    }

    /**
     *
     * @return current gamePanel object
     */
    public GamePanel getGamePanel() {
        return this.gamePanel;
    }

    /**
     *
     * @return current game object
     */
    public Game getGame() {
        return this.game;
    }

    /**
     * sets the paddleListeners for human players
     */
    public void setPaddleListener() {
        this.addKeyListener(new PaddleListener(this.game.getPlayer1Paddle(), true));
        this.addKeyListener(new PaddleListener(this.game.getPlayer2Paddle(), false));
    }
    


}
