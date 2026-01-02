package uno;

public class BlockCard extends ActionCard {

	public BlockCard(Color color) {
		super(color);
		
	}
	public int Block(int i ) {
		return i++;
		
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
