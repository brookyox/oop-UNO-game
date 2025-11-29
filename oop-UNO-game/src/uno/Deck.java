package uno;

import java.util.Stack;
public class Deck {
	private Stack<Card> deck = new Stack<>();
	public Deck() {
		deck.push(new NumberCard(Color.BLUE, 0));
		
		for (int i = 1; i <= 9; i++) {
		    deck.push(new NumberCard(Color.BLUE, i));
		    deck.push(new NumberCard(Color.BLUE, i));
		}

		deck.push(new BlockCard(Color.BLUE));
		deck.push(new BlockCard(Color.BLUE));

		deck.push(new ReverseCard(Color.BLUE));
		deck.push(new ReverseCard(Color.BLUE));

		deck.push(new Plus2Card(Color.BLUE));
		deck.push(new Plus2Card(Color.BLUE));
		
		deck.push(new NumberCard(Color.RED, 0));
		
		for (int i = 1; i <= 9; i++) {
		    deck.push(new NumberCard(Color.RED, i));
		    deck.push(new NumberCard(Color.RED, i));
		}

		deck.push(new BlockCard(Color.RED));
		deck.push(new BlockCard(Color.RED));

		deck.push(new ReverseCard(Color.RED));
		deck.push(new ReverseCard(Color.RED));

		deck.push(new Plus2Card(Color.RED));
		deck.push(new Plus2Card(Color.RED));
		
		deck.push(new NumberCard(Color.YELLOW, 0));
		
		for (int i = 1; i <= 9; i++) {
		    deck.push(new NumberCard(Color.YELLOW, i));
		    deck.push(new NumberCard(Color.YELLOW, i));
		}

		deck.push(new BlockCard(Color.YELLOW));
		deck.push(new BlockCard(Color.YELLOW));

		deck.push(new ReverseCard(Color.YELLOW));
		deck.push(new ReverseCard(Color.YELLOW));

		deck.push(new Plus2Card(Color.YELLOW));
		deck.push(new Plus2Card(Color.YELLOW));
		
		deck.push(new NumberCard(Color.YELLOW, 0));
		
		deck.push(new NumberCard(Color.GREEN, 0));
		
		for (int i = 1; i <= 9; i++) {
		    deck.push(new NumberCard(Color.GREEN, i));
		    deck.push(new NumberCard(Color.GREEN, i));
		}

		deck.push(new BlockCard(Color.GREEN));
		deck.push(new BlockCard(Color.GREEN));

		deck.push(new ReverseCard(Color.GREEN));
		deck.push(new ReverseCard(Color.GREEN));

		deck.push(new Plus2Card(Color.GREEN));
		deck.push(new Plus2Card(Color.GREEN));
		
		for (int i = 0; i < 4; i++) {
			deck.push(new WildCard());
		    deck.push(new Wild4Card());
		}
	}
    
	public Card draw() {
		return deck.pop();
	}
	public void shuffle() {
		
	}
}