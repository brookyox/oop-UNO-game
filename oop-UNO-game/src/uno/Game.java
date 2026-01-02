package uno;
import java.util.Stack;

public class Game {
	private Player[] players = new Player[4];
	private Deck deck;
	private Stack<Card> disCard;
	private int direction;
	private int currentPlayer;
	private Card top = disCard.peek();
	private Color topColor;
	private int turnNumber;
    
	public int getCurrentPlayer() {
		return currentPlayer;
	}

	public int getTurnNumber() {
		return turnNumber;
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

	public void setTurnNumber(int turnNumber) {
		this.turnNumber = turnNumber;
	}

	public void playTurn() {
		 
	}
    public void applyEffect() {
    	
    }
    public void checkWinCond() {
    	
    }
	public void nextPlayer() {
		
	}
    public void endGame() {
    	
    }

    public Player getPlayer(int index) {
        return players[index];
    }



	
	
}