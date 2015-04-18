/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.game;

import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jere
 */
public class GameTest {
    
    public GameTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testStartGame() {
        Game instance = new Game();
        instance.startGame(new Dimension(new Dimension(300,300)));
        assertNotNull(instance.getGameBall());
    }
    
    @Test
    public void testCheckCollisionBall() {
        Game instance = new Game();
        float negativeVelo = -5;
        instance.startGame(new Dimension(new Dimension(300,300)));
        instance.getGameBall().setPos(0, 0);
        instance.getGameBall().setxVelo(negativeVelo);
        instance.getGameBall().setyVelo(0);
        try {
            instance.tick();
        } catch (InterruptedException ex) {
      
        }
        assertTrue(negativeVelo<(int)instance.getGameBall().getxVelo());
    }
    
    
}
