package org.com.app.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Move {
    private Cell cell;
    private Player player;

    public Cell getCell() {
        return cell;
    }

    public Player getPlayer() {
        return player;
    }
}
