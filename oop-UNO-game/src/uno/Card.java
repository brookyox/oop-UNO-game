package uno;

public abstract class Card {

    
    public abstract boolean hasColor();

    
    public abstract Color getColor();

    
    public boolean canBePlayed(Card topCard) {
        

        // 1️⃣ Joker → toujours jouable
        if (!this.hasColor()) return true;

        // 2️⃣ Même couleur → jouable
        if (this.getColor() == topCard.getColor()) return true;

        // 3️⃣ NumberCard → même valeur
        if (this.getValue() != -1 && this.getValue() == topCard.getValue()) return true;

        // 4️⃣ ActionCard → même type d'action
        if (this instanceof ActionCard && topCard instanceof ActionCard) {
            // cast pour accéder à getActionType()
            String myAction = ((ActionCard)this).getActionType();
            String topAction = ((ActionCard)topCard).getActionType();

            if (myAction.equals(topAction)) return true;
        }

        // sinon → pas jouable
        return false;
    }

}
