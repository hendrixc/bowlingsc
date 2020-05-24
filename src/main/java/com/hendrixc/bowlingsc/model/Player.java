/*
 * System: Bowling Score Calculator
 * Author: Henry Coral
 * 
 * This program is for demo purposes, you can use or modify it under your own risk.
 */
package com.hendrixc.bowlingsc.model;

import com.hendrixc.bowlingsc.BowlingRules;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Model Class that represent a Bowling Player.
 * Each Player has 10 frames to record their throws.
 * 
 * @author Henry Coral
 */
public class Player {
    
    /**
     * Property name, represents a player name.
     */
    private String name;
    
    /**
     * Property frames, contains an ordered list of frames.
     */
    private Map<Integer,Frame> frames;
    
    /**
     * Property finalScore, represents a final score of the player.
     */
    private Integer finalScore;
    
    /**
     * Property turn, represents a number of actual turn of the player.
     */
    private Integer turn;

    /**
     * Default empty constructor. Initialize the values for frames and turn properties.
     */
    public Player() {
        this.frames = new LinkedHashMap<>(BowlingRules.MAX_FRAMES.value());
        this.turn = 0;
    }
    
    /**
     * Create an instance of Player with the provided name. 
     * Initialize the values for frames and turn properties.
     * @param name Name of the player.
     */
    public Player(String name) {
        this();
        this.name = name;
    }

    /**
     * Getter method for name property.
     * @return value of player name.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for name property.
     * @param name value of player name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for finalScore property.
     * @return value of final score.
     */
    public Integer getFinalScore() {
        return finalScore;
    }

    /**
     * Setter method for finalScore property.
     * @param finalScore value of finalScore.
     */
    public void setFinalScore(Integer finalScore) {
        this.finalScore = finalScore;
    }

    /**
     * Getter method for turn property.
     * @return actual turn of the player.
     */
    public Integer getTurn() {
        return turn;
    }

    /**
     * Setter method for turn property.
     * @param turn assign the actual turn of the player.
     */
    public void setTurn(Integer turn) {
        this.turn = turn;
    }
    
    /**
     * Getter method for frames property.
     * @return ordered list of frame objects.
     */
    public List<Frame> getFrames() {
        return this.frames.values().stream().collect(Collectors.toList());
    }

    /**
     * Assign a frame in the frames property.
     * @param frame object to be assigned.
     */
    public void putFrame(Frame frame) {
        this.turn = frame.getTurn();
        this.frames.put(this.turn, frame);
    }
    
    /**
     * Get the last frame object of the frames list.
     * @return last frame.  If the list is empty return null.
     */
    public Frame getLastFrame() {
        return (this.turn==0) ? null : this.frames.get(this.turn);
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return !(!Objects.equals(this.name, ((Player) obj).name));
    }

}
