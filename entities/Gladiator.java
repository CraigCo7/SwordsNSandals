package entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import entities.items.Armor;
import entities.items.Axe;
import entities.items.Equipment;
import entities.items.ArmorType;
import entities.items.Spear;
import entities.items.Sword;
import entities.items.Weapon;

public class Gladiator {
    protected String name;
    private int attack;
    private int baseDefense;
    private int maxHealth;
    private int maxStamina;

    // Stats below used for battle stats
    private int health;
    private int stamina;
    private int defense;
    private int armor;
    protected int level;

    protected Equipped equipped = new Equipped(this);

    public class Equipped {

        private Gladiator gladiator;
        private Armor helmet;
        private Armor chestplate;
        private Armor bracers;
        private Armor greaves;
        private Armor shield;
        private Weapon weapon;

        public Equipped(Gladiator gladiator) {
            this.gladiator = gladiator;
        }

        public void equipItem(Equipment equipment) {

            if (this.gladiator.getLevel() < equipment.getLevel()) {
                System.out.println("You are too low a level to equip this item!");
                return;
            }
            if (equipment.getArmorType() == (ArmorType.HELMET)) {
                this.helmet = (Armor) equipment;
                if (this.gladiator.getName() != null) {
                    System.out.println(
                            this.gladiator.getName() + " equipped: " + this.helmet.toString());
                }
            } else if (equipment.getArmorType() == (ArmorType.CHESTPLATE)) {
                this.chestplate = (Armor) equipment;
                if (this.gladiator.getName() != null) {
                    System.out.println(
                            this.gladiator.getName() + " equipped: " + this.chestplate.toString());
                }
            } else if (equipment.getArmorType() == (ArmorType.BRACERS)) {
                this.bracers = (Armor) equipment;
                if (this.gladiator.getName() != null) {
                    System.out.println(
                            this.gladiator.getName() + " equipped: " + this.bracers.toString());
                }
            } else if (equipment.getArmorType() == (ArmorType.GREAVES)) {
                this.greaves = (Armor) equipment;
                if (this.gladiator.getName() != null) {
                    System.out.println(
                            this.gladiator.getName() + " equipped: " + this.greaves.toString());
                }

            } else if (equipment.getArmorType() == (ArmorType.SHIELD)) {
                this.shield = (Armor) equipment;
                if (this.gladiator.getName() != null) {
                    System.out.println(
                            this.gladiator.getName() + " equipped: " + this.shield.toString());
                }

            } else {
                this.weapon = (Weapon) equipment;
                if (this.gladiator.getName() != null) {
                    System.out.println(
                            this.gladiator.getName() + " equipped: " + this.weapon.toString());
                }

            }
        }

        public int getTotalArmor() {
            int armor = 0;
            if (this.helmet != null) {
                armor += this.helmet.getArmor();
            } else if (this.chestplate != null) {
                armor += this.chestplate.getArmor();
            } else if (this.bracers != null) {
                armor += this.bracers.getArmor();
            } else if (this.greaves != null) {
                armor += this.greaves.getArmor();
            } else if (this.shield != null) {
                armor += this.shield.getArmor();
            }
            return armor;
        }

        public Weapon getWeapon() {
            return this.weapon;
        }
    }

    protected Gladiator(Builder builder) {
        this.attack = builder.attack;
        this.baseDefense = builder.baseDefense;
        this.maxHealth = builder.maxHealth;
        this.maxStamina = builder.maxStamina;
    }


    public static class Builder {

        private int attack;
        private int baseDefense;
        private int maxHealth;
        private int maxStamina;

        public Builder(int attack, int baseDefense, int maxHealth, int maxStamina) {
            this.attack = attack;
            this.baseDefense = baseDefense;
            this.maxHealth = maxHealth;
            this.maxStamina = maxStamina;
        }

        // Build function that returns a Book object
        public Gladiator build() {
            return new Gladiator(this);
        }

    }

    // Creates gladiator.
    public static Gladiator createGladiator(int level) {
        Random rng = new Random();
        int baseStat = level * 10;
        int attack = rng.nextInt(25);
        int baseDefense = rng.nextInt(25);
        int maxHealth = rng.nextInt(25);
        int maxStamina = rng.nextInt(25);
        Gladiator gladiator = new Gladiator.Builder(baseStat + attack, baseStat + baseDefense,
                baseStat + maxHealth + 100, baseStat + maxStamina + 50).build();

        gladiator.setLevel(level);

        Equipped equipped = gladiator.getEquipped();
        int weapon = rng.nextInt(3);
        if (weapon == 0) {
            equipped.equipItem(new Sword(level));
        } else if (weapon == 1) {
            equipped.equipItem(new Axe(level));
        } else {
            equipped.equipItem(new Spear(level));
        }

        List<ArmorType> armor = new ArrayList<ArmorType>(Arrays.asList(ArmorType.HELMET,
                ArmorType.CHESTPLATE, ArmorType.BRACERS, ArmorType.GREAVES, ArmorType.SHIELD));

        for (int i = 0; i < 5; i++) {
            int giveArmor = rng.nextInt(2);
            if (giveArmor == 1) {
                equipped.equipItem(new Armor(armor.get(i), level));
            }

        }
        return gladiator;
    }

