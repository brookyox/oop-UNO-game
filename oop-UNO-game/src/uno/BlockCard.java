package uno;

public class BlockCard extends ActionCard {

	public BlockCard(Color color) {
		super(color);
		
	}
	@Override
	public void effect (Game game ) {
		int i = game.getTurnNumber()+ 1;
		
		game.setTurnNumber(i);
		
	}
	@Override
	public boolean canBePlayed(Game game) {
		Card top = game.getTop();
		Color topcolor = game.getTopColor();
		
		if(this.getColor() == topcolor || top instanceof BlockCard ) {
			return true;
			
		}else return false;
		
		
	}


}
