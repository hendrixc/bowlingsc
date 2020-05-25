/*
 * System: Bowling Score Calculator
 * Author: Henry Coral
 * 
 * This program is for demo purposes, you can use or modify it under your own risk.
 */
package com.hendrixc.bowlingsc.service.parser;


import com.hendrixc.bowlingsc.BowlingRules;
import com.hendrixc.bowlingsc.model.Player;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
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

    private static final String SEPARATOR = "\t";
    private static final String END_LINE = "\n";
    
    @Override
    public List<Player> parseFile(String fileName) throws ParserException, IOException {
        Path path = Paths.get(fileName);
        List<String> contents = Files.readAllLines(path);
        StringBuilder sb = new StringBuilder();
        contents.forEach((line) -> {
            sb.append(line+TextScoreParser.END_LINE);
        });
        return this.parseContent(sb.toString());
    }

    @Override
    public List<Player> parseContent(String content) throws ParserException {
        if (content==null || content.isBlank()) {
            throw new ParserException("Content is null or blank");
        }
        List<String> lines = Arrays.asList(content.split(TextScoreParser.END_LINE));
        Map<String, Player> players = new LinkedHashMap<>();
        FrameBuilder frameBuilder = new DefaultFrameBuilder();
        for (String line : lines) {
            LineContent lineContent = this.processLine(line);
            Player player = players.get(lineContent.getName().toUpperCase());
            if (player == null) {
                player = new Player(lineContent.getName());
                players.put(player.getName().toUpperCase(), player);
                if (players.size()>BowlingRules.MAX_PLAYERS.value()) {
                    throw new ParserException("Players number exceed maximun permited 6.");
                }
            }
            player.putFrame(frameBuilder.build(player.getLastFrame(), lineContent.getPines()));
        }
        for (Player player : players.values()) {
            if (player.getFrames().size()<BowlingRules.MAX_FRAMES.value()) {
                throw new ParserException("Frames for player "+player.getName()+" are insufficients.");
            }
        }
        return new ArrayList<>(players.values());
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
    @Override
    public LineContent processLine(String line) throws ParserException {
        if (line==null) {
            throw new ParserException("Null value received as a text line.");
        }
        LineContent lineContent = new LineContent();
        String parts[] = line.trim().split(TextScoreParser.SEPARATOR);
        if (parts.length == 2) {
            if (parts[0].matches("^[\\p{L} .'-]+$")) {
                lineContent.setName(parts[0]);
            } else {
                throw new ParserException("Invalid name.");
            }
            if ("F".equals(parts[1].trim())) {
                lineContent.setPines(BowlingRules.FAULT.value());
            } else {
                try {
                    Integer pins = Integer.parseInt(parts[1].trim());
                    if (pins >= BowlingRules.FAULT.value() && pins <= BowlingRules.MAX_PINES.value()) {
                        lineContent.setPines(pins);
                    } else {
                        throw new ParserException("Invalid pines number.");
                    }
                } catch (NumberFormatException nfe) {
                    throw new ParserException("Expected a number for pines.");
                }
            }
            return lineContent;
        } else {
            throw new ParserException("Text line invalid. Check separator char.");
        }
    }

}
