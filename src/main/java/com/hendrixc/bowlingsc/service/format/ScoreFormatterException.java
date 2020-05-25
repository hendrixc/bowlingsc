/*
 * System: Bowling Score Calculator
 * Author: Henry Coral
 * 
 * This program is for demo purposes, you can use or modify it under your own risk.
 */
package com.hendrixc.bowlingsc.service.format;

/**
 * Represents an exception occurred in the score formatter process.
 * @author Henry Coral
 */
public class ScoreFormatterException extends Exception {

    /**
     * Constructs a new ScoreFormatterException with null as its detail message.
     */
    public ScoreFormatterException() {
    }

    /**
     * Constructs a new ScoreFormatterException with the specified detail message.
     * @param message the detail message.
     */
    public ScoreFormatterException(String message) {
        super(message);
    }
    
}
