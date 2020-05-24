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
    
    private String name;
    private Map<Integer,Frame> frames;
    private Integer finalScore;
    private Integer turn;

    /**
     * Default empty cosntructor.
     */
    public Player() {
        this.frames = new LinkedHashMap<>(BowlingRules.MAX_FRAMES.value());
        this.turn = 0;
    }
    
    /**
     * Create an instance of Player with the provided name.
     * @param name Name of the player.
     */
    public Player(String name) {
        this();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(Integer finalScore) {
        this.finalScore = finalScore;
    }

    public Integer getTurn() {
        return turn;
    }

    public void setTurn(Integer turn) {
        this.turn = turn;
    }
    
    public List<Frame> getFrames() {
        return this.frames.values().stream().collect(Collectors.toList());
    }

    public void putFrame(Frame frame) {
        this.turn = frame.getTurn();
        this.frames.put(this.turn, frame);
    }
    
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
