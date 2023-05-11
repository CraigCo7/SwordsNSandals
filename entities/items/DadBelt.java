package entities.items;

public class DadBelt extends Weapon {

    private final int baseDamage = 18;
    private final double lvlUpMin = 1.1;
    private final double lvlUpMax = 1.2;

    public DadBelt(int level) {
        this.id = increaseCounter();
        this.level = level;
        this.minDamage = instantiateMinDamage();
        this.maxDamage = instantiateMaxDamage();
        this.weight = 5;
        this.rarity = Rarity.RARE;
        this.description = "DADS BELT";
    }

    public int instantiateMinDamage() {
        return (int) Math.floor(baseDamage * this.getLevel() * lvlUpMin);
    }

    public int instantiateMaxDamage() {
        return (int) Math.floor(baseDamage * this.getLevel() * lvlUpMax);
    }

    @Override
    public String toString() {
        return "ID: " + this.id + "\t WEAPON: DADBELT" + "\tLEVEL: " + this.level + "\tMinDmg: "
                + this.minDamage + "\tMaxDmg: " + this.maxDamage + "\tWeight: " + this.weight;
    }

}
