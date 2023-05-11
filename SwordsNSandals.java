import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import entities.Gladiator;
import entities.Player;
import entities.Gladiator.Equipped;
import entities.Player.Storage;
import entities.command.Attack;
import entities.command.Defend;
import entities.command.Invoker;
import entities.command.Rest;
import entities.items.Equipment;
import entities.items.Sword;
import entities.items.Weapon;
import utils.DelayedStringPrinter;
import utils.Input;
import utils.exceptions.NotEnoughExperienceException;
import utils.exceptions.UnknownItemException;
import utils.exceptions.UnknownWeaponException;

public class SwordsNSandals {

  public static void main(String[] args) throws InterruptedException, UnknownWeaponException {

    // Instances of Needed Classes
    DelayedStringPrinter narrator = new DelayedStringPrinter(15);

    // Story Begins
    narrator.print(
        "You were once a humble farmer, tending to your fields and living a peaceful life in your small town. But one fateful day, your peaceful existence was shattered when your town was ambushed by a band of ruthless raiders.");
    narrator.print(
        "In the chaos of the attack, you were captured and thrown into a dark and ominous dungeon, where you were told that the only way to earn your freedom was to fight as a gladiator in the arena.");
    narrator.print(
        "With no other choice, you stepped into the arena, facing off against other prisoners, wild beasts, and skilled fighters. You quickly learned that the only way to survive was to fight with all your strength and cunning, using every weapon and skill at your disposal.");
    narrator.print(
        "But your ultimate goal was not just to survive, it was to become the champion of the arena and earn your freedom. To do so, you would have to face the most formidable foes and the deadliest challenges, all while battling the inner demons that threatened to consume you.");
    narrator.print(
        "Do you have what it takes to fight your way to victory and earn your freedom? Only time will tell as you enter the arena and begin your quest to become the champion.");

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

    entities.Player user = Player.newPlayer(name);
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
    List<String> gladiatorNames = new ArrayList<String>(Arrays.asList("Zzyzx", "Nimrod", "Octavius",
        "Cletus", "Xantha", "Ptolemy", "Mordecai", "Persephone", "Grendel", "Soren"));
    List<String> homeOptions = new ArrayList<String>(Arrays.asList("battle", "shop", "inventory"));
    List<String> shopOptions = new ArrayList<String>(Arrays.asList("weapon", "armor", "back"));
    List<String> inventoryOptions = new ArrayList<String>(Arrays.asList("view", "equip", "back"));
    List<String> battleOptions = new ArrayList<String>(Arrays.asList("attack", "defend", "rest"));



    narrator.print(
        "This is where I leave you... Fight your way until you accumulate 1000XP and LVL 7. Only then will you be set free!");


    while (true) {
      narrator.print("Your current level is: " + user.getLevel() + ". You have "
          + user.getExperience() + " experience.");
      narrator.print("What is next on the agenda? (Battle/Shop/Inventory)");
      String entry = Input.validEntry(homeOptions);
      if (entry.equals("shop")) { // SHOP
        narrator.print("Welcome to the Shop!");
        while (true) {
          narrator.print("Would you like a weapon or armor? (Weapon/Armor/Back)");
          entry = Input.validEntry(shopOptions);
          if (entry.equals("weapon")) {
            try {
              equipment = Weapon.buyWeapon(user);
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
              try {
                Input.newIntInput();;

              } catch (Exception e) {
                System.out.println("Please enter an integer!");
              }
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
        Random rand = new Random();

        Gladiator opponent = Gladiator.createGladiator(user.getLevel());
        System.out.println("USER LEVEL: " + user.getLevel());
        opponent.setName(gladiatorNames.get(rand.nextInt(10)));

        user.resetHealth();
        user.resetStamina();
        user.resetArmor();
        user.resetDefense();
        opponent.resetHealth();
        opponent.resetStamina();
        opponent.resetArmor();
        opponent.resetDefense();

        Attack playerAttack = new Attack(user, opponent);
        Defend playerDefend = new Defend(user, opponent);
        Rest playerRest = new Rest(user, opponent);
        Attack opponentAttack = new Attack(opponent, user);
        Defend opponentDefend = new Defend(opponent, user);
        Rest opponentRest = new Rest(opponent, user);
        Invoker invoker = new Invoker();

        while (true) {
          if (user.getHealth() <= 0) {
            narrator.print("YOU LOST!");
            break;
          }
          if (opponent.getHealth() <= 0) {
            narrator.print(opponent.getName() + " bit the dust... Victory!");
            narrator.print(user.getName() + " received 200XP.");
            user.addExperience(400 - 30 * user.getLevel());
            if (user.getExperience() >= 500) {
              user.levelUp();
            }
            break;
          }

          narrator.print("NAME:\t\t" + user.getName() + "\nARMOR:\t\t" + user.getArmor()
              + "\nHEALTH:\t\t" + user.getHealth() + "\nSTAMINA:\t" + user.getStamina()
              + "\nWEAPON:\t" + user.getEquipped().getWeapon());
          System.out.println(
              "------------------------------------------------------------------------------------------");
          narrator.print("OPPONENT LEVEL: " + opponent.getLevel());

          narrator.print("NAME:\t\t" + opponent.getName() + "\nARMOR:\t\t" + opponent.getArmor()
              + "\nHEALTH:\t\t" + opponent.getHealth() + "\nSTAMINA:\t" + opponent.getStamina()
              + "\nWEAPON:\t" + opponent.getEquipped().getWeapon());


          narrator.print("Enter 3 moves for this turn. (Attack/Defend/Rest)");
          List<String> moves = new ArrayList<String>(3);
          String act1 = Input.validEntry(battleOptions);
          String act2 = Input.validEntry(battleOptions);
          String act3 = Input.validEntry(battleOptions);
          moves.add(act1);
          moves.add(act2);
          moves.add(act3);

          for (int i = 0; i < 3; i++) {

            // Player moves first
            if (moves.get(i).equals("attack")) {
              invoker.addActivity(playerAttack);
            } else if (moves.get(i).equals("defend")) {

              invoker.addActivity(playerDefend);
            } else if (moves.get(i).equals("rest")) {

              invoker.addActivity(playerRest);
            }

            // Computer moves second
            int computer = rand.nextInt(3);
            if (computer == 0) {
              invoker.addActivity(opponentAttack);
            } else if (computer == 1) {
              invoker.addActivity(opponentDefend);
            } else {
              invoker.addActivity(opponentRest);
            }
          }
          invoker.performActivities();
          narrator.print("END OF TURN!");
          user.addStamina();
          opponent.addStamina();
          user.resetDefense();
          opponent.resetDefense();
        }
      }
    }
  }
}
