package user;

import java.util.ArrayList;
import java.util.List;
import user.items.Equipment;
import utils.DelayedStringPrinter;
import utils.Input;

public class Player extends Gladiator {
    private static Player player;
    private static Storage storage;
    private String name;
    private int experience;
    private int level;


    private Player(String name, Gladiator.Builder builder) {
        super(builder);
        this.name = name;
        Player.storage = Storage.createStorage();
        this.level = 1;
        this.experience = 0;
    }

    // Used to create a new Player
    public static Player newPlayer(String name) {
        Gladiator.Builder builder = new Builder(10, 10, 10, 10);
        if (Player.player == null) {
            Player.player = new Player(name, builder);
        } else {
            System.out.println("Player already created");
        }
        return Player.player;
    }

    private static class Storage {
        private List<Equipment> items;

        private static Storage storage;

        private Storage() {
            this.items = new ArrayList<Equipment>();
        }

        public static Storage createStorage() {
            if (Storage.storage == null) {
                Storage.storage = new Storage();
            } else {
                System.out.println("Storage already created");
            }
            return Player.storage;
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
                System.out.println("Do not have item.");
            }
        }

    }

    public List<Integer> setInitialStats() {
        DelayedStringPrinter narrator = new DelayedStringPrinter(15);
        int addStats;
        List<String> attributes = new ArrayList<String>();
        while (true) {
            addStats = 50;
            List<Integer> stats = new ArrayList<Integer>();
            for (int i = 0; i < 4; i++) {

                narrator.print("You have " + addStats + " more points left to assign.");
                narrator.print("How many stats would you like to assign to Attack?");
                Input.newIntInput();
                stats.add(Input.getNumInput());
            }
        }
    }

    public String getName() {
        return this.name;
    }

    public int getExperience() {
        return this.experience;
    }

    public int getLevel() {
        return this.level;
    }

}
