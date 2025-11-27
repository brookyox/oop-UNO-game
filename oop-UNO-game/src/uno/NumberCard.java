package uno;

public class NumberCard extends Card {
	
	private int number;

	public NumberCard(Color color ,int number) {
		super(color);
		this.number = number;
	}
	public int getValue() {
		return this.number;
	}
	
}
