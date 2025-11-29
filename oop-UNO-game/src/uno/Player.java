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
		  Card card  = deck.pop();
		  hand.add(c);
	  }
  }
  
  
  public boolean PlayableCard(Stack<Card> DisCard) {
	  Card top = DisCard.peek();}
	  
  public playCard(int index) {
	  
  }
  public void showHand() {
      for (int i = 0; i < hand.size(); i++) {
          System.out.println(i + " : " + hand.get(i));
      }
  }
}
