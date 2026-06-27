package org.com.app.model;

import lombok.Getter;
import lombok.Setter;
import org.com.app.enums.GameState;
import org.com.app.strategies.winningstrategies.ColumnWinningStrategy;
import org.com.app.strategies.winningstrategies.DiagonalWinningStrategy;
import org.com.app.strategies.winningstrategies.RowWinningStrategy;
import org.com.app.strategies.winningstrategies.WinningStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
public class Game {
    private final Board board;
    private final List<Player> players;
    @Setter
    private GameState gameState;
    @Setter
    private Player winner;
    private final List<Move> moves;
    @Setter
    private int nextPlayerIndex;
    List<WinningStrategy> winningStrategies;

    private Game(Builder builder){
        this.board = builder.board;
        this.players = builder.players;
        this.gameState = builder.gameState;
        this.winner = builder.winner;
        this.moves = new ArrayList<>();
        this.nextPlayerIndex = 0;
        this.winningStrategies= Arrays.asList(new RowWinningStrategy(), new ColumnWinningStrategy(), new DiagonalWinningStrategy());
    }

    public static Builder getBuilder(){
        return new Builder();
    }

    @Getter
    public static class Builder{
        private Board board;
        private List<Player> players;
        private GameState gameState;
        private Player winner;

        private Builder(){}

        public Builder setBoard(Board board) {
            this.board = board;
            return this;
        }

        public Builder setWinner(Player winner) {
            this.winner = winner;
            return this;
        }

        public Builder setGameState(GameState gameState) {
            this.gameState = gameState;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Game build(){
            return new Game(this);
        }
    }

}
