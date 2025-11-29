package uno;
enum Color{
	RED,BLUE,GREEN,YELLOW
}

public class NumberCard extends Card {
	
	private int number;
	private Color color;

	public NumberCard(Color color ,int number) {
		this.color = color;
		this.number = number;
	}
	public Color getColor() {
		return color;
	}
	public int getValue() {
		return this.number;
	}
	
}