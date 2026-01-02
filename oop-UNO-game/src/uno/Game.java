package uno;
import java.util.ArrayList;
import java.util.Stack;

public class Game {
	private Player[] players = new Player[4];
	private Deck deck;
	private Stack<Card> disCard;
	private int direction;
	private int currentPlayer;
	private Card top = disCard.peek();
	private Color topColor;

    
	public int getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(int currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public Card getTop() {
		return top;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}
	public Color getTopColor() {
		return topColor;
	}

	public void setTopColor(Color topColor) {
		this.topColor = topColor;
	}

	public Game(Player[] players, Deck deck) {
		this.players = players;
		this.disCard = new Stack<>();
		this.direction = 1;
	}

	public void start() {
		for (Player p : players) {
			for (int i = 0; i < 7; i++) {
				p.drawCard(deck);
			}

		}
	}

	public void StartFirstCard() {
		Card first = deck.pop();
		while( first instanceof WildCard ) {
			disCard.push(first);
			first = deck.pop();
		}
		while(!disCard.isEmpty()) {
	Card temp = disCard.pop();
	deck.push(temp);
		}
		disCard.push(first);
	}
	public void playTurn() {
		 
	}
    public void applyEffect() {
    	
    }
    public boolean checkWinCond(Player[] players) {
    	ArrayList<Card> hand;
    	for (int i = 0; i < 4 ; i++) {
    		hand = players[i].getHand();
    		if ( hand.size() == 0)return true;
    	}
		return false;
    	
    	
    }
	public void nextPlayer(int currentplayer) {
		this.currentPlayer = currentplayer + 1;
		
	}
    public void endGame() {
    	
    }

	public Deck getDeck() {
		return deck;
	}

	public Player getPlayer(int index) {
	    return players[index];
	}

	
	
}