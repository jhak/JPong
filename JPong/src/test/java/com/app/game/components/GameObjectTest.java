/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.game.components;

import java.awt.Graphics;
import java.awt.Point;
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
public class GameObjectTest {
    
    public GameObjectTest() {
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
    public void testSetPos() {
        System.out.println("setPos test");
        double x = 0.0;
        double y = 0.0;
        GameObject instance = new Ball(x,y);
        instance.setPos(1, 1);
        assertEquals(new Point((int)instance.getX(),(int)instance.getY()), new Point(1,1));
    }


    @Test
    public void testGetX() {
        System.out.println("getX test");
        GameObject instance = new Ball(0,0);
        double expResult = 0.0;
        double result = instance.getX();
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testGetY() {
        System.out.println("getY test");
        GameObject instance = new Ball(0,0);
        double result = instance.getY();
        assertEquals(0.0,instance.getY(),0.0);
    }


    @Test
    public void testPaint() {

    }


    
}