    // Basic attack
    public void attack(Gladiator opponent) {
        if (this.health <= 0 || opponent.health <= 0) {
            return;
        }

        Random rand = new Random();

        Equipped playerEquipped = this.getEquipped();
        Weapon weapon = playerEquipped.getWeapon();

        if (this.stamina < equipped.weapon.getWeight()) {
            System.out.println("Not enough stamina! You failed to move...");
            return;
        }

        int netDamage;
        int dmg =
                rand.nextInt(weapon.getMinDamage(), weapon.getMaxDamage()) - opponent.getDefense();
        if (dmg < 0) {
            dmg = 0;
        }
        netDamage = this.attack + dmg;

        if (opponent.armor > 0) {
            opponent.armor -= netDamage;
        } else {
            opponent.health -= netDamage;
        }
        System.out.println(this.name + " attacked for " + netDamage + "hp.\n");

        this.stamina -= weapon.getWeight();

    }

    // Halfs attack, doubles baseDefense until end of turn. Costs less energy.
    public void defend(Gladiator opponent) {
        if (this.health <= 0 || opponent.health <= 0) {
            return;
        }

        Random rand = new Random();

        Equipped playerEquipped = this.getEquipped();
        Weapon weapon = playerEquipped.getWeapon();

        if (this.stamina < (int) equipped.weapon.getWeight() / 2) {
            System.out.println("Not enough stamina! You failed to move...");
            return;
        }

        int netDamage;
        int dmg =
                rand.nextInt(weapon.getMinDamage(), weapon.getMaxDamage()) - opponent.getDefense();
        if (dmg < 0) {
            dmg = 0;
        }
        netDamage = (int) (this.attack + dmg) / 2;
        opponent.health -= netDamage;

        if (opponent.armor > 0) {
            opponent.armor -= netDamage;
        } else {
            opponent.health -= netDamage;
        }

        System.out.println(this.name + " attacked for " + netDamage + "hp.");
        System.out.println(this.name + " defense increased from " + this.defense + " to "
                + this.defense * 2 + ".\n");

        this.stamina -= (int) weapon.getWeight() / 2;
        this.defense *= 2;
    }

    // Recovers a 1/5 of the max stamina.
    public void rest(Gladiator opponent) {
        if (this.health <= 0 || opponent.health <= 0) {
            return;
        }

        int recover = (int) this.getMaxStamina() / 5;
        this.stamina += recover;
        System.out.println(this.name + " took a power nap mid battle.");
        System.out.println(this.name + " recovered " + recover + " stamina.\n");
    }


    public void resetHealth() {
        this.health = this.maxHealth;
    }

    public void resetStamina() {
        this.stamina = this.maxStamina;
    }

    public void resetArmor() {
        Equipped equipped = this.getEquipped();
        this.armor = equipped.getTotalArmor();
    }

    public void resetDefense() {
        this.defense = baseDefense;
    }

    public void addAttack(int attack) {
        this.attack += attack;
    }

    public void addDefense(int baseDefense) {
        this.baseDefense += baseDefense;
    }

    public void addMaxHealth(int maxHealth) {
        this.maxHealth += maxHealth;
    }

    public void addMaxStamina(int maxStamina) {
        this.maxHealth += maxStamina;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getAttack() {
        return this.attack;
    }

    public int getDefense() {
        return this.baseDefense;
    }

    public int getMaxHealth() {
        return this.maxHealth;
    }

    public int getMaxStamina() {
        return this.maxStamina;
    }

    public int getHealth() {
        return this.health;
    }

    public int getStamina() {
        return this.stamina;
    }

    public int getLevel() {
        return this.level;
    }

    public int getArmor() {
        return this.armor;
    }

    public void addStamina() {
        this.stamina += 10;
    }

    public Equipped getEquipped() {
        return this.equipped;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String getStats() {
        return "Attack: " + this.getAttack() + "\nDefense: " + this.getDefense() + "\nHealth: "
                + this.getMaxHealth() + "\nStamina: " + this.getMaxStamina();
    }
}
