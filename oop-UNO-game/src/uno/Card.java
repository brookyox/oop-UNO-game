package uno;

public abstract class Card {

    // true si la carte possède une couleur (Number, Action)
    public abstract boolean hasColor();

    // renvoie la couleur si elle existe, sinon null
    public abstract Color getColor();

    // règle UNO simple : même couleur OU même type de carte OU joker
    public boolean canBePlayed(Game game) {

        // JOKER → toujours jouable
        if (!this.hasColor()) {
            return true;
        }

        // carte colorée → même couleur
        return this.getColor() == game.topColor;
    }
}
