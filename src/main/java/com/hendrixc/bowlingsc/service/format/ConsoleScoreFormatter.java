/*
 * System: Bowling Score Calculator
 * Author: Henry Coral
 * 
 * This program is for demo purposes, you can use or modify it under your own risk.
 */
package com.hendrixc.bowlingsc.service.format;

import com.hendrixc.bowlingsc.BowlingRules;
import com.hendrixc.bowlingsc.model.Frame;
import com.hendrixc.bowlingsc.model.Player;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.StringSubstitutor;


/**
 * Implementation of ScoreFormatter for standart output (console).
 * 
 * @author Henry Coral
 */
public class ConsoleScoreFormatter implements ScoreFormatter{
    
    private static final String NAME = "NAME";
    private static final String VAL1 = "VAL1";
    private static final String VAL2 = "VAL2";
    private static final String SCORE = "SCO";
    
    @Override
    public String format(List<Player> players) throws ScoreFormatterException {
        StringBuilder finalStr = new StringBuilder();
        finalStr.append(ConsoleScoreFormatter.HEADER_TEMPLATE);
        for (Player player : players) {
            finalStr.append(this.format(player));
        }
        return finalStr.toString();
    }
    
    @Override
    public String format(Player player) throws ScoreFormatterException {
        if (player==null || player.getFinalScore()==null) {
            throw new ScoreFormatterException("Player invalid.");
        }
        StringBuilder playerStr = new StringBuilder();
        StringBuilder framesStr = new StringBuilder("Pinfalls ");
        StringBuilder scoreStr =  new StringBuilder("Score    ");
        Map<String,String> values = new HashMap<>();
        for (Frame frame : player.getFrames()) {
            String[] valuesFrame = this.obtainValuesFromFrame(frame);
            values.put(ConsoleScoreFormatter.VAL1, valuesFrame[0]);
            values.put(ConsoleScoreFormatter.VAL2, valuesFrame[1]);
            values.put(ConsoleScoreFormatter.SCORE, valuesFrame[2]);
            framesStr.append(this.replaceText(values, FRAME_TEMPLATE));
            scoreStr.append(this.replaceText(values, SCORE_TEMPLATE).substring(0, 8));
        }
        if (player.getLastFrame().getBonusBall()!=null) {
            framesStr.append((player.getLastFrame().getBonusBall()==BowlingRules.MAX_FRAMES.value()) ? "X" : player.getLastFrame().getBonusBall());
        }
        playerStr.append(player.getName());
        playerStr.append("\n");
        playerStr.append(framesStr);
        playerStr.append("\n");
        playerStr.append(StringUtils.trim(scoreStr.toString()));
        playerStr.append("\n");
        return playerStr.toString();
    }
    
    private String[] obtainValuesFromFrame(Frame frame) {
        String values[] = new String[4];
        if (frame.getTurn() == BowlingRules.MAX_FRAMES.value()) {
            values[0] = (frame.getFirstBall()==BowlingRules.MAX_PINES.value()) ? "X" : frame.getFirstBall().toString();
            values[1] = (frame.getSecondBall()==BowlingRules.MAX_PINES.value()) ? "X" : frame.getSecondBall().toString();
        } else if (frame.getFirstBall()==BowlingRules.MAX_PINES.value()) {
            values[0] = " ";
            values[1] = "X";
        } else {
            values[0] = frame.getFirstBall().toString();
            if (frame.getSecondBall()+frame.getFirstBall()==BowlingRules.MAX_PINES.value()) {
                values[1] = "/";
            } else {
                values[1] = frame.getFirstBall().toString();
            }
        }
        values[2] = frame.getScore().toString();
        return values;
    }
     
    private String replaceText(Map<String, String> data, String template) {
        StringSubstitutor sub = new StringSubstitutor(data);
        return sub.replace(template);
    }
    
    private static final String HEADER_TEMPLATE = "Frame    1       2       3       4       5       6       7       8       9       10\n";
    
    private static final String PLAYER_TEMPLATE = "{NAME}\n" +
            "Pinfalls	{VAL1}	{VAL2}	{VAL3}	{VAL4}	{VAL5}	{VAL6}	{VAL7}	{VAL8}	{VAL9}	{VAL10}	{VAL11}	{VAL12}	{VAL13}	{VAL14}	{VAL15}	{VAL16}	{VAL17}	{VAL18}	{VAL19}	{VAL20}	{VAL21}\n" +
            "Score		{SCO1}		{SCO2}		{SCO3}		{SCO4}		{SCO5}		{SCO6}		{SCO7}		{SCO8}		{SCO9}		{SCO10}\n";
    
    private static final String TEMPLATE = "${NAME}\n" +
            "${FRAMES}\n" +
            "${SCORES}\n";
    private static final String FRAME_HEADER_TEMPLATE = "\t${THROW}\t";
    private static final String FRAME_TEMPLATE = "${VAL1}   ${VAL2}   ";
    private static final String SCORE_TEMPLATE = "${SCO}       ";
}
