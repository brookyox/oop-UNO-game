package uno;

import java.util.Scanner;

public class Uno {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("===== THE UNO GAME =====");

		int nbHumanPlayers;
		do {
			System.out.print("Enter number of Human players (max 4) ");
			nbHumanPlayers = scanner.nextInt();
		} while (nbHumanPlayers < 0 || nbHumanPlayers > 4);

		Player[] players = new Player[4];
		scanner.nextLine();

		for (int i = 0; i < nbHumanPlayers; i++) {

			System.out.print("Enter player name: ");
			String name = scanner.nextLine();

			players[i] = new Player(name, true);
		}
		for (int i = nbHumanPlayers; i < 4; i++) {
			players[i] = new Player("Bot " + (i + 1), false);
		}

		Deck deck = new Deck();
		deck.shuffle();
		int n = 0;
		if (nbHumanPlayers != 4) {
			System.out.println("Enter the difficulty of the bots:\n");
			n = scanner.nextInt();
		}

		Game game = new Game(players, deck, n);

		game.start();

		game.StartFirstCard();

		game.setCurrentPlayer(0);

		boolean gameOver = false;

		while (!gameOver) {

			game.playTurn();

			Player current = game.getPlayer(game.getCurrentPlayer());

			if (game.endGame(current)) {
				System.out.println("\n🎉 GAME OVER 🎉");
				System.out.println("Winner is: " + current.getName());
				gameOver = true;
			}
		}

		scanner.close();
	}
}
