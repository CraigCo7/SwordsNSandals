package entities.items;

import java.util.Random;
import entities.Player;
import utils.exceptions.NotEnoughExperienceException;

public class Equipment {
    private static int counter = 0;
    protected int id;
    protected Rarity rarity;
    protected int level;
    protected String description;
    protected ArmorType armorType;

    public Rarity getEquipmentRarity() {
        return this.rarity;
    }

    public int increaseCounter() {
        return counter += 1;
    }

    public int getLevel() {
        return this.level;
    }

    public int getId() {
        return this.id;
    }

    public ArmorType getArmorType() {
        return this.armorType;
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
                player.addExperience(-200);
                return new Armor(ArmorType.HELMET, level);
            } else if (armorType == 1) {
                player.addExperience(-200);
                return new Armor(ArmorType.CHESTPLATE, level);
            } else if (armorType == 2) {
                player.addExperience(-200);
                return new Armor(ArmorType.BRACERS, level);
            } else if (armorType == 3) {
                player.addExperience(-200);
                return new Armor(ArmorType.GREAVES, level);
            } else {
                player.addExperience(-200);
                return new Armor(ArmorType.SHIELD, level);
            }
        }
    }
}
