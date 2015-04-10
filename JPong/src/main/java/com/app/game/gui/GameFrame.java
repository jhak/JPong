/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.game.gui;

import com.app.game.Game;
import com.app.game.gui.listeners.paddleListener;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Jere
 */
public class GameFrame extends JFrame{
    private GamePanel gamePanel;
    private Game game;
    private JMenuBar menuBar;
    private JMenu options;
    private JMenuItem startGame;
    private JMenuItem stopGame;
    
    
    public GameFrame(Game game){
        this.game = game;
        this.gamePanel = new GamePanel(game, new Dimension(780,400));
        this.menuBar = new JMenuBar();
        this.options = new JMenu("Options");
        this.startGame = new JMenuItem("Start game");
        this.stopGame = new JMenuItem("Stop game");
        
        this.options.add(startGame);
        this.options.add(stopGame);
        this.menuBar.add(this.options);
        
        setResizable(false);
        setTitle("JPong");
        setSize(new Dimension(900,900));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLayout(new BorderLayout());
        this.gamePanel.addKeyListener(new paddleListener(this.game.getPlayer1Paddle(),this.game.getPlayer2Paddle()));
        add(menuBar, BorderLayout.NORTH);
        add(gamePanel, BorderLayout.SOUTH);
        
        pack();
        setVisible(true);
        
    }
    
    
    public GamePanel getGamePanel(){
        return this.gamePanel;
    }
    
    public void setPaddleListener(){
        
    }
    
}
