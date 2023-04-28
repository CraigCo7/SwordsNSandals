import java.util.Scanner;
import user.Gladiator;
import user.Gladiator.Builder;
import utils.DelayedStringPrinter;
import utils.Input;
import utils.exceptions.UnknownWeaponException;

public class SwordsNSandals {

  public static void main(String[] args) throws InterruptedException, UnknownWeaponException {
    // Instances of Needed Classes
    DelayedStringPrinter narrator = new DelayedStringPrinter(15);
    Scanner myObj = Input.getScanner();

    // Story Begins
    narrator.print("BackStory Here");

    // 1. Character creation
    // Name

    while (true) {
      narrator.print("What is your name Gladiator?");
      Input.newStringInput();
      narrator.print("Is " + Input.getStringInput() + " your name? (Yes/No)");
      if (Input.validEntryYesNo() == false) {
        continue;
      } else {
        break;
      }
    }

    // Stats

    user.Gladiator temp = new Gladiator.Builder(10, 10, 10, 10).build();
    while (true) {
      narrator.print("Currently your stats are:\n" + temp.getStats());
      narrator.print("You have 50 stats to assign. You will get more when you level up.");

    }

  }
}
