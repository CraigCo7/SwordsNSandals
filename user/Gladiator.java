package user;

import java.util.Random;
import user.items.Equipment;

public class Gladiator {
    private int attack;
    private int defense;
    private int health;
    private int stamina;
    private Equipped equipped = new Equipped(false);

    private class Equipped {

        private boolean player = false;
        private Equipment helmet;
        private Equipment chestplate;
        private Equipment bracers;
        private Equipment greaves;
        private Equipment weapon;
        private Equipment shield;

        public Equipped(boolean player) {
            this.player = player;
        }

        public void equipHelmet(Equipment helmet) {
            if (!this.player) {
                this.helmet = helmet;
            }
        }

        public void equipChestplate(Equipment chestplate) {
            if (!this.player) {
                this.chestplate = chestplate;
            }
        }

        public void equipBracers(Equipment bracers) {
            if (!this.player) {
                this.bracers = bracers;
            }
        }

        public void equipGreaves(Equipment greaves) {
            if (!this.player) {
                this.greaves = greaves;
            }
        }

        public void equipWeapon(Equipment weapon) {
            if (!this.player) {
                this.weapon = weapon;
            }
        }

        public void equipShield(Equipment shield) {
            if (!this.player) {
                this.shield = shield;
            }
        }

    }

    protected Gladiator(Builder builder) {
        this.attack = builder.attack;
        this.defense = builder.defense;
        this.health = builder.health;
        this.stamina = builder.stamina;
    }


    public static class Builder {

        private int attack;
        private int defense;
        private int health;
        private int stamina;

        public Builder(int attack, int defense, int health, int stamina) {
            this.attack = 1;
            this.defense = 1;
            this.health = 1;
            this.stamina = 1;
        }

        // Build function that returns a Book ob
        public Gladiator build() {
            return new Gladiator(this);
        }

    }

    public Gladiator createGladiator(int level) {
        Random rng = new Random();
        int baseStat = level * 10;
        int attack = rng.nextInt(25);
        int defense = rng.nextInt(25);
        int health = rng.nextInt(25);
        int stamina = rng.nextInt(25);
        Gladiator gladiator = new Gladiator.Builder(baseStat + attack, baseStat + defense,
                baseStat + health, baseStat + stamina).build();
        return gladiator;
    }


    public void attack() {

    }

    public void defend() {

    }

    public void rest() {

    }
}
