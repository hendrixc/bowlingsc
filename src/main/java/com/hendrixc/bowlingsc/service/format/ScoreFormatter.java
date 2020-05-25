/*
 * System: Bowling Score Calculator
 * Author: Henry Coral
 * 
 * This program is for demo purposes, you can use or modify it under your own risk.
 */
package com.hendrixc.bowlingsc.service.format;

import com.hendrixc.bowlingsc.model.Player;
import java.util.List;

/**
 * Define the methods to be implemented for a formatter implementation.
 * A formatter implementation must generate a text from player info.
 * 
 * @author Henry Coral
 */
public interface ScoreFormatter {
    
    /**
     * Produce a string with the information of all players ready to be printed. 
     * To produce the result first add a header call the format(Player player) method for
     * each player of the list.
     * @param players List of players to apply formatter.
     * @return text formatted.
     * @throws ScoreFormatterException an exception if player of their contents are invalid.
     */
    String format(List<Player> players) throws ScoreFormatterException;
    
    /**
     * Produce a string with the information of a player (final score, frames) ready to be printed.
     * 
     * @param player Player object with final score calculated and all their frames. 
     * @return text with the format and data to be showed.
     * @throws ScoreFormatterException an exception is thrown if the player or their final score is null.
     */
    String format(Player player) throws ScoreFormatterException;
}
