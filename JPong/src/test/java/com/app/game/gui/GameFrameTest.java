/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.game.gui;

import com.app.game.Game;
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
public class GameFrameTest {
    
    public GameFrameTest() {
    
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
    public void testGetGamePanel() {
        System.out.println("getGamePanel");
        assertNotNull(new GameFrame(new Game()).getGamePanel());
    }
    
    @Test
    
    public void testIsVisible(){
        System.out.println("testIsVisible");
        GameFrame gf = new GameFrame(new Game());
        assertTrue(gf.isVisible());
    }
    
}
