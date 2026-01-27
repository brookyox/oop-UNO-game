package uno;

public abstract class Card {
  public abstract boolean hasColor();

  public abstract Color getColor();

  public abstract int getValue();

  public abstract boolean canBePlayed(Game game);

  public abstract String toString();
}
