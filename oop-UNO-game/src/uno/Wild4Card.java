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

	
	public void draw4(Game game) {
		
	    this.changeColor(game); 

	    int index = (game.getCurrentPlayer() + game.getDirection() + 4) % 4;
	    Player player = game.getPlayer(index);
	    Deck deck = game.getDeck();

	    for (int i = 0; i < 4; i++) {
	        
	        if (deck.isEmpty()) {
	            if (!game.getDisCard().isEmpty()) {
	                Card last = game.getDisCard().pop();
	                while (!game.getDisCard().isEmpty()) {
	                    deck.push(game.getDisCard().pop());
	                }
	                game.getDisCard().push(last);
	            }
	        }
	        player.drawCard(deck);
	    }

	    System.out.println(player.getName() + " drew 4 cards!");
	}
public void draw4Bot(Game game , Bot bot) {
		
	    this.changeColorBot(game , bot); 

	    int index = (game.getCurrentPlayer() + game.getDirection() + 4) % 4;
	    Player player = game.getPlayer(index);
	    Deck deck = game.getDeck();

	    for (int i = 0; i < 4; i++) {
	        
	        if (deck.isEmpty()) {
	            if (!game.getDisCard().isEmpty()) {
	                Card last = game.getDisCard().pop();
	                while (!game.getDisCard().isEmpty()) {
	                    deck.push(game.getDisCard().pop());
	                }
	                game.getDisCard().push(last);
	            }
	        }
	        player.drawCard(deck);
	    }

	    System.out.println(player.getName() + " drew 4 cards!");
	}


	@Override
	public String toString() {

		return "JOKER +4";
	}
}