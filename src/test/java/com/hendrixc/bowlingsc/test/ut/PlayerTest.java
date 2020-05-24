/*
 * System: Bowling Score Calculator
 * Author: Henry Coral
 * Stage: Unit Test
 * 
 * This program is for demo purposes, you can use or modify it under your own risk.
 */
package com.hendrixc.bowlingsc.test.ut;

import com.hendrixc.bowlingsc.BowlingRules;
import com.hendrixc.bowlingsc.model.Frame;
import com.hendrixc.bowlingsc.model.Player;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;


/**
 * Test Cases for Player class.
 * @author Henry Coral
 */
public class PlayerTest {

    private static final Logger LOG = Logger.getLogger(PlayerTest.class.getName());
    
    public PlayerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        LOG.info("Starting Player TestCases");
    }
    
    @AfterClass
    public static void tearDownClass() {
        LOG.info("Player TestCases finished");
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testPlayerDefaultCreation() {
        Player player = new Player();
        Assertions.assertNull(player.getName());
        Assertions.assertEquals(0, player.getTurn());
        Assertions.assertNull(player.getFinalScore());
        Assertions.assertTrue(player.getFrames().isEmpty());
    }
    
    @Test
    public void testPlayerWithNameCreation() {
        Player player = new Player("Henry");
        Assertions.assertEquals("Henry", player.getName());
        Assertions.assertEquals(0, player.getTurn());
        Assertions.assertNull(player.getFinalScore());
        Assertions.assertTrue(player.getFrames().isEmpty());
    }
    
    @Test
    public void testGetLastFrame() {
        Player player = new Player("Henry");
        Assertions.assertNull(player.getLastFrame());
        Frame frame = new Frame(1);
        player.putFrame(frame);
        Assertions.assertEquals(frame, player.getLastFrame());
        frame.setFirstBall(BowlingRules.MAX_PINES.value());
        player.putFrame(frame);
        Assertions.assertEquals(frame, player.getLastFrame());
        Frame last = player.getLastFrame();
        Assertions.assertEquals(frame.getFirstBall(), last.getFirstBall());
    }
}
