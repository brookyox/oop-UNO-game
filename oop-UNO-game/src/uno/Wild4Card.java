package uno;

public class Wild4Card extends WildCard {
	public Wild4Card() {
		super();
	}
	@Override
	public boolean hasColor() {
		
		return false;
	}
	@Override
	public Color getColor() {
		
		return null;
	}

	public void draw4(Player player, Deck deck) {
        
}
}