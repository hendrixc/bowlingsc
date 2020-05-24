/*
 * System: Bowling Score Calculator
 * Author: Henry Coral
 * 
 * This program is for demo purposes, you can use or modify it under your own risk.
 */
package com.hendrixc.bowlingsc.service.parser;


import com.hendrixc.bowlingsc.model.Frame;
import com.hendrixc.bowlingsc.model.Player;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Henry Coral
 */
public class TextScoreParser implements ScoreParser {

    @Override
    public List<Player> parseFile(String fileName) throws ParserException, IOException {
        Path path = Paths.get(fileName);
        String content = Files.readString(path);
        return this.parseContent(content);
    }

    @Override
    public List<Player> parseContent(String content) throws ParserException {
        List<String> lines = Arrays.asList(content.split("\n"));
        Map<String, Player> players = new LinkedHashMap<>();
        FrameBuilder frameBuilder = new DefaultFrameBuilder();
        for (String line : lines) {
            LineContent lineContent = this.processLine(line);
            Player player = players.get(lineContent.getName().toUpperCase());
            if (player == null) {
                player = new Player();
                player.setName(lineContent.getName());
                players.put(player.getName().toUpperCase(), player);
            }
            Frame frame = frameBuilder.build(player.getLastFrame(), lineContent.getPins());
            player.putFrame(frame);
        }
        return Arrays.asList((Player[])players.values().toArray());
    }

    

    private LineContent processLine(String line) throws ParserException {
        LineContent lineContent = new LineContent();
        String parts[] = line.trim().split("\t");
        if (parts.length == 2) {
            if (parts[0].matches("[\\u00C0-\\u00FF]")) {
                lineContent.setName(parts[0]);
            } else {
                throw new ParserException("Invalid name.");
            }
            if ("F".equals(parts[1])) {
                lineContent.setPins(10);
            } else {
                try {
                    Integer pins = Integer.parseInt(parts[1]);
                    if (pins >= 0 && pins <= 10) {
                        lineContent.setPins(pins);
                    } else {
                        throw new ParserException("Invalid pins number.");
                    }
                } catch (NumberFormatException nfe) {
                    throw new ParserException("No number for pins. ");
                }
            }
            return lineContent;
        } else {
            throw new ParserException("Line invalid.");
        }
        
    }

}
