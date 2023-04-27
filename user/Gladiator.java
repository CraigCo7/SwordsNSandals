package user;

import java.util.Random;

public class Gladiator {
    private int attack;
    private int defense;
    private int health;
    private int stamina;
    private Equipped equipped = new Equipped(false);

    private class Equipped {

        private boolean player = false;
        private Helmet helmet;
        private Chestplate chestplate;
        private Bracers bracers;
        private Greaves greaves;
        private Weapon weapon;
        private Shield shield;

        public Equipped(boolean player) {
            this.player = player;
        }

        public void equipHelmet(Helmet helmet) {
            if (!this.player) {
                this.helmet = helmet;
            }
        }

        public void equipChestplate(Chestplate chestplate) {
            if (!this.player) {
                this.chestplate = chestplate;
            }
        }

        public void equipBracers(Bracers bracers) {
            if (!this.player) {
                this.bracers = bracers;
            }
        }

        public void equipGreaves(Greaves greaves) {
            if (!this.player) {
                this.greaves = greaves;
            }
        }

        public void equipWeapon(Weapon weapon) {
            if (!this.player) {
                this.weapon = weapon;
            }
        }

        public void equipShield(Shield shield) {
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
