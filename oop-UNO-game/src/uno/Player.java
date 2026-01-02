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
    public ArrayList<Card> getHand() {
        return hand;
    }
    
  public void drawCard(Deck deck) {
	  if (!deck.isEmpty()) {
		  Card card  = deck.pop();
		  hand.add(card);
	  }
  }
  	  
  public Card playCard(int index){
	  if(index >= 1 && index <= hand.size() ) {
		  return hand.remove(index -1);
	  }
		  return null;
  }
  public void showHand() {
      for (int i = 0; i < hand.size(); i++) {
          System.out.println(i + " : " + hand.get(i));
      }
  }
}
