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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 * GamePanel, ie. the actual game arena for the game.
 * @author Jere
 *
 */
public class GamePanel extends JPanel {

    private Game game;
    private Dimension d;

    /**
     * 
     * @param game the current game
     * @param d wanted dimension
     */
    public GamePanel(Game game, Dimension d) {
        this.game = game;
        this.d = d;
        setPreferredSize(this.d);
        setVisible(true);
 
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, (int) d.getWidth(), (int) d.getHeight());
        g.setColor(Color.GREEN);
        this.game.getGameBall().Paint(g);
        this.game.getPlayer1Paddle().Paint(g);
        this.game.getPlayer2Paddle().Paint(g);
        g.drawString(this.game.getPlayer1Score() + " - " + this.game.getPlayer2Score(), (this.d.width / 2) - 15, 30);
    }

}
