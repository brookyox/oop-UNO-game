package uno;

public class Plus2Card extends ActionCard {

    public Plus2Card(Color color) {
        super(color);
    }

    @Override
    public String getActionType() {
        return "+2";
    }

    public void apply(Game game, Deck deck) {
       
    }
}
