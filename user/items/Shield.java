package user.items;

public class Shield extends Equipment {
    private int baseArmor = 10;
    private int armor;
    private String description = "BRACERS";

    public Shield(int level) {
        super(EquipmentType.ARMOR, "Shield", Rarity.COMMON, level);
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

