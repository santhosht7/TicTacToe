package org.com.app.strategies.botplayingstrategies;

import org.com.app.model.Board;
import org.com.app.model.Move;
import org.com.app.model.Player;

public interface BotPlayingStrategy {
    Move getMove(Board board, Player player);
}
