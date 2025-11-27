package uno;

public class ReverseCard extends ActionCard {

	public ReverseCard(Color color) {
		super(color);
		
	}
	public void revrese(game){
		Game.dirrection = -Game.dirrection
	}

}
