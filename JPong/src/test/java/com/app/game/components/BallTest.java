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
public class BallTest {

    public BallTest() {
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

    /**
     * Test of move method, of class Ball.
     */
    @Test
    public void testMove() {

        Ball instance = new Ball(50, 50);
        double x = instance.getX();
        double y = instance.getY();
        instance.move();
        assertNotSame(new Point((int) x, (int) y), new Point((int) instance.getX(), (int) instance.getY()));
    }

    @Test
    public void testVelocityIncreaseX() {

        Ball instance = new Ball(50, 50);
        float x = instance.getxVelo();
        instance.move();
        assertNotSame(x, instance.getxVelo());
    }

    @Test
    public void testVelocityIncreaseY() {

        Ball instance = new Ball(50, 50);
        float y = instance.getyVelo();
        instance.move();
        assertNotSame(y, instance.getyVelo());
    }

    /**
     * Test of handleCollisionX method, of class Ball.
     */
    @Test
    public void testHandleCollisionX() {

        Ball instance = new Ball(50, 50);
        double velX = instance.getxVelo();
        instance.handleCollisionX();
        assertNotSame(velX, instance.getxVelo());

    }

    /**
     * Test of handleCollisionX method, of class Ball.
     */
    @Test
    public void testHandleCollisionY() {

        Ball instance = new Ball(50, 50);
        double velY = instance.getyVelo();
        instance.handleCollisionY();
        assertNotSame(velY, instance.getyVelo());

    }

}
