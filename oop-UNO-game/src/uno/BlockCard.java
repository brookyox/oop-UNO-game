package uno;

public class BlockCard extends ActionCard {

	public BlockCard(Color color) {
		super(color);
		
	}
	@Override
	public void effect (Game game ) {
		int i = game.getCurrentPlayer() + game.getDirection();
		
		game.setCurrentPlayer(i);
		
	}
	@Override
	public boolean canBePlayed(Game game) {
		Card top = game.getTop();
		Color topcolor = game.getTopColor();
		
		if(this.getColor() == topcolor || top instanceof BlockCard ) {
			return true;
			
		}else return false;
		
		
	}
	@Override
	public String toString() {
		
		return getColor() + " SKIP";
	}


}
