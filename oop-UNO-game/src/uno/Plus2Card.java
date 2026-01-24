package uno;

public class Plus2Card extends ActionCard {

    public Plus2Card(Color color) {
        super(color);
    }
    
    @Override
    public void effect(Game game) {
    	int index = game.getCurrentPlayer() + game.getDirection();
    	Player player = game.getPlayer(index);
    	Deck deck = game.getDeck();
    	
    	player.drawCard(deck); 
    	player.drawCard(deck); 
       
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
