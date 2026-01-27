package uno;

public class ReverseCard extends ActionCard {
  public ReverseCard(Color color) {
    super(color);
  }

  public void effect(Game game) {
    int d = -game.getDirection();
    game.setDirection(d);
  }

  @Override
  public boolean canBePlayed(Game game) {
    Card top = game.getTop();
    Color topcolor = game.getTopColor();

    return this.getColor() == topcolor || top instanceof ReverseCard;
  }

  @Override
  public String toString() {
    return getColor() + " REVERSE";
  }
}
