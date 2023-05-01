package user.items;

public class Spear extends Equipment {
    private int baseDamage = 12;
    private int minDamage;
    private int maxDamage;
    private int weight = 15;
    private double lvlUpMin = 1.4;
    private double lvlUpMax = 1.7;
    private String description = "SPEAR";

    public Spear(int level) {
        super(EquipmentType.WEAPON, EquipmentName.SPEAR, Rarity.COMMON, level);
        this.minDamage = calculateMinDamage();
        this.maxDamage = calculateMaxDamage();
    }

    private int calculateMinDamage() {
        return (int) Math.floor(baseDamage * this.getLevel() * lvlUpMin);
    }

    private int calculateMaxDamage() {
        return (int) Math.floor(baseDamage * this.getLevel() * lvlUpMax);
    }

    public String getDescription() {
        return this.description;
    }
}
