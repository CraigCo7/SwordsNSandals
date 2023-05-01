package user.items;

public class Chestplate extends Equipment {
    private int baseArmor = 16;
    private int armor;
    private String description = "CHESTPLATE";

    public Chestplate(int level) {
        super(EquipmentType.ARMOR, EquipmentName.CHESTPLATE, Rarity.COMMON, level);
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

