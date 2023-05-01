package user.items;

public class MomSlipper extends Equipment {
    private int baseDamage = 12;
    private int minDamage;
    private int maxDamage;
    private int weight = 3;
    private double lvlUpMin = 1.0;
    private double lvlUpMax = 1.2;
    private String description = "MOMSLIPPER";

    public MomSlipper(int level) {
        super(EquipmentType.WEAPON, "MomSlipper", Rarity.RARE, level);
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
