/*
 * System: Bowling Score Calculator
 * Author: Henry Coral
 * Stage: Unit Test
 * 
 * This program is for demo purposes, you can use or modify it under your own risk.
 */
package com.hendrixc.bowlingsc.test.ut;

import com.hendrixc.bowlingsc.model.Frame;
import com.hendrixc.bowlingsc.service.parser.DefaultFrameBuilder;
import com.hendrixc.bowlingsc.service.parser.FrameBuilder;
import com.hendrixc.bowlingsc.service.parser.ParserException;
import java.util.logging.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Test Cases for Frame class.
 *
 * @author Henry Coral
 */
@DisplayName("Tests for Frame model class")
public class DefaultFrameBuilderTest {

    private static final Logger LOG = Logger.getLogger(DefaultFrameBuilderTest.class.getName());
    
    private final FrameBuilder builder = new DefaultFrameBuilder();
    
    @Test
    @DisplayName("build a Frame with from null")
    public void testWithNullFrame() {
        try {
            Frame frame = builder.build(null, 0);
            Assertions.assertAll("frame",
                    ()->Assertions.assertEquals(Integer.valueOf(1), frame.getTurn()),
                    ()->Assertions.assertEquals(Integer.valueOf(0), frame.getFirstBall()),
                    ()->Assertions.assertNull(frame.getSecondBall()),
                    ()->Assertions.assertNull(frame.getBonusBall()),
                    ()->Assertions.assertNull(frame.getScore())
            );
        } catch (ParserException pe) {
            LOG.info("Exception to execute testWithNullFrame::"+pe.getMessage());
        }
    }
    
    @Test
    @DisplayName("build a Frame with existing frame with one ball filled")
    public void testWithExistingFrameSecondThrow() {
        try {
            Frame frameTest = new Frame(1);
            frameTest.setFirstBall(1);
            Frame frame = builder.build(frameTest, 0);
            Assertions.assertAll("frame",
                    ()->Assertions.assertEquals(Integer.valueOf(1), frame.getTurn()),
                    ()->Assertions.assertEquals(Integer.valueOf(1), frame.getFirstBall()),
                    ()->Assertions.assertEquals(Integer.valueOf(0), frame.getSecondBall()),
                    ()->Assertions.assertNull(frame.getBonusBall()),
                    ()->Assertions.assertNull(frame.getScore())
            );
        } catch (ParserException pe) {
            LOG.info("Exception to execute testWithNullFrame::"+pe.getMessage());
        }
    }
    
    @Test
    @DisplayName("build a Frame passing a frame with all balls filled")
    public void testWithExistingFrameAllThrows() {
        try {
            Frame frameTest = new Frame(1);
            frameTest.setFirstBall(1);
            frameTest.setSecondBall(1);
            Frame frame = builder.build(frameTest, 0);
            Assertions.assertAll("frame",
                    ()->Assertions.assertEquals(Integer.valueOf(1), frame.getTurn()),
                    ()->Assertions.assertEquals(Integer.valueOf(0), frame.getFirstBall()),
                    ()->Assertions.assertNull(frame.getSecondBall()),
                    ()->Assertions.assertNull(frame.getBonusBall()),
                    ()->Assertions.assertNull(frame.getScore())
            );
        } catch (ParserException pe) {
            LOG.info("Exception to execute testWithNullFrame::"+pe.getMessage());
        }
    }
}
