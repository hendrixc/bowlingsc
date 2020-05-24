/*
 * System: Bowling Score Calculator
 * Author: Henry Coral
 * 
 * This program is for demo purposes, you can use or modify it under your own risk.
 */
package com.hendrixc.bowlingsc.service.format;

import com.hendrixc.bowlingsc.model.Player;


/**
 *
 * @author Henry Coral
 */
public interface ScoreFormatter {
    
    /**
     * 
     * @param player
     * @return 
     */
    String format(Player player);
}
