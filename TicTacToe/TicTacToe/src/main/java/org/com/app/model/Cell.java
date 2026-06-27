package org.com.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.com.app.enums.CellState;


@Getter
public class Cell {
    private CellState cellState;
    private int row;
    private int column;
    @Setter
    private Player player;

    public Cell(int row, int column) {
        this.cellState = CellState.EMPTY;
        this.row = row;
        this.column = column;
    }

    public void clearCell(){
        cellState = CellState.EMPTY;
        player = null;
    }

    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }
}
