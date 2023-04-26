package user;

public class Gladiator {
    private int attack;
    private int defense;
    private int health;
    private int stamina;
    private Equipped equipped = new Equipped();

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



}
