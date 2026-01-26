package uno;

import java.util.Scanner;

public class WildCard extends Card {

	public WildCard() {
		super();
	}

	@Override
	public boolean hasColor() {

		return false;
	}

	@Override
	public Color getColor() {

		return null;
	}

	public void changeColor(Game game) {
		Scanner sc = new Scanner(System.in);

		int n;
		System.out.println("What is the color for the next player?");
		System.out.println("1: RED \n2: BLUE \n3: GREEN \n4: YELLOW");
		do {
			while (!sc.hasNextInt()) { // input validation
				System.out.println("Please enter a number between 1 and 4.");
				sc.next(); // discard invalid input
			}
			n = sc.nextInt();
		} while (n < 1 || n > 4);

		switch (n) {
		case 1:
			game.setTopColor(Color.RED);
			break;
		case 2:
			game.setTopColor(Color.BLUE);
			break;
		case 3:
			game.setTopColor(Color.GREEN);
			break;
		case 4:
			game.setTopColor(Color.YELLOW);
			break;

		}
     sc.close();
	}

	public void changeColorBot(Game game,  Bot bot) {
		int n = 0;
		int d = game.getDifficulty();
		switch (d) {
		case 1:
			n = bot.easyColor(game);

			switch (n) {
			case 1:
				game.setTopColor(Color.RED);
				break;
			case 2:
				game.setTopColor(Color.BLUE);
				break;
			case 3:
				game.setTopColor(Color.GREEN);
				break;
			case 4:
				game.setTopColor(Color.YELLOW);
				break;
			}
			break;
		case 2:
			n = bot.mediumColor(game);

			switch (n) {
			case 1:
				game.setTopColor(Color.RED);
				break;
			case 2:
				game.setTopColor(Color.BLUE);
				break;
			case 3:
				game.setTopColor(Color.GREEN);
				break;
			case 4:
				game.setTopColor(Color.YELLOW);
				break;
			}
			break;
		case 3:
			n = bot.hardColor(game);

			switch (n) {
			case 1:
				game.setTopColor(Color.RED);
				break;
			case 2:
				game.setTopColor(Color.BLUE);
				break;
			case 3:
				game.setTopColor(Color.GREEN);
				break;
			case 4:
				game.setTopColor(Color.YELLOW);
				break;
			}
			break;
			
		}

	}

	@Override
	public boolean canBePlayed(Game game) {

		return true;
	}

	@Override
	public int getValue() {

		return -1;
	}

	@Override
	public String toString() {

		return "JOKER";
	}

}