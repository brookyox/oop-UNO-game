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
            
            if (deck.isEmpty()) {
                if (!game.getDisCard().isEmpty()) {
                    Card last = game.getDisCard().pop(); 
                    while (!game.getDisCard().isEmpty()) {
                        deck.push(game.getDisCard().pop());
                    }
                    game.getDisCard().push(last);
                }
            }
            
            nextPlayer.drawCard(deck);
        }

        System.out.println(nextPlayer.getName() + " drew 2 cards.");
    }

	@Override
	public boolean canBePlayed(Game game) {
		Card top = game.getTop();
		Color topcolor = game.getTopColor();
		
		if(this.getColor() == topcolor || top instanceof Plus2Card ) {
			return true;
			
		}else return false;
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
}
