package uno;

import java.util.Scanner;

public class WildCard extends Card {

	private Color chosenColor = null; // no color by default

    @Override
    public boolean hasColor() {
        return false; // Joker has no color initially
    }

    @Override
    public Color getColor() {
        return chosenColor;
    }

    public void changeColor() {
        Scanner sc = new Scanner(System.in);

        int n;
        System.out.println("What is the color for the next player?");
        System.out.println("1: RED \n2: BLUE \n3: GREEN \n4: YELLOW");
        do {   
            while (!sc.hasNextInt()) {   // input validation
                System.out.println("Please enter a number between 1 and 4.");
                sc.next();  // discard invalid input
            }
            n = sc.nextInt();
        } while (n < 1 || n > 4);

        switch (n) {
            case 1 :
            	game.TopColorr = Color.RED;
            	break;            
            case 2 :
            	game.TopColorr = Color.BLUE;
            	break;
            case 3 :
            	game.TopColorr = Color.GREEN;
            	break;
            case 4 :
            	game.TopColorr = Color.YELLOW;
            	break;
           
        }

    }
}