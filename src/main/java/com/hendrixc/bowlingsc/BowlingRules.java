/*
 * System: Bowling Score Calculator
 * Author: Henry Coral
 * 
 * This program is for demo purposes, you can use or modify it under your own risk.
 */
package com.hendrixc.bowlingsc;

/**
 * BowlingRules is an enum that define the values for some rules of Ten Pin Bowling game.
 * @author Henry Coral
 */
public enum BowlingRules {
    
    /**
     * Minimun number of players 1.
     */
    MIN_PLAYERS(1),
    /**
     * Maximun number of players 6.
     */
    MAX_PLAYERS(6),
    /**
     * Maximun number of Frames 10.
     */
    MAX_FRAMES(10),
    /**
     * Maximun number of pines 10.
     */
    MAX_PINES(10);
    
    /**
     * Internal variable to assign the value related to the enumeration element.
     */
    private final int value;
    
    /**
     * Default constructor for this Enumeration.
     * @param value Value related to enumeration element.
     */
    private BowlingRules(int value) {
        this.value = value;
    }

    /**
     * Return the value associated with the enumeration element.
     * @return Value of enumeration element.
     */
    public int value() {
        return value;
    }
    
    
}
