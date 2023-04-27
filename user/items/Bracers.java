package user.items;

public class Bracers extends Equipment {
    private int baseArmor = 6;
    private int armor;
    private String description = "BRACERS";

    public Bracers(int level) {
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

