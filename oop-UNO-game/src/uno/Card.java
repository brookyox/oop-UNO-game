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

    public abstract boolean canBePlayed(Game game);
}

