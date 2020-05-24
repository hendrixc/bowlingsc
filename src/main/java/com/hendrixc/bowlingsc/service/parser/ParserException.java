/*
 * System: Bowling Score Calculator
 * Author: Henry Coral
 * 
 * This program is for demo purposes, you can use or modify it under your own risk.
 */
package com.hendrixc.bowlingsc.service.parser;

/**
 * Represents an exception occurred in the text parse process.
 * @author Henry Coral
 */
public class ParserException extends Exception{

    /**
     * Constructs a new ParserException with null as its detail message.
     */
    public ParserException() {
    }

    /**
     * Constructs a new ParserException with the specified detail message.
     * @param message the detail message.  
     */
    public ParserException(String message) {
        super(message);
    }
    
    
    
}
