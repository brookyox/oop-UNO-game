package uno;

public class Bot extends Player {
    public Bot(String name, boolean b) {
        super(name,b);
    }
    
    public int easyTurn(Game game) { 
        for (int i = 0; i < getHandSize(); i++) {
            if (seeCard(i).canBePlayed(game)) {
                return i; //plays the first playable card
            }
        }
        return -1; 
    }
    
    public int easyColor(Game game) {
    	int rand = (int)(Math.random() * 4) + 1;
    	return rand;//chose a random color
    }
    
    public int mediumTurn(Game game) {
		int priority = 0; //has priorities 
    	for (int i = 0; i < getHandSize(); i++) {
            if (seeCard(i).canBePlayed(game)) {
            	Card card = seeCard(i);
               if (card instanceof ActionCard) {
            	   priority = 1;//prioritize action cards
               }
               if (card instanceof NumberCard && priority != 1) {
            	   priority = 2;//uses number cards as a second priority
               }
               if (card instanceof Wild4Card && priority != 1 && priority != 2) {
            	   priority = 3;//uses wild4cards and wild cards as a last resort
               }
               if (card instanceof WildCard && priority != 1 && priority != 2 && priority != 3) {
            	   priority = 4;//prioritize wild4cards because of the +4 effect
               }
            }
    	}
    	for (int i = 0; i < getHandSize(); i++) {
    		if (seeCard(i).canBePlayed(game)) {
            	Card card = seeCard(i);
    			if (priority == 1) {
    				if (card instanceof ActionCard) {
    	            	   return i;
    	               }
    			}
    			if (priority == 2) {
    				if (card instanceof NumberCard) {
    	            	   return i;
    	               }
    			}
    			if (priority == 3) {
    				if (card instanceof Wild4Card) {
    	            	   return i;
    	               }
    			}
    			if (priority == 4) {
    				return i;
    			}
    		}
    	}
    	return -1;
    }
    
    public int mediumColor(Game game) {
    	for (int i = 0; i < getHandSize(); i++) {
            if (seeCard(i).canBePlayed(game) && !(seeCard(i) instanceof WildCard)) {
            	Card card = seeCard(i);
            	if (card.getColor() == Color.RED){
                	return 1;
                }
            	if (card.getColor() == Color.BLUE){
                	return 2;
            	}
            	if (card.getColor() == Color.GREEN){
                	return 3;
            	}
            	if (card.getColor() == Color.YELLOW){
                	return 4;
            	}
            }
    	}
    	int rand = (int)(Math.random() * 4) + 1;
    	return rand;//chose a random color
    }	
    
