package org.com.app.model;

import org.com.app.enums.PlayerType;

public class HumanPlayer extends Player{

    public HumanPlayer(String name, Symbol symbol) {
        super(name, symbol, PlayerType.HUMAN);
    }
}
