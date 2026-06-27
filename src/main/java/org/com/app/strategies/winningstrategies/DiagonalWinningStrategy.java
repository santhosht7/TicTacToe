package org.com.app.strategies.winningstrategies;

import org.com.app.model.Board;
import org.com.app.model.Cell;
import org.com.app.model.Move;
import org.com.app.model.Player;

import java.util.Objects;

public class DiagonalWinningStrategy implements WinningStrategy{
    @Override
    public boolean checkWinner(Board board, Move move) {

        Cell cell = move.getCell();
        char symbol = cell.getPlayer().getSymbol().getCharacter();
        int row = cell.getRow();
        int col = cell.getColumn();
        if(row == col) {
            boolean winnerFlag = true;
            for (int i = 0; i < board.getSize(); i++) {
                Player player = board.getCells().get(i).get(i).getPlayer();
                if (Objects.isNull(player) || symbol != player.getSymbol().getCharacter()) {
                    winnerFlag = false;
                    break;
                }
            }
            return winnerFlag;
        }
        if(row+col+1 == board.getSize()) {
            boolean winnerFlag = true;
            for (int i = 0; i < board.getSize(); i++) {
                Player player = board.getCells().get(board.getSize() - i - 1).get(i).getPlayer();
                if (Objects.isNull(player) || symbol != player.getSymbol().getCharacter()) {
                    winnerFlag = false;
                    break;
                }

            }
            return winnerFlag;
        }
        return false;
    }
}
