package uno;

public abstract class ActionCard extends ColoredCard {
  public ActionCard(Color color) {
    super(color);
  }

  public abstract void effect(Game game);
}
