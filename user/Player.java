package user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import user.items.Equipment;
import utils.DelayedStringPrinter;
import utils.Input;

public class Player {

  private static String name;
  private static int attack;
  private static int defense;
  private static int health;
  private static int stamina;
  private Equipped equipped;
  private Backpack backpack;

  private class Equipped {

    private Equipment helmet;
    private Equipment chestplate;
    private Equipment bracers;
    private Equipment greaves;
    private Equipment weapon;
    private Equipment shield;
  }

  private Player(Builder builder) {
    Player.name = builder.name;
    Player.attack = builder.attack;
    Player.defense = builder.defense;
    Player.health = builder.health;
    Player.stamina = builder.stamina;
  }

  public static class Builder {

    private String name;
    private int attack;
    private int defense;
    private int health;
    private int stamina;

    public Builder(String name) {
      this.name = name;
      this.attack = 10;
      this.defense = 10;
      this.health = 10;
      this.stamina = 10;
    }

    // Function for optional parameter author
    public Builder attack(int attack) {
      this.attack += attack;
      return this;
    }

    // Function for optional parameter author
    public Builder defense(int defense) {
      this.defense += defense;
      return this;
    }

    // Function for optional parameter author
    public Builder health(int health) {
      this.health += health;
      return this;
    }

    // Function for optional parameter author
    public Builder stamina(int stamina) {
      this.stamina += stamina;
      return this;
    }

    // Build function that returns a Book object
    public Player build() {
      return new Player(this);
    }
  }

  // Use to assign name
  public static void setName(DelayedStringPrinter narrator) {
    String answer;
    String name;
    while (true) {
      narrator.print("What is your name, Gladiator?");
      Input.newStringInput();
      name = Input.getStringInput();
      narrator.print("Is " + name + " your name?");

      while (true) {
        Input.newStringInput();
        answer = Input.getStringInput();
        if (Input.validEntryYesNo() == false) {
          narrator.print("Please enter a valid input! (Yes/No)");
        } else {
          break;
        }
      }
      if (Input.getStringInput().equals("yes")) {
        break;
      }
    }
    Player.name = name;
  }

  // Use to first initialize character.
  public static Player initializeCharacterStats(String name, Scanner myObj,
      DelayedStringPrinter narrator) throws InterruptedException {
    List<String> array =
        new ArrayList<String>(Arrays.asList("Attack", "Defense", "Health", "Stamina"));
    List<Integer> builderInputs = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0));
    while (true) {
      int addStats = 15;
      for (int i = 0; i < array.size(); i++) {
        if (addStats == 0) {
          continue;
        }
        narrator.print("You have " + addStats
            + " free points left to assign. How many points do you want to assign to "
            + array.get(i) + "?");
        int value = myObj.nextInt();
        builderInputs.set(i, value);
        addStats -= value;
        if (addStats < 0) {
          narrator.print("You spent " + addStats * -1
              + " more points than you had to spend. Please try again.");
          break;
        }
      }

      if (addStats == 0) {
        Player player =
            new Player.Builder(name).attack(builderInputs.get(0)).defense(builderInputs.get(1))
                .health(builderInputs.get(2)).stamina(builderInputs.get(3)).build();
        return player;
      } else if (addStats > 0) {
        narrator.print("You still have " + addStats
            + " free points left to assign. Do you want to re-assign these points?");
      } else {
        Thread.sleep(1000);
      }
    }
  }

  // Use to set stats when leveling up.
  public void levelUpUpdateStats(Player player, Scanner myObj, DelayedStringPrinter narrator,
      int addStats) throws InterruptedException {
    List<String> array =
        new ArrayList<String>(Arrays.asList("Attack", "Defense", "Health", "Stamina"));
    List<Integer> builderInputs = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0));

    while (true) {
      for (int i = 0; i < array.size(); i++) {
        if (addStats == 0) {
          continue;
        }
        narrator.print("You have " + addStats
            + " free points left to assign. How many points do you want to assign to "
            + array.get(i) + "?");
        int value = myObj.nextInt();
        builderInputs.set(i, value);
        addStats -= value;
        if (addStats < 0) {
          narrator.print("You spent " + addStats * -1
              + " more points than you had to spend. Please try again.");
          break;
        }
      }

      if (addStats == 0) {
        player = new Player.Builder(name).attack(builderInputs.get(0)).defense(builderInputs.get(1))
            .health(builderInputs.get(2)).stamina(builderInputs.get(3)).build();

        break;
      } else if (addStats > 0) {
        narrator.print("You still have " + addStats
            + " free points left to assign. Do you want to re-assign these points?");
      } else {
        Thread.sleep(1000);
      }
    }
    narrator.print("Your stats are:");
    narrator.print(player.getStats());
    narrator.print("Is this to your liking?");
  }

  public static String getName() {
    return Player.name;
  }

  public static int getAttack() {
    return Player.attack;
  }

  public static int getDefense() {
    return Player.defense;
  }

  public static int getMaxHealth() {
    return Player.health;
  }

  public static int getMaxStamina() {
    return Player.stamina;
  }

  public String getStats() {
    return ("Attack: " + Player.attack + "\nDefense: " + Player.defense + "\nHealth: "
        + Player.health + "\nStamina: " + Player.stamina);
  }
  // public String toString() {
  // StringBuilder sb = new StringBuilder();
  // sb.append(title).append(" ").append(pages).append(" pages");
  // if (author != null) {
  // sb.append(" ").append(author);
  // }
  // if (year != 0) {
  // sb.append(" ").append(year);
  // } else {
  // sb.append("\nWe don't have the year of publication for this old book from the
  // mid-1800s");
  // }
  // return sb.toString();
  // }
}
