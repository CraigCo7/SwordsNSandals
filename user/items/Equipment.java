package user.items;

public abstract class Equipment {
    private EquipmentType type;
    private Rarity rarity;
    private int level;

    protected Equipment(EquipmentType type, Rarity rarity, int level) {
        this.type = type;
        this.rarity = rarity;
        this.level = level;
    }

    public EquipmentType getEquipmentType() {
        return this.type;
    }

    public Rarity getEquipmentRarity() {
        return this.rarity;
    }

    public int getLevel() {
        return this.level;
    }
}
