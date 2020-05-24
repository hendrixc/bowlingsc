/*
 * System: Bowling Score Calculator
 * Author: Henry Coral
 * 
 * This program is for demo purposes, you can use or modify it under your own risk.
 */
package com.hendrixc.bowlingsc.service.calculator;

import com.hendrixc.bowlingsc.model.Player;

/**
 * Define the methods must be implemented to create an ScoreCalculator implementation.
 * A Score Calculator implementation must be able to calculate the final acumulate score for each player and all partial scores of each frame.
 * 
 * @author Henry Coral
 */
public interface ScoreCalculator {
    
    /**
     * Calculates the final score for the player and all partial scores for each frame.
     * 
     * @param player A valid player with all frames.
     * @return a player with the scores calculate for each frame and final score.
     * @throws ScoreCalculationException when the calculus fails due to logical error in frames contents.
     */
    Player calculate(Player player) throws ScoreCalculationException;
    
}
