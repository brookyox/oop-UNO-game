package uno;

public class ReverseCard extends ActionCard {
  public ReverseCard(Color color) {
    super(color);
  }

  public void effect(Game game) {
    game.setDirection(-game.getDirection());
  }

  @Override
  public boolean canBePlayed(Game game) {
    Card topCard = game.getTopCard();
    return super.canBePlayed(game) || topCard instanceof ReverseCard;
  }

  @Override
  public String toString() {
    return super.toString() + " REVERSE";
  }
}
