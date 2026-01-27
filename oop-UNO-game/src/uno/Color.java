package uno;

public enum Color {
  RED, BLUE, GREEN, YELLOW;

  public static Color fromNumber(int n) {
    switch (n) {
      case 1:
        return RED;
      case 2:
        return BLUE;
      case 3:
        return GREEN;
      case 4:
        return YELLOW;
      default:
        throw new IllegalArgumentException("Invalid color number: " + n);
    }
  }

  public static Color randomColor() {
    int n = (int) (Math.random() * 4) + 1;
    return fromNumber(n);
  }
}
