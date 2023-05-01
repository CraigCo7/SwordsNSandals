package user.items;

public class Hydroflask extends Equipment {
    private int baseDamage = 25;
    private int minDamage;
    private int maxDamage;
    private int weight = 30;
    private double lvlUpMin = 1.2;
    private double lvlUpMax = 1.5;
    private String description = "HYDROFLASK";

    public Hydroflask(int level) {
        super(EquipmentType.WEAPON, "Hydroflask", Rarity.RARE, level);
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
