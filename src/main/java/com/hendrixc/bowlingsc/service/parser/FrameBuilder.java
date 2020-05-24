/*
 * System: Bowling Score Calculator
 * Author: Henry Coral
 * 
 * This program is for demo purposes, you can use or modify it under your own risk.
 */
package com.hendrixc.bowlingsc.service.parser;

import com.hendrixc.bowlingsc.model.Frame;

/**
 * Interface that defines the methods to be implemented by a Frame builder class.
 * 
 * @author Henry Coral
 */
public interface FrameBuilder {
    
    /**
     * Build the new Frame object according to the received parameters.
     * The implementation of this method must considerer the rules of the ten-pines bowling game to decide 
     * if it is necessary to create a new Frame object increasing the turn number and assigning the value 
     * of the first throw or if its only updated the value of the second or extra throw.
     * 
     * @param frame last object of the player frames list. See {@link com.hendrixc.bowlingsc.model.Player#getLastFrame()} 
     * for more details.
     * @param pines number of pines knocked down in a player attempt.
     * @return new Frame object to be added to player frames.
     * @throws ParserException an exception
     */
    Frame build(Frame frame, Integer pines) throws ParserException;
    
}
