package uno;

import java.util.ArrayList;

public class Bot extends Player {
    public Bot(String name) {
        super(name);
    }
    public int easyTurn(Game game) { 
        for (int i = 0; i < getHandSize(); i++) {
            if (seeCard(i).canBePlayed(game)) {
                return i; 
            }
        }
        return -1; 
    }
    public int easyColor(Game game) {
    	int rand = (int)(Math.random() * 4) + 1;
    	return rand;
    }

    
    }
   
