package uno;

import java.util.Stack;
import java.util.Scanner;

public class Game {
	private Player[] players = new Player[4];
	private Deck deck;
	private Stack<Card> disCard;
	private int direction;
	private int currentPlayer;
	private Card top = disCard.peek();
	private Color topColor;


	Scanner scanner = new Scanner(System.in);

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
		while (first instanceof WildCard) {
			disCard.push(first);
			first = deck.pop();
		}
		while (!disCard.isEmpty()) {
			Card temp = disCard.pop();
			deck.push(temp);
		}
		disCard.push(first);
	}

	public void playTurn() {
		Player current = players[currentPlayer];
		System.out.println("it's" + current.getName() + "'s turn.");
		System.out.println("top card is : " + top);
		System.out.print("press Enter to show hand...");
		scanner.nextLine();
		int drawAllowed=0; //only one draw allowed 
		boolean turnfinish =false;
		while (turnfinish == false) {
			System.out.print("choose the index of the card you want to play or choose 0 to draw a card  : ");// index
																												// start
																												// from
																												// 1
			current.showHand();
			int choice = scanner.nextInt() - 1;
			if (choice >= 0 && choice < current.getHandSize()) {
				Card selectedCard = current.seeCard(choice);
				if (selectedCard.canBePlayed(this)) {
					System.out.println("the selected card can be play.");
					current.playCard(choice);
					System.out.println(current.getName() + "played his turn");
					turnfinish = true;
					this.applyEffect();
					this.checkWinCond();
				} else {
					System.out.println("Index invalid or This card cannot be played please chooose another one .");
				}
			} else if (drawAllowed == 1) {
				System.out.println("No card played, you skip your tun.");
				turnfinish = true;
			} else if (choice == -1 && drawAllowed == 0) {
				System.out.println("you are going to draw a card");
				current.drawCard(deck);
				drawAllowed = 1;
			}
		}
	}

	public void applyEffect() {

	}

	public void checkWinCond() {

	}

	public void nextPlayer() {

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