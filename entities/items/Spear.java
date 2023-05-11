package entities.items;

public class Spear extends Weapon {

    private final int baseDamage = 12;
    private final double lvlUpMin = 1.4;
    private final double lvlUpMax = 1.7;

    public Spear(int level) {
        this.id = increaseCounter();
        this.level = level;
        this.minDamage = instantiateMinDamage();
        this.maxDamage = instantiateMaxDamage();
        this.weight = 15;
        this.rarity = Rarity.COMMON;
        this.description = "SPEAR";
    }

    public int instantiateMinDamage() {
        return (int) Math.floor(baseDamage * this.getLevel() * lvlUpMin);
    }

    public int instantiateMaxDamage() {
        return (int) Math.floor(baseDamage * this.getLevel() * lvlUpMax);
    }

    @Override
    public String toString() {
        return "ID: " + this.id + "\t WEAPON: SPEAR" + "\tLEVEL: " + this.level + "\tMinDmg: "
                + this.minDamage + "\tMaxDmg: " + this.maxDamage + "\tWeight: " + this.weight;
    }

}
