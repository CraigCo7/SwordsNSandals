package entities.items;

import java.util.Random;
import entities.Player;
import utils.exceptions.NotEnoughExperienceException;

public abstract class Weapon extends Equipment {

    protected int minDamage;
    protected int maxDamage;
    protected int weight;

    public abstract int instantiateMinDamage();

    public abstract int instantiateMaxDamage();

    public static Equipment buyWeapon(Player player) throws NotEnoughExperienceException {
        // Cost Experience.
        if (player.getExperience() < 200) {
            throw new NotEnoughExperienceException();
        } else {
            Random random = new Random();
            int rarity = random.nextInt(10);
            int level = random.nextInt(7) + 1;

            // Common Weapon
            if (rarity < 7) {
                int weaponType = random.nextInt(3);
                if (weaponType == 0) {
                    player.addExperience(-200);
                    return new Sword(level);
                } else if (weaponType == 1) {
                    player.addExperience(-200);
                    return new Axe(level);
                } else {
                    player.addExperience(-200);
                    return new Spear(level);
                }
            } else if (rarity < 9) { // Rare Weapon
                int weaponType = random.nextInt(4);
                if (weaponType == 0) {
                    player.addExperience(-200);
                    return new Baguette(level);
                } else if (weaponType == 1) {
                    player.addExperience(-200);
                    return new Hydroflask(level);
                } else if (weaponType == 2) {
                    player.addExperience(-200);
                    return new DadBelt(level);
                } else {
                    player.addExperience(-200);
                    return new MomSlipper(level);
                }
            } else { // Legendary Weapon
                player.addExperience(-200);
                return new Rizz(level);
            }
        }

    }

    public int getWeight() {
        return this.weight;
    }

    public int getMinDamage() {
        return this.minDamage;
    }

    public int getMaxDamage() {
        return this.maxDamage;
    }

    public String getDescription() {
        return this.description;
    }

}
