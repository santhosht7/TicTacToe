package org.com.app;

import org.com.app.controller.GameController;
import org.com.app.enums.BotDifficultyLevel;
import org.com.app.enums.GameState;
import org.com.app.factory.BotPlayingStrategyFactory;
import org.com.app.model.*;
import org.com.app.service.GameService;
import org.com.app.strategies.botplayingstrategies.BotPlayingStrategy;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class TIcTacToe {
    public static void main(String[] args) {
        System.out.println("======= Tic Tac Toe =======");
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the board: ");
        int size = sc.nextInt();
        sc.nextLine();
        Board board =new Board(size);
        System.out.println("Your Game Board is prepared.");


        List<Player> players = new ArrayList<>();
        int numberOfPlayers =size-1;
        System.out.println(numberOfPlayers + " players required for the game. Do you need Bot player ?(Enter Yes or No");
        String isBotRequired = sc.nextLine();
        int remainingPlayers = numberOfPlayers;

        if("Yes".equalsIgnoreCase(isBotRequired)){
            BotDifficultyLevel level = getBotDifficultyLevelFromInput(sc);

            BotPlayer bot = new BotPlayer("Chitti", new Symbol('B'), level);
            players.add(bot);
            remainingPlayers -= 1;
            System.out.println("Chitti is ready for a game");
            System.out.println("Chitti selected symbol 'B'");
        }



        for(int i=0;i<remainingPlayers;i++){
            System.out.println("Enter the player"+i+" name along with the Symbol: (ex: PlayerName-*)");
            try{
                String player = sc.nextLine();
                String[] playerDetail = player.split("-");
                Symbol symbol = new Symbol(playerDetail[1].charAt(0));
                Player p = new HumanPlayer(playerDetail[0],symbol);
                players.add(p);
            } catch (Exception e) {
                throw new RuntimeException("Please enter valid number of players: "+ remainingPlayers);
            }
        }

        GameController controller = new GameController(new GameService());

        Game game = Game.getBuilder()
                .setBoard(board)
                .setPlayers(players)
                .setGameState(GameState.IN_PROGRESS)
                .build();
        System.out.println("Your Game is prepared. Lets's start...");


        while(game.getGameState().equals(GameState.IN_PROGRESS)){
            controller.printBoard(game);

            Player currentPlayer = players.get(game.getNextPlayerIndex());

            Move move = controller.getMove(game, currentPlayer, sc);

            controller.makeMove(game,move);

            int nextIndex = controller.getNextPlayerIndex(game);
            game.setNextPlayerIndex(nextIndex);
            controller.printBoard(game);
        }

        if(GameState.COMPLETED.equals(game.getGameState())){
            System.out.println("Winner Winner Chicken Dinner, "+game.getWinner()+" won the game");
        } else if (GameState.DRAW.equals(game.getGameState())) {
            System.out.println("Game is completed as Draw");
        }



    }

    private static BotDifficultyLevel getBotDifficultyLevelFromInput( Scanner sc) {
        BotDifficultyLevel level = null;
        while (level == null) {
            System.out.println("Enter the difficulty level of the Bot Chitti(Allowed level: Easy, Medium, Hard): ");
            String difficultyLevel = sc.nextLine();

            try {
                level = BotPlayer.getDifficulty(difficultyLevel);
            } catch (IllegalArgumentException e) {
                System.out.println("⚠️ " + e.getMessage());
            }
        }
        return level;
    }
}