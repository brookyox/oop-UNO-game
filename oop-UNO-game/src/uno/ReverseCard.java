package uno;

public class ReverseCard extends ActionCard {

	public ReverseCard(Color color) {
		super(color);
		
	}
	public void revrese(Game game){
		game.dirrection = -game.dirrection
	}

}
