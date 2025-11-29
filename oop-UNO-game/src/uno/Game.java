package uno;
import java.util.ArrayList;
import java.util.Stack;

public class Game {
    private Player[] players = new Player[4];
    private Stack<Card> deck;
    private Stack<Card> disCard;
    private int direction;
    private int currentPlayer;
    private Card top = disCard.peek();
    
 public Game(Player[] players,Stack<Card> deck) {
	 this.players = players;
	 this.deck = deck;
	 this.disCard = new Stack<>();
	 this.currentPlayer =0;
	 this.direction = 1;
 }
}