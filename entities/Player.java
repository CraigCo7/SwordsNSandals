package entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import entities.items.Equipment;
import utils.DelayedStringPrinter;
import utils.Input;
import utils.exceptions.UnknownItemException;

public class Player extends Gladiator {
    private static Player player;
    private static Storage storage;
    private int experience;

    private Player(String name, Gladiator.Builder builder) {
        super(builder);
        Player.storage = Storage.createStorage();
        this.name = name;
        this.level = 1;
        this.experience = 0;
    }

    // Used to create a new Player
    public static Player newPlayer(String name) {
        Gladiator.Builder builder = new Builder(10, 10, 100, 50);
        if (Player.player == null) {
            Player.player = new Player(name, builder);
        } else {
            System.out.println("Player already created");
        }
        return Player.player;
    }

    public static class Storage {
        private List<Equipment> items;

        private static Storage storage;

        private Storage() {
            this.items = new ArrayList<Equipment>(91);
        }

        public static Storage createStorage() {
            if (Storage.storage == null) {
                Storage.storage = new Storage();
            } else {
                System.out.println("Storage already created");
            }
            return Storage.storage;
        }

        public void removeItem(Equipment equipment) {
            if (items.contains(equipment)) {
                items.remove(equipment);
            } else {
                System.out.println("Item cannot be found");
            }
        }

        public void addItem(Equipment equipment) {
            if (items.contains(equipment)) {
                System.out.println("Cannot have 2 of the same item.");
            } else {
                items.add(equipment);
            }
        }

        public void viewStorage() {
            this.items.forEach((item) -> {
                System.out.println(item.toString());
            });
        }

    }

    public List<Integer> promptAddStats(int availableStats) {
        DelayedStringPrinter narrator = new DelayedStringPrinter(15);
        List<String> attributes =
                new ArrayList<String>(Arrays.asList("Attack", "Defense", "Health", "Stamina"));
        List<Integer> stats = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0));
        int addStats = availableStats;
        while (true) {
            for (int i = 0; i < 4; i++) {
                narrator.print("You have " + addStats + " more points left to assign.");
                narrator.print(
                        "How many stats would you like to assign to " + attributes.get(i) + "?");
                Input.newIntInput();
                stats.set(i, stats.get(i) + Input.getNumInput());
                addStats -= Input.getNumInput();
                if (addStats == 0) {
                    return stats;
                } else if (addStats < 0) {
                    System.out.println("Assigned too many stats! Please try again.");
                    stats.forEach((num) -> {
                        int doubled = num * 0;
                        stats.set(stats.indexOf(num), doubled);
                    });
                    break;
                }
            }
            if (addStats < 0) {
                addStats = availableStats;
                continue;
            }
            while (true) {
                narrator.print("You still have " + addStats
                        + " stats left to assign. These will be lost. Do you want to add these leftover stats? (Yes/No)");
                Input.newStringInput();
                if (Input.validEntryYesNo() == true) {
                    break;
                } else {
                    return stats;
                }
            }
        }
    }

    public void addStats(List<Integer> stats) {
        this.addAttack(stats.get(0));
        this.addDefense(stats.get(1));
        this.addMaxHealth(stats.get(2));
        this.addMaxStamina(stats.get(3));
    }

    public void addExperience(int experience) {
        this.experience += experience;
    }

    public void levelUp() {
        if (this.level == 7) {
            System.out.println("Already at max level!");
            System.out.println("Reach 1000XP to earn your freedom.");
            return;
        }
        this.level += 1;
        this.experience -= 500;
    }

    public int getExperience() {
        return this.experience;
    }

    public String viewProjectedStats(int attack, int defense, int health, int stamina) {
        return "Attack: " + (this.getAttack() + attack) + "\nDefense: "
                + (this.getDefense() + defense) + "\nHealth: " + (this.getMaxHealth() + health)
                + "\nStamina: " + (this.getMaxStamina() + stamina);
    }

    public static Storage getStorage() {
        return Player.storage;
    }

    public void equipItemById(int id) throws UnknownItemException {
        Storage storage = getStorage();
        Equipped equipped = getEquipped();
        List<Integer> itemIds = new ArrayList<Integer>();
        storage.items.forEach((item) -> {
            if (item.getId() == id) {
                equipped.equipItem(item);
            }
            itemIds.add(item.getId());
        });
        if (!itemIds.contains(id)) {
            throw new UnknownItemException();
        }
    }
}
