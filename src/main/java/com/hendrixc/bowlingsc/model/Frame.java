/*
 * System: Bowling Score Calculator
 * Author: Henry Coral
 * 
 * This program is for demo purposes, you can use or modify it under your own risk.
 */
package com.hendrixc.bowlingsc.model;

import java.util.Objects;

/**
 * Class that represent a Bowling Frame.
 * Each frame must have associated a throw number (turn).
 * Each turn could have one, two or three tries.
 * A partial score must be calculated in each frame following the bowling scoring rules.
 * This class does not have an empty constructor.
 * 
 * @author Hnery Coral
 */
public class Frame {
    
    private final Integer turn;
    private Integer firstBall;
    private Integer secondBall;
    private Integer bonusBall;
    private Integer score;

    /**
     * Create a Frame instance using the turn provided.
     * @param turn value to be assigned to turn.
     */
    public Frame(Integer turn) {
        this.turn = turn;
    }
    
    public Integer getTurn() {
        return turn;
    }

    
    public Integer getFirstBall() {
        return firstBall;
    }

    public void setFirstBall(Integer firstBall) {
        this.firstBall = firstBall;
    }

    public Integer getSecondBall() {
        return secondBall;
    }

    public void setSecondBall(Integer secondBall) {
        this.secondBall = secondBall;
    }

    public Integer getBonusBall() {
        return bonusBall;
    }

    public void setBonusBall(Integer bonusBall) {
        this.bonusBall = bonusBall;
    }
    
    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.turn);
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
        return !(!Objects.equals(this.turn, ((Frame) obj).turn));
    }
    
}
