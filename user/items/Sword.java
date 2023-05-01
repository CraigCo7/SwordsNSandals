package user.items;

public class Sword extends Equipment {
    private int baseDamage = 10;
    private int minDamage;
    private int maxDamage;
    private int weight = 8;
    private double lvlUpMin = 1.3;
    private double lvlUpMax = 1.6;
    private String description = "SWORD";

    public Sword(int level) {
        super(EquipmentType.WEAPON, "Sword", Rarity.COMMON, level);
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
