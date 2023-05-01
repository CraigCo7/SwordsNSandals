import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import user.Gladiator;
import user.Gladiator.Builder;
import user.Gladiator.Equipped;
import user.Player.Storage;
import user.Player;
import user.items.Equipment;
import user.items.Sword;
import utils.DelayedStringPrinter;
import utils.Input;
import utils.exceptions.NotEnoughExperienceException;
import utils.exceptions.UnknownItemException;
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
    Storage storage = Player.getStorage();
    Equipment equipment = new Sword(1);
    storage.addItem(equipment);
    Equipped equipped = user.getEquipped();
    equipped.equipItem(equipment);

    // Freeplay
    List<String> homeOptions = new ArrayList<String>(Arrays.asList("battle", "shop", "inventory"));
    List<String> shopOptions = new ArrayList<String>(Arrays.asList("weapon", "armor", "back"));
    List<String> inventoryOptions = new ArrayList<String>(Arrays.asList("view", "equip", "back"));

    narrator.print("This is where I leave you...");


    while (true) {
      narrator.print("What is next on the agenda? (Battle/Shop/Inventory)");
      String entry = Input.validEntry(homeOptions);
      if (entry.equals("shop")) { // SHOP
        narrator.print("Welcome to the Shop!");
        while (true) {
          narrator.print("Would you like a weapon or armor? (Weapon/Armor/Back)");
          entry = Input.validEntry(shopOptions);
          if (entry.equals("weapon")) {
            try {
              equipment = Equipment.buyWeapon(user);
              storage.addItem(equipment);
            } catch (NotEnoughExperienceException e) {
              e.printStackTrace();
            }
          } else if (entry.equals("armor")) {
            try {
              equipment = Equipment.buyArmor(user);
              storage.addItem(equipment);
            } catch (NotEnoughExperienceException e) {
              e.printStackTrace();
            }
          } else {
            break;
          }
        }
      } else if (entry.equals("inventory")) { // INVENTORY
        while (true) {
          narrator.print("What would you like to do? (View/Equip/Back)");
          entry = Input.validEntry(inventoryOptions);
          if (entry.equals("view")) {
            narrator.print("Here are your items:");
            storage.viewStorage();
          } else if (entry.equals("equip")) {
            narrator.print(
                "To equip an item, enter the ID of the item you wish to equip. You can choose to return to the previous menu by typing (0)");
            while (true) {
              narrator.print("What would you like to equip?");
              Input.newIntInput();;
              int num = Input.getNumInput();
              if (num == 0) {
                break;
              } else {
                try {
                  user.equipItemById(num);
                } catch (UnknownItemException e) {
                  e.printStackTrace();
                }
              }
            }
          } else {
            break;
          }
        }


      } else if (entry.equals("battle")) {

      }
    }
  }
}
