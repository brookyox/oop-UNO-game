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
		
		if(this.getColor() == topcolor || top instanceof ReverseCard ) {
			return true;
			
		}else return false;
		
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
}
