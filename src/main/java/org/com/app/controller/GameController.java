package org.com.app.controller;

import org.com.app.model.Game;
import org.com.app.model.Move;
import org.com.app.model.Player;
import org.com.app.service.GameService;

import java.util.Scanner;

public class GameController {


    private GameService gameService;

    public GameController(GameService gameService){
        this.gameService = gameService;
    }

    public void printBoard(Game game){
        game.getBoard().printBoard();
    }


    public Move getMove(Game game, Player currentPlayer, Scanner sc) {
         return gameService.getMove(game, currentPlayer, sc);
    }

    public void makeMove(Game game, Move move) {
        gameService.makeMove(game, move);
    }

    public int getNextPlayerIndex(Game game) {
        return gameService.getNextPlayerIndex(game);
    }
}
