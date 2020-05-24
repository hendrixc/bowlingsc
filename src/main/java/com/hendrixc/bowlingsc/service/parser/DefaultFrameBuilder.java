/*
 * System: Bowling Score Calculator
 * Author: Henry Coral
 * 
 * This program is for demo purposes, you can use or modify it under your own risk.
 */
package com.hendrixc.bowlingsc.service.parser;

import com.hendrixc.bowlingsc.BowlingRules;
import com.hendrixc.bowlingsc.model.Frame;

/**
 *
 * @author Henry Coral
 */
public class DefaultFrameBuilder implements FrameBuilder{
    
    private static final Integer FIRST_TURN = 1; 

    @Override
    public Frame build(Frame frame, Integer pins) throws ParserException {
        Frame result;
        if (frame == null) {
            result = new Frame(DefaultFrameBuilder.FIRST_TURN);
            result.setFirstBall(pins);
        } else {
            if (BowlingRules.MAX_FRAMES.value()<frame.getTurn()) {
                if (BowlingRules.MAX_PINES.value()==frame.getFirstBall()) {
                    result = new Frame(frame.getTurn()+1);
                    result.setFirstBall(pins);
                } else {
                    if (frame.getFirstBall()+pins>BowlingRules.MAX_PINES.value()) {
                        throw new ParserException("The sum of first and second throws exceed the max pines number.");
                    }
                    frame.setSecondBall(pins);
                    result = frame;
                }
            } else  {
                if (frame.getSecondBall()==null) {
                    frame.setSecondBall(pins);
                    result = frame;
                } else if (BowlingRules.MAX_PINES.value()==frame.getFirstBall()) {
                    frame.setBonusBall(pins);
                    result = frame;
                } else {
                    throw new ParserException();
                }
            }
            
        } 
        return result;
    }
    
}
