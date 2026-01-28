package uno;

import java.util.ArrayList;

public class Player {
  private String name;
  private ArrayList<Card> hand;
  private boolean isHuman;
  private int drawCounter;
  private int points;

  public int getPoints() {
    return points;
  }

  public int getDrawCounter() {
    return drawCounter;
  }

  public Player(String name, boolean isHuman) {
    this.name = name;
    this.hand = new ArrayList<>();
    this.isHuman = isHuman;
    this.drawCounter = 0;
    this.points = 0;
  }

  public Player(String name) {
    this(name, true);
  }

  public String getName() {
    return name;
  }

  public ArrayList<Card> getHand() {
    return new ArrayList<>(hand);
  }

  public int getHandSize() {
    return hand.size();
  }

  public boolean isHuman() {
    return isHuman;
  }

  public void drawCard(Deck deck) {
    if (!deck.isEmpty()) {
      Card card = deck.pop();
      hand.add(card);
      drawCounter++;
    }
  }

  public Card seeCard(int index) {
    if (index >= 0 && index < hand.size())
      return hand.get(index);

    return null;
  }

  public Card playCard(int index) {
    if (index >= 0 && index < hand.size())
      return hand.remove(index);

    return null;
  }

  public void showHand() {
    for (int i = 0; i < hand.size(); i++)
      System.out.println((i + 1) + " : " + hand.get(i));
  }

  public void countPoints(int cardPlaced) {
    if (cardPlaced <= 50)
      this.points += 15;
    else if (cardPlaced <= 100)
      this.points += 10;
    else
      this.points += 5;

    if (this.drawCounter <= 5)
      this.points += 10 - 2 * this.drawCounter;
  }

  public void resetDrawCounter() {
    this.drawCounter = 0;
  }
}
