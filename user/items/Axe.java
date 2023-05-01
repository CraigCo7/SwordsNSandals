package user.items;

public class Axe extends Equipment {
    private int baseDamage = 20;
    private int minDamage;
    private int maxDamage;
    private int weight = 20;
    private double lvlUpMin = 1.2;
    private double lvlUpMax = 1.5;
    private String description = "AXE";

    public Axe(int level) {
        super(EquipmentType.WEAPON, "Axe", Rarity.COMMON, level);
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
