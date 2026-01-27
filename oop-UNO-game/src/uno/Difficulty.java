package uno;

public enum Difficulty {
  EASY, MEDIUM, HARD;

  public static Difficulty fromNumber(int n) {
    switch (n) {
      case 1:
        return EASY;
      case 2:
        return MEDIUM;
      case 3:
        return HARD;
      default:
        throw new IllegalArgumentException("Invalid difficulty number: " + n);
    }
  }
}
