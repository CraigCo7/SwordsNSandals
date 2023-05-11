package entities.items;

public class MomSlipper extends Weapon {

    private final int baseDamage = 12;
    private final double lvlUpMin = 1.0;
    private final double lvlUpMax = 1.2;

    public MomSlipper(int level) {
        this.id = increaseCounter();
        this.level = level;
        this.minDamage = instantiateMinDamage();
        this.maxDamage = instantiateMaxDamage();
        this.weight = 3;
        this.rarity = Rarity.RARE;
        this.description = "MOMS SLIPPER";
    }

    public int instantiateMinDamage() {
        return (int) Math.floor(baseDamage * this.getLevel() * lvlUpMin);
    }

    public int instantiateMaxDamage() {
        return (int) Math.floor(baseDamage * this.getLevel() * lvlUpMax);
    }

    @Override
    public String toString() {
        return "ID: " + this.id + "\t WEAPON: MOMSLIPPER" + "\tLEVEL: " + this.level + "\tMinDmg: "
                + this.minDamage + "\tMaxDmg: " + this.maxDamage + "\tWeight: " + this.weight;
    }

}
