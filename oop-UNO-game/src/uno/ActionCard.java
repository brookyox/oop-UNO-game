package uno;
enum Color{
	RED,BLUE,GREEN,YELLOW
}


public class ActionCard extends Card {
	
	private Color color;

	public ActionCard(Color color) {
		this.color = color;
	}

	public Color getColor() {
		return color;
	}
	

}
