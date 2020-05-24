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
 * <ul>
 * <li>Each frame must have associated a throw number (turn).</li>
 * <li>Each turn could have one, two or three tries.</li>
 * <li>A partial score must be calculated in each frame following the bowling scoring rules.</li>
 * </ul>
 * This class does not have an empty constructor.
 * 
 * @author Hnery Coral
 */
public class Frame {
    
    /**
     * Property turn, represents the frame number.
     */
    private final Integer turn;
    
    /**
     * Property firstBall, represents the value of the first throw.
     */
    private Integer firstBall;
    
    /**
     * Property secondBall, represents the value of the second throw.
     */
    private Integer secondBall;
    
    /**
     * Property bonusBall, represents the value of the extra throw in frame 10.
     */
    private Integer bonusBall;
    
    /**
     * Property score, represents the value of the frame score.
     */
    private Integer score;

    /**
     * Create a Frame instance using the turn provided.
     * Valid values for turn goes from 1 to 10.
     * @param turn value to be assigned to turn.
     */
    public Frame(Integer turn) {
        this.turn = turn;
    }
    
    /**
     * Getter method for turn property.
     * @return number of turn.  Valid values for turn goes from 1 to 10.
     */
    public Integer getTurn() {
        return turn;
    }

    /**
     * Getter method for firstBall property.
     * @return value of firstBall.
     */
    public Integer getFirstBall() {
        return firstBall;
    }

    /**
     * Setter method for firstBall property.
     * @param firstBall value to be assigned.
     */
    public void setFirstBall(Integer firstBall) {
        this.firstBall = firstBall;
    }

    /**
     * Getter method for secondBall property.
     * @return value of secondBall.
     */
    public Integer getSecondBall() {
        return secondBall;
    }

    /**
     * Setter method for secondBall property.
     * @param secondBall value to be assigned.
     */
    public void setSecondBall(Integer secondBall) {
        this.secondBall = secondBall;
    }

    /**
     * Getter method for bonusBall property.
     * @return value of bonusBall.
     */
    public Integer getBonusBall() {
        return bonusBall;
    }

    /**
     * Setter method for bonusBall property.
     * @param bonusBall value to be assigned.
     */
    public void setBonusBall(Integer bonusBall) {
        this.bonusBall = bonusBall;
    }
    
    /**
     * Getter method for score property.
     * @return value of score.
     */
    public Integer getScore() {
        return score;
    }

    /**
     * Setter method for score property.
     * @param score value to be assigned.
     */
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
