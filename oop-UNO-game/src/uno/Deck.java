package uno;

import java.util.Stack;
public class Deck {
	private Stack<Card> pile = new Stack<>();
	public Deck() {
		pile.push(new NumberCard(Color.BLUE, 0));
		
		for (int i = 1; i <= 9; i++) {
		    pile.push(new NumberCard(Color.BLUE, i));
		    pile.push(new NumberCard(Color.BLUE, i));
		}

		pile.push(new BlockCard(Color.BLUE));
		pile.push(new BlockCard(Color.BLUE));

		pile.push(new ReverseCard(Color.BLUE));
		pile.push(new ReverseCard(Color.BLUE));

		pile.push(new Plus2Card(Color.BLUE));
		pile.push(new Plus2Card(Color.BLUE));
		
		pile.push(new NumberCard(Color.RED, 0));
		
		for (int i = 1; i <= 9; i++) {
		    pile.push(new NumberCard(Color.RED, i));
		    pile.push(new NumberCard(Color.RED, i));
		}

		pile.push(new BlockCard(Color.RED));
		pile.push(new BlockCard(Color.RED));

		pile.push(new ReverseCard(Color.RED));
		pile.push(new ReverseCard(Color.RED));

		pile.push(new Plus2Card(Color.RED));
		pile.push(new Plus2Card(Color.RED));
		
		pile.push(new NumberCard(Color.YELLOW, 0));
		
		for (int i = 1; i <= 9; i++) {
		    pile.push(new NumberCard(Color.YELLOW, i));
		    pile.push(new NumberCard(Color.YELLOW, i));
		}

		pile.push(new BlockCard(Color.YELLOW));
		pile.push(new BlockCard(Color.YELLOW));

		pile.push(new ReverseCard(Color.YELLOW));
		pile.push(new ReverseCard(Color.YELLOW));

		pile.push(new Plus2Card(Color.YELLOW));
		pile.push(new Plus2Card(Color.YELLOW));
		
		pile.push(new NumberCard(Color.YELLOW, 0));
		
		pile.push(new NumberCard(Color.GREEN, 0));
		
		for (int i = 1; i <= 9; i++) {
		    pile.push(new NumberCard(Color.GREEN, i));
		    pile.push(new NumberCard(Color.GREEN, i));
		}

		pile.push(new BlockCard(Color.GREEN));
		pile.push(new BlockCard(Color.GREEN));

		pile.push(new ReverseCard(Color.GREEN));
		pile.push(new ReverseCard(Color.GREEN));

		pile.push(new Plus2Card(Color.GREEN));
		pile.push(new Plus2Card(Color.GREEN));
		
		for (int i = 0; i < 4; i++) {
			pile.push(new WildCard());
		    pile.push(new Wild4Card());
		}
	}
    
	public Card draw() {
		return pile.pop();
	}
	public void shuffle() {
		
	}
}