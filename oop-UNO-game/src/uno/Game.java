package uno;

import java.util.ArrayList;
import java.util.Stack;
import java.util.Scanner;

public class Game {
  private Player[] players = new Player[4];
  private Deck deck;
  private Stack<Card> disCard;
  private int direction;
  private int currentPlayer;
  private Card top;
  private Color topColor;
  private int difficulty;

  Scanner scanner = new Scanner(System.in);

  public int getCurrentPlayer() {
    return currentPlayer;
  }

  public void setCurrentPlayer(int currentPlayer) {
    this.currentPlayer = currentPlayer;
  }

  public Card getTop() {
    return top;
  }

  public int getDirection() {
    return direction;
  }

  public void setDirection(int direction) {
    this.direction = direction;
  }

  public Color getTopColor() {
    return topColor;
  }

  public void setTopColor(Color topColor) {
    this.topColor = topColor;
  }

  public Game(Player[] players, Deck deck, int difficulty) {
    this.players = players;
    this.disCard = new Stack<>();
    this.direction = 1;
    this.deck = deck;
    this.difficulty = difficulty;
  }

  public int getDifficulty() {
    return difficulty;
  }

  public void start() {
    for (Player p : players)
      for (int i = 0; i < 7; i++)
        p.drawCard(deck);
  }

  public void StartFirstCard() {
    Card first = deck.pop();
    while (first instanceof WildCard) {
      disCard.push(first);
      first = deck.pop();
    }

    while (!disCard.isEmpty()) {
      Card temp = disCard.pop();
      deck.push(temp);
    }

    disCard.push(first);
    top = first;
    topColor = first.getColor();
  }

  public void playTurn() {
    Player current = players[currentPlayer];
    int choice = -1;
    int drawAllowed = 0; // only one draw allowed
    boolean turnfinish = false;
    Card selectedCard;
    System.out.println("it's " + current.getName() + "'s turn.");

    if (!current.isHuman()) {
      Bot bot = (Bot) current;

      boolean turnFinished = false;

      while (!turnFinished) {
        switch (difficulty) {
          case 1:
            choice = bot.easyTurn(this);
            break;
          case 2:
            choice = bot.mediumTurn(this);
            break;
          case 3:
            choice = bot.HardTurn(this);
            break;
        }

        if (choice == -1 && drawAllowed == 0) {
          System.out.println(bot.getName() + " draws a card");
          if (deck.isEmpty()) {
            Card last = disCard.pop();
            while (!disCard.isEmpty()) {
              deck.push(disCard.pop());
            }
            disCard.push(last);
          }
          bot.drawCard(deck);
          drawAllowed = 1;
        } else if (choice >= 0) {
          selectedCard = bot.seeCard(choice);
          bot.playCard(choice);
          disCard.push(selectedCard);
          top = selectedCard;
          applyEffectBot(this, bot);

          if (!(top instanceof WildCard))
            topColor = top.getColor();

          this.checkWinCond(bot);
          turnFinished = true;
        } else if (choice == -1 && drawAllowed == 1) {

          System.out.println(bot.getName() + " cannot play, turn skipped");
          turnFinished = true;
        }
      }

      if (top != null) {
        System.out.println("top card is : " + top.toString());

        if (this.top instanceof WildCard)
          System.out.println("top color is:" + topColor);
      }

      return;
    } else if (current.isHuman() == true) {
      System.out.print("press Enter to show hand...");
      scanner.nextLine();

      for (int i = 0; i < 10; i++)
        System.out.println();

      System.out.println("top card is : " + top.toString());

      if (this.top instanceof WildCard)
        System.out.println("top color is:" + topColor);

      while (!turnfinish) {
        current.showHand();
        // index start from 1
        System.out.print("choose the index of the card you want to play or choose 0 to draw a card  : ");

        choice = scanner.nextInt() - 1;
        scanner.nextLine();
        if (choice >= 0 && choice < current.getHandSize()) {
          selectedCard = current.seeCard(choice);
          if (selectedCard.canBePlayed(this)) {
            System.out.println("the selected card can be played.");
            current.playCard(choice);
            System.out.println(current.getName() + " played his turn");
            disCard.push(selectedCard);
            top = selectedCard;
            this.applyEffect();

            if (!(top instanceof WildCard))
              topColor = top.getColor();

            turnfinish = true;
            this.checkWinCond(current);
          } else
            System.out.println("Index invalid or This card cannot be played please chooose another one .");
        } else if (drawAllowed == 1) {
          System.out.println("No card played, you skip your turn.");
          turnfinish = true;
        } else if (choice == -1 && drawAllowed == 0) {
          System.out.println("you are going to draw a card");
          if (deck.isEmpty()) {
            Card last = disCard.pop();

            while (!disCard.isEmpty())
              deck.push(disCard.pop());

            disCard.push(last);
          }

          current.drawCard(deck);
          drawAllowed = 1;
        }
      }
    }

    drawAllowed = 0;
  }

  public void applyEffect() {
    if (this.top instanceof ActionCard) {
      ((ActionCard) this.top).effect(this);
    } else if (this.top instanceof Wild4Card) {
      ((Wild4Card) this.top).draw4(this);
    } else if (this.top instanceof WildCard) {
      ((WildCard) this.top).changeColor(this);
    }
  }

  public void applyEffectBot(Game game, Bot bot) {
    if (this.top instanceof ActionCard) {
      ((ActionCard) this.top).effect(game);
    } else if (this.top instanceof Wild4Card) {
      ((Wild4Card) this.top).draw4Bot(game, bot);
    } else if (this.top instanceof WildCard) {
      ((WildCard) this.top).changeColorBot(game, bot);
    }
  }

  public boolean checkWinCond(Player player) {
    ArrayList<Card> hand;
    hand = player.getHand();
    return hand.size() == 0;
  }

  public void nextPlayer() {
    this.currentPlayer = (this.currentPlayer + this.direction + 4) % 4;
  }

  public Player getNextPlayer() {
    int nextIndex = (this.currentPlayer + this.direction + 4) % 4;
    return players[nextIndex];
  }

  public boolean endGame(Player player) {
    if (this.checkWinCond(player))
      return true;
    else
      return false;
  }

  public Deck getDeck() {
    return deck;
  }

  public Player getPlayer(int index) {
    return players[index];
  }

  public Stack<Card> getDisCard() {
    return disCard;
  }
}
