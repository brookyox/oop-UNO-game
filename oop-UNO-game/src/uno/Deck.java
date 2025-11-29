package uno;

import java.util.Stack;
public class Deck {
	private Stack<card> pile = new Stack<>();
	public deck() {
		pile.push(new NumberCard(Color.BLUE, 0));
		
		for (int i = 1; i <= 9; i++) {
		    pile.push(new NumberCard(Color.BLUE, i));
		    pile.push(new NumberCard(Color.BLUE, i));
		}

		pile.push(new ActionCard(Color.BLUE, Type.SKIP));
		pile.push(new ActionCard(Color.BLUE, Type.SKIP));

		pile.push(new ActionCard(Color.BLUE, Type.REVERSE));
		pile.push(new ActionCard(Color.BLUE, Type.REVERSE));

		pile.push(new ActionCard(Color.BLUE, Type.DRAW_TWO));
		pile.push(new ActionCard(Color.BLUE, Type.DRAW_TWO));
		
		pile.push(new NumberCard(Color.RED, 0));
		
		for (int i = 1; i <= 9; i++) {
		    pile.push(new NumberCard(Color.RED, i));
		    pile.push(new NumberCard(Color.RED, i));
		}

		pile.push(new ActionCard(Color.RED, Type.SKIP));
		pile.push(new ActionCard(Color.RED, Type.SKIP));

		pile.push(new ActionCard(Color.RED, Type.REVERSE));
		pile.push(new ActionCard(Color.RED, Type.REVERSE));

		pile.push(new ActionCard(Color.RED, Type.DRAW_TWO));
		pile.push(new ActionCard(Color.RED, Type.DRAW_TWO));
		
		pile.push(new NumberCard(Color.YELLOW, 0));
		
		for (int i = 1; i <= 9; i++) {
		    pile.push(new NumberCard(Color.YELLOW, i));
		    pile.push(new NumberCard(Color.YELLOW, i));
		}

		pile.push(new ActionCard(Color.YELLOW, Type.SKIP));
		pile.push(new ActionCard(Color.YELLOW, Type.SKIP));

		pile.push(new ActionCard(Color.YELLOW, Type.REVERSE));
		pile.push(new ActionCard(Color.YELLOW, Type.REVERSE));

		pile.push(new ActionCard(Color.YELLOW, Type.DRAW_TWO));
		pile.push(new ActionCard(Color.YELLOW, Type.DRAW_TWO));
		
		pile.push(new NumberCard(Color.YELLOW, 0));
		
		for (int i = 1; i <= 9; i++) {
		    pile.push(new NumberCard(Color.GREEN, i));
		    pile.push(new NumberCard(Color.GREEN, i));
		}

		pile.push(new ActionCard(Color.GREEN, Type.SKIP));
		pile.push(new ActionCard(Color.GREEN, Type.SKIP));

		pile.push(new ActionCard(Color.GREEN, Type.REVERSE));
		pile.push(new ActionCard(Color.GREEN, Type.REVERSE));

		pile.push(new ActionCard(Color.GREEN, Type.DRAW_TWO));
		pile.push(new ActionCard(Color.GREEN, Type.DRAW_TWO));
		
		for (int i = 0; i < 4; i++) {
		    pile.push(new WildCard(Type.WILD));
		    pile.push(new WildCard(Type.WILD_DRAW_FOUR));
		}
	}
    
	public card draw() {
		return pile.pop();
	}
	public void shuffle() {
		
	}
}