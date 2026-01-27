package uno;

public class NumberCard extends ColoredCard {
  private int number;

  public NumberCard(Color color, int number) {
    super(color);
    this.number = number;
  }

  public int getValue() {
    return number;
  }

  public boolean canBePlayed(Game game) {
    Card topCard = game.getTopCard();
    return super.canBePlayed(game)
        || (topCard instanceof NumberCard && this.getValue() == ((NumberCard) topCard).getValue());
  }

  @Override
  public String toString() {
    return super.toString() + " " + number;
  }
}
