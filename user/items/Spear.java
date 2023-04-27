package user.items;

public class Spear extends Equipment {
    private int baseDamage = 12;
    private int minDamage;
    private int maxDamage;
    private int weight = 15;
    private double lvlUpMin = 1.4;
    private double lvlUpMax = 1.7;
    private String description;

    public Spear(int level) {
        super(EquipmentType.WEAPON, Rarity.COMMON, level);
        this.description = "SPEAR";
        this.minDamage = calculateMinDamage();
        this.maxDamage = calculateMaxDamage();
    }

    private int calculateMinDamage() {
        return (int) Math.floor(baseDamage * this.getLevel() * lvlUpMin);
    }

    private int calculateMaxDamage() {
        return (int) Math.floor(baseDamage * this.getLevel() * lvlUpMax);
    }
}
