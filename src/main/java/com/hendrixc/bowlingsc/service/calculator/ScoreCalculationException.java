/*
 * System: Bowling Score Calculator
 * Author: Henry Coral
 * 
 * This program is for demo purposes, you can use or modify it under your own risk.
 */
package com.hendrixc.bowlingsc.service.calculator;

/**
 * Represents an exception occurred in the score calculation process.
 * @author Henry Coral
 */
public class ScoreCalculationException extends Exception {

    /**
     * Constructs a new ScoreCalculationException with null as its detail message.
     */
    public ScoreCalculationException() {
        super();
    }

    /**
     * Constructs a new ScoreCalculationException with the specified detail message.
     * @param message the detail message.
     */
    public ScoreCalculationException(String message) {
        super(message);
    }
    
}
