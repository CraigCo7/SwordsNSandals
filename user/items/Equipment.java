package user.items;

public class Equipment {
    private static int counter = 1;
    private int id;
    private EquipmentType type;
    private Rarity rarity;
    private int level;

    protected Equipment(EquipmentType type, Rarity rarity, int level) {
        this.id = counter;
        this.type = type;
        this.rarity = rarity;
        this.level = level;
        counter++;
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

    public int getId() {
        return this.id;
    }
}
