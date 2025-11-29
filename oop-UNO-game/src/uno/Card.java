package uno;

public class Card {
	
	public Boolean canBePlayed() {
		
		return this.color == Game.topColor || this.color == Color.JOKER || ??? ;
		
	}

}
