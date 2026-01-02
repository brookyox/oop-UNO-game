package uno;

import java.util.ArrayList;

public class Bot extends Player {

    public Bot(String name) {
        super(name);
    }

    public Card easyTurn(Game game) {
        for (Card card : getHand()) {
            if (card.canBePlayed(game)) {
                getHand().remove(card);
                if (card instanceof WildCard) {
                	
                }
                
                return card;
            }
        }
        drawCard(game.getDeck());
        return null;
    }
}