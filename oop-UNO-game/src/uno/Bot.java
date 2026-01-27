package uno;

import java.util.ArrayList;
import java.util.HashMap;

public class Bot extends Player {
  private int difficulty; // 1: easy, 2: medium, 3: hard

  public Bot(String name, int difficulty) {
    super(name, false);
    this.difficulty = difficulty;
  }

  public int getDifficulty() {
    return difficulty;
  }

  public int chooseCard(Game game) {
    switch (difficulty) {
      case 1:
        return easyChoice(game);
      case 2:
        return mediumChoice(game);
      case 3:
        return hardChoice(game);
      default:
        return -1;
    }
  }

  public int chooseColor(Game game) {
    switch (difficulty) {
      case 1:
        return easyColor(game);
      case 2:
        return mediumColor(game);
      case 3:
        return hardColor(game);
      default:
        return -1;
    }
  }

  public int easyChoice(Game game) {
    for (int i = 0; i < getHandSize(); i++)
      if (seeCard(i).canBePlayed(game))
        return i; // plays the first playable card

    return -1;
  }

  public int easyColor(Game game) {
    int rand = (int) (Math.random() * 4) + 1;
    return rand; // chose a random color
  }

  public int mediumChoice(Game game) {
    int priority = 5; // has priorities
    int cardIndex = -1;

    for (int i = 0; i < getHandSize(); i++) {
      if (seeCard(i).canBePlayed(game)) {
        Card card = seeCard(i);
        if (card instanceof ActionCard && priority > 1) {
          priority = 1;
          cardIndex = i;
          break;
        } else if (card instanceof NumberCard && priority > 2) {
          priority = 2;
          cardIndex = i;
        } else if (card instanceof Wild4Card && priority > 3) {
          priority = 3;
          cardIndex = i;
        } else if (card instanceof WildCard && priority > 4) {
          priority = 4;
          cardIndex = i;
        }
      }
    }

    return cardIndex;
  }

  public int mediumColor(Game game) {
    for (Card card : getHand())
      if (!(card instanceof WildCard))
        switch (card.getColor()) {
          case RED:
            return 1;
          case BLUE:
            return 2;
          case GREEN:
            return 3;
          case YELLOW:
            return 4;
        }

    int rand = (int) (Math.random() * 4) + 1;
    return rand;// chose a random color
  }

  public int getDangerCardIndex(Game game) {
    for (int i = 0; i < getHandSize(); i++) {
      Card card = seeCard(i);

      if (!card.canBePlayed(game))
        continue;

      if (card instanceof ActionCard || card instanceof Wild4Card)
        return i;
    }

    return -1;
  }

  public static ArrayList<Color> getColorsByFrequency(ArrayList<Card> hand) {
    HashMap<Color, Integer> count = new HashMap<>();

    // count cards per color
    for (Card card : hand) {
      Color color = card.getColor();
      count.put(color, count.getOrDefault(color, 0) + 1);
    }

    // put colors into an ArrayList
    ArrayList<Color> colors = new ArrayList<>(count.keySet());

    // sort by frequency (descending)
    colors.sort((c1, c2) -> count.get(c2) - count.get(c1));

    return colors;
  }

  public int hardChoice(Game game) {
    boolean danger = game.getNextPlayer().getHandSize() <= 3;

    if (danger) {
      int cardIndex = getDangerCardIndex(game);

      if (cardIndex != -1)
        return cardIndex;
    }

    ArrayList<Color> sortedColors = getColorsByFrequency(this.getHand());

    for (Color color : sortedColors) {
      int priority = 3; // has priorities
      int cardIndex = -1;

      for (int i = 0; i < getHandSize(); i++) {
        Card card = seeCard(i);
        if (!card.canBePlayed(game) || card.getColor() != color)
          continue;

        if (card instanceof NumberCard)
          return i;

        if (card instanceof ActionCard && priority > 2) {
          priority = 2;
          cardIndex = i;
        }
      }

      if (cardIndex != -1)
        return cardIndex;
    }

    for (int i = 0; i < getHandSize(); i++) {
      Card card = seeCard(i);
      if (card instanceof WildCard)
        return i;
    }

    return -1;
  }

  public int hardColor(Game game) {
    ArrayList<Color> sortedColors = getColorsByFrequency(this.getHand());

    if (sortedColors.size() > 0)
      switch (sortedColors.get(0)) {
        case RED:
          return 1;
        case BLUE:
          return 2;
        case GREEN:
          return 3;
        case YELLOW:
          return 4;
      }

    return (int) (Math.random() * 4) + 1;
  }
}
