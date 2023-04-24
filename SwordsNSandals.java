import java.util.Scanner;
import user.Player;
import utils.DelayedStringPrinter;
import utils.Input;

public class SwordsNSandals {

  public static void main(String[] args) throws InterruptedException {
    // Instances of Needed Classes
    DelayedStringPrinter narrator = new DelayedStringPrinter(15);
    Scanner myObj = Input.getScanner();

    // Story Begins
    narrator.print("BackStory Here");

    // 1. Character creation
    // Name
    Player.setName(narrator);

    narrator.print("Greetings, " + Player.getName() + "!");

    // Initializing Stats
    Player player;

    narrator.print("To begin, customize your gladiator.");
    narrator.print(
      "Currently, his stats are:\nAttack: 10\nDefense: 10\nHealth: 10\nStamina: 10"
    );
    narrator.print(
      "You have 15 free points to assign. You will get more as you level up."
    );

    player = Player.initializeCharacterStats(Player.getName(), myObj, narrator);

    narrator.print("Your stats are:");
    narrator.print(player.getStats());
    narrator.print("Is this to your liking?");

    while (
      Input.validEntryYesNo() == false || Input.getStringInput().equals("no")
    ) {
      if (Input.validEntryYesNo() == false) {
        narrator.print("Please enter a valid input! (Yes/No)");
      } else {
        player =
          Player.initializeCharacterStats(Player.getName(), myObj, narrator);
        narrator.print("Your stats are:");
        narrator.print(player.getStats());
        narrator.print("Is this to your liking?");
      }
    }
    // Start of Story

  }
}
