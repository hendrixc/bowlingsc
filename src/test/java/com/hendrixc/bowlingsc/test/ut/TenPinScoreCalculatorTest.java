/*
 * System: Bowling Score Calculator
 * Author: Henry Coral
 * Stage: Unit Test
 * 
 * This program is for demo purposes, you can use or modify it under your own risk.
 */
package com.hendrixc.bowlingsc.test.ut;

import com.hendrixc.bowlingsc.model.Frame;
import com.hendrixc.bowlingsc.model.Player;
import com.hendrixc.bowlingsc.service.calculator.ScoreCalculationException;
import com.hendrixc.bowlingsc.service.calculator.ScoreCalculator;
import com.hendrixc.bowlingsc.service.calculator.TenPinScoreCalculator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Test Cases for TenPinScoreCalculator class.
 *
 * @author Henry Coral
 */
@DisplayName("Tests for TenPinScoreCalculator class")
public class TenPinScoreCalculatorTest {

    private final ScoreCalculator scoreCalculator = new TenPinScoreCalculator();
    
    @Test
    @DisplayName("Exception for frames less than 10")
    public void testLessFrames() {
        Player player = new Player("Carl");
        Frame frame1 = new Frame(1);
        frame1.setFirstBall(10);
        Frame frame2 = new Frame(2);
        frame1.setFirstBall(10);
        player.putFrame(frame1);
        player.putFrame(frame2);
        Assertions.assertThrows(ScoreCalculationException.class, ()->this.scoreCalculator.calculate(player));
    }

