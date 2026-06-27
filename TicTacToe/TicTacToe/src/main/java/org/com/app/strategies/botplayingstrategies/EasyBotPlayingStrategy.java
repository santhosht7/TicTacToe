package org.com.app.strategies.botplayingstrategies;

import org.com.app.enums.CellState;
import org.com.app.model.Board;
import org.com.app.model.Cell;
import org.com.app.model.Move;
import org.com.app.model.Player;

import java.util.*;

public class EasyBotPlayingStrategy implements BotPlayingStrategy{

    @Override
    public Move getMove(Board board, Player player) {

        List<Cell> cells = new ArrayList<>();
        for(int i=0;i<board.getSize();i++){
            for(int j=0;j<board.getSize();j++){
                if(board.getCells().get(i).get(j).getCellState().equals(CellState.EMPTY)){
                    Cell cell = board.getCells().get(i).get(j);
                    cells.add(cell);
                }
            }
        }

        Random random = new Random();
        Cell cell = cells.get(random.nextInt(cells.size()));

        cell.setPlayer(player);
        cell.setCellState(CellState.FILLED);

        return new Move(cell, player);
    }
}
