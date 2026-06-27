package org.com.app.factory;

import org.com.app.enums.BotDifficultyLevel;
import org.com.app.strategies.botplayingstrategies.BotPlayingStrategy;
import org.com.app.strategies.botplayingstrategies.EasyBotPlayingStrategy;
import org.com.app.strategies.botplayingstrategies.HardBotPlayingStrategy;
import org.com.app.strategies.botplayingstrategies.MediumBotPlayingStrategy;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy createBotPlayingStrategy(BotDifficultyLevel botDifficultyLevel){
        return switch (botDifficultyLevel){
            case EASY -> new EasyBotPlayingStrategy();
            case MEDIUM -> new MediumBotPlayingStrategy();
            case HARD -> new HardBotPlayingStrategy();
        };
    }
}
