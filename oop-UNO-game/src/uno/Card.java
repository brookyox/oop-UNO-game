package uno;

public abstract class Card {

    public abstract boolean hasColor();

    public abstract Color getColor();

    public int getValue() {
        return -1;
    }
    public String getActionType() {
        return null;
    }

    public boolean canBePlayed(Game game) {
        Card topCard = game.getTop();

        
        if (!this.hasColor()) return true;

        // same color → playable
        if (this.getColor() == topCard.getColor()) return true;

        // NumberCard → same number
        if (this.getValue() != -1 && this.getValue() == topCard.getValue()) return true;

        // ActionCard → same action type
        if (this instanceof ActionCard && topCard instanceof ActionCard) {
            String myAction = this.getActionType();
            String topAction = topCard.getActionType();
            if (myAction != null && myAction.equals(topAction)) return true;
        }

        return false;
    }
}
