package entities.items;

public class Hydroflask extends Weapon {

    private final int baseDamage = 25;
    private final double lvlUpMin = 1.2;
    private final double lvlUpMax = 1.5;

    public Hydroflask(int level) {
        this.id = increaseCounter();
        this.level = level;
        this.minDamage = instantiateMinDamage();
        this.maxDamage = instantiateMaxDamage();
        this.weight = 30;
        this.rarity = Rarity.RARE;
        this.description = "HYDROFLASK";
    }

    public int instantiateMinDamage() {
        return (int) Math.floor(baseDamage * this.getLevel() * lvlUpMin);
    }

    public int instantiateMaxDamage() {
        return (int) Math.floor(baseDamage * this.getLevel() * lvlUpMax);
    }

    @Override
    public String toString() {
        return "ID: " + this.id + "\t WEAPON: HYDROFLASK" + "\tLEVEL: " + this.level + "\tMinDmg: "
                + this.minDamage + "\tMaxDmg: " + this.maxDamage + "\tWeight: " + this.weight;
    }

}
