package uno;
import java.util.Stack;

public class Game {
	private Player[] players = new Player[4];
	private Deck deck;
	private Stack<Card> disCard;
	private int direction;
	private Card top = disCard.peek();

	public Card getTop() {
		return top;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
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

	public void playTurn() {
		
	}
    public void applyEffect() {
    	
    }
    public void checkWinCond() {
    	
    }
	public void nextPlayer() {
		
	}

	
}