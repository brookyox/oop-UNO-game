package uno;

public class GameSave {
	int gameNumber;
	String winnerName;
	int cardPlaced;
	int pointsWon;
	
	

	public GameSave(int ng, int cardPlaced, Player current) {
		// TODO Auto-generated constructor stub
		this.gameNumber = ng;
		this.cardPlaced= cardPlaced;
		this.winnerName= current.getName();
		if(cardPlaced <= 50) {
			this.pointsWon = 15;
		}else if(cardPlaced <= 100) {
			this.pointsWon = 10;
		}else {
			this.pointsWon = 5;
		}
		int n = current.getDrawCounter();
		if(n <= 5) {
			this.pointsWon += 10 - 2*n;
		}
	}
	
	public void Display() {
		System.out.println("Game number "+this.gameNumber);
		System.out.println("Cards Placed: "+this.cardPlaced);
		System.out.println("Winner: "+this.winnerName);
		System.out.println("Points won: "+this.pointsWon);
		
	}

	
}
