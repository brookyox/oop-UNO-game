package uno;

import java.util.Scanner;

public class GeneralScanner {
  private static Scanner scanner;

  private GeneralScanner() {
  }

  public static Scanner getScanner() {
    if (scanner == null)
      scanner = new Scanner(System.in);

    return scanner;
  }

  public static void closeScanner() {
    if (scanner == null)
      return;

    scanner.close();
    scanner = null;
  }
}
