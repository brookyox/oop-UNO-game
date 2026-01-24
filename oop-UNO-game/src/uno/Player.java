 package uno;

import java.util.ArrayList;

public class Player {

	private String name;
	private ArrayList<Card> hand;
	private boolean isHuman ;

	public Player(String name, boolean b) {
		this.name = name;
		this.hand = new ArrayList<>();
		this.isHuman = b;
	}

	public String getName() {
		return name;
	}
	public ArrayList<Card> getHand() {
        return hand;
    }
    public int getHandSize() {
    	return hand.size();
    }
    
    public boolean isHuman() {
		return isHuman;
	}
    
  public void drawCard(Deck deck) {
	  if (!deck.isEmpty()) {
		  Card card  = deck.pop();
		  hand.add(card);
		  
	  }
  } 
  public Card seeCard(int index) {
	    if (index >= 0 && index < hand.size()) {
	        return hand.get(index);
	    }
	    return null;
	}
  
  public Card playCard(int index){
	  if(index >= 0 && index < hand.size() ) {
		  return hand.remove(index);
	  }
		  return null;
  }
  public void showHand() {
      for (int i = 0; i < hand.size(); i++) {
          System.out.println((i + 1) + " : " + hand.get(i));
      }
  }
}
