/*
 * System: Bowling Score Calculator
 * Author: Henry Coral
 * Stage: Unit Test
 * 
 * This program is for demo purposes, you can use or modify it under your own risk.
 */
package com.hendrixc.bowlingsc.test.ut;

import com.hendrixc.bowlingsc.model.Frame;
import java.util.logging.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

/**
 * Test Cases for Frame class.
 * @author Henry Coral
 */
public class FrameTest {
    
    private static final Logger LOG = Logger.getLogger(FrameTest.class.getName());
    
    public FrameTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        LOG.info("Starting Frame TestCases");
    }
    
    @AfterClass
    public static void tearDownClass() {
         LOG.info("Frame TestCases finished");
    }
    
    /**
     * Test the default creation of a Frame.
     */
    @Test
    public void testFrameDefaultCreation() {
        Frame frame = new Frame(1);
        Assertions.assertEquals(1, frame.getTurn());
        Assertions.assertNull(frame.getFirstBall());
        Assertions.assertNull(frame.getSecondBall());
        Assertions.assertNull(frame.getBonusBall());
        Assertions.assertNull(frame.getScore());
    }

    
}
