package uno;

public  class Wild4Card extends WildCard {
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

	public void draw4(Game game) {
		this.changeColor(game);
		int index = game.getCurrentPlayer() + game.getDirection();
    	Player player = game.getPlayer(index);
    	Deck deck = game.getDeck();
    	
    	player.drawCard(deck); 
    	player.drawCard(deck); 
    	player.drawCard(deck); 
    	player.drawCard(deck); 
        
}
}