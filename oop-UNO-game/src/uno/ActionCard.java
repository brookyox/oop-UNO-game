package uno;

public abstract class ActionCard extends Card {

    private Color color;

    public ActionCard(Color color) {
        this.color = color;
    }

    @Override
    public boolean hasColor() {
        return true;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public int getValue() {
        return -1; // ActionCards don't have numbers
    }

    @Override
    public String getActionType() {
        return "ACTION"; // default, to override in subclasses
    }

	@Override
	public abstract boolean canBePlayed(Game game);
	
	public abstract void effect(Game game);
}

