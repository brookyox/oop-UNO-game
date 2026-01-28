package uno;

import java.util.Scanner;

public class WildCard extends Card {
  public WildCard() {
    super();
  }

  public void changeColorPlayer(Game game) {
    Scanner scanner = GeneralScanner.getScanner();

    int n;
    System.out.println("What is the color for the next player?");
    System.out.println("1: RED \n2: BLUE \n3: GREEN \n4: YELLOW");
    do {
      while (!scanner.hasNextInt()) { // input validation
        System.out.println("Please enter a number between 1 and 4.");
        scanner.next(); // discard invalid input
      }

      n = scanner.nextInt();
    } while (n < 1 || n > 4);

    changeColor(game, Color.fromNumber(n));
  }

  public void changeColorBot(Game game, Bot bot) {
    Color color = bot.chooseColor(game);
    changeColor(game, color);
  }

  public void changeColor(Game game, Color color) {
    game.setTopColor(color);
    System.out.println(" changed color to " + color);
  }

  @Override
  public boolean canBePlayed(Game game) {
    return true;
  }

  @Override
  public String toString() {
    return "JOKER";
  }
}
