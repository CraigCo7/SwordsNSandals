package user.items;

public class DadBelt extends Equipment {
    private int baseDamage = 18;
    private int minDamage;
    private int maxDamage;
    private int weight = 5;
    private double lvlUpMin = 1.1;
    private double lvlUpMax = 1.2;
    private String description = "DADBELT";

    public DadBelt(int level) {
        super(EquipmentType.WEAPON, Rarity.RARE, level);
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
