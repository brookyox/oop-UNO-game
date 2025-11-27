package uno;
enum Color{
	RED,BLEU,GREEN,YELLOW,JOKER
}

public class Card {
	
	private Color color ;
	
	public Card(Color color) {
        this.color = color;
    }
	
	public Boolean canBePlayed() {
		
		return this.color == Game.topColor ;
		
	}
	
	
	

}
