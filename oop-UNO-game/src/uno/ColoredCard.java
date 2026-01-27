package uno;

public abstract class ColoredCard extends Card {
  private Color color;

  public ColoredCard(Color color) {
    this.color = color;
  }

  public Color getColor() {
    return color;
  }

  @Override
  public boolean canBePlayed(Game game) {
    Color topColor = game.getTopColor();

    return this.color == topColor;
  }

  @Override
  public String toString() {
    return color.toString();
  }
}
