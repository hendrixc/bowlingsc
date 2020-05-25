/*
 * System: Bowling Score Calculator
 * Author: Henry Coral
 * 
 * This program is for demo purposes, you can use or modify it under your own risk.
 */
package com.hendrixc.bowlingsc.service.calculator;

import com.hendrixc.bowlingsc.BowlingRules;
import com.hendrixc.bowlingsc.model.Frame;
import com.hendrixc.bowlingsc.model.Player;
import java.util.ArrayList;
import java.util.List;

/**
 * Default implementation for Ten Pines Bowling Score Calculator. The rules
 * implemented to calculate the score was tafed from
 * <a href="https://www.youtube.com/watch?v=aBe71sD8o8c">Scoring Bowling by
 * Stephen Anderson </a>.
 *
 * @author Henry Coral
 */
public class TenPinScoreCalculator implements ScoreCalculator {

    @Override
    public Player calculate(Player player) throws ScoreCalculationException {
        if (player.getFrames().size() == BowlingRules.MAX_FRAMES.value()) {
            List<Integer[]> set = new ArrayList<>();
            player.getFrames().forEach((fr) -> {
                set.addAll(createArrayElements(fr));
            });
            List<Integer[]> arr = this.calculateScoreFromArray(set);
            arr.stream().filter((val) -> (val[2] != null)).forEachOrdered((val) -> {
                player.getFrames().get(val[0] - 1).setScore(val[2]);
            });
            player.setFinalScore(player.getLastFrame().getScore());
        } else {
            throw new ScoreCalculationException("Frames size is invalid for player:" + player.getName());
        }
        return player;
    }

    /**
     * Create a list with one, two or three elements depending of the Frame
     * values and turn.
     *
     * @param frame object to be processed.
     * @return List object with the corresponding elements to be added to final
     * array used to calculate the score.
     */
    private List<Integer[]> createArrayElements(Frame frame) {
        List<Integer[]> set = new ArrayList<>();
        set.add(new Integer[]{frame.getTurn(), frame.getFirstBall(), null});
        if (frame.getSecondBall() != null) {
            set.add(new Integer[]{frame.getTurn(), frame.getSecondBall(), null});
        }
        if (frame.getTurn() == BowlingRules.MAX_FRAMES.value() && frame.getBonusBall() != null) {
            set.add(new Integer[]{frame.getTurn(), frame.getBonusBall(), null});
        }
        return set;
    }

    /**
     * Calculate the score from an array of throws.
     *
     * @param set Array with the values of a player's throws.
     * @return An array with the score calculated for each frame.
     */
    private List<Integer[]> calculateScoreFromArray(List<Integer[]> set) {
        int score = 0;
        int lastTurn = 0;
        Integer def[] = new Integer[]{0, 0};
        for (int i = 0; i < set.size() - 1 && lastTurn < 10; i++) {
            Integer current[] = set.get(i);
            Integer next1[] = set.get(i + 1);
            Integer next2[] = (i + 2) == set.size() ? def : set.get(i + 2);
            if (current[1] == 10 || current[1] + next1[1] == 10) {
                score += current[1] + next1[1] + next2[1];
                if (current[1] != 10) {
                    i++;
                }
            } else {
                score += current[1] + next1[1];
                i++;
            }
            current[2] = score;
            lastTurn = current[0];
        }
        return set;
    }

}
