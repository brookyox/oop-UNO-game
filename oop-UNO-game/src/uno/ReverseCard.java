package uno;

public class ReverseCard extends ActionCard {

    public ReverseCard(Color color) {
        super(color);
    }

    @Override
    public String getActionType() {
        return "REVERSE";
    }

    public void apply(Game game) {
        int d = -game.getDirection();
        game.setDirection(d);
    }
}
