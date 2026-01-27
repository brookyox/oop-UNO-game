package uno;

public class NumberCard extends Card {
  private Color color;
  private int number;

  public NumberCard(Color color, int number) {
    this.color = color;
    this.number = number;
  }

  @Override
  public boolean hasColor() {
    return true;
  }

  @Override
  public Color getColor() {
    return color;
  }

  public int getValue() {
    return number;
  }

  public boolean canBePlayed(Game game) {
    Card top = game.getTop();
    Color topcolor = game.getTopColor();

    return this.color == topcolor || (top instanceof NumberCard && this.getValue() == top.getValue());
  }

  @Override
  public String toString() {
    return color + " " + number;
  }
}
