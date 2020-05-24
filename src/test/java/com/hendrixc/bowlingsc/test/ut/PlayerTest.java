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
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Test Cases for Player class.
 *
 * @author Henry Coral
 */
@DisplayName("Test Cases for Player model class")
public class PlayerTest {

    /**
     * Test a default creation for Player.
     */
    @Test
    @DisplayName("Player default creation empty constructor")
    public void testPlayerDefaultCreation() {
        Player player = new Player();
        Assertions.assertNull(player.getName());
        Assertions.assertEquals(0, player.getTurn());
        Assertions.assertNull(player.getFinalScore());
        Assertions.assertTrue(player.getFrames().isEmpty());
    }

    /**
     * Test the player creation with a name as parameter.
     */
    @Test
    @DisplayName("Player creation name as parameter")
    public void testPlayerWithNameCreation() {
        Player player = new Player("Henry");
        Assertions.assertEquals("Henry", player.getName());
        Assertions.assertEquals(0, player.getTurn());
        Assertions.assertNull(player.getFinalScore());
        Assertions.assertTrue(player.getFrames().isEmpty());
    }

    /**
     * Test getlastFrame method.
     */
    @Test
    @DisplayName("getlastFrame and putFrame methods working together")
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
