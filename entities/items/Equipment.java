package entities.items;

import java.util.Random;
import entities.Player;
import utils.exceptions.NotEnoughExperienceException;

public class Equipment {
    private static int counter = 1;
    protected int id;
    protected EquipmentType type;
    protected Rarity rarity;
    protected int level;
    protected EquipmentName name;

    protected Equipment(EquipmentType type, EquipmentName name, int level) {
        this.id = counter;
        this.type = type;
        this.level = level;
        this.name = name;
        counter++;
    }

    public EquipmentType getEquipmentType() {
        return this.type;
    }

    public Rarity getEquipmentRarity() {
        return this.rarity;
    }

    public int getLevel() {
        return this.level;
    }

    public int getId() {
        return this.id;
    }

    public EquipmentName getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "ID: " + this.id + "\tName: " + this.name + "\tRarity: " + this.rarity + "\tLevel: "
                + this.level;
    }

    public static Equipment buyWeapon(Player player) throws NotEnoughExperienceException {
        // Cost Experience.
        if (player.getExperience() < 0) {
            throw new NotEnoughExperienceException();
        } else {
            Random random = new Random();
            int rarity = random.nextInt(10);
            int level = random.nextInt(7) + 1;

            // Common Weapon
            if (rarity < 7) {
                int weaponType = random.nextInt(3);
                if (weaponType == 0) {
                    return new Weapon(EquipmentName.SWORD, level);
                } else if (weaponType == 1) {
                    return new Weapon(EquipmentName.AXE, level);
                } else {
                    return new Weapon(EquipmentName.SPEAR, level);
                }
            } else if (rarity < 9) { // Rare Weapon
                int weaponType = random.nextInt(4);
                if (weaponType == 0) {
                    return new Weapon(EquipmentName.BAGUETTE, level);
                } else if (weaponType == 1) {
                    return new Weapon(EquipmentName.HYDROFLASK, level);
                } else if (weaponType == 2) {
                    return new Weapon(EquipmentName.DADBELT, level);
                } else {
                    return new Weapon(EquipmentName.MOMSLIPPER, level);
                }
            } else { // Legendary Weapon
                return new Weapon(EquipmentName.RIZZ, level);
            }
        }
    }

    public static Equipment buyArmor(Player player) throws NotEnoughExperienceException {
        // Cost Experience.
        if (player.getExperience() < 200) {
            throw new NotEnoughExperienceException();
        } else {
            Random random = new Random();
            int armorType = random.nextInt(5);
            int level = random.nextInt(7) + 1;

            if (armorType == 0) {
                return new Armor(EquipmentName.HELMET, level);
            } else if (armorType == 1) {
                return new Armor(EquipmentName.CHESTPLATE, level);
            } else if (armorType == 2) {
                return new Armor(EquipmentName.BRACERS, level);
            } else if (armorType == 3) {
                return new Armor(EquipmentName.GREAVES, level);
            } else {
                return new Armor(EquipmentName.SHIELD, level);
            }
        }
    }
}
