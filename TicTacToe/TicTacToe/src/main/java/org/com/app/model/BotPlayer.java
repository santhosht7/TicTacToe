package org.com.app.model;

import org.com.app.enums.BotDifficultyLevel;
import org.com.app.enums.PlayerType;
import org.com.app.factory.BotPlayingStrategyFactory;
import org.com.app.strategies.botplayingstrategies.BotPlayingStrategy;

public class BotPlayer extends Player{
    private BotDifficultyLevel botDifficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;

    public BotPlayer(String name, Symbol symbol, BotDifficultyLevel botDifficultyLevel) {
        super(name, symbol, PlayerType.BOT);
        this.botDifficultyLevel = botDifficultyLevel;
        this.botPlayingStrategy = BotPlayingStrategyFactory.createBotPlayingStrategy(botDifficultyLevel);
    }

    public static BotDifficultyLevel getDifficulty(String difficultyLevel) {
        return switch (difficultyLevel){
            case "Easy" -> BotDifficultyLevel.EASY;
            case "Medium" -> BotDifficultyLevel.MEDIUM;
            case "Hard" -> BotDifficultyLevel.HARD;
            default -> throw new IllegalArgumentException("Please enter valid bot difficulty level: Easy, Medium, Hard");
        };
    }

    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public BotPlayingStrategy getBotPlayingStrategy() {
        return botPlayingStrategy;
    }
}
