package user.items;

import java.util.Random;
import user.Player;
import utils.exceptions.NotEnoughExperienceException;

public class Equipment {
    private static int counter = 1;
    private int id;
    private EquipmentType type;
    private Rarity rarity;
    private int level;
    private EquipmentName name;

    protected Equipment(EquipmentType type, EquipmentName name, Rarity rarity, int level) {
        this.id = counter;
        this.type = type;
        this.rarity = rarity;
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
                    return new Sword(level);
                } else if (weaponType == 1) {
                    return new Axe(level);
                } else {
                    return new Spear(level);
                }
            } else if (rarity < 9) { // Rare Weapon
                int weaponType = random.nextInt(4);
                if (weaponType == 0) {
                    return new Baguette(level);
                } else if (weaponType == 1) {
                    return new Hydroflask(level);
                } else if (weaponType == 2) {
                    return new DadBelt(level);
                } else {
                    return new MomSlipper(level);
                }
            } else { // Legendary Weapon
                return new Rizz(level);
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
                return new Helmet(level);
            } else if (armorType == 1) {
                return new Chestplate(level);
            } else if (armorType == 2) {
                return new Bracers(level);
            } else if (armorType == 3) {
                return new Greaves(level);
            } else {
                return new Shield(level);
            }
        }
    }
}
