package org.com.app.model;

import lombok.Getter;
import org.com.app.enums.CellState;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
public class Board {
    private int size;
    private List<List<Cell>> cells;

    public Board(int size) {
        this.size = size;
        initializeCells(size);
    }

    private void initializeCells(int size) {
        cells = new ArrayList<>();
        for(int i=0; i<size; i++){
            List<Cell> row =new ArrayList<>();
            for(int j=0; j<size; j++){
                Cell cell = new Cell( i, j);
                row.add(cell);
            }
            cells.add(row);
        }

    }

    public void printBoard(){
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                Player player = cells.get(i).get(j).getPlayer();
                if(Objects.nonNull(player)){
                    System.out.print(player.getSymbol().getCharacter()+" ");
                }else{
                    System.out.print(". ");
                }

            }
            System.out.println();
        }
    }
}
