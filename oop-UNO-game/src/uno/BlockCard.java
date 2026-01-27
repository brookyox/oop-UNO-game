package uno;

public class BlockCard extends ActionCard {
  public BlockCard(Color color) {
    super(color);
  }

  @Override
  public void effect(Game game) {
    game.nextPlayer();
    System.out.println("Next player is skipped!");
  }

  @Override
  public boolean canBePlayed(Game game) {
    Card topCard = game.getTopCard();
    return super.canBePlayed(game) || topCard instanceof BlockCard;
  }

  @Override
  public String toString() {
    return super.toString() + " SKIP";
  }
}
