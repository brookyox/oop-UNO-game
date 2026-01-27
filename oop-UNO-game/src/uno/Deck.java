package uno;

import java.util.Stack;
import java.util.Collections;

public class Deck extends Stack<Card> {
  public Deck() {
    super();
    Color[] unoColors = { Color.BLUE, Color.RED, Color.YELLOW, Color.GREEN };

    for (Color currentColor : unoColors) {
      this.push(new NumberCard(currentColor, 0));
      for (int number = 1; number <= 9; number++) {
        this.push(new NumberCard(currentColor, number));
        this.push(new NumberCard(currentColor, number));
      }

      this.push(new BlockCard(currentColor));
      this.push(new BlockCard(currentColor));

      this.push(new ReverseCard(currentColor));
      this.push(new ReverseCard(currentColor));

      this.push(new Plus2Card(currentColor));
      this.push(new Plus2Card(currentColor));
    }

    for (int i = 0; i < 4; i++) {
      this.push(new WildCard());
      this.push(new Wild4Card());
    }
  }

  public void shuffle() {
    Collections.shuffle(this);
  }
}
