package org.com.app.service;

import org.com.app.enums.CellState;
import org.com.app.enums.GameState;
import org.com.app.enums.PlayerType;
import org.com.app.model.*;
import org.com.app.strategies.botplayingstrategies.BotPlayingStrategy;
import org.com.app.strategies.winningstrategies.WinningStrategy;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class GameService {
   public Game createGame(int size, List<Player> players){
       Board board =new Board(size);
       return Game.getBuilder()
                .setBoard(board)
               .setPlayers(players)
               .setGameState(GameState.IN_PROGRESS)
               .build();
   }

   public Move getMove(Game game, Player player, Scanner sc){

       Move move =null;
       if(player.getPlayerType().equals(PlayerType.BOT)){
           BotPlayer bot =(BotPlayer) player;
           move = bot.getBotPlayingStrategy().getMove(game.getBoard(), player);
           System.out.println("Chitti's turn...");

       }else{
           while(Objects.isNull(move)) {
               try {
                   System.out.println(player.getName() + "'s turn. Please select row and column position(ex: 0 1)");
                   int row = sc.nextInt();
                   int col = sc.nextInt();
                   if(row<0 || row >= game.getBoard().getSize() || col<0 || col>= game.getBoard().getSize()){

                       throw new IllegalArgumentException("Please enter valid position inside the size of the board");
                   }

                   Cell cell = game.getBoard().getCells().get(row).get(col);
                   if (!cell.getCellState().equals(CellState.EMPTY)) {
                       throw new IllegalArgumentException("This position is either filled or blocked. Please enter valid position");
                   }
                   cell.setPlayer(player);
                   cell.setCellState(CellState.FILLED);
                   move = new Move(cell, player);
               } catch (Exception e) {
                   System.out.println(e.getMessage());
               }

           }
       }


     return move;
   }


    private boolean checkWinner(Game game, Move move) {
       for(WinningStrategy winningStrategy: game.getWinningStrategies()){
           if(winningStrategy.checkWinner(game.getBoard(), move)){
               return true;
           }
       }
       return false;
    }

    public void makeMove(Game game, Move move) {
       game.getMoves().add(move);
       if(checkWinner(game, move)){
           game.setGameState(GameState.COMPLETED);
           game.setWinner(move.getPlayer());
       }else if(checkDraw(game)){
           game.setGameState(GameState.DRAW);
       }
    }

    private boolean checkDraw(Game game) {
       return game.getMoves().size() == game.getBoard().getSize() * game.getBoard().getSize();
    }

    public int getNextPlayerIndex(Game game) {
       int index= game.getNextPlayerIndex();
       if(index==game.getPlayers().size()-1){
           return 0;
       }else{
           return game.getNextPlayerIndex()+1;
       }
    }
}
