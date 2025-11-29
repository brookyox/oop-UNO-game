package uno;

import java.util.ArrayList;

public class Player {

	private String name;
	private ArrayList<Card> hand;

	public Player(String name) {
		this.name = name;
		this.hand = new ArrayList<>();
	}

	public String getName() {
		return name;
	}
    public int getHandSize() {
    	return hand.size();
    }
    
    
  public void drawCard(Deck deck) {
	  if (!deck.isEmpty()) {
		  Card c = deck.pop();
		  hand.add(c);
	  }
  }
}
