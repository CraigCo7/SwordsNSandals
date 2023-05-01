package user.items;

public class Helmet extends Equipment {
    private int baseArmor = 4;
    private int armor;
    private String description = "HELMET";

    public Helmet(int level) {
        super(EquipmentType.ARMOR, EquipmentName.HELMET, Rarity.COMMON, level);
        this.armor = calculateArmor();
    }

    private int calculateArmor() {
        return baseArmor * this.getLevel();
    }

    public int getArmor() {
        return this.armor;
    }

    public String getDescription() {
        return this.description;
    }
}

