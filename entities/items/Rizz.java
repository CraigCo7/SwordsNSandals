package entities.items;

public class Rizz extends Weapon {

    private final int baseDamage = 35;
    private final double lvlUpMin = 0.0;
    private final double lvlUpMax = 2.0;

    public Rizz(int level) {
        this.id = increaseCounter();
        this.level = level;
        this.minDamage = instantiateMinDamage();
        this.maxDamage = instantiateMaxDamage();
        this.weight = 0;
        this.rarity = Rarity.LEGENDARY;
        this.description = "GOT RIZZ";
    }

    public int instantiateMinDamage() {
        return (int) Math.floor(baseDamage * this.getLevel() * lvlUpMin);
    }

    public int instantiateMaxDamage() {
        return (int) Math.floor(baseDamage * this.getLevel() * lvlUpMax);
    }

    @Override
    public String toString() {
        return "ID: " + this.id + "\t WEAPON: RIZZ" + "\tLEVEL: " + this.level + "\tMinDmg: "
                + this.minDamage + "\tMaxDmg: " + this.maxDamage + "\tWeight: " + this.weight;
    }

}