    @Test
    @DisplayName("Optimal Bowling score 300")
    public void testOptimalScore() {
        try {
            Player player = this.scoreCalculator.calculate(this.dataFactoryOptimalScore());
            Assertions.assertAll("player",
                    () -> Assertions.assertEquals(Integer.valueOf(10), player.getTurn()),
                    () -> Assertions.assertEquals(Integer.valueOf(300), player.getFinalScore()),
                    () -> Assertions.assertEquals(Integer.valueOf(30), player.getFrames().get(0).getScore()),
                    () -> Assertions.assertEquals(Integer.valueOf(60), player.getFrames().get(1).getScore()),
                    () -> Assertions.assertEquals(Integer.valueOf(90), player.getFrames().get(2).getScore()),
                    () -> Assertions.assertEquals(Integer.valueOf(120), player.getFrames().get(3).getScore()),
                    () -> Assertions.assertEquals(Integer.valueOf(150), player.getFrames().get(4).getScore()),
                    () -> Assertions.assertEquals(Integer.valueOf(180), player.getFrames().get(5).getScore()),
                    () -> Assertions.assertEquals(Integer.valueOf(210), player.getFrames().get(6).getScore()),
                    () -> Assertions.assertEquals(Integer.valueOf(240), player.getFrames().get(7).getScore()),
                    () -> Assertions.assertEquals(Integer.valueOf(270), player.getFrames().get(8).getScore()),
                    () -> Assertions.assertEquals(Integer.valueOf(300), player.getFrames().get(9).getScore())
            );
        } catch (ScoreCalculationException ex) {
            Logger.getLogger(TenPinScoreCalculatorTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    @DisplayName("Terrible Bowling score 0")
    public void testTerribleScore() {
        try {
            Player player = this.scoreCalculator.calculate(this.dataFactoryTerribleScore());
            Assertions.assertAll("player",
                    () -> Assertions.assertEquals(Integer.valueOf(10), player.getTurn()),
                    () -> Assertions.assertEquals(Integer.valueOf(0), player.getFinalScore()),
                    () -> Assertions.assertEquals(Integer.valueOf(0), player.getFrames().get(0).getScore()),
                    () -> Assertions.assertEquals(Integer.valueOf(0), player.getFrames().get(1).getScore()),
                    () -> Assertions.assertEquals(Integer.valueOf(0), player.getFrames().get(2).getScore()),
                    () -> Assertions.assertEquals(Integer.valueOf(0), player.getFrames().get(3).getScore()),
                    () -> Assertions.assertEquals(Integer.valueOf(0), player.getFrames().get(4).getScore()),
                    () -> Assertions.assertEquals(Integer.valueOf(0), player.getFrames().get(5).getScore()),
                    () -> Assertions.assertEquals(Integer.valueOf(0), player.getFrames().get(6).getScore()),
                    () -> Assertions.assertEquals(Integer.valueOf(0), player.getFrames().get(7).getScore()),
                    () -> Assertions.assertEquals(Integer.valueOf(0), player.getFrames().get(8).getScore()),
                    () -> Assertions.assertEquals(Integer.valueOf(0), player.getFrames().get(9).getScore())
            );
        } catch (ScoreCalculationException ex) {
            Logger.getLogger(TenPinScoreCalculatorTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    @DisplayName("Test for Jeff player dataset 167")
    public void testScoreDataSet1() {
        try {
            Player player = this.scoreCalculator.calculate(this.dataFactoryDataSet1());
            Assertions.assertAll("player",
                    () -> Assertions.assertEquals(Integer.valueOf(10), player.getTurn()),
                    () -> Assertions.assertEquals(Integer.valueOf(167), player.getFinalScore()),
                    () -> Assertions.assertEquals(Integer.valueOf(20), player.getFrames().get(0).getScore()),
                    () -> Assertions.assertEquals(Integer.valueOf(39), player.getFrames().get(1).getScore()),
                    () -> Assertions.assertEquals(Integer.valueOf(48), player.getFrames().get(2).getScore()),
                    () -> Assertions.assertEquals(Integer.valueOf(66), player.getFrames().get(3).getScore()),
                    () -> Assertions.assertEquals(Integer.valueOf(74), player.getFrames().get(4).getScore()),
                    () -> Assertions.assertEquals(Integer.valueOf(84), player.getFrames().get(5).getScore()),
                    () -> Assertions.assertEquals(Integer.valueOf(90), player.getFrames().get(6).getScore()),
                    () -> Assertions.assertEquals(Integer.valueOf(120), player.getFrames().get(7).getScore()),
                    () -> Assertions.assertEquals(Integer.valueOf(148), player.getFrames().get(8).getScore()),
                    () -> Assertions.assertEquals(Integer.valueOf(167), player.getFrames().get(9).getScore())
            );
        } catch (ScoreCalculationException ex) {
            Logger.getLogger(TenPinScoreCalculatorTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    @DisplayName("Test for John player dataset 151")
    public void testScoreDataSet2() {
        try {
            Player player = this.scoreCalculator.calculate(this.dataFactoryDataSet2());
            Assertions.assertAll("player",
                    () -> Assertions.assertEquals(Integer.valueOf(10), player.getTurn()),
                    () -> Assertions.assertEquals(Integer.valueOf(151), player.getFinalScore()),
                    () -> Assertions.assertEquals(Integer.valueOf(16), player.getFrames().get(0).getScore()),
                    () -> Assertions.assertEquals(Integer.valueOf(25), player.getFrames().get(1).getScore()),
                    () -> Assertions.assertEquals(Integer.valueOf(44), player.getFrames().get(2).getScore()),
                    () -> Assertions.assertEquals(Integer.valueOf(53), player.getFrames().get(3).getScore()),
                    () -> Assertions.assertEquals(Integer.valueOf(82), player.getFrames().get(4).getScore()),
                    () -> Assertions.assertEquals(Integer.valueOf(101), player.getFrames().get(5).getScore()),
                    () -> Assertions.assertEquals(Integer.valueOf(110), player.getFrames().get(6).getScore()),
                    () -> Assertions.assertEquals(Integer.valueOf(124), player.getFrames().get(7).getScore()),
                    () -> Assertions.assertEquals(Integer.valueOf(132), player.getFrames().get(8).getScore()),
                    () -> Assertions.assertEquals(Integer.valueOf(151), player.getFrames().get(9).getScore())
            );
        } catch (ScoreCalculationException ex) {
            Logger.getLogger(TenPinScoreCalculatorTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    @DisplayName("Test for another variation of dataset 170")
    public void testScoreDataSet3() {
        try {
            Player player = this.scoreCalculator.calculate(this.dataFactoryDataSet3());
            Assertions.assertAll("player",
                    () -> Assertions.assertEquals(Integer.valueOf(10), player.getTurn()),
                    () -> Assertions.assertEquals(Integer.valueOf(170), player.getFinalScore()),
                    () -> Assertions.assertEquals(Integer.valueOf(17), player.getFrames().get(0).getScore()),
                    () -> Assertions.assertEquals(Integer.valueOf(30), player.getFrames().get(1).getScore()),
                    () -> Assertions.assertEquals(Integer.valueOf(37), player.getFrames().get(2).getScore()),
                    () -> Assertions.assertEquals(Integer.valueOf(57), player.getFrames().get(3).getScore()),
                    () -> Assertions.assertEquals(Integer.valueOf(77), player.getFrames().get(4).getScore()),
                    () -> Assertions.assertEquals(Integer.valueOf(105), player.getFrames().get(5).getScore()),
                    () -> Assertions.assertEquals(Integer.valueOf(123), player.getFrames().get(6).getScore()),
                    () -> Assertions.assertEquals(Integer.valueOf(131), player.getFrames().get(7).getScore()),
                    () -> Assertions.assertEquals(Integer.valueOf(151), player.getFrames().get(8).getScore()),
                    () -> Assertions.assertEquals(Integer.valueOf(170), player.getFrames().get(9).getScore())
            );
        } catch (ScoreCalculationException ex) {
            Logger.getLogger(TenPinScoreCalculatorTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    @DisplayName("Test for another variation of dataset 170")
    public void testScoreDataSet4() {
        try {
            Player player = this.scoreCalculator.calculate(this.dataFactoryDataSet4());
            Assertions.assertAll("player",
                    () -> Assertions.assertEquals(Integer.valueOf(10), player.getTurn()),
                    () -> Assertions.assertEquals(Integer.valueOf(181), player.getFinalScore()),
                    () -> Assertions.assertEquals(Integer.valueOf(19), player.getFrames().get(0).getScore()),
                    () -> Assertions.assertEquals(Integer.valueOf(38), player.getFrames().get(1).getScore()),
                    () -> Assertions.assertEquals(Integer.valueOf(57), player.getFrames().get(2).getScore()),
                    () -> Assertions.assertEquals(Integer.valueOf(76), player.getFrames().get(3).getScore()),
                    () -> Assertions.assertEquals(Integer.valueOf(95), player.getFrames().get(4).getScore()),
                    () -> Assertions.assertEquals(Integer.valueOf(114), player.getFrames().get(5).getScore()),
                    () -> Assertions.assertEquals(Integer.valueOf(133), player.getFrames().get(6).getScore()),
                    () -> Assertions.assertEquals(Integer.valueOf(152), player.getFrames().get(7).getScore()),
                    () -> Assertions.assertEquals(Integer.valueOf(171), player.getFrames().get(8).getScore()),
                    () -> Assertions.assertEquals(Integer.valueOf(181), player.getFrames().get(9).getScore())
            );
        } catch (ScoreCalculationException ex) {
            Logger.getLogger(TenPinScoreCalculatorTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Player dataFactoryOptimalScore() {
        Player player = new Player("John");
        for (int turn = 1; turn < 10; turn++) {
            Frame frame = new Frame(turn);
            frame.setFirstBall(10);
            player.putFrame(frame);
        }
        Frame frame = new Frame(10);
        frame.setFirstBall(10);
        frame.setSecondBall(10);
        frame.setBonusBall(10);
        player.putFrame(frame);
        return player;
    }

    private Player dataFactoryTerribleScore() {
        Player player = new Player("John");
        for (int turn = 1; turn < 10; turn++) {
            Frame frame = new Frame(turn);
            frame.setFirstBall(0);
            frame.setSecondBall(0);
            player.putFrame(frame);
        }
        Frame frame = new Frame(10);
        frame.setFirstBall(0);
        frame.setSecondBall(0);
        player.putFrame(frame);
        return player;
    }

    private Player dataFactoryDataSet1() {
        Player player = new Player("Jeff");
        Frame frame = new Frame(1);
        frame.setFirstBall(10);
        player.putFrame(frame);
        frame = new Frame(2);
        frame.setFirstBall(7);
        frame.setSecondBall(3);
        player.putFrame(frame);
        frame = new Frame(3);
        frame.setFirstBall(9);
        frame.setSecondBall(0);
        player.putFrame(frame);
        frame = new Frame(4);
        frame.setFirstBall(10);
        player.putFrame(frame);
        frame = new Frame(5);
        frame.setFirstBall(0);
        frame.setSecondBall(8);
        player.putFrame(frame);
        frame = new Frame(6);
        frame.setFirstBall(8);
        frame.setSecondBall(2);
        player.putFrame(frame);
        frame = new Frame(7);
        frame.setFirstBall(0);
        frame.setSecondBall(6);
        player.putFrame(frame);
        frame = new Frame(8);
        frame.setFirstBall(10);
        player.putFrame(frame);
        frame = new Frame(9);
        frame.setFirstBall(10);
        player.putFrame(frame);
        frame = new Frame(10);
        frame.setFirstBall(10);
        frame.setSecondBall(8);
        frame.setBonusBall(1);
        player.putFrame(frame);
        return player;
    }
    
    private Player dataFactoryDataSet2() {
        Player player = new Player("John");
        Frame frame = new Frame(1);
        frame.setFirstBall(3);
        frame.setSecondBall(7);
        player.putFrame(frame);
        frame = new Frame(2);
        frame.setFirstBall(6);
        frame.setSecondBall(3);
        player.putFrame(frame);
        frame = new Frame(3);
        frame.setFirstBall(10);
        player.putFrame(frame);
        frame = new Frame(4);
        frame.setFirstBall(8);
        frame.setSecondBall(1);
        player.putFrame(frame);
        frame = new Frame(5);
        frame.setFirstBall(10);
        player.putFrame(frame);
        frame = new Frame(6);
        frame.setFirstBall(10);
        player.putFrame(frame);
        frame = new Frame(7);
        frame.setFirstBall(9);
        frame.setSecondBall(0);
        player.putFrame(frame);
        frame = new Frame(8);
        frame.setFirstBall(7);
        frame.setSecondBall(3);
        player.putFrame(frame);
        frame = new Frame(9);
        frame.setFirstBall(4);
        frame.setSecondBall(4);
        player.putFrame(frame);
        frame = new Frame(10);
        frame.setFirstBall(10);
        frame.setSecondBall(9);
        frame.setBonusBall(0);
        player.putFrame(frame);
        return player;
    }
    
    private Player dataFactoryDataSet3() {
        Player player = new Player("Jane");
        Frame frame = new Frame(1);
        frame.setFirstBall(8);
        frame.setSecondBall(2);
        player.putFrame(frame);
        frame = new Frame(2);
        frame.setFirstBall(7);
        frame.setSecondBall(3);
        player.putFrame(frame);
        frame = new Frame(3);
        frame.setFirstBall(3);
        frame.setSecondBall(4);
        player.putFrame(frame);
        frame = new Frame(4);
        frame.setFirstBall(10);
        player.putFrame(frame);
        frame = new Frame(5);
        frame.setFirstBall(2);
        frame.setSecondBall(8);
        player.putFrame(frame);
        frame = new Frame(6);
        frame.setFirstBall(10);
        player.putFrame(frame);
        frame = new Frame(7);
        frame.setFirstBall(10);
        player.putFrame(frame);
        frame = new Frame(8);
        frame.setFirstBall(8);
        frame.setSecondBall(0);
        player.putFrame(frame);
        frame = new Frame(9);
        frame.setFirstBall(10);
        player.putFrame(frame);
        frame = new Frame(10);
        frame.setFirstBall(8);
        frame.setSecondBall(2);
        frame.setBonusBall(9);
        player.putFrame(frame);
        return player;
    }
    
    private Player dataFactoryDataSet4() {
        Player player = new Player("Mary");
        for (int turn = 1; turn < 10; turn++) {
            Frame frame = new Frame(turn);
            frame.setFirstBall(9);
            frame.setSecondBall(1);
            player.putFrame(frame);
        }
        Frame frame = new Frame(10);
        frame.setFirstBall(9);
        frame.setSecondBall(1);
        frame.setBonusBall(0);
        player.putFrame(frame);
        return player;
    }
}
