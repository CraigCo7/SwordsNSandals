package user.items;

public class Rizz extends Equipment {
    private int baseDamage = 35;
    private int minDamage;
    private int maxDamage;
    private int weight = 0;
    private double lvlUpMin = 0;
    private double lvlUpMax = 2.0;
    private String description;

    public Rizz(int level) {
        super(EquipmentType.WEAPON, Rarity.LEGENDARY, level);
        this.description = "RIZZ";
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
