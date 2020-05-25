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
 * Default implementation for ScoreParser interface.<br>
 * This implementation is designed to work according the initial rules provided in the challenge definition.
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
            Frame frame = frameBuilder.build(player.getLastFrame(), lineContent.getPines());
            player.putFrame(frame);
        }
        return Arrays.asList((Player[])players.values().toArray());
    }

    /**
     * Parse a text line to produce an object with two values (name and pines number).
     * Each line must have the following format in order to be processed.<br>
     * name[tab]pines
     * <ul>
     * <li><strong>name</strong> must be text with valid UTF-8 characters.</li>
     * <li><strong>pines</strong> numeric value from 0 to 10 or F (interpreted as zero).</li>
     * </ul>
     * @param line Text line to be parsed.
     * @return object with name and pines number.
     * @throws ParserException in case of the line not match with the content expected.
     */
    public LineContent processLine(String line) throws ParserException {
        LineContent lineContent = new LineContent();
        String parts[] = line.trim().split("\t");
        if (parts.length == 2) {
            if (parts[0].matches("[\\u00C0-\\u00FF]")) {
                lineContent.setName(parts[0]);
            } else {
                throw new ParserException("Invalid name.");
            }
            if ("F".equals(parts[1])) {
                lineContent.setPines(10);
            } else {
                try {
                    Integer pins = Integer.parseInt(parts[1]);
                    if (pins >= 0 && pins <= 10) {
                        lineContent.setPines(pins);
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