    public int HardTurn(Game game) {
		int priority = 0;
    	boolean danger = game.getNextPlayer().getHandSize() <= 3;
    	int red=0;
    	int blue=0;
    	int green=0;
    	int yellow=0;
    	for (int i = 0; i < getHandSize(); i++) {
        	Card card = seeCard(i);
    		if (card.getColor() == Color.RED){
            	red ++;
            }
        	if (card.getColor() == Color.BLUE){
            	blue++;
        	}
        	if (card.getColor() == Color.GREEN){
            	green++;
        	}
        	if (card.getColor() == Color.YELLOW){
            	yellow++;
        	}
        }
    	for (int i = 0; i < getHandSize(); i++) {
    		Card card = seeCard(i);
            if (card.canBePlayed(game)) {
            	if (danger && (card instanceof ActionCard || card instanceof Wild4Card)){
            		priority = 1;
            	}
                if (card instanceof NumberCard && priority != 1) {
             	   priority = 2;
                }
                if (card instanceof ActionCard && !danger && priority != 1 && priority != 2) {
             	   priority = 3;
                }
                if (card instanceof WildCard && !danger && priority != 1 && priority != 2 && priority != 3) {
             	   priority = 4;
                }
            }
    	}
    	
    	for (int i = 0; i < getHandSize(); i++) {
    		if (seeCard(i).canBePlayed(game)) {
            	Card card = seeCard(i);
    			if (priority == 1) {
    				if (card instanceof ActionCard || card instanceof Wild4Card) {
    	            	   return i;
    	               }
    			}
    	    	if (priority == 2 || priority == 3) {
    	    		int[] colors = {1, 2, 3, 4}; // 1=red, 2=blue, 3=green, 4=yellow
    	    		
    	    		for (int j = 0; j < 3; j++) {
    	    		    int maxIndex = j;

    	    		    for (int k = j + 1; k < 4; k++) {

    	    		        // compare directly using your variables
    	    		        int maxValue = 0;
    	    		        int currentValue = 0;

    	    		        // value at maxIndex
    	    		        if (colors[maxIndex] == 1) maxValue = red;
    	    		        else if (colors[maxIndex] == 2) maxValue = blue;
    	    		        else if (colors[maxIndex] == 3) maxValue = green;
    	    		        else maxValue = yellow;

    	    		        // value at k
    	    		        if (colors[k] == 1) currentValue = red;
    	    		        else if (colors[k] == 2) currentValue = blue;
    	    		        else if (colors[k] == 3) currentValue = green;
    	    		        else currentValue = yellow;

    	    		        if (currentValue > maxValue) {
    	    		            maxIndex = k;
    	    		        }
    	    		    }

    	    		    // swap colors
    	    		    int tmp = colors[j];
    	    		    colors[j] = colors[maxIndex];
    	    		    colors[maxIndex] = tmp;
    	    		}
    	    		if (priority == 2) {
    	    			if (card instanceof NumberCard) {
    	    			    for (int l = 0; l < colors.length; l++) {
    	    			        int preferredColor = colors[l]; // 1=RED, 2=BLUE, 3=GREEN, 4=YELLOW

    	    			        switch (preferredColor) {
    	    			            case 1: // RED
    	    			                if (card.getColor() == Color.RED) {
    	    			                    return i; 
    	    			                }
    	    			                break;
    	    			            case 2:
    	    			                if (card.getColor() == Color.BLUE) {
    	    			                    return i;
    	    			                }
    	    			                break;
    	    			            case 3: // GREEN
    	    			                if (card.getColor() == Color.GREEN) {
    	    			                    return i;
    	    			                }
    	    			                break;
    	    			            case 4: // YELLOW
    	    			                if (card.getColor() == Color.YELLOW) {
    	    			                    return i;
    	    			                }
    	    			                break;
    	    			        }
    	    			    }
    	    			}
    	    		}
    			if (priority == 3) {
    				if (card instanceof ActionCard) {
	    			    for (int l = 0; l < colors.length; l++) {
	    			        int preferredColor = colors[l]; // 1=RED, 2=BLUE, 3=GREEN, 4=YELLOW

	    			        switch (preferredColor) {
	    			            case 1: // RED
	    			                if (card.getColor() == Color.RED) {
	    			                    return i; 
	    			                }
	    			                break;
	    			            case 2:
	    			                if (card.getColor() == Color.BLUE) {
	    			                    return i;
	    			                }
	    			                break;
	    			            case 3: // GREEN
	    			                if (card.getColor() == Color.GREEN) {
	    			                    return i;
	    			                }
	    			                break;
	    			            case 4: // YELLOW
	    			                if (card.getColor() == Color.YELLOW) {
	    			                    return i;
	    			                }
	    			                break;
	    			        }
	    			    }
    	               }
    			}
    			if (priority == 4) {
    				return i;
    				}
    	    	}
    		}
    	}
        return -1; 
    }
    public int hardColor(Game game){
    	int red=0;
    	int blue=0;
    	int green=0;
    	int yellow=0;
    	for (int i = 0; i < getHandSize(); i++) {
        	Card card = seeCard(i);
    		if (card.getColor() == Color.RED){
            	red ++;
            }
        	if (card.getColor() == Color.BLUE){
            	blue++;
        	}
        	if (card.getColor() == Color.GREEN){
            	green++;
        	}
        	if (card.getColor() == Color.YELLOW){
            	yellow++;
        	}
    	}
    	int max = red;

    	if (blue > max) {
    	    max = blue;
    	}
    	if (green > max) {
    	    max = green;
    	}
    	if (yellow > max) {
    	    max = yellow;
    	}
    	if (max == red) {
    		return 1;
    	}
    	if (max == blue) {
    		return 2;
    	}
    	if (max == green) {
    		return 3;
    	}
    	if (max == yellow) {
    		return 4;
    	}
    	int rand = (int)(Math.random() * 4) + 1;
    	return rand;//chose a random color
    }
}