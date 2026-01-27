package uno;

public class Plus2Card extends ActionCard {
  public Plus2Card(Color color) {
    super(color);
  }

  @Override
  public void effect(Game game) {
    int nextIndex = (game.getCurrentPlayer() + game.getDirection() + 4) % 4;
    Player nextPlayer = game.getPlayer(nextIndex);
    Deck deck = game.getDeck();

    for (int i = 0; i < 2; i++) {
      game.refillDeckIfEmpty();
      nextPlayer.drawCard(deck);
    }

    System.out.println(nextPlayer.getName() + " drew 2 cards.");
  }

  @Override
  public boolean canBePlayed(Game game) {
    Card topCard = game.getTopCard();
    return super.canBePlayed(game) || topCard instanceof Plus2Card;
  }

  @Override
  public String toString() {
    return super.toString() + " +2";
  }
}
