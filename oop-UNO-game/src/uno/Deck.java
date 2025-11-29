package uno;

import java.util.Stack;
import java.util.Collections;

public class Deck {
	private Stack<Card> deck = new Stack<>();

	public Deck() {
		Color[] unoColors = new Color[4];
		unoColors[0] = Color.BLUE;
		unoColors[1] = Color.RED;
		unoColors[2] = Color.YELLOW;
		unoColors[3] = Color.GREEN;

		for (Color currentColor : unoColors) {
			deck.push(new NumberCard(currentColor, 0));
			for (int number = 1; number <= 9; number++) {
				deck.push(new NumberCard(currentColor, number));
				deck.push(new NumberCard(currentColor, number));
			}

			deck.push(new BlockCard(currentColor));
			deck.push(new BlockCard(currentColor));

			deck.push(new ReverseCard(currentColor));
			deck.push(new ReverseCard(currentColor));

			deck.push(new Plus2Card(currentColor));
			deck.push(new Plus2Card(currentColor));
		}

		for (int i = 0; i < 4; i++) {
			deck.push(new WildCard());
			deck.push(new Wild4Card());
		}
	}

	public Card draw() {
		return deck.pop();
	}

	public void shuffle() {
		Collections.shuffle(deck);
	}

	public boolean isEmpty() {
		return deck.isEmpty();
	}

	public Card pop() {
		if (!deck.isEmpty()) {
			return deck.remove(deck.size() - 1); 
		}
		return null; 
	}

	public void push(Card card) {
		deck.add(card); 
	}

}