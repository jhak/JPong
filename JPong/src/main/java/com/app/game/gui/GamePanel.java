/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.game.gui;

import com.app.game.Game;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Jere
 */
public class GamePanel extends JPanel {
    
    private Game game;
    private Dimension d;
    public GamePanel(Game game, Dimension d){
        this.game = game;
        this.d = d;
        setPreferredSize(this.d);
        setVisible(true);
        
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, (int)d.getWidth(), (int)d.getHeight());
        g.setColor(Color.GREEN);
        this.game.getGameBall().Paint(g);
        this.game.getPlayer1Paddle().Paint(g);
        this.game.getPlayer2Paddle().Paint(g);
    }
    
    
}
