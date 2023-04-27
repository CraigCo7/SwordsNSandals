package user.items;

public class Greaves extends Equipment {
    private int baseArmor = 4;
    private int armor;
    private String description = "GREAVES";

    public Greaves(int level) {
        super(EquipmentType.ARMOR, Rarity.COMMON, level);
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

