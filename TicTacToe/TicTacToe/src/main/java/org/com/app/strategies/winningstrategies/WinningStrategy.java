package org.com.app.strategies.winningstrategies;

import org.com.app.model.Board;
import org.com.app.model.Cell;
import org.com.app.model.Move;

public interface WinningStrategy {
    boolean checkWinner(Board board, Move move);
}
