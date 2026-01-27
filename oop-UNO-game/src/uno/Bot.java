package uno;

import java.util.ArrayList;
import java.util.HashMap;

public class Bot extends Player {
  private Difficulty difficulty;

  public Bot(String name, Difficulty difficulty) {
    super(name, false);
    this.difficulty = difficulty;
  }

  public Difficulty getDifficulty() {
    return difficulty;
  }

  public int chooseCard(Game game) {
    switch (difficulty) {
      case EASY:
        return easyChoice(game);
      case MEDIUM:
        return mediumChoice(game);
      case HARD:
        return hardChoice(game);
      default:
        throw new IllegalStateException("Unexpected value: " + difficulty);
    }
  }

  public Color chooseColor(Game game) {
    switch (difficulty) {
      case EASY:
        return easyColor(game);
      case MEDIUM:
        return mediumColor(game);
      case HARD:
        return hardColor(game);
      default:
        throw new IllegalStateException("Unexpected value: " + difficulty);
    }
  }

  public int easyChoice(Game game) {
    for (int i = 0; i < getHandSize(); i++)
      if (seeCard(i).canBePlayed(game))
        return i; // plays the first playable card

    return -1;
  }

  public Color easyColor(Game game) {
    return Color.randomColor(); // chose a random color
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

  public Color mediumColor(Game game) {
    for (Card card : getHand())
      if (card instanceof ColoredCard)
        return ((ColoredCard) card).getColor();

    return Color.randomColor(); // chose a random color
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
      if (!(card instanceof ColoredCard))
        continue;

      Color color = ((ColoredCard) card).getColor();
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
        if (!card.canBePlayed(game) || !(card instanceof ColoredCard) || ((ColoredCard) card).getColor() != color)
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

  public Color hardColor(Game game) {
    ArrayList<Color> sortedColors = getColorsByFrequency(this.getHand());
    return sortedColors.isEmpty() ? Color.randomColor() : sortedColors.get(0);
  }
}
