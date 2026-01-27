package uno;

import java.util.ArrayList;
import java.util.Scanner;

public class Uno {
  public static void createPlayers(Scanner scanner, Player[] players) {
    int nbHumanPlayers;

    do {
      System.out.print("Enter number of Human players (<= 4): ");
      nbHumanPlayers = scanner.nextInt();
    } while (nbHumanPlayers < 0 || nbHumanPlayers > 4);

    scanner.nextLine();

    for (int i = 0; i < nbHumanPlayers; i++) {
      System.out.print("Enter player name: ");
      String name = scanner.nextLine();

      players[i] = new Player(name);
    }

    if (nbHumanPlayers != 4) {
      System.out.println("Enter the difficulty of the bots:");
      System.out.println("1. Easy");
      System.out.println("2. Medium");
      System.out.println("3. Hard");

      int difficulty;
      do {
        difficulty = scanner.nextInt();
      } while (difficulty < 1 || difficulty > 3);

      for (int i = nbHumanPlayers; i < 4; i++)
        players[i] = new Bot("Bot " + (i + 1), difficulty);
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("===== THE UNO GAME =====");
    int cardPlaced;
    ArrayList<GameSave> saves = new ArrayList<>();

    boolean createdPlayers = false;
    Player[] players = new Player[4];
    int ng = 0;
    int choice = 0;

    do {
      System.out.println("1: start a party");
      System.out.println("2: view history ");
      System.out.println("3: players ranking ");
      System.out.println("4: exit ");

      choice = scanner.nextInt();
      scanner.nextLine();
      switch (choice) {
        case 1:
          if (!createdPlayers) {
            createPlayers(scanner, players);
            createdPlayers = true;
          } else
            for (Player player : players)
              player.resetDrawCounter();

          Game game = new Game(players, scanner);
          cardPlaced = 0;
          ng++;

          game.start();
          game.startFirstCard();
          game.setCurrentPlayer(0);

          boolean gameOver = false;

          while (!gameOver) {
            game.playTurn();
            System.out.println("\n");
            cardPlaced++;

            Player current = game.getPlayer(game.getCurrentPlayer());

            if (game.checkWinCond(current)) {
              System.out.println("\n GAME OVER ");
              System.out.println("Winner is: " + current.getName());
              gameOver = true;
              current.countPoints(cardPlaced);

              GameSave save = new GameSave(ng, cardPlaced, current);
              saves.add(save);
            }

            game.nextPlayer();
          }
          break;
        case 2:
          if (saves.isEmpty())
            System.out.println("No game played yet.");
          else {
            System.out.println("Game history: ");
            for (GameSave gs : saves) {
              gs.Display();
              System.out.println("------------------------");
            }
          }
          break;
        case 3:
          System.out.println("Player ranking: ");

          ArrayList<Player> ranking = new ArrayList<>();

          for (int i = 0; i < players.length; i++)
            ranking.add(players[i]);

          for (int i = 0; i < ranking.size() - 1; i++)
            for (int j = i + 1; j < ranking.size(); j++)
              if (ranking.get(j).getPoints() > ranking.get(i).getPoints()) {
                Player tmp = ranking.get(i);
                ranking.set(i, ranking.get(j));
                ranking.set(j, tmp);
              }

          for (int i = 0; i < ranking.size(); i++) {
            Player p = ranking.get(i);
            System.out.println((i + 1) + ". " + p.getName() + " | Points: " + p.getPoints());
          }

          System.out.println();
          break;
      }
    } while (choice != 4);

    scanner.close();
  }
}
