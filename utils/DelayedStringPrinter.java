package utils;

public class DelayedStringPrinter {

  private int delay;

  public DelayedStringPrinter(int delay) {
    this.delay = delay;
  }

  public void print(String str) {
    for (char c : str.toCharArray()) {
      System.out.print(c);
      try {
        Thread.sleep(delay);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    System.out.println();
    try {
      Thread.sleep(800);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
