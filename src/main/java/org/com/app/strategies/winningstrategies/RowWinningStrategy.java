package org.com.app.strategies.winningstrategies;

import org.com.app.model.Board;
import org.com.app.model.Cell;
import org.com.app.model.Move;
import org.com.app.model.Player;

import java.util.Objects;

public class RowWinningStrategy implements WinningStrategy{

    @Override
    public boolean checkWinner(Board board, Move move) {
        Cell cell = move.getCell();
        char symbol = cell.getPlayer().getSymbol().getCharacter();
        for(int i=0;i<board.getSize();i++){
            Player player =board.getCells().get(cell.getRow()).get(i).getPlayer();
            if(Objects.isNull(player) || symbol != player.getSymbol().getCharacter()){
                return false;
            }
        }
        return true;
    }
}
