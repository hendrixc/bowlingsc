/*
 * System: Bowling Score Calculator
 * Author: Henry Coral
 * Stage: Unit Test
 * 
 * This program is for demo purposes, you can use or modify it under your own risk.
 */
package com.hendrixc.bowlingsc.test.ut;

import com.hendrixc.bowlingsc.model.Frame;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Test Cases for Frame class.
 *
 * @author Henry Coral
 */
@DisplayName("Tests for Frame model class")
public class FrameTest {

    /**
     * Test the default creation of a Frame.
     */
    @Test
    @DisplayName("Frame default creation (with number of turn)")
    public void testFrameDefaultCreation() {
        Frame frame = new Frame(1);
        Assertions.assertEquals(1, frame.getTurn());
        Assertions.assertNull(frame.getFirstBall());
        Assertions.assertNull(frame.getSecondBall());
        Assertions.assertNull(frame.getBonusBall());
        Assertions.assertNull(frame.getScore());
    }

}
