import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import user.Gladiator;
import user.Gladiator.Builder;
import user.Gladiator.Equipped;
import user.Player;
import user.items.Equipment;
import user.items.Sword;
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

    String name;
    while (true) {
      narrator.print("What is your name Gladiator?");
      Input.newStringInput();
      name = Input.getStringInput();
      narrator.print("Is " + name + " your name? (Yes/No)");
      if (Input.validEntryYesNo() == false) {
        continue;
      } else {
        break;
      }
    }

    // Stats

    user.Player user = Player.newPlayer(name);
    narrator.print("You currently have:\n" + user.getStats());
    List<Integer> addStats = user.promptAddStats(50);

    // Prompt User to confirm their stats.
    while (true) {
      narrator.print("Your stats are:\n" + user.viewProjectedStats(addStats.get(0), addStats.get(1),
          addStats.get(2), addStats.get(3)));
      narrator.print("Is this to your liking? (Yes/No)");
      Input.newStringInput();
      if (Input.validEntryYesNo() == false) {
        addStats = user.promptAddStats(50);
      } else {
        user.addStats(addStats);
        break;
      }
    }

    // Assign first weapon

    narrator.print("Here is your first weapon.");
    Equipment weapon = new Sword(1);
    System.out.println(weapon.getId());
    Equipped equipment = user.getEquipped();
    equipment.equipWeapon(weapon);

    // Freeplay
    List<String> homeOptions = new ArrayList<String>(Arrays.asList("battle", "shop", "inventory"));

    narrator.print("This is where I leave you...");

    narrator.print("What is next on the agenda? (Battle/Shop/Inventory)");
    Input.validEntry(homeOptions);
  }
}
