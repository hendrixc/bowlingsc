/*
 * System: Bowling Score Calculator
 * Author: Henry Coral
 * 
 * This program is for demo purposes, you can use or modify it under your own risk.
 */
package com.hendrixc.bowlingsc.service.parser;

/**
 * Class used to obtain values for name and pines number from each text line.
 * @author Henry Coral
 */
public class LineContent {
    
    /**
     * Property name, represents a player name.
     */
    private String name;
    
    /**
     * Property pines, represents a number of pines. 
     */
    private Integer pines;

    /**
     * Getter method for name property.
     * @return player name.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for name property.
     * @param name name of the player.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for pines property.
     * @return number of pines knocked down.
     */
    public Integer getPines() {
        return pines;
    }

    /**
     * Setter method for pines property.
     * @param pines number of pines knocked down;
     */
    public void setPines(Integer pines) {
        this.pines = pines;
    }
    
}
