/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.game;

import com.app.game.components.Ball;
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
    
    @Test
    public void testCheckForGoalIncreasePlayer2() throws InterruptedException{
      Game instance = new Game();
      instance.getGameBall().setPos(-20, -20);
      instance.checkForGoal();
      assertEquals(1,instance.getPlayer2Score());
    }
    
    @Test
    public void testCheckForGoalIncreasePlayer1() throws InterruptedException{
      Game instance = new Game();
      instance.getGameBall().setPos(instance.gameFrame.getGamePanel().getWidth()+20, 20);
      instance.checkForGoal();
      assertEquals(1,instance.getPlayer1Score());
    }
    
    @Test
    public void testBallResetAfterGoal() throws InterruptedException{
      Game instance = new Game();
      instance.getGameBall().setPos(instance.gameFrame.getGamePanel().getWidth()+20, 20);
      instance.checkForGoal();
      assertNotSame(instance.getGameBall().getX(),instance.gameFrame.getGamePanel().getWidth()+20);
    }
    
    @Test
    public void testStopGame(){
        Game instance = new Game();
        instance.stopGame();
        assertTrue(instance.shouldGameStop());
    }
    
    @Test
    public void testDoesGameStart(){
        Game instance = new Game();
        instance.stopGame();
        instance.startGame(new Dimension(800,800));
        assertFalse(instance.shouldGameStop());
    }
    
    @Test
    public void testTick() throws InterruptedException{
        Game instance = new Game();
        instance.stopGame();
        Ball b = instance.getGameBall();
        double x = b.getX();
        double y = b.getY();
        instance.tick();
        if(b.getX() == x)
            fail("Ball didnt move");
        if(b.getY() == y)
            fail("Ball didnt move");
        
        assertNotNull(instance.getGameBall());
        
    }
}
