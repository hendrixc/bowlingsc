/*
 * System: Bowling Score Calculator
 * Author: Henry Coral
 * 
 * This program is for demo purposes, you can use or modify it under your own risk.
 */
package com.hendrixc.bowlingsc.service.format;

import com.hendrixc.bowlingsc.model.Player;

/**
 * Define the methods to be implemented for a formatter implementation.
 * A formatter implementation must generate a text from player info.
 * 
 * @author Henry Coral
 */
public interface ScoreFormatter {
    
    /**
     * Produce a string with the information of a player (final score, frames) ready to be printed.
     * 
     * @param player Player object with final score calculated and all their frames. 
     * @return text with the format and data to be showed.
     */
    String format(Player player);
}
